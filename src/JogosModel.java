import java.sql.*;
import java.util.*;

public class JogosModel
{
	static void create(Jogo jogo, Connection connection) throws SQLException
	{
		PreparedStatement statement;

		statement = connection.prepareStatement("INSERT INTO jogos (desenvolvedor, titulo, descricao, preco, desconto, nota, ano) VALUES (?, ?, ?, ?, ?, ?, ?)");
		statement.setInt(1, jogo.getDesenvolvedor());
		statement.setString(2, jogo.getTitulo());
        statement.setString(3,jogo.getDescricao());
        statement.setFloat(4, jogo.getPreco());
        statement.setFloat(5,jogo.getDesconto());
        statement.setFloat(6,jogo.getNota());
        statement.setInt(7,jogo.getAno());
		statement.execute();
		statement.close();
	}

	static HashSet listAll(Connection connection) throws SQLException
	{
		Statement statement;
		HashSet jogos = new HashSet();

		statement = connection.createStatement();
		String sql = "SELECT id, desenvolvedor, titulo, descricao, preco, desconto, nota, ano FROM jogos";
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			jogos.add(new Jogo(result.getInt(1), result.getInt(2), result.getString(3), 
            result.getString(4), result.getFloat(5), result.getFloat(6), result.getFloat(7), 
            result.getInt(8)));
		}

		return jogos;
	}

}