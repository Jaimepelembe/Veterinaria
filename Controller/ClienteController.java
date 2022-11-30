/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class ClienteController {

    public ClienteController() {
    }
    
    
public boolean cadastrarCliente(String nome, String telefone, String morada) throws SQLException, ClassNotFoundException, ExceptionDAO{
    Validacao vv= new Validacao();
if(vv.validarString(nome) && vv.validarString(telefone) && vv.validarString(morada)){//&vv.validarSexo(sexo) && vv.validarString(especie)&&vv.validarString(raca)&& vv.validarString(pelo) &&vv.validarPeso(peso)&& vv.validaeID(idVet)&& vv.validaeID(idCli
 Cliente cliente = new Cliente(nome, telefone, morada);
 cliente.cadastrarCliente(cliente);
 return true;
 }
 return false;
 }  
 

public Vector<Cliente> pesquisarClienteMorada(String morada) throws SQLException, ClassNotFoundException, ExceptionDAO{
return new Cliente().pesquisarClienteMorada(morada);
}
public Vector<Cliente> pesquisarClienteNome(String nome) throws SQLException, ClassNotFoundException, ExceptionDAO{
return new Cliente().pesquisarClienteNome(nome);
}


public boolean actualizarCliente(int id,String nome, String telefone, String morada) throws SQLException, ClassNotFoundException, ExceptionDAO{
    Validacao vv= new Validacao();
if(vv.validarString(nome) && vv.validarString(telefone) && vv.validarString(morada) &&id>0){//&vv.validarSexo(sexo) && vv.validarString(especie)&&vv.validarString(raca)&& vv.validarString(pelo) &&vv.validarPeso(peso)&& vv.validaeID(idVet)&& vv.validaeID(idCli
 Cliente cliente = new Cliente(nome, telefone, morada);
 cliente.setIdCliente(id);
cliente.actualizarCliente(cliente);
 return true;
 }
 return false;
}
public boolean apagarCliente(int id) throws SQLException, ClassNotFoundException, ExceptionDAO{
 Cliente cliente = new Cliente();
if(id>0){
 cliente.setIdCliente(id);
cliente.apagarCliente(cliente);
 return true;
 }
 return false;
}    

public void gerarRelatorio(Vector<Cliente> clientes) throws FileNotFoundException, DocumentException, IOException, ClassNotFoundException, ExceptionDAO {
        //Tabela simples
        String ficheiro = "RelatorioClientes.pdf";
        OutputStream out = new FileOutputStream(ficheiro);
        Document doc = new Document();
        PdfWriter writter = PdfWriter.getInstance(doc, out);

        doc.open();
        doc.setPageSize(PageSize.A4);
        doc.setMargins(40, 40, 40, 40);
        
        //doc.add(new Chunk("Animais cadastrados na veterinaria"));
        doc.add(new Paragraph(Chunk.NEWLINE));

        Image img = Image.getInstance("src/cliente.png");
        doc.add(img);
        doc.add(new Paragraph(Chunk.NEWLINE));
        doc.add(new Paragraph(Chunk.NEWLINE));
        
        //Criar cabecalho da tabela
        PdfPTable table = new PdfPTable(3); //Criar tabela com 3 colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Nome"));//Criar o cabecalho Mocambique
        cell.setColspan(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(10.0f);
        table.addCell(cell);//Adicionar o cabecalho

        cell = new PdfPCell(new Paragraph("Telefone"));//Criar o cabecalho Nome
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(10.0f);
        table.addCell(cell);//Adicionar o cabecalho

        cell = new PdfPCell(new Paragraph("Morada"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(10.0f);
        table.addCell(cell);//Adicionar o cabecalho
        
        //Adicionar os dados dos animais
        String nome,telefone,morada;
        if(clientes!=null){
        for(int i=0;i<clientes.size();i++){
            nome=clientes.elementAt(i).getNome();
            telefone=clientes.elementAt(i).getTelefone();
            morada=clientes.elementAt(i).getMorada();
            table.addCell(nome);
            table.addCell(telefone);
            table.addCell(morada);
       
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
