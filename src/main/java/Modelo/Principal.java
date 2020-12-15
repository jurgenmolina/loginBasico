/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;


public class Principal {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(String nombre, String email, String usuario, String passoword) {
        Usuario usuario1 = new Usuario(nombre, email, usuario, passoword );
        usuarios.add(usuario1);
    }

    public boolean validarUsuario(String usuario, String password) {
        if (!usuarios.isEmpty()) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getUsuario().equals(usuario) && usuarios.get(i).getContrasena().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean usuarioDuplicado(String usuario){
        if(!usuario.isEmpty()){
        for (Usuario user : usuarios){
            if(user.getUsuario().equals(usuario)){
                return true;
            }
        }}
        return false;
    }
    
    public String mostrarInformacion(){
        String dato = "";
        for (Usuario user : usuarios){
            dato += user.toString2();
        }
        return dato;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
    public Usuario buscarUser(String usuario){
        if (!usuarios.isEmpty()) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getUsuario().equals(usuario)) {
                    return usuarios.get(i);
                }
            }
        }
        return null;
    }
    
    public void modificarUsuario(String nombre, String email, String usuario, String contrasena){
        Usuario modificar = buscarUser(usuario);
        if(modificar!=null){
            modificar.setNombre(nombre);
            modificar.setEmail(email);
            modificar.setContrasena(contrasena);
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getUsuario().equals(usuario)) {
                    usuarios.set(i, modificar);
                    return;
                }
            }
        }
    }
    
    public void eliminarUsuario(String usuario){
        Usuario eliminar = buscarUser(usuario);
        if(eliminar!=null){
            
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getUsuario().equals(usuario)) {
                    usuarios.remove(i);
                    
                    return;
                }
            }
        }
    }
}
