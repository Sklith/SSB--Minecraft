package plugins.SuperSmashBros.Main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SSB extends JavaPlugin{

	private Server s = Bukkit.getServer();
	private PluginManager pm = s.getPluginManager();
	private Logger log = s.getLogger();
	
	public void onEnable(){
		
		log.info("SSB: Minecraft fully enabled!");
	}
	public void onDisable(){
		log.info("SSB: Minecraft disabled!");
	}
}
