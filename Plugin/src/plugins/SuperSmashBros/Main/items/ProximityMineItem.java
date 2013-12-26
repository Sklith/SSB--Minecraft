package plugins.SuperSmashBros.Main.items;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ProximityMineItem {
	public static ArrayList<Block> proximityMines = new ArrayList<Block>();
	// Thanks, DancingWalrus!
	
	@EventHandler
	  public void interact(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
	      if ((e.getItem() != null) && 
	        (e.getItem().getType() == Material.WOOD_PLATE)) {
	        final Item i = p.getWorld().dropItem(p.getLocation().add(0.0D, 1.0D, 0.0D), new ItemStack(Material.WOOD_PLATE));
	        i.setPickupDelay(9999);
	        i.setVelocity(p.getLocation().getDirection());
	        new BukkitRunnable() {
	          public void run() {
	            if (i.isDead()) {
	              cancel();
	            }
	            else if ((i.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) && (!i.getLocation().getBlock().isLiquid())) {
	              Block b = i.getLocation().getBlock();
	              i.getWorld().playEffect(i.getLocation(), Effect.STEP_SOUND, Material.WOOD);
	              if (!proximityMines.contains(b)) {
	                proximityMines.add(b);
	                b.setType(Material.WOOD_PLATE);
	                i.remove();
	                cancel();
	              } else {
	                i.remove();
	                cancel();
	              }
	            }
	          }
	        }
	        .runTaskTimer((Plugin) this, 2L, 2L);
	      }

	    }
	    else if ((e.getAction() == Action.PHYSICAL) && 
	      (e.getClickedBlock().getType() == Material.WOOD_PLATE) && 
	      (ProximityMineItem.proximityMines.contains(e.getClickedBlock()))) {
	      ProximityMineItem.proximityMines.remove(e.getClickedBlock());
	      e.getClickedBlock().setType(Material.AIR);
	      e.getClickedBlock().getWorld().createExplosion(e.getClickedBlock().getLocation(), 4.0F);
	    }
	  }
	}
