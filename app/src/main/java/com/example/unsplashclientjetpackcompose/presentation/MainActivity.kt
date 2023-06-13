package com.example.unsplashclientjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unsplashclientjetpackcompose.presentation.search_photos.SearchPhotosScreen
import com.example.unsplashclientjetpackcompose.presentation.ui.theme.UnsplashClientJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnsplashClientJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.SearchPhotoScreen.route,
                    ){
                        // 画像検索画面
                        composable(route = ScreenRoute.SearchPhotoScreen.route){
                            SearchPhotosScreen(navController)
                        }
                        // 画像詳細表示画面
                        composable(route = ScreenRoute.PhotoDetailScreen.route + "/{photoId}"){
                            Text(text = "画像詳細表示画面")
                        }
                    }
                }
            }
        }
    }
}

