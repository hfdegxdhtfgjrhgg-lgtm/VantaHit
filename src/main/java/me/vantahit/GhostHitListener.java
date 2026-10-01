package me.vantahit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public final class GhostHitListener implements Listener {

    private final Main plugin;

    public GhostHitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.HIGHEST,
            ignoreCancelled = false
    )
    public void onDamage(EntityDamageByEntityEvent event) {

        if (!plugin.getConfig().getBoolean("recover-cancelled-hits", true)) {
            return;
        }

        if (!event.isCancelled()) {
            return;
        }

        if (!(event.getDamager() instanceof Player attacker)) {
            return;
        }

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        // الضربة وصلت للسيرفر، لكن حدث الضرر تم إلغاؤه.
        // نرجع الحدث للعمل بدون إضافة Damage ثانية.
        event.setCancelled(false);

        if (plugin.getConfig().getBoolean("actionbar-message", true)) {
            String message = plugin.getConfig().getString(
                    "recovered-message",
                    "§a✔ Hit recovered"
            );

            attacker.sendActionBar(message);
        }
    }
}
