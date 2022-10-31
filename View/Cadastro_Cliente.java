package View;



import Controller.ClienteController;
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
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Cadastro_Cliente implements ActionListener{
      private JLabel nome, tel, morada,lab;
    private JButton bSalvar, bCancelar, bLimpar;
    private JTextField fNome;
    private JFormattedTextField fTel;
    private JFrame frame;
    private JComboBox cDistrito;
    private JPanel pAuxiliar;
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Cliente () {
   criarJanela();
    }

    public JButton cancelar(){
    return bCancelar;}
    
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
     fTel = new JFormattedTextField();
     fTel.setColumns(25);
     tel.setForeground(Color.gray);
//        formatarCampo(fTel);
     
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
       bSalvar = new JButton("       Salvar       ");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(Color.green);
       bSalvar.setBorderPainted(false);
       bSalvar.setFocusPainted(false);
       bSalvar.addActionListener(this);
       
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
        bCancelar.setFocusPainted(false);
  
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
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
       pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 2;
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
        JPanel pImagens = new JPanel();
        ImageIcon imageIcon;
        
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src/Imagens/Entidades/cliente.jpg"));
        pImagens.add(label);
        pImagens.setBackground(Color.white);

    return pImagens;
}
public Container pPrincipal() {
        JPanel pPrincipal = new JPanel(new BorderLayout());
        pAuxiliar= new JPanel(new BorderLayout());
        
        ImageIcon imageIcon;
        
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src/Imagens/Entidades/cliente.jpg"));
        pPrincipal.add(adicionarImagens(), BorderLayout.NORTH);
        pPrincipal.add(adicionarComponentes(), BorderLayout.CENTER);
        pPrincipal.add(adicionarBotoes(), BorderLayout.SOUTH);
        pPrincipal.setBackground(Color.white);
        pAuxiliar.add(pPrincipal);

    return pAuxiliar;
}


    

    public void criarJanela() {
        frame = new JFrame("CADASTRO DE CLIENTE");
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630, 650);
         frame.add(pPrincipal());
        ImageIcon img = new ImageIcon("src/Imagens/Entidades/icon.jpg");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    

    public static void main(String[] args) {
     new Cadastro_Cliente ();
        
    }

    public void Limpar(){
    this.fNome.setText("");
    this.fTel.setText("");
    this.cDistrito.setSelectedIndex(-1);
    
    }
    public void SalvarDados(){
        //nome do cliente
    String nome = fNome.getText();
    //telefone do cliente
    String telefone = fTel.getText();
    //morada
    String morada = cDistrito.getSelectedItem().toString();
    
     boolean sucesso;
    try{ClienteController cliente = new ClienteController();
    sucesso=cliente.cadastrarCliente(nome, telefone, morada);
    if(sucesso){
    JOptionPane.showMessageDialog(null, "O Cliente foi cadastrado com sucesso");
    }
    else{JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o Cliente");}
    }catch(Exception ex){ JOptionPane.showMessageDialog(null, "Erro ao coletar dados do cliente"+ex);}
    
    
    
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==bLimpar){
      Limpar();}
      if(e.getSource()==bCancelar){}
          
     //Evento para salvar os dados do cliente na BD
        if(e.getSource()==bSalvar){
        SalvarDados();
        Limpar();
        }
      }
      
    }
    

   

