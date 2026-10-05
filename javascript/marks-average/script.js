const calculateMarks = (s1, s2, s3) => {
    const total = s1 + s2 + s3;
    const average = total / 3;
    return `Subject 1: ${s1}\nSubject 2: ${s2}\nSubject 3: ${s3}\nTotal Marks: ${total}\nAverage Marks: ${average.toFixed(2)}`;
};

const result = calculateMarks(84, 78, 92);
console.log(result);

if (typeof document !== "undefined") {
    const out = document.getElementById("output");
    if (out) {
        out.innerHTML = `<pre>${result}</pre>`;
    }
}
