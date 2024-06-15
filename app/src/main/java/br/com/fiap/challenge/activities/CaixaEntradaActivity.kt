package br.com.fiap.challenge.activities

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaEntrada(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Caixa de entrada",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF012E40))
                .fillMaxHeight()
                .padding(innerPadding)
                .padding(top = 2.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    unfocusedLeadingIconColor = Color.White
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = null
                    )
                },
                value = "Digite o assunto do email",
                onValueChange = {},
            )

            CardEmail()
            CardEmail()
            MenuRodape(navController)
        }
    }
}


@Composable
fun CardEmail() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .height(65.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF024959)),
//                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(1.dp, Color(0xFF024959))
    ) {
        Text(
            modifier = Modifier.padding(start = 5.dp, top = 10.dp),
            text = "KABUM",
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = "PROMOÇÃO RELAMPAGO",
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

    }


}

@Composable
fun MenuRodape(navController: NavController) {

    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
//        topBar = {
//            TopAppBar(
//                colors = topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    titleContentColor = MaterialTheme.colorScheme.primary,
//                ),
//                title = {
//                    Text("Top app bar")
//                }
//            )
//        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF012E40),
                contentColor = Color(0xFF012E40),
            ) {
                Row(){
                    Button(onClick = { navController.navigate("home") }) {
                        Icon(painter = painterResource(id = R.drawable.home_icon), contentDescription = "")
                    }

                    Button(onClick = { navController.navigate("calendario") },) {
                        Icon(painter = painterResource(id = R.drawable.calendar_icon), contentDescription = "")
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





