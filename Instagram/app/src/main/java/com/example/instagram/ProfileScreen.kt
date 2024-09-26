package com.example.instagram

import android.graphics.drawable.PaintDrawable
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.ui.theme.Shapes

data class ImageWithText(val text: String, val image: ImageVector)

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar()
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(.2f)
            ) {
                Image(
                    painterResource(id = R.drawable.philipp),
                    contentDescription = " ",
                    modifier = Modifier
                        .aspectRatio(1f, matchHeightConstraintsFirst = true)
                        .clip(
                            RoundedCornerShape(100.dp)
                        )
                )
            }
            Row(
                modifier = Modifier
                    .weight(.8f)
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(.3f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "601",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold

                    )
                    Text(text = "Post", color = Color.Black)

                }
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(.3f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "601",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold

                    )
                    Text(text = "Post", color = Color.Black)

                }
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(.3f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "601",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Post", color = Color.Black)

                }
            }
        }
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                "Programming language",
                color = Color.Black, fontWeight = FontWeight.Bold
            )
            val letterSpacing = 0.5.sp
            val lineHeight = 20.sp
            Text(
                text = "10 years of coding experience\n" +
                        "Want me to make your app? Send me an email!\n" +
                        "Subscribe to my YouTube channel!",

                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
            Text(text = buildAnnotatedString {
                val style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)
                pushStyle(style)
                this.append("Subscribe")
                pop()
                this.append("10 followers")

            })

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(modifier = Modifier

                    .padding(3.dp), shape = RoundedCornerShape(10.dp),
                    onClick = {
                    }) {
                    Text(text = "Following", color = Color.Black)
                    Icon(
                        Icons.Filled.ArrowDropDown,
                        contentDescription = "Localized description",
                        tint = Color.Black
                    )
                }
                OutlinedButton(modifier = Modifier

                    .padding(3.dp), shape = RoundedCornerShape(10.dp),
                    onClick = { /* doSomething() */ }) {
                    Text(text = "Message", color = Color.Black)
                }
                OutlinedButton(modifier = Modifier

                    .padding(3.dp), shape = RoundedCornerShape(10.dp),
                    onClick = { /* doSomething() */ }) {
                    Text(text = "Email", color = Color.Black)
                }
                OutlinedButton(modifier = Modifier.padding(3.dp), shape = RoundedCornerShape(10.dp),
                    onClick = { /* doSomething() */ }) {
                    Icon(
                        Icons.Filled.ArrowDropDown,
                        tint = Color.Black,
                        contentDescription = "Localized description"
                    )
                }
            }


            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(100.dp)),
                        painter = painterResource(id = R.drawable.philipp),
                        contentDescription = ""
                    )
                    Text(text = "Youtube")
                }
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(100.dp)),
                        painter = painterResource(id = R.drawable.philipp),
                        contentDescription = ""
                    )
                    Text(text = "Youtube")
                }
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(100.dp))
                            .border(3.dp, Color.Gray),
                        painter = painterResource(id = R.drawable.philipp),
                        contentDescription = ""
                    )
                    Text(text = "Youtube")
                }
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(100.dp)),
                        painter = painterResource(id = R.drawable.philipp),
                        contentDescription = ""
                    )
                    Text(text = "Youtube")
                }


            }
            Spacer(modifier = Modifier.height(10.dp))
            var selectedTabIndex by remember {

                mutableStateOf(0)
            }
            var tabList = listOf(
                ImageWithText(
                    image = Icons.Filled.Person,
                    text = "Posts"
                ),
                ImageWithText(
                    image = Icons.Filled.Favorite,
                    text = "Reels"
                ),
                ImageWithText(
                    image = Icons.Filled.CheckCircle,
                    text = "IGTV"
                ),
            )
            TabRow(containerColor = Color.Transparent, selectedTabIndex = selectedTabIndex) {
                tabList.forEachIndexed { index, tab ->

                    Tab(selected = selectedTabIndex == index,
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.Gray,
                        onClick = { selectedTabIndex = index }, text = {
                            Text(text = tab.text)
                        }, icon = {
                            Icon(imageVector = tab.image, contentDescription = null)
                        })

                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .scale(1.01f)
            ) {
                items(100) {
                    Image(
                        modifier = Modifier.border(1.dp, Color.Green),
                        painter = painterResource(id = R.drawable.philipp),
                        contentDescription = ""
                    )

                }
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(title = {
        Text(text = " Anchu_official ", color = Color.Black)
    }, navigationIcon = {
        IconButton(onClick = { }) {
            Icon(Icons.Filled.ArrowBack, null)
        }
    }, actions = {
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Notifications, null)
        }
        IconButton(onClick = { }) {
            Icon(Icons.Filled.MoreVert, null)
        }
    })
}

