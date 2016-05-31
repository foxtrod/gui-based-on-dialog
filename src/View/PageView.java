package View;

import Controller.Controller;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PageView extends JPanel {

    private JButton startToTableButton = new JButton("Start");
    private JButton endToTableButton = new JButton("End");
    private JButton nextToTableButton = new JButton("Next");
    private JButton prevToTableButton = new JButton("Prev");

    private JLabel countOfRecordsLabel = new JLabel();

    private JTextField countTextField = new JTextField(4);
    private JButton confirmButton = new JButton("Oк");

    private Controller controller;

    public PageView(Controller controller, int count) {

        this.controller = controller;
        setLayout(new BorderLayout());
        JPanel nextAndPrevPanel = new JPanel(new FlowLayout());
        nextAndPrevPanel.add(endToTableButton);
        nextAndPrevPanel.add(prevToTableButton);
        nextAndPrevPanel.add(nextToTableButton);
        nextAndPrevPanel.add(startToTableButton);

        JPanel countPanel = new JPanel(new FlowLayout());
        JLabel countLabel = new JLabel("Number of tape");

        countPanel.add(countLabel);
        countPanel.add(countTextField);
        countPanel.add(confirmButton);

        add(nextAndPrevPanel, BorderLayout.SOUTH);
        add(countOfRecordsLabel, BorderLayout.NORTH);
        add(countPanel, BorderLayout.EAST);
        JTable myTab;
        if (count == 0) {
            myTab = new JTable(controller.openFileToAddStudent(new File("test.xml")));
            JScrollPane bookPane = new JScrollPane(myTab);
            add(bookPane);
            updateRecords();
        } else {
            myTab = new JTable(controller.returnModel());
            JScrollPane bookPane = new JScrollPane(myTab);
            add(bookPane);
        }
        initListeners(controller);
    }

    public void initListeners(Controller controller) {

        nextToTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.nextPage();
            }
        });

        prevToTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.prevPage();
            }
        });

        startToTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startPage();
            }
        });
        endToTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.endPage();

            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addCountPage(Integer.parseInt(countTextField.getText()));
            }
        });

    }

    public void updateRecords() {
        countOfRecordsLabel.setText(Integer.toString(controller.numberOfRecords()));
        this.revalidate();
        this.repaint();
    }
}
