package com.linminphyo.datatable.tables

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.material.DataTable
import androidx.ui.material.DefaultDataTableSorting
import androidx.ui.tooling.preview.Preview

/**
 * Created by lin min phyo on 2/9/20.
 */
@Preview
@Composable
fun PreviewSortableTable() {
    SortableTable(menuItems = DataProvider.coffeeMenu.toMutableList())
}

@Composable
fun SortableTable(menuItems: MutableList<MenuItem>) {
    DataTable(
        columns = 2,
        sorting = DefaultDataTableSorting(
            sortableColumns = setOf(1),
            onSortRequest = { _, isAscending ->
                if (isAscending) {
                    menuItems.sortBy { it.unitPrice }
                } else {
                    menuItems.sortByDescending { it.unitPrice }
                }
            })
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
                    0 -> Text(menuItem.name)
                    1 -> Text("$ ${menuItem.unitPrice}")
                }
            }
        }


    }
}