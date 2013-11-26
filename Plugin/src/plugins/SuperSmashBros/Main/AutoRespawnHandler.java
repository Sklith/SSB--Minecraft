package plugins.SuperSmashBros.Main;

import net.minecraft.server.v1_6_R3.Packet205ClientCommand;

import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class AutoRespawnHandler implements Listener{
	private final SuperSmashBros plugin;
	public AutoRespawnHandler(SuperSmashBros plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	// This just auto-respawns a player half a second after they die.
	public void onDeath(PlayerDeathEvent event){
		if(plugin.getConfig().getBoolean("Booleans.autoRespawn", true)){
			final Packet205ClientCommand packet = new Packet205ClientCommand();
			packet.a = 1;
			final Player ply = (Player) event.getEntity();
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				public void run(){
					if(ply.isDead()){
						((CraftPlayer) ply).getHandle().playerConnection.a(packet);
					}
				}
			}, 10);
		}
	}

}
