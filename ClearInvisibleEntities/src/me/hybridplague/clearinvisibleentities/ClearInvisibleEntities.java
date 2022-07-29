package me.hybridplague.clearinvisibleentities;

import org.bukkit.plugin.java.JavaPlugin;

public class ClearInvisibleEntities extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getCommand("cleararmorstand").setExecutor(new ClearArmorStands());
		this.getCommand("cleararmorstands").setExecutor(new ClearArmorStands());
		this.getCommand("clearas").setExecutor(new ClearArmorStands());
		this.getCommand("cas").setExecutor(new ClearArmorStands());
		
		this.getCommand("clearitemframes").setExecutor(new ClearItemFrames());
		this.getCommand("clearitemframe").setExecutor(new ClearItemFrames());
		this.getCommand("clearif").setExecutor(new ClearItemFrames());
		this.getCommand("cif").setExecutor(new ClearItemFrames());
		
	}
	
	@Override
	public void onDisable() {
	}
	
}
