package View;

import Controller.AnimalController;
import Controller.ExameController;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Exame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

public class Cadastro_Exame implements ActionListener {

    private JLabel lab, codAnimal, preco;
    private JButton bSalvar, bLimpar, bCancelar;
    private JComboBox cbAnimais, CbExames, CbResultados;
    private JTextField fObservacao;
    private JFrame frame;
    private JPanel painel, pPrincipal, pBotoes;
    private GridBagConstraints gbc = new GridBagConstraints();
    private int idAnimal, idVacina;
    private float precoExame;
    private Vector<Animal> vectorAnimais;
    private Vector<Exame> vectorExames;
    private String[] resultados = {"Positivo", "Negativo"};

    public Cadastro_Exame() throws SQLException, ClassNotFoundException, ExceptionDAO {
        criarJanela();
    }

    public void inicializar() throws SQLException, ClassNotFoundException, ExceptionDAO {
        //ComBoboxes
        CbExames = new JComboBox();
        cbAnimais = new JComboBox();
        CbResultados = new JComboBox(resultados);
        //Labes
        codAnimal = new JLabel();
        preco = new JLabel();
        //TextField observacao
        fObservacao = new JTextField();
        fObservacao.setColumns(10);

        receberAnimais();

        //Botoes 
        //Salvar
        bSalvar = new JButton("Salvar");
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
        bLimpar.addActionListener(this);

        //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar.setForeground(Color.white);
        bCancelar.setBackground(Color.red);
        bCancelar.setBorderPainted(false);
        bCancelar.addActionListener(this);
        bCancelar.setFocusPainted(false);
        bCancelar.addActionListener(this);

    }

    public Container componentes() throws SQLException, ClassNotFoundException, ExceptionDAO {
        inicializar();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Informacoes do animal
        lab = new JLabel("Selecione o animal");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(lab, gbc);
        //Combobox Animal
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(cbAnimais, gbc);
        //Label do idAnimal
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        painel.add(codAnimal, gbc);

        //Informacoes do exame
        lab = new JLabel("Selecione o Exame");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        painel.add(lab, gbc);
        //Combobox
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        painel.add(CbExames, gbc);
        //Label preco Exame
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 3;
        painel.add(preco, gbc);

        //Informacoes do resultado
        lab = new JLabel("Selecione o Resultado");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 50;
        painel.add(lab, gbc);
        //Combobox
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        painel.add(CbResultados, gbc);

        //Informacoes da observacao
        lab = new JLabel("Observacao");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 6;
        painel.add(lab, gbc);
        //Combobox
        gbc.insets = new Insets(35, 5, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 60;
        gbc.ipady = 10;
        painel.add(fObservacao, gbc);

        return painel;
    }

    public Container adicionarBotoes() {
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
        pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 5, 0, 0);
        gbc.ipady = 2;
        gbc.ipadx = 2;
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

    public Container pPrincipal() throws SQLException, ClassNotFoundException, ExceptionDAO {
        pPrincipal = new JPanel(new BorderLayout());
        pPrincipal.add(componentes(), BorderLayout.NORTH);
        pPrincipal.add(adicionarBotoes(), BorderLayout.CENTER);
        pPrincipal.setBackground(Color.white);

        return pPrincipal;
    }
//         public void colocarIconMenu() {
//       Menu_Principal a = new Menu_Principal("");
//        a.mudarCor();
//        a.iconPrincipal();
//        
//    }

    private void receberAnimais() throws SQLException, ClassNotFoundException, ExceptionDAO {
        vectorAnimais = new ExameController().selecionarAnimais();
        for (int i = 0; i < vectorAnimais.size(); i++) {
            this.cbAnimais.addItem(vectorAnimais.elementAt(i).getNome());
        }
        this.cbAnimais.setSelectedIndex(-1);
    }

    public void Limpar() {

    }

    public void criarJanela() throws SQLException, ClassNotFoundException, ExceptionDAO {
        frame = new JFrame("CONSULTA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530, 550);
        frame.add(pPrincipal());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExceptionDAO {
        new Cadastro_Exame();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
//  if(e.getSource()==bCancelar){
//       colocarIconMenu();
//       }
    }
}
