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
public class PrestamoDTO {
    private int prestamoid;
    private int usuarioid;
    private int lectorid;
    private String fechap;
    private String fechad;

    public PrestamoDTO() {
    }

    public PrestamoDTO(int usuarioid, int lectorid, String fechap, String fechad) {
        this.usuarioid = usuarioid;
        this.lectorid = lectorid;
        this.fechap = fechap;
        this.fechad = fechad;
    }

    public PrestamoDTO(int prestamoid, int usuarioid, int lectorid, String fechap, String fechad) {
        this.prestamoid = prestamoid;
        this.usuarioid = usuarioid;
        this.lectorid = lectorid;
        this.fechap = fechap;
        this.fechad = fechad;
    }

    public int getPrestamoid() {
        return prestamoid;
    }

    public void setPrestamoid(int prestamoid) {
        this.prestamoid = prestamoid;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getLectorid() {
        return lectorid;
    }

    public void setLectorid(int lectorid) {
        this.lectorid = lectorid;
    }

    public String getFechap() {
        return fechap;
    }

    public void setFechap(String fechap) {
        this.fechap = fechap;
    }

    public String getFechad() {
        return fechad;
    }

    public void setFechad(String fechad) {
        this.fechad = fechad;
    }
    
    
    
    
}
