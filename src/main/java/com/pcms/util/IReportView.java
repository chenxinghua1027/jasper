package com.pcms.util;

import java.util.Map;

import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class IReportView extends JasperReportsMultiFormatView {

	private JasperReport jasperReport;  
	  
    public IReportView() {  
        super();  
    }  
  
    protected JasperPrint fillReport(Map<String, Object> model) throws Exception {  
        if (model.containsKey("url")) {  
            setUrl(String.valueOf(model.get("url")));  
            this.jasperReport = loadReport();  
        }  
        JasperPrint jasperPrint = super.fillReport(model);  
        return jasperPrint;  
  
    }  
  
    protected JasperReport getReport() {  
        return this.jasperReport;  
    }  
}
