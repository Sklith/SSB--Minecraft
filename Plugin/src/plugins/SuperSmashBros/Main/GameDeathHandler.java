package plugins.SuperSmashBros.Main;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GameDeathHandler implements Listener{
	private final SuperSmashBros plugin;
	public GameDeathHandler(SuperSmashBros plugin){
		this.plugin = plugin;
	}
	
	private Map<Player, Integer> counterHandler = new HashMap<Player, Integer>();
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event, Integer lives){
		Player ply = (Player) event.getEntity();
		if((counterHandler.containsKey(ply)) && (counterHandler.containsKey(lives))){
			int newlives = lives - 1;
			counterHandler.put(ply, newlives);
		}
		
	}
}
