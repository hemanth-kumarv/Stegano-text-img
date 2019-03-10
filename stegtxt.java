import java.util.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Stegtxt
 */
@WebServlet(urlPatterns="/Stegtxt")
public class Stegtxt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stegtxt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str=request.getParameter("image");
		String str2=request.getParameter("text");
		BufferedImage img = null;
	    File f1 = null;
	    File f2 = null;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the original file location.");
	    String imgsrc = str;
	    System.out.println("Enter the text to be hidden.");
	    String text = str2;

	    try
	    {
	      f1 = new File(imgsrc);
	      img = ImageIO.read(f1);
	    }
	    catch(IOException e)
	    {
	      System.out.println(e);
	    }

	    int width = img.getWidth();
	    int length = text.length();
	    String lenstr = Integer.toBinaryString(length);
	    int len2 = lenstr.length();
	    while(len2 != 16)
	    {
	    		len2++;
	    		lenstr = 0+lenstr;
	    }
	    
	    if(len2 >= width)
	    	System.out.println("String is long");
	    else {
	    for(int x = 0; x < 2; x++)
	    {
	    	int p = img.getRGB(x,0);
	    	
	    	String a = ByteConv((p>>24)&0xff);
	        String r = ByteConv((p>>16)&0xff);
	        String g = ByteConv((p>>8)&0xff);
	        String b = ByteConv(p&0xff);
	        
	        String a2 = a.substring(0,6) + lenstr.substring(0+(8*x),2+(8*x));
	        String r2 = r.substring(0,6) + lenstr.substring(2+(8*x),4+(8*x));
	        String g2 = g.substring(0,6) + lenstr.substring(4+(8*x),6+(8*x));
	        String b2 = b.substring(0,6) + lenstr.substring(6+(8*x),8+(8*x));
	        
	        int r3 = Integer.parseInt(r2,2);
	        int g3 = Integer.parseInt(g2,2);
	        int b3 = Integer.parseInt(b2,2);
	        int a3 = Integer.parseInt(a2,2);

	        int p1 = (a3<<24) | (r3<<16) | (g3<<8) | b3;
			img.setRGB(x, 0, p1);
	    }
	    
	    int i = 0;
	      for(int x = 2; x < length+2; x++)
	      {
	        int p = img.getRGB(x,1);

	        String a1 = ByteConv((p>>24)&0xff);
	        String r1 = ByteConv((p>>16)&0xff);
	        String g1 = ByteConv((p>>8)&0xff);
	        String b1 = ByteConv(p&0xff);
	        
	        String asciitext = ByteConv((int)text.charAt(i++));
	        
	        String r2 = r1.substring(0,6) + asciitext.substring(2,4);
	        String g2 = g1.substring(0,6) + asciitext.substring(4,6);
	        String b2 = b1.substring(0,6) + asciitext.substring(6,8);
	        String a2 = a1.substring(0,6) + asciitext.substring(0,2);
	        
	        int r = Integer.parseInt(r2,2);
	        int g = Integer.parseInt(g2,2);
	        int b = Integer.parseInt(b2,2);
	        int a = Integer.parseInt(a2,2);

	        int p3 = (a<<24) | (r<<16) | (g<<8) | b;
			img.setRGB(x, 1, p3);
	      }

	    try
	    {
	      f2 = new File("D:\\File\\encimg.png");
	      ImageIO.write(img, "png", f2);
	      PrintWriter out = response.getWriter();
	      out.print("Picture encoded successfully as encimg.png");
	    }
	    catch(IOException e)
	    {
	      System.out.println(e);
	    }}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	  public static String ByteConv(int a)
	  {
		  String h = Integer.toBinaryString(a);
		  while(h.length()!=8)
			  h = 0 + h;
		  return h;
	  }
	  


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
