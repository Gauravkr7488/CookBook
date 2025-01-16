import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cookbook.RecipeDao
import com.example.cookbook.RecipeViewModel

@Suppress("UNCHECKED_CAST")
class RecipeViewModelFactory(private val recipeDao: RecipeDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeViewModel::class.java)) {
            return RecipeViewModel(recipeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
