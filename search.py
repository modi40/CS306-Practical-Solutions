import os
import sys
import re

if len(sys.argv) < 2:
    print("Usage: python3 search.py <search_term>")
    sys.exit(1)

query = sys.argv[1].strip()
query_lower = query.lower()

base_dir = os.path.dirname(os.path.abspath(__file__))
categories = ["java", "javascript", "node"]

primary_matches = []
secondary_matches = []

word_pattern = re.compile(r"\b" + re.escape(query) + r"\b", re.IGNORECASE)

for cat in categories:
    cat_dir = os.path.join(base_dir, cat)
    if not os.path.isdir(cat_dir):
        continue
    for folder in sorted(os.listdir(cat_dir)):
        folder_path = os.path.join(cat_dir, folder)
        if not os.path.isdir(folder_path):
            continue
        rel_folder = f"{cat}/{folder}"
        is_primary = False
        is_secondary = False

        if query_lower in folder.lower():
            is_primary = True

        q_path = os.path.join(folder_path, "question.txt")
        if os.path.exists(q_path):
            with open(q_path, "r", encoding="utf-8") as qf:
                q_text = qf.read()
            if word_pattern.search(q_text):
                is_primary = True
            elif query_lower in q_text.lower():
                is_secondary = True

        if is_primary:
            primary_matches.append((rel_folder, folder_path))
        elif is_secondary:
            secondary_matches.append((rel_folder, folder_path))

matches = primary_matches if primary_matches else secondary_matches

print(f"SEARCH RESULTS FOR: {query}\n")

if not matches:
    print("No matching programs found.")
else:
    for rel_folder, full_path in matches:
        print(f"{rel_folder}/")
        files = sorted(os.listdir(full_path))
        if "question.txt" in files:
            print("    question.txt")
        for f in files:
            if f != "question.txt" and os.path.isfile(os.path.join(full_path, f)):
                print(f"    {f}")
        print()
