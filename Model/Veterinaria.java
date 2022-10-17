package Model;

/**
 *
 * @author multi
 */
public class Veterinaria {
    private String nome,localizacao;
    private int id;
    private float gasto_material,lucro_total;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGasto_material() {
        return gasto_material;
    }

    public void setGasto_material(float gasto_material) {
        this.gasto_material = gasto_material;
    }

    public float getLucro_total() {
        return lucro_total;
    }

    public void setLucro_total(float lucro_total) {
        this.lucro_total = lucro_total;
    }
    
    
}
