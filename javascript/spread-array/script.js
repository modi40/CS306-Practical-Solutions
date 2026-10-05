const originalArray = ["Apple", "Banana", "Cherry", "Mango"];
const copiedArray = [...originalArray, "Orange"];

const resultText = `Original Array: [ ${originalArray.join(", ")} ]\nCopied Array:   [ ${copiedArray.join(", ")} ]`;

console.log(resultText);

if (typeof document !== "undefined") {
    const el = document.getElementById("output");
    if (el) {
        el.textContent = resultText;
    }
}
