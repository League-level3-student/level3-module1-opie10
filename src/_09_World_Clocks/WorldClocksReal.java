package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class WorldClocksReal implements ActionListener{
	HashMap <String, TimeZoneArea> cityhash = new HashMap<>();
	ClockUtilities clockUtil;
	Timer timer;
	TimeZone timeZone;
	JFrame frame;
	JPanel panel;
	JButton jb;
	JTextArea textArea;
	String city;
	String dateStr;
	String timeStr;
public void WorldClocksReal() {
	
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
	timer = new Timer(1000, this);
	timer.start();
}
public void addTime() {
	String city = JOptionPane.showInputDialog(null,"Input a city to add the time for ((Format: City, Country)EX: Chicago US):");
	JTextArea textare = new JTextArea();
	TimeZoneArea t = new TimeZoneArea(city,textare);
	
	
	panel.add(textare);
	cityhash.put(city, t);


	panel.add(textare);
	frame.pack();
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if (arg0.getSource()==jb) {
		addTime();
	}
	else {
		for (String eachCity : cityhash.keySet()) {
			
		TimeZoneArea tz=	cityhash.get(eachCity);
		Calendar calendar = Calendar.getInstance(tz.timeZone);
		String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		String dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " "
				+ calendar.get(Calendar.YEAR);
		Calendar c = Calendar.getInstance(tz.timeZone);
		String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
				+ c.get(Calendar.SECOND);
		String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":"
				+ c.get(Calendar.SECOND) + "]";
		String timeStr = militaryTime + twelveHourTime;
		tz.textarea.setText(eachCity+"\n" + dateStr+"\n"+ timeStr);
		frame.pack();
		}
	}
}
}
