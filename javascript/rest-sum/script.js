const calculateSum = (...numbers) => {
    return numbers.reduce((accumulator, current) => accumulator + current, 0);
};

const res1 = `Sum of (10, 20): ${calculateSum(10, 20)}`;
const res2 = `Sum of (5, 10, 15, 20): ${calculateSum(5, 10, 15, 20)}`;
const res3 = `Sum of (1, 2, 3, 4, 5, 6, 7, 8): ${calculateSum(1, 2, 3, 4, 5, 6, 7, 8)}`;

const totalOutput = `${res1}\n${res2}\n${res3}`;
console.log(totalOutput);

if (typeof document !== "undefined") {
    const el = document.getElementById("output");
    if (el) {
        el.textContent = totalOutput;
    }
}
