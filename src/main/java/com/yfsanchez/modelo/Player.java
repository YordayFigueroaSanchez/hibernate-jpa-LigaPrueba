package com.yfsanchez.modelo;
 
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "PLAYERS")
public class Player {
    private long id;
    private String name;
 
    private Set<GamePlayer> gamePlayers = new HashSet<GamePlayer>();
     
    public Player() {
    }
 
    public Player(String name) {
        this.name = name;
    }
         
    @Id
    @GeneratedValue
    @Column(name = "PLAYER_ID")
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @OneToMany(mappedBy = "player")
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }
 
    public void setGamePlayers(Set<GamePlayer> value) {
        this.gamePlayers = value;
    }
     
    public void addGamePlayer(GamePlayer value) {
        this.gamePlayers.add(value);
    }

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}
    
    
 
}