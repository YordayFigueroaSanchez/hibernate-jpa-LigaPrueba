package com.yfsanchez.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.yfsanchez.modelo.Game;
import com.yfsanchez.modelo.GamePlayer;
import com.yfsanchez.modelo.Player;

public class TestSaveDelete {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");

	public static void main(String[] args) {
		crearDatos();
		findAndDelete();
		// imprimirTodo();

	}

	static void findAndDelete() {
		EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        GamePlayer usergroup = manager.find(GamePlayer.class, new Long(1));
        manager.remove(usergroup);
		manager.getTransaction().commit();
		manager.close();
	}

	static void crearDatos() {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();

		Game user = new Game("tommy", "ymmot", "tommy@gmail.com");
		Player group = new Player("Coders");
		manager.persist(new GamePlayer(user,group,true, new Date()));
		manager.persist(new GamePlayer(user,group,false, new Date()));

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
