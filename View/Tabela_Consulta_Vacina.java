/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Tabela_Consulta_Vacina {
    
    private JLabel marca,nomeVacina;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cListaMarcas, cNomesVacinas;
    private JTable tabela;
    private JButton bPesquisar;
    private JPanel pPrincipal,painel;
    GridBagConstraints gbc = new GridBagConstraints();
     private String[] listaMarcas = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT" };
    private String[] Vacinas_Caes = { "Polivalente (V10)", "Antirrábica", "Contra a gripe", "contra Giárdia", "Esgana",
            "Parvovirose" };
     String[][] data = {
            { "Zoetis", "Antirrabica", "500", "19-02-2022"} };
 
        // NOMES DAS COLUNAS
        String[] columnNames = { "MARCA", "NOME", "QUANTIDADE(ml)", "DATA DE VALIDADE"};

    public Tabela_Consulta_Vacina(){
    criarJanela();
    }

    public void inicializarComponentes(){
        painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        
        pPrincipal= new JPanel(new BorderLayout());
        
        //Botao pesquisar
        bPesquisar = new JButton("PESQUISAR");
        bPesquisar.setForeground(Color.WHITE);
        bPesquisar.setBackground(Color.blue);
        
        //Combobox de marca
        cListaMarcas = new JComboBox(listaMarcas);
        cListaMarcas.setSelectedIndex(-1);
        
        //Combobox nome vacinas
        cNomesVacinas = new JComboBox(Vacinas_Caes);
        cNomesVacinas.setSelectedIndex(-1);
    }
    public Container adicionarcomponentes() {
        inicializarComponentes();
        gbc.fill = GridBagConstraints.HORIZONTAL;

          // BOTAO PESQUISAR
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        painel.add(bPesquisar, gbc);

        
       //MARCA DA VACINA
         marca = new JLabel("MARCA");
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painel.add(marca, gbc); 

        // Box MARCAS VACINAS
        gbc.gridy = 1;
       gbc.insets = new Insets(35, 5, 0, 0);
        gbc.ipady = 5;
        
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cListaMarcas, gbc);
       
        //NOME DA VACINA
        gbc.insets = new Insets(35, 15, 20, 30);
        gbc.gridy = 2;
        nomeVacina = new JLabel("Nome");
        gbc.gridx = 0;
        painel.add(nomeVacina, gbc); 

        // Box nomes
        gbc.gridy = 2;
       gbc.insets = new Insets(35, 5, 20, 0);
        gbc.ipady = 5;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cNomesVacinas, gbc);
        
         //tabela
        gbc.insets = new Insets(35, 5, 40, 50);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.gridwidth = 4;
        // INICIALIZANDO
        tabela = new JTable(data, columnNames);
        //tabela.setBounds(30, 40, 200, 300);

        // SCROLL PANE
        JScrollPane sp = new JScrollPane(tabela);
        painel.add(sp, gbc);
        
        pPrincipal.add(painel,BorderLayout.PAGE_START);
        pPrincipal.add(sp,BorderLayout.CENTER);

        return pPrincipal;

    
    
}    public void criarJanela() {
        frame = new JFrame("CONSULTAR VACINAS");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(adicionarcomponentes());
      //frame.add(tabela());
        frame.pack();

    }

    public static void main(String[] args) {
     new Tabela_Consulta_Vacina();
     
        
        
    }}
