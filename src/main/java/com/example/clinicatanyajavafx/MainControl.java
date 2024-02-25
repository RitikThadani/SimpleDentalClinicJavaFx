package com.example.clinicatanyajavafx;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Clase MainControl que tiene todos los métodos principales,
 */

public class MainControl {

    public static EntityManagerFactory managerFactory =Persistence.createEntityManagerFactory("Persistencia");

    /**
     * Método para insertar usuarios a nuestra base de datos.
     * @param usuario
     */

    public static void insertUsuario(Usuario usuario){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Método para buscar en la base de datos un usuario igual al dado.
     * Se devolverá true si se encuentra 1 o más.
     * @param user
     * @return
     */

    public static boolean usuarioRepetido(String user){
        EntityManager manager = managerFactory.createEntityManager() ;
        TypedQuery<Long> query = manager.createQuery(
                "SELECT COUNT(u) FROM Usuario u WHERE u.userName = :userName", Long.class);
        query.setParameter("userName", user);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    public static boolean dniRepetido(String dni){
        EntityManager manager = managerFactory.createEntityManager() ;
        TypedQuery<Long> query = manager.createQuery(
                "SELECT COUNT(u) FROM Usuario u WHERE u.dni = :dni", Long.class);
        query.setParameter("dni", dni);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    /**
     * Método para buscar en la base de datos un usuario igual al dado, y con la misma contraseña a la dada.
     * Se devolverá true si se encuentra 1 o más.
     * @param user
     * @param pass
     * @return
     */

    public static boolean usuarioExiste(String user, String pass) {
        EntityManager manager = managerFactory.createEntityManager() ;
        TypedQuery<Long> query = manager.createQuery(
                "SELECT COUNT(u) FROM Usuario u WHERE u.userName = :userName AND u.contra = :password", Long.class);
        query.setParameter("userName", user);
        query.setParameter("password", pass);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    /**
     * Método para buscar en la base de datos un dentista igual al dado, y con la misma contraseña a la dada.
     * Se devolverá true si se encuentra 1 o más.
     * @param user
     * @param pass
     * @return
     */

    public static boolean dentistaExiste(String user, String pass) {
        EntityManager manager = managerFactory.createEntityManager() ;
        TypedQuery<Long> query = manager.createQuery(
                "SELECT COUNT(u) FROM Dentista u WHERE u.userName = :userName AND u.contra = :password", Long.class);
        query.setParameter("userName", user);
        query.setParameter("password", pass);
        Long count = query.getSingleResult();
        return count != null && count > 0;
    }

    /**
     * Método para recuperar en un ArrayList todos nuestros usuarios.
     * @return
     */

    public static ArrayList<Usuario> getUsuarios (){
        EntityManager manager = managerFactory.createEntityManager() ;
        ArrayList<Usuario> listado = (ArrayList<Usuario>) manager.createQuery( "FROM Usuario" ).getResultList() ;
        manager.close() ;
        return listado;
    }

    /**
     * Método para recuperar en un ArrayList todos nuestros dentistas.
     * @return
     */

    public static ArrayList<Dentista> getDentistas (){
        EntityManager manager = managerFactory.createEntityManager() ;
        ArrayList<Dentista> listado = (ArrayList<Dentista>) manager.createQuery( "FROM Dentista" ).getResultList() ;
        manager.close() ;
        return listado;
    }

    /**
     * Método para borrar un usuario dado.
     * @param us
     */

    public static void deleteUser(Usuario us){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        Usuario usuario = manager.find(Usuario.class, us.getDni());
        manager.remove(usuario);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Método para actualizar el nombre de un usuario dado por otro.
     * @param us
     * @param nombre
     */

    public static void actualizarUsuario(Usuario us,String nombre){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();

        Usuario usuario = manager.find(Usuario.class, us.getDni());
        usuario.setNombre(nombre);

        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Método para recuperar el nombre de un dentista dando el nombre del usuario.
     * @param userName
     * @return
     */

    public static String getNombreDentista(String userName) {
        EntityManager manager = managerFactory.createEntityManager() ;
        Query query = manager.createQuery("SELECT d.nombre FROM Dentista d WHERE d.userName = :userName");
        query.setParameter("userName", userName);
        String nombre = (String) query.getSingleResult();
        return nombre;
    }
}
