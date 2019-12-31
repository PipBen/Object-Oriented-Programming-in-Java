package exam1819;

import java.util.ArrayList;

public interface ImageSelector {
	public ArrayList<Image> select(ImageLocationStore images,ClassificationStore classification);
}
