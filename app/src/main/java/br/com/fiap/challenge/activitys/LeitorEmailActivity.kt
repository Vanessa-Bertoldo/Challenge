package br.com.fiap.challenge.activitys

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challenge.activitys.ui.theme.ChallengeTheme

class LeitorEmailActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            br.com.fiap.challenge.ui.theme.ChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaLeitorEmail()
                }
            }
        }
    }

@Composable
fun TelaLeitorEmail() {
    Column() {
        Text(
            text = "Agenda da Reunião",
            fontSize = 24.sp
        )
        Row {
            Column(Modifier.padding(vertical = 10.dp)) {
                Text(
                    text = "De: João",
                    fontSize = 20.sp
                )
            }
        }
        Row {
            Column() {
                Text(
                    text = "Menssagem:",
                    fontSize = 20.sp
                )
            }
        }
        Row {
            Column() {
                Text(
                    text = "Próxima reunião dia 15/06/24",
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MeuComponentePreview() {
    TelaLeitorEmail()
}