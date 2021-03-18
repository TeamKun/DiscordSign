package net.kunmc.lab.discordsign.api

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.kunmc.lab.discordsign.ChannelType
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import retrofit2.HttpException

class Messenger(private val service: DiscordService) {
    fun send(
            player: Player,
            message: String,
            channelType: ChannelType,
            plugin: JavaPlugin
    ) {
        GlobalScope.launch {
            try {
                val name = player.name
                val image = "https://crafatar.com/avatars/${player.uniqueId}"
                val id = plugin.config.getString(channelType.id)
                val token = plugin.config.getString(channelType.token)
                if (id != null && token != null) {
                    service.send(id, token, message, name, image)
                }
            } catch (e: HttpException) {
            } catch (e: Exception) {
            }
        }
    }
}