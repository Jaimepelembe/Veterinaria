/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.ExceptionDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.RIGHT_ALIGNMENT;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Valter Boa 53
 */
public class Menu_Principal implements ActionListener, MouseListener{

    private static JFrame frame;
    private static Container cadastro_cliente, cadastro_consul;

    private static Container painelActual;

   
    private GridBagConstraints gbc = new GridBagConstraints();
    private JButton cliente, animal, servicos, produtos, historico, tema, botao;
    private static JLabel label, iCliente, iAnimal, iProduto, iServico, iHistorico, iTema , iconPrincipal;
    private JPopupMenu popMenu, pop_Animal, pop_Vacina;
    private JMenuItem mCadCliente, mConsCliente, mCadAnimal, mConsAnimal, mConsVacina, mCadVacina;
    //cores
    Color cor = new Color(0.0f, 0.4f, 0.8f, 1f);//COR DO PAINEL AZUL
    Color corBranco = Color.white ;//COR DO PAINEL branco
    Color cor2 = new Color(0.0f, 0.2f, 0.8f, 1f); //COR SECUNDARIA

    //fontes
    Font fonte = new Font("Helvetica", Font.TRUETYPE_FONT, 20);
    Font fonte2 = new Font("arial", Font.TRUETYPE_FONT, 15);

    public Menu_Principal() {
        inicializarComponentes();
        criarJanela();
    }

     public Menu_Principal(String vazio) {
        inicializarComponentes();
       
    }

    public void inicializarComponentes() {
        // BUTAO CLIENTE
        cliente = new JButton("Clientes ");
        cliente.setBackground(cor);
        cliente.setForeground(Color.WHITE);
        cliente.setBorderPainted(false);
        cliente.setFont(fonte);
        cliente.addActionListener(this);
        cliente.setFocusPainted(false);

        // BUTAO ANIMAL
        animal = new JButton("Animais ");
        animal.setBackground(cor);
        animal.setForeground(Color.WHITE);
        animal.setBorderPainted(false);
        animal.setFont(fonte);
        animal.addActionListener(this);
        animal.setFocusPainted(false);

        // BUTAO produtos Vacinas
        produtos = new JButton(" Vacinas ");
        produtos.setBackground(cor);
        produtos.setForeground(Color.WHITE);
        produtos.setBorderPainted(false);
        produtos.setFont(fonte);
        produtos.setFocusPainted(false);
        produtos.addActionListener(this);

        // BUTAO serviços
        servicos = new JButton(" Servicos ");
        servicos.setBackground(cor);
        servicos.setForeground(Color.WHITE);
        servicos.setBorderPainted(false);
        servicos.setFont(fonte);
        servicos.addActionListener(this);
        servicos.setFocusPainted(false);

        // BUTAO historico
        historico = new JButton(" Historico ");
        historico.setBackground(cor);
        historico.setForeground(Color.WHITE);
        historico.setBorderPainted(false);
        historico.setFont(fonte);
        historico.setFocusPainted(false);

        // BUTAO configuracao
        tema = new JButton(" Tema ");
        tema.setBackground(cor);
        tema.setForeground(Color.WHITE);
        tema.setBorderPainted(false);
        tema.setFont(fonte);
        tema.setFocusPainted(false);
        tema.addActionListener(this);

        // POP MENUS
        // Cliente pops
        popMenu = new JPopupMenu();
        //MenuItem Cadastro
        mCadCliente = new JMenuItem("Cadastrar      ");
        mCadCliente.setBackground(Color.white);
        mCadCliente.addActionListener(this);
        mCadCliente.setFont(fonte2);
        //MenuItem consulta
        mConsCliente = new JMenuItem("Consulta");
        mConsCliente.setBackground(Color.white);
        mConsCliente.addActionListener(this);
        mConsCliente.setFont(fonte2);
        
        //Animal Pops
        pop_Animal = new JPopupMenu();
        //MenuItem cadastro
        mCadAnimal = new JMenuItem("Cadastrar        ");
        mCadAnimal.setBackground(Color.white);
        mCadAnimal.addActionListener(this);
        mCadAnimal.setFont(fonte2);
        //MenuItem consulta
        mConsAnimal = new JMenuItem("Consultar");
        mConsAnimal.setBackground(Color.white);
        mConsAnimal.addActionListener(this);
        mConsAnimal.setFont(fonte2);
        
          // Vacinas pops
        pop_Vacina = new JPopupMenu();
        //MenuItem Cadastro
        mCadVacina = new JMenuItem("Cadastrar      ");
        mCadVacina.setBackground(Color.white);
        mCadVacina.addActionListener(this);
        mCadVacina.setFont(fonte2);
        //MenuItem consulta
        mConsVacina = new JMenuItem("Consultar");
        mConsVacina.setBackground(Color.white);
        mConsVacina.addActionListener(this);
        mConsVacina.setFont(fonte2);

        //// ------------------IMAGENS--------
        iProduto = new JLabel();
        iServico = new JLabel();
        label = new JLabel();
        iCliente = new JLabel();
        iAnimal = new JLabel();
        iHistorico = new JLabel();
        iTema = new JLabel();
        label.setIcon(new ImageIcon("src/Imagens/Menu/logo.png"));
        iAnimal.setIcon(new ImageIcon("src/Imagens/Menu/animal.png"));
        iCliente.setIcon(new ImageIcon("src/Imagens/Menu/cliente.png"));
        iProduto.setIcon(new ImageIcon("src/Imagens/Menu/produto.png"));
        iServico.setIcon(new ImageIcon("src/Imagens/Menu/servico.png"));
        iHistorico.setIcon(new ImageIcon("src/Imagens/Menu/historico.png"));
        iTema.setIcon(new ImageIcon("src/Imagens/Menu/tema.png"));
        label.addMouseListener(this);
       
    }

