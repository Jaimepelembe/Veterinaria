/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.AnimalDAO;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
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
import java.util.Vector;

/**
 *
 * @author multi
 */
public class RelatorioController {

    public RelatorioController() throws IOException, FileNotFoundException, DocumentException, ClassNotFoundException, ExceptionDAO {
        //tabelaCabecalho();
    }

    public void RelatorioAnimaisCadastrados() {

    }
//public Vector<Animal> pesquisarAnimalRelatorio() throws ClassNotFoundException, ExceptionDAO {
//return new Animal().pesquisarAnimalRelatorio();
////        }
//    public void tabelaCabecalho() throws FileNotFoundException, DocumentException, IOException, ClassNotFoundException, ExceptionDAO {
//        //Vector<Animal> animais= pesquisarAnimalRelatorio();
//       
//        
//        //Tabela simples
//        String ficheiro = "relatorioCadastroAnimais.pdf";
//        OutputStream out = new FileOutputStream(ficheiro);
//        Document doc = new Document();
//        PdfWriter writter = PdfWriter.getInstance(doc, out);
//
//        doc.open();
//        doc.setPageSize(PageSize.A4);
//        doc.setMargins(40, 40, 40, 40);
//        
//        //doc.add(new Chunk("Animais cadastrados na veterinaria"));
//        doc.add(new Paragraph(Chunk.NEWLINE));
//
//        Image img = Image.getInstance("src/menu.jpg");
//        doc.add(img);
//        doc.add(new Paragraph(Chunk.NEWLINE));
//        doc.add(new Paragraph(Chunk.NEWLINE));
//        
//        //Criar cabecalho da tabela
//        PdfPTable table = new PdfPTable(5); //Criar tabela com 5 colunas
//        PdfPCell cell = new PdfPCell(new Paragraph("Nome"));//Criar o cabecalho Mocambique
//        cell.setColspan(0);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(BaseColor.GRAY);
//        cell.setPadding(10.0f);
//        table.addCell(cell);//Adicionar o cabecalho
//
//        cell = new PdfPCell(new Paragraph("Especie"));//Criar o cabecalho Nome
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(BaseColor.GRAY);
//        cell.setPadding(10.0f);
//        table.addCell(cell);//Adicionar o cabecalho
//
//        cell = new PdfPCell(new Paragraph("Sexo"));
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(BaseColor.GRAY);
//        cell.setPadding(10.0f);
//        table.addCell(cell);//Adicionar o cabecalho
//        
//        cell = new PdfPCell(new Paragraph("Raca"));
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(BaseColor.GRAY);
//        cell.setPadding(10.0f);
//        table.addCell(cell);//Adicionar o cabecalho
//        
//        cell = new PdfPCell(new Paragraph("Data nascimento"));
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(BaseColor.GRAY);
//        cell.setPadding(10.0f);
//        table.addCell(cell);//Adicionar o cabecalho
//        
//        //Adicionar os dados dos animais
//        String nome,especie,sexo,raca,data;
//        
//        for(int i=0;i<animais.size();i++){
//            nome=animais.elementAt(i).getNome();
//            especie=animais.elementAt(i).getEspecie();
//            sexo=animais.elementAt(i).getSexo();
//            raca=animais.elementAt(i).getRaca();
//            data=""+animais.elementAt(i).getDt_nascimento();
//            table.addCell(nome);
//            table.addCell(especie);
//            table.addCell(sexo);
//            table.addCell(raca);
//            table.addCell(data);
//            
//}
//        doc.add(table);
//        doc.close();
//        MostrarDocumento(ficheiro);
//
//    }
////public PdfPTable adicionarElementosTabela(PdfPTable tabela,Vector elementos){
////for(int i=0;i<elementos.size();i++){
////
////}
////
//}
    public static void MostrarDocumento(String nomeFicheiro) throws IOException {
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
            desktop.open(new File(nomeFicheiro));
        }

    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, DocumentException, ClassNotFoundException, ExceptionDAO {
        new RelatorioController();
    }
}
