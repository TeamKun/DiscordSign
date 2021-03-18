package net.kunmc.lab.discordsign.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface DiscordService {
    @FormUrlEncoded
    @POST("{id}/{token}")
    suspend fun send(@Path("id") id: String,
                     @Path("token") token: String,
                     @Field("content") content: String,
                     @Field("username") username: String,
                     @Field("avatar_url") avatar_url: String)
}