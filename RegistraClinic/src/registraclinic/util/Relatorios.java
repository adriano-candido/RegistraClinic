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
        String diretorioPdf = "cadastroPaciente" + formatarData.format(new Date()) + ".pdf";

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
                document.add(new Paragraph(" "));
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

            PdfPTable tabela = new PdfPTable(3);

            PdfPCell celulaTituloNome = new PdfPCell(new Phrase("Nome", boldFont));
            PdfPCell celulaTituloSexo = new PdfPCell(new Phrase("Sexo", boldFont));
            PdfPCell celulaTituloCpfPaciente = new PdfPCell(new Phrase("CPF do paciente", boldFont));
            PdfPCell celulaTituloRgPaciente = new PdfPCell(new Phrase("RG do paciente", boldFont));
            PdfPCell celulaTituloSituacao = new PdfPCell(new Phrase("Situação do paciente", boldFont));
            PdfPCell celulaTituloTipo = new PdfPCell(new Phrase("Tipo do paciente", boldFont));
            PdfPCell celulaTituloCpfResponsavel = new PdfPCell(new Phrase("CPF do responsável", boldFont));
            PdfPCell celulaTituloRgResponsavel = new PdfPCell(new Phrase("RG do responsável", boldFont));
            PdfPCell celulaTituloEndereco = new PdfPCell(new Phrase("Endereço", boldFont));
            PdfPCell celulaTituloNumero = new PdfPCell(new Phrase("Nº", boldFont));
            PdfPCell celulaTituloBairro = new PdfPCell(new Phrase("Bairro", boldFont));
            PdfPCell celulaTituloComplemento = new PdfPCell(new Phrase("Complemento", boldFont));
            PdfPCell celulaTituloCidade = new PdfPCell(new Phrase("Cidade", boldFont));
            PdfPCell celulaTituloEstado = new PdfPCell(new Phrase("Estado", boldFont));
            PdfPCell celulaTituloTelefonePaciente = new PdfPCell(new Phrase("Telefone paciente", boldFont));
            PdfPCell celulaTituloNomeResponsavel = new PdfPCell(new Phrase("Nome do Responsável", boldFont));
            PdfPCell celulaTituloTelefoneResponsavel = new PdfPCell(new Phrase("Telefone responsável", boldFont));

            tabela.addCell(celulaTituloNome);
            tabela.addCell(celulaTituloSexo);
            tabela.addCell(celulaTituloCpfPaciente);
            tabela.addCell(celulaTituloRgPaciente);
            tabela.addCell(celulaTituloSituacao);
            tabela.addCell(celulaTituloTipo);
            tabela.addCell(celulaTituloCpfResponsavel);
            tabela.addCell(celulaTituloRgResponsavel);
            tabela.addCell(celulaTituloEndereco);
            tabela.addCell(celulaTituloNumero);
            tabela.addCell(celulaTituloBairro);
            tabela.addCell(celulaTituloComplemento);
            tabela.addCell(celulaTituloCidade);
            tabela.addCell(celulaTituloEstado);
            tabela.addCell(celulaTituloTelefonePaciente);
            tabela.addCell(celulaTituloNomeResponsavel);
            tabela.addCell(celulaTituloTelefoneResponsavel);

            //for (Object dado : dados) {

                //Paciente objeto = (Paciente) paciente;

                PdfPCell str1 = new PdfPCell(new Phrase(paciente.getNomePaciente()));
                PdfPCell str2 = new PdfPCell(new Phrase(paciente.getSexoPaciente()));
                PdfPCell str3 = new PdfPCell(new Phrase(paciente.getCpfPaciente()));
                PdfPCell str4 = new PdfPCell(new Phrase(paciente.getRgPaciente()));
                PdfPCell str5 = new PdfPCell(new Phrase(paciente.getSituacaoPaciente()));
                PdfPCell str6 = new PdfPCell(new Phrase(paciente.getTipoPaciente()));
                PdfPCell str7 = new PdfPCell(new Phrase(converterDataString(paciente.getDataNascimentoPaciente())));
                PdfPCell str8 = new PdfPCell(new Phrase(paciente.getCpfResponsavel()));
                PdfPCell str9 = new PdfPCell(new Phrase(paciente.getRgResponsavel()));
                PdfPCell str10 = new PdfPCell(new Phrase(paciente.getEnderecoPaciente()));
                PdfPCell str11 = new PdfPCell(new Phrase(paciente.getEnderecoNumeroPaciente()));
                PdfPCell str12 = new PdfPCell(new Phrase(paciente.getEnderecoBairroPaciente()));
                PdfPCell str13 = new PdfPCell(new Phrase(paciente.getEnderecoComplementoPaciente()));
                PdfPCell str14 = new PdfPCell(new Phrase(paciente.getCidadePaciente()));
                PdfPCell str15 = new PdfPCell(new Phrase(paciente.getEstadoPaciente()));
                PdfPCell str16 = new PdfPCell(new Phrase(paciente.getTelefonePaciente()));
                PdfPCell str17 = new PdfPCell(new Phrase(paciente.getNomeResponsavelPaciente()));
                PdfPCell str18 = new PdfPCell(new Phrase(paciente.getTelefoneResponsavelPaciente()));

                tabela.addCell(str1);
                tabela.addCell(str2);
                tabela.addCell(str3);
                tabela.addCell(str4);
                tabela.addCell(str5);
                tabela.addCell(str6);
                tabela.addCell(str7);
                tabela.addCell(str8);
                tabela.addCell(str9);
                tabela.addCell(str10);
                tabela.addCell(str11);
                tabela.addCell(str12);
                tabela.addCell(str13);
                tabela.addCell(str14);
                tabela.addCell(str15);
                tabela.addCell(str16);
                tabela.addCell(str17);
                
            //}

            tabela.setWidthPercentage(100);
            try {
                document.add(tabela);
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

            Desktop.getDesktop().open(new File(diretorioPdf));
        } catch (IOException de) {
            System.err.println(de.getMessage());
        }

        try {
            Paragraph linha = new Paragraph();
            linha.add(new Paragraph(" "));
            document.add(linha);
            //linha.add(new Paragraph("Assinatura: __________________________", boldFont));
            linha.setAlignment(Element.ALIGN_RIGHT);
            document.add(linha);
        } catch (DocumentException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.close();
    }

}
