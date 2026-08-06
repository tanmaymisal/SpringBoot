package com.nt.service;

import java.util.List;

import com.nt.model.EmployeeJBean;

public interface IEmployeeMgmtService {
        public List<EmployeeJBean> fetchAllEmployeesByDesgs(String desg1,String desg2,String desg3) throws Exception;
        public String registerEmployee(EmployeeJBean emp) throws Exception;
}
