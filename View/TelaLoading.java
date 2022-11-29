/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

// Java Program to create a
// simple progress bar
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaLoading{

    private GridBagConstraints gbc = new GridBagConstraints();
     Color cor = new Color(0.0f, 0.4f, 0.8f, 1f);//COR DO AZUL
    Color cor2 = new Color(0.0f, 0.2f, 0.8f, 1f); //COR SECUNDARIA
    // create a frame
	private static JFrame f;
	private static JProgressBar b;
        private static Container painelLoading;
        private static JLabel icon;
     //fontes
    Font fonte = new Font("Helvetica", Font.TRUETYPE_FONT, 15);
    Font fonte2 = new Font("Helvetica", Font.TRUETYPE_FONT, 14);
    public TelaLoading(){
    criarJanela();
    }
	
        public void inicializar(){
        
        b = new JProgressBar();
        // valor inicial
        b.setValue(0);
        b.setStringPainted(true);
        b.setBackground(Color.white);
        
        icon = new JLabel();
        icon.setIcon(new ImageIcon("src/Imagens/Menu/logoLoading.png"));
    }
        
        public Container painelLoading(){
            inicializar();
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(-150, 0, -90, 0);
        gbc.gridx = 2;
        gbc.gridy = 1;
        painel.add(icon,gbc); //adicionar imagem ao painel
        
        gbc.insets = new Insets(0, 0, -10, 10);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.ipadx= 100;
        gbc.ipady =30;
        painel.add(b,gbc); //adicionar progress bar ao painel
        painel.setBackground(cor);
        
        
        return painel;}

	/*public static void main(String[]args)
	{ new TelaLoading();
         new TelaLogin();    
	}*/
        
        public void criarJanela(){
		// criar a frame
		f = new JFrame("loading");
                f.setLayout(new BorderLayout());
                f.setBackground(Color.white);
		// add panel
		f.add(painelLoading(),BorderLayout.CENTER);
		//Tamanho do frame
                f.setSize(880, 750);
		f.setVisible(true);
                 f.setLocationRelativeTo(null);
                 f.setResizable(false);
		fill();
        
        }

	// aumentar o tamanho do progresso
	public static void fill(){
		int i = 0;
		try {
			while (i <= 100) {
				// fill the menu bar
				b.setValue(i + 1);

				// delay the thread
				Thread.sleep(1000);
				i += 10;
			}
                        f.setVisible(false);
		}
		catch (Exception e) {
		}
	}
}
