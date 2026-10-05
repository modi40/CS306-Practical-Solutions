const fs = require("fs");
const path = require("path");

const fileToTest = path.join(__dirname, "temporary_file.txt");

fs.writeFile(fileToTest, "This is temporary file content.", (err) => {
    if (err) {
        console.log("Error creating file: " + err.message);
        return;
    }
    console.log("Success: File created successfully at " + fileToTest);

    fs.unlink(fileToTest, (err) => {
        if (err) {
            console.log("Error deleting file: " + err.message);
            return;
        }
        console.log("Success: File deleted successfully.");

        fs.unlink(path.join(__dirname, "non_existent_file.txt"), (err) => {
            if (err) {
                console.log("Expected Error when deleting non-existent file: " + err.message);
            } else {
                console.log("Unexpected success deleting missing file.");
            }
        });
    });
});
