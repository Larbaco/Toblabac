/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.TobLaba;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Desk
 */
public class KeyboardHook extends Thread {

    public static boolean executa = true;
    private static GlobalKeyboardHook keyboardHook;
    static Instant start = Instant.now();
    static Instant end;

    private static void iniciaKeyboardHook() throws AWTException {
        Robo robo = new Robo();
        keyboardHook = new GlobalKeyboardHook();

        System.out.println("Hook Inicialized.");
        keyboardHook.addKeyListener(
                new GlobalKeyAdapter() {
                    @Override
                    public void keyPressed(GlobalKeyEvent event
                    ) {
                        //System.out.println(event);
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
                            System.out.println("ESC");
                            System.out.println("Panic Key!");
                            TobLaba.Panic();

                            //executa = false;
                        }/*
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_NUMPAD1) {
                    System.out.println("1");
                    for (int i = 0; i < 3; i++) {

                        robo.type(GlobalKeyEvent.VK_5, 0);
                        robo.delay(1930);
                        robo.type(GlobalKeyEvent.VK_6, 0);
                        robo.delay(1230);
                        robo.type(GlobalKeyEvent.VK_7, 0);
                        robo.delay(1230);
                        robo.type(GlobalKeyEvent.VK_8, 0);
                        robo.delay(1060);
                        robo.type(GlobalKeyEvent.VK_9, 0);
                        robo.delay(1630);

                    }

                    // robo.type("Ola mundo");
                }
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_NUMPAD2) {
                    System.out.println(GlobalKeyEvent.VK_RETURN);
                    robo.type(KeyEvent.VK_ENTER, 0);
                    robo.type("O will e um viadao");
                    robo.type(KeyEvent.VK_ENTER, 0);

                }
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_NUMPAD3) {
                    System.out.println("3");

                }
                */
                        if (event.getVirtualKeyCode() == KeyEvent.VK_PAGE_DOWN) {
                            System.out.println("Page Down");
                            System.out.println("Macro Pot");
                            TobLaba.tooglePot();
                        }
                        if (event.getVirtualKeyCode() == KeyEvent.VK_PAGE_UP) {
                            System.out.println("Page Up");
                            System.out.println("Macro Custom");
                            TobLaba.toogleCustom();
                        }
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_END) {
                            System.out.println("End");
                        }
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_HOME) {
                            System.out.println("Home");
                            System.out.println("Ativando quebra");
                            TobLaba.toogleQuebra();
                        }
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_DELETE) {
                            System.out.println("Delete");
                        }
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_INSERT) {
                            System.out.println("Insert");
                            robo.type(KeyEvent.VK_ENTER, 0);
                            robo.type("O will e um viadao");
                            robo.type(KeyEvent.VK_ENTER, 0);
                        }
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_F9) {
                            System.out.println("Macro BM2");
                            TobLaba.toogleBM2();
                        }
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_F10) {
                            System.out.println("Macro BM3");
                            TobLaba.toogleBM3();
                        }
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_F11) {
                            System.out.println("Bot S1");
                            //TobLaba.toogleBot();
                        }
                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_F12) {
                            System.out.println("F12");
                            TobLaba.fechar();
                        }

                        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_0) {
                            end = Instant.now();
                            Duration timeElapsed = Duration.between(start, end);
                            System.out.println(timeElapsed);
                            start = end;
                        }
                    }

                    @Override
                    public void keyReleased(GlobalKeyEvent event
                    ) {
                        //System.out.println(event);
                    }
                }
        );

        try {
            while (executa) {
                Thread.sleep(128);
            }
        } catch (InterruptedException e) {
            /* nothing to do here */
        } finally {
            keyboardHook.shutdownHook();
        }
    }

    public static void panic() {
        keyboardHook.shutdownHook();
    }

    @Override
    public void run() {
        try {
            iniciaKeyboardHook();
        } catch (AWTException ex) {
            Logger.getLogger(KeyboardHook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
