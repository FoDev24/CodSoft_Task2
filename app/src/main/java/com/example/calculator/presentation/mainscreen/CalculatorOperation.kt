package com.example.calculator.presentation.mainscreen

sealed class CalculatorOperation(val symbol : String) {

    object Plus : CalculatorOperation("+")
    object Minus : CalculatorOperation("-")
    object Multiply : CalculatorOperation("*")
    object Divide : CalculatorOperation("/")
}