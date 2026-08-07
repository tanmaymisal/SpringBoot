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
@Repository("empOracleService")
public class EmployeeOracleDAOImpl implements IEmployeeDAO {
    @SuppressWarnings("unused")
	private static final String GET_EMPS_QUERY = "SELECT EMPNO,ENAME,DESG,SAL,DEPTNO FROM EMPLOYEE1 WHERE DESG IN (?,?,?) ORDER BY DESG";
    @SuppressWarnings("unused")
	private static final String INSERT_EMP = "INSERT INTO EMPLOYEE1  VALUES(EMPNO_SEQ1.NEXTVAL,?,?,?,?)";
	List<EmployeeBean> list = new ArrayList<>();
	@Autowired
	private DataSource ds;
	
    @Override
	public List<EmployeeBean> getEmpsByDesg(String d1, String d2, String d3) throws Exception {
		// TODO Auto-generated method stub
		try
		(
//		  gives pooled jdbc connection object
				Connection c = ds.getConnection();
				PreparedStatement ps = c.prepareStatement(GET_EMPS_QUERY);
		) 
		{
//			set values to params
			ps.setString(1, d1);
			ps.setString(2, d2);
			ps.setString(3, d3);
//			execute sql query 
			try(ResultSet rs = ps.executeQuery()) 
			{
//			    copy each record of the result set obj to MODEL class obj
				while(rs.next()) 
				{
//					create EmployeeBean object to hold the data and then add to the list which forwarded to the service layer
					EmployeeBean emp = new EmployeeBean();
//					copy each record to the emp object
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSal(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
//					add each model class object to result set
					list.add(emp);
				}//try 2
			} catch (SQLException se) {
				// TODO: handle exception
				se.printStackTrace();
				throw se;
			}//try 1
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
//			get pooled connection
				Connection c = ds.getConnection();
//				create Preparedstatement object having the pre-compiled sql query
				PreparedStatement ps = c.prepareStatement(INSERT_EMP);
		)
		{
//			set values to query params 
			ps.setString(1,emp.getEname());
			ps.setString(2,emp.getJob());
			ps.setDouble(3, emp.getSal());
			ps.setInt(4, emp.getDeptno());
//			execute the sql query
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		    e.printStackTrace();
		    throw e;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}//method
