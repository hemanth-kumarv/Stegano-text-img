//Text decoder
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Steg_text_dec {
	public static void main(String []args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedImage img1 = null;
	    File f1 = null;
	    System.out.println("Enter the location of the encoded image.");
	    String imgsrc1 = sc.nextLine();
	    try
	    {
	      f1 = new File(imgsrc1);
	      img1 = ImageIO.read(f1);
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	    
	    int length = 0;
	    String len = "";
	    for(int i = 0; i < 2; i++)
	    {
	    	int p1 = img1.getRGB(i,0);
    		
    		String a1 = ByteConv((p1>>24)&0xff);
            String r1 = ByteConv((p1>>16)&0xff);
            String g1 = ByteConv((p1>>8)&0xff);
            String b1 = ByteConv((p1)&0xff);
            
            len = len + a1.substring(6,8) + r1.substring(6,8) + g1.substring(6,8) + b1.substring(6,8);
	    }
        length = Integer.parseInt(len,2);
	    System.out.println("\nDecoded text is:");
	    
	    for(int i = 2;i <= length+1;i++)
	    {
	    	int p2 = img1.getRGB(i,1);
	    		
	    	String a1 = ByteConv((p2>>24)&0xff);
	        String r1 = ByteConv((p2>>16)&0xff);
	        String g1 = ByteConv((p2>>8)&0xff);
	        String b1 = ByteConv(p2&0xff);
	            
	        String txt = a1.substring(6,8) + r1.substring(6,8) + g1.substring(6,8) + b1.substring(6,8);
	          
	        char ch =(char) Integer.parseInt(txt,2);
	        System.out.print(ch);
	    }
	}
	
	public static String ByteConv(int a)
	  {
		  String h = Integer.toBinaryString(a);
		  while(h.length()!=8)
			  h = "0"+h;
		  return h;
	  }

}
