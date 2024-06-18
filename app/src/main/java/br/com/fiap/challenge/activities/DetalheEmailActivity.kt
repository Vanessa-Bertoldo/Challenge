package br.com.fiap.challenge.activities

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.challenge.components.TopBar
import br.com.fiap.challenge.database.repository.EmailRepository
import br.com.fiap.challenge.model.Email


@Composable
fun DetalheEmail(navController: NavController, idEmail: String?) {

    Scaffold(
        topBar = {
            TopBar("Detalhes Email", true, navController)
        },
        content = { innerPadding ->

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF024959))
                    .fillMaxHeight()
                    .padding(innerPadding)
            ) {
                val email = buscarEmailId(idEmail?.toLong())


                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF026773),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp),
                    shape = RoundedCornerShape(0.dp),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Text(
                        text = email.nomeAssunto,
                        modifier = Modifier
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF026773),
                    ),
                    shape = RoundedCornerShape(0.dp),
                    border = BorderStroke(1.dp, Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 3.dp)
                ) {
                    Text(
                        text = email.texto,
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.White
                    )
                }

            }


        }
    )


}

@Composable
fun buscarEmailId(idEmail: Long?): Email {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)

    return emailRepository.buscarEmailId(idEmail)
}
