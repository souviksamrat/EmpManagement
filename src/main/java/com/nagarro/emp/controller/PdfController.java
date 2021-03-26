package com.nagarro.emp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lowagie.text.DocumentException;
import com.nagarro.emp.model.EmployeeDetails;
import com.nagarro.emp.pdfexport.EmployeePdfExport;
import com.nagarro.emp.service.EmployeeServiceImp;


@Controller
public class PdfController {
	
	@Autowired
	private EmployeeServiceImp empService;
		
	 @GetMapping("/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=empData" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<EmployeeDetails> listEmployee = this.empService.getAllEmployee();
	         
	        EmployeePdfExport exporter = new EmployeePdfExport(listEmployee);
	        exporter.export(response);
	         
	    }
}
