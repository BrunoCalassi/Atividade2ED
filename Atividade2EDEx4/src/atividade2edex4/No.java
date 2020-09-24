/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade2edex4;

/**
 *
 * @author bruno
 */
public class No {
    private Livro l;
    private No prox;

    public No(Livro l) {
        this.l = l;
        this.prox = null;
    }

    public Livro getL() {
        return l;
    }

    public void setL(Livro l) {
        this.l = l;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
