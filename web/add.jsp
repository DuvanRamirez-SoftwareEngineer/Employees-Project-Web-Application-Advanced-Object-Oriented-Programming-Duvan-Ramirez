<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
        <title>IU Digital</title>
    </head>
    <body>
        
        <div class="container mt-4">
            <form action="Controlador" method="POST">
                <div class="card border-info mb-3" style="max-width: 18rem;">
                    <div class="card-header">AGREGAR PERSONA</div>
                    <div class="card-body text-info">                    
                        <div class="form-group">
                            <label>NOMBRES</label>
                            <input type="text" name="txtNombres" class="form-control">                        
                        </div>
                        <div class="form-group">
                            <label>APELLIDOS</label>
                            <input type="text" name="txtApellidos" class="form-control">                        
                        </div>
                        <div class="form-group">
                            <label>CORREO</label>
                            <input type="email" name="txtCorreo" class="form-control">                        
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" value="Agregar" name="accion" class="btn btn-outline-success">
                        <a href="Controlador?accion=listar" class="btn-link ml-2">Volver</a>
                    </div>
                </div>                 
            </form>
             
        </div>
        
    </body>
</html>
