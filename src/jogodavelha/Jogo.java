package jogodavelha;

import java.util.Scanner;

public class Jogo {
    
    private Tabuleiro m_Tabuleiro;
    private Jogador[] m_Jogador = new Jogador[2];
    public Scanner sc = new Scanner(System.in);
    private int m_Turno;
    private String m_Posicao;
    private boolean m_JogadaValida;
    
    private String[] escolhaJogador = {"1", "2", "3"};
    
    public Jogo(){
       m_Tabuleiro = new Tabuleiro(); 
       jogar();
    }
    
    public void iniciarJogador(String escolha){
        
        if(escolha.equals("1")){
            System.out.println("Iniciar jogador com nome e sinal padrão");
        }
        else if(escolha.equals("2")){
            System.out.println("Iniciar jogador com nome personalizado");
        }
        else if(escolha.equals("3")){
            System.out.println("Iniciar jogador com nome e sinal personalizado");
        }
        else
            System.out.println("Opção não existe");
        
//        
//        for(int i = 0; i < 2; i++){
//            System.out.println("Digite o nome do "+(i + 1)+"º jogador");
//            //String nome = sc.nextLine();
//            //jogador[i] = new Jogador(nome);
//            m_Jogador[i] = new Jogador("Christian");
//            String sinal = i == 0 ? "X": "O"; 
//            m_Jogador[i].setSinal(sinal);
//            //jogador[i].setSinal(i == 0 ? "X": "O");
//            
//            ///System.out.println("Mostarando o jogador "+jogador[i].getSinal());
//        }
    }
     
    public void jogar(){
        
        //iniciarJogador("1");
        
        //Teste
        //String sinal = m_Turno % 2 != 0 ? "X": "O"; 
//        m_Jogador[i] = new Jogador();
//        m_Jogador[i].setSinal(sinal);
//        System.out.println("Estou testandoooo o sinal chora: " + sinal);
//        
//        
        //Teste

        while(!m_Tabuleiro.getFimDeJogo()){
            
            if(m_Turno >= 9){
                
                //Não está funcionando corretamente o aviso de empatou!
                System.out.println("Empatou!");
                break;   
            }
            
            m_Tabuleiro.mostrarTabuleiro();  

            do{
                System.out.println("Digite sua jogada");
                m_Posicao = sc.nextLine();
                
                if(!m_Tabuleiro.valido(m_Posicao)){
                    System.out.println("Jogada invalida!");
                    m_JogadaValida = false;
                }
                else                    
                    m_JogadaValida = true; 
                
            }while(!m_JogadaValida);
            
            String sinal = m_Turno % 2 == 0 ? "X": "O";
            
            
//            
//            if(m_Turno % 2 != 0){
//                m_Jogador[0].setSinal("X");
//                //m_Tabuleiro.mover(m_Posicao, m_Jogador[0].getSinal()); 
//                //m_Tabuleiro.vencedor(m_Jogador[0].getSinal()); 
//            }
//            else{
//                //m_Jogador[1].setSinal("O");
//               // m_Tabuleiro.mover(m_Posicao, m_Jogador[1].getSinal()); 
//                //m_Tabuleiro.vencedor(m_Jogador[1].getSinal()); 
//            }
//            m_Tabuleiro.mostrarTabuleiro();
//            m_Turno++;
//                    
            m_Tabuleiro.mover(m_Posicao, sinal); 
            m_Tabuleiro.mostrarTabuleiro();
            m_Turno++;
            m_Tabuleiro.vencedor(sinal); 
            System.out.println("Turno: " + m_Turno);
            System.out.println();
        }   
        m_Tabuleiro.mostrarTabuleiro();  
    } 

}
