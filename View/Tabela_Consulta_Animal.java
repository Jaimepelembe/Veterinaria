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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Tabela_Consulta_Animal {

    private JLabel nome, tel, especie, raca, cor;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cCores, cRacas;
    private JTable tabela;
    private JButton bPesquisar;
    GridBagConstraints gbc = new GridBagConstraints();
       String[][] data = {
            { "Rex", "Canino", "PitBull", "Preto"},
            { "Kitty", "Felino", "Gatao", "Branco"} };
 
        // NOMES DAS COLUNAS
        String[] columnNames = { "NOME", "ESPECIE", "RAÇA", "COR"};

    public Tabela_Consulta_Animal(){
    criarJanela();
    }

    public Container componentes() {

        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
        // nome
        gbc.insets = new Insets(35, 15, 50, 50);
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 4;
        nome = new JLabel("Nome ");
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 50, 50);
        fNome = new JTextField(5);
        fNome.setColumns(28);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(fNome, gbc);
        
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

        // ESPECIES
        // Label ESPECIES
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 0;
        especie = new JLabel("ESPECIE");
        gbc.gridx = 0;
        painel.add(especie, gbc);

       /*  Box distrito
       gbc.insets = new Insets(35, 5, 0, 10);
        gbc.ipady = 5;
         String[] racas = {"Pastor Alemao", "Pitbull", "Pastor Belga", "Chiuaua"};
        cDistrito = new JComboBox(distritos);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cDistrito, gbc);*/
        
       //RACA DO ANIMAL
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 1;
        raca = new JLabel("RAÇA");
        gbc.gridx = 0;
        painel.add(raca, gbc); 

        // Box racas
        gbc.gridy = 1;
       gbc.insets = new Insets(35, 5, 0, 0);
        gbc.ipady = 5;
         String[] racas = {"Pastor Alemao", "Pitbull", "Pastor Belga", "Chiuaua"};
        cRacas = new JComboBox(racas);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cRacas, gbc);
       
        //COR DO ANIMAL
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 2;
        cor = new JLabel("COR");
        gbc.gridx = 0;
        painel.add(cor, gbc); 

        // Box cores
        gbc.gridy = 2;
       gbc.insets = new Insets(35, 5, 0, 0);
        gbc.ipady = 5;
           String[] cores = {"Branco", "Cizento", "Azul", "Amarelo"};
        cCores = new JComboBox(cores);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cCores, gbc);
        
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

    }

    public void criarJanela() {
        frame = new JFrame("CONSULTAR ANIMAL");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(componentes());
      //frame.add(tabela());
        frame.pack();

    }

    public static void main(String[] args) {
     new Tabela_Consulta_Animal();
     
        
        
    }

}
