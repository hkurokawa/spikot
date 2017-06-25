package jp.co.fablic.spikot

import org.bukkit.plugin.java.JavaPlugin

class MainPlugin : JavaPlugin() {
    override fun onEnable() {
        val ip = server.ip.takeUnless { it.isNullOrEmpty() } ?: "not specified"
        SlackNotifier().postMessage("Server launched. IP: " + ip)

        server.pluginManager.registerEvents(SlackEventListener(), this)
    }

    override fun onDisable() {
        SlackNotifier().postMessage("Server stopped.")
    }
}
