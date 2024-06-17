package br.com.fiap.challenge.activities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.challenge.components.TopBar
import br.com.fiap.challenge.database.repository.EmailRepository
import br.com.fiap.challenge.model.Email

@Composable
fun NovoEmail(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }
    var to by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)

    fun sendEmail(navController: NavController) {

        if (to.isEmpty() || subject.isEmpty() || body.isEmpty()) {
            message = "Os campos Para, Assunto e Corpo do email são obrigatórios."
            showMessage = true
            return
        }

        val email = Email(
            //id = 1,
            nomeDestinatario = to,
            nomeAssunto = subject,
            texto = body,
            nomeRemetente = ""
        )

        val emailId = emailRepository.novoEmail(email)

        if (emailId > 0) {
            message = "Email enviado com sucesso!"
        } else {
            message = "Erro ao enviar email."
        }
        showMessage = true
        navController.navigate("home")
    }

    fun createEvent(navController: NavController){
        navController.navigate("event")
    }

    Scaffold(
        topBar = {
            TopBar(titulo = "Novo Email", voltarON = true, navController = navController)
        },
        content = { innerPadding ->
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
                    .background(color = Color.LightGray),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    OutlinedTextField(
                        value = to, onValueChange = { to = it },
                        label = { Text(text = "Destinatário") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White),
                    )
                }

                item {
                    OutlinedTextField(
                        value = subject, onValueChange = { subject = it },
                        label = { Text(text = "Assunto") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    OutlinedTextField(
                        value = body,
                        onValueChange = { body = it },
                        label = { Text(text = "Corpo do email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp),
                        maxLines = 50
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .background(Color.Black)
                            .fillMaxWidth()
                    ) {
                        Button(
                            onClick = { sendEmail(navController) },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Enviar")
                        }
                        Button(
                            onClick = { createEvent(navController) },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Adicionar Evento")
                        }
                    }
                }

                if (showMessage) {
                    item {
                        Text(
                            text = message,
                            color = if (message.contains("sucesso")) Color.Green else Color.Red,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    )

}

