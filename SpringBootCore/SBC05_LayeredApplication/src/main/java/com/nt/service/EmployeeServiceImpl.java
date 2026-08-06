package com.nt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.EmployeeJBean;
@Service("empService")
// this is the dependent class therefore we are using the interface for getting the loose control 
public class EmployeeServiceImpl implements IEmployeeMgmtService {
    @Autowired
//    DAO implement class obj is injected
    private IEmployeeDAO empDao;
    
	@Override
	public List<EmployeeJBean> fetchAllEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		// TODO Auto-generated method stub
//		convert all desgnations to UPPERCASE letters
		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();
//		use DAO
		List<EmployeeJBean> list = empDao.getEmpsByDesg(desg1, desg2, desg3);
//		sort the object in List collection
//		Here we are using compare method to compare in ascending order
		list.sort((t1,t2)-> t1.getEmpNO().compareTo(t2.getEmpNO()));
//		calculate gross salary and netSalary
		//list.forEach(emp -> emp.setGrossSal(emp.getSal()+(emp.getSal()*0.4);));
	list.forEach
	(
	   emp ->{ emp.setGrossSal(emp.getSal()+(emp.getSal()*0.4));
	    emp.setNetSalary(emp.getGrossSal()-(emp.getGrossSal()*0.2));
	    
	   }
	);
		return list;
	}

	@Override
	public String registerEmployee(EmployeeJBean emp) throws Exception {
		// TODO Auto-generated method stub
		int result = empDao.insertEmployee(emp);
		return result==0?"Employee not Registered":"Employee is registered";
	}

}
