import javax.swing.JOptionPane;

/**
 *
 * @author DiegoCS
 */
public class Main {
    
    public static void main(String[] args) {
        String exercicio=JOptionPane.showInputDialog("Exercício: "
                + "\n L - LE1_EX1"
                + "\n AL - ListaComArray"
                + "\n ALP - ListaComArrayProfessor"
                + "\n LE - ListaEncadeada"
                + "\n DL - DuasListas");
        
        switch (exercicio.toUpperCase()){
            case "L":
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