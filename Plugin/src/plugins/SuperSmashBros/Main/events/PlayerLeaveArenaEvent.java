package plugins.SuperSmashBros.Main.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import plugins.SuperSmashBros.Main.Arena;
import plugins.SuperSmashBros.Main.ArenaPlayer;

public class PlayerLeaveArenaEvent extends Event{
	private static final HandlerList handlers = new HandlerList();
	private ArenaPlayer player = null;
	private Arena arena = null;
	private boolean cancelled = false;
	
	public PlayerLeaveArenaEvent(ArenaPlayer player, Arena arena){
		this.player = player;
		this.arena = arena;
	}
	public boolean isCancelled(){
		return cancelled;
	}
	public void setCancelled(boolean cancelled){
		this.cancelled = cancelled;
	}
	public ArenaPlayer player(){
		return player;
	}
	public Player getPlayer(){
		return player.getPlayer();
	}
	public Arena getArena(){
		return arena;
	}
	public HandlerList getHandlers(){
		return handlers;
	}
	public static HandlerList getHandlerList(){
		return handlers;
	}
}
