package plugins.SuperSmashBros.Main.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class OnSignChange implements Listener{
	
	@EventHandler
	public void onSign(SignChangeEvent event){
		if(event.getLine(0).contains("[SSB_Join]")){
			Player p = event.getPlayer();
			if(event.getLine(1).contains("stuff needs to be done")){
				
			}
			if(p.hasPermission("ssb.sign.join.create")){
				
			}
		}
	}
}
