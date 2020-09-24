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
public class Atividade2EDEx4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista=new Lista();
        Livro l;
        int pos;
        int opc=0;
        while(opc!=9){
            opc=Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n1-Adiciona Inicio\n2-Adiciona Final\n3-Adiciona em uma posição específica\n"
            + "4-Remove Final\n5-Remove Início\n6-Remove de uma posição específica\n7-Mostra Elementos\n9-Sair"));
            switch(opc){
                case 1:
                      l= new Livro();
                      l.setQtd(Integer.parseInt(JOptionPane.showInputDialog("Quantidade")));
                      l.setTitulo(JOptionPane.showInputDialog("Titulo"));
                      lista.AddInicio(l);
                        break;
                case 2:
                      l= new Livro();
                      l.setQtd(Integer.parseInt(JOptionPane.showInputDialog("Quantidade")));
                      l.setTitulo(JOptionPane.showInputDialog("Titulo"));
                      lista.AddFim(l);
                        break;
                case 3:
                        
                    break;
                case 4:
                     lista.RemoveFinal();
                     break;
                 case 5:
                     lista.RemoveInicio();
                        break;
                 case 6:
                    pos=Integer.parseInt(JOptionPane.showInputDialog("Informe a posição do vetor que você deseja remover"));
                    JOptionPane.showMessageDialog(null,"O elemento removido foi: "+lista.RemoveAny((int) pos));
                     break;
                 case 8:
                        l.mergeSort();
                        break;
                case 10:
                        lista.percorre();
                        break;
                
                        
                           
            case 9:
                JOptionPane.showMessageDialog(null,"Saindo");
                break;
            default:
                JOptionPane.showMessageDialog(null,"Opção inválida");
         }
        }
    }
    
}
