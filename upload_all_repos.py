import os
import sys
import json
import getpass
import subprocess
import urllib.request
import urllib.error

repo_name = "CS306-Practical-Solutions"
repo_description = "Complete solutions for CS-306 Core Java and Web Technology-I practical question bank"

token = None
if len(sys.argv) > 1 and sys.argv[1].strip():
    token = sys.argv[1].strip()
elif "GITHUB_TOKEN" in os.environ and os.environ["GITHUB_TOKEN"].strip():
    token = os.environ["GITHUB_TOKEN"].strip()
else:
    try:
        token = getpass.getpass("Enter your GitHub Personal Access Token: ").strip()
    except Exception:
        pass

if not token:
    print("Error: No GitHub token provided.")
    print("Usage: python3 upload_all_repos.py <GITHUB_TOKEN>")
    print("   or: export GITHUB_TOKEN=\"your_token\"")
    sys.exit(1)

def make_request(url, method="GET", data=None):
    headers = {
        "Authorization": f"Bearer {token}",
        "Accept": "application/vnd.github.v3+json",
        "User-Agent": "CS306-Uploader"
    }
    req_data = None
    if data is not None:
        req_data = json.dumps(data).encode("utf-8")
        headers["Content-Type"] = "application/json"
    req = urllib.request.Request(url, data=req_data, headers=headers, method=method)
    return urllib.request.urlopen(req)

try:
    with make_request("https://api.github.com/user") as resp:
        user_info = json.loads(resp.read().decode("utf-8"))
        username = user_info["login"]
except Exception as e:
    print("Authentication failed. Please verify your GitHub Personal Access Token.")
    sys.exit(1)

repo_exists = False
try:
    with make_request(f"https://api.github.com/repos/{username}/{repo_name}") as resp:
        if resp.status == 200:
            repo_exists = True
except urllib.error.HTTPError as e:
    if e.code == 404:
        repo_exists = False
    else:
        print(f"Error checking repository: {e.code}")
        sys.exit(1)

if not repo_exists:
    payload = {
        "name": repo_name,
        "description": repo_description,
        "private": False,
        "auto_init": False
    }
    try:
        with make_request("https://api.github.com/user/repos", method="POST", data=payload) as resp:
            print(f"Created repository {username}/{repo_name} on GitHub.")
    except urllib.error.HTTPError as e:
        print(f"Failed to create repository: {e.read().decode('utf-8')}")
        sys.exit(1)
else:
    print(f"Repository {username}/{repo_name} already exists on GitHub.")

base_dir = os.path.dirname(os.path.abspath(__file__))

def run_git(args, cwd=base_dir, check=True):
    return subprocess.run(["git"] + args, cwd=cwd, capture_output=True, text=True, check=check)

try:
    run_git(["init"])
    config_name = subprocess.run(["git", "config", "user.name"], cwd=base_dir, capture_output=True, text=True)
    if not config_name.stdout.strip():
        run_git(["config", "user.name", username])
    config_email = subprocess.run(["git", "config", "user.email"], cwd=base_dir, capture_output=True, text=True)
    if not config_email.stdout.strip():
        run_git(["config", "user.email", f"{username}@users.noreply.github.com"])

    run_git(["add", "."])
    status_res = run_git(["status", "--porcelain"], check=False)
    if status_res.stdout.strip():
        run_git(["commit", "-m", "Initial commit: CS-306 Practical Solutions"])

    run_git(["branch", "-M", "main"])

    remote_res = run_git(["remote", "get-url", "origin"], check=False)
    authed_remote = f"https://{token}@github.com/{username}/{repo_name}.git"
    clean_remote = f"https://github.com/{username}/{repo_name}.git"

    if remote_res.returncode == 0:
        run_git(["remote", "set-url", "origin", authed_remote])
    else:
        run_git(["remote", "add", "origin", authed_remote])

    print("Pushing repository to GitHub...")
    push_res = run_git(["push", "-u", "origin", "main", "--force"])
    print("Successfully pushed to GitHub!")

    run_git(["remote", "set-url", "origin", clean_remote])

    print(f"Repository URL: {clean_remote}")
except subprocess.CalledProcessError as e:
    run_git(["remote", "set-url", "origin", clean_remote], check=False)
    print("Git operation failed.")
    if e.stderr:
        print(e.stderr.strip())
    sys.exit(1)
