/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


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

    public Container componentes() {

        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

          // BOTAO PESQUISAR
        bPesquisar = new JButton("PESQUISAR");
        bPesquisar.setForeground(Color.WHITE);
        bPesquisar.setBackground(Color.blue);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        painel.add(bPesquisar, gbc);

        
       //MARCA DA VACINA
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 1;
        marca = new JLabel("MARCA");
        gbc.gridx = 0;
        painel.add(marca, gbc); 

        // Box MARCAS VACINAS
        gbc.gridy = 1;
       gbc.insets = new Insets(35, 5, 0, 0);
        gbc.ipady = 5;
        cListaMarcas = new JComboBox(listaMarcas);
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
        cNomesVacinas = new JComboBox(Vacinas_Caes);
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
        tabela.setBounds(30, 40, 200, 300);
        painel.add(tabela, gbc);

        // SCROLL PANE
        JScrollPane sp = new JScrollPane(tabela);
        painel.add(sp, gbc);

        return painel;

    
    
}    public void criarJanela() {
        frame = new JFrame("CONSULTAR VACINAS");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(componentes());
      //frame.add(tabela());
        frame.pack();

    }

    public static void main(String[] args) {
     new Tabela_Consulta_Vacina();
     
        
        
    }}
