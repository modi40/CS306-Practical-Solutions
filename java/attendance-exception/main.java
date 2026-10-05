class StudentNotEligibleException extends Exception {
    StudentNotEligibleException(String message) {
        super(message);
    }
}

class Student {
    String student_name;
    int student_rollno;
    int total_lectures;
    int attended_lectures;

    Student(String student_name, int student_rollno, int total_lectures, int attended_lectures) {
        this.student_name = student_name;
        this.student_rollno = student_rollno;
        this.total_lectures = total_lectures;
        this.attended_lectures = attended_lectures;
    }

    void verifyEligibility() throws StudentNotEligibleException {
        double percentage = (attended_lectures * 100.0) / total_lectures;
        if (percentage < 75.0) {
            throw new StudentNotEligibleException("Student is Not Eligible for Exam");
        }
        System.out.println("--- Student Details ---");
        System.out.println("Roll Number: " + student_rollno);
        System.out.println("Name: " + student_name);
        System.out.println("Total Lectures: " + total_lectures);
        System.out.println("Attended Lectures: " + attended_lectures);
        System.out.println("Attendance: " + percentage + "%");
        System.out.println("Eligibility: Eligible for Exam");
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("Pooja More", 21, 60, 52);
            s1.verifyEligibility();
        } catch (StudentNotEligibleException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            Student s2 = new Student("Sachin Shinde", 22, 60, 35);
            s2.verifyEligibility();
        } catch (StudentNotEligibleException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
