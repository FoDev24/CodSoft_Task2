package com.example.calculator.presentation.mainscreen

sealed class CalculatorEvent {

    data class Number(val number: Int):CalculatorEvent()
    data class Operation(val operation: CalculatorOperation):CalculatorEvent()

    object Clear:CalculatorEvent()
    object Delete:CalculatorEvent()
    object Decimal:CalculatorEvent()
    object Calculate:CalculatorEvent()



}