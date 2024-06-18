package br.com.fiap.challenge.activities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.challenge.components.CardContent
import br.com.fiap.challenge.components.TopBar
import br.com.fiap.challenge.database.repository.EmailRepository

@Composable
fun EventoActivity(navController: NavController) {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)

    Scaffold(
        topBar = {
            Row {
                TopBar("Eventos", true, navController)
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

            buscarEventos(emailRepository)


        }
    }
}


@Composable
private fun buscarEventos(emailRepository: EmailRepository) {

    var listaEvento = emailRepository.buscarTodosEventos()

    for (i in listaEvento) {
        if (i.dataEvento.isNotEmpty()) {
            CardContent(i.nomeAssunto, i.texto, i.dataEvento)
        }

    }

}
