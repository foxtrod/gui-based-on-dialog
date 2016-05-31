package Controller;

import Model.Student;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ReadXMLFile extends DefaultHandler {


    private ArrayList<Student> students = new ArrayList<>();
    private String thisElement = "";
    private int thisStudent = 0;
    private int thisParentFather = 0;
    private int thisParentMother = 0;
    private int thisSalary = 0;

    private String studentSurname = "";
    private String studentName = "";
    private String studentLastName = "";
    private String studentBrothers = "";
    private String studentSisters = "";

    private String parentFatherSurname = "";
    private String parentFatherName = "";
    private String parentFatherLastName = "";
    private String parentFatherSalary = "";

    private String parentMotherSurname = "";
    private String parentMotherName = "";
    private String parentMotherLastName = "";
    private String parentMotherSalary = "";

    private final String surnameConst = "surname";
    private final String nameConst = "name";
    private final String lastNameConst = "lastname";

    private final String studentConst = "student";
    private final String parentFatherConst = "parent father";
    private final String parentMotherConst = "parent mother";
    private final String salaryConst = "salary";


    public ArrayList<Student> getResult() {
        return students;
    }

    public void startDocument() throws SAXException {
        System.out.println("start");
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals(studentConst)) {
            thisStudent++;
        }
        if (qName.equals(parentFatherConst)) {
            thisParentFather++;
        }
        thisElement = qName;
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisStudent != 0) {
            if (thisElement.equals(surnameConst) && thisParentFather == 0) {
                studentSurname = new String(ch, start, length);
            }
            if (thisElement.equals(nameConst) && thisParentFather == 0) {
                studentName = new String(ch, start, length);
            }
            if (thisElement.equals(lastNameConst) && thisParentFather == 0) {
                studentLastName = new String(ch, start, length);
            }
            if (thisElement.equals(studentBrothers) && thisParentFather == 0) {
                studentBrothers = new String(ch, start, length);
            }
            if (thisElement.equals(studentSisters) && thisParentFather == 0) {
                studentSisters = new String(ch, start, length);
            }

            if (thisParentFather != 0) {
                if (surnameConst.equals(thisElement)) {
                    parentFatherSurname = new String(ch, start, length);
                }
                if (nameConst.equals(thisElement)) {
                    parentFatherName = new String(ch, start, length);
                }
                if (lastNameConst.equals(thisElement)) {
                    parentFatherLastName = new String(ch, start, length);
                }
                if (salaryConst.equals(thisElement)) {
                    parentFatherSalary = new String(ch, start, length);
                }
            }

            if (thisParentMother != 0) {
                if (surnameConst.equals(thisElement)) {
                    parentMotherSurname = new String(ch, start, length);
                }
                if (nameConst.equals(thisElement)) {
                    parentMotherName = new String(ch, start, length);
                }
                if (lastNameConst.equals(thisElement)) {
                    parentMotherLastName = new String(ch, start, length);
                }
                if (salaryConst.equals(thisElement)) {
                    parentMotherSalary = new String(ch, start, length);
                    students.add(new Student(studentSurname, studentName, studentLastName, Integer.parseInt(studentSisters),
                            Integer.parseInt(studentBrothers), parentMotherSurname, parentMotherName, parentMotherLastName,
                            Integer.parseInt(parentMotherSalary), parentFatherSurname, parentFatherName, parentFatherLastName,
                            Integer.parseInt(parentFatherSalary)));
                    thisStudent = 0;
                    thisParentFather = 0;
                    thisParentMother = 0;
                }
            }
        }
    }


    public void endDocument() {
        System.out.println("end");
    }
}
