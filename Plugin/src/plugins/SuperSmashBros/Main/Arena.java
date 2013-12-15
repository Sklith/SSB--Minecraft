package plugins.SuperSmashBros.Main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class Arena {

	private String name;
	private Location lobbyspawn = null;
	private List<String> players = new ArrayList<String>();
	private List<Location> startLocations = new ArrayList<Location>();
	private List<String> queuedPlayers = new ArrayList<String>();
	private int maxPlayers;
	private boolean itemDrop = true;
	private boolean restoreArena = true;
	private boolean isRanked = false;
	private boolean earnXp = false;
	private boolean enableParticleEffects = true;
	private boolean enableKnockoutSounds = true;
	private boolean useTagAPI = true;
	private boolean scoreboards = true;
	private boolean doubleJump = true;
	private boolean canGrab = true;
	private boolean canGroundPound = true;
	private int winXp = 0;
	private int killXp = 10;
	private int afkKickXp = 5;
	public static ArrayList<Arena> arenaObjects = new ArrayList<Arena>();
	
	public Arena(Location lobbyspawn, String name, int winXp, int killXp, int afkKickXp, List<String> players, List<Location> startLocations, List<String> queuedPlayers,
			boolean itemDrop, boolean restoreArena, boolean isRanked, boolean earnXp, boolean enableParticleEffects, boolean enableKnockoutSounds, 
			boolean useTagAPI, boolean scoreboards, boolean doubleJump){
		this.lobbyspawn = lobbyspawn;
		this.name = name;
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
		arenaObjects.add(this);
	}
	public String getName(){
		return this.name;
	}
	public int getWinXp(){
		return this.winXp;
	}
	public int getKillXp(){
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
	public boolean canUseScoreboards(){
		return this.scoreboards;
	}
	public boolean canDoubleJump(){
		return this.doubleJump;
	}
	public boolean canItemsDrop(){
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
	public boolean canGroundPound(){
		return this.canGroundPound;
	}
	public boolean canGrab(){
		return this.canGrab;
	}
	public boolean inFull(){
		if(players.size() >= maxPlayers){
			return true;
		}else{
			return false;
		}
	}
	public Location getLobbyLocation(){
		return this.lobbyspawn;
	}
	public List<String> getQueuedPlayers(){
		return this.queuedPlayers;
	}
	public int getKickedForAwayXp(){
		return this.afkKickXp;
	}
	
	// setters
	
	public void setLobbyLocation(Location lobbyspawn){
		this.lobbyspawn = lobbyspawn;
	}
	public void setRanked(boolean isRanked){
		this.isRanked = isRanked;
	}
	
}
