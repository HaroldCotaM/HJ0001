/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo.interfaces;

import java.util.List;


/**
 *
 * @author UPEU
 * @param <Model>
 */
public interface Operaciones<Model> {
    public int create(Model m);
    public int update(Model m);
    public int delete(int key);
    public Model read(int key);
    public List<Model> readAll();
}
