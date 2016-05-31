package Controller;

import Model.Student;
import View.MainView;
import View.TableModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {
    TableModel tableModel;
    ArrayList<Student> students = new ArrayList<>();

    public Controller() {
        initModel();
        initView();
    }

    public Controller(ArrayList<Student> students) {
        this.students = students;
        initModel();
    }

    public TableModel returnModel() {
        return tableModel;
    }

    public void initModel() {
        tableModel = new TableModel(students);
    }

    public void initView() {
        new MainView(this);
    }

    public TableModel openFileToAddStudent(File fileName) {
        tableModel.startTable();
        ArrayList<Student> students1 = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        ReadXMLFile saxp = new ReadXMLFile();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(fileName, saxp);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        students.clear();
        students1 = saxp.getResult();
        students.addAll(students1);
        tableModel.changeVisibleSize(students.size());
        tableModel.fireTableDataChanged();
        return tableModel;
    }

    public void save() {


        String surnameConst = "surname";
        String nameConst = "name";
        String lastNameConst = "lastname";
        String brothersConst = "numberOfBrothers";
        String sistersConst = "numberOfSisters";
        String brothersSistersConst = "brothersSisters";
        String salaryConst = "salary";

        try {
            File file = new File("D:/test.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();
            Element rootElement = doc.createElement("student-list");

            for (int i = 0; i < students.size(); i++) {
                Element elementStudent = doc.createElement("student");

                Element elementSurnameStudent = doc.createElement(surnameConst);
                elementSurnameStudent.appendChild(doc.createTextNode(students.get(i).getStudentSurname()));
                System.out.print(students.get(i).getStudentSurname());
                elementStudent.appendChild(elementSurnameStudent);

                Element elementNameStudent = doc.createElement(nameConst);
                elementNameStudent.appendChild(doc.createTextNode(students.get(i).getStudentName()));
                elementStudent.appendChild(elementNameStudent);

                Element elementLastnameStudent = doc.createElement(lastNameConst);
                elementLastnameStudent.appendChild(doc.createTextNode(students.get(i).getStudentLastName()));
                elementStudent.appendChild(elementLastnameStudent);

                Element elementNumberOfSisters = doc.createElement(sistersConst);
                elementNumberOfSisters.appendChild(doc.createTextNode(String.valueOf(students.get(i).getNumberOfSisters())));
                elementStudent.appendChild(elementNumberOfSisters);

                Element elementNumberOfBrothers = doc.createElement(brothersConst);
                elementNumberOfBrothers.appendChild(doc.createTextNode(String.valueOf(students.get(i).getNumberOfBrothers())));
                elementStudent.appendChild(elementNumberOfBrothers);

                Element elementParentFather = doc.createElement("parentFather");

                Element elementParentFatherSurname = doc.createElement(surnameConst);
                elementParentFatherSurname.appendChild(doc.createTextNode(students.get(i).parentFather.getParentFatherSurname()));
                elementParentFather.appendChild(elementParentFatherSurname);

                Element elementParentFatherName = doc.createElement(nameConst);
                elementParentFatherName.appendChild(doc.createTextNode(students.get(i).parentFather.getParentFatherName()));
                elementParentFather.appendChild(elementParentFatherName);

                Element elementParentFatherLastname = doc.createElement(lastNameConst);
                elementParentFatherLastname.appendChild(doc.createTextNode(students.get(i).parentFather.getParentFatherLastName()));
                elementParentFather.appendChild(elementParentFatherLastname);

                Element elementParentFatherSalary = doc.createElement(salaryConst);
                elementParentFatherSalary.appendChild(doc.createTextNode(String.valueOf(students.get(i).parentFather.salary.getSalary())));
                elementParentFather.appendChild(elementParentFatherSalary);

                Element elementParentMother = doc.createElement("parentMother");

                Element elementParentMotherSurname = doc.createElement(surnameConst);
                elementParentMotherSurname.appendChild(doc.createTextNode(students.get(i).parentMother.getParentMotherSurname()));
                elementParentMother.appendChild(elementParentMotherSurname);

                Element elementParentMotherName = doc.createElement(nameConst);
                elementParentMotherName.appendChild(doc.createTextNode(students.get(i).parentMother.getParentMotherName()));
                elementParentMother.appendChild(elementParentMotherName);

                Element elementParentMotherLastname = doc.createElement(lastNameConst);
                elementParentMotherLastname.appendChild(doc.createTextNode(students.get(i).parentMother.getParentMotherLastName()));
                elementParentMother.appendChild(elementParentMotherLastname);

                Element elementParentMotherSalary = doc.createElement(salaryConst);
                elementParentMotherSalary.appendChild(doc.createTextNode(String.valueOf(students.get(i).parentMother.salary.getSalary())));
                elementParentMother.appendChild(elementParentMotherSalary);

                elementStudent.appendChild(elementParentFather);
                elementStudent.appendChild(elementParentMother);
                rootElement.appendChild(elementStudent);
            }

            doc.appendChild(rootElement);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(file));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void add(String studentName, String studentSurname, String studentLastName, int sisters, int brothers,
                    String motherSurname, String motherName, String motherLastName, int motherSalary,
                    String fatherSurname, String fatherName, String fatherLastName, int fatherSalary) {
        students.add(new Student(studentName, studentSurname, studentLastName, sisters, brothers,
                motherSurname, motherName, motherLastName, motherSalary,
                fatherSurname, fatherName, fatherLastName, fatherSalary));
        tableModel.fireTableDataChanged();
    }

    public void nextPage() {
        tableModel.pageUp();
        tableModel.fireTableDataChanged();
    }

    public void prevPage() {
        tableModel.pageDown();
        tableModel.fireTableDataChanged();
    }

    public void startPage() {
        tableModel.startTable();
        tableModel.fireTableDataChanged();
    }

    public void endPage() {
        tableModel.endTable();
        tableModel.fireTableDataChanged();
    }

    public ArrayList<Student> searchByStudentSurname(String studentSurname) {
        ArrayList<Student> students1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentSurname().equals(studentSurname)) {
                students1.add(students.get(i));
            }
        }
        return students1;
    }

    public ArrayList<Student> searchByParentSurname (String parentSurname) {
        ArrayList<Student> students1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i ++) {
            if (students.get(i).parentFather.getParentFatherSurname().equals(parentSurname) ||
                    students.get(i).parentMother.getParentMotherSurname().equals(parentSurname)) {
                students1.add(students.get(i));
            }
        }
        return students1;
    }

    public ArrayList<Student> searchByParentSalary (int minSalary, int maxSalary) {
        ArrayList<Student> students1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i ++) {
            if ((students.get(i).parentFather.salary.getSalary() < maxSalary &&
                    students.get(i).parentFather.salary.getSalary() > minSalary) ||
                    (students.get(i).parentMother.salary.getSalary() < maxSalary &&
                    students.get(i).parentMother.salary.getSalary() > minSalary)) {
                students1.add(students.get(i));
            }
        }
        return students1;
    }

    public ArrayList<Student> searchByAmountOfBrothers (int amountOfBrothers) {
        ArrayList<Student> students1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i ++) {
            if (students.get(i).getNumberOfBrothers() == amountOfBrothers) {
                students1.add(students.get(i));
            }
        }
        return students1;
    }

    public ArrayList<Student> searchByAmountOfSisters (int amountOfSisters) {
        ArrayList<Student> students1 = new ArrayList<>();

        for (int i = 0; i < students.size(); i ++) {
            if (students.get(i).getNumberOfSisters() == amountOfSisters) {
                students1.add(students.get(i));
            }
        }

        return students1;
    }

    public void deleteByStudentName(String surname) {
        int i;
        int numberOfDeletions = 0;
        for (i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentSurname().equals(surname)) {
                students.remove(i);
                i = 0;
                numberOfDeletions++;
            }
            addCountPage(numberOfRecords());
        }
        JOptionPane.showMessageDialog(null, "Deleted: " + numberOfDeletions + " records");
        tableModel.fireTableDataChanged();
    }

    public void deleteByParentName(String parentName) {

        int numberOfDeletions = 0;

        for (int i = 0; i < students.size(); i ++) {
            if (students.get(i).parentFather.getParentFatherSurname().equals(parentName) ||
                    students.get(i).parentMother.getParentMotherSurname().equals(parentName)) {
                students.remove(i);
                i = 0;
                numberOfDeletions ++;
            }
            addCountPage(numberOfRecords());
        }
        JOptionPane.showMessageDialog(null, "Deleted: " + numberOfDeletions + " records");
        tableModel.fireTableDataChanged();
    }

    public void deleteByParentSalary(int salaryMin, int salaryMax) {


        int numberOfDeletions = 0;

        for (int i = 0; i < students.size(); i ++) {
            if ((students.get(i).parentFather.salary.getSalary() < salaryMax &&
                    students.get(i).parentFather.salary.getSalary() > salaryMin) ||
                    (students.get(i).parentMother.salary.getSalary() < salaryMax &&
                    students.get(i).parentMother.salary.getSalary() > salaryMin)) {
                students.remove(i);
                i = 0;
                numberOfDeletions ++;
            }
            addCountPage(numberOfRecords());
        }
        JOptionPane.showMessageDialog(null, "Deleted: " + numberOfDeletions + " records");
        tableModel.fireTableDataChanged();
    }

    public void addCountPage(int count) {
        tableModel.changeVisibleSize(count);
    }

    public void addCountPageOfSearch(int count) {
        tableModel.changeVisibleSizeBySearch(count);
    }

    public int numberOfRecords() {
        return tableModel.numberOfRecords();
    }

}

