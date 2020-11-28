package src.br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.br.ufscar.dc.dsw.domain.Cidade;

//Método getAll retorna uma lista com todas as cidades inseridas no banco de dados Hoteis.
public class CidadeDAO extends GenericDAO{

	public List<Cidade> getAll(){
		List<Cidade> listaCidades = new ArrayList<>();
		
		
		String sql = "SELECT * from Hotel order by cidade";; //melhorar
		
		try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	String nomeCidade = resultSet.getString("cidade");
                Cidade cidade = new Cidade(nomeCidade);
                listaCidades.add(cidade);
            }
            
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		return listaCidades;
	}	
	
}
