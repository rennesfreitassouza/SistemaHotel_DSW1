package src.br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.br.ufscar.dc.dsw.domain.*;

//Essa classe acessa o banco de dados.
//Método getAll retorna uma lista com todos os dados dos hotéis do banco de dados Hoteis.
public class HotelDAO extends GenericDAO{

	public List<Hotel> getAll(){
		List<Hotel> listaHoteis = new ArrayList<>();
		
		String sql = "SELECT * FROM Hotel order by nome";
		
		try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	String cnpj = resultSet.getString("cnpj");
            	String nome = resultSet.getString("nome");
            	String cidade = resultSet.getString("cidade");
            	String email = resultSet.getString("email");
            	String senha = resultSet.getNString("senha");
                Hotel hotel = new Hotel(email, senha, cnpj, nome, cidade);
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
	
	//Classe não está sendo chamanda.
	public List<Hotel> getByNomeCidade(String nomeCidade){
		
		List<Hotel> listaHoteis = new ArrayList<>();
		String sql = "SELECT * from Hotel WHERE cidade = \"" + nomeCidade + "\""; //melhorar
		
		try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	String cnpj = resultSet.getString("cnpj");
            	String nome = resultSet.getString("nome");
            	String cidade = resultSet.getString("cidade");
            	String email = resultSet.getString("email");
            	String senha = resultSet.getNString("senha");
            	Hotel hotel = new Hotel(email, senha, cnpj, nome, cidade);
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
