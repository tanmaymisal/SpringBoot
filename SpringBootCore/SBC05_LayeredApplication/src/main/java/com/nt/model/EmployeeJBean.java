package com.nt.model;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class EmployeeJBean implements Serializable {
  @SuppressWarnings("unused")
private String empNO,eName,desg,deptNO;
  @SuppressWarnings("unused")
private Double sal,GrossSal,netSalary;
  
}
