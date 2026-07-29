package S_beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wdf")
public class WeekDayFinder 
{
    @Autowired
    @Qualifier("ldate4")//field injection 
    private LocalDate date; //HAS-A property
    @Autowired
    private LocalTime time;
    
    @Autowired //Constructor injection
    public WeekDayFinder(@Qualifier("ldate2") LocalDate date) 
    {
    	System.out.println("WeekDayFinder :: 1-param constructor");
    }

    
    
//    setter methods for setter injection 
    @Autowired//setter injection
    @Qualifier("ldate1")
	public void setDate(LocalDate date) {
		System.out.println("WeekDayFinder.setDate()(setter method)");
		this.date = date;
	}
	
@Autowired//arbitary method injection
@Qualifier("ldate3")
	public void assignDate(LocalDate date) {
		System.out.println("WeekDayFinder.assignDate()(arbitary method)");
		this.date = date;
	}


public void showInjectedValues() {
    System.out.println("=== Final Injected Values ===");
    System.out.println("Date: " + date);
    System.out.println("Time: " + time);
}

	
    
    
}
