package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent extends JDialog {

    Controller controller;

    Box box = Box.createVerticalBox();

    public DeleteStudent(Controller controller, PageView pageView) {
        super();
        setSize(800, 500);
        setLayout(new GridLayout(3, 0));

        this.controller = controller;

        JPanel panelOfDeleteStudentName = new JPanel();
        JLabel labelOfDeleteSurname = new JLabel("Enter surname of student");
        JTextField textFieldOfDeleteSurname = new JTextField(10);
        JButton buttonOfDeleteSurname = new JButton("Delete");
        panelOfDeleteStudentName.add(labelOfDeleteSurname);
        panelOfDeleteStudentName.add(textFieldOfDeleteSurname);
        panelOfDeleteStudentName.add(buttonOfDeleteSurname);

        JPanel panelOfDeleteParentName = new JPanel();
        JLabel labelOfDeleteParentName = new JLabel("Enter surname of parent");
        JTextField textFieldOfDeleteParentName = new JTextField(10);
        JButton buttonOfDeleteParentSurname = new JButton("Delete");
        panelOfDeleteParentName.add(labelOfDeleteParentName);
        panelOfDeleteParentName.add(textFieldOfDeleteParentName);
        panelOfDeleteParentName.add(buttonOfDeleteParentSurname);

        JPanel panelOfDeleteParentSalary = new JPanel();
        JLabel labelOfDeleteParentSalary = new JLabel("Enter minimum and maximum salary");
        JTextField textFieldOfDeleteParentSalaryMin = new JTextField(5);
        JTextField textFieldOfDeleteParentSalaryMax = new JTextField(5);
        JButton buttonOfDeleteParentSalary = new JButton("Delete");
        panelOfDeleteParentSalary.add(labelOfDeleteParentSalary);
        panelOfDeleteParentSalary.add(textFieldOfDeleteParentSalaryMin);
        panelOfDeleteParentSalary.add(textFieldOfDeleteParentSalaryMax);
        panelOfDeleteParentSalary.add(buttonOfDeleteParentSalary);

        box.add(panelOfDeleteStudentName);
        box.add(panelOfDeleteParentName);
        box.add(panelOfDeleteParentSalary);

        add(box);

        setLocationRelativeTo(null);

        buttonOfDeleteSurname.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        pageView.updateRecords();
                                                        controller.deleteByStudentName(textFieldOfDeleteSurname.getText());
                                                        pageView.updateRecords();
                                                    }
                                                }
        );

        buttonOfDeleteParentSurname.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        pageView.updateRecords();
                                                        controller.deleteByParentName(textFieldOfDeleteParentName.getText());
                                                        pageView.updateRecords();
                                                    }
                                                }
        );

        buttonOfDeleteParentSalary.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        pageView.updateRecords();
                                                        controller.deleteByParentSalary(Integer.parseInt(textFieldOfDeleteParentSalaryMin.getText()),
                                                                Integer.parseInt(textFieldOfDeleteParentSalaryMax.getText()));
                                                        pageView.updateRecords();
                                                    }

                                                }
        );
    }
}

