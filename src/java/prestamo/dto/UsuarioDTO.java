/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo.dto;

/**
 *
 * @author UPEU
 */
public class UsuarioDTO {
   private int per_usu_id;
   private int rol_id;
   private String usu_user;
   private String usu_pass;


    public UsuarioDTO() {
    }

    public UsuarioDTO(int rol_id, String usu_user, String usu_pass) {
        this.rol_id = rol_id;
        this.usu_user = usu_user;
        this.usu_pass = usu_pass;
    }

    public int getPer_usu_id() {
        return per_usu_id;
    }

    public void setPer_usu_id(int per_usu_id) {
        this.per_usu_id = per_usu_id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getUsu_user() {
        return usu_user;
    }

    public void setUsu_user(String usu_user) {
        this.usu_user = usu_user;
    }

    public String getUsu_pass() {
        return usu_pass;
    }

    public void setUsu_pass(String usu_pass) {
        this.usu_pass = usu_pass;
    }

   
}
