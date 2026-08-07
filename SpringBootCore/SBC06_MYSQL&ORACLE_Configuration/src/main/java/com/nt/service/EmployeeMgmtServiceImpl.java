package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.EmployeeBean;
@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
    @Autowired
//    DAO implement class obj is injected
    @Qualifier("dbDAO")
    private IEmployeeDAO empDao;
	@Override
	public List<EmployeeBean> fetchAllEmployeeByDesg(String d1, String d2, String d3) throws Exception {
		// TODO Auto-generated method stub
//		convert all designation to uppercase letters
		d1 = d1.toUpperCase();
		d2 = d2.toUpperCase();
		d3 = d3.toUpperCase();
//		use DAO
		List<EmployeeBean> list = empDao.getEmpsByDesg(d1, d2, d3);
//		sort the obj in list collection
//		Here we are using compare method to compare in ascending order
		list.sort((t1,t2)->t1.getEmpno().compareTo(t2.getEmpno()));
//		calculate gross salary and netSalary
//		list.forEach(emp -> emp.setGrossSal(emp.getSal()+(emp.getSal()*0.4);));
		list.forEach(
				emp-> {emp.setGrossSal(emp.getSal()+(emp.getSal()*0.4));
				emp.setNetSal(emp.getGrossSal()-(emp.getGrossSal()*0.2));
				}
				);
		return list;
	}

	@Override
	public String registerEmployee(EmployeeBean emp) throws Exception {
		// TODO Auto-generated method stub
		int result = empDao.insertEmployee(emp);
		return result == 0?"Employee not Registered":"Employee is registered";
	}

}
