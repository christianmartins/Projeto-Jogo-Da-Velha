package jogodavelha;

public class Jogador {
    private String m_Sinal;
    private String m_Nome;
    private int m_Vitoria;
  
    public Jogador(String nome, String sinal){
        this.m_Nome = nome;
        this.m_Sinal = sinal;
    }
    public Jogador(String nome){
        this.m_Nome = nome;
    }
    public Jogador(){    
    }
    public String getSinal(){
        return this.m_Sinal;
    }
    public void setSinal(String sinal){
        this.m_Sinal = sinal;
    }
    public String getNome(){
        return this.m_Nome;
    }
    public void setNome(String nome){
        this.m_Nome = nome;
    }  
    public int getVitoria(){
        return m_Vitoria;
    }
    public void setVitoria(int vitoria){
        this.m_Vitoria = vitoria + this.m_Vitoria;
    }
}
