package com.rian.skorsepakbola

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkorSepakBolaApp()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SkorSepakBolaApp(viewModel: ScoreViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("SepakBola Score", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                backgroundColor = Color(0xFF0D47A1),
                contentColor = Color.White
            )
        }
    ) {
        ScoreScreen(viewModel)
    }
}

@Composable
fun ScoreScreen(viewModel: ScoreViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TeamScore("Team A", viewModel.scoreA) { viewModel.incrementScore(true) }
            Divider(modifier = Modifier.height(160.dp).width(4.dp), color = Color.Gray)
            TeamScore("Team B", viewModel.scoreB) { viewModel.incrementScore(false) }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { viewModel.resetScores() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFD32F2F)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("RESET", fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@Composable
fun TeamScore(teamName: String, score: Int, onScoreChange: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
            .width(140.dp)
    ) {
        Text(teamName, style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold, color = Color(0xFF0D47A1))
        Text(score.toString(), style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onScoreChange,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF388E3C)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("+1", fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}