let a = 15;
let b = 45;

const beforeSwap = `Before Swapping: a = ${a}, b = ${b}`;
console.log(beforeSwap);

[a, b] = [b, a];

const afterSwap = `After Swapping:  a = ${a}, b = ${b}`;
console.log(afterSwap);

if (typeof document !== "undefined") {
    const el = document.getElementById("output");
    if (el) {
        el.textContent = `${beforeSwap}\n${afterSwap}`;
    }
}
