package plugins.SuperSmashBros.Main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
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
	

}
