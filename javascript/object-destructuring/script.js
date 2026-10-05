const employee = {
    name: "Vikram Malhotra",
    department: "Information Technology",
    salary: 85000
};

const { name, department, salary } = employee;

const displayContent = `Employee Name:       ${name}\nEmployee Department: ${department}\nEmployee Salary:     Rs. ${salary}`;

console.log(displayContent);

if (typeof document !== "undefined") {
    const el = document.getElementById("output");
    if (el) {
        el.textContent = displayContent;
    }
}
