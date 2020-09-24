/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Lista {
    private No prim;
    private Aluno a;
    public Lista(){
		prim=null;
	}
    public void adicionaFinal(int e){
	if (prim==null){
			No n=new No(e);
			prim=n;
		}
	else{
		No aux=prim;
		recursividadeAdicionaFinal(aux);
		No n=new No(e);
		aux.prox=n;
	}
    }
    public void adicionaInicio(int e){
	No n=new No(e);
	n.prox=prim;
	prim=n;
    }
    public int removeFinal(){
	int r=-1;
	if (prim==null){
		System.out.println("Lista Vázia");
	}
	else{
		if (prim.prox==null){
			r=prim.dado;
			prim=null;
		}
		else{
			No aux=prim;
			No aux2=prim;
			recursivaRemoveFinal(aux, aux2);
			r=aux.dado;
			aux2.prox=null;
		}
	}
	return r;
	}
      public void adicionaPosicao(int e, int pos){
        No novo= new No(e);
        if(pos==1){       
            adicionaInicio(e);
        }else{       
            No aux=prim;
            int count=1;
            recursivaAdicionaPosicao(aux, count, pos);
            if(count==pos-1){  
                novo.prox=aux.prox;
                aux.prox=novo;
            }else{
                System.out.println("Posição Inválida!");
            }            
        }
    }
    public int removePosicao(int pos){
        int e=-1;
        int i=1;
        No aux=prim;
        if(prim==null){
	           System.out.println("Lista Vazia!");
	           return e;
	       }    
	       if(pos==1){
	           e=removeInicio();
	           return e;
	       }else{           
	           while(aux.prox!=null){
	               aux=aux.prox;
	               i++;
	           }
	           if(pos>i || pos==0){
	               System.out.println("Posição Invalida!");
	               return e;
	           }else if(pos==i){
	               e=removeFinal();
	               return e;
	           }else{
	               aux=prim;
	               No aux2=aux;
                       aux2.prox = recursivaRemovePosicao(pos, aux, aux2);
	                e=aux.dado;
	                return e;
	            }
	        }        
	    }
    public int removeInicio(){
	int r=-1;
	if (prim==null){
		JOptionPane.showMessageDialog(null,"Lista Vázia");
	}
	else{
		r=prim.dado;
		prim=prim.prox;
	}
	return r;
    }
    public String percorre(){
	No aux=prim;
	String r=" ";
	while(aux!=null){
		r=r+"\n"+aux.dado;
		aux=aux.prox; 
	}
	return r;
        }
    
    public No recursivaRemovePosicao(int pos, No aux, No aux2) {		
		if (pos==1) {
			return aux.prox;
		}
	return recursivaRemovePosicao((pos-1), aux.prox, aux);
}
    private No recursividadeAdicionaFinal(No aux){
         if(aux.prox==null){
            return aux;
	}
         return recursividadeAdicionaFinal(aux.prox);
    }
    private No recursivaRemoveFinal(No aux, No aux2){
        if(aux.prox==null){
                aux2=aux;
                return aux;
           }
         return recursivaRemoveFinal( aux.prox,  aux2);
    }
    private No recursivaAdicionaPosicao(No aux,int count,int pos){
        if(aux.prox==null && count==pos-1){
                return aux;
            }
        return recursivaAdicionaPosicao(aux.prox,count+1, pos);
    }
    
}
