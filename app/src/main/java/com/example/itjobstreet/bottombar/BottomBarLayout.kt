package com.example.itjobstreet.bottombar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.itjobstreet.ui.theme.ITJobstreetTheme

@Composable
fun BottomBar1() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            MyBottomBar(navController)
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize()
        ) {
            SetupNavGraph(navController = navController)
        }
    }

}

// bottom bar implementation
@Composable
fun MyBottomBar(navController: NavHostController) {
    val navigationItems = listOf(
        BottomBarNav.Home,
        BottomBarNav.Search,
        BottomBarNav.PostingLoker,
        BottomBarNav.Favorite,
        BottomBarNav.Profile,
    )

    var selectedIcon by remember {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = White,
        modifier = Modifier
            .height(60.dp)
            .drawBehind {
                val strokeWidth = 1f
                val x = size.width - strokeWidth

                //top line navbar
                drawLine(
                    color = Gray,
                    start = Offset(0f, 0f), //(0,0) at top-left point of the box
                    end = Offset(x, 0f), //top-right point of the box
                    strokeWidth = strokeWidth
                )
            }

    ) {
        navigationItems.forEachIndexed { index, screen ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF2493DC),
                    unselectedIconColor = Gray,
                    indicatorColor = Color(0xFFEEEEEE)
                ),
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                //kalo navigation barnya mau dibuat nama" dari iconnya, pake label
//                label = { Text(text = screen.name) },  //name nya dibuat di sealed class
                selected = (selectedIcon == index),
                onClick = {
                    // this if condition keeps only one screen in the back stack
                    if (navController.currentBackStack.value.size >= 2) {
                        navController.popBackStack()
                    }
                    selectedIcon = index
                    navController.navigate(screen.route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    ITJobstreetTheme {
        BottomBar1()
    }
}