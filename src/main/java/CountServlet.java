import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "CountServlet", urlPatterns= "/count")
public class CountServlet extends HttpServlet {
    static int count =0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
//        out.println("<h1> The count is :" + count++ + ".");


        String reset = req.getParameter("reset");
        if(reset == null){
            out.println("<h1> The count is :" + count++ + ".");
        }else{
            count =0;
            out.println("<h1> The count is :" + count + ".");
        }
    }
    }
