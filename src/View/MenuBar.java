package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuBar extends JMenuBar {

    private JMenuItem saveButton = new JMenuItem("Save");
    private JMenuItem addButton = new JMenuItem("Add");
    private JMenuItem openButton = new JMenuItem("Open");
    private JMenuItem searchButton = new JMenuItem("Find");
    private JMenuItem deleteButton = new JMenuItem("Delete");

    public Controller controller;

    public MenuBar(Controller controller, PageView pageView) {
        super();
        this.controller = controller;
        JMenu mainMenu = new JMenu("File");
        mainMenu.add(saveButton);
        mainMenu.add(addButton);
        mainMenu.add(searchButton);
        mainMenu.add(openButton);
        mainMenu.add(deleteButton);
        add(mainMenu);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddStudent(controller, pageView);

            }
        });

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileOpen = new JFileChooser();
                int ret = fileOpen.showDialog(null, "Open File");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileOpen.getSelectedFile();
                    controller.openFileToAddStudent(file);
                    pageView.updateRecords();

                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.save();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchStudent(controller).setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteStudent(controller, pageView).setVisible(true);
            }
        });
    }


}
