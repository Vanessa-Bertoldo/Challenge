package br.com.fiap.challenge.activities

import android.content.Context
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import br.com.fiap.challenge.model.Email
import br.com.fiap.challenge.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun CaixaEntrada(navController: NavController) {

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                // ...other drawer items
            }
        }
    ) {

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
}


@Composable
fun CardEmail(
    idEmail: String,
    nomeAssunto: String?,
    corpo: String?,
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
                navController.navigate("detalhe-email/$nomeAssunto/$corpo")
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

                        val call = RetrofitFactory().getEmailService().atualizarImportancia(idEmail)
                        call.enqueue(object : Callback<Void> {

                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                                emailsState.value = response.body()!!
                                navController.navigate("home")
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) {
                                Log.e("onFailure", "Error: ${t.message}")
                            }
                        })
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.flag_icon_importante),
                            contentDescription = "flag icon",
                            tint = Color.Red,
                        )
                    }

                } else {

                    IconButton(onClick = {

                        val call = RetrofitFactory().getEmailService().atualizarImportancia(idEmail)
                        call.enqueue(object : Callback<Void> {

                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                                emailsState.value = response.body()!!
                                navController.navigate("home")
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) {
                                Log.e("onFailure", "Error: ${t.message}")
                            }
                        })
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
    val emailsState = remember { mutableStateOf<List<Email>>(emptyList()) } // Estado reativo

    // Buscar emails - API
    LaunchedEffect(Unit) {

        val call = RetrofitFactory().getEmailService().getAllEmails("vanessa@123")
        call.enqueue(object : Callback<List<Email>> {
            override fun onResponse(call: Call<List<Email>>, response: Response<List<Email>>) {
                emailsState.value = response.body()!!
            }

            override fun onFailure(call: Call<List<Email>>, t: Throwable) {
                Log.e("onFailure", "Error: ${t.message}")
            }
        })
    }

    if (emailsState.value.isNotEmpty()) {
        LazyColumn {
            items(5) { index ->
                val email = emailsState.value[index]
                CardEmail(
                    email.id,
                    email.nomeAssunto ?: "Sem assunto",
                    email.texto,
                    email.nomeRemetente,
                    email.flagImportante,
                    navController
                )
            }
        }
    }
}

fun deletarEmail(navController: NavController, idEmail: String, context: Context) {
//
//    val emailRepository = EmailRepository(context)
//
//    var email = emailRepository.buscarEmailId(idEmail)
//
//    emailRepository.deletarEmail(email)
//
//    navController.navigate("home")
}


//fun buscarEmailLetra(navController: NavController, palavra: String, context: Context) {
//
//    val emailRepository = EmailRepository(context)
//
//    var email = emailRepository.buscarTodosEmailAssunto(palavra)
//
//    navController.navigate("home")
//}

