package game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
@author christian
github: github.com/crmon
*/
public class FrameGrid extends JFrame{
    private JLabel lblJogadorAtual;
    private JPanel pnlGrid, pnlResetar;
    private JButton btn[], btnResetar;
    private String jogadorAtual;
    private Box boxPrincipal;     
    public FrameGrid(){
        super("JOGO DA VELHA");
        lblJogadorAtual = new JLabel("JOGADOR ATUAL: "+jogadorAtual);
        boxPrincipal = Box.createVerticalBox();
        pnlGrid = new JPanel(new GridLayout(3,3));
        pnlResetar = new JPanel();
        btn = new JButton[9];
        
        for(int i = 0; i < btn.length; i ++){
            btn[i] = new JButton();
            btn[i].setPreferredSize(new Dimension(100, 100));
        }         
        
        btnResetar = new JButton("RESETAR"); 
        btnResetar.setPreferredSize(new Dimension(250, 50)); 
    }
    
    public void init(){
        //jogadorAtual = "X";
        //lblJogadorAtual.setText(jogadorAtual);
        getContentPane().add(boxPrincipal);
        boxPrincipal.add(lblJogadorAtual);
        boxPrincipal.add(pnlGrid);
        for(int i = 0; i < btn.length; i ++){
            pnlGrid.add(btn[i]);    
        }   
        boxPrincipal.add(pnlResetar);
        pnlResetar.add(btnResetar);
        
           
        setSize(380, 450);
        setLocationRelativeTo(null); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);     
    }
    public static void main(String[] args) {
        FrameGrid fg = new FrameGrid();
        fg.init();
    }  
}
