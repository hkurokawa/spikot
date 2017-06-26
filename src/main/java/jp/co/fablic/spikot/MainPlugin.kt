package jp.co.fablic.spikot

import org.bukkit.plugin.java.JavaPlugin

class MainPlugin : JavaPlugin() {
    override fun onEnable() {
        SlackNotifier().postMessage("Server launched.", "#cccccc")
        server.pluginManager.registerEvents(SlackEventListener(), this)
    }

    override fun onDisable() {
        SlackNotifier().postMessage("Server stopped.", "#cccccc")
    }
}
