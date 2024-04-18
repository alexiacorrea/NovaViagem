package com.example.novaviagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novaviagem.components.MyTopBar
import com.example.novaviagem.ui.theme.NovaViagemTheme
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovaViagemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            MyTopBar()
        }
    ){

        val snackbarHostState = remember { SnackbarHostState() }
        val coroutineScope = rememberCoroutineScope()

        SnackbarHost(
            hostState = snackbarHostState
        ) {}

        val showDatePickerDialogInicio = remember {
            mutableStateOf(false)
        }
        val selectedDateInicio = remember {
            mutableStateOf("")
        }
        val datePickerStateInicio = rememberDatePickerState()



        val showDatePickerDialogFinal = remember {
            mutableStateOf(false)
        }
        val selectedDateFinal = remember {
            mutableStateOf("")
        }
        val datePickerStateFinal = rememberDatePickerState()

        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Destino",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .weight(1f)
                )
            }

            Row {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .weight(4f)
                        .padding(top = 10.dp)
                )
            }

            Row {
                Text(
                    text = "Tipo",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 10.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = false,
                    onClick = {},
                    modifier = Modifier
                        .weight(0.5f)
                )

                Text(
                    text = "Lazer",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .weight(1.5f)
                )

                RadioButton(
                    selected = true,
                    onClick = {},
                    modifier = Modifier
                        .weight(0.5f)
                )

                Text(
                    text = "Negócios",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .weight(1.5f)

                )
            }

            Row {

                Text(
                    text = "Data inicial",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(top = 16.dp)
                )
            }

            Row {

                if (showDatePickerDialogInicio.value) {
                    DatePickerDialog(
                        onDismissRequest = { showDatePickerDialogInicio.value = false },
                        confirmButton = {
                            Button(
                                onClick = {
                                    datePickerStateInicio
                                        .selectedDateMillis?.let { millis ->
                                            selectedDateInicio.value = millis.toBrazilianDateFormat()
                                        }
                                    showDatePickerDialogInicio.value = false
                                }) {
                                Text(text = "Escolher data")
                            }
                        },
                        modifier = Modifier
                            .weight(4f)
                    ) {
                        DatePicker(state = datePickerStateInicio)
                    }
                }

                OutlinedTextField(
                    value = selectedDateInicio.value,
                    onValueChange = { },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .onFocusChanged {
                            if (it.isFocused) {
                                showDatePickerDialogInicio.value = true
                            }
                        },
                    readOnly = true
                )
            }

            Row {

                Text(
                    text = "Data final",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(top = 16.dp)
                )
            }

            Row {

                if (showDatePickerDialogFinal.value) {
                    DatePickerDialog(
                        onDismissRequest = { showDatePickerDialogFinal.value = false },
                        confirmButton = {
                            Button(
                                onClick = {
                                    datePickerStateFinal
                                        .selectedDateMillis?.let { millis ->
                                            selectedDateFinal.value = millis.toBrazilianDateFormat()
                                        }
                                    showDatePickerDialogFinal.value = false
                                }) {
                                Text(text = "Escolher data")
                            }
                        },
                        modifier = Modifier
                            .weight(4f)
                    ) {
                        DatePicker(state = datePickerStateFinal)
                    }
                }

                OutlinedTextField(
                    value = selectedDateFinal.value,
                    onValueChange = { },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .onFocusChanged {
                            if (it.isFocused) {
                                showDatePickerDialogFinal.value = true
                            }
                        },
                    readOnly = true
                )
            }

            Row {

                Text(
                    text = "Orçamento",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(top = 16.dp)
                )
            }

            Row {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .weight(4f)
                        .padding(top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Viagem registrada!")
                        }
                    },
                    modifier = Modifier
                        .padding(top = 20.dp)
                ){
                    Text(text = "Salvar",
                        fontSize = 20.sp)
                }
            }
        }
    }
}

fun Long.toBrazilianDateFormat(
    pattern: String = "dd/MM/yyyy"
): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return formatter.format(date)
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    NovaViagemTheme {
        MyApp()
    }
}