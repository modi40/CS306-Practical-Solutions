const divideNumbers = (numerator, denominator) => {
    return new Promise((resolve, reject) => {
        if (denominator === 0) {
            reject(new Error("Division by zero error: Denominator cannot be zero."));
        } else {
            resolve(numerator / denominator);
        }
    });
};

divideNumbers(50, 5)
    .then((result) => {
        console.log("Division Result (50 / 5): " + result);
    })
    .catch((error) => {
        console.log("Error caught: " + error.message);
    });

divideNumbers(100, 0)
    .then((result) => {
        console.log("Division Result (100 / 0): " + result);
    })
    .catch((error) => {
        console.log("Error caught: " + error.message);
    });
