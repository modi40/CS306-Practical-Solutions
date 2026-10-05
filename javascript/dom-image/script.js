let current = 1;
const img1 = "data:image/svg+xml;utf8,<svg width='300' height='200'><rect width='300' height='200' fill='rgb(52,152,219)'/><text x='150' y='100' fill='white' font-size='24' text-anchor='middle'>Image 1 (Blue)</text></svg>";
const img2 = "data:image/svg+xml;utf8,<svg width='300' height='200'><rect width='300' height='200' fill='rgb(231,76,60)'/><text x='150' y='100' fill='white' font-size='24' text-anchor='middle'>Image 2 (Red)</text></svg>";

document.getElementById("replaceBtn").addEventListener("click", function() {
    const imgElement = document.getElementById("displayImage");
    if (current === 1) {
        imgElement.src = img2;
        current = 2;
    } else {
        imgElement.src = img1;
        current = 1;
    }
});
