package View;

import Model.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private int columnCount = 7;

    private List<Student> studentList;
    private List<Student> tempo;

    private int visibleSize = 1;
    private int pageCount;
    private int rest;
    private int currentPage = 0;
    private boolean flag = true;
    private int visible = 0;


    public TableModel(List<Student> studentList) {
        this.studentList = studentList;
        tempo = this.studentList;
    }

    public TableModel() {
        this.studentList.add(new Student());
        tempo = this.studentList;
    }

    public void add(List<Student> studentList) {
        tempo = studentList;
        this.studentList = studentList;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public String getColumnName(int ColumnIndex) {

        String studentName = "Name of student";
        String fatherName = "Name of father";
        String fatherSalary = "Father's salary";
        String motherName = "Name of mother";
        String motherSalary = "Mother's salary";
        String numberOfBrothers = "Number of brothers";
        String numberOfSisters = "Number of sisters";

        switch (ColumnIndex) {
            case 0:
                return studentName;
            case 1:
                return fatherName;
            case 2:
                return fatherSalary;
            case 3:
                return motherName;
            case 4:
                return motherSalary;
            case 5:
                return numberOfBrothers;
            case 6:
                return numberOfSisters;
        }
        return " ";
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getRowCount() {
        if (visibleSize != 0) {
            pageCount = tempo.size() / visibleSize;
            rest = tempo.size() % visibleSize;
        }
        if (flag) {
            return visibleSize;
        } else {
            return rest;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student;
        if (currentPage < pageCount) {
            student = tempo.subList(visible, visible + visibleSize).get(rowIndex);
        } else
            student = studentList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return student.getStudentSurname() + " " + student.getStudentName()
                        + " " + student.getStudentLastName();
            case 1:
                return student.parentFather.getParentFatherSurname() + " " +
                        student.parentFather.getParentFatherName() + " " +
                        student.parentFather.getParentFatherLastName();
            case 2:
                return student.parentFather.salary.getSalary();
            case 3:
                return student.parentMother.getParentMotherSurname() + " " +
                        student.parentMother.getParentMotherName() + " " +
                        student.parentMother.getParentMotherLastName();
            case 4:
                return student.parentMother.salary.getSalary();
            case 5:
                return student.getNumberOfBrothers();
            case 6:
                return student.getNumberOfSisters();

        }
        return "";
    }


    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void deleteRow(int count) {
        studentList.remove(count);
    }

    public void pageUp() {
        if (currentPage < pageCount) {
            studentList = tempo.subList(visible, visible + visibleSize);
            visible += visibleSize;
            currentPage++;
        }
        if (currentPage == pageCount) {
            studentList = tempo.subList(tempo.size() - rest, tempo.size());
            flag = false;
            currentPage = pageCount;
            visible = tempo.size() - rest;
        }
    }

    public void pageDown() {
        if (currentPage != 0) {
            studentList = tempo.subList(visible - visibleSize, visible);
            visible -= visibleSize;
            currentPage--;
            flag = true;
        }
    }

    public void startTable() {
        studentList = tempo;
        currentPage = 0;
        flag = true;
        visible = 0;
    }

    public void endTable() {
        studentList = tempo.subList(tempo.size() - rest, tempo.size());
        flag = false;
        currentPage = pageCount;
        visible = tempo.size() - rest;
    }

    public void changeVisibleSize(int count) {
        startTable();
        if (count > tempo.size())
            JOptionPane.showMessageDialog(null, "Nothing exist");
        else
            visibleSize = count;
        this.fireTableDataChanged();
    }

    public void changeVisibleSizeBySearch(int count) {
        visibleSize = count;
        this.fireTableDataChanged();
    }

    public int numberOfRecords() {
        return tempo.size();
    }
}

