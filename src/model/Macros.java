/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.TobLaba;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desk
 */
public class Macros extends Thread {

    private final int id;
    private final Robo robo;
    private boolean run = false;
    private boolean alt = false;
    private boolean ctrl = false;
    private boolean caps = false;
    private boolean shift = false;
    public boolean gema = false;
    private String comandos;
    public int tempo = 1;

    @Override
    public void run() {
        try {
            inicia();
        } catch (InterruptedException | AWTException ex) {
            Logger.getLogger(Macros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Macros(int id, String cmd) throws AWTException {

        this.id = id;
        this.comandos = cmd;
        robo = new Robo();
    }

    public Macros(int id) throws AWTException {

        this.id = id;
        this.comandos = "";
        robo = new Robo();
    }

    public void setComandos(String comandos) {
        this.comandos = comandos;
    }

    private void inicia() throws InterruptedException, AWTException {
        switch (id) {
            case 1: //BM2
                while (true) {
                    if (run) {
                        robo.type(KeyEvent.VK_QUOTE);
                        robo.delay(100);
                        robo.leftClick();
                        robo.delay(100);
                        robo.type(KeyEvent.VK_1);
                        robo.delay(100);
                    } else {
                        robo.delay(5000);
                    }
                }
            case 2:  //BM3
                while (true) {
                    if (run) {
                        robo.type(KeyEvent.VK_1);
                        robo.delay(1200);
                        robo.type(KeyEvent.VK_2);
                        robo.delay(1200);
                        robo.type(KeyEvent.VK_1);
                        robo.delay(1200);
                        robo.type(KeyEvent.VK_2);
                        robo.delay(1200);
                        robo.type(KeyEvent.VK_1);
                        robo.delay(1200);
                        robo.type(KeyEvent.VK_2);
                        robo.delay(1200);
                        robo.type(KeyEvent.VK_1);
                        robo.delay(1200);
                        robo.type(KeyEvent.VK_2);
                        robo.delay(1200);
                        robo.type(KeyEvent.VK_3);
                        robo.delay(2000);
                    } else {
                        robo.delay(5000);
                    }
                }
            case 3:  //Custom
                while (true) {
                    if (run) {
                        //System.out.println(comandos);
                        for (String cmd : comandos.split("\\.")) {

                            if (" ".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("z".equalsIgnoreCase(cmd)) {
                                robo.type(KeyEvent.VK_Z, 0);
                            } else if ("1".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("2".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("3".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("4".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("5".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("6".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("7".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("8".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("9".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("0".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("-".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else if ("=".equalsIgnoreCase(cmd)) {
                                robo.type(cmd.getBytes()[0], 0);
                            } else {

                                Integer tmp;
                                if (cmd.startsWith("wait", 1)) {
                                    String aux = cmd.substring(5, 9);
                                    //System.out.println("Isso aqui:" + aux);
                                    tmp = Integer.parseInt(aux);
                                    //System.out.println("E isso: " + tmp);
                                    robo.delay(tmp);
                                } else if (cmd.startsWith("sleep", 1)) {
                                    tmp = Integer.parseInt(cmd.substring(5, 9));
                                    robo.delay(tmp * 1000);
                                } else if (cmd.startsWith("alt", 1)) {
                                    if (!alt) {
                                        robo.robot.keyPress(KeyEvent.VK_ALT);
                                        alt = !alt;
                                    } else {
                                        robo.robot.keyRelease(KeyEvent.VK_ALT);
                                        alt = !alt;
                                    }
                                } else if (cmd.startsWith("ctrl", 1)) {
                                    if (!ctrl) {
                                        robo.robot.keyPress(KeyEvent.VK_CONTROL);
                                        ctrl = !ctrl;
                                    } else {
                                        robo.robot.keyRelease(KeyEvent.VK_CONTROL);
                                        ctrl = !ctrl;
                                    }
                                } else if (cmd.startsWith("shift", 1)) {
                                    if (!shift) {
                                        robo.robot.keyPress(KeyEvent.VK_SHIFT);
                                        shift = !shift;
                                    } else {
                                        robo.robot.keyRelease(KeyEvent.VK_SHIFT);
                                        shift = !shift;
                                    }
                                } else if (cmd.startsWith("caps", 1)) {
                                    if (!shift) {
                                        robo.robot.keyPress(KeyEvent.VK_CAPS_LOCK);
                                        caps = !caps;
                                    } else {
                                        robo.robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
                                        caps = !caps;
                                    }
                                }
                            }
                            if (!run) {
                                break;
                            }
                            //System.out.println(cmd);
                        }
                        //System.out.print(".");
                    } else {
                        robo.delay(5000);
                    }
                }
            case 4:  //Bot 
                while (true) {
                    if (run) {

                        int x = 640;
                        int y = 100;
                        System.out.println(tempo);
                        System.out.println(gema);
                        // Anda ate porta
                        robo.moveMouse(x, y);
                        robo.arrastaDireito(x, y, x + 240, y - 130);
                        //giraCamera(240, -130);
                        robo.delay(50);
                        //robo.moveMouse(x, y);
                        robo.delay(1000);
                        robo.leftDown();
                        robo.delay(20);
                        robo.arrastaDireito(x, y, x - 750, y + 200);
                        //giraCamera(-770, 200);
                        robo.moveMouse(640, 300);
                        robo.delay(2000);
                        robo.leftUp();
                        robo.delay(100);

                        if (gema) {
                            robo.moveMouse(780, 560);
                            robo.leftClick();

                        } else {
                            robo.moveMouse(680, 560);
                            robo.leftClick();
                        }
                        robo.delay(5000);

                        // Inicia
                        /*
                        robo.moveMouse(525, 525);
                        robo.leftClick();
                         */
                        // Anda Ate o Gluto
                        x = 837;
                        y = 115;

                        robo.moveMouse(x, y);
                        robo.delay(50);
                        robo.leftDown();
                        robo.delay(2000);

                        robo.arrastaDireito(x, y, x + 150, y);
                        robo.delay(6000);
                        //giraCamera(240, -130);
                        robo.leftUp();
                        robo.type(KeyEvent.VK_W, 1000);
                        robo.delay(100);
                        System.out.println("Iniciando");
                        TobLaba.custom.setRun(true);
                        for (int i = 0; i < tempo*60; i++) {
                            if (run) {
                                robo.delay(1000);
                            } else {
                                i=tempo;
                            }
                        }
                        TobLaba.custom.setRun(false);
                        System.out.println("Finalizado");

                        /*
                        //Robo robo2 = new Robo();
                        robo.moveMouse(x, y);
                        TimeUnit.MILLISECONDS.sleep(50);
                        robo.leftClick();
                        TimeUnit.MILLISECONDS.sleep(50);
                        //robo.moveMouse(x, y);
                        robo.moveMouse(640, 100);
                        TimeUnit.MILLISECONDS.sleep(50);
                        robo.leftDown();
                        TimeUnit.MILLISECONDS.sleep(20);
                        robo.arrastaDireito(800, 200, 30, 400);
                        TimeUnit.SECONDS.sleep(1);
                        robo.leftUp();
                        TimeUnit.SECONDS.sleep(2);
                        Macros farma = new Macros(3,".1.2.3.4.5.6.7.8.9.0. .z.{wait0100}");
                         */
                        //run = !run;
                    } else {
                        robo.delay(1000);
                    }
                }
            case 5:  //Pot
                while (true) {
                    if (run) {
                        robo.type(KeyEvent.VK_EQUALS);
                        robo.delay(200);
                    } else {
                        robo.delay(5000);
                    }
                }
            case 6:  //Quebras
                while (true) {
                    if (run) {
                        robo.arrastaDireito(840, 300, 1050, 170);
                        TimeUnit.MILLISECONDS.sleep(50);
                        robo.moveMouse(640, 100);
                        TimeUnit.MILLISECONDS.sleep(50);
                        robo.leftDown();
                        TimeUnit.MILLISECONDS.sleep(20);
                        robo.arrastaDireito(800, 200, 30, 400);
                        TimeUnit.SECONDS.sleep(1);
                        robo.leftUp();
                        TimeUnit.SECONDS.sleep(2);
                    } else {
                        robo.delay(5000);
                    }
                }
            default:
                break;
        }
    }

    public void setRun(boolean b) {
        //java.awt.Toolkit.getDefaultToolkit().beep();
        if(b) {
            Sound.beep(70000, 100);
        }else{
            Sound.beep(7000, 100);
        }
        run = b;
    }

    public boolean getRun() {
        return run;
    }

    private void giraCamera(int x, int y) throws InterruptedException {
        robo.delay(50);
        robo.moveMouse(640, 360);
        robo.delay(50);
        robo.arrastaDireito(640, 360, 640 + x, 360 + y);
        robo.delay(50);
        robo.moveMouse(640, 360);
        robo.delay(50);
        robo.leftClick();
        robo.delay(50);

    }
}
