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

    var teamAName by mutableStateOf("Team A")
        private set

    var teamBName by mutableStateOf("Team B")
        private set

    var winningTeam by mutableStateOf<String?>(null)
        private set

    var gameOver by mutableStateOf(false)
        private set

    fun incrementScore(isTeamA: Boolean) {
        if (gameOver) return

        if (isTeamA) {
            scoreA++
            if (scoreA >= 10) {
                winningTeam = teamAName
                gameOver = true
            }
        } else {
            scoreB++
            if (scoreB >= 10) {
                winningTeam = teamBName
                gameOver = true
            }
        }
    }

    fun resetScores() {
        scoreA = 0
        scoreB = 0
        winningTeam = null
        gameOver = false
    }

    fun setTeamNames(nameA: String, nameB: String) {
        teamAName = nameA
        teamBName = nameB
    }
}
