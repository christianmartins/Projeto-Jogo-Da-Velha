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
    private int m_NumeroDeRodada;
    private boolean m_Empatou = false;
    private int m_NumeroDeEmpate;
    private boolean m_JogadorVenceu1 = false;
    private boolean m_JogadorVenceu2 = false;
    private boolean m_Desempatar = false;

    public Jogo(){
        menu();
        iniciarJogador();
        jogar();    
    }
    
    public static void limparTela(){
        System.out.println("\n\n\n\n\n\n");    
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
            System.out.println("*--- Jogo da velha ---*\n"
                    + "Digite a opção desejada\n"
                    + "1 - Melhor de 1\n"
                    + "2 - Melhor de 3\n"
                    + "3 - Melhor de 5\n"
                    + "4 - Sair");
            
            menu = sc.nextLine();

            if(menu.equals("1")){
                m_NumeroDeRodada = 1;
                finalizar = true;
            }
            else if(menu.equals("2")){
                m_NumeroDeRodada = 3;
                finalizar = true;
            }
            else if(menu.equals("3")){
                m_NumeroDeRodada = 5;
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
        System.out.println("Empate: "+ m_NumeroDeEmpate);
    }
    
    public void verificarNumeroDeVitorias(){
        
         if(m_NumeroDeRodada == 1){
            if(m_Jogador[0].getVitoria() == 1 
            && m_Jogador[1].getVitoria() == 0){
                
                m_JogadorVenceu1 = true;
            }
            if(m_Jogador[1].getVitoria() == 1 
            && m_Jogador[0].getVitoria() == 0){
                
                m_JogadorVenceu2 = true;
            }
        }
        else if(m_NumeroDeRodada == 3){
            // Condição de vitoria para ambos jogadores
            if(m_Jogador[m_JogadorAtual].getVitoria() >= 2){
                m_JogadorVenceu1 = true;
            }
            
            //Condição de vitoria do jogador 1
            else if(m_Jogador[0].getVitoria() == 1 
            && m_Jogador[1].getVitoria() == 0
            && m_NumeroDeEmpate >= 2){
                m_JogadorVenceu1 = true;
            }
            
            //Condição de vitoria do jogador 2
            else if(m_Jogador[1].getVitoria() == 1 
            && m_Jogador[0].getVitoria() == 0
            && m_NumeroDeEmpate >= 2){
                m_JogadorVenceu2 = true;
            }
            
            // Condição de vitoria para ambos jogadores
            else if(m_Jogador[0].getVitoria() == 1 
            && m_Jogador[1].getVitoria() == 1
            && m_NumeroDeEmpate >= 1){
                m_Desempatar = true;  
            }         
            else if(m_NumeroDeEmpate >= 3){
                m_Desempatar = true;    
            }
        }   
        else if(m_NumeroDeRodada == 5){
            // Condição de vitoria para ambos jogadores
            if(m_Jogador[m_JogadorAtual].getVitoria() >= 3){
                m_JogadorVenceu1 = true;
            }
            
            //Condição de vitoria do jogador 1
            else if(m_Jogador[0].getVitoria() == 1 
            && m_Jogador[1].getVitoria() == 0
            && m_NumeroDeEmpate >= 4){
                m_JogadorVenceu1 = true;
            }
            else if(m_Jogador[0].getVitoria() == 2 
            && m_Jogador[1].getVitoria() == 0
            && m_NumeroDeEmpate >= 3){
                m_JogadorVenceu1 = true;
            }
            else if(m_Jogador[0].getVitoria() == 2 
            && m_Jogador[1].getVitoria() == 1
            && m_NumeroDeEmpate >= 2){
                m_JogadorVenceu1 = true;
            }
            
            //Condição de vitoria do jogador 2
            else if(m_Jogador[1].getVitoria() == 1 
            && m_Jogador[0].getVitoria() == 0
            && m_NumeroDeEmpate >= 4){
                m_JogadorVenceu2 = true;
            }
            else if(m_Jogador[1].getVitoria() == 2 
            && m_Jogador[0].getVitoria() == 0
            && m_NumeroDeEmpate >= 3){
                m_JogadorVenceu2 = true;
            }
            else if(m_Jogador[1].getVitoria() == 2 
            && m_Jogador[0].getVitoria() == 1
            && m_NumeroDeEmpate >= 2){
                m_JogadorVenceu1 = true;
            }
            // Condição de vitoria para ambos jogadores
            else if(m_Jogador[0].getVitoria() == 2 
            && m_Jogador[1].getVitoria() == 2
            && m_NumeroDeEmpate >= 1){
                m_Desempatar = true;  
            }
            else if(m_NumeroDeEmpate >= 5){
                m_Desempatar = true;   
            }
        }   
    }
    
    public void jogar(){
        
        for(int i = 0; i < m_NumeroDeRodada; i++){
            
            m_Tabuleiro = new Tabuleiro(); 
            Jogo.limparTela();
            m_Turno = 0;
            
            while(!m_Tabuleiro.getFimDeJogo()){
                
                m_Empatou = false;
                
                if(m_Turno >= 9){
                    m_Empatou = true;
                    break;
                }
                
                m_JogadorAtual = m_Turno % 2 == 0 ? 0 : 1;          
                placar(); 
                
                if(m_Desempatar){
                    System.out.println("* ------ Desempate! ------ *");
                }
                m_Tabuleiro.mostrarTabuleiro();  
                
                do{
                    System.out.println("Digite sua posição "
                    +m_Jogador[m_JogadorAtual].getNome()+ ": ");
                    m_Posicao = sc.nextLine();
                    
                    if(!m_Tabuleiro.valido(m_Posicao)){
                        System.out.println("Jogada invalida!");
                        m_JogadaValida = false;
                    }
                    else                    
                        m_JogadaValida = true; 
                }while(!m_JogadaValida);
       
                m_Tabuleiro.mover(m_Posicao, m_Jogador[m_JogadorAtual].getSinal());
                placar();
                m_Tabuleiro.mostrarTabuleiro();
                m_Turno++;
                m_Tabuleiro.vencedor(m_Jogador[m_JogadorAtual].getSinal());

                System.out.println();
            }   

            if(m_Empatou){
                System.out.println("Deu velha!");
                m_NumeroDeEmpate += 1;
            }
            else{
                m_Jogador[m_JogadorAtual].setVitoria(1);     
            }
            
            verificarNumeroDeVitorias();
            
            if(m_Desempatar == true){
                i -= 1; 
            }
            
            if(m_JogadorVenceu1){    
                placar();
                m_Tabuleiro.mostrarTabuleiro();  
                System.out.println("O "+ m_Jogador[0].getNome()+" venceu");
                break;
            }    
            else if(m_JogadorVenceu2){    
                placar();
                m_Tabuleiro.mostrarTabuleiro();  
                System.out.println("O "+ m_Jogador[1].getNome()+" venceu");
                break;
            }           
        }    
        
    }

}
