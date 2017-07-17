package com.pcms.util;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class IReportDataSourceProvider extends JRAbstractBeanDataSourceProvider {
	private List<?> dataList;  
	  
    public IReportDataSourceProvider(Class<?> beanClass) {  
        super(beanClass);  
    }  
      
    public IReportDataSourceProvider(Class<?> beanClass, List<?> dataSourceList) {  
        super(beanClass);  
        this.dataList = dataSourceList;  
    }  
  
    public JRDataSource create(JasperReport report) throws JRException {  
        return new JRBeanCollectionDataSource(this.dataList);  
    }  
  
    public void dispose(JRDataSource dataSource) throws JRException {  
        this.dataList = null;  
    }  
}
