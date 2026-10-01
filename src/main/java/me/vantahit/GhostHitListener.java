package me.vantahit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public final class GhostHitListener implements Listener {

    @EventHandler(
            priority = EventPriority.HIGHEST,
            ignoreCancelled = false
    )
    public void onDamage(EntityDamageByEntityEvent event) {

        if (!event.isCancelled()) {
            return;
        }

        if (!(event.getDamager() instanceof Player attacker)) {
            return;
        }

        if (!(event.getEntity() instanceof Player target)) {
            return;
        }

        // Recover the hit that reached the server but was cancelled.
        event.setCancelled(false);

        attacker.sendActionBar("§a✔ Hit recovered");
    }
}
