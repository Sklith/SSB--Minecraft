package plugins.SuperSmashBros.Main;

import org.bukkit.entity.Player;

public class ArenaManager {
	private static ArenaManager am = new ArenaManager();
	
	public static ArenaManager getManager(){
		return am;
	}
	public Arena getArena(String name){
		for (Arena a : Arena.arenaObjects){
			if(a.getName().equals(name)){
				return a;
			}
		}
		return null;
	}
	
	public void addPlayers(Player player, String arenaName){
		if(getArena(arenaName) != null){
			Arena arena = getArena(arenaName);
			if(!arena.isFull()){
				if(!arena.isInGame()){
					player.getInventory().clear();
					player.setHealth(player.getMaxHealth());
					player.setFireTicks(0);
					player.teleport(arena.getLobbyLocation());
				}
			}
		}
		
	}
}
