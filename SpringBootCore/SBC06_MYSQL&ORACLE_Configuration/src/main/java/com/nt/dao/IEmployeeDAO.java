package com.nt.dao;

import java.util.List;

import com.nt.model.EmployeeBean;

public interface IEmployeeDAO
{
   public List<EmployeeBean> getEmpsByDesg(String d1,String d2,String d3) throws Exception;//this is an Abstract method and this method might throw Runtime Exceptions like nullPointer Exception
   public int insertEmployee(EmployeeBean emp) throws Exception;
}
