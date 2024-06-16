package br.com.fiap.challenge.activities

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScheduleActivity(day: Int, month: Int, year: Int, navController: NavController) {
    Log.d("ScheduleActivity", "Received day: $day, month: $month, year: $year")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Detalhes do Dia", fontSize = 24.sp, style = TextStyle(color = Color.Black))
        Spacer(modifier = Modifier.height(16.dp))
        BasicText(text = "Dia: $day", style = TextStyle(fontSize = 18.sp))
        BasicText(text = "Mês: $month", style = TextStyle(fontSize = 18.sp))
        BasicText(text = "Ano: $year", style = TextStyle(fontSize = 18.sp))
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Voltar")
        }
    }
}
