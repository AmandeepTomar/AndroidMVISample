package com.amandeep.androidmvisample.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeMeal(
    @SerializedName("meals")
    val meals: List<Meal>
)