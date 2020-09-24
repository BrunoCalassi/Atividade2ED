/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade2edex4;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Lista {
    private No prim;
    private No ult;
    private int tamanho;

    public Lista() {
        this.prim = null;
        this.ult = null;
        this.tamanho = 0;
    }

    public No getPrim() {
        return prim;
    }

    public void setPrim(No prim) {
        this.prim = prim;
    }

    public No getUlt() {
        return ult;
    }

    public void setUlt(No ult) {
        this.ult = ult;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int qtd) {
        this.tamanho = qtd;
    }

    public void AddInicio(Livro l){
        No no =new No(l);
        if (this.verifica()) {
            this.ult=no;
        }
        no.setProx(this.prim);
        this.prim=no;
        this.tamanho++;
       
    }
    
    public boolean verifica(){
        return(this.prim==null);
    }
    
    public void AddFim(Livro l){
        No no =new No(l);
        if(this.verifica()){
            this.prim=no;
        }else{
            this.ult.setProx(no);
        }
        this.ult=no;
        this.tamanho++;
    }
    
    public boolean RemoveAny(int pos){
        No atual=this.prim;
        No ant=null;
        if(this.verifica()){
            System.out.println("lista vazia");
            return false;
        }else{
            recursivaRemoveAny(atual, ant, pos);
           if(atual ==this.prim){
               if (this.prim==this.ult) {
                   this.ult=null;
               }
               this.prim=this.prim.getProx();
           }else{
               if (atual==this.ult) {
                   this.ult=ant;
               }
               ant.setProx(atual.getProx());
           } 
           this.tamanho--;
        }
        return true;
    }
    
    public int RemoveInicio(){
		int r=-1;
		if (verifica()){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}
		else{
			r=prim.getL().getQtd();
			prim=prim.getProx();
		}
		return r;
	}
    
    public int RemoveFinal(){
		int r=-1;
		if (verifica()){
			System.out.println("Lista Vázia");
		}
		else{
			if (prim.getProx()==null){
				r=prim.getL().getQtd();
				prim=null;
			}
			else{
				No aux1=prim;
				No aux2=this.getPrim();
                                 int i=0;
				recursivaRemoveFinal(i);

				r=prim.getL().getQtd();
				aux2.setProx(null);
			}
		}
		return r;
	}
    
    
    public void escolhePosicao(Livro a, int pos){
	        No no= new No(a);

	        if(pos==1){            
	            AddInicio(a);
	        }else{       
	            No aux=prim;
	            int count=1;
	            
	            while(aux.getProx()!=null && count<pos-1){
	                aux=aux.getProx();
	                tamanho++;
	            }
	            
	            if(count==pos-1){  
	                no.setProx(aux.getProx());
	                aux.setProx(no);
	            }else{
	                System.out.println("Posição Inválida!");
	            }            
	        }
	    }
    public String percorre(){
    String  msg=" ";
    No atual =prim;
    if(this.verifica()){
    msg="Lista Vazia";
    }
    while(atual !=null){
    msg=msg+"\n"+ atual.getL().getQtd() + " " + atual.getL().getTitulo()+ "--->";
    atual=atual.getProx();
    }
    return msg;
    }
    
   public void mergeSort(int v[], int ini, int fim){
   if (ini < fim){
      int meio = (ini+fim)/2;
      mergeSort (v,ini, meio);
      mergeSort (v,meio+1, fim);
      mescla(v, ini, meio, meio+1,fim);
   }
   }
   public void mescla(int v[], int iA, int fA, int iB, int fB){

    int aux[]=new int[fB-iA+1], ini=iA, iaux=0;
    
    while (iA<=fA && iB<=fB){
       if (v[iA] < v[iB]){
          aux[iaux]=v[iA];
          iA++;
       } else {
          aux[iaux]=v[iB];
          iB++;
       }
       iaux++;
    }
    while (iA<=fA){
          aux[iaux]=v[iA];
          iA++;
          iaux++;    
    }
    
    while (iB<=fB){
          aux[iaux]=v[iB];
          iB++;
          iaux++;    
    }
    iaux=0;
    for (int i=ini; i<=fB;iaux++,i++){
      v[i]=aux[iaux];
    }
}
   private double recursivaRemoveFinal(int i){
                if (i!=tamanho-1){
                    tamanho--;
                    return tamanho;
                }
        return recursivaRemoveFinal(i+1); 
    }
   
   private No recursivaRemoveAny(No atual,No ant, int pos){
            if(atual==null && this.tamanho==pos-1){
                ant=atual;
                atual=atual.getProx();
                return atual;
            }
       tamanho++;
        return recursivaRemoveAny(atual, ant, pos); 
    }
   
   
}

