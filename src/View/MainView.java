package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by horbachevsky on 28.04.2016.
 */
public class MainView {

    private JFrame jFrame;

    private PageView pageView;
    Controller controller;

    public MainView(Controller controller) {
        jFrame = new JFrame("Table of students");
        jFrame.setDefaultLookAndFeelDecorated(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(800, 600);
        jFrame.setDefaultLookAndFeelDecorated(true);


        this.controller = controller;
        pageView = new PageView(controller, 0);

        jFrame.setJMenuBar(new MenuBar(controller, pageView));


        jFrame.add(pageView);
        jFrame.setVisible(true);


    }
}
