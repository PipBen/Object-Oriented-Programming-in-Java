package exam1819;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import exam1.MPData;

public class Image { 
	int imageID;
	double latitude;
	double longitude;
	
	public Image(String line) {
		Scanner s= new Scanner(line);
		s.useDelimiter(" ");
		this.imageID= s.nextInt();
		this.latitude=s.nextDouble();
		this.longitude=s.nextDouble();
		s.close();
	}
	
	public String toString() {
		String image ="{Image ID: "+ Integer.toString(imageID)+", Latitude: "+Double.toString(latitude)+", Longitude: "+Double.toString(longitude)+"}\n";
		return image;
	}

	public int getImageID() {
		return imageID;
	}

}
