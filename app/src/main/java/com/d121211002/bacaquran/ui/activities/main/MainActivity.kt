package com.d121211002.bacaquran.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d121211002.bacaquran.ui.activities.BacaQuranApp
import com.d121211002.bacaquran.ui.theme.BacaQuranTheme
import com.d121211002.bacaquran.ui.viewmodel.BacaQuranViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel : BacaQuranViewModel = viewModel(factory= BacaQuranViewModel.Factory)
            val uiState by viewModel.tempState.collectAsState()
            BacaQuranTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BacaQuranApp(viewModel=viewModel,uiState=uiState)
                }
            }
        }
    }
}

