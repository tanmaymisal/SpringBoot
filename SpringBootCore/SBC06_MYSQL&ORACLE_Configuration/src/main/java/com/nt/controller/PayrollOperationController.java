package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.EmployeeBean;
import com.nt.service.IEmployeeMgmtService;


@Controller("payroll")
public class PayrollOperationController {
     @SuppressWarnings("unused")
	@Autowired 
     private IEmployeeMgmtService service;
     public List <EmployeeBean> showAllEmployessByDesgs(String desg1,String desg2,String desg3) throws Exception
     {
//  	   use service 
  	   List<EmployeeBean> list = service.fetchAllEmployeeByDesg(desg1, desg2, desg3);
  	   return list;
     }
     public String ProcessEmployee(EmployeeBean emp) throws Exception
     {
//    	 use  service 
    	 String resutlMsg = service.registerEmployee(emp);
    	 return resutlMsg;
     }
}
