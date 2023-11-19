package Paketik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//хуйня хужна для выбора разный кнопок
class ClickChech {
    private static boolean boolValue;

    public static boolean getboolValue() {
        return boolValue;

    }

    public static void setValue(boolean newboolValue) {
        boolValue = newboolValue;
    }
}
        //хуйня нужна для задержки
class Config {
    private static int value; // Статическое поле для хранения значения

    public static int getValue() {
        return value;
    }

    public static void setValue(int newValue) {
        value = newValue;
    }
}

public class GUI extends JFrame {
    //насрал кнопками
    private JButton button = new JButton("Вкл");
    private JButton button2 = new JButton("Выкл");
    private JLabel label = new JLabel("интервал кликов(мс)");
    private JCheckBox waitingClick = new JCheckBox("Задержка в 1с перед началом работы");
    private JTextField fieldDelay = new JTextField();
    private JCheckBox LCM = new JCheckBox("LCM");
    private JCheckBox PCM = new JCheckBox("PCM");
    private JCheckBox SCM = new JCheckBox("SCM");


    //Логика окна( размеры кнопки и т.д)
    public GUI() {
        super("Autoclicker");

        this.setBounds(100, 100, 450, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 8, 5, 5));
        container.add(label);
        container.add(fieldDelay);
        container.add(waitingClick);

        //листенер лкм
        LCM.addActionListener(new LcmEventList());
        container.add(LCM);

        //ты еблан, если не понял, чек выше
        PCM.addActionListener(new PcmEventList());
        container.add(PCM);

        //ты еблан, если не понял, чек ещё выше
        SCM.addActionListener(new ScClickEventList());
        container.add(SCM);


        button.addActionListener(new ButtonEventList());

        container.add(button);
        
        button.setIcon(new ImageIcon("D:\\кнопка.png"));
        button.setRolloverIcon(new ImageIcon("D:\\кнопкаRes.png"));

        //отключение ебучей обводки
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
       // container.setBackground(Color.BLACK);

    }

    //Класс евента нажатия Вкл кнопки
    class ButtonEventList implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int delay = Integer.parseInt(fieldDelay.getText());
                Config.setValue(delay);

                if (LCM.isSelected()) {
                    AutoclickerLogic.autoLeftClicker();
                }
                if (PCM.isSelected()) {
                    AutoclickerLogic.autoRightClick();
                }
                if (SCM.isSelected()){
                    AutoclickerLogic.autoScrollClicker();
                }

            } catch (NumberFormatException ex) {
                System.out.println("Ошибка при получении значения из поля");
            } catch (AWTException ex) {
                throw new RuntimeException(ex);

         }
     }
 }

    //выбор лкм лист
    class LcmEventList implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            boolean check = LCM.isSelected();
            ClickChech.setValue(check);
        }
    }

    class PcmEventList implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean check1 = PCM.isSelected();
            ClickChech.setValue(check1);

        }
    }
    /* ебашит крч сетер  */
    class ScClickEventList implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean check2 = SCM.isSelected();
            ClickChech.setValue(check2);
        }
    }


}





