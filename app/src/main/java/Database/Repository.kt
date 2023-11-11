package Database

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    val allExpenses: Flow<List<ExpenseEntity>> = expenseDao.GetAllExpenses()

    suspend fun insertExpense(expense: ExpenseEntity) {
        expenseDao.insertExpense(expense)
    }

    suspend fun updateExpense(expense: ExpenseEntity) {
        expenseDao.insertExpense(expense)
    }

    suspend fun deleteExpense(expense: ExpenseEntity) {
        expenseDao.insertExpense(expense)
    }

}
class CategoryRepository(private val categoryDao: CategoryDao) {
    val allCategories: Flow<List<CategoryEntity>> = categoryDao.GetAllCategories()

    suspend fun insertcategory(expense: InsertEntity) {
        categoryDao.insertCategory(category)
    }



class BudgetRepository(private val budgetDao: BudgetDao) {
    val getBudgetByCategory(categoryId: Long): Flow<List<BudgetEntity?>> = budgetDao.getBudgetByCategory(categoryId)

    suspend fun InsertBudget(budget: budgetEntity) {
        budgetDao.insertBudget(Budget)
    }

    suspend fun updateBudget(budget: budgetEntity) {
        budgetDao.updateBudget(Budget)
    }

}