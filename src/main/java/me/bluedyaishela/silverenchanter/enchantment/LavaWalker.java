package me.bluedyaishela.silverenchanter.enchantment;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class LavaWalker extends Enchantment implements Listener {
    public LavaWalker(int id) {
        super(id);
    }

    @Override
    public String getName() {
        return "LavaWalker";
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getLocation().getBlock().getType() == Material.LAVA && player.getLocation().getBlock().getData() == 0) {
            if (player.getInventory().getBoots() != null && player.getInventory().getBoots().containsEnchantment(this)) {
                // La vitesse de déplacement dans la lave peut être ajustée en modifiant le multiplicateur ci-dessous
                player.setWalkSpeed(0.3f);
            }
        } else {
            player.setWalkSpeed(0.2f); // Rétablir la vitesse de déplacement normale lorsque le joueur n'est pas dans la lave
        }
    }
}
