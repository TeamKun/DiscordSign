package net.kunmc.lab.discordsign

import net.kunmc.lab.discordsign.ext.registerListener
import net.kunmc.lab.discordsign.listener.DiscordListener
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.annotation.plugin.ApiVersion
import org.bukkit.plugin.java.annotation.plugin.Plugin
import org.bukkit.plugin.java.annotation.plugin.author.Author

@Plugin(name = "DiscordSign", version = "1.0-SNAPSHOT")
@Author("ReyADayer")
@ApiVersion(ApiVersion.Target.v1_15)
class DiscordSign : JavaPlugin() {
    override fun onEnable() {
        saveDefaultConfig()
        registerListener(DiscordListener(this))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}