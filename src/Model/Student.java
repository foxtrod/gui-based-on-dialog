package Model;

public class Student {
    private String studentSurname;
    private String studentName;
    private String studentLastName;

    private int numberOfSisters;
    private int numberOfBrothers;

    public ParentMother parentMother;
    public ParentFather parentFather;

    public Student() {
    }

    public Student(String studentSurname, String studentName, String studentLastName, int sisters, int brothers,
                   String motherName, String motherSurname, String motherLastName, int motherSalary,
                   String fatherName, String fatherSurname, String fatherLastName, int fatherSalary) {
        this.studentSurname = studentSurname;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.numberOfBrothers = brothers;
        this.numberOfSisters = sisters;
        this.parentMother = new ParentMother(motherSurname, motherName, motherLastName, motherSalary);
        this.parentFather = new ParentFather(fatherSurname, fatherName, fatherLastName, fatherSalary);
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public int getNumberOfSisters() {
        return numberOfSisters;
    }

    public int getNumberOfBrothers() {
        return numberOfBrothers;
    }

}
