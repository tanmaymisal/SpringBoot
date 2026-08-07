package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.PayrollOperationController;
import com.nt.model.EmployeeBean;

@SpringBootApplication
@ImportResource("com/nt/configurations/applicationContext.xml")
public class LayeredAppMinPrjOracleAndMySqlApplication {

	public static void main(String[] args) {
		 @SuppressWarnings("unused")
//		 get IOC container
		ApplicationContext ctx =SpringApplication.run(LayeredAppMinPrjOracleAndMySqlApplication.class, args);
		 
//		get Controller(Target Spring bean)  object ref 
		 PayrollOperationController con = ctx.getBean("payroll",PayrollOperationController.class);
System.out.println("Enter your option for :\n\t 1. Add\n\t2. ShowAll");
Scanner s = new Scanner(System.in);
int op = s.nextInt();
switch(op) 
{
case 1 : 
		{
			 //		 invoke business logic method1
			System.out.println("Register new Emp");
			System.out.println("Enter Name :");
			String name = s.next();
			s.nextLine();
			System.out.println("Enter Desg : ");
			String desg = s.nextLine();
			System.out.println("Enter salary : ");
			Double sal = s.nextDouble();
			System.out.println("Enter Dept no : (10,20,30,40)");
			int dep = s.nextInt();
//			create employee class object
			EmployeeBean remp = new EmployeeBean(); 
			remp.setEname(name);
			remp.setJob(desg);
			remp.setSal(sal);
			remp.setDeptno(dep);
			try {
				String resultMsg = con.ProcessEmployee(remp);
				System.out.println(resultMsg);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			  
		}
		 LayeredAppMinPrjOracleAndMySqlApplication.main(args);
		break;
case 2 :
		{
			 //		 invoke business logic method-2
			System.out.print("Enter Designation no.1 : ");
			String de1 = s.next();
			System.out.print("Enter Designation no.2 : ");
			String de2 = s.next();
			System.out.print("Enter Designation no.3 : ");
			String de3 = s.next();
			try (s)
			{
				List<EmployeeBean> list = con.showAllEmployessByDesgs(de1, de2, de3);
//				process results
				list.forEach(
						emp ->
						{
							System.out.println(emp);
						}
						);
				
			}
			catch(Exception e) {}
		}
		   
		break;
default : System.err.println("Enter valid option...");
          LayeredAppMinPrjOracleAndMySqlApplication.main(args);
}
		
//close container
s.close();
	((ConfigurableApplicationContext) ctx).close(); 
		 
	}

}
