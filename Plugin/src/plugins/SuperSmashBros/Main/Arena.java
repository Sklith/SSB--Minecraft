package plugins.SuperSmashBros.Main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class Arena {

	int id = 0;
	Location lobbyspawn = null;
	List<String> players = new ArrayList<String>();
	List<Location> startLocations = new ArrayList<Location>();
	List<String> queuedPlayers = new ArrayList<String>();
	boolean itemDrop = true;
	boolean restoreArena = true;
	boolean isRanked = false;
	boolean earnXp = false;
	boolean enableParticleEffects = true;
	boolean enableKnockoutSounds = true;
	boolean useTagAPI = true;
	boolean scoreboards = true;
	boolean doubleJump = true;
	int winXp = 0;
	int killXp = 10;
	int afkKickXp = 5;
	
	
	public Arena(Location loc, int id){
		this.lobbyspawn = loc;
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public int winXp(){
		return this.winXp;
	}
	public int killXp(){
		return this.killXp;
	}
	public List<String> getPlayers(){
		return this.players;
	}
	public List<Location> getStartLocations(){
		return this.startLocations;
	}
	public boolean canUseTagApi(){
		return this.useTagAPI;
	}
	public boolean canEarnXp(){
		return this.earnXp;
	}
	public boolean isRanked(){
		return this.isRanked;
	}
	public boolean scoreboards(){
		return this.scoreboards;
	}
	public boolean doubleJump(){
		return this.doubleJump;
	}
	public boolean itemDrop(){
		return this.itemDrop;
	}
	public boolean restoreArena(){
		return this.restoreArena;
	}
	public boolean enableKnockoutSounds(){
		return this.enableKnockoutSounds;
	}
	public boolean enableParticleEffects(){
		return this.enableParticleEffects;
	}
}
