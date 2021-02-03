
package studi.co.Base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.opencv.imgproc.Imgproc;

class MatchingDemo {
	public void run(String inFile, String templateFile,
  String outFile, int match_method) throws IOException {
  System.out.println("\nRunning Template Matching");
  
  // Mat img = Highgui.imread(inFile); 
  // Mat templ =  Highgui.imread(templateFile);
  
  ru.yandex.qatools.ashot.comparison.ImageDiffer differ = new ru.yandex.qatools.ashot.comparison.ImageDiffer();
  BufferedImage expectedImage1 = ImageIO.read(new File(inFile));
  BufferedImage expectedImage2 = ImageIO.read(new File(templateFile));
  
	//In below line we call the method which compares two images by use of the reference for ImageDiffer class object
	ru.yandex.qatools.ashot.comparison.ImageDiff diff=differ.makeDiff(expectedImage1, expectedImage2);
	
	//ImageIO.write(diff.getMarkedImage(), "PNG", new File(outFile));
	//diff.setDiffImage(ImageIO.read(new File("C:\\Users\\Dell\\eclipse-workspace\\TATA_Studi\\TATA_Studi\\src\\main\\resources\\Radio Button.png")));
	ImageIO.write(diff.getTransparentMarkedImage(), "PNG", new File(outFile));
	
	BufferedImage dif=diff.getDiffImage();
	System.out.println(dif.getColorModel());
  
  System.out.println(inFile); 
	/*
	 * Mat img = Imgcodecs.imread(inFile); Mat templ =
	 * Imgcodecs.imread(templateFile);
	 * 
	 * // / Create the result matrix int result_cols = img.cols() - templ.cols() +1;
	 * int result_rows = img.rows() - templ.rows() + 1; Mat result = new
	 * Mat(result_rows, result_cols, CvType.CV_32FC1);
	 * 
	 * // / Do the Matching and Normalize Imgproc.matchTemplate(img, templ, result,
	 * match_method);
	 * 
	 * Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
	 * 
	 * 
	 * // / Localizing the best match with minMaxLoc MinMaxLocResult mmr =
	 * Core.minMaxLoc(result);
	 * 
	 * Point matchLoc; if (match_method == Imgproc.TM_SQDIFF || match_method ==
	 * Imgproc.TM_SQDIFF_NORMED) { matchLoc = mmr.minLoc;
	 * 
	 * } else { matchLoc = mmr.maxLoc; }
	 * 
	 * // / Show me what you got Imgproc.rectangle(img, matchLoc, new
	 * Point(matchLoc.x + templ.cols(), matchLoc.y + templ.rows()), new Scalar(0,
	 * 255, 0));
	 * 
	 * // Save the visualized detection. System.out.println("Writing "+ outFile);
	 * Imgcodecs.imwrite(outFile, img);
	 */
  }
}

public class TemplateMatching {
	public static void main(String[] args) throws IOException {
		System.loadLibrary("opencv_java451");

		args = new String[] {
				"C:\\Users\\Dell\\Desktop\\lena.png",
				"C:\\Users\\Dell\\Desktop\\Screenshot_1611330595.png", // template
				"C:\\Users\\Dell\\eclipse-workspace\\TATA_Studi\\TATA_Studi\\src\\main\\resources\\logo.png" };
		new MatchingDemo().run(args[0], args[1], args[2], Imgproc.TM_CCOEFF);
		// new MatchingDemo().run(args[0], args[1], args[2], Imgproc.TM_CCORR);
	}
}
