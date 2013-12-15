package plugins.SuperSmashBros.Main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import plugins.SuperSmashBros.Main.Utils.Updater;
import plugins.SuperSmashBros.Main.Utils.Updater.UpdateResult;
import plugins.SuperSmashBros.Main.Utils.Updater.UpdateType;
import plugins.SuperSmashBros.Main.listeners.OnSignChange;

public class SSB extends JavaPlugin{

	private Server s = Bukkit.getServer();
	private PluginManager pm = s.getPluginManager();
	private Logger log = s.getLogger();
	
	public void onEnable() {
		log.info("SSB: Minecraft fully enabled!");
		
		if(getConfig().getBoolean("Check-For-Updates") == true){
			Updater updater = new Updater(this, 69480, this.getFile(), UpdateType.DEFAULT, true);
			if(updater.getResult() == UpdateResult.UPDATE_AVAILABLE){
				this.getLogger().info("New version available! " + updater.getLatestName());
			}
		}		
	}
	public void onDisable() {
		log.info("SSB: Minecraft disabled!");
		
	}
	
	public void regListeners(){
		pm.registerEvents(new OnSignChange(), this);
	}
}
