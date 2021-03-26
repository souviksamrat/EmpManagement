package com.nagarro.emp.pdfexport;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nagarro.emp.model.EmployeeDetails;

public class EmployeePdfExport {
	private List<EmployeeDetails> empData;

	public EmployeePdfExport(List<EmployeeDetails> empData) {
		this.empData = empData;
	}
	
	 private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Emp  Code", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Employee Name", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Employee Location", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Employee Email", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Employee DOB", font));
	        table.addCell(cell);       
	    }
	  private void writeTableData(PdfPTable table) {
	        for (EmployeeDetails empDetails : empData) {
	            table.addCell(String.valueOf(empDetails.getEmployeeCode()));
	            table.addCell(empDetails.getEmployeeName());
	            table.addCell(empDetails.getEmployeeLocation());
	            table.addCell(empDetails.getEmployeeEmail());
	            table.addCell(empDetails.getEmployeeDateOfBirth());
	        }
	    }
	  public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Employee", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}
