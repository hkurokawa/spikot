package jp.co.fablic.spikot

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import jp.co.fablic.spikot.dynamic.Benri

class SlackEventListener : Listener {
    @EventHandler
    fun onPlayerJoinEvent(event: PlayerJoinEvent) {
        Benri.onPlayerJoinEvent(event);
    }

    @EventHandler
    fun onPlayerQuitEvent(event: PlayerQuitEvent) {
        Benri.onPlayerQuitEvent(event);
    }

    @EventHandler
    fun onPlayerDeathEvent(event: PlayerDeathEvent) {
        Benri.onPlayerDeathEvent(event);
    }

    @EventHandler
    fun onAsyncPlayerChatEvent(event: AsyncPlayerChatEvent) {
      Benri.onAsyncPlayerChatEvent(event);
    }
}
