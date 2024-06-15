package br.com.fiap.challenge.activitys

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NovoEmail(navController: NavController){
    var to by remember { mutableStateOf(value = "") }
    var cc by remember { mutableStateOf(value = "") }
    var cco by remember { mutableStateOf( value ="") }
    var assunto by remember { mutableStateOf( value ="") }
    var body by remember { mutableStateOf(value = "") }

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Nova mensagem")

        OutlinedTextField(
            value = "to", onValueChange ={to=it},
            label = { Text(text = "Para") },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
        )
        OutlinedTextField(
            value = "cc", onValueChange ={ cc=it },
            label = { Text(text = "CC") },
            modifier = Modifier.fillMaxWidth()
            //colors = textFieldColors)
        )
        OutlinedTextField(
            value = "cco", onValueChange ={ cco = it},
            label = { Text(text = "Cco") },
            modifier = Modifier.fillMaxWidth()
            //colors = textFieldColors
        )
        OutlinedTextField(
            value = "assunto", onValueChange ={ assunto = it},
            label = { Text(text = "Assunto") },
            modifier = Modifier.fillMaxWidth()
            //colors = textFieldColors
        )
        OutlinedTextField(
            value = "body",
            onValueChange = { body = it },
            label = { Text(text = "Corpo do email") },
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            maxLines = 50)
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.background(Color.Black)
                    .fillMaxWidth()
            ){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Anexo")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Foto")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Enviar")
                }
            }
        }
    }
}


