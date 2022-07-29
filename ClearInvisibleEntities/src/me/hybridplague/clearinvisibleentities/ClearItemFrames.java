package me.hybridplague.clearinvisibleentities;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

public class ClearItemFrames implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player p = (Player) sender;

		if (!p.hasPermission("clearinvisibleentites.use")) {
			p.sendMessage(ChatColor.RED + "Insufficient Permissions.");
			return true;
		}
		
		switch (args.length) {
		case 0:
			p.sendMessage(ChatColor.RED + "Missing Argument: " + ChatColor.GRAY + "/cif <radius>");
			break;
		case 1:
			if (!isNum(args[0])) {
				p.sendMessage(ChatColor.RED + "Invalid Radius: " + ChatColor.GRAY + "/cif <radius>");
				return true;
			}
			clearRadius(p, Integer.valueOf(args[0]));
			break;
		default:
			p.sendMessage(ChatColor.RED + "Invalid Argument: " + ChatColor.GRAY + "/cif <radius>");
			break;
		}
		
		return true;
	}
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}
	
	private void clearRadius(Player p, int radius) {
		if (radius < 1) {
			p.sendMessage(ChatColor.RED + "Radius must be a positive number!");
			return;
		}
		if (radius > 10) {
			p.sendMessage(ChatColor.RED + "Radius limit is 10!");
			return;
		}
		
		int invisible = 0;
		List<Entity> nearby = p.getNearbyEntities(radius, radius, radius);
		for (Entity entity : nearby) {
			if (entity instanceof ItemFrame) {
				ItemFrame frame = (ItemFrame) entity;
				if (!frame.isVisible()) {
					invisible++;
					frame.remove();
				}
			}
		}
		p.sendMessage(ChatColor.GREEN + "You removed a total of " + ChatColor.RED + String.valueOf(invisible) + ChatColor.GREEN + " invisible item frames!");
	}
	
}
