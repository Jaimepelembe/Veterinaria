/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
public class Menu_Principal implements ActionListener{
   private JFrame frame;
   private GridBagConstraints gbc = new GridBagConstraints();
   private JButton cliente, animal, servicos, produtos,historico, tema;
   private JLabel label, iCliente, iAnimal, iProduto, iServico, iHistorico,iTema;
   private JPopupMenu popMenu;
   private JMenuItem mCadCliente, mConsCliente;
   

public Menu_Principal(){
        criarJanela();
        

}

public void inicializarComponentes(){
        
        Color cor = new Color(0.0f,0.4f,0.8f,1f);
        Font fonte = new Font("Helvetica",Font.TRUETYPE_FONT,20);
        //BUTAO CLIENTE
        cliente = new JButton("Clientes "); 
        cliente.setBackground(cor);
        cliente.setForeground(Color.WHITE);
        cliente.setBorderPainted(false);
        cliente.setFont(fonte);
        cliente.addActionListener(this);
        
        //BUTAO ANIMAL
        animal = new JButton("Animais "); 
        animal.setBackground(cor);
        animal.setForeground(Color.WHITE);
        animal.setBorderPainted(false);
        animal.setFont(fonte);
        
           //BUTAO produtos
        produtos = new JButton(" Vacinas "); 
        produtos.setBackground(cor);
        produtos.setForeground(Color.WHITE);
        produtos.setBorderPainted(false);
        produtos.setFont(fonte);
        
        
          //BUTAO serviços
        servicos = new JButton(" Servicos "); 
        servicos.setBackground(cor);
        servicos.setForeground(Color.WHITE);
        servicos.setBorderPainted(false);
        servicos.setFont(fonte);
        servicos.addActionListener(this);
        
          //BUTAO historico
        historico = new JButton(" Historico "); 
        historico.setBackground(cor);
        historico.setForeground(Color.WHITE);
        historico.setBorderPainted(false);
        historico.setFont(fonte);
        
          //BUTAO configuracao
        tema = new JButton(" Tema "); 
        tema.setBackground(cor);
        tema.setForeground(Color.WHITE);
        tema.setBorderPainted(false);
        tema.setFont(fonte);
        
        
        //POP MENUS
        //Cliente pops
        popMenu = new JPopupMenu();
        mCadCliente = new JMenuItem("Cadastrar"); 
        mCadCliente.setBackground(Color.white);
        mCadCliente.addActionListener(this);
        mConsCliente = new JMenuItem("Consultar");
        mConsCliente.setBackground(Color.white);
        
        
        ////------------------IMAGENS--------
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
};

    public Container componentes() {
        
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
    return painel;
    }
  

    //PAINEL lateral esquerdo
public Container lateral() {
        Color cor = new Color(0.0f,0.4f,0.8f,1f);

        inicializarComponentes();
        JPanel pLateral = new JPanel();
        pLateral.setBackground(cor);
        
        pLateral.setBounds(0, 0, 0, 0);
       
        pLateral.setLayout(new GridBagLayout());
        
        //IMAGEM ANIMAL
        gbc.insets = new Insets(5, 5, 0, 0);
        gbc.gridx = 1;
        gbc.gridy=0;
         pLateral.add(label,gbc);
        
         gbc.insets = new Insets(0, 5, 0, 0);
         
        //clente
        gbc.gridx = 1;
        gbc.gridy=2;
        pLateral.add(cliente,gbc);
        //icon cliente
        gbc.insets = new Insets(0, 12, 0, -67);
        gbc.gridx = 0;
        gbc.gridy=2;
        pLateral.add(iCliente,gbc);
        
        gbc.insets = new Insets(30, 5, 0, 0);
        //animal
        gbc.gridx = 1;
        gbc.gridy=3;
        pLateral.add(animal,gbc);
        //icon animal
        gbc.insets = new Insets(30, 12, 0, -67);
        gbc.gridx = 0;
        gbc.gridy=3;
        pLateral.add(iAnimal,gbc);
        
        
       gbc.insets = new Insets(30, 5, 0, 0);
        //produtos
        gbc.gridx = 1;
        gbc.gridy=4;
        pLateral.add(produtos,gbc);
        //icon produto
        gbc.insets = new Insets(30, 12, 0, -67);
        gbc.gridx = 0;
        gbc.gridy=4;
        pLateral.add(iProduto,gbc);
        
         gbc.insets = new Insets(30, 12, 0, 0);
        //servicos
        gbc.gridx = 1;
        gbc.gridy=5;
        pLateral.add(servicos,gbc);
        //icon servico
        gbc.insets = new Insets(30, 14, 0, -58);
        gbc.gridx = 0;
        gbc.gridy=5;
        pLateral.add(iServico,gbc);
        
        gbc.insets = new Insets(30, 12, 0, 0);
        //historico
        gbc.gridx = 1;
        gbc.gridy=6;
        pLateral.add(historico,gbc);
        //icon historico
        gbc.insets = new Insets(30, 14, 0, -58);
        gbc.gridx = 0;
        gbc.gridy=6;
        pLateral.add(iHistorico,gbc);
        
        gbc.insets = new Insets(30, 5, 0, 0);
        //configuracoes
        gbc.gridx = 1;
        gbc.gridy=7;
        pLateral.add(tema,gbc);
        //icon tema
        gbc.insets = new Insets(30, 14, 0, -58);
        gbc.gridx = 0;
        gbc.gridy=7;
        pLateral.add(iTema,gbc);
        
    return pLateral;
}
public void cadastro_Cliente(){
        Cadastro_Cliente cCliente = new Cadastro_Cliente();
        frame.add(cCliente.pPrincipal(), BorderLayout.CENTER);
}

public void cadastro_Consulta(){
        Cadastro_Consulta cConsulta = new Cadastro_Consulta();
        frame.add(cConsulta.pPrincipal(), BorderLayout.CENTER);
        
      
}

public void Menu_Cliente(){
        
        popMenu.add(mCadCliente);
        popMenu.add(mConsCliente);
        popMenu.setBackground(Color.WHITE);
        cliente.setAlignmentX(RIGHT_ALIGNMENT);
        cliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX());//52 para meio
                System.out.println(e.getY());
                popMenu.show(e.getComponent(), 100, 0);
            }
        });


}

  
    
    public void criarJanela() {
       
        frame = new JFrame("MENU") ;
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 650);
         ImageIcon img = new ImageIcon("src/Imagens/Menu/menu.jpg");
        frame.setIconImage(img.getImage());    frame.setLocationRelativeTo(null);
        frame.setResizable(false);
       // frame.add(componentes());
        frame.add(lateral(), BorderLayout.WEST);
       
        //cadastro_Consulta();
        frame.setVisible(true); 
        //cadastro_Cliente();
        //frame.setVisible(true);
        
}
    
 public void Cancelar(){
 frame.remove(tema);
 
 }   
 

    public static void main(String[] args) {
     new Menu_Principal();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Cadastro_Cliente cCliente = new Cadastro_Cliente();
        if(e.getSource()==cliente){
        Menu_Cliente();
        frame.setVisible(true);
        
        }
        
        if(e.getSource()== servicos){
        cadastro_Consulta();
        frame.setVisible(true);
        
        }
        if(e.getSource()==mCadCliente){
        cadastro_Cliente();
        Menu_Cliente();
        frame.setVisible(true);
        }
        
        
    }
}

