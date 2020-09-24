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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista=new Lista();
        int pos,e;
        int opc=0;
        while(opc!=9){
            opc=Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n1-Adiciona Inicio\n2-Adiciona Final\n3-Adiciona em uma posição específica\n"
            + "4-Remove Final\n5-Remove Início\n6-Remove de uma posição específica\n7-Mostra Elementos\n9-Sair"));
            switch(opc){
                case 1:
                      e=(Integer.parseInt(JOptionPane.showInputDialog("RA")));
                      lista.adicionaFinal(e);
                        break;
                case 2:
                      e=(Integer.parseInt(JOptionPane.showInputDialog("RA")));
                      lista.adicionaFinal(e);
                        break;
                case 3:
                      e=(Integer.parseInt(JOptionPane.showInputDialog("RA")));
                      pos=(Integer.parseInt(JOptionPane.showInputDialog("RA")));
                      lista.adicionaPosicao(e, pos);
                    break;
                case 4:
                     lista.removeFinal();
                     break;
                 case 5:
                    lista.removeInicio();
                    break;
                 case 6:
                    pos=Integer.parseInt(JOptionPane.showInputDialog("Informe a posição do vetor que você deseja remover"));
                    JOptionPane.showMessageDialog(null,"O elemento removido foi: "+lista.removePosicao(pos));
                     break;
                case 7:lista.percorre();
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
