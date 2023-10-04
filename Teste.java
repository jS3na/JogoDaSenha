import jogodasenha.JogoDaSenha;

public class Teste {

    public static void main(String[] args){ //Método principal

        JogoDaSenha novoJogo = new JogoDaSenha(); //Chamando a classe JogoDaSenha, no método principal

        novoJogo.gerarRan(jogodasenha.JogoDaSenha.count); //Método que gera os números aleatórios

        while(!novoJogo.venceu){ //Loop Principal

            novoJogo.getNum(JogoDaSenha.esc, JogoDaSenha.scan); //Recebe as escolhas do jogador
            JogoDaSenha.quant = novoJogo.fazerTentativa(JogoDaSenha.nums, JogoDaSenha.esc); //Verifica quantos números da lista randomizados são iguais aos números recebidos do usuário, armazenando o valor na variável "quant"
            JogoDaSenha.venceu = novoJogo.getSenha(JogoDaSenha.numsstr, JogoDaSenha.quant); //Verifica se o jogador venceu o jogo, armazenando "true" na variável "venceu" finalizando o loop principal
    
        }
    }
    
}
