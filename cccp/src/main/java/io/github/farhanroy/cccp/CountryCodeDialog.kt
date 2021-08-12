package io.github.farhanroy.cccp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CountryCodeDialog(pickedCountry: (CCPCountry) -> Unit) {
    val countryList: List<CCPCountry> = getLibraryMasterCountriesEnglish()
    val picked = remember { mutableStateOf(countryList[0]) }
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false) }
            val dialogWidth = 250.dp
            val dialogHeight = 400.dp

            Row(Modifier.clickable {
                openDialog.value = true
            }, horizontalArrangement = Arrangement.SpaceBetween) {
                Image(
                    painter = painterResource(
                        id = getFlagMasterResID(
                            picked.value
                        )
                    ), contentDescription = null
                )
                Text(
                    picked.value.name,
                    Modifier.padding(horizontal = 18.dp)
                )
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
            }

            if (openDialog.value) {
                Dialog(onDismissRequest = { openDialog.value = false }) {
                    Box(
                        Modifier
                            .size(dialogWidth, dialogHeight)
                            .background(Color.White)
                    ) {
                        LazyColumn {
                            items(countryList.size) { index ->
                                Row(
                                    Modifier
                                        .padding(
                                            horizontal = 18.dp,
                                            vertical = 18.dp
                                        )
                                        .clickable {
                                            pickedCountry(countryList[index])
                                            picked.value = countryList[index]
                                            openDialog.value = false
                                        }) {
                                    Image(
                                        painter = painterResource(
                                            id = getFlagMasterResID(
                                                countryList[index]
                                            )
                                        ), contentDescription = null
                                    )
                                    Text(
                                        countryList[index].name,
                                        Modifier.padding(horizontal = 18.dp)
                                    )
                                }
                            }
                        }
                    }

                }
            }
        }

    }
}