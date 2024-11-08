package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    Connection conexion;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public UsuarioDAO() {
        conexion = new Conexion().getConection();
    }

    public Usuario getUsuarioById(int id) {
        var usuario = new Usuario();
        try {
            query = "SELECT * FROM usuarios where id=?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario.setId(resultSet.getInt(1));
                usuario.setUsuario(resultSet.getString(2));
                usuario.setContrasena(resultSet.getString(3));
                usuario.setNombre(resultSet.getString(4));
                usuario.setApellidoPaterno(resultSet.getString(5));
                usuario.setApellidoMaterno(resultSet.getString(6));
                usuario.setEstado(resultSet.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuario;
    }

    public int registrar(Usuario usuario) {
        try {
            query = "SELECT usuario FROM usuarios where usuario=?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, usuario.getUsuario());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return 2;
            }
            query = "INSERT INTO usuarios ("
                    + "nombre, apellido_paterno, apellido_materno, usuario, contrasena)"
                    + " VALUES (?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellidoPaterno());
            preparedStatement.setString(3, usuario.getApellidoMaterno());
            preparedStatement.setString(4, usuario.getUsuario());
            preparedStatement.setString(5, usuario.getContrasena());
            var numRegistrosAfectados = preparedStatement.executeUpdate();

            if (numRegistrosAfectados > 0) {
                return 1;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return 0;

    }

}
