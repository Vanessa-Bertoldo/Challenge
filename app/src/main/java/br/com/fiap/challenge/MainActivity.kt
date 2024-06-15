package br.com.fiap.challenge

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.challenge.activities.CaixaEntrada
import br.com.fiap.challenge.activities.CalendarView
import br.com.fiap.challenge.activities.DetalheEmail
import br.com.fiap.challenge.ui.theme.ChallengeTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable(route = "home") {
                            CaixaEntrada(navController)
                        }
                        composable(route = "novo-email") {
                            CaixaEntrada(navController)
                        }
                        composable(route = "calendario") {
                            CalendarView(navController)
                        }
                        composable(route = "detalhe-email") {
                            DetalheEmail(navController)
                        }
                    }
                }

            }

        }

    }
}


