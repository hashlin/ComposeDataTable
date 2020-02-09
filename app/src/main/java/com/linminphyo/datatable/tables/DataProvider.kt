package com.linminphyo.datatable.tables

import androidx.annotation.DrawableRes
import androidx.compose.Model
import com.linminphyo.datatable.R

/**
 * Created by lin min phyo on 2/9/20.
 */

@Model
data class MenuItem(
    @DrawableRes val image: Int, val name: String,
    val unitPrice: Int,
    var isSelected: Boolean = false
)

object DataProvider {

    val coffeeMenu = listOf(
        MenuItem(R.drawable.espresso,"Espresso", unitPrice = 3),
        MenuItem(R.drawable.double_espresso,"Double Espresso", unitPrice = 4),
        MenuItem(R.drawable.americano,"Americano", unitPrice = 4),
        MenuItem(R.drawable.macchiato,"Macchiato", unitPrice = 5),
        MenuItem(R.drawable.caramel_macchiato,"Caramel Macchiato", unitPrice = 5),
        MenuItem(R.drawable.ristretto,"Ristretto", unitPrice = 3),
        MenuItem(R.drawable.latte,"Latte", unitPrice = 5),
        MenuItem(R.drawable.cappuchino,"Cappuchino", unitPrice = 5),
        MenuItem(R.drawable.mocha,"Mocha", unitPrice = 5)
    )

}