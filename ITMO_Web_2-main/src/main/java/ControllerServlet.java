import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (isCoordinates(request)){

            getServletContext().getNamedDispatcher("AreaCheckServlet").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean isCoordinates(HttpServletRequest request){
        String x = request.getParameter("coor_x");
        String y = request.getParameter("coor_y");
        String r = request.getParameter("value_R");

        return Optional.ofNullable(x).isPresent() && Optional.ofNullable(y).isPresent()
                && Optional.ofNullable(r).isPresent();
    }
}
