package com.nt.service;

import java.util.List;

import com.nt.model.EmployeeBean;

public interface IEmployeeMgmtService {
  public List<EmployeeBean> fetchAllEmployeeByDesg(String d1,String d2,String d3) throws Exception;
  public String registerEmployee(EmployeeBean emp) throws Exception;
}
