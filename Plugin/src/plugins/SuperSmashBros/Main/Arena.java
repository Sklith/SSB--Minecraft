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
	
	
	public Arena(Location lobbyspawn, int id, int winXp, int killXp, int afkKickXp, List<String> players, List<Location> startLocations, List<String> queuedPlayers,
			boolean itemDrop, boolean restoreArena, boolean isRanked, boolean earnXp, boolean enableParticleEffects, boolean enableKnockoutSounds, 
			boolean useTagAPI, boolean scoreboards, boolean doubleJump){
		this.lobbyspawn = lobbyspawn;
		this.id = id;
		this.winXp = winXp;
		this.killXp = killXp;
		this.afkKickXp = afkKickXp;
		this.players = players;
		this.startLocations = startLocations;
		this.queuedPlayers = queuedPlayers;
		this.itemDrop = itemDrop;
		this.restoreArena = restoreArena;
		this.isRanked = isRanked;
		this.earnXp = earnXp;
		this.enableParticleEffects = enableParticleEffects;
		this.enableKnockoutSounds = enableKnockoutSounds;
		this.useTagAPI = useTagAPI;
		this.scoreboards = scoreboards;
		this.doubleJump = doubleJump;
		this.winXp = winXp;
		this.killXp = killXp;
		this.afkKickXp = afkKickXp;
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
