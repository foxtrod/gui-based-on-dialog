package Model;

/**
 * Created by horbachevsky on 17.05.2016.
 */
public class ParentFather {


    private String parentFatherSurname;
    private String parentFatherName;
    private String parentFatherLastName;


    public Salary salary;

    public ParentFather(String parentFatherSurname, String parentFatherName, String parentFatherLastName, int salary) {
        this.parentFatherLastName = parentFatherLastName;
        this.parentFatherName = parentFatherName;
        this.parentFatherSurname = parentFatherSurname;
        this.salary = new Salary(salary);
    }

    public ParentFather() {

    }

    public Salary getSalary() {
        return salary;
    }

    public String getParentFatherLastName() {
        return parentFatherLastName;
    }

    public String getParentFatherName() {
        return parentFatherName;
    }

    public String getParentFatherSurname() {
        return parentFatherSurname;
    }

}
