package me.bluedyaishela.silverenchanter;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player))
        {
            return false;
        }

        if (args.length == 0)
        {
            sender.sendMessage("Vous utilisez actuellement SilverEnchanter Beta");
            return false;
        }

        Player player = (Player) sender;

        switch (args[0])
        {
            case "lavawalker":
                ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS); // Crée une nouvelle paire de bottes en diamant
                Enchantment lavaWalker = Enchantment.getByName("LavaWalker"); // Récupère l'enchantement "LavaWalker"

                ItemMeta itemMeta = boots.getItemMeta(); // Récupère les métadonnées de l'objet ItemStack
                itemMeta.addEnchant(lavaWalker, 1, true); // Applique l'enchantement "LavaWalker" avec un niveau de 1 sur les bottes

                boots.setItemMeta(itemMeta); // Définit les métadonnées mises à jour sur l'objet ItemStack

                player.getInventory().addItem(boots); // Ajoute les bottes enchantées à l'inventaire du joueur
                player.sendMessage("Vous avez reçu des bottes enchantées avec LavaWalker !");

                return true;
            case "registered":
                Enchantment.registerEnchantment();
                return false;
            case "help":
                return false;
        }

        return false;
    }
}
