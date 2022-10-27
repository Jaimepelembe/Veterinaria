package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.plaf.multi.MultiTableHeaderUI;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;public class Cadastro_Veterianara  implements ActionListener{
    private JLabel lab;
    private JButton bSalvar, bLimpar, bCancelar;
    private JTextField fNome, fLocalizacao;
    private JFrame frame;private JPanel painel,pBotoes,pPrincipal;
    
    private GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Veterianara() {
        criarJanela();
    }
    
    public void inicializarComponentes(){
    //Field Nome
    fNome = new JTextField();
    
    //Field Localizacao
    fLocalizacao = new JTextField(5);
    fLocalizacao.setColumns(10);
    
    //Botoes Salvar, Limpar e cancelar
    //Botao salvar
     bSalvar = new JButton("Salvar");
     bSalvar.setForeground(Color.white);
    bSalvar.setBackground(Color.green);
    
    //Limpar
    bLimpar = new JButton("Limpar");
    bLimpar.setForeground(Color.white);
    bLimpar.setBackground(Color.blue);
    bLimpar.addActionListener(this);
    
    //Cancelar
    bCancelar = new JButton("Cancelar");
    bCancelar.setForeground(Color.white);
    bCancelar.setBackground(Color.red);
   }

    public Container painelComponentes() {
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // nome
         lab = new JLabel("Nome");
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(35, 15, 0, 0);// Insets de Label
        painel.add(lab, gbc);

        // Field nome
        gbc.insets = new Insets(10, 5, 0, 10);// Insets e Field,RadioButton, Combobox
        gbc.gridwidth =3 ;
        gbc.ipadx = 100;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy=1;
        painel.add(fNome, gbc);

        // Label Localizacao
        lab = new JLabel("Localizacao");
        gbc.insets = new Insets(35, 15, 0, 0);// Insets de Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(lab, gbc);

        // FIELD Localizacao
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.insets = new Insets(35, 5, 0, 10);// Insets e Field,RadioButton, Combobox
        painel.add(fLocalizacao, gbc);
        return painel;
    }
    
       public Container painelBotoes(){
   pBotoes= new JPanel(new GridBagLayout());
   pBotoes.setBackground(Color.white);
   
    // Botoes de baixo
        //Botao salvar   
        gbc.insets = new Insets(35, 5, 40, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth =1 ;
        pBotoes.add(bSalvar, gbc);

        //Botao cancelar
        gbc.gridx = 1;
        pBotoes.add(bCancelar, gbc);
        
        //Botao limpar
        gbc.gridx = 2;
        pBotoes.add(bLimpar, gbc);

   return pBotoes;
   } 

    public Container painelPrincipal(){
    pPrincipal= new JPanel(new BorderLayout());
    //Adicionar o painel de componentes
    pPrincipal.add(painelComponentes(),BorderLayout.CENTER);
    
     //Adicionar o painel de botoes
    pPrincipal.add(painelBotoes(),BorderLayout.PAGE_END);
    return pPrincipal;}
    

   
   public void criarJanela() {
        frame = new JFrame("CADASTRO DA VETERINARIA");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(painelPrincipal());
        frame.pack();

    }
    public static void main(String[] args) {
        new Cadastro_Veterianara();

    }

    public void Limpar(){
        fNome.setText("");
        fLocalizacao.setText("");
        fNome.requestFocus();}
  
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bLimpar){
        Limpar();}
        
         }

}
