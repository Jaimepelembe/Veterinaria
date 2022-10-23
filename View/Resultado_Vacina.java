/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author multi
 */
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

public class Resultado_Vacina {
    private JLabel lab;
    private JButton bSalvar, bEliminar, bCancelar;
    private JTextField  tfNome, tfQuantidade, tfPreco_Aquisicao, tfValidade, tfTemperatura;
    private JComboBox cbMarca, cbNome;
    private String[] listaMarca = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT" };
    private String[] Vacinas_Caes = { "Polivalente (V10)", "Antirrábica", "Contra a gripe", "contra Giárdia", "Esgana",
            "Parvovirose" };
    private String[] Vacinas_Gatos = { "Panleucopénia felina", "Antirrábica", "RinoTranquete" };
    private JPanel pPrincipal;   
  
    private JFrame janela;
    private JSpinner spQuantidade;
    GridBagConstraints gbc = new GridBagConstraints();   

    public Resultado_Vacina() {
        createWindow();
    }
    
    public void inicializarComponentes(){
    //Informacoes da marca
    //Combobox
     cbMarca = new JComboBox<>(listaMarca);
     cbMarca.setSelectedIndex(-1);
     
      // informacoes nome
      //Combobox dos nomes
      cbNome = new JComboBox<>();
      cbNome.setSelectedIndex(-1);
      
      //Spinner Quantidade de vacinas
       spQuantidade = new JSpinner();
       spQuantidade.setValue(0.5);
       spQuantidade.setToolTipText("Indique a quantidade");
       
       //Informacoes do preco de aquisicao
       tfPreco_Aquisicao= new JTextField();
       
       //TextField da temperatura
       tfTemperatura = new JTextField();
       tfTemperatura.setColumns(10);
       
       //TextField data
        tfValidade = new JTextField();
        tfValidade.setColumns(10);
           
     //Botoes 
     //Salvar
       bSalvar = new JButton("Salvar");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(Color.green);
       
      //Eliminar
       bEliminar = new JButton("Eliminar");
       bEliminar.setForeground(Color.white);
       bEliminar.setBackground(Color.ORANGE);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
    
    }
    
    
    public Container AdicionarComponentes() {
        inicializarComponentes();
        JPanel pPrincipal = new JPanel(new GridBagLayout());

        // informacoes Marca
        lab = new JLabel("Marca:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

       //ComboBox marca
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 15, 10, 0);
        pPrincipal.add(cbMarca, gbc);

        // informacoes nome
        //Label
        lab = new JLabel("Nome:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        //Combobox nome
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 10, 0);
        pPrincipal.add(cbNome, gbc);

        // Informacoes da Quandidade
        lab = new JLabel("Quantidade:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

       //Spinner quantidade de vacinas
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 1;
        gbc.ipady=5;
        gbc.insets = new Insets(0, 15, 10, 0);
        pPrincipal.add(spQuantidade, gbc);
        //label ml
        lab = new JLabel("ml");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 5, 0);
        pPrincipal.add(lab, gbc);

        // Informacoes do Preco Aquisicao
        lab = new JLabel("Preco Aquisição:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx=1;
        gbc.ipady=5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);
        
        //TextField preco de aquisicao
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 10, 0);
        pPrincipal.add(tfPreco_Aquisicao, gbc);

        // Temperatura Conservacao
        lab = new JLabel("Temperatura Conservação:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        //TextField de temperatura 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 10, 0);
        pPrincipal.add(tfTemperatura, gbc);

        // informacoes da data de validade Validade
        lab = new JLabel("Data validade:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);
        
        //TextField da data 
        gbc.insets = new Insets(0, 15, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
       
        pPrincipal.add(tfValidade, gbc);
        
    

        // Botoes
        // Salvar
        gbc.insets = new Insets(35, 5, 40, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx=10;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
       
        pPrincipal.add(bSalvar, gbc);

        // Eliminar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
          gbc.ipadx=10;
          gbc.ipady=5;
        gbc.weightx=0;
        gbc.insets = new Insets(35, 45, 40, 60);
        pPrincipal.add(bEliminar, gbc);
        
        
        // Cancelar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.ipadx=10;
        gbc.insets = new Insets(35, 5, 40, 1);
        pPrincipal.add(bCancelar, gbc);

        return pPrincipal;
    }

    public void createWindow() {
        janela = new JFrame("RESULTADO DA CONSULTA DA VACINA");
        janela.setLayout(new GridBagLayout());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        // Adicicao dos componentes a janela
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        // gbc.gridwidth = 1;
        janela.add(AdicionarComponentes(), gbc);
        janela.pack();
        janela.setVisible(true);

    }
    public static void main(String[] args) {
        new Resultado_Vacina();
    }
}
