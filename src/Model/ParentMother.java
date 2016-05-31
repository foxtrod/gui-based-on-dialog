package Model;

/**
 * Created by horbachevsky on 13.05.2016.
 */
public class ParentMother {

    private String parentMotherSurname;
    private String parentMotherName;
    private String parentMotherLastName;


    public Salary salary;

    public ParentMother(String parentMotherSurname, String parentMotherName, String parentMotherLastName, int salary) {
        this.parentMotherLastName = parentMotherLastName;
        this.parentMotherName = parentMotherName;
        this.parentMotherSurname = parentMotherSurname;
        this.salary = new Salary(salary);
    }

    public ParentMother() {

    }

    public Salary getSalary() {
        return salary;
    }

    public String getParentMotherLastName() {
        return parentMotherLastName;
    }

    public String getParentMotherName() {
        return parentMotherName;
    }

    public String getParentMotherSurname() {
        return parentMotherSurname;
    }

}
