const fs = require("fs");
const path = require("path");

const testFile = path.join(__dirname, "to_read_and_delete.txt");

fs.writeFileSync(testFile, "Temporary content to be read and then removed.");

fs.readFile(testFile, "utf8", (err, data) => {
    if (err) {
        console.log("Error reading file: " + err.message);
        return;
    }
    console.log("Success: File read successfully.");
    console.log("Content: " + data);

    fs.unlink(testFile, (err) => {
        if (err) {
            console.log("Error deleting file: " + err.message);
            return;
        }
        console.log("Success: File deleted successfully.");
    });
});
