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
@Table(name = "TEAMS")
public class Team {
    private long id;
    private String name;
 
    private Set<GameTeam> gameTeams = new HashSet<GameTeam>();
     
    public Team() {
    }
 
    public Team(String name) {
        this.name = name;
    }
         
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
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
 
    @OneToMany(mappedBy = "team")
    public Set<GameTeam> getGameTeams() {
        return gameTeams;
    }
 
    public void setGameTeams(Set<GameTeam> value) {
        this.gameTeams = value;
    }
     
    public void addGameTeam(GameTeam value) {
        this.gameTeams.add(value);
    }

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
    
    

	
}