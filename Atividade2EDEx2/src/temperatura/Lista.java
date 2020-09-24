/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatura;

/**
 *
 * @author bruno
 */
public class Lista {
    private double dados[];
    private int tamanho;
    public Lista(){
    dados=new double [5];
    tamanho=0;
    }
    public void AdicionaFinal(double e){
        if (tamanho<dados.length){
            dados[tamanho]=e;
            tamanho++;
        }
        else{
            System.out.println("Lista Cheia");
        }
    }
    public void AdicionaInicio(double e){
        if (tamanho<dados.length){
            int i=tamanho;
            recursivaAdicionaInicio(e,i);
        dados[0]=e;
        tamanho++;
        }
        else{
            System.out.println("Erro, lista cheia");
        }
    }
    public void AdicionaQualquerPosicao(double e, int pos){
        int i=tamanho;
        if ((tamanho<dados.length)&&(pos<tamanho+1)&&(pos>=0)){
            recursivaAdicionaPosicao(pos, i);
         dados[i]=e;
        tamanho++;
        }
    }
    public double RemoveFinal(){
        double retorno = 0;
        int i;
        if (tamanho>=1){
            retorno=dados[tamanho-1];
            i=0;
            recursivaRemoveFinal(i);
            
        }           
            return retorno;
        }
    public double RemoveInicio(){
        double retorno = 0;
        int i;
        if (tamanho>=1){
            retorno=dados[0];
            i=1;
            recursivaRemoveInicio(i);
                tamanho--;
        }
    return retorno;
    }
    public double RemoveQualquerPosicao(int pos){
        int i = 0;
        double retorno=0;
        if ((pos<tamanho)&&(pos>=0)&&(tamanho>=1)){
            i=pos;
            retorno=dados[pos];
            recursivaRemovePosicao(i, pos);
            tamanho--;
        }
        return retorno;
        }
    public  void verifica(){
        if(tamanho==0){
            System.out.println("Lista Vazia");
        }else if(tamanho>=dados.length){
            System.out.println("Lista Cheia");
        }else{
            System.out.println("Lista parcialmente preenchida");
        }
            
    }
    public String percorre(){
    String aux=" ";
    for (int i=0;i<tamanho;i++){
        aux=aux+"\n"+dados[i]+"°C";
    }
        return aux;
    }
    
    private double recursivaAdicionaInicio(double e, int i){
        if(i==1){
            dados[i]=dados[i-1];
            return e;
        }
        
        return recursivaAdicionaInicio(e,(i-1)); 
    }
    
    private double recursivaAdicionaPosicao(int pos, int i){
                if(i==1){
                    dados[i]=dados[i-1];
                    return i;
                }if(i==pos){
                    dados[i]=dados[i-1];
                    return i;
                }if(i==0){
                    return i;
                }
        return recursivaAdicionaPosicao(pos,(i-1)); 
    }
    private double recursivaRemoveFinal(int i){
                if (i!=tamanho-1){
                    tamanho--;
                    return tamanho;
                }
        return recursivaRemoveFinal(i+1); 
    }
    private double recursivaRemoveInicio(int i){
                if(i<=tamanho){
                dados[i-1]=dados[i];
                return i;
            }
        return recursivaRemoveInicio(i+1); 
    }
    private double recursivaRemovePosicao(int i, int pos){
                dados[i]=dados[i+1];
                if(i<tamanho-1){ 
                return i;
            }
        return recursivaRemovePosicao((i+1),pos); 
    }
}
 