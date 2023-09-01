package uvg.edu.gt.cardgenerator

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object CardSelectorScreen : Screen("card_selector")
    object CardGeneratorScreen : Screen("card_generator")
}