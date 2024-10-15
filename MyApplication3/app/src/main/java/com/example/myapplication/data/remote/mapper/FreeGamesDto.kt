package com.example.myapplication.data.remote.mapper

import com.example.myapplication.data.remote.mapper.dto.FreeGamesDtoItem
import com.example.myapplication.domain.model.FreeGames

fun FreeGamesDtoItem.toDomainFreeGames(): FreeGames {
    return FreeGames(game_url, id, short_description, thumbnail, title)
}
