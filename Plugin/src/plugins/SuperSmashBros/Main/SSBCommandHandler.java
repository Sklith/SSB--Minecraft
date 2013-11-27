package plugins.SuperSmashBros.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SSBCommandHandler implements CommandExecutor{
	private final SuperSmashBros plugin;
	public SSBCommandHandler(SuperSmashBros plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Commandlabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("ssb")){
			// a lot of stuff
			
			
			
			
		}
		return false;
	}
	
}
