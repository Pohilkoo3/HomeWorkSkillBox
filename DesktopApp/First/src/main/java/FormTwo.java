import javax.swing.*;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;


public class FormTwo {
    private JPanel panelTwo;
    private JButton expand;
    private JTextArea mappingFIO;

    public FormTwo(String resultFormOne){
        mappingFIO.setText(resultFormOne);
        expand.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = mappingFIO.getText();
                String[] splitText = text.split(" ");
                JFrame frame = new JFrame();
                frame.setSize(600, 400);
                MainForm mainForm = new MainForm();
                JPanel jPanel = mainForm.getMyPanel();
                mainForm.getSurName().setText(splitText[0]);
                mainForm.getName().setText(splitText[1]);
                mainForm.getMiddleName().setText(splitText.length == 3? splitText[2] : "");
                frame.add(jPanel);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);

            }
        });
    }

    public JPanel getPanelTwo(){
        return panelTwo;
    }
}
