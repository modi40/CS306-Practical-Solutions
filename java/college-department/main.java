class College {
    int cno;
    String cname;
    String caddr;

    College(int cno, String cname, String caddr) {
        this.cno = cno;
        this.cname = cname;
        this.caddr = caddr;
    }

    void displayCollege() {
        System.out.println("College Number: " + cno);
        System.out.println("College Name: " + cname);
        System.out.println("College Address: " + caddr);
    }
}

class Department extends College {
    int dno;
    String dname;

    Department(int cno, String cname, String caddr, int dno, String dname) {
        super(cno, cname, caddr);
        this.dno = dno;
        this.dname = dname;
    }

    void displayDepartment() {
        displayCollege();
        System.out.println("Department Number: " + dno);
        System.out.println("Department Name: " + dname);
    }
}

class Main {
    public static void main(String[] args) {
        Department dept = new Department(101, "Fergusson College", "FC Road, Pune", 15, "Computer Science");
        dept.displayDepartment();
    }
}
