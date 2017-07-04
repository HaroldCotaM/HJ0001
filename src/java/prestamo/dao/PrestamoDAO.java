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
import prestamo.dto.PrestamoDTO;
import prestamo.interfaces.Operaciones;
import prestamo.util.Conexion;

/**
 *
 * @author UPEU
 */
public class PrestamoDAO implements Operaciones<PrestamoDTO>{

    private Connection cx;
    private PreparedStatement ps;
    private ResultSet rs;
//    private static final String SQL_CREATE = "INSERT INTO PRESTAMOS(IDPRESTAMOS, IDCLIENTES, FECHAP, FECHAD) VALUES(NULL,?,?,?)";
//    private static final String SQL_UPDATE = "UPDATE PRESTAMOS SET IDCLIENTES=?, FECHAP=?, FECHAD=? WHERE IDPRESTAMOS=?";
    private static final String SQL_READALL2 = "SELECT A.PRE_ID, A.PER_USU_ID, A.PER_LEC_ID, A.PRE_FECHA_PRESTAMO,A.PRE_FECHA_DEVOLUCION, C.PER_NOMBRES, C.PER_APELLIDOS, C.PER_DNI FROM PRESTAMO A, LECTOR B, PERSONA C WHERE A.PER_LEC_ID=B.PER_LEC_ID AND B.PER_LEC_ID=C.PER_ID";
//    private static final String SQL_READ = "SELECT * FROM PRESTAMOS WHERE IDPRESTAMOS=?";
//    private static final String SQL_READALL = "SELECT * FROM PRESTAMOS";
//    private static final String SQL_MAX = "SELECT FC_GENERA_FACID FROM DUAL";    
    
    @Override
    public int create(PrestamoDTO m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(PrestamoDTO m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrestamoDTO read(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDTO> readAll() {
//        List<PrestamoDTO> lista = new ArrayList<>();
//        try {
//            cx = Conexion.getConexion();
//            ps = cx.prepareStatement(SQL_READALL);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                PrestamoDTO dTO = new PrestamoDTO();
//                dTO.setIdprestamo(rs.getInt("IDPRESTAMOS"));
//                dTO.setIdcliente(rs.getInt("IDCLIENTES"));
//                dTO.setFecha1(rs.getString("FECHAP"));
//                dTO.setFecha2(rs.getString("FECHAD"));
//                lista.add(dTO);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error:" + e);
//        }
//        return lista;
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   

    public List<Map<String, ?>> readAll2() {
        List<Map<String, ?>> ret = new ArrayList<>();
        Map<String, Object> pres = null;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL_READALL2);
            rs = ps.executeQuery();
            while (rs.next()) {
                pres = new HashMap<>();
                pres.put("idp", rs.getString("PRE_ID"));
                pres.put("idu", rs.getString("PER_USU_ID"));
                pres.put("fecha1", rs.getString("PRE_FECHA_PRESTAMO"));
                pres.put("fecha2", rs.getString("PRE_FECHA_DEVOLUCION"));
                pres.put("nomb", rs.getString("PER_NOMBRES"));
                pres.put("apelli", rs.getString("PER_APELLIDOS"));
                pres.put("dni", rs.getString("PER_DNI"));
                ret.add(pres);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return ret;
    }
    
    
}
