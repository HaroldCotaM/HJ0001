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
public class Lector {
    private int per_lec_id;

    public Lector() {
    }

    public Lector(int per_lec_id) {
        this.per_lec_id = per_lec_id;
    }

    public int getPer_lec_id() {
        return per_lec_id;
    }

    public void setPer_lec_id(int per_lec_id) {
        this.per_lec_id = per_lec_id;
    }
    
    
}
