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
	boolean itemdrop = true;
	boolean restorearena = true;
	boolean isRanked = false;
	boolean earnXp = false;
	boolean enableParticleEffects = true;
	boolean enableKnockoutSounds = true;
	boolean useTagAPI = true;
	boolean scoreboards = true;
	boolean doubleJump = true;
	int winXp = 0;
	int killXP = 10;
	int afkKickXp = 0;
	
	public Arena(Location loc, int id){
		this.lobbyspawn = loc;
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public List<String> getPlayers(){
		return this.players;
	}
}
