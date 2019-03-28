package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adelino Neto
 */
public class MyRandom {
    
    public static int gerar(int i){
        double r = (Math.random()*i);
        int rand = (int) Math.floor(r);
        return rand;
    }
}
