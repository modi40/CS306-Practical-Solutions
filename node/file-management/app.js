const fs = require("fs");
const path = require("path");

const fileApp = {
    create(filename, content) {
        fs.writeFileSync(filename, content);
        console.log("File created: " + filename);
    },
    read(filename) {
        if (fs.existsSync(filename)) {
            const data = fs.readFileSync(filename, "utf8");
            console.log("File content [" + filename + "]:\n" + data);
            return data;
        } else {
            console.log("File does not exist: " + filename);
        }
    },
    update(filename, newContent) {
        if (fs.existsSync(filename)) {
            fs.appendFileSync(filename, "\n" + newContent);
            console.log("File updated (appended): " + filename);
        } else {
            console.log("Cannot update. File not found: " + filename);
        }
    },
    rename(oldName, newName) {
        if (fs.existsSync(oldName)) {
            fs.renameSync(oldName, newName);
            console.log("File renamed from " + oldName + " to " + newName);
        } else {
            console.log("Cannot rename. File not found: " + oldName);
        }
    },
    delete(filename) {
        if (fs.existsSync(filename)) {
            fs.unlinkSync(filename);
            console.log("File deleted: " + filename);
        } else {
            console.log("Cannot delete. File not found: " + filename);
        }
    }
};

const f1 = path.join(__dirname, "doc1.txt");
const f2 = path.join(__dirname, "doc_renamed.txt");

console.log("=== Node.js Mini File Management Application ===");
fileApp.create(f1, "Version 1: Initial document content.");
fileApp.read(f1);
fileApp.update(f1, "Version 2: Additional updated line appended.");
fileApp.read(f1);
fileApp.rename(f1, f2);
fileApp.read(f2);
fileApp.delete(f2);
console.log("All file management operations executed successfully.");
