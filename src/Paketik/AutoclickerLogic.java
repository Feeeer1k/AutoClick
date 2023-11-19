package Paketik;

import java.awt.*;
import java.awt.event.InputEvent;

public class AutoclickerLogick {

    public static void autoClicker() throws AWTException {
        wait(3000);
       //while (true) {
            mouseClick();
            wait(3000);
        }
   // }

    public static void wait(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mouseClick() throws AWTException {
        Robot govnoed = new Robot();
        govnoed.mousePress(InputEvent.BUTTON1_MASK);
        govnoed.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}









