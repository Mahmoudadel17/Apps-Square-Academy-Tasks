package com.example.cimacorner.presentation.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cimacorner.presentation.SearchAppBar

@Composable
fun HomeScreen() {

    Scaffold (
        topBar = {
            SearchAppBar(text = "")
        }
    ){
        Box(modifier = Modifier.padding(it))
    }
}