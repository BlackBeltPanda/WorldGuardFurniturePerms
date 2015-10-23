package main.java.me.BlackBeltPanda.WorldGuardFurniturePerms;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import de.Ste3et_C0st.FurnitureLib.Events.FurnitureBreakEvent;

public class Main extends JavaPlugin implements Listener{
	
	WorldGuardPlugin wgp;
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		wgp = (WorldGuardPlugin) getServer().getPluginManager().getPlugin("WorldGuard");
	}
	
	@EventHandler
	public void onFurnitureBreak(FurnitureBreakEvent event){
		if (wgp.canBuild(event.getPlayer(), event.getLocation())) event.getID().remove(event.getPlayer());
	}
}
