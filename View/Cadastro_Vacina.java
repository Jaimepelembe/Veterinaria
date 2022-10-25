package View;




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

public class Cadastro_Vacina implements  ActionListener {
    private JLabel nome, marca, quant,preco, dtVal ;
    private JButton bSalvar, bCancelar, bLimpar;
    private JTextField fNome, fPreco;
    private JFormattedTextField  fDtVal;
    private JFrame frame;
    private JComboBox cMarca;
    private JSpinner spQuant;
     private String[] listaMarca = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT","Outro" };
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Vacina() {

    criarJanela();
    }
    

    
    public void inicializarComponentes(){
    //Informacoes do nome
    //Label
    nome = new JLabel("Nome ");
    nome.setForeground(Color.gray);
    
   //TextField
    fNome = new JTextField(5);
    fNome.setColumns(20);
    
    //informacoes da marca
    //Label
    marca = new JLabel("Marca");
      cMarca = new JComboBox(listaMarca);
      cMarca.setSelectedIndex(-1);
     //BOX
     marca.setForeground(Color.gray);
     
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
     
   //INFORMACOES SOBRE DATA 
     //Label
    dtVal = new JLabel("Data de Validade ");
    dtVal.setForeground(Color.gray);
    
   //TextField
    fDtVal = new JFormattedTextField();
    fDtVal.setColumns(20);
    formatarCampo(fDtVal);

        
        
     //Botoes 
     //Salvar
       bSalvar = new JButton("       Salvar       ");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(Color.green);
       bSalvar.setBorderPainted(false);
       
      //Eliminar
       bLimpar = new JButton("Limpar");
       bLimpar.setForeground(Color.white);
       bLimpar.setBackground(Color.blue);
       bLimpar.setBorderPainted(false);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
        bCancelar.setBorderPainted(false);
  
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

        // Informacoes d o nome
        // nome
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.ipady = 12;
        painel.add(nome, gbc);
        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        painel.add(fNome, gbc);

        // SEGUNDA FILA
        // Label MARCA
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painel.add(marca, gbc);

        // BOX MARCA
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.ipady = 6;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        painel.add(cMarca, gbc);

        // terceira
        // Label quant
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 4;
        gbc.gridx = 1;
        painel.add(quant, gbc);

        // SPINNER QUANT
        gbc.insets = new Insets(35, 5, 40, 10);
        gbc.ipady = 15;
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(spQuant, gbc);
        
        
        
        
        // Informacoes dE preco
        // precp
        gbc.insets = new Insets(35, 45, -27, 0);
        gbc.gridy = 0;
        gbc.gridx = 2;
        gbc.ipady = 12;
        painel.add(preco, gbc);
        // Field nome
        gbc.insets = new Insets(35, 35, 0, 10);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        painel.add(fPreco, gbc);

        // SEGUNDA FILA
        // Label data
        gbc.insets = new Insets(35, 45, -27, 0);
        gbc.gridy = 2;
        gbc.gridx = 2;
        painel.add(dtVal, gbc);

        // field data
        gbc.insets = new Insets(35, 35, 0, 10);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        painel.add(fDtVal, gbc);

        
        
        
        
        
        
        
        
        
        
        
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

    

    public void criarJanela() {
        frame = new JFrame("CADASTRO DE VACINA");
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(730, 690);
        frame.add(adicionarImagens(), BorderLayout.NORTH);
        frame.add(adicionarComponentes(), BorderLayout.CENTER);
         frame.add(adicionarBotoes(), BorderLayout.SOUTH);
        ImageIcon img = new ImageIcon("C:/Users/Valter Boa/Documents/NetBeansProject/veterinaria/src/Imagens/iconVacina.png");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    

    public static void main(String[] args) {
     new Cadastro_Vacina();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
