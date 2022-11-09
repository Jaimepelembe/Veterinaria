package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Cadastro_Consulta  implements ActionListener {
    private JLabel lab,lPreco, nome, preco, data, lData;
    private JButton bSalvar, bLimpar, bCancelar;
    private JComboBox cNome;
    private String[] nomes = {"Hemograma", "Exame de rins" ,"Exame de fígado", "Raio-x" }; 
    private JFrame frame;
    private JPanel painel, pPrincipal, pButoes;
    private GridBagConstraints gbc = new GridBagConstraints();
    
    public Cadastro_Consulta(){
        criarJanela();
    }
    
    public void inicializar(){
    nome = new JLabel("Nome da Consulta ");
    nome.setForeground(Color.gray);
    cNome = new JComboBox(nomes);
    cNome.setSelectedIndex(-1);
    int precoNum = 100;
    String dt = "15/10/1947";
    preco = new JLabel("Preco da consulta                                    "+precoNum+" MZN ");
        data = new JLabel("Data da Consulta                                    "+dt); 
        
         //Botoes 
     //Salvar
       bSalvar = new JButton("       Salvar       ");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(Color.green);
       bSalvar.setBorderPainted(false);
       bSalvar.setFocusPainted(false);
       
      //Eliminar
       bLimpar = new JButton("Limpar");
       bLimpar.setForeground(Color.white);
       bLimpar.setBackground(Color.blue);
       bLimpar.setBorderPainted(false);
       bLimpar.addActionListener(this);
       bLimpar.setFocusPainted(false);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
        bCancelar.setBorderPainted(false);
        bCancelar.addActionListener(this);
        bCancelar.setFocusPainted(false);
    
    }
      //principal
    public Container componentes(){
        inicializar();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

       // Informacoes d o nome
        // nome
        gbc.insets = new Insets(105, 15, -27, 0);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.ipady = 2;
        painel.add(nome, gbc);
        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.ipadx = 100;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        painel.add(cNome, gbc);

          // Preco consulta
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painel.add(preco, gbc);

        gbc.insets = new Insets(35, 5, 0, 10);
        lPreco = new JLabel("100");//O preco da consulta deve ser calculado de a cordo com o nome
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        //painel.add(lPreco, gbc);
        
        
             // Data Real
             gbc.insets = new Insets(35, 15, 7, 50);
             gbc.gridy = 4;
             gbc.gridx = 1;
             painel.add(data, gbc);
            
        //field da data 
                
            
       
    

   
return painel;
    }
  

public Container adicionarBotoes() {
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
       pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(150, 5, 40, 0);
        gbc.ipady = 2;
        gbc.ipadx = 2;
        // add buttons to the panel
        gbc.gridy=0;
        gbc.gridx = 1;
        pBotoes.add(bSalvar,gbc);
        gbc.gridx = 2;
        pBotoes.add(bLimpar,gbc);
        gbc.gridx = 4;
        pBotoes.add(bCancelar,gbc);
    return pBotoes;
}
        public Container pPrincipal() {
        pPrincipal = new JPanel();
        
       pPrincipal.add(componentes(), BorderLayout.CENTER);
      pPrincipal.add(adicionarBotoes(), BorderLayout.SOUTH);
        pPrincipal.setBackground(Color.white);

    return pPrincipal;
}
         public void colocarIconMenu() {
       Menu_Principal a = new Menu_Principal("");
        a.mudarCor();
        a.iconPrincipal();
        
    }
         public void Limpar() {
        this.cNome.setSelectedIndex(-1);

    }
    
    public void criarJanela() {
        frame = new JFrame("CONSULTA");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530, 550);
       //frame.add(componentes(), BorderLayout.CENTER);
     // frame.add(adicionarBotoes(), BorderLayout.SOUTH);
      frame.add(pPrincipal());
       //frame.pack();
frame.setVisible(true);
    }

    public static void main(String[] args) {
     new Cadastro_Consulta();
    }
 public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
  if(e.getSource()==bCancelar){
       colocarIconMenu();
       }
}}
