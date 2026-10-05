const http = require("http");

const server = http.createServer((req, res) => {
    res.writeHead(200, { "Content-Type": "text/plain" });
    res.end("Response received successfully from Node.js HTTP Server! Requested URL: " + req.url);
});

const PORT = 3000;
server.listen(PORT, () => {
    console.log("HTTP Server running on port " + PORT);
    if (process.env.TEST_MODE) {
        server.close();
    }
});
