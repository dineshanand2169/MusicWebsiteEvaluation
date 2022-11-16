package spring.pdfHandler;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import spring.model.PurchaseDetails;


import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class InvoiceGenerator {
    private List<PurchaseDetails> purchaseDetailsList;

    public InvoiceGenerator(List<PurchaseDetails> purchaseDetailsList) {
        this.purchaseDetailsList = purchaseDetailsList;
    }


    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Transaction ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Billing Address ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Payment Mode", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Purchase Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Bill Amount", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) {
        for (PurchaseDetails purchaseDetails : purchaseDetailsList) {
            table.addCell("TiEVEmW"+purchaseDetails.getPurchaseId());
            table.addCell("AD"+purchaseDetails.getBillingAddressId());
            table.addCell(String.valueOf(purchaseDetails.getPaymentMode()));
            table.addCell(String.valueOf(purchaseDetails.getPurchaseDate()));
            table.addCell("INR"+purchaseDetails.getBillAmount());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("EveMusic.com", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{2.5f, 1.5f, 3.5f, 2.5f, 2.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
