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
public class PersonaDTO {
    private int per_id;
    private int per_nombres;
    private int per_apellidos;
    private int per_dni;

    public PersonaDTO() {
    }

    public PersonaDTO(int per_nombres, int per_apellidos, int per_dni) {
        this.per_nombres = per_nombres;
        this.per_apellidos = per_apellidos;
        this.per_dni = per_dni;
    }

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public int getPer_nombres() {
        return per_nombres;
    }

    public void setPer_nombres(int per_nombres) {
        this.per_nombres = per_nombres;
    }

    public int getPer_apellidos() {
        return per_apellidos;
    }

    public void setPer_apellidos(int per_apellidos) {
        this.per_apellidos = per_apellidos;
    }

    public int getPer_dni() {
        return per_dni;
    }

    public void setPer_dni(int per_dni) {
        this.per_dni = per_dni;
    }
    
    
}
