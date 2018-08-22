
import javax.swing.JOptionPane;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author DiegoCS
 */
public class Main {
    
    public static void main(String[] args) {
        String exercicio=JOptionPane.showInputDialog("Exercício: "
                + "\n 1 - LE1_EX1"
                + "\n AL - ListaComArray"
                + "\n ALP - ListaComArrayProfessor"
                + "\n LE - ListaEncadeada"
                + "\n DL - DuasListas");
        
        switch (exercicio){
            case "1":
                new LE1_Ex1();
                break;
            case "AL":
                new ListaComArray().ListaComArrayTeste();
                break;
            case "ALP":
                new TesteLista();
                break;
                case "LE":
                new TesteListaEncadeada();
                break;
                    case "DL":
                new TesteDuasListas();
                break;
            default:
                JOptionPane.showMessageDialog(null,"Opcao Invalida:");
        }
        
    }
}
