package Model;

/**
 *
 * @author multi
 */
public class Veterinaria {
    private int idVeterinaria;
    private String nome,localizacao;
   
    private float investimento_material,valor_ganho,lucro_total;
    private int nr_cliente,nr_vacina,nr_animais; //nr=numero de...

    public Veterinaria() {
    }

    public Veterinaria(int idVeterinaria, String nome, String localizacao, float investimento_material, float valor_ganho, float lucro_total, int nr_cliente, int nr_vacina, int nr_animais) {
        this.idVeterinaria = idVeterinaria;
        this.nome = nome;
        this.localizacao = localizacao;
        this.investimento_material = investimento_material;
        this.valor_ganho = valor_ganho;
        this.lucro_total = lucro_total;
        this.nr_cliente = nr_cliente;
        this.nr_vacina = nr_vacina;
        this.nr_animais = nr_animais;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

  


    public float getLucro_total() {
        return lucro_total;
    }

    public void setLucro_total(float lucro_total) {
        this.lucro_total = lucro_total;
    }
    
    
}
