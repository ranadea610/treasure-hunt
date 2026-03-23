package com.example.treasurehunt.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.treasurehunt.viewmodel.TreasureViewModel

@Composable
fun StartScreen(
    navController: NavController,
    viewModel: TreasureViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Corvallis Treasure Hunt", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Rules:\nFind each location using the clues.\nPress 'Found It' when you arrive."
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {

            viewModel.resetTimer()
            viewModel.startTimer()

            navController.navigate("clue")

        }) {
            Text("Start Hunt")
        }
    }
}