package plugins.SuperSmashBros.Main;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArenaPlayer {
	private Player ply;
	private ItemStack[] inv;
	private ItemStack[] armor;
	private int elo = 1000;
	private int food = 20;
	private double health = 20.0;
	private float saturation = 15;
	private Arena arena = null;
	private GameMode inGameMode = GameMode.ADVENTURE;
	private int deaths = 0;
	private Location lastLoc = null;
	
	
	
	public ArenaPlayer(Player player, ItemStack[] inv, ItemStack[] armor, int elo, int food,
			double health, float saturation, Arena arena, GameMode inGameMode, int deaths, Location lastLoc){
		this.ply = player;
		this.inv = inv;
		this.armor = armor;
		this.elo = elo;
		this.food = food;
		this.health = health;
		this.saturation = saturation;
		this.arena = arena;
		this.inGameMode = inGameMode;
		this.deaths = deaths;
		this.lastLoc = lastLoc;
	}
	public Player getPlayer(){
		return this.ply;
	}
	public String sendMessage(String msg){
		return msg;
	}
	public String getName(){
		return ply.getName();
	}
	public int getElo(){
		return this.elo;
	}
	public int getFood(){
		return this.food;
	}
	public float getSaturation(){
		return this.saturation;
	}
	public double getHealth(){
		return this.health;
	}
	public int getDeaths(){
		return this.deaths;
	}
	public Arena getArena(){
		return this.arena;
	}
	public ItemStack[] getInv(){
		return this.inv;
	}
	public ItemStack[] getArmor(){
		return this.armor;
	}
	public GameMode getGameMode(){
		return this.inGameMode;
	}
	public Location getLastLocation(){
		return this.lastLoc;
	}
}
