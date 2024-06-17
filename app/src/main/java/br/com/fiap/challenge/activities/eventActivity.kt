
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.challenge.components.TopBar

@Composable
fun EventActivity(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(titulo = "Novo Evento", voltarON = true, navController = navController)
        },
        content = { innerPadding ->
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
                    .background(color = Color.LightGray)
            ) {
                item {
                    TextField(
                        value = "",
                        onValueChange = { /* Handle title change */ },
                        label = { Text("Título") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }
                item {
                    TextField(
                        value = "",
                        onValueChange = { /* Handle end date change */ },
                        label = { Text("Data Fim") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }
                item {
                    TextField(
                        value = "",
                        onValueChange = { /* Handle start date change */ },
                        label = { Text("Data Início") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }
                item {
                    TextField(
                        value = "",
                        onValueChange = { /* Handle description change */ },
                        label = { Text("Descrição") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp) // Larger height for description
                            .padding(bottom = 8.dp)
                    )
                }
            }
        }
    )
}

