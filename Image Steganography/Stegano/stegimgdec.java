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
 * Servlet implementation class StegImgdec
 */
@WebServlet(urlPatterns="/StegImgdec")
public class StegImgdec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StegImgdec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str2=request.getParameter("decade");
		BufferedImage img1 = null;
	    File f1 = null;
	    File f2 = null;
	    System.out.println("Enter the location of the encoded image.");
	    String imgsrc1 = str2;
	    try
	    {
	      f1 = new File(imgsrc1);
	      img1 = ImageIO.read(f1);
	    }
	    catch(IOException e)
	    {
	      System.out.println(e);
	    }
	    for(int j = 0;j < img1.getHeight();j++)
	    	for(int i = 0;i < img1.getWidth();i++)
	    	{
	    		int p1 = img1.getRGB(i,j);
	    		
	    		String a1 = ByteConv((p1>>24)&0xff);
	            String r1 = ByteConv((p1>>16)&0xff);
	            String g1 = ByteConv((p1>>8)&0xff);
	            String b1 = ByteConv(p1&0xff);
	            
	            String a3 = a1.substring(4,8) + "1111";
	            String r3 = r1.substring(4,8) + "1010";
	            String g3 = g1.substring(4,8) + "1010";
	            String b3 = b1.substring(4,8) + "1010";
	            
	            int r = Integer.parseInt(r3,2);
	            int g = Integer.parseInt(g3,2);
	            int b = Integer.parseInt(b3,2);
	            int a = Integer.parseInt(a3,2);
	            
	            int p3 = (a<<24) | (r<<16) | (g<<8) | b;
	    		img1.setRGB(i, j, p3);
	    	}
	    try
	    {
	      f2 = new File("D:\\File\\decpic.png");
	      ImageIO.write(img1, "png", f2);
	      PrintWriter out = response.getWriter();
	      out.print("Picture decoded successfully as decpic.png");
	    }
	    catch(IOException e)
	    {
	      System.out.println(e);
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
