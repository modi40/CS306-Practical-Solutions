const fs = require("fs");
const path = require("path");

const targetFile = path.join(__dirname, "demo_data.txt");

fs.writeFile(targetFile, "Header: First initial record.\n", (err) => {
    if (err) {
        console.log("Failed to create and write file: " + err.message);
        return;
    }
    console.log("File created and initial data written successfully.");

    fs.readFile(targetFile, "utf8", (err, content1) => {
        if (err) {
            console.log("Failed to read file: " + err.message);
            return;
        }
        console.log("Content after initial write:\n" + content1);

        fs.appendFile(targetFile, "Appended: Second record entry.\n", (err) => {
            if (err) {
                console.log("Failed to append data: " + err.message);
                return;
            }
            console.log("Data appended successfully.");

            fs.readFile(targetFile, "utf8", (err, content2) => {
                if (err) {
                    console.log("Failed to read after append: " + err.message);
                    return;
                }
                console.log("Final Content after append:\n" + content2);

                fs.unlink(targetFile, () => {});
            });
        });
    });
});
