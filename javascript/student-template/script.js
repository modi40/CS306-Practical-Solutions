const studentName = "Aarav Sharma";
const rollNo = 101;
const courseName = "B.Sc. Computer Science";
const marksJava = 88;
const marksWebTech = 92;
const marksDBMS = 85;

const totalMarks = marksJava + marksWebTech + marksDBMS;
const percentage = (totalMarks / 300) * 100;
const grade = percentage >= 75 ? "Distinction" : percentage >= 60 ? "First Class" : "Pass Class";

const report = `======================================
         STUDENT REPORT CARD
======================================
Roll No: ${rollNo}
Name:    ${studentName}
Course:  ${courseName}
--------------------------------------
Subjects and Marks:
- Core Java:            ${marksJava} out of 100
- Web Technology:       ${marksWebTech} out of 100
- Database Systems:     ${marksDBMS} out of 100
--------------------------------------
Total Marks:            ${totalMarks} out of 300
Percentage:             ${percentage.toFixed(2)}%
Final Grade:            ${grade}
======================================`;

console.log(report);

if (typeof document !== "undefined") {
    const el = document.getElementById("report");
    if (el) {
        el.textContent = report;
    }
}
