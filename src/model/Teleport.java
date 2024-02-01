/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Desk
 */


public class Teleport {
    
    private int x;
    private int y;
    private int tempo;

    public Teleport(int x, int y, int tempo) {
        this.x = x;
        this.y = y;
        this.tempo = tempo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTempo() {
        return tempo;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
        
    
}
