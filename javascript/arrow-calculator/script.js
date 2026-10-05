const add = (a, b) => a + b;
const subtract = (a, b) => a - b;
const multiply = (a, b) => a * b;
const divide = (a, b) => b !== 0 ? (a / b) : "Division by zero error";

const num1 = 20;
const num2 = 5;

const results = [
    `Number 1: ${num1}, Number 2: ${num2}`,
    `Addition: ${add(num1, num2)}`,
    `Subtraction: ${subtract(num1, num2)}`,
    `Multiplication: ${multiply(num1, num2)}`,
    `Division: ${divide(num1, num2)}`
];

console.log(results.join("\n"));

if (typeof document !== "undefined") {
    const container = document.getElementById("output");
    if (container) {
        container.innerHTML = `<pre>${results.join("<br>")}</pre>`;
    }
}
