package project1;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GeoCountDownTimerMainSwing extends JPanel implements ActionListener {

    private JMenuItem quitItem;

    public GeoCountDownTimerMainSwing(JMenuBar quitItem) {
        JPanel panel = new JPanel();
        panel.add(new GeoCountDownTimerPanelSwing());
        panel.add(new GeoCountDownTimerPanelSwing());
        panel.add(new GeoCountDownTimerPanelSwing());

        quitItem.getMenu(0).getItem(0).addActionListener(new myListener());
        panel.add(quitItem);
        add(panel);
        add(panel);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == quitItem) {
            System.exit(1);
        }
    }

    private class myListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(1);
        }
    }


}