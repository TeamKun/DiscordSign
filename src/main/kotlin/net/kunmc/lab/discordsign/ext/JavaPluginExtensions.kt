package net.kunmc.lab.discordsign.ext

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

fun JavaPlugin.registerListener(listener: Listener) {
    server.pluginManager.registerEvents(listener, this)
}