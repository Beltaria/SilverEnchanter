package me.bluedyaishela.silverenchanter;

import me.bluedyaishela.silverenchanter.enchantment.LavaWalker;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SilverEnchanter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents((new LavaWalker(420)), this);
        this.getCommand("silverenchanter").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
