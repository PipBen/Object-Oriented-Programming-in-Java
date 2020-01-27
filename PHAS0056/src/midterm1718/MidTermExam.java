package midterm1718;

public class MidTermExam {
	
	public static void main(String[] args) throws Exception{
		String fileName ="N:\\Eclipse\\N_extent_v3.0.csv";
		MonthStore monthStore = new MonthStore(fileName);
		System.out.println(monthStore.getNumberMonths());
		System.out.println(monthStore.getLowestExtent());
		System.out.println(monthStore.getLowestArea());
		monthStore.scanMonthAreaLows();
		YearStore yearStore = new YearStore(monthStore);
		System.out.println(yearStore.getYears().get(4));
		yearStore.compareYearArea();
	}

}
