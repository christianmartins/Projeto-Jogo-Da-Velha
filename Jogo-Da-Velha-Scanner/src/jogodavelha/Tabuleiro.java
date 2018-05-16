package jogodavelha;

public class Tabuleiro {
    
    private String[][] m_Tabuleiro = {{"1", "2", "3" },{"4","5","6"},{"7","8","9"}};
    private boolean m_FimDeJogo;

    public void mostrarTabuleiro(){
        System.out.println("*--- Jogo da velha ---*");
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){
                System.out.print(" | "+m_Tabuleiro[linha][coluna]+ " | ");
            }
            System.out.println("\n");
        }
    }

    public void mover(String posicao, String jogadorAtual){           
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){
                if(m_Tabuleiro[linha][coluna].equals(posicao)){  
                    m_Tabuleiro[linha][coluna] = jogadorAtual;                    
                }
            }
        }   
    }
  
    public void vencedor(String jogadorAtual){
        
        //Vitoria Horizontal
        if(m_Tabuleiro[0][0].equals(jogadorAtual)&& m_Tabuleiro[0][1].equals(jogadorAtual)&& m_Tabuleiro[0][2].equals(jogadorAtual))
            m_FimDeJogo = true;
        
        else if(m_Tabuleiro[1][0].equals(jogadorAtual)&& m_Tabuleiro[1][1].equals(jogadorAtual)&& m_Tabuleiro[1][2].equals(jogadorAtual))
            m_FimDeJogo = true;
        
        else if(m_Tabuleiro[2][0].equals(jogadorAtual)&& m_Tabuleiro[2][1].equals(jogadorAtual)&& m_Tabuleiro[2][2].equals(jogadorAtual))
            m_FimDeJogo = true;
        
        //Vitoria Vertical
        else if(m_Tabuleiro[0][0].equals(jogadorAtual)&& m_Tabuleiro[1][0].equals(jogadorAtual)&& m_Tabuleiro[2][0].equals(jogadorAtual))
            m_FimDeJogo = true;
        
        else if(m_Tabuleiro[0][1].equals(jogadorAtual)&& m_Tabuleiro[1][1].equals(jogadorAtual)&& m_Tabuleiro[2][1].equals(jogadorAtual))
            m_FimDeJogo = true;
        
        else if(m_Tabuleiro[0][2].equals(jogadorAtual)&& m_Tabuleiro[1][2].equals(jogadorAtual)&& m_Tabuleiro[2][2].equals(jogadorAtual))
            m_FimDeJogo = true;
        
        //Vitoria Diagonal
        else if(m_Tabuleiro[0][0].equals(jogadorAtual)&& m_Tabuleiro[1][1].equals(jogadorAtual)&& m_Tabuleiro[2][2].equals(jogadorAtual))
            m_FimDeJogo = true;
        
        else if(m_Tabuleiro[0][2].equals(jogadorAtual)&& m_Tabuleiro[1][1].equals(jogadorAtual)&& m_Tabuleiro[2][0].equals(jogadorAtual))
            m_FimDeJogo = true;     
    }
    
    public boolean valido(String posicao){
       for(int linha = 0; linha < 3; linha++){
           for(int coluna = 0; coluna < 3; coluna++){
                if(m_Tabuleiro[linha][coluna].equals(posicao))
                    return true;
           }
       }
       return false;
    }    
    
    public boolean getFimDeJogo(){
        return m_FimDeJogo;
    }  
    public void setFimDeJogo(boolean fimDeJogo){
        this.m_FimDeJogo = fimDeJogo;
    }
}
