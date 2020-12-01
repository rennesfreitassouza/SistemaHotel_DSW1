package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.SiteReserva;

public class SiteReservaDAO extends GenericDAO {
	
	public void insert(SiteReserva sitereserva) {

        String sql = "INSERT INTO SiteReserva (url, nome, telefone, email, senha) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, sitereserva.getUrl());
            statement.setString(2, sitereserva.getNome());
            statement.setString(3, sitereserva.getTelefone());
            statement.setString(4, sitereserva.getEmail());
            statement.setString(5, sitereserva.getSenha());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SiteReserva> getAll() {

        List<SiteReserva> listaSiteReserva = new ArrayList<>();

        String sql = "SELECT * from SiteReserva";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                SiteReserva siteReserva = new SiteReserva(id, url, nome, telefone, email, senha);
                listaSiteReserva.add(siteReserva);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSiteReserva;
    }
    
    public void delete(SiteReserva sitereserva) {
        String sql = "DELETE FROM SiteReserva where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, sitereserva.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(SiteReserva sitereserva) {
        String sql = "UPDATE SiteReserva SET url = ?, nome = ?, telefone = ?, email = ?, senha = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, sitereserva.getUrl());
            statement.setString(2, sitereserva.getNome());
            statement.setString(3, sitereserva.getTelefone());
            statement.setString(4, sitereserva.getEmail());
            statement.setString(5, sitereserva.getSenha());
            statement.setLong(6, sitereserva.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SiteReserva get(Long id) {
    	SiteReserva siteReserva = null;
        
        String sql = "SELECT * from SiteReserva where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                siteReserva = new SiteReserva(id, url, nome, telefone, email, senha);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return siteReserva;
    }
    
    public SiteReserva getbyLogin(String email) {
    	SiteReserva siteReserva = null;

        String sql = "SELECT * from SiteReserva WHERE email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = resultSet.getLong("id");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");
                siteReserva = new SiteReserva(id, url, nome, telefone, email, senha);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return siteReserva;
    }
}
