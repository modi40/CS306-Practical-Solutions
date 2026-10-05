const authenticateUser = (username, password) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (username === "admin" && password === "pass123") {
                resolve("Login successful! Welcome, " + username + ".");
            } else {
                reject(new Error("Invalid username or password! Access denied."));
            }
        }, 100);
    });
};

const simulateLogin = async (username, password) => {
    try {
        console.log("Attempting login for: " + username);
        const result = await authenticateUser(username, password);
        console.log("Success: " + result);
    } catch (error) {
        console.log("Error: " + error.message);
    }
};

const run = async () => {
    await simulateLogin("admin", "pass123");
    await simulateLogin("john_doe", "wrongpassword");
};

run();
