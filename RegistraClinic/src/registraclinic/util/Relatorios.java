/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registraclinic.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import registraclinic.paciente.Paciente;
import registraclinic.telas.CadastroPaciente;

/**
 *
 * @author Karlos
 */
public class Relatorios {

    private static String converterDataString(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(date);
    }

    public static void gerarRelatorioDadosCadastrais(Paciente paciente) {
        SimpleDateFormat formatarData = new SimpleDateFormat("dd-MM-yyyy(HH-mm-ss)");
        // criação do documento
        Document document = new Document();
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL);
        String diretorioPdf = "paciente" + formatarData.format(new Date()) + ".pdf";

        try {

            try {
                PdfWriter.getInstance(document, new FileOutputStream(diretorioPdf));
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.open();

            try {
                Paragraph linha = new Paragraph("Psique - Cadastro de Pacientes", boldFont);
                linha.setAlignment(Element.ALIGN_CENTER);
                document.add(linha);
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                //Linha 01
                Paragraph linha1 = new Paragraph("Nome do Paciente", boldFont);
                linha1.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha1);
                linha1 = new Paragraph(paciente.getNomePaciente(), normal);
                linha1.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha1);
                //Linha 02
                Paragraph linha2 = new Paragraph("Sexo", boldFont);
                linha2.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha2);
                linha2 = new Paragraph(paciente.getSexoPaciente(), normal);
                linha2.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha2);
                //Linha 03
                Paragraph linha3 = new Paragraph("CPF Paciente", boldFont);
                linha3.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha3);
                linha3 = new Paragraph(paciente.getCpfPaciente(), normal);
                linha3.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha3);
                //Linha 04
                Paragraph linha4 = new Paragraph("RG Paciente", boldFont);
                linha4.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha4);
                linha4 = new Paragraph(paciente.getRgPaciente(), normal);
                linha4.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha4);
                //Linha 05
                Paragraph linha5 = new Paragraph("Situação do Paciente", boldFont);
                linha5.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha5);
                linha5 = new Paragraph(paciente.getSituacaoPaciente(), normal);
                linha5.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha5);
                //Linha 06
                Paragraph linha6 = new Paragraph("Tipo Paciente", boldFont);
                linha6.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha6);
                linha6 = new Paragraph(paciente.getTipoPaciente(), normal);
                linha6.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha6);
                //Linha 07
                Paragraph linha7 = new Paragraph("Data de Nascimento do Paciente", boldFont);
                linha7.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha7);
                linha7 = new Paragraph(converterDataString(paciente.getDataCadastroPaciente()), normal);
                linha7.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha7);
                //Linha 08
                Paragraph linha8 = new Paragraph("CPF do Responsável", boldFont);
                linha8.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha8);
                linha8 = new Paragraph(paciente.getCpfResponsavel(), normal);
                linha8.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha8);
                //Linha 09
                Paragraph linha9 = new Paragraph("RG do Responsável", boldFont);
                linha9.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha9);
                linha9 = new Paragraph(paciente.getRgResponsavel(), normal);
                linha9.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha9);
                //Linha 10
                Paragraph linha10 = new Paragraph("Endereço", boldFont);
                linha10.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha10);
                linha10 = new Paragraph(paciente.getEnderecoPaciente(), normal);
                linha10.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha10);
                //Linha 11
                Paragraph linha11 = new Paragraph("Nº", boldFont);
                linha11.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha11);
                linha11 = new Paragraph(paciente.getEnderecoNumeroPaciente(), normal);
                linha11.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha11);
                //Linha 12
                Paragraph linha12 = new Paragraph("Bairro", boldFont);
                linha12.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha12);
                linha12 = new Paragraph(paciente.getEnderecoBairroPaciente(), normal);
                linha12.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha12);
                //Linha 13
                Paragraph linha13 = new Paragraph("Complemento", boldFont);
                linha13.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha13);
                linha13 = new Paragraph(paciente.getEnderecoComplementoPaciente(), normal);
                linha13.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(linha13);
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                document.add(new Paragraph(" "));
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

            Desktop.getDesktop().open(new File(diretorioPdf));
        } catch (IOException de) {
            System.err.println(de.getMessage());
        }

//        try {
//            Paragraph linha = new Paragraph();
//            linha.add(new Paragraph(" "));
//            document.add(linha);
//            linha.add(new Paragraph("Assinatura: __________________________", boldFont));
//            linha.setAlignment(Element.ALIGN_RIGHT);
//            document.add(linha);
//        } catch (DocumentException ex) {
//            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
//        }

        document.close();
    }

}
