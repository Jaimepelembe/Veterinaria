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

public class Cadastro_Cliente implements ActionListener {

    private JLabel nome, tel, morada, lab;//label idCliente
    private JButton bSalvar, bCancelar, bLimpar, bEliminar, bActualizar, bAnimal;
    private  JTextField fNome ;
    private  JTextField fTel ;
    private int idCliente=0;
    //private static JFormattedTextField fTel = new JFormattedTextField(5) ;
    private JFrame frame;
    private static String[] distritos = {"Matola", "Marracuene", "Manhiça", "Magude", "Moamba", "Boane", "Namaacha",
            "Matutuine"};
    private static JComboBox cDistrito = new JComboBox(distritos);
    private JPanel pAuxiliar, pbActual, pPrincipal;
    
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Cliente() {
        inicializarComponentes();
        //criarJanela();
    }

    private void inicializarComponentes() {
        //Label id do cliente
        //idCliente= new JLabel();

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
        bCancelar.setForeground(Color.white);
        bCancelar.setBackground(Color.red);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusPainted(false);
        bCancelar.addActionListener(this);

        //Botoes para formar a tela de consulta
        //Actualizar
        bActualizar = new JButton("Update");
        bActualizar.setForeground(Color.white);
        bActualizar.setBackground(Color.darkGray);
        bActualizar.addActionListener(this);
        
        //Adicionar Animal
       bAnimal= new JButton("Add Animal");
       bAnimal.setForeground(Color.white);
       bAnimal.setBackground(Color.blue);
       bAnimal.addActionListener(this);
       

        //Botao Eliminar
        bEliminar = new JButton("Eliminar");
        bEliminar.setForeground(Color.white);
        bEliminar.setBackground(Color.orange);
        bEliminar.addActionListener(this);

    }

    public Container adicionarComponentes() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Informacoes do nome
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

    private Container botoesCadastro() {
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
        pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 2;
        // add buttons to the panel
        gbc.gridy = 0;
        gbc.gridx = 1;
        pBotoes.add(bSalvar, gbc);
        gbc.gridx = 2;
        pBotoes.add(bLimpar, gbc);
        gbc.gridx = 4;
        pBotoes.add(bCancelar, gbc);
        return pBotoes;
    }

    public Container painelCadastro() {
        pAuxiliar = new JPanel(new BorderLayout());
        JPanel painel = (JPanel) pPrincipal();
        removerPainelBotao();
        pbActual = (JPanel) botoesCadastro();
        painel.add(pbActual, BorderLayout.SOUTH);
        painel.add(adicionarImagens("cadastro"), BorderLayout.NORTH);
        pAuxiliar.add(painel);
        return pAuxiliar;
    }

    private Container botoesResulConsulta() {
        JPanel pbConsulta = new JPanel(new GridBagLayout());
        pbConsulta.setBackground(Color.white);

        //Botao salvar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 0, 40, 50);
        gbc.ipadx = 10;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pbConsulta.add(bActualizar, gbc);

         gbc.gridx = 1;
        pbConsulta.add(bAnimal, gbc);
        
        //Botao Eliminar
        gbc.gridx = 2;
        pbConsulta.add(bEliminar, gbc);

        //Botao Cancelar
        gbc.gridx = 3;
        pbConsulta.add(bCancelar, gbc);

        return pbConsulta;
    }

    public Container painelResultConsulta() {
        pAuxiliar = new JPanel(new BorderLayout());
        JPanel painel = (JPanel) pPrincipal();
        removerPainelBotao();
        pbActual = (JPanel) botoesResulConsulta();
        painel.add(pbActual, BorderLayout.SOUTH);
        painel.add(adicionarImagens("consulta"), BorderLayout.NORTH);
        pAuxiliar.add(painel);
        return pAuxiliar;
    }

    public int selecionarCliente(int id, String nome, String cell, String morada) {
       this.idCliente = id;
        fNome.setText(nome);
        fTel.setText(cell);
        SelectcomboBox(morada);
        //Passar o painel do resultado da consulta para o menu 
       // new Menu_Principal().ResulConsultaCliente(painelResultConsulta());
       Menu_Principal.ResulConsultaCliente(painelResultConsulta());
        return id;
    }

