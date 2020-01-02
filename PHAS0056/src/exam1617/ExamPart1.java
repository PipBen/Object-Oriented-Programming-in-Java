package exam1617;

public class ExamPart1 {

	public static void main(String[] args) throws Exception{
		IndexStore indexStore = new IndexStore("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");
		Recording recording01=new Recording("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt",indexStore);
		Recording recording02=new Recording("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt",indexStore);
		Recording recording03=new Recording("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt",indexStore);
		Recording recording04=new Recording("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt",indexStore);
		Recording genA = new Recording("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genA.txt",indexStore);
		Recording genB = new Recording("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genB.txt",indexStore);
		Recording genC = new Recording("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genC.txt",indexStore);
		System.out.println(recording01);
		System.out.println(recording02);
		System.out.println(recording03);
		System.out.println(recording04);
		System.out.println(genA);
		System.out.println(genB);
		System.out.println(genC);
		System.out.println(recording01.getNoSamples());
	}

}
