//Encoding image
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Steg
{
  public static void main(String args[])throws IOException
  {
    BufferedImage img1 = null;
    BufferedImage img2 = null;
    File f1 = null;
    File f2 = null;
    File f3 = null;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the original file location.");
    String imgsrc1 = sc.next();
    System.out.println("Enter the location of the file to be hidden.");
    String imgsrc2 = sc.next();

    try
    {
      f1 = new File(imgsrc1);
      img1 = ImageIO.read(f1);
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
    
    try
    {
    	f2 = new File(imgsrc2);
    	img2 = ImageIO.read(f2);
    }
    catch(IOException e)
    {
    	System.out.println(e);
    }

    int width = img1.getWidth();
    int height = img1.getHeight();

    for(int y = 0; y < height; y++)
    {
      for(int x = 0; x < width; x++)
      {
        int p1 = img1.getRGB(x,y);
        int p2 = img2.getRGB(x,y);

        String a1 = ByteConv((p1>>24)&0xff);
        String r1 = ByteConv((p1>>16)&0xff);
        String g1 = ByteConv((p1>>8)&0xff);
        String b1 = ByteConv(p1&0xff);

        String a2 = ByteConv((p2>>24)&0xff);
        String r2 = ByteConv((p2>>16)&0xff);
        String g2 = ByteConv((p2>>8)&0xff);
        String b2 = ByteConv(p2&0xff); 
        
        String r3 = r1.substring(0,4) + r2.substring(0,4);
        String g3 = g1.substring(0,4) + g2.substring(0,4);
        String b3 = b1.substring(0,4) + b2.substring(0,4);
        String a3 = a1.substring(0,4) + a2.substring(0,4);
        
        int r = Integer.parseInt(r3,2);
        int g = Integer.parseInt(g3,2);
        int b = Integer.parseInt(b3,2);
        int a = Integer.parseInt(a3,2);

        int p3 = (a<<24) | (r<<16) | (g<<8) | b;
		img1.setRGB(x, y, p3);
      }
    }

    try
    {
      f3 = new File("C:\\File\\newone.png");
      ImageIO.write(img1, "png", f3);
      System.out.println("Picture encoded successfully.");
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
  
  public static String ByteConv(int a)
  {
	  String h = Integer.toBinaryString(a);
	  while(h.length()!=8)
		  h = 0+h;
	  return h;
  }
}
