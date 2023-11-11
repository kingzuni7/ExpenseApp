package Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ExpenseViewModel(private val expenseRepository: ExpenseRepository) : ViewModel() {

    val allExpenses: LiveData<List<ExpenseEntity>> = expenseRepository.allExpenses.asLiveData()

    fun insertExpense(expense: ExpenseEntity) {
        viewModelScope.launch {
            expenseRepository.insertExpense(expense)
        }
    }

    fun updateExpense(expense: ExpenseEntity) {
        viewModelScope.launch {
            expenseRepository.updateExpense(expense)
        }
    }

    fun deleteExpense(expense: ExpenseEntity) {
        viewModelScope.launch {
            expenseRepository.deleteExpense(expense)
        }
    }
}

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    val allCategories: LiveData<List<CategoryEntity>> = categoryRepository.allCategories.asLiveData()

    fun insertCategory(category: CategoryEntity) {
        viewModelScope.launch {
            categoryRepository.insertCategory(category)
        }
    }
}

class BudgetViewModel(private val budgetRepository: BudgetRepository) : ViewModel() {

    fun getBudgetByCategory(categoryId: Long): LiveData<BudgetEntity?> =
        budgetRepository.getBudgetByCategory(categoryId).asLiveData()

    fun insertBudget(budget: BudgetEntity) {
        val launch = viewModelScope.launch {
            budgetRepository.insertBudget(budget)
        }
    }

    fun updateBudget(budget: BudgetEntity) {
        viewModelScope.launch {
            budgetRepository.updateBudget(budget)
        }
    }
}
