package com.pcms.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcms.model.User;
import com.pcms.util.ConnectionProvider;
import com.pcms.util.IReportDataSourceProvider;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("report")
public class ReportController {

	@RequestMapping("test")
	public String test(Model model){
		 
		
		List<User> list = getList();
		
		//method 1
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
		
		//method 2
//		List<Map<String,Object>> maps = new ArrayList<>();
//		for(User user:list){
//			Map<String,Object> map = new HashMap<>();
//			map.put("id", user.getId());
//			map.put("name", user.getName());
//			maps.add(map);
//		}
//		JRDataSource jrDataSource = this.jrDataSource(maps);
		
        model.addAttribute("jrMainDataSource", jrDataSource); 

        // 动态指定报表模板url  
	    model.addAttribute("url", "/WEB-INF/jasper/user.jasper");  
	    model.addAttribute("format", "pdf"); // 报表格式  
	    return "iReportView"; // 对应jasper-defs.xml中的bean id   
	}
	
	
//	关于中文显示问题，自己下载相应jar包，调试了半天没成功。最后还是直接用了原博主提供的itext-2.1.7.js2.jar和
//	itextasian-2.1.7.js2.jar两个文件，通过本地导入方式加到项目中。
	
	@RequestMapping("company")
	public String company(Model model) {

		try {
			// 报表数据源
			Statement stmt = ConnectionProvider.getConnection().createStatement();
			// JdbcConnectionProvider为前面建立的mysql连接文件
			ResultSet rs = stmt.executeQuery("select * from company");// 执行query语句得到结果
			JRDataSource jrDataSource = new JRResultSetDataSource(rs);

			// 动态指定报表模板url
			model.addAttribute("url", "/WEB-INF/jasper/test.jasper");
			// 填入你的模板文件
			model.addAttribute("format", "pdf"); // 报表格式
			model.addAttribute("jrMainDataSource", jrDataSource);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "iReportView"; // 对应jasper-defs.xml中的bean id
	}
	
	
	
	private JRDataSource jrDataSource(List<Map<String,Object>> list){  
	    JRDataSource jrDataSource = null;  
	    try {  
	        IReportDataSourceProvider dataSource = new IReportDataSourceProvider(HashMap.class, list);  
	        jrDataSource = dataSource.create(null);  
	    } catch (JRException e) {  
	        e.printStackTrace();  
	    }  
	    return jrDataSource;  
	}
	
	
	private List<User> getList(){
		List<User> list = new ArrayList<>();
		for(int i=0;i<35;i++){
		User user = new User();
		user.setId(Long.valueOf(i+1));
		user.setName("name"+i);
//		user.setCode("code-"+i);
		list.add(user);
		}
		return list;
	}
	
}
