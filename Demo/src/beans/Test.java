/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
/**
 *
 * @author oussama
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Test {
    public static void save(Site s) {
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/db"; 
        Connection cn = null;
        Statement st = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, password);
            st = cn.createStatement();
            String req = "INSERT INTO site VALUES (null, '" + s.getNom() + "')";
            st.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver : " + ex.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources : " + ex.getMessage());
            }
        }
    }
// autre methode 
   
    public static void load() {
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/db"; // Assurez-vous que le nom de la base de données est correct ici
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Chargement du pilote JDBC
            Class.forName("com.mysql.jdbc.Driver");
            
            // Connexion à la base de données
            cn = DriverManager.getConnection(url, user, password);
            
            // Création d'un objet Statement pour exécuter la requête SQL
            st = cn.createStatement();
            
            String req = "SELECT * FROM site";
            
            // Exécution de la requête SQL et récupération du résultat dans un ResultSet
            rs = st.executeQuery(req);
            
            // Parcours des résultats et affichage
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                System.out.println("ID : " + id + ", Nom : " + nom);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver : " + ex.getMessage());
        } finally {
            try {
                // Fermeture des ressources dans le bloc "finally"
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources : " + ex.getMessage());
            }
        }
    }
    
}



