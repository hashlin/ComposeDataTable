package com.linminphyo.datatable.tables

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.material.DataTable
import androidx.ui.tooling.preview.Preview

/**
 * Created by lin min phyo on 2/9/20.
 */
@Preview
@Composable
fun PreviewSelectableTable(){
    SelectableTable(menuItems = DataProvider.coffeeMenu)
}


@Composable
fun SelectableTable(menuItems: List<MenuItem>) {
    DataTable(columns = 2) {
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
                    0 -> Text(menuItem.name)
                    1 -> Text("$ ${menuItem.unitPrice}")
                }
            }
        }
    }
}


