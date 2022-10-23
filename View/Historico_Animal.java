/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author multi
 */
public class Historico_Animal {
   private JTextField tfNome;
   private JTable tabela;
   private  JLabel lab,lbnomeClie;
   private JScrollPane scrool;
   
private String [] colunas={"Vacinas","Cirurgias","Exames","Total gasto"};
private Object[][] dados={{new Integer(10),new Integer(2), new Integer(3),new Double(550)},{new Integer(8),new Integer(5), new Integer(6),new Double(2250)}};
private JFrame frame;
private JPanel painel,Pauxiliar;
private JButton bVoltar;
private GridBagConstraints gbc = new GridBagConstraints();

    public Historico_Animal() {
        criarJanela();
    }
    
    public void inicializarComponentes(){
        //Informacoes do Nome do cliente
        lbnomeClie= new JLabel("Jaime");
        
        tfNome = new JTextField();
        tfNome.setColumns(15);
        
        //Tabela
        tabela= new JTable(dados,colunas);
        scrool = new JScrollPane(tabela);
        tabela.setFillsViewportHeight(true);
        
        //Definir o comprimento das colunas
        TableColumn column=null;
        
    for(int i=0; i<4;i++){
    column= tabela.getColumnModel().getColumn(i); 
    column.setPreferredWidth(20);
    }
     
    //Botao voltar
      bVoltar = new JButton("Voltar");
      bVoltar.setForeground(Color.white);
      bVoltar.setBackground(Color.green);
    }
    
    public Container adicionarComponentes(){
        inicializarComponentes();
    painel= new JPanel(new BorderLayout());//Usei Border Layout para auxiliar
    painel.setBackground(Color.white);
    
    Pauxiliar= new JPanel(new GridBagLayout());
    Pauxiliar.setBackground(Color.white);
   
    
    //Informacoes do nome do cliente
    //Label
    lab= new JLabel("Cliente: ");
    lab.setFont(new java.awt.Font("Calibri", 0, 22));
    gbc.gridx=0;
    gbc.gridy=0;
    gbc.insets= new Insets(0, 5, 10, 0);
    painel.add(lab);
    Pauxiliar.add(lab,gbc);
    
    //Label nome cliente
    gbc.gridx=1;
    gbc.ipadx=10;
    gbc.ipady=3;
    gbc.gridwidth=1;
    gbc.insets= new Insets(0, 35, 10, 0);
    lbnomeClie.setFont(new java.awt.Font("Calibri",1,22));
    painel.add(lbnomeClie);
    Pauxiliar.add(lbnomeClie,gbc);
    painel.add(Pauxiliar,BorderLayout.PAGE_START);
    
    //Adicionar o scroll
    gbc.gridx=0;
    gbc.gridy=1;
    gbc.gridwidth=2;
    painel.add(scrool,BorderLayout.CENTER);
    //Pauxiliar.add(scrool,gbc);
   
 
    
    //painel.add(Pauxiliar);
    
    return painel;
    }
    public void criarJanela() {
        frame = new JFrame("HISTORICO DO ANIMAL");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(adicionarComponentes());
        frame.pack();

    }
    public static void main(String[] args) {
        new Historico_Animal();
    }
    
}
