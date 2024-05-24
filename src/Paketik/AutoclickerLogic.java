package Paketik;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AutoclickerLogic {


    public static void autoLeftClicker() throws AWTException {
        boolean chech = false;
        chech = ClickChech.getboolValue();
        int delay = Config.getValue();
        wait(1000);
        while (chech == true) {
            System.out.println("Left Клик");
            mouseLeftClick();
            wait(delay);
        }
    }

    public static void autoRightClick() throws AWTException {
        boolean check1 = ClickChech.getboolValue();
        int delay = Config.getValue();
        wait(1000);
        while (check1 == true) {
            System.out.println("Rigt Клик");
           mouseRightClick();
            wait(delay);
        }
    }

    public static void autoScrollClicker() throws AWTException {
        boolean check2 = ClickChech.getboolValue();
        int delay = Config.getValue();
        wait(1000);
        while (check2 == true) {
            System.out.println("Scroll Клик");
            mouseScrollClick();
            wait(delay);
        }
    }


    public static void wait(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mouseLeftClick() throws AWTException {
        Robot govnoed = new Robot();
        govnoed.mousePress(InputEvent.BUTTON1_MASK);
        govnoed.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void mouseRightClick() throws AWTException {
        Robot govnoed = new Robot();
        govnoed.mousePress(InputEvent.BUTTON2_MASK);
        govnoed.mouseRelease(InputEvent.BUTTON2_MASK);
    }

    public static void mouseScrollClick() throws AWTException {
        Robot govnoed = new Robot();
        govnoed.mousePress(InputEvent.BUTTON3_MASK);
        govnoed.mouseRelease(InputEvent.BUTTON3_MASK);
    }
}









