package com.example.cimacorner.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.example.cimacorner.presentation.components.MoviesGridList
import com.example.cimacorner.presentation.components.SearchAppBar

@Composable
fun SearchScreen(searchScreenViewModel: SearchScreenViewModel, navController: NavHostController) {
    val searchQuery = searchScreenViewModel.searchQuery.collectAsState().value
    val searchedItems = searchScreenViewModel.searchedItems.collectAsState().value

    Column {
        SearchAppBar(
            text = searchQuery,
            enabl = true,
            onTextChange = {searchScreenViewModel.onChangeSearchQuery(it)},
            onSearchClicked = {searchScreenViewModel.onIconSearchClick()},
        )
        MoviesGridList(searchedItems,navController)
    }
}