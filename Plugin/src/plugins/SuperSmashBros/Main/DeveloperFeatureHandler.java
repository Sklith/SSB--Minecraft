package plugins.SuperSmashBros.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DeveloperFeatureHandler implements Listener{
	private final SuperSmashBros plugin;
	public DeveloperFeatureHandler(SuperSmashBros plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		if(plugin.getConfig().getBoolean("Booleans.developerFeature", true)){
			Player p = event.getPlayer();
			if((p.getName().contains("Incomprehendable")) || equals(p.getName().contains("AwesomeMin3r2000"))){
				String msg = plugin.getConfig().getString("Strings.developerMessage").replaceAll("(&([a-f0-9]))", "\u00A7$2").replace("%name", p.getName());
				p.sendMessage(msg);
			}
		}
	}

}
