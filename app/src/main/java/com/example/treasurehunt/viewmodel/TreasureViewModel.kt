package com.example.treasurehunt.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.treasurehunt.data.Clue
import com.example.treasurehunt.data.ClueRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TreasureViewModel(application: Application) : AndroidViewModel(application) {

    private val _clues = MutableStateFlow<List<Clue>>(emptyList())
    val clues: StateFlow<List<Clue>> = _clues

    private val _currentClueIndex = MutableStateFlow(0)
    val currentClueIndex: StateFlow<Int> = _currentClueIndex

    private val _elapsedTime = MutableStateFlow(0L)
    val elapsedTime: StateFlow<Long> = _elapsedTime

    private var timerRunning = false

    init {
        loadClues()
    }

    private fun loadClues() {
        val repo = ClueRepository()
        _clues.value = repo.loadClues(getApplication())
    }

    fun nextClue() {
        _currentClueIndex.value++
    }

    fun startTimer() {

        if (timerRunning) return
        timerRunning = true

        viewModelScope.launch {

            while (timerRunning) {
                delay(1000)
                _elapsedTime.value += 1
            }

        }
    }

    fun stopTimer() {
        timerRunning = false
    }

    fun resetTimer() {
        _elapsedTime.value = 0
    }
}