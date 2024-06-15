package br.com.fiap.challenge.activities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DetalheEmail(navController: NavController) {
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
