package com.example.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.instagram.data.remote.Post
import com.example.instagram.data.remote.PostItem
import com.example.instagram.presentation.ActionButton
import com.example.instagram.presentation.PostViewModel
import com.example.instagram.presentation.SwipeableItemWithActions
import com.example.instagram.ui.theme.InstagramTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            InstagramTheme {
                PostScreen()

            }

        }
    }
}

@Composable
fun PostScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val viewModel: PostViewModel = hiltViewModel()
        val state = viewModel.stateFlow.collectAsState()

        LazyColumn {
            items(state.value.post, key = {
                it.id
            }) {
                SwipeableItemWithActions(
                    isRevealed = it.isOptionsRevealed,
                    actions = {
                        ActionButton(icon = Icons.Default.Delete,
                            modifier = Modifier
                                .fillMaxHeight()
                                .background(Color.Red),
                            onClick = {

                            })
                        ActionButton(icon = Icons.Default.Share, modifier = Modifier
                            .fillMaxHeight()
                         , onClick = {

                        })
                        ActionButton(icon = Icons.Default.Send, modifier = Modifier
                            .fillMaxHeight()
                            , onClick = {

                        })

                    },
                    onCollapsed = { /*TODO*/ },
                    onExpanded = { /*TODO*/ }, content = {
                        PostCard(it)
                    }

                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCard(post: PostItem) {
    Card(
        modifier = Modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .wrapContentSize()
            .clip(RoundedCornerShape(10.dp)),
        onClick = { /*TODO*/ },
        elevation = CardDefaults.elevatedCardElevation(10.dp),


        ) {
        Column {
            Row(modifier = Modifier.wrapContentSize()) {
                Text(
                    modifier = Modifier
                        .weight(.7f)
                        .padding(top = 20.dp, bottom = 10.dp, start = 10.dp, end = 10.dp),
                    text = post.title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Image(

                    painter = painterResource(id = R.drawable.philipp),
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
                        .weight(.3f)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(100)),
                    contentDescription = ""
                )

            }
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp, top = 10.dp),
                text = post.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

