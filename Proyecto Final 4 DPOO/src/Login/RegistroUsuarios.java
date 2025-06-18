package Login;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroUsuarios {
	
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";

    public void guardarUsuario(Usuario usuario) {
    	
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS, true))) {
        	
            writer.write(usuario.getNombre() + "," + usuario.getContrasenia());
            writer.newLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Usuario> cargarUsuarios() {
    	
        ArrayList<Usuario> usuarios = new ArrayList<>();
        File archivo = new File(ARCHIVO_USUARIOS);

        if (archivo.exists()) {
        	try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            	
                String linea;
                
                while ((linea = reader.readLine()) != null) {
                	
                    String[] partes = linea.split(",");
                    
                    if (partes.length == 2) {
                        usuarios.add(new Usuario(partes[0], partes[1]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return usuarios;
    }

    public boolean verificarCredenciales(String nombre, String contrasena) {
    	
        ArrayList<Usuario> usuarios = cargarUsuarios();
        boolean credencialesValidas = false;
        
        int i = 0;
        while(i < usuarios.size() && !credencialesValidas){
        	
        	Usuario u = usuarios.get(i);
            if (u.getNombre().equals(nombre) && u.getContrasenia().equals(contrasena)) {
                credencialesValidas = true;
            }
            
            i++;
        }
        return credencialesValidas;
    }
}