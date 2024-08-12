package com.app.testapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.app.testapplication.R
import com.app.testapplication.ui.theme.BlackColor
import kotlinx.serialization.Serializable

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val entries = BottomNavigation.mainEntries

    Row(
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .zIndex(1f)
            .fillMaxWidth()
            .clip(CircleShape)
            .background(Color.White)
            .padding(8.dp)
    ) {

        entries.forEachIndexed { index, item ->
            val isSelected = selectedItem == index
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = "icon",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(if (isSelected) BlackColor else Color.White)
                    .padding(8.dp)
                    .clickable {
                        selectedItem = index
                    },
                tint = if (isSelected) Color.White else BlackColor
            )
        }
    }
}

@Serializable
sealed class BottomNavigation(val icon: Int) {
    @Serializable
    data object Home : BottomNavigation(
        icon = R.drawable.ic_bookmark_,
    )

    @Serializable
    data object Menu : BottomNavigation(
        icon = R.drawable.ic_tv,
    )

    @Serializable
    data object Table : BottomNavigation(
        icon = R.drawable.ic_bell,
    )

    @Serializable
    data object Order : BottomNavigation(
        icon = R.drawable.ic_user,
    )

    companion object {
        val mainEntries = listOf(Home, Menu, Table, Order)
    }
}
