package project1;

import javax.swing.*;

public class GeoCountDownTimerGUISwing {
    public static void main(String arg[]) {

        JMenu fileMenu;
        JMenuItem quitItem;
        JMenuBar menus;


        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        menus = new JMenuBar();


        menus.add(fileMenu);

        JFrame gui = new JFrame("GEO Count Down Timer");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GeoCountDownTimerMainSwing panel = new GeoCountDownTimerMainSwing(menus);


        gui.getContentPane().add(panel);


        gui.setSize(600, 400);
        gui.setJMenuBar(menus);
        gui.pack();
        gui.setVisible(true);
    }


}