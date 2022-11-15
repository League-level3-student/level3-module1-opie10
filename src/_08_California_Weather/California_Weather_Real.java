package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class California_Weather_Real implements ActionListener {
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JButton jb1 = new JButton();
	JButton jb2 = new JButton();

void run() {
	
		jp.add(jb1);
		jp.add(jb2);
		jf.add(jp);
		jf.setVisible(true);
		jf.setSize(200, 100);
		jb1.setText("Search by City");
		jb2.setText("Search by Temperature");
		jf.setTitle("Search Menu");
		jb1.setFocusable(false);
		jb2.setFocusable(false);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()== jb1) {
	    HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
		String CityName =JOptionPane.showInputDialog("Input a city in California to see its current temperature");
		WeatherData datum = weatherData.get(CityName);
		 if( datum == null ) {
	            System.out.println("Unable to find weather data for: " + CityName);
	        } else {
	            System.out.println(CityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
	        }
	}
	if (e.getSource()== jb2) {
		  HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
			String TempSearchstr=JOptionPane.showInputDialog("Input a temperature to see what cities are currently at the specified temperature.");
	Double TempSearch =Double.parseDouble(TempSearchstr);
	  ArrayList<String> citiesatt = new ArrayList<String>();
	  if (weatherData.containsValue(TempSearch)) {
		
	}
	
	
	
	}
}
}

