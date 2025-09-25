package com.example.demo.Jasper;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

@RestController
@RequestMapping("/reporting")
public class sampleController {
	
	
	@GetMapping("/welcome")
	public ResponseEntity<byte[]> generateReport() {
	    try {
	        String reportPath = "reports/sampleFile.jrxml";
	        InputStream reportStream = getClass().getClassLoader().getResourceAsStream(reportPath);
	        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

	        // Main parameters
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("DapartmentName", "Computer Science");

	        // Build subDataset data
	        List<Map<String, ?>> dataset1List = new ArrayList<>();

	        Map<String, Object> row1 = new HashMap<>();
	        row1.put("Name", "Bala");
	        row1.put("College", "IIT");
	        row1.put("Mobile", "9999999999");
	        row1.put("Team", "Backend");
	        row1.put("company", "OpenAI");
	        dataset1List.add(row1);

	        Map<String, Object> row2 = new HashMap<>();
	        row2.put("Name", "Ravi");
	        row2.put("College", "NIT");
	        row2.put("Mobile", "8888888888");
	        row2.put("Team", "Frontend");
	        row2.put("company", "Google");
	        dataset1List.add(row2);

	        // Pass dataset into the subDataset parameter
	        JRMapCollectionDataSource dataset1DS = new JRMapCollectionDataSource(dataset1List);
	        parameters.put("Dataset1Param", dataset1DS);

	        // Fill the report (main report datasource can be empty)
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

	        // Export to PDF
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        JasperExportManager.exportReportToPdfStream(jasperPrint, out);

	        byte[] report = out.toByteArray();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=employee_report.pdf");

	        return ResponseEntity.ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(report);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).build();
	    }
	}


}
