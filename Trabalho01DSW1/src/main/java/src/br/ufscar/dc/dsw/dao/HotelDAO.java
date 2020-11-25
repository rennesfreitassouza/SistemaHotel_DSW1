package src.br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.br.ufscar.dc.dsw.domain.*;

public class HotelDAO extends GenericDAO{

	public List<Hotel> getAll(){
		List<Hotel> listaHoteis = new ArrayList<>();
		
		String sql = "SELECT * from Hotel order by nomeHotel";
		try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	String e_mail = resultSet.getString("e_mail");
            	String senha = resultSet.getString("senha");
            	String CNPJ = resultSet.getString("CNPJ");
            	String nomeHotel = resultSet.getString("nomeHotel");
            	String cidade = resultSet.getString("cidade");
                Hotel hotel = new Hotel(e_mail, senha, CNPJ, nomeHotel, cidade);
                listaHoteis.add(hotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		return listaHoteis;
	}
}
