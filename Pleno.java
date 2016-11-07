/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Enrique
 */
public class Pleno {
     public static void main(String a[])throws FileNotFoundException,DocumentException,IOException{
         String ae;
         JFileChooser jfc= new JFileChooser();
         jfc.showOpenDialog(null);    
         BufferedReader archivo=new BufferedReader(new FileReader(jfc.getSelectedFile().getPath()));
         FileOutputStream nuevo= new FileOutputStream("hola.pdf");
          Document documento=new Document();
        PdfWriter.getInstance(documento,nuevo);
        documento.open();
       String w;
         while(archivo.ready()){
           
           ae=archivo.readLine();
           
           StringTokenizer tituloI = new StringTokenizer(ae, "{T}{#T}{C}{#C}{P}{#P}{S}{#S}");
           
            while(tituloI.hasMoreTokens()){
           String a1= tituloI.nextToken();
           w=a1;
           
            documento.add(new Paragraph(a1,
                    FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLUE)));
            }
           
                
           String a2="";
           
              while(tituloI.hasMoreTokens()) {
                   a2= tituloI.nextToken();
          documento.add(new Paragraph(a2,
                    FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.RED
                                )));
     }
               
           String a3="";
              while(tituloI.hasMoreTokens()) {
                   a3= tituloI.nextToken();
          documento.add(new Paragraph(a3,
                    FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.CYAN
                                )));
     }
              
           String a4="";
              while(tituloI.hasMoreTokens()) {
                   a4= tituloI.nextToken();
          documento.add(new Paragraph(a4,
                    FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.YELLOW
                                )));
     }
              System.out.println(archivo.readLine());
         }
          documento.close();
     }
}
