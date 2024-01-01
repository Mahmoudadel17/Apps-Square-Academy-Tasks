package com.example.cimacorner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.cimacorner.presentation.HomeActivity
import com.example.cimacorner.presentation.SplashScreen
import com.example.cimacorner.presentation.components.TextWithFontSharp
import com.example.cimacorner.presentation.navigation.AppNavigation
import com.example.cimacorner.presentation.navigation.Screens
import com.example.cimacorner.ui.theme.CimaCornerTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CimaCornerTheme {
                val systemUiController: SystemUiController = rememberSystemUiController()
                systemUiController.isSystemBarsVisible = false // Status & Navigation bars

                SplashScreen()

                LaunchedEffect(Unit ){
                    delay(2000)

                    // go to home screen
                    val intent = Intent(this@MainActivity, HomeActivity::class.java)

                    startActivity(intent)

                    // clear current activity from back stack.
                    finish()


                }

            }
        }
    }
}
