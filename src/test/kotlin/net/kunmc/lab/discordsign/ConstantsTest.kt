package net.kunmc.lab.discordsign

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ConstantsTest {
    @Test
    fun test() {
        assertEquals("https://discordapp.com/api/webhooks/", Constants.BASE_URL)
    }
}