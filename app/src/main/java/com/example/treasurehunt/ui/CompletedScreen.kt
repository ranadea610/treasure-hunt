package com.example.treasurehunt.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.treasurehunt.viewmodel.TreasureViewModel

@Composable
fun CompletedScreen(
    navController: NavController,
    viewModel: TreasureViewModel = viewModel()
) {

    val elapsedTime by viewModel.elapsedTime.collectAsState()

    viewModel.stopTimer()

    Column(modifier = Modifier.padding(20.dp)) {

        Text("🎉 Treasure Hunt Completed!", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Final Time: ${elapsedTime} seconds")

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            navController.navigate("start")
        }) {
            Text("Home")
        }
    }
}