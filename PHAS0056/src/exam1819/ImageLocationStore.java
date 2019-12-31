package exam1819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ImageLocationStore {
ArrayList<Image> images;	
	//unpack image/location data from url and store in an ImageLocationStore array
	public ImageLocationStore(String urlName) throws IOException{
		
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		this.images =new ArrayList<Image>();
		String line=br.readLine();
		while (line!= null) {
			
			Image image = new Image(line);
			images.add(image);
			line = br.readLine();
			
		}
	}
	
	public String toString() {
		return images.toString();
	}
	
	public int noImages() {
		return images.size();
	}
	
	public Image getIndex(int n) {
		return images.get(n);
	}

}
