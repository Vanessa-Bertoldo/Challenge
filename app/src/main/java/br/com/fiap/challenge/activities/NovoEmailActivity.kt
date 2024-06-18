package br.com.fiap.challenge.activities

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.challenge.R
import br.com.fiap.challenge.components.datePickerComponent
import br.com.fiap.challenge.database.repository.EmailRepository
import br.com.fiap.challenge.model.Email

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NovoEmail(navController: NavController) {

    var to by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }

    var isChecked by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF012E40),
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        "Novo Email",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description",
                                tint = Color.White
                            )
                        }

                    }
                },
                actions = {
                    IconButton(onClick = {
                        sendEmail(
                            navController,
                            to,
                            subject,
                            body,
                            data,
                            context
                        )
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.send_icon),
                            tint = Color.White,
                            contentDescription = "Localized description"
                        )
                    }

                },
            )
        },
        content = { innerPadding ->

            Column(
                modifier = Modifier
                    .background(Color(0xFF026773))
                    .fillMaxHeight()
            ) {

                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    item {
                        TextField(
                            value = to, onValueChange = { to = it },
                            label = { Text(text = "Destinatário") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                        )
                    }

                    item {
                        TextField(
                            value = subject, onValueChange = { subject = it },
                            label = { Text(text = "Assunto") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                        )
                    }

                    item {
                        TextField(
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

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },
                                colors = CheckboxDefaults.colors(checkmarkColor = Color.White, uncheckedColor = Color(0xFF012E40))
                            )
                            Text(text = "Organizar evento para email", color = Color.White)

                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            if (isChecked) {
                                data = datePickerComponent()
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

        }
    )
}

fun sendEmail(
    navController: NavController,
    to: String,
    subject: String,
    body: String,
    data: String,
    context: Context
) {

    val email = Email(
        nomeDestinatario = to,
        nomeAssunto = subject,
        texto = body,
        nomeRemetente = "",
        dataEvento = data
    )

    val emailRepository = EmailRepository(context)
    emailRepository.novoEmail(email)

    navController.navigate("home")
}







