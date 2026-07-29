package S_beans;
//target (User defined java class as Spring bean)
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("sf")
public class SeasonFinder {

	private LocalDate date ; //HAS-A property Composition
	public SeasonFinder() 
	{
           System.out.println("SeasonFinder :: 0-argument Constructor");
           
	}
	@Autowired
	public void setDate(LocalDate date) 
	{
		System.out.println("SeasonFinder.setDate()");
		this.date = date;
	}
//	business Method
	public String showSeasonName() 
	{
	System.out.println("SeasonFinder.showSeasonName()");
//	get current month of the year
	int month  = date.getMonthValue();
	if(month>=3 && month<=6) {
		return "summer season";
	}
	else if(month >= 7 && month <= 10 ) 
	{
		return "Rainy Season";
	}
	else return "Winter Season";
	}
	
}
