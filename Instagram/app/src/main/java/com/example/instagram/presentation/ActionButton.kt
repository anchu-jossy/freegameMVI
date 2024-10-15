package com.example.instagram.presentation

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ActionButton(
    icon: ImageVector,
    color: Color = Color.White,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier.background(color)
    ) {
        Icon(imageVector = icon, contentDescription = "")

    }
}