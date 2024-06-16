package br.com.fiap.challenge.activities

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.time.YearMonth

class CalendarActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "calendar") {
                composable("calendar") { CalendarView(navController) }
                composable(
                    "schedule/{day}/{month}/{year}",
                    arguments = listOf(
                        navArgument("day") { type = NavType.IntType },
                        navArgument("month") { type = NavType.IntType },
                        navArgument("year") { type = NavType.IntType }
                    )
                ) { backStackEntry ->
                    val day = backStackEntry.arguments?.getInt("day") ?: 0
                    val month = backStackEntry.arguments?.getInt("month") ?: 0
                    val year = backStackEntry.arguments?.getInt("year") ?: 0
                    ScheduleActivity(day, month, year, navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(26)
@Composable
fun CalendarView(navController: NavController){
    var currentYearMonth by remember { mutableStateOf(YearMonth.now()) }

    Column {
        TopAppBar(
            title = {
                Text(
                    text = "Agenda",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { currentYearMonth = currentYearMonth.minusMonths(1) },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(Icons.Default.ChevronLeft, contentDescription = "Previous Month")
                }
                MonthHeader(currentYearMonth)
                IconButton(
                    onClick = { currentYearMonth = currentYearMonth.plusMonths(1) },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(Icons.Default.ChevronRight, contentDescription = "Next Month")
                }
            }
            WeekDaysHeader()
            CalendarDays(currentYearMonth, navController)
        }
    }
}

@Composable
fun WeekDaysHeader(){
    val weekDays = listOf("Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab")
    Row(
        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
        weekDays.forEach{day ->
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center){
                BasicText(text = day)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarDays(yearMonth: YearMonth, navController: NavController) {
    val daysInMonth = yearMonth.lengthOfMonth()
    val firstDayOfMonth = yearMonth.atDay(1).dayOfWeek.value % 7
    val days = (1..daysInMonth).toList()

    var dayIndex = 0

    for (week in 0..5) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            for (dayOfWeek in 0..6) {
                if (week == 0 && dayOfWeek < firstDayOfMonth || dayIndex >= days.size) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .align(Alignment.CenterVertically)
                    ) {}
                } else {
                    val selectedDay = days[dayIndex]
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                Log.d("CalendarActivity", "Clicked on day $selectedDay")
                                navController.navigate("schedule/$selectedDay/${yearMonth.monthValue}/${yearMonth.year}")
                            }
                    ) {
                        Text(text = selectedDay.toString())
                        dayIndex++
                    }
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MonthHeader(yearMonth: YearMonth) {
    val monthYear = "${yearMonth.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${yearMonth.year}"
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        BasicText(text = monthYear, style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        )
    }
}
