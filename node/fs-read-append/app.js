const fs = require("fs");
const path = require("path");

const targetPath = path.join(__dirname, "read_append_sample.txt");

fs.writeFileSync(targetPath, "Initial existing record line.\n");

fs.appendFile(targetPath, "Appended second line data.\n", (err) => {
    if (err) {
        console.log("Error appending data to file: " + err.message);
        return;
    }
    console.log("Success: Data appended to file successfully.");

    fs.readFile(targetPath, "utf8", (err, data) => {
        if (err) {
            console.log("Error reading file: " + err.message);
            return;
        }
        console.log("Success: File read successfully after append.");
        console.log("Updated File Content:\n" + data);

        fs.unlink(targetPath, () => {});
    });
});
