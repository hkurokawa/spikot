package jp.co.fablic.spikot

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class SlackEventListener : Listener {
    @EventHandler
    fun onPlayerJoinEvent(event: PlayerJoinEvent) {
        SlackNotifier().postMessage(event.joinMessage, "#ace639")
    }

    @EventHandler
    fun onPlayerQuitEvent(event: PlayerQuitEvent) {
        SlackNotifier().postMessage(event.quitMessage, "#69b4c8")
    }

    @EventHandler
    fun onPlayerDeathEvent(event: PlayerDeathEvent) {
        SlackNotifier().postMessage(event.deathMessage, "#ff8066")
    }

    @EventHandler
    fun onAsyncPlayerChatEvent(event: AsyncPlayerChatEvent) {
        SlackNotifier().postMessage(String.format(event.format, event.player.displayName, event.message))
    }
}
