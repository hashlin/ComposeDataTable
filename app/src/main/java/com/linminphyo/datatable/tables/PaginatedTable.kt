package com.linminphyo.datatable.tables

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.DataTable
import androidx.ui.material.DefaultDataTablePagination
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

/**
 * Created by lin min phyo on 2/9/20.
 */

@Preview
@Composable
fun PreviewPaginatedMenu() {
    PaginatedTable(menuItems = DataProvider.coffeeMenu)
}

@Composable
fun PaginatedTable(menuItems: List<MenuItem>) {
    DataTable(
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
            dataRow { index ->
                when (index) {
                    0 -> Container(LayoutWidth(200.dp), alignment = Alignment.CenterLeft) {
                        Text(menuItem.name)
                    }
                    1 -> Text("$ ${menuItem.unitPrice}")
                }
            }
        }


    }
}
