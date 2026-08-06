package com.nt;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.EmployeeJBean;
import com.nt.service.EmployeeServiceImpl;

@SpringBootApplication
public class SpringBootCoreProject06LayeredAppMinPrjAppl {

	public static void main(String[] args) {
//		get IOC container
		ApplicationContext  ctx = SpringApplication.run(SpringBootCoreProject06LayeredAppMinPrjAppl.class, args);
//		get Controller(Target) class spring Bean object reference
		PayrollOperationsController controller = ctx.getBean("payroll",PayrollOperationsController.class);
//		invoke insertion business logic method
		System.out.println("Register new Emp");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name :");
		String name = sc.next();
		sc.nextLine();
		System.out.println("Enter Desg : ");
		String desg = sc.nextLine();
		System.out.println("Enter salary : ");
		Double sal = sc.nextDouble();
		System.out.println("Enter Dept no : (10,20,30,40)");
		String dep = sc.next();
		
//		create employee class object
		EmployeeJBean remp = new EmployeeJBean(); 
		remp.setEName(name);
		remp.setDesg(desg);
		remp.setSal(sal);
		remp.setDeptNO(dep);
		try {
			String resultMsg = controller.ProcessEmployee(remp);
			System.out.println(resultMsg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		invoke business class method 
		System.out.print("Enter Designation no.1 : ");
		String de1 = sc.next();
		System.out.print("Enter Designation no.2 : ");
		String de2 = sc.next();
		System.out.print("Enter Designation no.3 : ");
		String de3 = sc.next();
		try (sc)
		{
			List<EmployeeJBean> list = controller.showAllEmployessByDesgs(de1, de2, de3);
//			process results
			list.forEach(
					emp ->
					{
						System.out.println(emp);
					}
					);
			
		}
		catch(Exception e) {}
		
//	close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
