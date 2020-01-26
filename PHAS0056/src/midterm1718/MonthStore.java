package midterm1718;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.text.DateFormatSymbols;

public class MonthStore {
	
	public ArrayList<Month> months;
	public Month lowestExtentMonth;
	public Month lowestAreaMonth;
	public Month areaLowMonth;
	
	public MonthStore(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String line = br.readLine();
		this.months= new ArrayList<Month>();
		while(line!=null) {
			Month month= new Month(line);
			months.add(month);
			line=br.readLine();
		}
	}

	/**
	 * @return the months
	 */
	public ArrayList<Month> getMonths() {
		return months;
	}

	/**
	 * @param months the months to set
	 */
	public void setMonths(ArrayList<Month> months) {
		this.months = months;
	}
	
	public int getNumberMonths() {
		return months.size();
	}
	
	public Month getLowestExtent() {
		double lowestExtent =100;
		for(int n=0;n<months.size();n++) {
			Month month = months.get(n);
			if(month.getExtent()!=null) {
				
				double extent = month.getExtent();
				if(extent<lowestExtent) {
					lowestExtentMonth=month;
					lowestExtent = extent;
				}
			}
		}
		return lowestExtentMonth;
	}
	
	public Month getLowestArea() {
		double lowestArea =100;
		for(int n=0;n<months.size();n++) {
			Month month = months.get(n);
			if(month.getArea()!=null) {
				double area = month.getArea();
				if(area<lowestArea) {
					lowestAreaMonth=month;
					lowestArea = area;
				}
			}
		}
		return lowestAreaMonth;
	}

	@Override
	public String toString() {
		return "MonthStore [months=" + months + "]";
	}
	
	public Month getMonthlyAreaLow(int monthCode) {
		double monthlyAreaLow=100;
		
		for(int n=0; n<months.size();n++) {
			Month month = months.get(n);
			if(month.getMonth()==(monthCode)) {
				if(month.getArea()!=null) {
					double monthArea=month.getArea();
					if(monthArea<monthlyAreaLow) {
						areaLowMonth=month;
						monthlyAreaLow=month.getArea();
					}
				}
			}
		}
		return areaLowMonth;
	}
	
	public void scanMonthAreaLows(){
		for(int n=1; n<13; n++) {
			Month lowestArea= getMonthlyAreaLow(n);
			String monthName =new DateFormatSymbols().getMonths()[n-1];
			System.out.println(monthName+ lowestArea);
		}
	}

}
