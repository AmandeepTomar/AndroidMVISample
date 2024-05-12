package com.amandeep.androidmvisample.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amandeep.androidmvisample.data.remote.ApiClient
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

//    private var _state = mutableStateOf<RecipeViewState>(RecipeViewState.Loading)
//    val state: State<RecipeViewState> = _state

    private var _stateFlow = MutableStateFlow(RecipeViewStateData())
    val stateFLow: StateFlow<RecipeViewStateData> = _stateFlow

    val intentChannel = Channel<RecipeViewIntent>(Channel.UNLIMITED)

    init {
        handleIntent()
    }

    // cahannel Approach
    private fun handleIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collectLatest {
                when (it) {
                    RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
                    is RecipeViewIntent.SearchRecipes -> searRecipe(it.query)
                }
            }
        }
    }

    fun processIntent(recipeViewIntent: RecipeViewIntent) {
        when (recipeViewIntent) {
            RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
            is RecipeViewIntent.SearchRecipes -> searRecipe(recipeViewIntent.query)
        }
    }


    private fun loadRandomRecipe() {
        viewModelScope.launch {
//            _state.value = RecipeViewState.Loading
//            try {
//                _state.value = RecipeViewState.Success(
//                    ApiClient.getRandomRecipe()
//                )
//            } catch (e: Exception) {
//                _state.value = RecipeViewState.Error(e.localizedMessage)
//            }

            _stateFlow.update {
                it.copy(loading = true)
            }
            try {
                _stateFlow.update {
                    it.copy(recipeList = ApiClient.getRandomRecipe())
                }

            } catch (e: Exception) {
                _stateFlow.update {
                    it.copy(errorMessage = e.localizedMessage)
                }
            }
        }
    }

    private fun searRecipe(query: String) {
        viewModelScope.launch {
//            _state.value = RecipeViewState.Loading
//            try {
//                // get list through the query
//                _state.value = RecipeViewState.Success(
//                    ApiClient.getSearchedRecipe(query)
//                )
//            } catch (e: Exception) {
//                _state.value = RecipeViewState.Error(e.localizedMessage)
//            }

            _stateFlow.update {
                it.copy(loading = true)
            }

            try {
                _stateFlow.update {
                    it.copy(loading = false, recipeList = ApiClient.getSearchedRecipe(query))
                }

            } catch (e: Exception) {
                _stateFlow.update {
                    it.copy(errorMessage = e.toString())
                }
            }
        }
    }
}