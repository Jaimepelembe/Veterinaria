package Controller;

import static Controller.RelatorioController.MostrarDocumento;
import Model.DAO.AnimalDAO;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Cliente;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class AnimalController {

    public AnimalController() {
    }
    //Metodo que recebe dados da view e passa para o model   

    public boolean cadastrarAnimal(String nome, String especie, String sexo, String raca, String pelo, float peso, Date dt_nascimentO, int idCli, int idVet) throws SQLException, ClassNotFoundException, ExceptionDAO {
        Validacao vv = new Validacao();
        if (vv.validarString(nome) && vv.validarString(sexo) && vv.validarString(especie) && vv.validarString(raca) && vv.validarString(pelo) && vv.validarPeso(peso) && vv.validaID(idVet) && vv.validaID(idCli)) {
            Animal animal = new Animal(nome, especie, sexo, raca, pelo, peso, dt_nascimentO, idCli, idVet);
            animal.cadastrarAnimal(animal);
            return true;
        }
        return false;
    }

   public boolean actualizarAnimal(int id,String nome, String especie, String sexo,String raca,String cor,float peso,Date data) throws SQLException, ClassNotFoundException, ExceptionDAO{
    Validacao vv= new Validacao();
if(id>0 && vv.validarString(nome) && vv.validarString(especie) && vv.validarString(sexo) && vv.validarString(raca) && vv.validarString(cor) && peso>0 && data!=null){
 Animal animal = new Animal();
 animal.setIdAnimal(id);
 animal.setNome(nome);
 animal.setEspecie(especie);
 animal.setSexo(sexo);
 animal.setRaca(raca);
 animal.setCor_pelo(cor);
 animal.setPeso(peso);
 animal.setDt_nascimento(data);
 
 animal.actualizarAnimal(animal);
 return true;
 }
 return false;
} 
  
   public boolean apagarAnimal(int id) throws SQLException, ClassNotFoundException, ExceptionDAO{
Animal animal= new Animal();
if(id>0){
 animal.setIdAnimal(id);
animal.apagarAnimal(animal);
 return true;
 }
 return false;
}   
   
    public Vector<Cliente> selecionarCliente() throws SQLException, ClassNotFoundException, ExceptionDAO {

        return new AnimalDAO().selecionarCliente();
    }

    public Vector<Animal> pesquisarAnimalEspecie(String especie) throws ClassNotFoundException, ExceptionDAO {
        return new Animal().pesquisarAnimalEspecie(especie);
    }

    public Vector<Animal> pesquisarAnimalRaca(String Raca) throws ClassNotFoundException, ExceptionDAO {
        return new Animal().pesquisarAnimalRaca(Raca);
    }
    
    public Vector<Animal> pesquisarAnimalNome(String nome) throws ClassNotFoundException, ExceptionDAO {
        return new Animal().pesquisarAnimalNome(nome);
    }
    
 public void gerarRelatorio(Vector<Animal> animais) throws FileNotFoundException, DocumentException, IOException, ClassNotFoundException, ExceptionDAO {
        //Tabela simples
        String ficheiro = "RelatorioAnimais.pdf";
        OutputStream out = new FileOutputStream(ficheiro);
        Document doc = new Document();
        PdfWriter writter = PdfWriter.getInstance(doc, out);

        doc.open();
        doc.setPageSize(PageSize.A4);
        doc.setMargins(40, 40, 40, 40);
        
        //doc.add(new Chunk("Animais cadastrados na veterinaria"));
        doc.add(new Paragraph(Chunk.NEWLINE));

        Image img = Image.getInstance("src/animais.jpg");
        doc.add(img);
        doc.add(new Paragraph(Chunk.NEWLINE));
        doc.add(new Paragraph(Chunk.NEWLINE));
        
        //Criar cabecalho da tabela
        PdfPTable table = new PdfPTable(5); //Criar tabela com 5 colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Nome"));//Criar o cabecalho Mocambique
        cell.setColspan(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(10.0f);
        table.addCell(cell);//Adicionar o cabecalho

        cell = new PdfPCell(new Paragraph("Especie"));//Criar o cabecalho Nome
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(10.0f);
        table.addCell(cell);//Adicionar o cabecalho

        cell = new PdfPCell(new Paragraph("Sexo"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(10.0f);
        table.addCell(cell);//Adicionar o cabecalho
        
        cell = new PdfPCell(new Paragraph("Raca"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(10.0f);
        table.addCell(cell);//Adicionar o cabecalho
        
        cell = new PdfPCell(new Paragraph("Data nascimento"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(10.0f);
        table.addCell(cell);//Adicionar o cabecalho
        
        //Adicionar os dados dos animais
        String nome,especie,sexo,raca,data;
        if(animais!=null){
        for(int i=0;i<animais.size();i++){
            nome=animais.elementAt(i).getNome();
            especie=animais.elementAt(i).getEspecie();
            sexo=animais.elementAt(i).getSexo();
            raca=animais.elementAt(i).getRaca();
            data=""+animais.elementAt(i).getDt_nascimento();
            table.addCell(nome);
            table.addCell(especie);
            table.addCell(sexo);
            table.addCell(raca);
            table.addCell(data);
}}       
        doc.add(table);
        //Nova linha
        doc.add(new Paragraph(Chunk.NEWLINE));
        doc.add(new Paragraph(Chunk.NEWLINE));
        
        String dat=""+new Data().dataActual();
        doc.add(new Paragraph("Data: "+dat));
        doc.close();
        MostrarDocumento(ficheiro);

    
    }

 public static void MostrarDocumento(String nomeFicheiro) throws IOException {
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
            desktop.open(new File(nomeFicheiro));
        }

    }

}

 
    
