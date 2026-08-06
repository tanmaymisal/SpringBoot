package com.nt.dao;

import java.util.List;

import com.nt.model.EmployeeJBean;

public interface IEmployeeDAO {
       public List<EmployeeJBean> getEmpsByDesg(String desg1,String desg2,String desg3) throws Exception;  // this is an Abstract method and this method might throw Runtime Exceptions like nullPointer Exp
       public int insertEmployee(EmployeeJBean emp)  throws Exception;
}
