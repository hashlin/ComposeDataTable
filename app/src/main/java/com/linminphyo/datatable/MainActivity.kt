package com.linminphyo.datatable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.setContent
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.material.lightColorPalette
import androidx.ui.tooling.preview.Preview
import com.linminphyo.datatable.tables.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MaterialTheme(
                colors = lightColorPalette(
                    background = Color(0xFFEED7C1),
                    primary = Color(0xFF432918),
                    primaryVariant = Color(0xFF432918),
                    secondary = Color(0xFFBD6940),
                    onBackground = Color(0xFFBD6940)
                )
            ) {
                Container {
                    DrawShape(shape = RectangleShape, color = Color(0xFFEED7C1))
                    Home()
                }
            }
        }
    }
}

private enum class TableTypes(val title: String) {
    FullFeatured("Full Featured"),
    //    Simple("Simple"),
    Selectable("Selectable"),
    Sortable("Sortable"),
    Paginated("Paginated")
}


@Preview
@Composable
fun Home() {
    var section by state { TableTypes.FullFeatured }
    val sectionTitles = TableTypes.values().map { it.title }

    Column {
        TabRow(items = sectionTitles, selectedIndex = section.ordinal) { index, text ->
            Tab(text = text, selected = section.ordinal == index) {
                section = TableTypes.values()[index]
            }
        }
        Container(modifier = LayoutFlexible(1f)) {
            when (section) {
                TableTypes.FullFeatured -> FullFeaturedTable(DataProvider.coffeeMenu.toMutableList())
//                TableTypes.Simple -> SimpleTable(DataProvider.coffeeMenu)
                TableTypes.Selectable -> SelectableTable(DataProvider.coffeeMenu)
                TableTypes.Sortable -> SortableTable(DataProvider.coffeeMenu.toMutableList())
                TableTypes.Paginated -> PaginatedTable(DataProvider.coffeeMenu)
            }
        }
    }
}
