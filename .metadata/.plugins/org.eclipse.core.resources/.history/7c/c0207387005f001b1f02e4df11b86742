package studi.co.Base;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class sample {
	public static void main(String[] args) throws IOException {

		FileInputStream in = new FileInputStream("C:\\Users\\Dell\\Desktop\\test.png");
		BufferedInputStream buf = new BufferedInputStream(in);
		byte[] bMapArray = new byte[buf.available()];
		buf.read(bMapArray);

		Bitmap bitmap = BitmapFactory.decodeByteArray(bMapArray, 0, bMapArray.length);
		/*
		 * Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true); final int
		 * color = newBitmap.getPixel(0, 0); newBitmap.recycle();
		 */
		
	//	System.out.println(color);

	}

}
