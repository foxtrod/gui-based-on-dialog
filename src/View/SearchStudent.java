package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStudent extends JDialog {

    Controller controller;
    Controller myController;
    PageView pageView;

    Box box = Box.createVerticalBox();

    public SearchStudent(Controller controller) {
        super();
        setSize(800, 500);
        setLayout(new GridLayout(3, 0));

        this.controller = controller;


        JPanel panelOfSearchStudentName = new JPanel();
        JLabel labelOfSearchStudentName = new JLabel("Enter surname of student");
        JTextField textFieldOfSearchStudentName = new JTextField(10);
        JButton buttonOfSearchStudentName = new JButton("Find");
        panelOfSearchStudentName.add(labelOfSearchStudentName);
        panelOfSearchStudentName.add(textFieldOfSearchStudentName);
        panelOfSearchStudentName.add(buttonOfSearchStudentName);

        JPanel panelOfSearchParentName = new JPanel();
        JLabel labelOfSearchParentName = new JLabel("Enter surname of parent");
        JButton buttonOfSearchParentName = new JButton("Find");
        JTextField textFieldOfSearchParentName = new JTextField(10);
        panelOfSearchParentName.add(labelOfSearchParentName);
        panelOfSearchParentName.add(textFieldOfSearchParentName);
        panelOfSearchParentName.add(buttonOfSearchParentName);

        JPanel panelOfSearchParentSalary = new JPanel();
        JLabel labelOfSearchParentSalary = new JLabel("Enter parent's salary");
        JButton buttonOfSearchParentSalary = new JButton("Find");
        JTextField textFieldOfSearchParentSalaryMin = new JTextField(4);
        JTextField textFieldOfSearchParentSalaryMax = new JTextField(4);
        panelOfSearchParentSalary.add(labelOfSearchParentSalary);
        panelOfSearchParentSalary.add(textFieldOfSearchParentSalaryMin);
        panelOfSearchParentSalary.add(textFieldOfSearchParentSalaryMax);
        panelOfSearchParentSalary.add(buttonOfSearchParentSalary);

        JPanel panelOfSearchStudentBrother = new JPanel();
        JLabel labelOfSearchStudentBrother = new JLabel("Enter amount of student's brothers");
        JButton buttonOfSearchStudentBrother = new JButton("Find");
        JTextField textFieldOfSearchStudentBrother = new JTextField(5);
        panelOfSearchStudentBrother.add(labelOfSearchStudentBrother);
        panelOfSearchStudentBrother.add(textFieldOfSearchStudentBrother);
        panelOfSearchStudentBrother.add(buttonOfSearchStudentBrother);

        JPanel panelOfSearchStudentSister = new JPanel();
        JLabel labelOfSearchStudentSister = new JLabel("Enter amount of student's brothers");
        JButton buttonOfSearchStudentSister = new JButton("Find");
        JTextField textFieldOfSearchStudentSister = new JTextField(5);
        panelOfSearchStudentSister.add(labelOfSearchStudentSister);
        panelOfSearchStudentSister.add(textFieldOfSearchStudentSister);
        panelOfSearchStudentSister.add(buttonOfSearchStudentSister);

        box.add(panelOfSearchStudentName);
        box.add(panelOfSearchParentName);
        box.add(panelOfSearchParentSalary);
        box.add(panelOfSearchStudentBrother);
        box.add(panelOfSearchStudentSister);

        add(box);

        setLocationRelativeTo(null);

        buttonOfSearchStudentName.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            if (pageView != null)
                                                                remove(pageView);
                                                            if (controller.searchByStudentSurname(textFieldOfSearchStudentName.getText()).size() != 0) {
                                                                myController = new Controller(controller.searchByStudentSurname(textFieldOfSearchStudentName.getText()));
                                                                myController.addCountPageOfSearch(controller.searchByStudentSurname(textFieldOfSearchStudentName.getText()).size());
                                                                pageView = new PageView(myController, 1);
                                                                pageView.updateRecords();
                                                                add(pageView);
                                                                getContentPane().validate();
                                                            } else
                                                                JOptionPane.showMessageDialog(null, "Can't find student");
                                                        }
                                                    }
        );

        buttonOfSearchParentName.addActionListener(new ActionListener() {
                                                       @Override
                                                       public void actionPerformed(ActionEvent e) {
                                                           if (pageView != null) {
                                                               remove(pageView);
                                                           }
                                                           if (controller.searchByParentSurname(textFieldOfSearchParentName.getText()).size() != 0) {
                                                               myController = new Controller(controller.searchByParentSurname(textFieldOfSearchParentName.getText()));
                                                               myController.addCountPageOfSearch(controller.searchByParentSurname(textFieldOfSearchParentName.getText()).size());
                                                               pageView = new PageView(myController, 1);
                                                               pageView.updateRecords();
                                                               add(pageView);
                                                               getContentPane().validate();
                                                           } else {
                                                               JOptionPane.showMessageDialog(null, "Can't find parent");
                                                           }
                                                       }
                                                   }
        );

        buttonOfSearchParentSalary.addActionListener(new ActionListener() {
                                                         @Override
                                                         public void actionPerformed(ActionEvent e) {
                                                             if (pageView != null) {
                                                                 remove(pageView);
                                                             }
                                                             if (controller.searchByParentSalary(Integer.parseInt(textFieldOfSearchParentSalaryMin.getText()),
                                                                     Integer.parseInt(textFieldOfSearchParentSalaryMax.getText())).size() != 0) {
                                                                 myController = new Controller(controller.searchByParentSalary(Integer.parseInt(textFieldOfSearchParentSalaryMin.getText()),
                                                                         Integer.parseInt(textFieldOfSearchParentSalaryMax.getText())));
                                                                 myController.addCountPageOfSearch(controller.searchByParentSalary(Integer.parseInt(textFieldOfSearchParentSalaryMin.getText()),
                                                                         Integer.parseInt(textFieldOfSearchParentSalaryMax.getText())).size());
                                                                 pageView = new PageView(myController, 1);
                                                                 pageView.updateRecords();
                                                                 add(pageView);
                                                                 getContentPane().validate();
                                                             } else {
                                                                 JOptionPane.showMessageDialog(null, "No parent with such salary");
                                                             }
                                                         }
                                                     }
        );

        buttonOfSearchStudentBrother.addActionListener(new ActionListener() {
                                                         @Override
                                                         public void actionPerformed(ActionEvent e) {
                                                             if (pageView != null) {
                                                                 remove(pageView);
                                                             }
                                                             if (controller.searchByAmountOfBrothers(Integer.parseInt(textFieldOfSearchStudentBrother.getText())).size() != 0) {
                                                                 myController = new Controller(controller.searchByAmountOfBrothers(Integer.parseInt(textFieldOfSearchStudentBrother.getText())));
                                                                 myController.addCountPageOfSearch(controller.searchByAmountOfBrothers(Integer.parseInt(textFieldOfSearchStudentBrother.getText())).size());
                                                                 pageView = new PageView(myController, 1);
                                                                 pageView.updateRecords();
                                                                 add(pageView);
                                                                 getContentPane().validate();
                                                             } else {
                                                                 JOptionPane.showMessageDialog(null, "No such student");
                                                             }
                                                         }
                                                     }
        );

        buttonOfSearchStudentSister.addActionListener(new ActionListener() {
                                                           @Override
                                                           public void actionPerformed(ActionEvent e) {
                                                               if (pageView != null) {
                                                                   remove(pageView);
                                                               }
                                                               if (controller.searchByAmountOfSisters(Integer.parseInt(textFieldOfSearchStudentSister.getText())).size() != 0) {
                                                                   myController = new Controller(controller.searchByAmountOfSisters(Integer.parseInt(textFieldOfSearchStudentSister.getText())));
                                                                   myController.addCountPageOfSearch(controller.searchByAmountOfSisters(Integer.parseInt(textFieldOfSearchStudentSister.getText())).size());
                                                                   pageView = new PageView(myController, 1);
                                                                   pageView.updateRecords();
                                                                   add(pageView);
                                                                   getContentPane().validate();
                                                               } else {
                                                                   JOptionPane.showMessageDialog(null, "No such student");
                                                               }
                                                           }
                                                       }
        );

    }
}
