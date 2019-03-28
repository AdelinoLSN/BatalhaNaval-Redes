/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import model.Tabuleiro;

/**
 *
 * @author Adelino Neto
 */
public class Jogo {
    Tabuleiro principal;
    Tabuleiro clicavel;
    
    public Jogo(){
        this.principal = new Tabuleiro(false);
        this.clicavel = new Tabuleiro(true);
    }

    public Tabuleiro getPrincipal() {
        return principal;
    }

    public Tabuleiro getClicavel() {
        return clicavel;
    }
}
