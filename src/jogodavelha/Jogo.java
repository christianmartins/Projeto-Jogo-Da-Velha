package jogodavelha;

import java.util.Scanner;

public class Jogo {
    
    private Tabuleiro m_Tabuleiro;
    private Jogador[] m_Jogador = new Jogador[2];
    public Scanner sc = new Scanner(System.in);
    private int m_Turno;
    private String m_Posicao;
    private boolean m_JogadaValida;
    private int m_JogadorAtual;
    private int m_numeroDeRodada;
    private boolean m_Empatou = false;
    private int m_NumueroDeEmpate;
    
    
    public Jogo(){
        menu();
        iniciarJogador();
        jogar();    
    }
    
    public static void limparTela(){
        System.out.println("\n\n\n\n\n");    
    }
    
    public void iniciarJogador(){
        
        System.out.println("---- Alterações do jogador ----");
        
        for(int i = 0; i < m_Jogador.length; i++){
            String escolha;
            boolean valido;
            
            do{ 
                System.out.println("Deseja alterar nome do jogador " + (i + 1) + " ?\n"
                + "[S]/[N]");
                escolha = sc.nextLine();
                
                if(escolha.equalsIgnoreCase("S") || escolha.equalsIgnoreCase("N"))
                    valido = true;
                else{
                    System.out.println("Opção Invalida");
                    valido = false;
                }
            }while(!valido);
            
            if(escolha.equalsIgnoreCase("N")){
                m_Jogador[i] = new Jogador(("Jogador "+(i == 0 ? "1" : "2")), (i == 0 ? "X": "O"));  
            }
            else if(escolha.equalsIgnoreCase("S")){
                m_Jogador[i] = new Jogador();
                System.out.println("Digite o nome do jogador "+(i + 1)+" :");
                m_Jogador[i].setNome(sc.nextLine());
                m_Jogador[i].setSinal((i == 0 ? "X": "O"));
            }
            else
                System.out.println("Opção não existe");
        }
    }
    
    public void menu(){
        boolean finalizar = false;
        while(!finalizar){
            String menu;
            System.out.println("1*--- Jogo da velha ---*\n"
                    + "Digite a opção desejada\n"
                    + "1 - Melhor de 1\n"
                    + "2 - Melhor de 3\n"
                    + "3 - Melhor de 5\n"
                    + "4 - Sair");
            
            menu = sc.nextLine();

            if(menu.equals("1")){
                m_numeroDeRodada = 1;
                finalizar = true;
            }
            else if(menu.equals("2")){
                m_numeroDeRodada = 1;
                finalizar = true;
            }
            else if(menu.equals("3")){
                m_numeroDeRodada = 1;
                finalizar = true;
            }    
            else if(menu.equals("4")){
                System.exit(0);
            }
            else{
                System.out.println("Opção invalida");
            }
        }
        
    }

    public void placar(){
        System.out.println("* ------- Placar ------- *");
        System.out.println(m_Jogador[0].getNome() 
        +"   "+m_Jogador[0].getVitoria()+" x "+m_Jogador[1].getVitoria()+"   "
        +m_Jogador[1].getNome());
        System.out.println("Empate: "+ m_NumueroDeEmpate);
    }
    
    public void jogar(){
        
        for(int i = 0; i < m_numeroDeRodada; i++){
            
            m_Tabuleiro = new Tabuleiro(); 
            Jogo.limparTela();
            
            while(!m_Tabuleiro.getFimDeJogo()){

                if(m_Turno >= 9){
                    m_Empatou = true;
                    break;
                }
                
                placar(); 
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
  
                m_JogadorAtual = m_Turno % 2 == 0 ? 0 : 1;    
                m_Tabuleiro.mover(m_Posicao, m_Jogador[m_JogadorAtual].getSinal()); 
                m_Tabuleiro.mostrarTabuleiro();
                m_Turno++;
                m_Tabuleiro.vencedor(m_Jogador[m_JogadorAtual].getSinal());
                
                System.out.println("Turno: " + m_Turno);
                System.out.println("Nome do jogador: "+ m_Jogador[m_JogadorAtual].getNome());
                System.out.println("Sinal: "+m_Jogador[m_JogadorAtual].getSinal());
                System.out.println();
            }   
            
            m_Tabuleiro.mostrarTabuleiro();
            
            if(m_Empatou){
                System.out.println("Deu velha!");
                m_NumueroDeEmpate += 1;
            }
            else{
                System.out.println("O "+ m_Jogador[m_JogadorAtual].getNome()+
                " Venceu essa partida");
                m_Jogador[m_JogadorAtual].setVitoria(1);
            }
            m_Turno = 0;
        }    
        
    }

}
