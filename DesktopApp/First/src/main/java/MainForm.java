import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel myPanel;
    private JButton collaps;
    private JTextField surName;
    private JTextField name;
    private JTextField middleName;

    public MainForm(){
        collaps.addActionListener(new Action() {
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
            String surNameValue = surName.getText().trim();
            String nameValue = name.getText().trim();
            String middleNameValue = middleName.getText().trim();
            if (surNameValue.length() == 0 || nameValue.length() == 0){
                JOptionPane.showMessageDialog(
                        myPanel,
                        "Обязательные поля не заполнены. Пожалуйста заполните Фамилию и Имя.",
                        "Не заполнены обязательные поля!",
                        JOptionPane.ERROR_MESSAGE

                );

            } else {
                String result = surNameValue + " " + nameValue + " " + middleNameValue;
                JFrame frame = new JFrame();
                frame.setSize(600, 400);
                frame.add(new FormTwo(result).getPanelTwo());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
            }
        });
    }

    public JTextField getSurName() {
        return surName;
    }

    public JTextField getName() {
        return name;
    }

    public JTextField getMiddleName() {
        return middleName;
    }

    public JPanel getMyPanel(){
        return myPanel;
    }
}
