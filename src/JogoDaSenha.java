package src;
import java.lang.Math; //Para importar o Random, função usada para gerar um número aleatório
import java.util.InputMismatchException; //Para importar a exceção, caso o usuário digite algo diferente de um inteiro
import java.util.Scanner; //Scanner, a bibloteca usada para pegar o input do teclado

//Obs: O código irá rodar caso o nome do arquivo.java seja "JogoDaSenha.java"

//Um jogo simples com uma lógica interessante por trás, lógica essa que gera 30 números aleatórios e únicos, e desafiando o usuário a adivinhar 5 desses números, contando quantas tentativas foram feitas, e quantos números foram acertados a cada tentativa

public class JogoDaSenha {

    public static int contadorLos = 0; //Contador de tentativas

    public static int count = 0;
    public static int esc[] = new int[5]; //Escolhas do Jogador

    public static int nums[] = new int[30]; //Números randomizados serão armazenados aqui
    public static String numsstr[] = new String[30]; //String da lista dos números randomizados, conforme pedido no enuncidado do projeto

    public static boolean venceu = false; //Verificador da vitória do jogo, finalizando o loop principal se o valor for "true"

    public static int quant = 0; //Contador de números que condizem com a escolha do Jogador

    public static Scanner scan = new Scanner(System.in); //Scanner, o sistema de input

    public int gerarRan(int contador) {

        count = 0;

        while (contador < 30) {

            int ran = (int) ((Math.random() * 100) + 1);//Gera um número aleatório entre 1 e 100 e armazena temporariamente na variável "ran"
            boolean existe = false; //Variável usada para verificar se o número aleatório já existe na lista
    
            for (int j : nums) { //Percorre a lista de números
                if (ran == j) {
                    existe = true; //Se o número gerado já existe na lista, ele quebra o loop, gerando outro número
                    break;
                }
            }
    
            if (!existe) {
                nums[contador] = ran; //Adiciona o número na lista caso ele seja único
                contador++;
            }
        }
        
            for (int i = 0; i < 30; i++) {
                numsstr[i] = Integer.toString(nums[i]); //Transforma os inteiros randomizados em uma String
            }
        
            return contador; // Retorna o valor de contador após o loop

        }
        

    public int fazerTentativa(int[] numeros, int[] escolhas, Scanner scan) { //Método que verifica quantos dos números digitados pelo Usuário estão na lista de 30 números randomizados
        int quant = 0;

        for(int m = 0; m < 5; m++){ //Limpa a lista de escolhidos
            esc[m] = 0;
        }

        System.out.println("Escolha 5 números entre 1 e 100:\n");   

        for (int l = 0; l < 5; l++) {

            int countEqual = 0; //Variável usada para contar a repetição de números

            try{ //Função try-catch, utilizada para quando ocorrer uma exceção, no caso, caso o usuário digite algo diferente de um inteiro, algo que pode comprometer o sistema
                System.out.printf("Escolha o %dº número: ", l + 1);
                escolhas[l] = scan.nextInt(); //Recebe os valores do usuário

                for(int k : escolhas){
                    if(escolhas[l] == k){
                        countEqual++; //Adiciona a "countEqual" +1 se houver números iguais
                    }
                }

                if(countEqual > 1){
                    System.out.println("Números repetidos não são permitidos!\n");
                    l--; //Se houver números iguais, ele volta um loop atrás para que o usuário digite novamente
                }

                else if(escolhas[l] < 1 || escolhas[l] > 100){ //Condição criada para alertar o usuário que só são permitidos números entre 01 e 100
                    System.out.println("Número inválido, digite algo entre 01 e 100!\n");
                    l--;
                }

                }catch(InputMismatchException e){
                    scan.next();
                    System.out.println("\nVocê digitou um caractere inválida, apenas números são aceitos!");
                    l--;
                }

        }

        for (int in : numeros) {
            for (int ij : escolhas) {
                if (ij == in) {
                    quant++; //Soma +1 a "quant" se o item "in" da lista "numeros"(30) for igual ao item "ij" da lista "escolhas"(05)
                }
            }
        }
        return quant;
    
}

    public boolean getSenha(String[] numeros, int quantidade){ //Método utilizado para dizer se o Usuário venceu ou não, mostrando os números da lista caso tenha vencido

        if(quantidade == 5){
            System.out.print("--------------------------------------------------------------------------------------------------");
            System.out.println("\nVocê venceu!! Os números da senha são:");
            for (String numero : numeros) { //Percorre a string com a lista de 30 números aleatórios, para que imprima um por um

                if(numero.equals(numeros[0])){
                    System.out.print(numero);
                }
                else{
                    System.out.print(" - " + numero);
                }
        }
            
            System.out.println();
            getContadorPesquisa(contadorLos); //Chama o método que imprime a quantidade de tentativas
            System.out.print("--------------------------------------------------------------------------------------------------\n");
            while (true) {
                System.out.println("Deseja continuar?\n\n1 - Sim\n2 - Não");

                int op = scan.nextInt();

                if (op == 2) {
                    System.out.println("Saindo...");
                    return true; //Retorna "true" se os acertos forem 5
                }
                
                else if (op == 1) {
                    System.out.println("Certo!");

                    gerarRan(count);
                    contadorLos = 0;

                    return false;

                } 
                
                else {
                    System.out.println("Opção inválida! Digite novamente\n");
                }
            }
        }

        else{

            System.out.println("\nVocê ainda não adivinhou a senha!");
            System.out.printf("Quantidade de acertos: %d\n\n", quantidade);

            contadorLos++; //Soma +1 a quantidade de tentativas

            return false; //Retorna "false" se os acertos ainda não tiverem chegado em 5

        }
    }

    public static void getContadorPesquisa(int num){ //Método usado para mostrar quantas tentativas foram feitas no final
        num++;
        System.out.println("Comparações realizadas: "+ num);
    }

}
