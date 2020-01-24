package com.yfsanchez.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.yfsanchez.modelo.Game;
import com.yfsanchez.modelo.GamePlayer;
import com.yfsanchez.modelo.GameTeam;
import com.yfsanchez.modelo.Player;
import com.yfsanchez.modelo.Team;

public class TestSave {
	
	private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("aplicacion");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*crear el gestos de base de datos EM*/
		crearDatos();
		
		imprimirTodo();
		

	}
	
	static void crearDatos() {
		EntityManager manager = emf.createEntityManager();
		
//		
		manager.getTransaction().begin();
		
		Game game1 = new Game("tommy1", "ymmot1", "tommy1@gmail.com");
		Game game2 = new Game("tommy2", "ymmot2", "tommy2@gmail.com");
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		Team team1 = new Team("Team1");
		Team team2 = new Team("Team2");
		 
		 
        manager.persist(new GamePlayer(game1,player1,true, new Date()));
        manager.persist(new GamePlayer(game1,player1,false, new Date()));
        manager.persist(new GamePlayer(game2,player1,false, new Date()));
        manager.persist(new GamePlayer(game2,player2,false, new Date()));
        
        manager.persist(new GameTeam(game1, team1, true, new Date(),true));
        manager.persist(new GameTeam(game1, team2, true, new Date(),false));
        
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
		
		List<Team> cols3 = (List<Team>)mon.createQuery("from Team").getResultList();
		System.out.println("libros: " + cols3.size());
		for (Team temp : cols3) {
			System.out.println(temp.toString());
		}
		
		mon.close();
	}

}
