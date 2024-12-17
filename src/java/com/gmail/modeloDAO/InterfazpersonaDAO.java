package com.gmail.modeloDAO;

import com.gmail.modelo.Persona;
import java.util.List;


public interface InterfazpersonaDAO {
    public List<Persona>getPersonas();
    public Persona getId(int id);
    public int add(Persona p);
    public int update(Persona p);
    public int delete(int id);
}
