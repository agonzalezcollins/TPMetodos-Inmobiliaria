///*
// * This code is part of the 'iText'.
// * http://itextdocs.lowagie.com/tutorial/
// */
//
//package tpmetodos.utils;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.ExceptionConverter;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfGState;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfPageEventHelper;
//import com.itextpdf.text.pdf.PdfTemplate;
//import com.itextpdf.text.pdf.PdfWriter;
//
//
///**
// * ImprimirVenta (add Watermarks and Pagenumbers) EJEMPLO
// * 
// * @author Agu
// *
// */
//
//
//public class ImprimirVenta extends PdfPageEventHelper {
//
//    /** An Image that goes in the header. */
//    public Image headerImage;
//    /** The headertable. */
//    public PdfPTable table;
//    /** The Graphic state */
//    public PdfGState gstate;
//    /** A template that will hold the total number of pages. */
//    public PdfTemplate tpl;
//    /** The font that will be used. */
//    public BaseFont helv;
//    
//    /**
//     * Generates a document with a header containing Page x of y and with a Watermark on every page.
//     * @param args no arguments needed
//     */
//    public static void main(String args[]) {
//        try {
//            // step 1: creating the document
//            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
//
//            // step 2: creating the writer
//            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("prueba.pdf"));
//            // si deseas que respusta sea al vuelo  y no en archivo
//            //esta clase debe importar -- import javax.servlet.http.*;
//			//y recibir como parametro el objeto response  
//			//así el clien te recibira la respuesta  en su navegador  en pdf ejemplo:
//			///PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());
//
//            // step 3: initialisations + opening the document
//           
//            writer.setPageEvent(new ImprimirVenta());
//            doc.open();
//            // step 4: adding content
//            String text = "some padding text ";
//            for (int k = 0; k < 10; ++k)
//                text += text;
//            Paragraph p = new Paragraph(text);
//            p.setAlignment(Element.ALIGN_JUSTIFIED);
//            doc.add(p);
//            // step 5: closing the document
//            doc.close(); //TODO ERROR DE VERSION
//        }
//        catch ( Exception e ) {
//            e.printStackTrace();
//        }
//    }
//    
//    /**
//     * @see com.lowagie.text.pdf.PdfPageEventHelper#onOpenDocument(com.lowagie.text.pdf.PdfWriter, com.lowagie.text.Document)
//     */
//    public void onOpenDocument(PdfWriter writer, Document document) {
//        try {
//            // initialization of the header table
//        	String PathGeneral = new File(".").getCanonicalPath();
//            headerImage = Image.getInstance(PathGeneral + "/images/casita.jpg");
//
//            table = new PdfPTable(2);
//            Phrase p = new Phrase(); 
//            Chunk ck = new Chunk("lowagie.com\n", new Font()); //new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLDITALIC, Color.blue)
//            p.add(ck);
//            ck = new Chunk("Ghent\nBelgium", new Font()); //new Font(Font.HELVETICA, 12, Font.NORMAL, Color.darkGray)
//            p.add(ck);
//            table.getDefaultCell().setBackgroundColor(BaseColor.YELLOW);
//            table.getDefaultCell().setBorderWidth(0);
//            table.addCell(p);
//            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
//            table.addCell(new Phrase(new Chunk(headerImage, 0, 0)));
//            // initialization of the Graphic State
//            gstate = new PdfGState();
//            gstate.setFillOpacity(0.3f);
//            gstate.setStrokeOpacity(0.3f);
//            // initialization of the template
//            tpl = writer.getDirectContent().createTemplate(100, 100);
//            tpl.setBoundingBox(new Rectangle(-20, -20, 100, 100));
//            // initialization of the font
//            helv = BaseFont.createFont("Helvetica", BaseFont.WINANSI, false);
//        }
//        catch(Exception e) {
//            throw new ExceptionConverter(e);
//        }
//    }    
//    
//    /**
//     * @see com.lowagie.text.pdf.PdfPageEventHelper#onEndPage(com.lowagie.text.pdf.PdfWriter, com.lowagie.text.Document)
//     */
//    public void onEndPage(PdfWriter writer, Document document) {
//        PdfContentByte cb = writer.getDirectContent();
//        cb.saveState();
//        // write the headertable
//        table.setTotalWidth(document.right() - document.left());
//        table.writeSelectedRows(0, -1, document.left(), document.getPageSize().getHeight() - 50, cb);
//        // compose the footer
//        String text = "Page " + writer.getPageNumber() + " of ";
//        float textSize = helv.getWidthPoint(text, 12);
//        float textBase = document.bottom() - 20;
//        cb.beginText();
//        cb.setFontAndSize(helv, 12);
//        // for odd pagenumbers, show the footer at the left
//        if ((writer.getPageNumber() & 1) == 1) {
//            cb.setTextMatrix(document.left(), textBase);
//            cb.showText(text);
//            cb.endText();
//            cb.addTemplate(tpl, document.left() + textSize, textBase);
//        }
//        // for even numbers, show the footer at the right
//        else {
//            float adjust = helv.getWidthPoint("0", 12);
//            cb.setTextMatrix(document.right() - textSize - adjust, textBase);
//            cb.showText(text);
//            cb.endText();
//            cb.addTemplate(tpl, document.right() - adjust, textBase);
//        }
//        cb.saveState();
//        // draw a Rectangle around the page
//        cb.setColorStroke(BaseColor.ORANGE);
//        cb.setLineWidth(2);
//        cb.rectangle(20, 20, document.getPageSize().getWidth() - 40, document.getPageSize().getHeight() - 40);
//        cb.stroke();
//        cb.restoreState();
//        // starting on page 3, a watermark with an Image that is made transparent
//        if (writer.getPageNumber() >= 3) {
//            cb.setGState(gstate);
//            cb.setColorFill(BaseColor.RED);
//            cb.beginText();
//            cb.setFontAndSize(helv, 48);
//            cb.showTextAligned(Element.ALIGN_CENTER, "Watermark Opacity " + writer.getPageNumber(), document.getPageSize().getWidth() / 2, document.getPageSize().getHeight() / 2, 45);
//            cb.endText();
//            try {
//                cb.addImage(headerImage, headerImage.getWidth(), 0, 0, headerImage.getHeight(), 440, 80);
//            }
//            catch(Exception e) {
//                throw new ExceptionConverter(e);
//            }
//            cb.restoreState();
//        }
//    }
//    
//    /**
//     * @see com.lowagie.text.pdf.PdfPageEventHelper#onStartPage(com.lowagie.text.pdf.PdfWriter, com.lowagie.text.Document)
//     */
//    public void onStartPage(PdfWriter writer, Document document) {
//        if (writer.getPageNumber() < 3) {
//            PdfContentByte cb = writer.getDirectContentUnder();
//            cb.saveState();
//            cb.setColorFill(BaseColor.PINK);
//            cb.beginText();
//            cb.setFontAndSize(helv, 48);
//            cb.showTextAligned(Element.ALIGN_CENTER, "My Watermark Under " + writer.getPageNumber(), document.getPageSize().getWidth() / 2, document.getPageSize().getHeight() / 2, 45);
//            cb.endText();
//            cb.restoreState();
//        }
//    }
//    
//    /**
//     * @see com.lowagie.text.pdf.PdfPageEventHelper#onCloseDocument(com.lowagie.text.pdf.PdfWriter, com.lowagie.text.Document)
//     */
//    public void onCloseDocument(PdfWriter writer, Document document) {
//       tpl.beginText();
//       tpl.setFontAndSize(helv, 12);
//       tpl.setTextMatrix(0, 0);
//       tpl.showText("" + (writer.getPageNumber() - 1));
//       tpl.endText();
//    }
//}