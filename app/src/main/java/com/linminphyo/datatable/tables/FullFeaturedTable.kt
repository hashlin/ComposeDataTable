package com.linminphyo.datatable.tables

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.SimpleImage
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Spacer
import androidx.ui.material.DataTable
import androidx.ui.material.DefaultDataTablePagination
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

/**
 * Created by lin min phyo on 2/8/20.
 */
@Preview
@Composable
fun PreviewFullFeaturedTable() {
    FullFeaturedTable(menuItems = DataProvider.coffeeMenu.toMutableList())
}

@Composable
fun FullFeaturedTable(menuItems: MutableList<MenuItem>) {
    DataTable(
        borderWidth = 0.dp,
        dataRowHeight = 150.dp,
        columns = 2, pagination = DefaultDataTablePagination(
            initialRowsPerPage = 3,
            availableRowsPerPage = menuItems.chunked(3).map { it.size }
        )
    ) {
        headerRow { index ->
            when (index) {
                0 -> Text(text = "Name")
                1 -> Text(text = "Price")
            }

        }

        for (menuItem in menuItems) {
            dataRow(
                selected = menuItem.isSelected,
                onSelectedChange = {
                    menuItem.isSelected = it
                }
            ) { index ->
                when (index) {
                    0 -> Column(LayoutWidth(180.dp)) {
                            SimpleImage(image = imageResource(id = menuItem.image))
                            Spacer(modifier = LayoutHeight(8.dp))
                            Text("${menuItem.name}", style = MaterialTheme.typography().h6.copy(color = MaterialTheme.colors().secondary))
                        }


                    1 -> Text("$ ${menuItem.unitPrice}", style = MaterialTheme.typography().h6.copy(color = MaterialTheme.colors().secondary))
                }
            }
        }


    }
}

