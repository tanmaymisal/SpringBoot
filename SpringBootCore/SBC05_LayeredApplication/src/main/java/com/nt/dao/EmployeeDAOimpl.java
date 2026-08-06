package com.nt.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.EmployeeJBean;
//  Note : In DAO class we place all the SQL Queries at the top of the class as the top of the
//  values of private static final String Constant variable that to in upper letters to 
//  differentiate them from the regular java code
@Repository("empDAO")
public class EmployeeDAOimpl implements IEmployeeDAO {
	@SuppressWarnings("unused")
	private static final String GET_EMPS_QUERY = "SELECT EMPNO,ENAME,DESG,SAL,DEPTNO FROM EMPLOYEE WHERE DESG IN (?,?,?) ORDER BY DESG";
	@SuppressWarnings("unused")
	private static final String INSERT_EMP = "INSERT INTO EMPLOYEE  VALUES(EMPNO_SEQ1.NEXTVAL,?,?,?,?)";
	 List<EmployeeJBean> list = new ArrayList<>();
	@Autowired
	private DataSource ds;
	
	@Override
	public List<EmployeeJBean> getEmpsByDesg(String desg1, String desg2, String desg3) throws Exception {
		// TODO Auto-generated method stub
		
		
		try (//gives pooled jdbc connection object
				Connection c = ds.getConnection();
	PreparedStatement ps = c.prepareStatement(GET_EMPS_QUERY);
				)
		{

//			 set value to params
			 ps.setString(1, desg1);
			 ps.setString(2, desg2);
			 ps.setString(3, desg3);
//			 execute sql query
			  try(ResultSet rs = ps.executeQuery())
			  {
//				  copy each record of the result set obj to MODEL class obj
				  while(rs.next()) 
				  {
//					  create EmployeeJbean object to hold the data and then add to the list which can be forwarded to the service layer
                      EmployeeJBean emp = new EmployeeJBean();
//                      copy each record to the emp object
                      emp.setEmpNO(rs.getString(1));
                      emp.setEName(rs.getString(2));
                      emp.setDesg(rs.getString(3));
                      emp.setSal(rs.getDouble(4));
                      emp.setDeptNO(rs.getString(5));
//                      add each Model class object to result set
                      list.add(emp);
				  }//try 2
			  }
			  catch (SQLException e) {
				// TODO: handle exception
				  e.printStackTrace();// exception rethrowing for exception propogation
				  throw e;
			}
		
		}//try 1
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	@Override
	public int insertEmployee(EmployeeJBean emp) throws Exception {
		// TODO Auto-generated method stub
		int result =0;
		try
		(
//		     get pooled connection
				Connection c = ds.getConnection();
//				create preparedStatement obj having the pre-compiled SQL query
				PreparedStatement ps = c.prepareStatement(INSERT_EMP);
		) 
		
		{
//			set values to Query params 
			ps.setString(1,emp.getEName());
			ps.setString(2,emp.getDesg());
			ps.setDouble(3, emp.getSal());
			ps.setString(4, emp.getDeptNO());
//			execute the sql query
			result = ps.executeUpdate();
			
		} catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
			throw se;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}//method
/*
 * In layered  app development , we  need to catch and rethrow the exception in the following to pass
 *  OR propogate  the exception to caller/ previous Layer
 *  
 *  => DAO Layer
 *  => Service Layer
 *  => Controller Layer
 *  
 *  
 *  It is recommended to use seperate jdbc con for every persistence operation we  do on the DB s/w becoz the rollback  
 *  persisitence operation should effect other persistence operations that are happening
 * */
