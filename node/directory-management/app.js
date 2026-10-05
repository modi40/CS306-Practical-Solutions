const fs = require("fs");
const path = require("path");

const testDir = path.join(__dirname, "test_folder");
const renamedDir = path.join(__dirname, "renamed_folder");

if (!fs.existsSync(testDir)) {
    fs.mkdirSync(testDir);
    console.log("Created directory: " + testDir);
}

fs.writeFileSync(path.join(testDir, "test.txt"), "sample file");

const filesInside = fs.readdirSync(testDir);
console.log("Listing contents of directory: " + filesInside.join(", "));

fs.unlinkSync(path.join(testDir, "test.txt"));

if (fs.existsSync(renamedDir)) {
    fs.rmdirSync(renamedDir);
}
fs.renameSync(testDir, renamedDir);
console.log("Renamed directory to: " + renamedDir);

fs.rmdirSync(renamedDir);
console.log("Deleted directory: " + renamedDir);
