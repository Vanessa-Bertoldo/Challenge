package br.com.fiap.challenge.activities

import android.content.Context
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

        },
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF026773))
                .fillMaxHeight()
                .padding(innerPadding)
                .padding(top = 2.dp)
        ) {
//            OutlinedTextField(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(60.dp)
//                    .padding(bottom = 5.dp),
//                colors = OutlinedTextFieldDefaults.colors(
//                    unfocusedTextColor = Color.White,
//                    unfocusedBorderColor = Color.White,
//                    unfocusedLabelColor = Color.White,
//                    unfocusedLeadingIconColor = Color.White
//                ),
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Search, contentDescription = null
//                    )
//                },
//                value = "Digite o",
//                onValueChange = {
//                },
//            )

            buscarEmails(navController)

            Button(
                onClick = { navController.navigate("novo-email") },
                colors = ButtonDefaults.buttonColors(Color(0xFF012E40)),
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Text(text = "+")

            }


        }
    }
}


@Composable
fun CardEmail(
    idEmail: Long,
    nomeAssunto: String,
    nomeRemetente: String,
    flagImportante: Boolean,
    navController: NavController
) {
    var context = LocalContext.current


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 10.dp, end = 10.dp)
            .height(90.dp)
            .clickable {
                navController.navigate("detalhe-email/$idEmail")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF024959)),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, Color.White)
    ) {
        Column {

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 5.dp, top = 10.dp),
                    text = "De: $nomeRemetente",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,

                    )

                if (flagImportante) {
                    IconButton(onClick = {
                        importanciaEmail(
                            navController,
                            idEmail,
                            context
                        )
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.flag_icon_importante),
                            contentDescription = "flag icon",
                            tint = Color.Red,
                        )
                    }

                } else {

                    IconButton(onClick = {
                        importanciaEmail(
                            navController,
                            idEmail,
                            context
                        )
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.flag_icon),
                            contentDescription = "flag icon",
                            tint = Color.White,
                        )
                    }

                }


            }

            HorizontalDivider(thickness = 1.dp)

            Row {

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 5.dp, top = 5.dp),
                    text = "Assunto: $nomeAssunto",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                IconButton(onClick = {
                    deletarEmail(
                        navController,
                        idEmail,
                        context
                    )
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.delete_icon),
                        contentDescription = "flag icon",
                        tint = Color.White,
                    )
                }

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
        CardEmail(i.id, i.nomeAssunto, i.nomeDestinatario, i.flagImportante, navController)
    }
}

fun importanciaEmail(navController: NavController, idEmail: Long, context: Context) {

    val emailRepository = EmailRepository(context)

    var email = emailRepository.buscarEmailId(idEmail)
    if (email.flagImportante) email.flagImportante = false else email.flagImportante = true
    emailRepository.mudarImportanciaEmail(email)

    navController.navigate("home")
}

fun deletarEmail(navController: NavController, idEmail: Long, context: Context) {

    val emailRepository = EmailRepository(context)

    var email = emailRepository.buscarEmailId(idEmail)

    emailRepository.deletarEmail(email)

    navController.navigate("home")
}


//fun buscarEmailLetra(navController: NavController, palavra: String, context: Context) {
//
//    val emailRepository = EmailRepository(context)
//
//    var email = emailRepository.buscarTodosEmailAssunto(palavra)
//
//    navController.navigate("home")
//}

