/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Controller.AnimalController;
import Controller.VacinaController;
import Controller.Validacao;
import Model.VO.Animal;
import Model.VO.Vacina;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tabela_Consulta_Vacina implements ActionListener{
    
    private JLabel lab;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cListaMarcas, cNomesVacinas;
    private JTable tabela;
//    private JButton bPesquisar;
    private JPanel pPrincipal,painel,pTabela,pBotoes;
    private JRadioButton rbgato,rbcao;
    private ButtonGroup botoes;
    private JButton bLimpar, bCancelar;
    private GridBagConstraints gbc = new GridBagConstraints();
    private String[] listaMarcas = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT" };
    private String[] VacinasCaes={"Polivalente (V10) ","Antirrábica","Gripe","Giárdia","Esgana","Parvovirose "};
    private String[] VacinasGatos={"Panleucopénia","Antirrábica ","RinoTranquete","Leucemia","Peritonite infeciosa ","Clamídia"};
    private Validacao vv= new Validacao();

    public Tabela_Consulta_Vacina(){
    inicializarComponentes();
    //criarJanela();
    }

    public void inicializarComponentes(){
        painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.white);
       
        pBotoes= new JPanel(new GridBagLayout());
        pBotoes.setBackground(Color.white);
        
        pPrincipal= new JPanel(new BorderLayout());
        
        //Informacoes da Especie
        botoes = new ButtonGroup();
        //Canina
        rbcao = new JRadioButton("Canina");
        rbcao.setBackground(Color.WHITE);
        rbcao.addActionListener(this);
        
        //Felina
        rbgato = new JRadioButton("Felina");
        rbgato.setBackground(Color.WHITE);
        rbgato.addActionListener(this);
        botoes.add(rbcao);
        botoes.add(rbgato);
        
      
        //Combobox de marca
        cListaMarcas = new JComboBox(listaMarcas);
        cListaMarcas.setSelectedIndex(-1);
        cListaMarcas.addActionListener(this);
        
        //Combobox nome vacinas
        cNomesVacinas = new JComboBox();
        cNomesVacinas.setSelectedIndex(-1);
        cNomesVacinas.addActionListener(this);
        
        //Botoes
        //Botao limpar
        bLimpar = new JButton("Limpar");
        bLimpar.setForeground(Color.white);
        bLimpar.setBackground(Color.blue);
        bLimpar.addActionListener(this);
        bLimpar.setFocusPainted(false);

        //Botao cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar.setForeground(Color.white);
        bCancelar.setBackground(Color.red);
        bCancelar.addActionListener(this);
        bCancelar.setFocusPainted(false); 
        
    }
    public Container painelComponentes() {
      
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //Especie
        //Label Especie
        lab = new JLabel("Especie");
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 0;
        gbc.gridx = 0;
        painel.add(lab, gbc);
        
        // Informacoes RadioButtons
        gbc.insets = new Insets(35, 15, 0, 0);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 0;
        gbc.gridy=1;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);

        gbc.insets = new Insets(35, 15,0, 0);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);
        
       //MARCA DA VACINA
         lab = new JLabel("Marca");
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 2;
        gbc.gridx = 0;
        painel.add(lab, gbc); 

        // Box MARCAS VACINAS
        gbc.insets = new Insets(35, 5, 0, 0);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.ipady = 5;
        painel.add(cListaMarcas, gbc); 
        
        
        //NOME DA VACINA
        gbc.insets = new Insets(35, 15, 40, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        lab = new JLabel("Nome");
        painel.add(lab, gbc); 

        // ComBobox nomes
        gbc.insets = new Insets(35, 5, 40, 0);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.ipady = 5;
        painel.add(cNomesVacinas, gbc);
 
        return painel;
}  
    
  private Container painelTabela() {
        Object[][] data = {};
        String[] colunas = { "NOME", "PRECO","DATA DE VALIDADE","QUANTIDADE(ml)"};
        pTabela = new JPanel(new BorderLayout());
        pTabela.setBackground(Color.white);
        pTabela.setForeground(Color.white);
        // INICIALIZANDO a tabela
        tabela = new JTable(data, colunas);
        tabela.setBounds(30, 40, 200, 300);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
                data,
                colunas
        ) {
            Class[] types = new Class[]{
                java.lang.String.class,java.lang.Float.class,java.sql.Date.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        // Adicionar a tabela a um SCROLL PANE
        JScrollPane sp = new JScrollPane(tabela);
        sp.setForeground(Color.white);
        sp.setBackground(Color.white);
        pTabela.add(sp, BorderLayout.CENTER);
        return pTabela;
    }

  
   //Metodo para devolver o painel com os botoes Limpar e Cancelar
private Container painelBotoes() {
        // Botoes Cancelar e limpar
        //Limpar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 5, 10, 40);
        gbc.ipadx = 10;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pBotoes.add(bLimpar,gbc);

        //Botao cancelar
        gbc.gridx = 1;
        pBotoes.add(bCancelar,gbc);

        return pBotoes;
    }
  
 public Container PainelConsulta(){
 pPrincipal.add(painelComponentes(),BorderLayout.PAGE_START);
 pPrincipal.add(painelTabela(),BorderLayout.CENTER);
 pPrincipal.add(painelBotoes(),BorderLayout.PAGE_END);
 
 return pPrincipal;
 }

  //Metodo para selecionar o nome das vacinas de determinada especie
private void selecionarNomeVacina() {
        if (rbcao.isSelected()) {
            this.cNomesVacinas.removeAllItems();
            for (int i = 0; i < VacinasCaes.length; i++) {
                this.cNomesVacinas.addItem(VacinasCaes[i]);

            }

        }
        if (rbgato.isSelected()) {
            this.cNomesVacinas.removeAllItems();
            for (int i = 0; i < VacinasGatos.length; i++) {
                this.cNomesVacinas.addItem(VacinasGatos[i]);
            }

        }

    }

private void Limpar(){
botoes.clearSelection();
cListaMarcas.setSelectedIndex(-1);
cNomesVacinas.removeAllItems();

}
private void colocarIconMenu() {
        Menu_Principal a = new Menu_Principal("");
        a.iconPrincipal();
        a.mudarCor();
    }


 private void pesquisarVacinaMarca(String mark) {
        
        try {
            if (vv.validarString(mark)) {
                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                modelo.setRowCount(0);
                VacinaController vacina= new VacinaController();
                
                Vector<Vacina> vacinas = vacina.pesquisarVacinaMarca(mark);
                vacinas.forEach((Vacina vaci) -> {modelo.addRow(new Object[]{vaci.getNome(), vaci.getPreco(),vaci.getData(),vaci.getQuantidade()});
                });
                tabela.setModel(modelo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o a vacina pela marca" + ex);
        }
    }


 private void pesquisarVacinaNome(String name) {
        
        try {
            if (vv.validarString(name)) {
                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                modelo.setRowCount(0);
                VacinaController vacina= new VacinaController();
                
                Vector<Vacina> vacinas = vacina.pesquisarVacinaNome(name);
                vacinas.forEach((Vacina vaci) -> {modelo.addRow(new Object[]{vaci.getNome(), vaci.getPreco(),vaci.getData(),vaci.getQuantidade()});
                });
                tabela.setModel(modelo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o a vacina pelo nome" + ex);
        }
    }


    
    public void criarJanela() {
        frame = new JFrame("CONSULTAR VACINAS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(PainelConsulta());
      //frame.add(tabela());
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
     new Tabela_Consulta_Vacina();  
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bLimpar){
            Limpar();
        }
        
        if(e.getSource()==bCancelar){
        colocarIconMenu();
        }
        
        
        if(e.getSource()==rbcao){
        selecionarNomeVacina();
        cNomesVacinas.setSelectedIndex(-1);
        
        }
        if(e.getSource()==rbgato){
        selecionarNomeVacina();
        cNomesVacinas.setSelectedIndex(-1);
        }
        if(e.getSource()==cListaMarcas && cListaMarcas.isShowing()){
            
                if(cListaMarcas.getSelectedIndex()>=0){
            String marca=cListaMarcas.getSelectedItem().toString();
            pesquisarVacinaMarca(marca);
                cNomesVacinas.setSelectedIndex(-1);
                }
        }
        
        if(e.getSource()==cNomesVacinas && cNomesVacinas.isShowing()){
            if(cNomesVacinas.getSelectedIndex()>=0){
        String nome=cNomesVacinas.getSelectedItem().toString();
        pesquisarVacinaNome(nome);
            cListaMarcas.setSelectedIndex(-1);
            }
        }
        
        
       }
}
