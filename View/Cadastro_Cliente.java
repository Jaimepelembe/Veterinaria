package View;


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
import javax.swing.JComboBox;

public class Cadastro_Cliente {
    private JLabel nome, tel, morada;
    private JButton bSalvar, bCancelar, bLimpar;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cDistrito;
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Cliente(){
    criarJanela();
    }

    
    public void inicializarComponentes(){
    //Informacoes do nome
    //Label
    nome = new JLabel("Nome ");
    
   //TextField
    fNome = new JTextField(5);
    fNome.setColumns(10);
    
    //informacoes do telefone
    //Label
     tel = new JLabel("Telefone ");
     //TextField
     fTel = new JTextField();
     fTel.setColumns(10);
     
     //Informacoes da morada
     //Label
     morada = new JLabel("Morada");
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
       
      //Eliminar
       bLimpar = new JButton("Limpar");
       bLimpar.setForeground(Color.white);
       bLimpar.setBackground(Color.blue);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
  
    }
    
    public Container adicionarComponentes() {
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Informacoes d o nome
        // nome
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 0;
        gbc.gridx = 0;
        painel.add(nome, gbc);
        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(fNome, gbc);

        // SEGUNDA FILA
        // Label Telelfone
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painel.add(tel, gbc);

        // Field telefone
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fTel, gbc);

        // terceira
        // Label distrito
        gbc.insets = new Insets(35, 15, 40, 0);
        gbc.gridy = 2;
        gbc.gridx = 0;
        painel.add(morada, gbc);

        // Box distrito
        gbc.insets = new Insets(35, 5, 40, 20);
        gbc.ipady = 5;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cDistrito, gbc);

        // Butoes de baixo
        gbc.insets = new Insets(35, 5, 40, 10);
        // gbc.ipadx = 35;
        
        //Botao salvar
        gbc.ipady = 5;
        gbc.gridy = 3;
        gbc.gridx = 0;
        painel.add(bSalvar, gbc);
        
      //Botao Limpar
        gbc.gridx = 1;
        painel.add(bLimpar, gbc);
        
        //Cancelar
        gbc.gridx = 2;
        painel.add(bCancelar, gbc);


        return painel;

    }

    public void criarJanela() {
        frame = new JFrame("CADASTRO DE CLIENTE");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(adicionarComponentes());
        frame.pack();

    }

    public static void main(String[] args) {
     new Cadastro_Cliente();
     
        
        
    }

}