package _09_World_Clocks;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
	ClockUtilities clockUtil;
	Timer timer;
	TimeZone timeZone;
	String timeStri;
	String dateStri;
	TimeZone timeZonee;
	JFrame frame;
	JPanel panel;
	JButton jb;
	JTextArea textArea;

	String city;
	String dateStr;
	String timeStr;
	String citywant;

	public WorldClocks() {
		clockUtil = new ClockUtilities();

		// The format for the city must be: city, country (all caps)
		// city = "Chicago, US";
		String citywant = JOptionPane.showInputDialog(null,
				"Input a city to add the time for ((Format: City, Country)EX: Chicago US):");
		city = citywant;
		timeZone = clockUtil.getTimeZoneFromCityName(city);

		Calendar calendar = Calendar.getInstance(timeZone);
		String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.YEAR);

		System.out.println(dateStr);

		// Sample starter program
		jb = new JButton();
		jb.setText("Add Time");
		jb.setFocusable(false);
		frame = new JFrame();
		panel = new JPanel();
		textArea = new JTextArea();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(100, 100);
		panel.add(jb);
		frame.add(panel);

		jb.addActionListener(this);
		panel.add(textArea);
		textArea.setText(city + "\n" + dateStr);

		// This Timer object is set to call the actionPerformed() method every
		// 1000 milliseconds
		timer = new Timer(1000, this);
		timer.start();
	}

	public void addTime() {
		JTextArea txtArea = new JTextArea();
		String citywant = JOptionPane.showInputDialog(null,
				"Input a city to add the time for ((Format: City, Country)EX: Chicago US):");

		timeZonee = clockUtil.getTimeZoneFromCityName(citywant);

		Calendar calendar = Calendar.getInstance(timeZonee);
		String monthi = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String dayOfWeeki = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		dateStri = dayOfWeeki + " " + monthi + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.YEAR);
		panel.add(txtArea);
		txtArea.setText(citywant + "\n" + dateStri);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb) {
			addTime();
		} else {
			Calendar c = Calendar.getInstance(timeZone);
			String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
					+ c.get(Calendar.SECOND);
			String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
					+ c.get(Calendar.SECOND) + "]";
			timeStr = militaryTime + twelveHourTime;

			System.out.println(timeStr);
			textArea.setText(city + "\n" + dateStr + "\n" + timeStr);
			frame.pack();

			Calendar ci = Calendar.getInstance(timeZone);
			String militaryTimei = ci.get(Calendar.HOUR_OF_DAY) + ":" + ci.get(Calendar.MINUTE) + ":"
					+ ci.get(Calendar.SECOND);
			String twelveHourTimei = " [" + ci.get(Calendar.HOUR) + ":" + ci.get(Calendar.MINUTE) + ":"
					+ ci.get(Calendar.SECOND) + "]";
			timeStri = militaryTimei + twelveHourTimei;

			System.out.println(timeStri);
			textArea.setText(citywant + "\n" + dateStri + "\n" + timeStri);
			frame.pack();
		}

	}

}
