import os
import sys

base_dir = os.path.dirname(os.path.abspath(__file__))
java_dir = os.path.join(base_dir, "java")
js_dir = os.path.join(base_dir, "javascript")
node_dir = os.path.join(base_dir, "node")

expected_java = [
    "account-inheritance", "armstrong-range", "array-sum-sort",
    "attendance-exception", "calculator-interface", "clock",
    "college-department", "cylinder", "driver-exception",
    "employee-max-salary", "file-count", "file-reverse-case",
    "file-uppercase", "game-package", "matrix-menu",
    "multilevel-inheritance", "mydate-exception", "mynumber",
    "person-this", "prime-exception", "product-object-count",
    "shape-overriding", "string-package", "vehicle-inheritance"
]

expected_js = [
    "array-swap", "arrow-calculator", "change-heading",
    "dom-image", "flexbox-homepage", "hover-button-link",
    "image-gallery", "js-module", "list-pseudo-class",
    "marks-average", "object-destructuring", "product-bill",
    "registration-form", "rest-sum", "spread-array",
    "student-registration", "student-template"
]

expected_node = [
    "async-login", "directory-management", "file-management",
    "fs-async", "fs-create-delete", "fs-create-read",
    "fs-create-write-read-append", "fs-read-append", "fs-read-delete",
    "http-server", "promise-division"
]

slip_mapping = {
    1: ("java", "array-sum-sort", "javascript", "registration-form"),
    2: ("java", "armstrong-range", "javascript", "student-registration"),
    3: ("java", "string-package", "javascript", "flexbox-homepage"),
    4: ("java", "matrix-menu", "javascript", "change-heading"),
    5: ("java", "file-reverse-case", "javascript", "image-gallery"),
    6: ("java", "account-inheritance", "javascript", "hover-button-link"),
    7: ("java", "driver-exception", "javascript", "list-pseudo-class"),
    8: ("java", "shape-overriding", "javascript", "dom-image"),
    9: ("java", "employee-max-salary", "javascript", "arrow-calculator"),
    10: ("java", "file-uppercase", "javascript", "student-template"),
    11: ("java", "vehicle-inheritance", "javascript", "marks-average"),
    12: ("java", "game-package", "javascript", "product-bill"),
    13: ("java", "clock", "javascript", "array-swap"),
    14: ("java", "array-sum-sort", "javascript", "object-destructuring"),
    15: ("java", "multilevel-inheritance", "javascript", "spread-array"),
    16: ("java", "cylinder", "javascript", "rest-sum"),
    17: ("java", "calculator-interface", "javascript", "js-module"),
    18: ("java", "mynumber", "node", "http-server"),
    19: ("java", "file-count", "node", "async-login"),
    20: ("java", "college-department", "node", "promise-division"),
    21: ("java", "college-department", "node", "http-server"),
    22: ("java", "product-object-count", "node", "fs-async"),
    23: ("java", "multilevel-inheritance", "node", "fs-create-write-read-append"),
    24: ("java", "cylinder", "javascript", "array-swap"),
    25: ("java", "calculator-interface", "node", "directory-management"),
    26: ("java", "attendance-exception", "node", "fs-create-delete"),
    27: ("java", "person-this", "node", "fs-create-read"),
    28: ("java", "mydate-exception", "node", "fs-read-append"),
    29: ("java", "prime-exception", "node", "fs-read-delete"),
    30: ("java", "mynumber", "node", "file-management")
}

errors = []
total_folders = 0
total_source_files = 0

if not os.path.isdir(java_dir):
    errors.append("Directory java/ does not exist.")
if not os.path.isdir(js_dir):
    errors.append("Directory javascript/ does not exist.")
if not os.path.isdir(node_dir):
    errors.append("Directory node/ does not exist.")

category_map = {
    "java": (java_dir, expected_java),
    "javascript": (js_dir, expected_js),
    "node": (node_dir, expected_node)
}

for cat_name, (cat_path, expected_list) in category_map.items():
    if not os.path.isdir(cat_path):
        continue
    actual_dirs = [d for d in os.listdir(cat_path) if os.path.isdir(os.path.join(cat_path, d))]
    for expected in expected_list:
        if expected not in actual_dirs:
            errors.append(f"Required folder missing: {cat_name}/{expected}")
    for actual in actual_dirs:
        if actual.lower().startswith("slip") or actual.lower().startswith("program") or actual.lower().startswith("jwt"):
            errors.append(f"Prohibited folder naming detected: {cat_name}/{actual}")
        if actual not in expected_list:
            errors.append(f"Unexpected or duplicate folder: {cat_name}/{actual}")

