package DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import model.Vaga;

public class VagaDAO {

    public void updateStatusVaga(Vaga vaga) throws Exception {

        String SQL = "UPDATE public.\"vagas-point\" SET status = ? WHERE gid = ?";

        Connection conn = ConnectionFactory.createConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setBoolean(1, vaga.getStatus());
            pstmt.setInt(2, vaga.getId());
            pstmt.executeUpdate();
            // ConnectionFactory.closeConnection(conn, pstmt);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
