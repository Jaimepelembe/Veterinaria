
import javax.swing.ButtonGroup;
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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class Cadastro_Animal {
    private JLabel nome, especie, raca, cor, dtNascimento, peso, kg;
    private JButton salvar, cancelar, limpar;
    private JTextField fNome, fPeso, fDtNascimento;
    private JFrame frame;
    private JComboBox cRaca, cCor;
    private ButtonGroup botoes;
    private JRadioButton rbcao, rbgato;
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Animal() {
        criarJanela();
    }

    public Container componentes() {

        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
        // nome
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 0;
        nome = new JLabel("Nome ");
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        fNome = new JTextField(5);
        fNome.setColumns(10);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(fNome, gbc);

        // SEGUNDA FILA
        // Label especie
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 1;
        especie = new JLabel("Especie ");
        gbc.gridx = 0;
        painel.add(especie, gbc);

        // Radios
        botoes = new ButtonGroup();
        rbcao = new JRadioButton("Canino");
        rbcao.setBackground(Color.WHITE);
        rbgato = new JRadioButton("Felino");
        rbgato.setBackground(Color.WHITE);
        botoes.add(rbcao);
        botoes.add(rbgato);

        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);

        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);

        // terceira
        // cores
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 2;
        cor = new JLabel("Cor do pelo ");
        gbc.gridx = 0;
        painel.add(cor, gbc);

        // box cores
        gbc.insets = new Insets(35, 5, 0, 20);
        gbc.ipady = 5;
        String[] cores = { "Branco", "Cizento", "Azul", "Amarelo" };
        cCor = new JComboBox(cores);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cCor, gbc);

        // raca
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 3;
        raca = new JLabel("Raça ");
        gbc.gridx = 0;
        painel.add(raca, gbc);

        // box racas
        gbc.insets = new Insets(35, 5, 0, 20);
        gbc.ipady = 5;
        String[] racas = { "Pastor Alemao", "Pitbull", "Pastor Belga", "Chiuaua" };
        cRaca = new JComboBox(racas);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cRaca, gbc);

        // DATA DE NASCIMENTO
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 4;

        dtNascimento = new JLabel("Data de nascimento ");
        gbc.gridx = 0;
        painel.add(dtNascimento, gbc);

        gbc.insets = new Insets(35, 5, 0, 20);
        fDtNascimento = new JTextField(5);
        fDtNascimento.setColumns(10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fDtNascimento, gbc);

        // PESO DO ANIMAL
        gbc.insets = new Insets(35, 15, 20, 0);
        gbc.gridy = 5;
        peso = new JLabel("Peso ");
        gbc.gridx = 0;
        painel.add(peso, gbc);

        gbc.insets = new Insets(35, 5, 20, 20);
        fPeso = new JTextField(5);
        fPeso.setColumns(10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fPeso, gbc);
        // label kg
        kg = new JLabel("KG");
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        painel.add(kg, gbc);

        gbc.gridwidth = 1;
        // Butoes de baixo
        gbc.insets = new Insets(35, 5, 10, 10);
        // gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 6;
        salvar = new JButton("Salvar");
        gbc.gridx = 1;
        salvar.setForeground(Color.white);
        salvar.setBackground(Color.green);
        painel.add(salvar, gbc);

        cancelar = new JButton("Cancelar");
        gbc.gridx = 3;
        cancelar.setForeground(Color.white);
        cancelar.setBackground(Color.red);
        painel.add(cancelar, gbc);

        limpar = new JButton("Limpar");
        limpar.setForeground(Color.white);
        limpar.setBackground(Color.blue);
        gbc.gridx = 2;
        painel.add(limpar, gbc);

        return painel;

    }

    public void criarJanela() {
        frame = new JFrame("CADASTRO ANIMAL");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(componentes());
        frame.pack();

    }

    public static void main(String[] args) {
        new Cadastro_Animal();

    }
}
