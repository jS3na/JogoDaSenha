package src;
public class Teste extends JogoDaSenha{ //Classe de teste, o comando "extends JogoDaSenha" foi utilizado para "puxar" os métodos da classe Principal do jogo.

    public static void main(String[] args){ //Método principal

        JogoDaSenha novoJogo = new JogoDaSenha(); //Chamando a classe JogoDaSenha, no método principal

        novoJogo.gerarRan(count); //Método que gera os números aleatórios

        while(!novoJogo.venceu){ //Loop Principal

            novoJogo.getNum(esc, scan); //Recebe as escolhas do jogador
            quant = novoJogo.fazerTentativa(nums, esc); //Verifica quantos números da lista randomizados são iguais aos números recebidos do usuário, armazenando o valor na variável "quant"
            venceu = novoJogo.getSenha(numsstr, quant); //Verifica se o jogador venceu o jogo, armazenando "true" na variável "venceu" finalizando o loop principal
    
        }
    }
}