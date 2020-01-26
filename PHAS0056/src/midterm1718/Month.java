package midterm1718;

import java.util.Scanner;

public class Month {
	
	int year;
	int month;
	String dataType;
	String region;
	Double extent;
	Double area;
	
	public Month(String line) {
		Scanner s = new Scanner(line).useDelimiter(",\\s*");
		this.year=s.nextInt();
		this.month=s.nextInt();
		String dataType=s.next();
		if (dataType.equals(Double.toString(-9999))){
			this.dataType=null;
		}
		else {
			this.dataType=dataType;
		}
		this.region=s.next();
		Double extent=s.nextDouble();
		if(extent.equals(-9999.0)) {
			this.extent=null;
		}
		else {
			this.extent=extent;
		}
		
		Double area=s.nextDouble();
		if(area.equals(-9999.0)) {
			this.area=null;
		}
		else {
			this.area=area;
		}
		
		s.close();
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public String getDataType() {
		return dataType;
	}

	public Double getExtent() {
		return extent;
	}

	public Double getArea() {
		return area;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public void setExtent(Double extent) {
		this.extent = extent;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Month [year=" + year + ", month=" + month + ", dataType=" + dataType + ", region=" + region
				+ ", extent=" + extent + ", area=" + area + "]";
	}
	
	

}
