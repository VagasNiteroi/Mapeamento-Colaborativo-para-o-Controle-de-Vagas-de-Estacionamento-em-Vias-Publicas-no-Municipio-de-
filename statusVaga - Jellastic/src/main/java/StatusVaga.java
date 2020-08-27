import DAO.VagaDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vaga;

public class StatusVaga {

    public StatusVaga() {
        // Do nothing
    }

    public void changeStatusVaga(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String gidString = request.getParameter("id");
        String statusString = request.getParameter("status");

        int gid = Integer.parseInt(gidString);
        boolean status = Boolean.parseBoolean(statusString);

        Vaga vaga = new Vaga(gid, status);
        VagaDAO dao = new VagaDAO();

        try {
            dao.updateStatusVaga(vaga);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
