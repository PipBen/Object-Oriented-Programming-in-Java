package midterm1718;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class YearStore {
	
	ArrayList<Year> years= new ArrayList<Year>();
	ArrayList<Integer> yearIntegers= new ArrayList<Integer>();
	ArrayList<Month> fullYear;
	
	public YearStore(MonthStore monthStore) {
		ArrayList<Month> months = monthStore.getMonths();
		for(int i=0;i<months.size();i++) {
			Month month =months.get(i);
			int year=month.getYear();
			if(yearIntegers.contains(year)==false) {
				fullYear = new ArrayList<Month>();
				yearIntegers.add(year);
				for(int n=0; n<months.size();n++) {
					Month yearCheckMonth = months.get(n);
					if (yearCheckMonth.getYear()==year) {
						fullYear.add(yearCheckMonth);
					}
				}
				Year eachYear = new Year(fullYear);
				years.add(eachYear);
				//fullYear.clear();
			}
		}
	}

	/**
	 * @return the years
	 */
	public ArrayList<Year> getYears() {
		return years;
	}

	/**
	 * @return the yearIntegers
	 */
	public ArrayList<Integer> getYearIntegers() {
		return yearIntegers;
	}

	/**
	 * @return the fullYear
	 */
	public ArrayList<Month> getFullYear() {
		return fullYear;
	}

	/**
	 * @param years the years to set
	 */
	public void setYears(ArrayList<Year> years) {
		this.years = years;
	}

	/**
	 * @param yearIntegers the yearIntegers to set
	 */
	public void setYearIntegers(ArrayList<Integer> yearIntegers) {
		this.yearIntegers = yearIntegers;
	}

	/**
	 * @param fullYear the fullYear to set
	 */
	public void setFullYear(ArrayList<Month> fullYear) {
		this.fullYear = fullYear;
	}
	
	public void compareYearArea() {
		//
		for(int n=0;n<years.size();n++) {
			Year year = years.get(n);
			int yearValue= year.getYear();
			if (yearIntegers.contains(yearValue-2)){
				
				for(int i=0;i<years.size();i++) {
					Year previousYear=years.get(i);
					if(previousYear.getYear()==yearValue-1) {
						
						for(int m=0; m<year.getMonths().size();m++) {
							
							Month month = year.getMonths().get(m);
							Month previousYearMonth= previousYear.getMonths().get(m);
							if(month.getArea()!= null& previousYearMonth.getArea()!= null) {
								double changeInArea= month.getArea()-previousYearMonth.getArea();
								String monthName =new DateFormatSymbols().getMonths()[m];
								System.out.println("Area("+monthName+Integer.toString(month.getYear())+") - Area("+monthName+" "+Integer.toString(previousYearMonth.getYear())+ ") = "+ Double.toString(changeInArea));
							}		
						}
					}
				}
			}
		}
	}
	
	public ArrayList<> findLargestIceDrop() {
		
	}
	

}
