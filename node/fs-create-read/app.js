const fs = require("fs");
const path = require("path");

const filePath = path.join(__dirname, "created_and_read.txt");

fs.writeFile(filePath, "Hello! This file was created asynchronously using fs.writeFile.", (err) => {
    if (err) {
        console.log("Error creating file: " + err.message);
        return;
    }
    console.log("Success: File created successfully.");

    fs.readFile(filePath, "utf8", (err, data) => {
        if (err) {
            console.log("Error reading file: " + err.message);
            return;
        }
        console.log("Success: File read successfully.");
        console.log("File Content: " + data);

        fs.unlink(filePath, () => {});
    });
});
