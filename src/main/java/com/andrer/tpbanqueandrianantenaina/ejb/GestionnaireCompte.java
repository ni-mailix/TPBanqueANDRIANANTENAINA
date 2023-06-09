/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrer.tpbanqueandrianantenaina.ejb;

/**
 *
 * @Gère la paersistence
 */
import com.andrer.tpbanqueandrianantenaina.entities.CompteBancaire;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;

@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root", // nom et
        password = "&19Bcm46#&", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true"
        }
)
@Stateless
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    public void persist(CompteBancaire comptebanque) {
        em.persist(comptebanque);
    }

    public List<CompteBancaire> getAllCustomers() {
        TypedQuery query = (TypedQuery) em.createNamedQuery("CompteBancaire.findAll");

        return query.getResultList();
    }

    public CompteBancaire update(CompteBancaire comptebanque) {
        return em.merge(comptebanque);
    }

}
