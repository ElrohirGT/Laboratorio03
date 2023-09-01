package uvg.edu.gt.cardgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import uvg.edu.gt.cardgenerator.ui.theme.CardGeneratorTheme
import uvg.edu.gt.cardgenerator.views.cardGeneratorView
import uvg.edu.gt.cardgenerator.views.cardSelectorView
import uvg.edu.gt.cardgenerator.views.homeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.MainScreen.route){
                composable(route = Screen.MainScreen.route){
                    homeView(navController)
                }
                composable(route = Screen.CardSelectorScreen.route +"/{celebrationType}"){
                    backStackEntry ->
                    val celebrationType = backStackEntry.arguments?.getString("celebrationType")
                    requireNotNull(celebrationType) { "CardSelector requires a celebration type." }
                    cardSelectorView(navController, celebrationType)
                }
                composable(
                    route = Screen.CardGeneratorScreen.route +"/{imageID}",
                    arguments = listOf(navArgument("imageID"){ type = NavType.IntType})
                ){
                        backStackEntry ->
                    val imageID = backStackEntry.arguments?.getInt("imageID")
                    requireNotNull(imageID) { "imageID requires a celebration type." }
                    cardGeneratorView(navController, imageID)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CardGeneratorTheme {
        Greeting("Android")
    }
}