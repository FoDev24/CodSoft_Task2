package com.example.calculator.presentation.mainscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculator.util.Const.Companion.MAX_NUM_LENGTH

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onEvent(event: CalculatorEvent) {
        Log.d("test","Success in viewModel")
        when (event) {
            is CalculatorEvent.Number -> enterNumber(event.number)

            is CalculatorEvent.Decimal -> enterDecimal()

            is CalculatorEvent.Clear -> state = CalculatorState()

            is CalculatorEvent.Operation -> enterOperation(event.operation)

            is CalculatorEvent.Calculate -> performCalculation()

            is CalculatorEvent.Delete -> performDeletion()

        }

    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Plus -> number1 + number2
                is CalculatorOperation.Minus -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> Unit
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }

    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.number1.isNotBlank() && !state.number1.contains(".")
            && state.operation == null
        ) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }

        if (state.number2.isNotBlank() && !state.number2.contains(".")
        ) {
            state = state.copy(
                number2 = state.number2 + "."
            )
            return
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }
}