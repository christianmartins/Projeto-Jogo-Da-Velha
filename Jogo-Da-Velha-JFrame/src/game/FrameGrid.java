package game;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
@author christian
github: github.com/crmon
*/
public class FrameGrid extends JFrame{
    private JLabel titulo;
    private JPanel pnlPrincipal, linha[], pnlResetar;
    private JButton btn[], btnResetar;
    
    public FrameGrid(){
        titulo = new JLabel("--- Jogo da Velha ---");
        linha = new JPanel[3];
        pnlPrincipal = new JPanel();
        
        btn = new JButton[9];
        
        for(int i = 0; i < btn.length; i ++){
            btn[i] = new JButton();
            btn[i].setPreferredSize(new Dimension(100, 100));
        }
        
        for(int i = 0; i < linha.length; i++){
            linha[i] = new JPanel();
        }
        
         
        
        btnResetar = new JButton("RESETAR"); 
        btnResetar.setPreferredSize(new Dimension(250, 50)); 
    }
    
    public void init(){
        setSize(380, 450);
        setLocationRelativeTo(null);
        getContentPane().add(pnlPrincipal);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        for(int i = 0; i < btn.length; i ++){
            pnlPrincipal.add(btn[i]);
            
        }   
        pnlPrincipal.add(btnResetar);
    }
    public static void main(String[] args) {
        FrameGrid fg = new FrameGrid();
        fg.init();
        //new FrameGrid().init();
        
    }
    
}
