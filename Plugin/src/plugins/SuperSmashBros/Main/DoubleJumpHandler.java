package plugins.SuperSmashBros.Main;

import plugins.SuperSmashBros.Main.ParticleEffects;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJumpHandler implements Listener{
	private final SuperSmashBros plugin;
	public DoubleJumpHandler(SuperSmashBros plugin){
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent event){
		// Variables
		Player ply = event.getPlayer();
		ply.setLevel(2);
		// Makes sure that the player has the right permission, is not in creative, and is not in midair, then allows them to fly.
		if((ply.hasPermission("ssb.doublejump")) && (ply.getGameMode() != GameMode.CREATIVE) && (ply.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)){
			ply.setAllowFlight(true);
		}
	}
	
	@EventHandler
	public void onToggle(PlayerToggleFlightEvent event){
		// Variables
		Player ply = event.getPlayer();
		// Makes sure that the player has the permission and is not in creative.
		if((ply.hasPermission("ssb.doublejump")) && (ply.getGameMode() != GameMode.CREATIVE)) doDoubleJump(ply, event);
	}

	// This is the actual part where we make the player "jump" again.
	public void doDoubleJump(Player ply, Event event){
		// This will make sure the 'event' argument is the player double jumping
		if(event instanceof PlayerToggleFlightEvent){
			((PlayerToggleFlightEvent) event).setCancelled(true);
			ply.setLevel(0);
		}
		// Variables
		Location loc = ply.getLocation();
		double distance = plugin.getConfig().getDouble("Doubles.doubleJumpDistance");
		double height = plugin.getConfig().getDouble("Doubles.doubleJumpHeight");
		// Now we actually do stuff
		ply.setAllowFlight(false);
		ply.setFlying(false);
		ply.setVelocity(loc.getDirection().multiply(distance).setY(height));
		if(plugin.getConfig().getBoolean("soundOnDoubleJump", true)) ply.playSound(loc, Sound.ZOMBIE_INFECT, 1.0F, 2.0F);
		if(plugin.getConfig().getBoolean("smokeOnDoubleJump", true)){
			try{
				ParticleEffects.SMOKE.sendToPlayer(ply, loc, 1.0F, 1.0F, 1.0F, 1.0F, 5);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
