package com.example.cimacorner.presentation.Home


import android.os.Handler
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.NavHostController
import com.example.cimacorner.presentation.components.MoviesGridList
import com.example.cimacorner.presentation.components.NoInternetScreen
import com.example.cimacorner.presentation.components.SearchAppBar
import com.example.cimacorner.presentation.components.ShimmerGridMovies
import com.example.cimacorner.presentation.navigation.Screens
import com.example.cimacorner.ui.theme.BackgroundColor
import com.example.cimacorner.ui.theme.DarkComponentColor1
import com.example.cimacorner.ui.theme.RedComponentColor3
import com.example.cimacorner.ui.theme.RedTextColor
import com.example.cimacorner.ui.theme.TextColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel, navController: NavHostController){



    var doubleBackToExitPressedOnce = false
    val activity = LocalOnBackPressedDispatcherOwner.current as ComponentActivity
    val context = LocalContext.current

    val tabItems = homeScreenViewModel.tabList.collectAsState().value
    val allMovies = homeScreenViewModel.movieList.collectAsState().value
    val filteredMovies = homeScreenViewModel.movieListFiltered.collectAsState().value
    val internetAvailable = homeScreenViewModel.internetAvailable.collectAsState().value


    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()


    // State to control the visibility of ShimmerGridMovies()
    var shimmerVisible by remember { mutableStateOf(true) }


    Scaffold (
        containerColor = BackgroundColor,
        modifier = Modifier.padding(10.dp),
        topBar = {
            SearchAppBar(
                text = "",
                onClicked = {
                            navController.navigate(Screens.Search.route)
                },
            )

        }
    ){
        if (internetAvailable){

            Box(modifier = Modifier.padding(it)){
                HorizontalPager(
                    count = tabItems.size, state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,

                    ) { index ->

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp)

                    ) {
                        // on tab selected or swap using HorizontalPager
                        // Use LaunchedEffect to show ShimmerGridMovies() for 2 seconds

                        LaunchedEffect(index) {
                            shimmerVisible = true
                            delay(1000) // 1 seconds delay
                            shimmerVisible = false
                        }
                        // check if current tab is all or filter.
                        if (tabItems[index].id==-1){
                            if (shimmerVisible || allMovies.isEmpty() ) {
                                // Show ShimmerGridMovies() when shimmerVisible is true or list empty
                                ShimmerGridMovies()
                            } else {
                                // Show MoviesGridList() when shimmerVisible is false or list not empty
                                MoviesGridList(allMovies,navController){
                                    coroutineScope.launch {
                                        tween<Float>(600)
                                        pagerState.animateScrollToPage(
                                            page = (pagerState.currentPage + 1) % (pagerState.pageCount)
                                        )
                                    }

                                }
                            }

                        }else{
                            LaunchedEffect(index){
                                homeScreenViewModel.onSelectingTab(tabItems[index])
                            }
                            if (shimmerVisible || filteredMovies.isEmpty() ) {
                                // Show ShimmerGridMovies() when shimmerVisible is true or list empty
                                ShimmerGridMovies()
                            } else {
                                // Show MoviesGridList() when shimmerVisible is false or list has been filtered complete.
                                MoviesGridList(filteredMovies,navController){
                                    coroutineScope.launch {
                                        tween<Float>(600)
                                        pagerState.animateScrollToPage(
                                            page = (pagerState.currentPage + 1) % (pagerState.pageCount)
                                        )
                                    }
                                }
                            }

                        }


                    }


                }


                ScrollableTabRow(
                    selectedTabIndex = pagerState.currentPage,
                    modifier = Modifier
                        .padding(5.dp)
                        .background(color = Color.Transparent),
                    edgePadding = 0.dp,
                    backgroundColor = BackgroundColor,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier
                                .pagerTabIndicatorOffset(
                                    pagerState,
                                    tabPositions
                                )
                                .width(0.dp)
                                .height(0.dp)
                        )
                    }
                ) {
                    tabItems.forEachIndexed { index, category ->
                        val color = remember {
                            Animatable(RedComponentColor3)
                        }
                        LaunchedEffect(pagerState.currentPage == index) {
                            color.animateTo(if (pagerState.currentPage == index) RedComponentColor3 else DarkComponentColor1)
                        }
                        Tab(
                            text = {
                                Text(
                                    category.name,
                                    style = if (pagerState.currentPage == index) TextStyle(
                                        color = TextColor,
                                        fontSize = 18.sp
                                    )
                                    else TextStyle(
                                        color = RedTextColor,
                                        fontSize = 16.sp
                                    )
                                )
                            },
                            selected = pagerState.currentPage == index,
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .background(
                                    color = color.value,
                                    shape = RoundedCornerShape(24.dp)
                                ),
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }

                            })
                    }

                }

            }





        }
        else{
            NoInternetScreen()
        }




        //Back Handler
        BackHandler(onBack = {
            if (doubleBackToExitPressedOnce) {
                finishAffinity(activity)
            } else {
                doubleBackToExitPressedOnce = true
                Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
                Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
            }
        })
    }
}