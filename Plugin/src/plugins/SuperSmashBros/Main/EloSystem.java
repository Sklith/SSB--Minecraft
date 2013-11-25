package plugins.SuperSmashBros.Main;

import org.bukkit.event.Listener;

public class EloSystem implements Listener{
	private final SuperSmashBros plugin;
	public EloSystem(SuperSmashBros plugin) {	
		this.plugin = plugin;		
	}
	/* 
	 * Main class for the IES (Internal Elo System) 
	 * 
	 * Explanation on Elo Rating System Located Here:
	 * 
	 * https://en.wikipedia.org/wiki/Elo_rating_system
	 * 
	 *
	 * I was thinking of creating events for the plugin, like SmashWinEvent and SmashLoseEvent
	 * Maybe some ways to retrieve player data. Like player.getElo(), player.setElo(), etc.
	 * We should start planning this out!
	 *
	 */
	
	
	
}
