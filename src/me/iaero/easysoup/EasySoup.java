package me.iaero.easysoup;

import me.iaero.easysoup.commands.SoupCommand;
import me.iaero.easysoup.listeners.PlayerListener;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class EasySoup extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {

		getServer().getLogger().info("EasySoup [v" + getDescription().getVersion() + "] has been enabled!");
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);

		getCommand("soup").setExecutor(new SoupCommand());

	}

	@Override
	public void onDisable() {
		getServer().getLogger().info("EasySoup [v" + getDescription().getVersion() + "] has been disabled!");
	}

}
