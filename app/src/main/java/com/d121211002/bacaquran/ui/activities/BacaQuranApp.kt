@file:OptIn(ExperimentalMaterial3Api::class)

package com.d121211002.bacaquran.ui.activities

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.d121211002.bacaquran.R
import com.d121211002.bacaquran.ui.activities.detail.DetailSurahScreen

enum class AppRoute(val route:String){
    Home(route = "Home"),
    Detail(route = "Detail")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BacaQuranApp(
    navController: NavHostController = rememberNavController()
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { BacaQuranTopAppBar(scrollBehavior = scrollBehavior)}
    ) {
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            val bacaQuranViewModel: BacaQuranViewModel =
                viewModel(factory = BacaQuranViewModel.Factory)
            BacaQuranContent(viewModel = bacaQuranViewModel, innerPadding = PaddingValues(16.dp), navController = navController)
        }
    }
}

@Composable
fun BacaQuranContent(
    viewModel: BacaQuranViewModel,
    innerPadding : PaddingValues,
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = AppRoute.Home.name,
    ){
        composable(
            AppRoute.Home.name
        ){
            HomeScreen(
                bacaQuranUiState = viewModel.bacaQuranUiState,
                retryAction = viewModel:: getSurahs,
                navigation = { navController.navigate(AppRoute.Detail.name)
                            println(navController.currentDestination.toString())
                }
            )
        }
        composable(
            AppRoute.Detail.name
        ){
            DetailSurahScreen(
                bacaQuranUiState = viewModel.bacaQuranUiState,
                retryAction = viewModel::getSurah,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BacaQuranTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall)
        },
        modifier = modifier
    )
}