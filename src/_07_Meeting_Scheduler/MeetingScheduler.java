package _07_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

public class MeetingScheduler {
    /*
     * Your task is to code a method to find a meeting time for two people
     * given their schedules.
     * 
     * Code the method below so that it returns a Schedule object that contains
     * all the times during the week that are in BOTH people's schedules. The
     * Schedule class is included in this package.
     * 
     * Example:
     * person1 availability - Monday at 9, Tuesday at 14, and Friday 10
     * person2 availability - Tuesday at 14, Friday 8, and Monday at 9
     * The returned HashMap should contain: Tuesday 14 and Monday 9
     * 
     * The returned Schedule object represents the times both people are
     * available for a meeting.
     * 
     * Time availability is always at the top of the hour, so 9:30 is not valid
     * Time availability always represents 1 hour
     * Assume both schedules are in the same time zones
     */
    public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
    	HashMap<String, ArrayList<Integer>> Schedule = new HashMap<String, ArrayList<Integer>>();
    	if (person1.getSchedule().get("Monday")==person2.getSchedule().get("Monday")) {
    		Schedule.put("Monday", person1.getSchedule().get("Monday"));
	    	}
    	else if (person1.getSchedule().get("Tuesday")==person2.getSchedule().get("Tuesday")) {
    		Schedule.put("Tuesday", person1.getSchedule().get("Tuesday"));
	    	}
    	else if (person1.getSchedule().get("Wednesday")==person2.getSchedule().get("Wednesday")) {
    		Schedule.put("Wednesday", person1.getSchedule().get("Wednesday"));
	    	}
    	else if (person1.getSchedule().get("Thursday")==person2.getSchedule().get("Thursday")) {
    		Schedule.put("Thursday", person1.getSchedule().get("Thursday"));
	    	}
    	else if (person1.getSchedule().get("Friday")==person2.getSchedule().get("Friday")) {
    		Schedule.put("Friday", person1.getSchedule().get("Friday"));
	    	}
    	else if (person1.getSchedule().get("Saturday")==person2.getSchedule().get("Saturday")) {
    		Schedule.put("Saturday", person1.getSchedule().get("Saturday"));
	    	}
    	else if (person1.getSchedule().get("Sunday")==person2.getSchedule().get("Sunday")) {
    		Schedule.put("Sunday", person1.getSchedule().get("Sunday"));
	    	}
        return ;
    }
}
