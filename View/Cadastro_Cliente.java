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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Cadastro_Cliente {
      private JLabel nome, tel, morada,lab;
    private JButton bSalvar, bCancelar, bLimpar;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cDistrito;
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Cliente () {

    criarJanela();
    }

    
    public void inicializarComponentes(){
    //Informacoes do nome
    //Label
    nome = new JLabel("Nome ");
   nome.setForeground(Color.gray);
    
   //TextField
    fNome = new JTextField(5);
    fNome.setColumns(25);
    
    
    //informacoes do telefone
    //Label
     tel = new JLabel("Telefone ");
     //TextField
     fTel = new JTextField();
     fTel.setColumns(25);
     tel.setForeground(Color.gray);
     
     //Informacoes da morada
     //Label
     morada = new JLabel("Morada");
     morada.setForeground(Color.gray);
     //ComboBox
      String[] distritos = { "Matola", "Marracuene", "Manhiça", "Magude", "Moamba", "Boane", "Namaacha",
                "Matutuine" };
        cDistrito = new JComboBox(distritos);
        cDistrito.setSelectedIndex(-1);
        
     //Botoes 
     //Salvar
       bSalvar = new JButton("Salvar");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(Color.green);
       bSalvar.setBorderPainted(false);
       
      //Eliminar
       bLimpar = new JButton("Limpar");
       bLimpar.setForeground(Color.white);
       bLimpar.setBackground(Color.blue);
       bLimpar.setBorderPainted(false);
    //  bLimpar.addActionListener(this);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
        bCancelar.setBorderPainted(false);
  
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
        // Label Telelfone
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painel.add(tel, gbc);

        // Field telefone
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        painel.add(fTel, gbc);

        // terceira
        // Label distrito
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 4;
        gbc.gridx = 1;
        painel.add(morada, gbc);

        // Box distrito
        gbc.insets = new Insets(35, 5, 40, 10);
        gbc.ipady = 5;
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cDistrito, gbc);
        return painel;

    }
public Container adicionarBotoes() {
      
        inicializarComponentes();
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
       pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
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

public Container adicionarImagens() {
      
        inicializarComponentes();
        JPanel pImagens = new JPanel();
        ImageIcon imageIcon;
        
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("cliente.jpg"));
        pImagens.add(label);
        pImagens.setBackground(Color.white);
        
   
    

    return pImagens;
}

    

    public void criarJanela() {
        frame = new JFrame("CADASTRO DE CLIENTE");
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(730, 650);
        frame.add(adicionarImagens(), BorderLayout.NORTH);
        frame.add(adicionarComponentes(), BorderLayout.CENTER);
         frame.add(adicionarBotoes(), BorderLayout.SOUTH);
        ImageIcon img = new ImageIcon("icon.jpg");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    

    public static void main(String[] args) {
     new Cadastro_Cliente ();
        
    }
    
    public void Limpar(){
     fNome.setText("");
     fTel.setText("");
     cDistrito.setSelectedIndex(-1);
     fNome.requestFocus();
     
 }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bLimpar){
        Limpar();}
        }

}