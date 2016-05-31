package View;

import Controller.Controller;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent {

    private JTextField fieldSurnameStudent;
    private JTextField fieldNameStudent;
    private JTextField fieldLastNameStudent;

    private JTextField fieldSistersStudent;
    private JTextField fieldBrothersStudent;

    private JTextField fieldParentFatherSurname;
    private JTextField fieldParentFatherName;
    private JTextField fieldParentFatherLastName;
    private JTextField fieldParentFatherSalary;


    private JTextField fieldParentMotherSurname;
    private JTextField fieldParentMotherName;
    private JTextField fieldParentMotherLastName;
    private JTextField fieldParentMotherSalary;



    Controller controller;

    public AddStudent(Controller controller, PageView pageView) {

        JFrame frame;

        frame = new JFrame("Adding");
        frame.setSize(550, 400);
        frame.setLayout(new GridLayout(0, 6));

        fieldSurnameStudent = new JTextField(10);
        fieldNameStudent = new JTextField(10);
        fieldLastNameStudent = new JTextField(10);


        fieldParentFatherSurname = new JTextField(10);
        fieldParentFatherName = new JTextField(10);
        fieldParentFatherLastName = new JTextField(10);
        fieldParentFatherSalary = new JTextField(10);

        fieldParentMotherSurname = new JTextField(10);
        fieldParentMotherName = new JTextField(10);
        fieldParentMotherLastName = new JTextField(10);
        fieldParentMotherSalary = new JTextField(10);

        fieldSistersStudent = new JTextField(10);
        fieldBrothersStudent = new JTextField(10);

        this.controller = controller;

        JLabel labelNameStudent = new JLabel("Enter name of student");
        JLabel labelNameFather = new JLabel("Enter name of father");
        JLabel labelSalaryFather = new JLabel("Enter salary of father");
        JLabel labelNameMother = new JLabel("Enter name of mother");
        JLabel labelSalaryMother = new JLabel("Enter salary of mother");
        JLabel labelNumbOfBrother = new JLabel("Enter number of brothers of student");
        JLabel labelNumbOfSisters = new JLabel("Enter number of sisters of student");

        JPanel panelOfStudentName = new JPanel();
        JPanel panelOfFatherName = new JPanel();
        JPanel panelOfFatherSalary = new JPanel();
        JPanel panelOfMotherName = new JPanel();
        JPanel panelOfMotherSalary = new JPanel();
        JPanel panelOfNumbOfBrothers = new JPanel();
        JPanel panelOfNumbOfSisters = new JPanel();

        JButton buttonConfirm;

        buttonConfirm = new JButton("Ok");

        panelOfStudentName.add(labelNameStudent);
        panelOfStudentName.add(fieldSurnameStudent);
        panelOfStudentName.add(fieldNameStudent);
        panelOfStudentName.add(fieldLastNameStudent);

        panelOfFatherName.add(labelNameFather);
        panelOfFatherName.add(fieldParentFatherSurname);
        panelOfFatherName.add(fieldParentFatherName);
        panelOfFatherName.add(fieldParentFatherLastName);

        panelOfFatherSalary.add(labelSalaryFather);
        panelOfFatherSalary.add(fieldParentFatherSalary);

        panelOfMotherName.add(labelNameMother);
        panelOfMotherName.add(fieldParentMotherSurname);
        panelOfMotherName.add(fieldParentMotherName);
        panelOfMotherName.add(fieldParentMotherLastName);

        panelOfMotherSalary.add(labelSalaryMother);
        panelOfMotherSalary.add(fieldParentMotherSalary);

        panelOfNumbOfBrothers.add(labelNumbOfBrother);
        panelOfNumbOfBrothers.add(fieldBrothersStudent);

        panelOfNumbOfSisters.add(labelNumbOfSisters);
        panelOfNumbOfSisters.add(fieldSistersStudent);

        frame.setLayout(new GridLayout(6, 0));
        frame.add(panelOfStudentName);
        frame.add(panelOfFatherName);
        frame.add(panelOfFatherSalary);
        frame.add(panelOfMotherName);
        frame.add(panelOfMotherSalary);
        frame.add(panelOfNumbOfBrothers);
        frame.add(panelOfNumbOfSisters);
        frame.add(buttonConfirm);
        frame.setVisible(true);

        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.add(fieldSurnameStudent.getText(), fieldNameStudent.getText(), fieldLastNameStudent.getText(),
                        Integer.parseInt(fieldSistersStudent.getText()), Integer.parseInt(fieldBrothersStudent.getText()), fieldParentMotherSurname.getText(),
                        fieldParentMotherName.getText(), fieldParentMotherLastName.getText(), Integer.parseInt(fieldParentMotherSalary.getText()),
                        fieldParentFatherSurname.getText(), fieldParentFatherName.getText(), fieldParentFatherLastName.getText(),
                        Integer.parseInt(fieldParentFatherSalary.getText()));
                pageView.updateRecords();
            }
        });
    }
}

