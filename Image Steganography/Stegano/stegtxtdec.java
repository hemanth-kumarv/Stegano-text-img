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
 * Servlet implementation class Stegtxtdec
 */
@WebServlet(urlPatterns="/Stegtxtdec")
public class Stegtxtdec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stegtxtdec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str2=request.getParameter("dectxt");
		Scanner sc = new Scanner(System.in);
		BufferedImage img1 = null;
	    File f1 = null;
	    System.out.println("Enter the location of the encoded image.");
	    String imgsrc1 = str2;
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
	        PrintWriter out = response.getWriter();
		      out.print(ch);
	    }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	public static String ByteConv(int a)
	  {
		  String h = Integer.toBinaryString(a);
		  while(h.length()!=8)
			  h = 0+h;
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
