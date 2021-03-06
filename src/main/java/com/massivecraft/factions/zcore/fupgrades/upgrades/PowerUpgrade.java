package com.massivecraft.factions.zcore.fupgrades.upgrades;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.zcore.fupgrades.FactionUpgrade;
import com.massivecraft.factions.zcore.fupgrades.UpgradeListener;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.Set;

public class PowerUpgrade extends FactionUpgrade {

    public PowerUpgrade() {
        super("power");
    }

    @Override
    public Set<Listener> listenersToRegister() {
        return null;
    }

    @Override
    public void onLevelUp(Faction faction) {

        updateFactionPowerBoost(faction);

    }

    private void updateFactionPowerBoost(Faction f) {
        double boost = SavageFactions.plugin.getConfig().getDouble("fupgrades.upgrades." + "power" + ".levels." + (f.getUpgrade(this)) +  ".boost");
        if (boost < 0) return;
        f.setPowerBoost(f.getPowerBoost() + boost);
    }

}