    private static void SelectcomboBox(String morada) {
        int j = cDistrito.getItemCount();
        System.out.println(j);

        for (int i = 0; i < j; i++) {
            if (cDistrito.getItemAt(i) != null && cDistrito.getItemAt(i).equals(morada)) {
                cDistrito.setSelectedIndex(i);
                
                break;
            }
        }
    }

    public Container adicionarImagens(String nome) {
        JPanel pImagens = new JPanel();
        ImageIcon imageIcon;

        JLabel label = new JLabel();
        if (nome == "cadastro") {
            label.setIcon(new ImageIcon("src/Imagens/Entidades/cliente.jpg"));
        }
        if (nome == "consulta") {
            label.setIcon(new ImageIcon("src/Imagens/Entidades/cliente2.png"));
        }
        pImagens.add(label);
        pImagens.setBackground(Color.white);

        return pImagens;
    }

    private void removerPainelBotao() {
        if (pbActual != null) {
            pPrincipal.remove(pbActual);
        }
    }

    private Container pPrincipal() {
        pPrincipal = new JPanel(new BorderLayout());
        // pPrincipal.add(adicionarImagens(), BorderLayout.NORTH);
        pPrincipal.add(adicionarComponentes(), BorderLayout.CENTER);
        pPrincipal.setBackground(Color.white);
        return pPrincipal;
    }

    public void criarJanela() {
        frame = new JFrame("CADASTRO DE CLIENTE");
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630, 650);
        frame.add(painelResultConsulta());
        ImageIcon img = new ImageIcon("src/Imagens/Entidades/icon.jpg");
        frame.setIconImage(img.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Cadastro_Cliente();
       //fTel.setText("olla");
       // System.out.println(fTel.getText());

    }

    public void Limpar() {
        this.fNome.setText("");
        this.fTel.setText("");
        this.cDistrito.setSelectedIndex(-1);

    }

    public void SalvarDados() {
        //nome do cliente
        String nome = fNome.getText();
        //telefone do cliente
        String telefone = fTel.getText();
        //morada
        String morada = cDistrito.getSelectedItem().toString();

        boolean sucesso;
        try {
            ClienteController cliente = new ClienteController();
            sucesso = cliente.cadastrarCliente(nome, telefone, morada);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "O Cliente foi cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o Cliente");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados do cliente" + ex);
        }

    }
    
    public void actualizarCiente(){
        
      //nome do cliente
        String nome = fNome.getText();
        //telefone do cliente
        String telefone = fTel.getText();
        //morada
        String morada = cDistrito.getSelectedItem().toString();

        boolean sucesso;
        try {
            ClienteController cliente = new ClienteController();
            sucesso = cliente.actualizarCliente(this.idCliente,nome, telefone, morada);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "O Cliente foi actualizado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao actualizar o Cliente");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao actualizar dados do cliente" + ex);
        }
    
    }

 public void apagarCiente(){

        boolean sucesso;
        try {
            ClienteController cliente = new ClienteController();
            sucesso = cliente.apagarCliente(this.idCliente);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "O Cliente foi apagado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao apagar o Cliente");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar o cliente" + ex);
        }
    
    }
  //Volta a colocar a imagem central no Painel do menu Principal
 
    public void colocarIconMenu() {
        Menu_Principal a = new Menu_Principal();
        a.iconPrincipal();
        a.mudarCor();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
        if (e.getSource() == bCancelar) {
        }

        //Evento para salvar os dados do cliente na BD
        if (e.getSource() == bSalvar) {
            SalvarDados();
            Limpar();
        }
        //Evento para actualizar dados do cliente
        if(e.getSource()==bActualizar){
        actualizarCiente();
        }
         //Evento para apagardados o cliente da BD
       if(e.getSource()==bEliminar){
       apagarCiente();
       } 
       if(e.getSource()==bCancelar){
       colocarIconMenu();
       }
    }

}
