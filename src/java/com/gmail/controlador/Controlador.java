package com.gmail.controlador;
import com.gmail.modelo.Persona;
import com.gmail.modeloDAO.PersonaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {

    PersonaDAO dAO;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        List<Persona>personas=new ArrayList<>();
        switch (accion){
            case "listar":
                dAO=new PersonaDAO();
                personas=dAO.getPersonas();
                request.setAttribute("Personas", personas);
                request.getRequestDispatcher("index.jsp").forward(request, response);                    
                break;
            case "nuevo":
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            case "Agregar":
                int r=0;
                String nombres=request.getParameter("txtNombres");
                String apellidos=request.getParameter("txtApellidos");
                String correo=request.getParameter("txtCorreo");
                Persona p=new Persona();
                p.setNombres(nombres);
                p.setApellidos(apellidos);
                p.setCorreo(correo);
                r=dAO.add(p);
                if(r!=0) {
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "SE AGREGÓ CON EXITO!");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "ERROR AL GUARDAR EL REGISTRO EN BASE DE DATOS");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
            case "Editar":
                int id=Integer.valueOf(request.getParameter("id"));
                Persona persona=dAO.getId(id);
                request.setAttribute("persona", persona);
                request.getRequestDispatcher("editar.jsp").forward(request, response);                
                break;
            case "Actualizar":
                String nombres1 = request.getParameter("txtNombres");
                String apellidos1 = request.getParameter("txtApellidos");
                String correo1 = request.getParameter("txtCorreo");
                int idPersona = Integer.valueOf(request.getParameter("txtId"));
                Persona per= new Persona(idPersona, nombres1, apellidos1, correo1);
                int respuesta = dAO.update(per);
                if(respuesta !=0) {
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "SE ACTUALIZÓ CON EXITO!");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "ERROR AL ACTUALIZAR EL REGISTRO EN BASE DE DATOS");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
            case "Delete":
                int idperso = Integer.valueOf(request.getParameter("id"));
                int res = dAO.delete(idperso);
                if(res !=0) {
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "SE HA ELIMINADO EL REGISTRO DE LA BASE DE DATOS");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "ERROR AL ELIMINAR EL REGISTRO DE LA BASE DE DATOS");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
                
            default:
                throw new AssertionError();              
              
          }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
