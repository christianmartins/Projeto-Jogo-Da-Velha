package jogodavelha;

import java.util.Scanner;

public class Jogo {
    
    private Tabuleiro m_Tabuleiro;
    private Jogador[] m_Jogador = new Jogador[2];
    public Scanner sc = new Scanner(System.in);
    private int m_Turno;
    private String m_Posicao;
    private boolean m_JogadaValida;
    private int m_numeroDeRodada = 1;
    
    private String[] escolhaJogador = {"1", "2", "3"};
    
    public Jogo(){
        //menu();
        //jogar();
        iniciarJogador();
        System.out.println("Jogador 1: "+m_Jogador[0].getNome());
//        System.out.println("Sinal: "+m_Jogador[0].getSinal());
        System.out.println("Jogador 2: "+m_Jogador[1].getNome());
//        System.out.println("Sinal: "+m_Jogador[1].getSinal());
        
    }
    
    public void limparTela(){
        System.out.println("\n\n\n\n\n\n");    
    }
    
    public void iniciarJogador(){
        
        for(int i = 0; i < m_Jogador.length; i++){
            System.out.println("1 - Iniciar jogador "+ (i + 1) +" com nome padrão\n"
            + "2 - Iniciar jogador "+ (i + 1) +" com nome personalizado");
            String escolha = sc.nextLine();
            if(escolha.equals("1")){
                m_Jogador[i] = new Jogador(("Jogador "+(i == 0 ? "1": "2")), (i == 0 ? "X": "O"));  
            }
            else if(escolha.equals("2")){
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
            char menu;
            int a , b; 
            
            System.out.println("*----------- Jogo da velha -----------*\n"
                    + "Digite a opção desejada\n"
                    + "1 - Melhor de 1\n"
                    + "2 - Melhor de 3\n"
                    + "3 - Melhor de 5\n"
                    + "4 - Sair");
            
            menu = sc.next().charAt(0);

            switch(menu){
                  
                case '1':
                    m_numeroDeRodada = 1;
                    finalizar = true;
                    break;
                case '2':
                    m_numeroDeRodada = 3;
                    finalizar = true;
                    break;
                case '3':
                    m_numeroDeRodada = 5;
                    finalizar = true;
                    break;
                case '4':
                    finalizar = true;
                    System.exit(0);
                    break;     
                default :
                    finalizar = false;
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }
     
    public void jogar(){

        for(int i = 0; i < m_numeroDeRodada; i++){
            m_Tabuleiro = new Tabuleiro(); 
            limparTela();

            while(!m_Tabuleiro.getFimDeJogo()){

                if(m_Turno >= 9){
                    System.out.println("Deu velha!");
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
            m_Turno = 0;
        }    
        
    }

}
