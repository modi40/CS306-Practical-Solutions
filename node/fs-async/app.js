const fs = require("fs");
const path = require("path");

const filePath = path.join(__dirname, "sample_async.txt");

fs.writeFile(filePath, "Initial asynchronous content.\n", (err) => {
    if (err) {
        console.log("Error writing file: " + err.message);
        return;
    }
    console.log("Step 1: File created and written asynchronously.");

    fs.readFile(filePath, "utf8", (err, data) => {
        if (err) {
            console.log("Error reading file: " + err.message);
            return;
        }
        console.log("Step 2: File read successfully. Content:\n" + data);

        fs.appendFile(filePath, "Appended line via async call.\n", (err) => {
            if (err) {
                console.log("Error appending file: " + err.message);
                return;
            }
            console.log("Step 3: Content appended successfully.");

            fs.unlink(filePath, (err) => {
                if (err) {
                    console.log("Error deleting file: " + err.message);
                    return;
                }
                console.log("Step 4: File deleted asynchronously.");
            });
        });
    });
});
