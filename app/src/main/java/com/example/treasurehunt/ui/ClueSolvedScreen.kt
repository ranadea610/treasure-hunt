package com.example.treasurehunt.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.example.treasurehunt.viewmodel.TreasureViewModel

@Composable
fun ClueSolvedScreen(
    navController: NavController,
    viewModel: TreasureViewModel = viewModel()
){

    val clues by viewModel.clues.collectAsState()
    val index by viewModel.currentClueIndex.collectAsState()

    val clue = clues[index]

    Column(modifier = Modifier.padding(20.dp)) {

        Text("Clue Solved!", fontSize = 26.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Text(clue.info)

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {

            viewModel.nextClue()
            navController.navigate("clue")

        }) {
            Text("Continue")
        }
    }
}