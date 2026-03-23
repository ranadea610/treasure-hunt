package com.example.treasurehunt.ui

import android.widget.Toast

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.example.treasurehunt.viewmodel.TreasureViewModel
import com.example.treasurehunt.utils.haversineDistance
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.treasurehunt.utils.getCurrentLocation

@Composable
fun ClueScreen(
    navController: NavController,
    viewModel: TreasureViewModel = viewModel()
) {
    val elapsedTime by viewModel.elapsedTime.collectAsState()
    val context = LocalContext.current
    val clues by viewModel.clues.collectAsState()
    val index by viewModel.currentClueIndex.collectAsState()

    val clue = clues[index]

    Column(modifier = Modifier.padding(20.dp)) {

        Text(
            "Time: ${elapsedTime}s",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Clue:", fontSize = 24.sp)

        Text(clue.clue)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            // Show hint
            Toast.makeText(
                context,
                clue.hint,
                Toast.LENGTH_LONG
            ).show()

        }) {
            Text("Hint")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            getCurrentLocation(context) { userLat, userLon ->

                val distance = haversineDistance(
                    userLat,
                    userLon,
                    clue.latitude,
                    clue.longitude
                )

                if (distance < 15) {

                    if (index < clues.size - 1) {
                        navController.navigate("solved")
                    } else {
                        navController.navigate("completed")
                    }

                } else {

                    Toast.makeText(
                        context,
                        "Not quite there yet!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }) {
            Text("Found It!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate("start")
        }) {
            Text("Quit")
        }
    }
}