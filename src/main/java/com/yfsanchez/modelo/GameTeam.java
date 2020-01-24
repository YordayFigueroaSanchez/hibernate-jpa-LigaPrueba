package com.yfsanchez.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GAMES_TEAMS")
public class GameTeam {
	private long id;
	private Game game;
	private Team team;

	// additional fields
	private boolean activated;
	private Date registeredDate;
	private boolean Local;

	public GameTeam() {
	}

	public GameTeam(Game game, Team team, boolean activated, Date registeredDate, boolean Local) {
		this.game = game;
		this.team = team;
		this.activated = activated;
		this.registeredDate = registeredDate;
		this.Local = Local;
	}

	@Id
	@GeneratedValue
	@Column(name = "GAME_TEAM_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "GAME_ID")
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAM_ID")
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team value) {
		this.team = value;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	@Column(name = "REGISTERED_DATE")
	@Temporal(TemporalType.DATE)
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public boolean isLocal() {
		return Local;
	}

	public void setLocal(boolean local) {
		Local = local;
	}
}
