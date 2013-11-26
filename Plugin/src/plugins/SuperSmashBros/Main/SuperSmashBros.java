package plugins.SuperSmashBros.Main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperSmashBros extends JavaPlugin {
	
	// Variables
	private Server serv = Bukkit.getServer();
	private PluginManager pm = serv.getPluginManager();
	private Logger log = serv.getLogger();
	
	public void onEnable() {
		// Configuration-related space
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		// Plugin Manager-related space
		pm.registerEvents(new DoubleJumpHandler(this), this);
		pm.registerEvents(new DeveloperFeatureHandler(this), this);
		
		// This is just some empty space for later.
		log.info("SSB: Minecraft enabled successfully! Yay!");
		log.info("Plugin by AwesomeMin3r2000 and Incomprehendable!");
		// Let's make the adjustment to ProtocolLib tomorrow, because if we use craftbukkit.jar as a dependency, we'd have to update this plugin EVERY TIME Bukkit updates.
	}
	public void onDisable() {
		// Empty space for later
		
		log.info("SSB: Minecraft disabled!");
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if ((cmd.getName().equalsIgnoreCase("ssb")) && (sender.hasPermission("ssb.join"))) {
			
			if (sender instanceof Player) {
				
				// This is a work in progress, AwesomeMin3r2000 is trying to figure out a way to get and set player lives
				sender.sendMessage("ssb join");
				
			} else {
				
				sender.sendMessage("Error: You must be a player in game to do this!");
				return false;
				
			}
			
			return false;
			
		}
		
		return false;
		
	}
	
	public void onSmashWin() {
		
		
		
	}
	
	public void onSmashLose() {
		
		
		
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		
		Player player = event.getEntity();
		
		/*
		 * Here we will handle subtracting a life each time a player dies in match.
		 * The final product will start you with about 3 lives, and each time you die, we will subtract one. For this to work the way I have it planned,
		 * I need to figure out a way to get when a player joins a match of SSB. If I can get those event handlers setup, I can easily setup a lives system, as well
		 * as the pds (player death system).
		 * 
		 * (Added by AwesomeMin3r2000)
		 */
		
	}

}
