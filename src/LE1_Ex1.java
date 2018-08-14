import javax.swing.JOptionPane;

/**
 *
 * @author DiegoCS
 */
public class LE1_Ex1 {
    
    public static void main(String[] args) {
        new LE1_Ex1();
    }
    
    public LE1_Ex1() {
        //Matriz 
        int[][]matriz={{7,45, 56, 58, 456, 476},{489, 490, 762, 922, 980, 1023},{1024, 1872, 1987, 2012, 2013, 2014},{2015, 3498, 3987, 8722, 8900, 9000},{9500, 9600, 9872, 9900, 9999, 10000},{10001, 35522, 72822, 92882, 97652, 100012}};
       //Inicializacao de mensagens
        String m="|6x6\t|1\t|2\t|3\t|4\t|5\t|6\t|";
        String retorno="";
        String posicaoSeInserir="";
        //Coleta a entrada
        String valor=JOptionPane.showInputDialog("Insira um valor para descobrir qual a sua posicao na matriz:");
        
        //Soluçao Quadrática
        //Para cada linha
        for (int i=0;i<6;i++){
            m=m+"\n|"+Integer.toString(i+1)+"\t|";
            //Para cada coluna
            for (int j=0;j<6;j++){
                m=m+""+matriz[i][j]+"\t|";
                //se valor nao for vazio e estiver na matriz
                if (!"".equals(valor) && Integer.parseInt(valor) == matriz[i][j]){
                    retorno = "O valor "+valor+" esta na posicao "+Integer.toString(i+1)+"x"+Integer.toString(j+1);
                }
                /**
                 * Requisito nao funcional:INICIO
                 */
                //se valor nao for vazio e for maior  que o valor na posicao analisada
                if (!"".equals(valor) && Integer.parseInt(valor) > matriz[i][j]){
                    //se o valor for menor que o proximo
                    if ((j==5 && i!=5 && Integer.parseInt(valor) < matriz[i+1][0])){
                        posicaoSeInserir = Integer.toString(i+2)+"x"+Integer.toString(1);
                    }
                    if ((j<5 && Integer.parseInt(valor) < matriz[i][j+1])){
                     posicaoSeInserir = Integer.toString(i+1)+"x"+Integer.toString(j+2);
                    }
                     if (i==5 && j==5){
                     posicaoSeInserir = "nula, uma vez que e maior que o ultimo valor da matriz";
                    }
                }
                /**
                 * Requisito nao funcional:FIM
                 */
            }
            //Solução Linear
                    if (matriz[i][5]<=Integer.parseInt(valor)){
             for (int j=0;j<6;j++){
                if (matriz[i][j]==Integer.parseInt(valor)){
                     retorno = "O valor "+valor+" esta na posicao "+Integer.toString(i+1)+"x"+Integer.toString(j+1);
                }
            }
        }
        }

        
        //lanca a matriz no log
        System.out.println(m);
       //monta a mensagem de saida
        if ("".equals(retorno)){
            retorno="O valor "+valor+" nao esta na matriz";
            if (!"".equals(posicaoSeInserir)){
                retorno=retorno+". Porem, se fosse inserido, ficaria na posicao "+posicaoSeInserir;
            }
        }
         //Apresenta a mensagem
        JOptionPane.showMessageDialog(null, retorno+".");
    } 
//Matriz
//|6x6	|1	|2	|3	|4	|5	|6	|
//|1	|7	|45	|56	|58	|456	|476	|
//|2	|489	|490	|762	|922	|980	|1023	|
//|3	|1024	|1872	|1987	|2012	|2013	|2014	|
//|4	|2015	|3498	|3987	|8722	|8900	|9000	|
//|5	|9500	|9600	|9872	|9900	|9999	|10000	|
//|6	|10001	|35522	|72822	|92882	|97652	|100012	|
    
    
    //Ex2.
    //1+1+(n*(n*(1+1)))+1
    //2+(n*2n)+1
    //f(n)=3+2n²
    
}
