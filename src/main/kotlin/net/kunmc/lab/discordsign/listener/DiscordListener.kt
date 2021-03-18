package net.kunmc.lab.discordsign.listener

import net.kunmc.lab.discordsign.ChannelType
import net.kunmc.lab.discordsign.Constants
import net.kunmc.lab.discordsign.api.DiscordService
import net.kunmc.lab.discordsign.api.Messenger
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.SignChangeEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.java.JavaPlugin
import retrofit2.Retrofit


class DiscordListener(private val plugin: JavaPlugin) : Listener {
    private val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .build()

    private val service = retrofit.create(DiscordService::class.java)

    private val messenger = Messenger(service)

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val message = "サーバーにログインしました"
        messenger.send(event.player, message, ChannelType.COMMENT, plugin)
    }

    @EventHandler
    fun executeCommand(event: PlayerCommandPreprocessEvent) {
        val message = "${event.message} コマンドを実行しました"
        messenger.send(event.player, message, ChannelType.COMMAND, plugin)
    }

    @EventHandler
    fun talkPlayer(event: AsyncPlayerChatEvent) {
        val message = "「${event.message}」"
        messenger.send(event.player, message, ChannelType.COMMENT, plugin)
    }

    @EventHandler
    fun logoutPlayer(event: PlayerQuitEvent) {
        val message = "ログアウトしました"
        messenger.send(event.player, message, ChannelType.COMMENT, plugin)
    }

    @EventHandler
    fun onSignEvent(event: SignChangeEvent) {
        val location = event.block.location
        val lines = event.lines
        val message = "${location.world?.name} x:${location.x} y:${location.y} z:${location.z} に ${lines.joinToString(",")} の看板を設置しました"
        messenger.send(event.player, message, ChannelType.SIGN, plugin)
    }
}