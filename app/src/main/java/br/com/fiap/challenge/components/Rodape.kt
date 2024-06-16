package br.com.fiap.challenge.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.challenge.R

@Composable
fun Rodape(navController: NavController) {

    var presses by remember { mutableIntStateOf(0) }

    Scaffold(

        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF012E40),
                contentColor = Color(0xFF012E40),
            ) {
                Row() {
                    Button(onClick = { navController.navigate("home") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.home_icon),
                            contentDescription = ""
                        )
                    }

                    Button(onClick = { navController.navigate("calendario") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.calendar_icon),
                            contentDescription = ""
                        )
                    }

                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("novo-email") }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
        }

    }
}