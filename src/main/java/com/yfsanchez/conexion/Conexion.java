package com.yfsanchez.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {

	private static EntityManagerFactory emf = null;

	public static EntityManager createEntityMananger() {
		try {
			if (emf == null) {
				emf = Persistence.createEntityManagerFactory("aplicacion");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return emf.createEntityManager();
	}

}