    public Container componentes() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        return painel;
    }

    // PAINEL lateral esquerdo
    public Container lateral() {
        JPanel pLateral = new JPanel();
        pLateral.setBackground(cor);

        pLateral.setBounds(0, 0, 0, 0);

        pLateral.setLayout(new GridBagLayout());

        // IMAGEM ANIMAL
        gbc.insets = new Insets(5, 5, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        pLateral.add(label, gbc);

        gbc.insets = new Insets(0, 5, 0, 0);

        // clente
        gbc.gridx = 1;
        gbc.gridy = 2;
        pLateral.add(cliente, gbc);
        // icon cliente
        gbc.insets = new Insets(0, 12, 0, -67);
        gbc.gridx = 0;
        gbc.gridy = 2;
        pLateral.add(iCliente, gbc);

        gbc.insets = new Insets(30, 5, 0, 0);
        // animal
        gbc.gridx = 1;
        gbc.gridy = 3;
        pLateral.add(animal, gbc);
        // icon animal
        gbc.insets = new Insets(30, 12, 0, -67);
        gbc.gridx = 0;
        gbc.gridy = 3;
        pLateral.add(iAnimal, gbc);

        gbc.insets = new Insets(30, 5, 0, 0);
        // produtos
        gbc.gridx = 1;
        gbc.gridy = 4;
        pLateral.add(produtos, gbc);
        // icon produto
        gbc.insets = new Insets(30, 12, 0, -67);
        gbc.gridx = 0;
        gbc.gridy = 4;
        pLateral.add(iProduto, gbc);

        gbc.insets = new Insets(30, 12, 0, 0);
        // servicos
        gbc.gridx = 1;
        gbc.gridy = 5;
        pLateral.add(servicos, gbc);
        // icon servico
        gbc.insets = new Insets(30, 14, 0, -58);
        gbc.gridx = 0;
        gbc.gridy = 5;
        pLateral.add(iServico, gbc);

        gbc.insets = new Insets(30, 12, 0, 0);
        // historico
        gbc.gridx = 1;
        gbc.gridy = 6;
        pLateral.add(historico, gbc);
        // icon historico
        gbc.insets = new Insets(30, 14, 0, -58);
        gbc.gridx = 0;
        gbc.gridy = 6;
        pLateral.add(iHistorico, gbc);

        gbc.insets = new Insets(30, 5, 0, 0);
        // configuracoes
        gbc.gridx = 1;
        gbc.gridy = 7;
        pLateral.add(tema, gbc);
        // icon tema
        gbc.insets = new Insets(30, 14, 0, -58);
        gbc.gridx = 0;
        gbc.gridy = 7;
        pLateral.add(iTema, gbc);

        return pLateral;
    }

    public void cadastro_Cliente() {
        Cadastro_Cliente cCliente = new Cadastro_Cliente();
        //Remover o painel que esta no centro
        removerPainelCentral();
        mudarCor();
        cliente.setBackground(cor2);
        painelActual = cCliente.painelCadastro();
        frame.add(painelActual, BorderLayout.CENTER);
    }

    public static void ResulConsultaCliente(Container contentor) {
        //Cadastro_Cliente cliente = new Cadastro_Cliente();
        //Remover o painel que esta no centro
        removerPainelCentral();
        painelActual =  contentor; //cliente.painelResultConsulta();
        frame.add(painelActual, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void cadastro_Consulta() {
        Cadastro_Consulta cConsulta = new Cadastro_Consulta();
        //Remover o painel central caso ele tenha algo
        removerPainelCentral();
        painelActual = cConsulta.pPrincipal();
        mudarCor();
        servicos.setBackground(cor2);
        frame.add(painelActual, BorderLayout.CENTER);

    }

    //Metodos Para cadastro, Consulta e exibir resultado da consulta do animal   
    //Cadastro do Animal
    public void cadastro_Animal() throws SQLException, ClassNotFoundException, ExceptionDAO {
        Cadastro_Animal animais = new Cadastro_Animal();
        mudarCor();
        animal.setBackground(cor2);
        //Remover o painel que esta no centro 
        removerPainelCentral();
        painelActual = animais.painelCadastro();
        frame.add(painelActual, BorderLayout.CENTER);

    }
    public void selecionarAnimal(){
    //sCadastro_Animal animal= new Cadastro_Animal().selecionarAnimal(0, nome, especie, sexo, raca, cor_pelo, RIGHT_ALIGNMENT, dt_nascimento)
    
    }

    
      public void cadastro_Vacina(){
    Cadastro_Vacina vacinas= new Cadastro_Vacina();
    mudarCor();
    produtos.setBackground(cor2);
       //Remover o painel que esta no centro 
     removerPainelCentral();
     this.painelActual  = vacinas.componentes();
     frame.add(painelActual, BorderLayout.CENTER);
     
    }
        public void Tabela_vacina() {

        Tabela_Consulta_Vacina tVacina = new Tabela_Consulta_Vacina();
                mudarCor();
                produtos.setBackground(cor2);
        removerPainelCentral();
        painelActual = tVacina.adicionarcomponentes();
        frame.add(painelActual, BorderLayout.CENTER);

    }
         public void PopMenu_Vacina() {
        pop_Vacina.add(mCadVacina);
        pop_Vacina.add(mConsVacina);
        pop_Vacina.setBackground(Color.WHITE);
        produtos.setAlignmentX(RIGHT_ALIGNMENT);
        produtos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pop_Vacina.show(e.getComponent(), 100, 0);
            }
        });

    }

    

    //Paimel que exibe a informacao do animal selecionado na busca a BD
    public void Resul_consultaAnimal() throws SQLException, ClassNotFoundException, ExceptionDAO {
        Cadastro_Animal animais = new Cadastro_Animal();
        //Remover o painel que esta no centro
        removerPainelCentral();
        painelActual = animais.painelResulConsulta();
        frame.add(painelActual, BorderLayout.CENTER);
    }

    public void Tabela_animal() {

        Tabela_Consulta_Animal tAnimal = new Tabela_Consulta_Animal();
        //// consulta_animal = tAnimal.componentes();
//        frame.add(consulta_animal, BorderLayout.CENTER);

        mudarCor();
        animal.setBackground(cor2);
        removerPainelCentral();
        painelActual = tAnimal.componentes();

        frame.add(painelActual, BorderLayout.CENTER);

    }

    public void Tabela_Cliente() {

        Tabela_Consulta_Cliente tCliente = new Tabela_Consulta_Cliente();
        removerPainelCentral();
        mudarCor();
        cliente.setBackground(cor2);
        painelActual = tCliente.painelPrincipal();

        frame.add(painelActual, BorderLayout.CENTER);

    }

    public void mudarCor() {
        cliente.setBackground(cor);
        servicos.setBackground(cor);
        animal.setBackground(cor);
        tema.setBackground(cor);
        produtos.setBackground(cor);
        historico.setBackground(cor);
    }
    public  void iconPrincipal(){
       removerPainelCentral();
       painelActual=new JLabel(new ImageIcon("src/Imagens/Menu/pexels.jpg"));
       this.frame.add(painelActual,BorderLayout.CENTER);
       this.frame.setVisible(true);
    }
    //MUDAR TEMA
    public void mudarTema(){
    cor = Color.orange;
    cor2 = Color.orange;
    }
    
    public void PopMenu_Cliente() {
        popMenu.add(mCadCliente);
        popMenu.add(mConsCliente);
        popMenu.setBackground(Color.WHITE);
        cliente.setAlignmentX(RIGHT_ALIGNMENT);
        cliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                popMenu.show(e.getComponent(), 100, 0);
            }
        });

    }

    public void PopMenu_Animal() {
        pop_Animal.add(mCadAnimal);
        pop_Animal.add(mConsAnimal);
        pop_Animal.setBackground(Color.WHITE);
        animal.setAlignmentX(RIGHT_ALIGNMENT);
        animal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pop_Animal.show(e.getComponent(), 100, 0);
            }
        });

    }

    public void criarJanela() {
        ImageIcon img = new ImageIcon("src/Imagens/Menu/menu.jpg");
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(880, 750);
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);

        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        // painel lateral da janela
        frame.add(lateral(), BorderLayout.WEST);
       //Icon principal
       iconPrincipal();
       frame.setVisible(true);
       

    }

    public static void removerPainelCentral() {
        if (painelActual != null) {
            frame.remove(painelActual);
        }  }

    public static void main(String[] args) {
        new Menu_Principal();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //##### Eventos do botao cliente #########
        if (e.getSource() == cliente) {
            PopMenu_Cliente();
            frame.setVisible(true);
        }

        if (e.getSource() == mCadCliente) {
            cadastro_Cliente();
            // frame.remove(consulta_animal);
            //frame.remove(painelActual);
            frame.setVisible(true);
        }
          //CONSULTAR CLIENTE
        if (e.getSource() == mConsCliente) {
            Tabela_Cliente();
            frame.setVisible(true);
        }


        if (e.getSource() == servicos) {
            cadastro_Consulta();
            frame.setVisible(true);

        }

        //######## Eventos do botao Animal #########
        if (e.getSource() == animal) {
            PopMenu_Animal();
            frame.setVisible(true);
        }

        //Pop Menu
        //Menuitem Cadastrar ANIMAL
        if (e.getSource() == mCadAnimal) {
            try {
                cadastro_Animal();
            } catch (SQLException ex) {
                Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExceptionDAO ex) {
                Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.setVisible(true);
        }

        //Menuitem Consultar ANIMAL
        if (e.getSource() == mConsAnimal) {
            Tabela_animal();
            frame.setVisible(true);
        }

        
      //######## Eventos do botao VACINAS ######### produtos= vacinas
        if (e.getSource() == produtos) {
            PopMenu_Vacina();
            frame.setVisible(true);
        }

        //Pop Menu
        //Menuitem Cadastrar Vacinas
        if (e.getSource() == mCadVacina) {
            cadastro_Vacina();
            frame.setVisible(true);
        } //Menuitem Consultar VACINA
        if (e.getSource() == mConsVacina) {
            Tabela_vacina();
            frame.setVisible(true);
        }
          if (e.getSource() == tema) {
            //mudarTema();
            frame.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        mudarCor();
          iconPrincipal();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}

