package me.iaero;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class EasySoup extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		getServer().getLogger().info("EasySoup [v" + getDescription().getVersion() + "] has been enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		getServer().getLogger().info("EasySoup [v" + getDescription().getVersion() + "] has been disabled!");
	}
	
	@EventHandler (priority = EventPriority.HIGH)
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		
	    if (((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) && (player.getItemInHand().getType() == Material.MUSHROOM_SOUP) && (player.getHealth() != 20.0) && (player.getHealth() + 1.0 <= 20.0)) {
	        event.setCancelled(true);
	        player.setHealth(player.getHealth() + 7.0 > player.getMaxHealth() ? player.getMaxHealth() : player.getHealth() + 7.0);
	        player.getInventory().setItemInHand(new ItemStack(Material.BOWL, 1));
	    }
		
	}
	
}
