package Dao;


import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	
	public Usuario encontreLoginESenha(String login, String senha) throws SQLException{
        Usuario usuario = null;
        String sql="SELECT id,Nome,Login,Senha,Email from usuario where login=? and senha=?";
        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            try(ResultSet rs=stmt.executeQuery()){
            	if(rs.next()) {
            		usuario = new Usuario();
            		usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setEmail(rs.getString("email"));
            	}
            }
	}
        return usuario;
	}
        
        public boolean insert (Usuario usuario) throws SQLException{
            String sql ="INSERT INTO usuario(nome,login,senha,email)VALUES(?,?,?,?)";
            try(Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1,usuario.getNome());
                stmt.setString(2,usuario.getLogin());
                stmt.setString(3,usuario.getSenha());
                stmt.setString(4,usuario.getEmail());
                return stmt.executeUpdate()>0;
            }
       }
}
	
	
