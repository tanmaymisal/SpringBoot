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

import com.nt.model.EmployeeBean;
@Repository("empMySQLService")
public class EmployeeMySQLSDAOImpl implements IEmployeeDAO {
	@Autowired
    private DataSource ds;
    private static final String GET_EMPS_BY_DESG = "SELECT * FROM EMPLOYEE1 WHERE JOB IN (?,?,?)";
    private static final String INSERT_EMP = "INSERT INTO EMPLOYEE1(ename,sal,job,deptno) VALUES(?,?,?,?)";
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<EmployeeBean> getEmpsByDesg(String d1, String d2, String d3) throws Exception {
		// TODO Auto-generated method stub
		 List<EmployeeBean> list = null;
		 try 
		 (
//		   get Pooled connection
				 Connection c = ds.getConnection();
//				 create prepared Stm object having pre compiled SQL query.
				 PreparedStatement ps = c.prepareStatement(GET_EMPS_BY_DESG);
		)
		 {
//			 set values to query params
			 ps.setString(1, d1);
			 ps.setString(2, d2);
			 ps.setString(3, d3);
			 //System.out.println(d1+"\n"+d2+"\n"+d3); working correctly
			 try 
			 (
//			    execute Query 
					 ResultSet rs = ps.executeQuery();
             )
			 {
//				 process the Result Object
				 list = new ArrayList();
				 while(rs.next()) 
				 {
//					 copy each record into java bean class object
					 EmployeeBean emp = new EmployeeBean();
					 emp.setEmpno(rs.getInt(1));
					// System.out.println(rs.getInt(1));//correct
					 emp.setEname(rs.getString(2));
					 //System.out.println(rs.getString(2));//correct
					 emp.setJob(rs.getString(4));
					// System.out.println(rs.getString(4));
					 emp.setSal(rs.getDouble(3));
					// System.out.println(rs.getDouble(3));

					 emp.setDeptno(rs.getInt(5));
					// System.out.println(rs.getInt(5));
//					 add each Java bean class object list Collection
					 list.add(emp);
					 
				 }//while
				
			} catch (SQLException se) {
				// TODO: handle exception
				System.out.println("Some DB problems , wait for some time");
				throw se;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some up known problems, wait for some time");
			throw e;
			
		}
		 return list;
	}

	@Override
	public int insertEmployee(EmployeeBean emp) throws Exception {
		// TODO Auto-generated method stub
		int result =0;
		try
		(
//		 get pooled connection
				Connection c = ds.getConnection();
//				create prepared Stm obj having the pre compiled SQL query 
				PreparedStatement ps = c.prepareStatement(INSERT_EMP);
	    )
		{
//			set Values to query params
			ps.setString(1,emp.getEname());
			ps.setDouble(2, emp.getSal());
			ps.setString(3, emp.getJob());
			ps.setInt(4,emp.getDeptno());
//			execute the SQL query 
			result = ps.executeUpdate();
			
			
		} catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
			throw se;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return result;
	}//method

}//class
