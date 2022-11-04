/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ClienteController;
import Model.VO.Cliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Tabela_Consulta_Cliente implements ActionListener{

    private JLabel nome, tel, morada;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cDistrito;
    private JTable tabela;
    private JButton bPesquisar;
    private JPanel pPrincipal, pTabela,painel;
    private GridBagConstraints gbc = new GridBagConstraints();
    private String[] distritos = {"Matola", "Marracuene", "Manhiça", "Magude", "Moamba", "Boane", "Namaacha",
        "Matutuine"};

    public Tabela_Consulta_Cliente() {
        inicializarComponentes();
        criarJanela();
    }

    private void inicializarComponentes(){
     painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        //Label Nome
        nome = new JLabel("   Nome");
        nome.setForeground(Color.gray);
        //TextField Nome
         fNome = new JTextField(5);
        fNome.setColumns(17);
        //Label Telefone
        tel = new JLabel("Telefone ");
        tel.setForeground(Color.gray);
        //Field Telefone
        fTel = new JTextField();
        fTel.setColumns(9);
        
        //Label Morada
        morada = new JLabel(" Morada");
        morada.setForeground(Color.gray);
        
        //Combobox Morada
        cDistrito = new JComboBox(distritos);
        cDistrito.setSelectedIndex(-1);
        cDistrito.addActionListener(this);
        
        //Botoes
        //Pesquisar
        bPesquisar = new JButton("PESQUISAR");
        bPesquisar.setForeground(Color.WHITE);
        bPesquisar.setBackground(Color.blue);
        
        
        
    }
    private Container adicionarComponentes() {
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
        // nome
        gbc.insets = new Insets(35, 25, 0, 0);
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 1;
       
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        painel.add(fNome, gbc);

        // SEGUNDA FILA
        // Label Telelfone
        gbc.insets = new Insets(35, 95, 0, 0);
        gbc.gridy = 1;
        gbc.gridx = 2;
        painel.add(tel, gbc);
        gbc.ipady = 6;
        
        // Field telefone
        gbc.insets = new Insets(35, 70, 0, 20);
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        painel.add(fTel, gbc);

        // terceira
        // Label distrito
        gbc.insets = new Insets(35, 25, 0, 0);
        gbc.gridy = 0;
        gbc.gridx = 0;
        painel.add(morada, gbc);

        // ComboBox Morada
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.ipady = 5;
        gbc.ipadx=10;
        gbc.gridwidth=1;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(cDistrito, gbc);

        // BOTAO PESQUISAR
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 15, -35, 0);
        painel.add(bPesquisar, gbc);

        return painel;

    }

    public Container painelPrincipal() {
        pPrincipal = new JPanel(new BorderLayout());
        pPrincipal.setBackground(Color.white);
        pPrincipal.setForeground(Color.white);
        pPrincipal.add(adicionarComponentes(), BorderLayout.CENTER);
        pPrincipal.add(painelTabela(), BorderLayout.PAGE_END);

        return pPrincipal;
    }

    private Container painelTabela() {
     Object[][] data= {};
     String[] colunas={"NOME", "TELEFONE", "MORADA","NUMERO ANIMAIS"
            };
        pTabela = new JPanel(new BorderLayout());
        pTabela.setBackground(Color.white);
        pTabela.setForeground(Color.white);
        // INICIALIZANDO a tabela
        tabela = new JTable(data, colunas);
        tabela.setBounds(30, 40, 200, 300);
       // tabela.setForeground(Color.white);
        //tabela.setBackground(Color.white);
  
   tabela.setModel(new javax.swing.table.DefaultTableModel(
           data,
            colunas
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
   
        // Adicionar a tabela ap SCROLL PANE
        JScrollPane sp = new JScrollPane(tabela);
        sp.setForeground(Color.white);
        sp.setBackground(Color.white);
        pTabela.add(sp, BorderLayout.CENTER);
        return pTabela;
    }

        private void pesquisarClienteMorada(){
    String morada="";
    if(cDistrito.getSelectedItem()!=null){
    morada=cDistrito.getSelectedItem().toString();
    }
    try{
    if(morada!=null && morada.length()>0){
        DefaultTableModel modelo= (DefaultTableModel)tabela.getModel();
        modelo.setRowCount(0);
        ClienteController cliente = new ClienteController();
        Vector<Cliente> clientes=cliente.pesquisarClienteMorada(morada);
        clientes.forEach((Cliente cli)->{modelo.addRow(new Object[]{cli.getNome(),cli.getTelefone(),cli.getMorada()});});
        tabela.setModel(modelo);
    }
    }
    catch(Exception ex){ JOptionPane.showMessageDialog(null, "Erro ao pesquisar o actor"+ex);}
    }
    private void criarJanela() {
        frame = new JFrame("CONSULTAR CLIENTE");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(880, 750);
        frame.add(painelPrincipal());
        //frame.add(tabela());
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Tabela_Consulta_Cliente();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==cDistrito){
       pesquisarClienteMorada();
       }
    }

}
