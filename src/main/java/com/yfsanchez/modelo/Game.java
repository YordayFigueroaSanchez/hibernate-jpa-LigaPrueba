package com.yfsanchez.modelo;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "GAMES")
public class Game {
    private long id;
    private String username;
    private String password;
    private String email;  
 
    private Set<GamePlayer> gamePlayers = new HashSet<GamePlayer>();
    private Set<GameTeam> gameTeams = new HashSet<GameTeam>();
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_league")
	private League league;
 
    public Game() {
    }
 
    public Game(String username, String password, String email, League league) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.league = league;
    }
     
    public void addPlayer(GamePlayer value) {
        this.gamePlayers.add(value);
    }
 
    @Id
    @GeneratedValue
    @Column(name = "GAME_ID")
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @OneToMany(mappedBy = "game")
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
		return "Game [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", league=" + league.getId() + "]";
	}
	
	@OneToMany(mappedBy = "game")
    public Set<GameTeam> getGameTeams() {
        return gameTeams;
    }
 
    public void setGameTeams(Set<GameTeam> value) {
        this.gameTeams = value;
    }
     
    public void addGameTeam(GameTeam value) {
        this.gameTeams.add(value);
    }

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
    
    
}
