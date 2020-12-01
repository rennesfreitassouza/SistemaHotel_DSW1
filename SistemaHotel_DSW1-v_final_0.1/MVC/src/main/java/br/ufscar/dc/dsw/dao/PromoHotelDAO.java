package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.domain.PromoHotel;

public class PromoHotelDAO extends GenericDAO {

    public void insert(PromoHotel promohotel) {

        String sql = "INSERT INTO PromoHotel (preco, iniciopromo, fimpromo, Hotel_id, SiteReserva_id) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setFloat(1, promohotel.getPreco());
            statement.setString(2, promohotel.getIniciopromo());
            statement.setString(3, promohotel.getFimpromo());
            statement.setLong(4, promohotel.getHotel().getId());
            statement.setLong(5, promohotel.getSitereserva().getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PromoHotel> getAll() {

        List<PromoHotel> listapromohotel = new ArrayList<>();

        String sql = "SELECT * FROM PromoHotel p, Hotel h, SiteReserva s WHERE p.Hotel_id = h.id AND p.Sitereserva_id = s.id";
        //SELECT * from PromoHotel p, Hotel h where p.Hotel_id = h.id order by p.id"

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                float preco = resultSet.getFloat("preco");
                String iniciopromo = resultSet.getString("iniciopromo");
                String fimpromo = resultSet.getString("fimpromo");
                Long hotel_id = resultSet.getLong(5);
                String cnpj = resultSet.getString("cnpj");
                Long sitereserva_id = resultSet.getLong(6);
                String url = resultSet.getString("url");

                Hotel hotel = new Hotel(hotel_id, cnpj);
                SiteReserva sitereserva = new SiteReserva(sitereserva_id, url);
                PromoHotel promohotel = new PromoHotel(id, preco, iniciopromo, fimpromo, hotel, sitereserva);
                listapromohotel.add(promohotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listapromohotel;
    }
    
    public List<PromoHotel> getPromohotel(Long hotel_id) {

        List<PromoHotel> listapromohotel = new ArrayList<>();

        String sql = "SELECT * FROM PromoHotel p, Hotel h, SiteReserva s WHERE p.Hotel_id = ? AND p.Sitereserva_id = s.id";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, hotel_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                float preco = resultSet.getFloat("preco");
                String iniciopromo = resultSet.getString("iniciopromo");
                String fimpromo = resultSet.getString("fimpromo");;
                String cnpj = resultSet.getString("cnpj");
                Long sitereserva_id = resultSet.getLong(6);
                String url = resultSet.getString("url");

                Hotel hotel = new Hotel(hotel_id, cnpj);
                SiteReserva sitereserva = new SiteReserva(sitereserva_id, url);
                PromoHotel promohotel = new PromoHotel(id, preco, iniciopromo, fimpromo, hotel, sitereserva);
                listapromohotel.add(promohotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listapromohotel;
    }
    
    public List<PromoHotel> getPromoSite(Long sitereserva_id) {    	

        List<PromoHotel> listapromohotel = new ArrayList<>();

        String sql = "SELECT * FROM PromoHotel p, Hotel h, SiteReserva s WHERE p.Hotel_id = h.id AND p.Sitereserva_id = ?";
        //SELECT * from PromoHotel p, Hotel h where p.Hotel_id = h.id order by p.id"

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, sitereserva_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                float preco = resultSet.getFloat("preco");
                String iniciopromo = resultSet.getString("iniciopromo");
                String fimpromo = resultSet.getString("fimpromo");
                Long hotel_id = resultSet.getLong(5);
                String cnpj = resultSet.getString("cnpj");
                String url = resultSet.getString("url");

                Hotel hotel = new Hotel(hotel_id, cnpj);
                SiteReserva sitereserva = new SiteReserva(sitereserva_id, url);
                PromoHotel promohotel = new PromoHotel(id, preco, iniciopromo, fimpromo, hotel, sitereserva);
                listapromohotel.add(promohotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listapromohotel;
    }

    public void delete(PromoHotel promohotel) {
        String sql = "DELETE FROM PromoHotel where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, promohotel.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(PromoHotel promohotel) {
        String sql = "UPDATE PromoHotel SET preco = ?, iniciopromo = ?, fimpromo = ?";
        sql += ", Hotel_id = ?, Sitereserva_id = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setFloat(1, promohotel.getPreco());
            statement.setString(2, promohotel.getIniciopromo());
            statement.setString(3, promohotel.getFimpromo());
            
            statement.setFloat(5, promohotel.getHotel().getId());
            statement.setFloat(6, promohotel.getSitereserva().getId());
            statement.setLong(7, promohotel.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PromoHotel get(Long id) {
        PromoHotel promohotel = null;

        String sql = "SELECT * from PromoHotel p, Hotel h, SiteReserva s WHERE p.id = ? and p.Hotel_id = h.id and p.Sitereserva_id = s.id";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                float preco = resultSet.getFloat("preco");
                String iniciopromo = resultSet.getString("iniciopromo");
                String fimpromo = resultSet.getString("fimpromo");

                Long hotelID = resultSet.getLong("Hotel_id");
                Hotel hotel = new HotelDAO().get(hotelID);
                
                Long SitereservaID = resultSet.getLong("SiteReserva_id");
                SiteReserva sitereserva = new SiteReservaDAO().get(SitereservaID);
                promohotel = new PromoHotel(id, preco, iniciopromo, fimpromo, hotel, sitereserva);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promohotel;
    }

    public int countByHotel(Long id) {
        int contador = 0;
        
        String sql = "SELECT count(*) from PromoHotel p where p.Hotel_id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                contador = resultSet.getInt(1);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contador;
    }
    
    public int countBySiteReserva(Long id) {
        int contador = 0;
        
        String sql = "SELECT count(*) from PromoHotel p where p.Sitereserva_id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                contador = resultSet.getInt(1);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contador;
    }
}
