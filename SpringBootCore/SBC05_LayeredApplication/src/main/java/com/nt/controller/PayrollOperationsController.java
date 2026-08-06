package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.EmployeeJBean;
import com.nt.service.IEmployeeMgmtService;
//It is target Spring Bean 
@Controller("payroll")
public class PayrollOperationsController {
           @Autowired
           private IEmployeeMgmtService service;//Service implemented class obj is injected
           public List <EmployeeJBean> showAllEmployessByDesgs(String desg1,String desg2,String desg3) throws Exception
           {
//        	   use service 
        	   List<EmployeeJBean> list = service.fetchAllEmployeesByDesgs(desg1, desg2, desg3);
        	   return list;
           }
           public String ProcessEmployee(EmployeeJBean emp) throws Exception
           {
//        	   use service
        	   String resultMsg = service.registerEmployee(emp);
        	   return resultMsg;
           }
           
}
