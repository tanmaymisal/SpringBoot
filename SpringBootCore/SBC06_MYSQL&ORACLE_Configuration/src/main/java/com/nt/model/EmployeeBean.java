package com.nt.model;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class EmployeeBean implements Serializable {
         private String ename,job;
         private Integer empno,deptno;
         private Double sal,GrossSal,netSal;
         
         
}
