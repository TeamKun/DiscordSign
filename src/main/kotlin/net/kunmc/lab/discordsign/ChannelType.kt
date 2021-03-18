package net.kunmc.lab.discordsign

enum class ChannelType(val id: String, val token: String) {
    COMMENT("comment_webhook_id", "comment_webhook_token"),
    COMMAND("command_webhook_id", "command_webhook_token"),
    SIGN("sign_webhook_id", "sign_webhook_token");
}