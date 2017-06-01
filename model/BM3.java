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
public class BM3 {

    private int AABA;
    private int ABAA;
    private int BAAB;
    private int BBAB;
    private int delay;
    private int Fatal1;
    private int Fatal2;
    private int Fatal3;

    public BM3(int classe, int AABA, int ABAA, int BAAB, int BBAB) {
        this.AABA = AABA;
        this.ABAA = ABAA;
        this.BAAB = BAAB;
        this.BBAB = BBAB;
        switch (classe) {
            case 1:                //MA
                delay = 1205;
                Fatal1 = 2005;
                Fatal2 = 1805;
                Fatal3 = 1705;
                break;
            case 2:                //DU
                delay = 1205;
                Fatal1 = 2005;
                Fatal2 = 1805;
                Fatal3 = 1705;
                break;
            case 3:                //EA
                delay = 1205;
                Fatal1 = 2005;
                Fatal2 = 1805;
                Fatal3 = 1705;
                break;
            case 4:                //GU
                delay = 1305;
                Fatal1 = 2005;
                Fatal2 = 1805;
                Fatal3 = 1705;
                break;
            case 5:                //AA
                delay = 1305;
                Fatal1 = 2005;
                Fatal2 = 1805;
                Fatal3 = 1705;
                break;
            case 6:                //GA
                delay = 1205;
                Fatal1 = 2005;
                Fatal2 = 1805;
                Fatal3 = 1705;
                break;
            case 7:                //GL
                delay = 1205;
                Fatal1 = 2005;
                Fatal2 = 1805;
                Fatal3 = 1705;
                break;
            default:
                break;
        }
    }

    public String getBM3(int Fatal) {
        //System.out.println("GetBM3: "+AABA+ABAA+BAAB+BBAB+Fatal);
        String saida = "";
        saida += getAABA(AABA)
                + getABAA(ABAA)
                + getBAAB(BAAB)
                + getBBAB(BBAB);
        if (Fatal > 0) {
            saida += "3.{wait" + Fatal1 + "}.";
            if (Fatal > 1) {
                saida += "3.{wait" + Fatal2 + "}.";
                if (Fatal == 3) {
                    saida += "3.{wait" + Fatal3 + "}.";
                }
            }
        }
        //System.out.print("  Saida: "+saida);
        return saida;
    }

    public void setAABA(int AABA) {
        this.AABA = AABA;
    }

    public void setABAA(int ABAA) {
        this.ABAA = ABAA;
    }

    public void setBAAB(int BAAB) {
        this.BAAB = BAAB;
    }

    public void setBBAB(int BBAB) {
        this.BBAB = BBAB;
    }

    public String getAABA(int vezes) {
        //System.out.println("AABA"+vezes+delay);
        String comando = "";
        while (vezes > 0) {
            comando += "1." + "{wait" + delay + "}" + ".1." + "{wait" + delay + "}" + ".2." + "{wait" + delay + "}" + ".1."+ "{wait" + delay + "}.";
            vezes--;
        }
        //System.out.println(comando);
        return comando;
    }

    public String getABAA(int vezes) {
        //System.out.print("ABAA");
        String comando = "";
        while (vezes > 0) {
            comando += "1." + "{wait" + delay + "}" + ".2." + "{wait" + delay + "}" + ".1." + "{wait" + delay + "}" + ".1."+ "{wait" + delay + "}.";
            vezes--;
        }
        return comando;
    }

    public String getBAAB(int vezes) {
        //System.out.print("BAAB");
        String comando = "";
        while (vezes > 0) {
            comando += "2." + "{wait" + delay + "}" + ".1." + "{wait" + delay + "}" + ".1." + "{wait" + delay + "}" + ".2."+ "{wait" + delay + "}.";
            vezes--;
        }
        return comando;
    }

    public String getBBAB(int vezes) {
        //System.out.print("BBAB");
        String comando = "";
        while (vezes > 0) {
            comando += "2." + "{wait" + delay + "}" + ".2." + "{wait" + delay + "}" + ".1." + "{wait" + delay + "}" + ".2."+ "{wait" + delay + "}.";
            vezes--;
        }
        return comando;
    }

}
