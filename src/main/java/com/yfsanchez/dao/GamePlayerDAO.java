package com.yfsanchez.dao;

import javax.persistence.EntityManager;

import com.yfsanchez.conexion.Conexion;
import com.yfsanchez.modelo.GamePlayer;

public class GamePlayerDAO {

	public void insertar(GamePlayer value) {
		EntityManager em = null;
		try {
			em = Conexion.createEntityMananger();
			em.getTransaction().begin();
			em.persist(value);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error al insertar " + e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
