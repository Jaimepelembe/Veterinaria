/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Valter Boa 53
 */
import java.awt.BorderLayout;
import javax.swing.JButton;
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
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Vacinacao  implements ActionListener{
       private JLabel animal, vacina, data, quant, preco ;
    private JButton bSalvar, bCancelar, bLimpar;
    private JTextField fData, fPreco;
    private JFormattedTextField  fDtVal;
    private JFrame frame;
    private JComboBox cMarca, cAnimal;
    Color corSalvar = new Color(0.05f, 0.72f, 0.08f, 1.0f);
    Color corLimpar = new Color(0.05f, 0.31f, 0.72f, 1.0f);
    private JSpinner spQuant;
     private String[] listaMarca = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT","Outro" };
    GridBagConstraints gbc = new GridBagConstraints();
    
     public Vacinacao() {
    criarJanela();
    }
    
     public void inicializarComponentes(){
    //Informacoes do Animal
    //Label
    animal = new JLabel("Animal ");
    animal.setForeground(Color.gray);
    
   //bocx de animais
      cAnimal = new JComboBox();
      cAnimal.setSelectedIndex(-1);
    
    //informacoes da vacina
    //Label
    vacina = new JLabel("Vacina");
      cMarca = new JComboBox(listaMarca);
      cMarca.setSelectedIndex(-1);
     //BOX
     vacina.setForeground(Color.gray);
     
     
     //Informacoes QUANTIDADE
     //Label
     quant = new JLabel("Quantidade");
     quant.setForeground(Color.gray);
     
     //SPINNER QUANTIDADE
     spQuant = new JSpinner();
     
      //Informacoes do preco
    //Label
    preco = new JLabel("Preco (MZN) ");
    preco.setForeground(Color.gray);
    
   //TextField
    fPreco = new JTextField(5);
    fPreco.setColumns(20);
     
   //INFORMACOES SOBRE DATA da vacinacao 
     //Label
    data = new JLabel("Data de Vacinação ");
    data.setForeground(Color.gray);
    
   //TextField
    fData = new JFormattedTextField();
    fData.setColumns(20);
    formatarCampo(fData);

        
        
     //Botoes 
     //Salvar
       bSalvar = new JButton("    Salvar       ");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(corSalvar);
       bSalvar.setBorderPainted(false);
       bSalvar.setFocusPainted(false);
      //bSalvar.addActionListener(this);
       
      //limpar
       bLimpar = new JButton("Limpar");
       bLimpar.setForeground(Color.white);
       bLimpar.setBackground(corLimpar);
       bLimpar.setBorderPainted(false);
       bLimpar.addActionListener(this);
       bLimpar.setFocusPainted(false);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusPainted(false);
        bCancelar.addActionListener(this);
  
    }
    
       private  void formatarCampo(JTextField campoTexto){
         try {
             MaskFormatter mascara = new MaskFormatter();
              if(campoTexto==fDtVal){
              mascara.setMask("##/##/####");
             mascara.install( fDtVal);
           }
               
         } catch (ParseException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao formatar Campo de texto");
         }
    
         
    }
     public Container adicionarComponentes() {
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
         
        JLabel vazio = new JLabel("");
         gbc.insets = new Insets(35, 15, 77, 0);
         painel.add(vazio, gbc);
        
// Informacoes da vacina
        // Animal
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.ipady = 12;
        painel.add(animal, gbc);
        
        // box vacina/ marca
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        painel.add(cAnimal, gbc);

        
        // SEGUNDA FILA
        // Label vacina
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 3;
        gbc.gridx = 1;
        painel.add(vacina, gbc);

        // BOX MARCA
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.ipady = 6;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        painel.add(cMarca, gbc);

        // terceira
        // Label quant
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 3;
        gbc.gridx = 2;
        
        painel.add(quant, gbc);

        // SPINNER QUANT
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.ipady = 15;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        painel.add(spQuant, gbc);
       
        // SEGUNDA FILA
        // Label data
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 5;
        gbc.gridx = 1;
        painel.add(data, gbc);

        // field data
        gbc.insets = new Insets(35, 5, 70, 10);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fData, gbc);
         
        // Informacoes dE preco
        // precp
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 5;
        gbc.gridx = 2;
        gbc.ipady = 12;
        painel.add(preco, gbc);
        
        // Field preco
        gbc.insets = new Insets(35, 5, 70, 10);
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        painel.add(fPreco, gbc);

        
        return painel;

    }
public Container adicionarBotoes() {
      
        inicializarComponentes();
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
       pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, -5, 50, 15);
        // add buttons to the panel
         gbc.ipady = 4;
        gbc.gridy=0;
        gbc.gridx = 0;
        pBotoes.add(bSalvar,gbc);
        gbc.gridx = 1;
        pBotoes.add(bLimpar,gbc);
        gbc.gridx = 2;
        pBotoes.add(bCancelar,gbc);
    return pBotoes;
}
 public Container componentes() {
JPanel  pComponentes = new JPanel();
pComponentes.setBackground(Color.white);
pComponentes.add(adicionarImagens(), BorderLayout.NORTH);
        pComponentes.add(adicionarComponentes(), BorderLayout.CENTER);
         pComponentes.add(adicionarBotoes(), BorderLayout.SOUTH);
 
 return pComponentes;}
 public Container adicionarImagens() {
        inicializarComponentes();
        JPanel pImagens = new JPanel();
        ImageIcon imageIcon;
        
        JLabel label = new JLabel();
      label.setIcon(new ImageIcon("C:/Users/Valter Boa/Documents/NetBeansProject/veterinaria/src/Imagens/vacina.png"));
        pImagens.add(label);
        pImagens.setBackground(Color.white);
    return pImagens;
}

 
    public void Limpar() {
        cMarca.setSelectedIndex(-1);
        preco.setText("");
        data.setText("");
        //spQuant
        cMarca.setSelectedIndex(-1);
    }
    
        public void criarJanela() {
        frame = new JFrame("vacinação");
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(730, 690);
       frame.add(componentes());
        ImageIcon img = new ImageIcon("C:/Users/Valter Boa/Documents/NetBeansProject/veterinaria/src/Imagens/iconVacina.png");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
         //Volta a colocar a imagem central no Painel do menu Principal
    public void colocarIconMenu() {
        Menu_Principal a = new Menu_Principal("");
        a.iconPrincipal();
        a.mudarCor();
    }
    
   public static void main(String[] args) {
     new Vacinacao(); 
    }

      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
        
          if(e.getSource()==bCancelar){
       colocarIconMenu();
       }
         
    }
      

}
