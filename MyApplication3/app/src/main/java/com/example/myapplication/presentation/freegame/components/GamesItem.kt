package com.example.myapplication.presentation.freegame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.myapplication.domain.model.FreeGames

@Composable
fun GamesItem(modifier: Modifier, games: FreeGames) {
        Column(modifier = modifier
        .padding(16.dp)
        .fillMaxWidth())  {
            Card(elevation = CardDefaults.cardElevation(4.dp), shape = RoundedCornerShape(16.dp)) {

            Column(modifier=Modifier.padding(8.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,)
            {
            AsyncImage(
                modifier = modifier.fillMaxWidth(),
                model = games.thumbnail,
                contentDescription = null, contentScale = ContentScale.Crop
            )

                Text(
                    text = games.title,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center, // Center text within its bounds
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Center horizontally within the Column
                )
                Text(modifier = Modifier.fillMaxWidth(),text = games.short_description)
        }
        }
    }

}