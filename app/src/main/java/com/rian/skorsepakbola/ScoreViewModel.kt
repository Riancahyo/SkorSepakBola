package com.rian.skorsepakbola

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var scoreA by mutableStateOf(0)
        private set

    var scoreB by mutableStateOf(0)
        private set

    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
            scoreA++  // UI akan otomatis update
        } else {
            scoreB++
        }
    }

    fun resetScores() {
        scoreA = 0
        scoreB = 0
    }
}
