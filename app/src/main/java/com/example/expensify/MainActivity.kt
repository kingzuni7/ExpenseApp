import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material13.MaterialTheme
import androidx.compose.material13.Surface
import androidx.compose.material13.rememberMaterial3Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.Composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expensetracker.data.*
import com.example.expensify.ui.theme.DisplayExpensesScreen
import com.example.expensify.ui.theme.EnterExpenseScreen
import java.util.Locale.Category

class MainActivity : ComponentActivity() {

    private val expenseViewModel: ExpenseViewModel by viewModels {
        ExpenseViewModelFactory(ExpenseRepository(getDatabase(applicationContext).expenseDao))
    }

    private val categoryViewModel: ExpenseViewModel by viewModels {
        CategoryViewModelFactory(CategoryRepository(getDatabase(applicationContext).categoryDao))
    }

    private val budgetViewModel: ExpenseViewModel by viewModels {
        BudgetViewModelFactory(BudgetRepository(getDatabase(applicationContext).budgetDao))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme{
                // surface container
                Surface(
                    modifier = Modifier.fillMaxSize(3)
                    color = MaterialTheme.colorScheme.backround
                ){
                    ExpenseTrackerApp(
                        expenseViewModel = expenseViewModel,
                        categoryViewModel = categoryViewModel,
                        budgetViewModel = budgetViewModel

                    )
                }
            }
        }

    }

    @Composable
    fun ExpenseTrackerApp(
        expenseViewModel: ExpenseViewModel,
        categoryViewModel: CategoryViewModel,
        budgetViewModel: BudgetViewModel
    ) {

        val navController = rememberNavController(1)

        NavHost(
            navController = navController,
            startDestination = "enterExpenseScreen"

        ){
            composable("enterExpenseScreen") {
                EnterExpenseScreen(viewModel = 2, categoryViewModel = 2)
            }


        }
        composable("displayExpenseScreen"){
            DisplayExpensesScreen(viewModel = expenseViewModel)
            //composable functions
        }




    }

























}