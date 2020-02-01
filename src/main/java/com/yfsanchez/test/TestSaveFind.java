package com.yfsanchez.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.yfsanchez.modelo.Game;
import com.yfsanchez.modelo.GamePlayer;
import com.yfsanchez.modelo.League;
import com.yfsanchez.modelo.Player;

public class TestSaveFind {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");

	public static void main(String[] args) {
		crearDatos();
		findAndUpdate();
		// imprimirTodo();

	}

	static void findAndUpdate() {
		EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        Game user = manager.find(Game.class, new Long(2));
        Player group = manager.find(Player.class, new Long(5));
        manager.persist(new GamePlayer(user,group,true, new Date()));
		manager.getTransaction().commit();
		manager.close();
	}

	static void crearDatos() {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		League l1 = new League("league1");
		manager.persist(new Game("tommy1", "ymmot1", "tommy1@gmail.com",l1));
		manager.persist(new Game("tommy2", "ymmot2", "tommy2@gmail.com",l1));
		manager.persist(new Game("tommy3", "ymmot3", "tommy3@gmail.com",l1));
		manager.persist(new Player("Coders4"));
		manager.persist(new Player("Coders5"));
		manager.persist(new Player("Coders6"));

		manager.getTransaction().commit();
		manager.close();
	}

	@SuppressWarnings("unchecked")
	private static void  imprimirTodo() {
		EntityManager mon = emf.createEntityManager();
		List<Player> cols = (List<Player>)mon.createQuery("from Player").getResultList();
		System.out.println("players: " + cols.size());
		for (Player temp : cols) {
			System.out.println(temp.toString());
		}
		
		List<Game> cols2 = (List<Game>)mon.createQuery("from Game").getResultList();
		System.out.println("libros: " + cols2.size());
		for (Game temp : cols2) {
			System.out.println(temp.toString());
		}
		mon.close();
	}


}
