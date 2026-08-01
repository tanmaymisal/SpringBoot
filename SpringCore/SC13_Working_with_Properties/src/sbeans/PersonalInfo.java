package com.nit.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component("pinfo")
@PropertySource(value = "com/nit/commons/info.properties")
public class PersonalInfo {
//       injecting the values of properties file to spring bean properties
	@Value("${per.id}")
	private Integer pid ;
	@Value("${per.name}")
	private String pname;
	@Value("${per.addrs}")
	private String addrs;
//	injecting  the direct values to spring bean properties 
	@Value("9898989899")
	private long mobileNo;
	
//	injecting the system property values
	@Value("${os.name}")
	private String os_name;
	@Value("${os.version}")
	private String os_ver;
	
//	injecting environment variable values 
	@Value("${path}")
	private String path_data;

	@Override
	public String toString() {
		return "PersonalInfo [pid=" + pid + ", pname=" + pname + ", addrs=" + addrs + ", mobileNo=" + mobileNo
				+ ", os_name=" + os_name + ", os_ver=" + os_ver + ", path_data=" + path_data + "]";
	}
	@Autowired
	private Environment env;
	public void showData()
	{
		System.out.println("os.name::"+env.getProperty("os.name"));
		System.out.println("per.id key value ::"+env.getProperty("per.id"));
	}
	
}
