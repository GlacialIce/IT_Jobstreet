package com.example.itjobstreet.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.itjobstreet.Favorite
import com.example.itjobstreet.HomePageShow
import com.example.itjobstreet.PostingLoker1
import com.example.itjobstreet.ProfilePostingShow
import com.example.itjobstreet.SearchPost

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarNav.Home.route,
    ) {
        //route ke halaman HomePage.kt
        composable(route = BottomBarNav.Home.route ) {
            HomePageShow()
        }

        //route ke halaman SearchPostActivity.kt
        composable(route = BottomBarNav.Search.route) {
            SearchPost()
        }
        //route ke halaman PostingLoker1Activity.kt
        composable(route = BottomBarNav.PostingLoker.route) {
            PostingLoker1()
        }

        //route ke halaman FavoriteActivity.kt
        composable(route = BottomBarNav.Favorite.route) {
            Favorite()
        }

        //route ke halaman ProfilePosting.kt
        composable(route = BottomBarNav.Profile.route) {
            ProfilePostingShow()
        }
    }
}
