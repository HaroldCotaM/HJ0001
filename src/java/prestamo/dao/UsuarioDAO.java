/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import prestamo.dto.UsuarioDTO;
import prestamo.interfaces.Operaciones;
import prestamo.util.Conexion;


/**
 *
 * @author UPEU
 */
public class UsuarioDAO implements Operaciones<UsuarioDTO>{
    private Connection cx;
    private PreparedStatement ps;
    private ResultSet rs;
    private static final String SQL_VALIDA1 = "SELECT * FROM USUARIO WHERE NOM_USER = ? AND CLAVE = ?";
    private static final String SQL_VALIDA2 = "SELECT A.PER_USU_ID, A.ROL_ID, A.USU_USER, A.USU_PASS, B.ROL_NOMBRE, C.PER_NOMBRES, C.PER_APELLIDOS  FROM USUARIO A, ROL B, PERSONA C\n" +
"WHERE A.ROL_ID = B.ROL_ID AND A.PER_USU_ID= C.PER_ID";


    //SELECT u.IDUSUARIO, u.NOM_USER, r.IDROL, r.NOM_ROL  from usuario u, rol r where u.IDROL=r.IDROL;
    public int validarUser(String user, String clave) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_VALIDA1);
            ps.setString(1, user);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while(rs.next()){
                x = 1;
            }
        } catch (SQLException e) {
        }
        return x;
    }
    public Map<String,Object> login(String user, String clave){
        Map<String,Object> users = null;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_VALIDA2);
            ps.setString(1, user);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while(rs.next()){
                users = new HashMap<>();
                users.put("idu", rs.getString("PER_USU_ID"));
                users.put("nombres", rs.getString("PER_NOMBRES"));
                users.put("apellidos", rs.getString("PER_APELLIDOS"));
                users.put("user", rs.getString("USU_USER"));
                users.put("idr", rs.getString("ROL_ID"));
                users.put("rol", rs.getString("ROL_NOMBRE"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return users;
    }
    @Override
    public int create(UsuarioDTO m) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int update(UsuarioDTO m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }

    @Override
    public int delete(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public UsuarioDTO read(int key) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Map<String,?>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
