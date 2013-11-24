package plugins.SuperSmashBros.Main;

import plugins.SuperSmashBros.Main.ParticleEffects;

import org.bukkit.GameMode;
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
	// Constructor to the main class so we can use its config methods
	private final SuperSmashBros plugin;
	public DoubleJumpHandler(SuperSmashBros plugin){
		this.plugin = plugin;
	}
	
	// This is just general double jump. Once we set up arenas, we have to change this around
	@EventHandler
	public void onMove(PlayerMoveEvent event){
		Player ply = event.getPlayer();
		// This checks for a certain permission, makes sure their game mode is survival or adventure, and makes sure they are on the ground
		if((ply.hasPermission("ssb.doublejump")) && (ply.getGameMode() != GameMode.CREATIVE) & (ply.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)){
			ply.setAllowFlight(true);
			// I don't really like this method because move events are fired a lot, so on bigger servers, it may cause some lag. I'll try to find an optimized method for this later.
		}
	}
	
	public void onFly(PlayerToggleFlightEvent event){
		// Actual double jumping mechanics here
		Player ply = event.getPlayer();
		if((ply.hasPermission("ssb.doublejump")) && (ply.getGameMode() != GameMode.CREATIVE)) doubleJumpGo(ply, event);
		// Yeah, I just put that into one line of code. Mostly for the ego boost, but it could help make the plugin a bit more flexible
	}
	
	private void doubleJumpGo(Player ply, Event event){
		// Config variables
		double height = (plugin.getConfig().getDouble("Doubles.doubleJumpHeight"));
		double velocity = (plugin.getConfig().getDouble("Doubles.doubleJumpDistance"));
		boolean sound = (plugin.getConfig().getBoolean("Booleans.soundEffectOnDoubleJump"));
		boolean effect = (plugin.getConfig().getBoolean("Booeans.smokeEffectOnDoubleJump"));
		
		// Actual stuff to do
		if(event instanceof PlayerToggleFlightEvent) ((PlayerToggleFlightEvent) event).setCancelled(true);
		ply.setAllowFlight(false);
		ply.setFlying(false);
		ply.setVelocity(ply.getLocation().getDirection().multiply(velocity).setY(height));
		if(sound == true) ply.playSound(ply.getLocation(), Sound.ZOMBIE_INFECT, 1.0F, 2.0F);
		if(effect == true){
	          try {
	        	  // I made craftbukkit and the Bukkit API both dependencies so we can make effects like this without having to fall back onto another API for it. Even though I think we should make ProtocolLib a referenced library because it is gonna save us a ton of pain in the future
					ParticleEffects.SMOKE.sendToPlayer(ply, ply.getLocation(), 1.0F, 1.0F, 1.0F, 1.0F, 40);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
