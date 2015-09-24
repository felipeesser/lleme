package dataset;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEntity extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(request.getSession().getServletContext().getMimeType(request.getPathInfo()));
        PrintWriter writer = response.getWriter();
        System.out.println(request.getParameter("entity"));
        writer.write("Entidade " + request.getParameter("entity"));
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("Error: POST method not implemented.");
    }
}
