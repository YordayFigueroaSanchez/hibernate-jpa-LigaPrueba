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
@Table(name = "GAMES_PLAYERS")
public class GamePlayer {
	private long id;
	private Game game;
	private Player player;

	// additional fields
	private boolean activated;
	private Date registeredDate;

	public GamePlayer() {
	}

	public GamePlayer(Game game, Player player, boolean activated, Date registeredDate) {
		this.game = game;
		this.player = player;
		this.activated = activated;
		this.registeredDate = registeredDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "GAME_PLAYER_ID")
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
	@JoinColumn(name = "PLAYER_ID")
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
}
