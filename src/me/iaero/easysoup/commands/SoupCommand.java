package me.iaero.easysoup.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SoupCommand implements CommandExecutor {

	public ItemStack soup() {
		return (new ItemStack(Material.MUSHROOM_SOUP));
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player)sender;

			if (player.hasPermission("easysoup.soup")) {
				for (int i = 0; i < 8; i++) {
					player.getInventory().addItem(soup());
				}
				player.sendMessage("Your soup has been refilled.");
			} else {
				player.sendMessage("§4Permission denied for /" + label);
			}
		} else {
			sender.sendMessage("Please use this command in-game.");
		}
		return false;
	}

}
