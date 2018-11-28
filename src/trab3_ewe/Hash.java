package trab3.ewe;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author ejust
 */
public class Hash
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MapaDispersao<String, Veiculo> mp = new MapaDispersao(10000);

        // geração dos dados
        String nome, placa, modelo;
        int ano;

        for (int i = 0; i < 5000; i++)
        {
            nome = GeradorAleatorio.geraNome() + " " + i;
            placa = GeradorAleatorio.geraPlaca();
            modelo = GeradorAleatorio.geraModelo();
            ano = GeradorAleatorio.geraAno();
            Veiculo v = new Veiculo(placa, modelo, ano, nome);

            mp.inserir(v.getPlaca(), v);
            System.out.println("número de colisões " + mp.verificaColisao(v.getPlaca()) + "\n");
        }

        mp.posicaoComMaisColisoes();
    }
}

class GeradorAleatorio
{

    private static Random geraNumero = new Random();
    private static String[] nomes =
    {
        "José", "Maria", "Pedro", "João", "Mario", "Paulo", "Paula", "Sandra", "André", "Carla"
    };
    private static String[] modelos =
    {
        "Gol", "Mobi", "Fox", "Fusca", "C3", "Captur", "i30", "Fiesta", "Fit", "Picanto"
    };

    private static int anoAtual = (new GregorianCalendar()).get(Calendar.YEAR);

    public static String geraNome()
    {
        return nomes[geraNumero.nextInt(10)];
    }

    public static String geraPlaca()
    {
        String placa = "";
        for (int i = 0; i < 3; i++)
        {
            placa += (char) (65 + geraNumero.nextInt(26));
        }
        placa += "-";
        for (int i = 0; i < 4; i++)
        {
            placa += (char) (48 + geraNumero.nextInt(10));
        }

        return placa;
    }

    public static String geraModelo()
    {
        return modelos[geraNumero.nextInt(10)];
    }

    public static int geraAno()
    {
        int redutor = geraNumero.nextInt(10);
        if (redutor > 8)
        {
            redutor = geraNumero.nextInt(60);
        } else
        {
            redutor = geraNumero.nextInt(20);
        }

        return anoAtual - redutor;
    }

}




