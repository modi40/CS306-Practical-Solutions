import { add, subtract, multiply, divide } from "./operations.js";

const x = 50;
const y = 10;

const logOutput = [
    `Module Arithmetic Operations for ${x} and ${y}:`,
    `Addition:       ${add(x, y)}`,
    `Subtraction:    ${subtract(x, y)}`,
    `Multiplication: ${multiply(x, y)}`,
    `Division:       ${divide(x, y)}`
].join("\n");

console.log(logOutput);

if (typeof document !== "undefined") {
    const el = document.getElementById("output");
    if (el) {
        el.textContent = logOutput;
    }
}
