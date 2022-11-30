/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
/**
 *
 * @author Valter Boa 53
 */
public class TelaLogin {
    private static JLabel senha, tenteNovamente,icon;
    private static JTextField fSenha;
    private JButton bEntrar;
    private static JFrame frame;
    private static JPanel painel;
    private static Container painelLogin;
    private GridBagConstraints gbc = new GridBagConstraints();
     Color cor = new Color(0.0f, 0.4f, 0.8f, 1f);//COR DO AZUL
    Color cor2 = new Color(0.0f, 0.2f, 0.8f, 1f); //COR SECUNDARIA
     //fontes
    Font fonte = new Font("Helvetica", Font.TRUETYPE_FONT, 15);
    Font fonte2 = new Font("Helvetica", Font.TRUETYPE_FONT, 14);
    public TelaLogin(){
        
        inicializar();
    criarJanela();
    }
    
    public void inicializar(){
    senha = new JLabel("Introduza a senha");
    senha.setFont(fonte2);
    senha.setForeground(Color.white);
    tenteNovamente = new JLabel("   preencha o campo acima  ");
    tenteNovamente.setForeground(Color.yellow);
    bEntrar = new JButton("  ENTRAR  ");
      bEntrar.setBackground(cor2);
        bEntrar.setForeground(Color.WHITE);
        bEntrar.setBorderPainted(false);
        bEntrar.setFont(fonte);
        bEntrar.setFocusPainted(false);
        bEntrar.addActionListener(al);
        
    fSenha = new JPasswordField(20);
    fSenha.setFont(fonte2);
    fSenha.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
      
    
    //imagem de login
            icon = new JLabel();
        icon.setIcon(new ImageIcon("src/Imagens/Menu/logo.png"));
    
    }
   public Container painelLogin(){
   inicializar();
   painel = new JPanel();
   painel.setBackground(cor);
    
    painel.setLayout(new GridBagLayout());
    // IMAGEM login
        gbc.insets = new Insets(0, 5, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(icon, gbc);
        
        //LAbel introduzir senha
        gbc.insets = new Insets(5, 5, 10, 0);
        gbc.gridy = 1;
        painel.add(senha, gbc);
        
        //field senha
        gbc.gridy = 2;
        gbc.ipady = 14;
        painel.add(fSenha, gbc);
        gbc.ipady = 0;
         //field repetir senha
        gbc.gridy = 3;
        painel.add(tenteNovamente, gbc);
        
        //butao entrar
        gbc.insets = new Insets(25, 5, 30, 0);
        gbc.gridy = 4;
        painel.add(bEntrar, gbc);
    
    return painel;
    }
       public void criarJanela() {
        frame = new JFrame();
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(painelLogin());
        frame.setSize(880, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
        public void repetirSenha(){
          String nSenha = "vet";
        if(fSenha.getText().equalsIgnoreCase(nSenha)){
            frame.setVisible(false);
           Menu_Principal menu = new Menu_Principal();
           menu.criarJanela();
        }
          else{
            fSenha.setText(null);
            tenteNovamente.setForeground(Color.white);
            tenteNovamente.setText("Senha errada, Tente novamente");}
            
            System.out.println(fSenha.getText());
        
        }

    public static void main(String[] args){
    new TelaLoading();
    new TelaLogin();
    
    }
    
     ActionListener al = new ActionListener() {
           public void actionPerformed(ActionEvent e)  {
       repetirSenha();
       }};
           
     
        
   
    
    
}
