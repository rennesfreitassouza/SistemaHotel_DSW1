package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.ufscar.dc.dsw.domain.Hotel;

public class HotelDAO extends GenericDAO {
	
	public void insert(Hotel hotel) {

        String sql = "INSERT INTO Hotel (cnpj, nome, cidade, email, senha) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, hotel.getCnpj());
            statement.setString(2, hotel.getNome());
            statement.setString(3, hotel.getCidade());
            statement.setString(4, hotel.getEmail());
            statement.setString(5, hotel.getSenha());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hotel> getAll() {

        List<Hotel> listaHotel = new ArrayList<>();

        String sql = "SELECT * FROM Hotel ORDER BY nome";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Hotel hotel = new Hotel(id, cnpj, nome, cidade, email, senha);
                listaHotel.add(hotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHotel;
    }
    
    public void delete(Hotel hotel) {
        String sql = "DELETE FROM Hotel where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, hotel.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Hotel hotel) {
        String sql = "UPDATE Hotel SET cnpj = ?, nome = ?, cidade = ?, email = ?, senha = ? where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, hotel.getCnpj());
            statement.setString(2, hotel.getNome());
            statement.setString(3, hotel.getCidade());
            statement.setString(4, hotel.getEmail());
            statement.setString(5, hotel.getSenha());
            statement.setLong(6, hotel.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Hotel get(Long id) {
        Hotel hotel = null;
        
        String sql = "SELECT * FROM Hotel where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                hotel = new Hotel(id, cnpj, nome, cidade, email, senha);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotel;
    }
    
    public Hotel getbyLogin(String email) {
    	Hotel hotel = null;

        String sql = "SELECT * from Hotel WHERE email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String senha = resultSet.getString("senha");
                hotel = new Hotel(id, cnpj, nome, cidade, email, senha);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotel;
    }

	public List<Hotel> getByNomeCidade(String nomeCidade){
		
		List<Hotel> listaHoteis = new ArrayList<>();
		String sql = "SELECT * from Hotel WHERE cidade = \"" + nomeCidade + "\""; //melhorar
		
		try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Hotel hotel = new Hotel(id, cnpj, nome, cidade, email, senha);
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

    public Hotel getByNome(String nomeHotel) {
        Hotel hotel = null;

        String sql = "SELECT * from Hotel WHERE nome = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nomeHotel);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String email = resultSet.getString("email");
                String cidade = resultSet.getString("cidade");
                String senha = resultSet.getString("senha");
                hotel = new Hotel(id, cnpj, nomeHotel, cidade, email, senha);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotel;
    }
}
