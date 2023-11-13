package com.example.itjobstreet.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarNav(val route: String, val name: String, val icon: ImageVector) {
    object Home: BottomBarNav(route = "home_page", name = "Home", icon = Icons.Default.Home)
    object Search: BottomBarNav(route = "search", name = "Search", icon = Icons.Default.Search)
    object PostingLoker: BottomBarNav(route = "posting_loker", name = "Posting Loker", icon = Icons.Default.AddCircle)
    object Favorite: BottomBarNav(route = "favorite", name = "Notification", icon = Icons.Default.FavoriteBorder)
    object Profile: BottomBarNav(route = "profile", name = "Profile", icon = Icons.Default.Person)
}