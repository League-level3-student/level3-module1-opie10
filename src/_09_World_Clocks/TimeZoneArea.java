package _09_World_Clocks;

import java.util.TimeZone;

import javax.swing.JTextArea;

public class TimeZoneArea {

TimeZone timeZone ;
JTextArea textarea = new JTextArea();
TimeZoneArea(String city,JTextArea area) {
	ClockUtilities clockUtil = new ClockUtilities();
timeZone = clockUtil.getTimeZoneFromCityName(city);
textarea = area;
}
}