for slip_num in range(1, 31):
    if slip_num not in slip_mapping:
        errors.append(f"Slip {slip_num} is not represented in the mapping.")
    else:
        j_cat, j_prog, w_cat, w_prog = slip_mapping[slip_num]
        j_path = os.path.join(base_dir, j_cat, j_prog)
        w_path = os.path.join(base_dir, w_cat, w_prog)
        if not os.path.isdir(j_path):
            errors.append(f"Slip {slip_num} Q1 folder missing: {j_cat}/{j_prog}")
        if not os.path.isdir(w_path):
            errors.append(f"Slip {slip_num} Q2 folder missing: {w_cat}/{w_prog}")

def check_balanced_symbols(text, filepath):
    char_names = {')': 'Parentheses', '}': 'Braces', ']': 'Square brackets'}
    pairs = {')': '(', '}': '{', ']': '['}
    stack = []
    in_sq = False
    in_dq = False
    in_bt = False
    esc = False
    for idx, ch in enumerate(text):
        if esc:
            esc = False
            continue
        if ch == '\\':
            esc = True
            continue
        if ch == '"' and not in_sq and not in_bt:
            in_dq = not in_dq
            continue
        if ch == "'" and not in_dq and not in_bt:
            in_sq = not in_sq
            continue
        if ch == '`' and not in_sq and not in_dq:
            in_bt = not in_bt
            continue
        if in_sq or in_dq or in_bt:
            continue
        if ch in '({[':
            stack.append((ch, idx))
        elif ch in ')}]':
            if not stack:
                return f"Unmatched closing '{ch}' at index {idx} in {filepath}"
            top, pos = stack.pop()
            if top != pairs[ch]:
                return f"Mismatched '{top}' and '{ch}' at index {idx} in {filepath}"
    if stack:
        top, pos = stack[-1]
        return f"Unclosed '{top}' starting at index {pos} in {filepath}"
    return None

prohibited_comment_tokens = ["//", "/*", "*/", "<!--", "-->", "#"]

all_categories = [java_dir, js_dir, node_dir]
for cat_path in all_categories:
    if not os.path.isdir(cat_path):
        continue
    for folder_name in os.listdir(cat_path):
        prog_folder = os.path.join(cat_path, folder_name)
        if not os.path.isdir(prog_folder):
            continue
        total_folders += 1
        q_path = os.path.join(prog_folder, "question.txt")
        if not os.path.exists(q_path):
            errors.append(f"Missing question.txt in {prog_folder}")
        else:
            with open(q_path, "r", encoding="utf-8") as qf:
                q_text = qf.read().strip()
            if len(q_text) == 0:
                errors.append(f"question.txt is empty in {prog_folder}")

        files_in_folder = os.listdir(prog_folder)
        source_files = [f for f in files_in_folder if f != "question.txt" and not os.path.isdir(os.path.join(prog_folder, f))]
        if not source_files:
            errors.append(f"No source files found in {prog_folder}")
        for sf in source_files:
            total_source_files += 1
            sf_path = os.path.join(prog_folder, sf)
            size = os.path.getsize(sf_path)
            if size == 0:
                errors.append(f"Source file is empty: {sf_path}")
            with open(sf_path, "r", encoding="utf-8") as sff:
                code_content = sff.read()
            for token in prohibited_comment_tokens:
                if token in code_content:
                    errors.append(f"Prohibited comment token '{token}' found in {sf_path}")
            ext = os.path.splitext(sf)[1].lower()
            if ext in [".java", ".js", ".css"]:
                balance_err = check_balanced_symbols(code_content, sf_path)
                if balance_err:
                    errors.append(balance_err)

print(f"Total program folders checked: {total_folders}")
print(f"Total source files checked: {total_source_files}")

if errors:
    print(f"Found {len(errors)} error(s):")
    for err in errors:
        print(f"- {err}")
    sys.exit(1)
else:
    print("ALL FILES PASSED VERIFICATION!")
    sys.exit(0)
