/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AnimalController;
import Controller.ClienteController;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Cliente;
import com.itextpdf.text.DocumentException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class Tabela_Consulta_Animal extends MouseAdapter implements ActionListener {

    private JLabel nome, especie, raca;
    private JPanel pTabela,pPrincipal;
    private JTextField fNome;
    private JFrame frame;
    private JComboBox cCores, cRacas;
    private JTable tabela;
    private JButton bPesquisar, bRelatorio;
    private ButtonGroup botoes;
    private JRadioButton rbcao, rbgato;
    private Vector<Animal> animais;
    GridBagConstraints gbc = new GridBagConstraints();
    private String[] racas_caes = {"Chow chow", "Chiuaua", "Doberman", "Husky siberiano", "Pastor Alemao", "Pitbull", "Pastor Belga", "outro"};
    private String[] racas_gatos = {"Bengal", "British Shorthair", "Maine Coon", "Munchkin", "Persa", "Ragdoll", "Sphynx", "outro"};
Color corSalvar = new Color(0.05f, 0.72f, 0.08f, 1.0f);
    Color corLimpar = new Color(0.05f, 0.31f, 0.72f, 1.0f);
    public Tabela_Consulta_Animal() {
        inicializar();
        criarJanela();
    }

    public void inicializar() {

        //Especie
        especie = new JLabel("Especie ");
        botoes = new ButtonGroup();
        //Canina
        rbcao = new JRadioButton("Especie - Canina");
        rbcao.setBackground(Color.WHITE);
        rbcao.addActionListener(this);
        
        //Felina
        rbgato = new JRadioButton("Especie - Felina");
        rbgato.setBackground(Color.WHITE);
        rbgato.addActionListener(this);
        botoes.add(rbcao);
        botoes.add(rbgato);
        
        //Nome do animal
        nome = new JLabel("Nome ");
        nome.setForeground(Color.gray);
        //TextField Nome
        fNome = new JTextField(5);
        fNome.setColumns(25);

        //Raca do animal
        raca = new JLabel("Raça");
        raca.setForeground(Color.gray);
        cRacas = new JComboBox();
        cRacas.addActionListener(this);

        //Botao pesquisar
        bPesquisar = new JButton("PESQUISAR");
        bPesquisar.setForeground(Color.WHITE);
        bPesquisar.setBackground(corLimpar);
        bPesquisar.setFocusPainted(false);
        bPesquisar.addActionListener(this);
        
        //Botao de relatorio
        bRelatorio= new JButton("Relatorio");
        bRelatorio.setForeground(Color.WHITE);
        bRelatorio.setBackground(Color.DARK_GRAY);
        bRelatorio.setFocusPainted(false);
        bRelatorio.addActionListener(this);
        

    }

    
    
    public Container componentes() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Componentes da primeira fila
        // ESPECIES

        //Radio button ESPECIES canina
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        painel.add(rbcao, gbc);

        //Radio button ESPECIES Felina
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 0;
        painel.add(rbgato, gbc);

        // Label RACA DO ANIMAL
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        painel.add(raca, gbc);

        //Combobox de raca do animal
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.ipady = 5;
        gbc.ipadx = -10;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        painel.add(cRacas, gbc);

        // nome
        gbc.gridwidth = 0;
        gbc.insets = new Insets(35, 15, 40, 0);
        gbc.ipadx = 20;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 15, 40, 0);
        gbc.ipady = 10;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        painel.add(fNome, gbc);

        //BOTAO PESQUISAR
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        painel.add(bPesquisar, gbc);
        
        //Botao de relatorio
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 15, 40, 0);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        painel.add(bRelatorio, gbc);
        
        
        return painel;

    }

    public Container pPrincipal() {
       pPrincipal = new JPanel(new BorderLayout());
        pPrincipal.setBackground(Color.white);
        pPrincipal.add(componentes(),BorderLayout.PAGE_START);
        pPrincipal.add(painelTabela(),BorderLayout.CENTER);
        return pPrincipal;

    }

    private Container painelTabela() {
        Object[][] data = {};
        String[] colunas = {"ID", "NOME", "ESPECIE", "SEXO","RACA","COR_PELO","PESO","DT_NASC"
        };
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
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.Float.class,java.sql.Date.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false,false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tabela.addMouseListener(this);

        // Adicionar a tabela ap SCROLL PANE
        JScrollPane sp = new JScrollPane(tabela);
        sp.setForeground(Color.white);
        sp.setBackground(Color.white);
        pTabela.add(sp, BorderLayout.CENTER);
        return pTabela;
    }

     private void selecionarAnimal() throws SQLException, ClassNotFoundException, ExceptionDAO {//Levar todos atributos e passar para tela de cadastro
        Integer linha = tabela.getSelectedRow();
        int id =  (Integer)tabela.getModel().getValueAt(linha, 0);
        String nome = (String) tabela.getModel().getValueAt(linha, 1);
        String especie = (String) tabela.getModel().getValueAt(linha, 2);
        String sexo = (String) tabela.getModel().getValueAt(linha, 3);
        String raca = (String) tabela.getModel().getValueAt(linha, 4);
        String pelo = (String) tabela.getModel().getValueAt(linha, 5);
       float peso = (Float) tabela.getModel().getValueAt(linha, 6);
       Date data = (Date) tabela.getModel().getValueAt(linha, 7);
        //Passar a informacao do animal selecionado para a tela de Consulta
        Cadastro_Animal animal = new Cadastro_Animal();
        animal.selecionarAnimal(id, nome, especie, sexo, raca, pelo, peso, data);
     
       

    }
   private void selecionarRaca(){
    if(rbcao.isSelected()){
       cRacas.removeAllItems();
        for(int i=0;i<racas_caes.length;i++){
        cRacas.addItem(racas_caes[i]);
       
        }
        
    }
    if(rbgato.isSelected()){
        this.cRacas.removeAllItems();
        for(int i=0;i<racas_gatos.length;i++){
        cRacas.addItem(racas_gatos[i]);
      
        }
        
    }
     }
    
   private void pesquisarAnimalEspecie(String esp) {
        String especie = "";
        especie=esp;
        
        try {
            if (especie != null && especie.length()>0) {
                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                modelo.setRowCount(0);
                AnimalController animal = new AnimalController();
                animais = animal.pesquisarAnimalEspecie(especie);
                animais.forEach((Animal ani) -> {modelo.addRow(new Object[]{ani.getIdAnimal(), ani.getNome(),ani.getEspecie(),ani.getSexo(),ani.getRaca(),ani.getCor_pelo(),ani.getPeso(),ani.getDt_nascimento()});
                });
                tabela.setModel(modelo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o Animal" + ex);
        }
    } 
   private void pesquisarAnimalRaca(String rac) {
        String raca = "";
        raca=rac;
        
        try {
            if (raca != null && raca.length()>0) {
                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                modelo.setRowCount(0);
                AnimalController animal = new AnimalController();
                animais = animal.pesquisarAnimalRaca(raca);
                animais.forEach((Animal ani) -> {modelo.addRow(new Object[]{ani.getIdAnimal(), ani.getNome(),ani.getEspecie(),ani.getSexo(),ani.getRaca(),ani.getCor_pelo(),ani.getPeso(),ani.getDt_nascimento()});
                });
                tabela.setModel(modelo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o Animal" + ex);
        }
    } 
   
    private void pesquisarAnimalNome(String nome) {
        String name = "";
        name=nome;
        
        try {
            if (name != null && name.length()>0) {
                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                modelo.setRowCount(0);
                AnimalController animal = new AnimalController();
                animais = animal.pesquisarAnimalNome(name);
                animais.forEach((Animal ani) -> {modelo.addRow(new Object[]{ani.getIdAnimal(), ani.getNome(),ani.getEspecie(),ani.getSexo(),ani.getRaca(),ani.getCor_pelo(),ani.getPeso(),ani.getDt_nascimento()});
                });
                tabela.setModel(modelo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o Animal" + ex);
        }
    }
   
    private void gerarRelatorio() throws DocumentException, IOException, FileNotFoundException, ClassNotFoundException, ExceptionDAO{
    new AnimalController().gerarRelatorio(animais);
    
    }
    public void criarJanela() {
        frame = new JFrame("CONSULTAR ANIMAL");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);
        frame.add(pPrincipal(), BorderLayout.NORTH);
        //frame.add(tabela());
        // frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Tabela_Consulta_Animal();

    }

    
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            try {
                selecionarAnimal();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Selecionar os dados do animal"+ ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Selecionar os dados do animal"+ ex);
            } catch (ExceptionDAO ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao Selecionar os dados do animal"+ ex);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Evento para selecionar o animal pela especie e preencher o combobox da raca
     
      if(e.getSource()==rbcao){
      selecionarRaca();
      cRacas.setSelectedIndex(-1);
      fNome.setText("");
      
      String especie="Canina";
       pesquisarAnimalEspecie(especie);
      
      } 
     if(e.getSource()==rbgato){
      selecionarRaca();
       cRacas.setSelectedIndex(-1);
       fNome.setText("");
       
       String especie="Felina";
       pesquisarAnimalEspecie(especie);
       
      } 
     //Evento para selecionar o animal pela raca
     if(e.getSource()==cRacas){
         if(cRacas.getSelectedIndex()>-1){
         fNome.setText("");
         String raca=cRacas.getSelectedItem().toString();
         pesquisarAnimalRaca(raca);}
     }
     
     if(e.getSource()==bPesquisar){
         botoes.clearSelection();
         cRacas.removeAllItems();
         cRacas.setSelectedIndex(-1);
         String nome=fNome.getText();
         pesquisarAnimalNome(nome);
     }
     if(e.getSource()==bRelatorio){
          try {
              gerarRelatorio();
          } catch (DocumentException ex) {
              JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio os dados do animal"+ ex);
          } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio os dados do animal"+ ex);
          } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio os dados do animal"+ ex);
          } catch (ExceptionDAO ex) {
              JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio os dados do animal"+ ex);
          }
     }
     
    }
     
   
    
}
