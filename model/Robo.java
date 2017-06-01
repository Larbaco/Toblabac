package model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * A Java Robot example class.
 *
 * Caution: Using the Java Robot class improperly can cause a lot of system
 * problems. I had to reboot my Mac ~10 times yesterday while trying to debug
 * this code.
 *
 * I created this class to demonstrate the Java Robot class on a Mac OS X
 * system, though it should run on Linux or Windows as well.
 *
 * On a Mac system, I place the TextEdit text editor in the upper-left corner of
 * the screen, and put a bunch of blank lines in the editor. Then I run this
 * Java Robot example from Eclipse or the Unix command line.
 *
 * It types the three strings shown in the code below into the text editor.
 *
 * Many thanks to the people on the Mac Java-dev mailing list for your help.
 *
 * @author Alvin Alexander,
 * <a href="http://devdaily.com" title="http://devdaily.com">http://devdaily.com</a>
 *
 */
public class Robo {

    Robot robot = new Robot();

    public Robo() throws AWTException {
        /**
         * *
         * robot.setAutoDelay(40); robot.setAutoWaitForIdle(true);
         *
         * robot.delay(4000); robot.mouseMove(40, 130); robot.delay(500);
         *
         * leftClick(); robot.delay(500); leftClick();
         *
         * robot.delay(500); type("Hello, world");
         *
         * robot.mouseMove(40, 160); robot.delay(500);
         *
         * leftClick(); robot.delay(500); leftClick();
         *
         * robot.delay(500); type("This is a test of the Java Robot class");
         *
         * robot.delay(50); type(KeyEvent.VK_DOWN);
         *
         * robot.delay(250); type("Four score and seven years ago, our fathers
         * ...");
         *
         * robot.delay(1000); System.exit(0); **
         */
    }

    public void delay(int ms) {
        robot.delay(ms);
    }

    public void leftClick() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(10);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //robot.delay(10);
    }

    public void rigthClick(int ms) {
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(ms);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        //robot.delay(ms);
    }

    public void rigthClick() {
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(10);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        //robot.delay(10);
    }

    public void arrastaDireito(int x1, int y1, int x2, int y2) throws InterruptedException {
        robot.delay(50);
        robot.mouseMove(x1, y1);
        robot.delay(50);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(50);
        robot.mouseMove(x2,y2);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(50);
    }

    public void arrastaEsquerdo(int x1, int y1, int x2, int y2) {
        robot.delay(50);
        robot.mouseMove(x1, y1);
        robot.delay(50);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseMove(x2, y2);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
    }

    public void moveMouse(int x, int y) {
        robot.mouseMove(x, y);
    }

    public void leftClick(int ms) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(ms);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //robot.delay(ms);
    }

    public void type(int i) {
        robot.delay(40);
        robot.keyPress(i);
        robot.keyRelease(i);
    }

    public void type(int i, int ms) {
        robot.keyPress(i);
        robot.delay(ms);
        robot.keyRelease(i);
    }

    public void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) {
                code = code - 32;
            }
            robot.delay(5);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
        robot.delay(100);
    }

    // 
    void leftDown() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

    void leftUp() {
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

}
