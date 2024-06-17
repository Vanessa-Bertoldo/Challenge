package br.com.fiap.challenge.activities

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.R
import br.com.fiap.challenge.components.TopBar
import br.com.fiap.challenge.database.repository.EmailRepository


@Composable
fun CaixaEntrada(navController: NavController) {
    Scaffold(
        topBar = {
            Row {
                TopBar("Caixa de Entrada", false, navController)
            }
            
        },
        floatingActionButton = {
//            FloatingActionButton(onClick = { navController.navigate("novo-email") }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
            FloatingActionButton(
                onClick = { navController.navigate("calendario") },
                containerColor = Color(0xFF012E40)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar_icon),
                    contentDescription = "",
                    tint = Color.White
                )
            }

        }


    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF024959))
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

            buscarEmails(navController)

            Button(onClick = { navController.navigate("novo-email") },
                colors = ButtonDefaults.buttonColors(Color(0xFF026773),),
                modifier = Modifier.padding(top = 5.dp)) {
                Text(text = "+")

            }
        }
    }
}


@Composable
fun buscarEmails(navController: NavController) {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)

    var listaEmail = emailRepository.buscarTodosEmail()

    for (i in listaEmail) {
        CardEmail(i.id, i.nomeAssunto, i.nomeDestinatario, navController)
    }
}


@Composable
fun CardEmail(
    idEmail: Long,
    nomeAssunto: String,
    nomeRemetente: String,
    navController: NavController
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .height(65.dp)
            .clickable {
                navController.navigate("detalhe-email/$idEmail")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF026773)),
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(1.dp, Color.White)
    ) {
        Text(
            modifier = Modifier.padding(start = 5.dp, top = 10.dp),
            text = nomeRemetente,
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = nomeAssunto,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}