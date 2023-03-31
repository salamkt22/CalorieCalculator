package com.example.caloriecalculator.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private var _gymNam = MutableLiveData<String>("")
    val gymName : LiveData<String> = _gymNam

    private var _gender = MutableLiveData<String>("")
    val gender : LiveData<String> = _gender

    private var _age = MutableLiveData<Int>(0)
    val age : LiveData<Int> = _age

    private var _height = MutableLiveData<Double>(0.0)
    val height : LiveData<Double> = _height

    private var _weight = MutableLiveData<Double>(0.0)
    val weight : LiveData<Double> = _weight

    private var _activeDays = MutableLiveData<String>("")
    val activeDays : LiveData<String> = _activeDays

    private var _maintenanceCalories = MutableLiveData<Double>(0.0)
    val maintenanceCalories : LiveData<Double> = _maintenanceCalories

    private var _shreddedCalories = MutableLiveData<Double>(0.0)
    val shreddedCalories : LiveData<Double> = _shreddedCalories

    private var _bulkCalories = MutableLiveData<Double>(0.0)
    val bulkCalories : LiveData<Double> = _bulkCalories

    fun setGymName(GymName : String){
        _gymNam.value = GymName
    }
    fun setGender(genderType : String){
        _gender.value = genderType
    }
    fun setAge(yourAge : Int){
        _age.value = yourAge
        calculateAge()
    }
    fun setHeight(heightNu : Double){
        _height.value = heightNu
        calculateHeight()
    }
    fun setWeight(weightNu : Double){
        _weight.value = weightNu
        calculateWeight()
    }
    fun setActiveDays(activeDays : String){
        _activeDays.value = activeDays
        calculateBMR()
    }

    private fun calculateHeight(){
        val bmrHeightMale = (_height.value ?: 0.0 ) * 5.003
        val bmrHeightFemale = (_height.value ?: 0.0 ) * 1.85

        if (_gender.value == "Male"){
            _height.value = bmrHeightMale
        }else{
            _height.value = bmrHeightFemale
        }
    }

    private fun calculateWeight(){
        val bmrWeightMale = (_weight.value ?: 0.0) * 13.75
        val bmrWeightFemale = (_weight.value ?: 0.0) * 9.563

        if (_gender.value == "Male"){
            _weight.value = bmrWeightMale
        }else{
            _weight.value = bmrWeightFemale
        }
    }

    private fun calculateAge(){
        val bmrAgeMale = (_age.value ?: 0) * 7
        val bmrAgeFemale = (_age.value ?: 0 ) * 5

        if (_gender.value == "Male"){
            _age.value = bmrAgeMale
        }else{
            _age.value = bmrAgeFemale
        }
    }

    private fun calculateBMR(){
        val heightPlusWeight = (_height.value ?: 0.0) + (_weight.value ?: 0.0)
        val maleBMR = 66.74 + heightPlusWeight - (_age.value ?: 0)
        val femaleBMR = 655.1 + heightPlusWeight - (_age.value ?: 0)

        if (_gender.value == "Male"){
            _maintenanceCalories.value = maleBMR
        }else{
            _maintenanceCalories.value = femaleBMR
        }
        when(_activeDays.value){
            "Little or no exercise" -> {
                _maintenanceCalories.value = (_maintenanceCalories.value ?: 0.0) * 1.2
            }
            "Exercise 1-3 times/week" -> {
                _maintenanceCalories.value = (_maintenanceCalories.value ?: 0.0) * 1.375
            }
            "Exercise 4-5 times/week" -> {
                _maintenanceCalories.value = (_maintenanceCalories.value ?: 0.0) * 1.55
            }
            "Intense exercise 6-7 times/week" -> {
                _maintenanceCalories.value = (_maintenanceCalories.value ?: 0.0 ) * 1.725
            }

        }
        calculateShreddedCalories()
        calculateBulkCalories()
    }

    private fun calculateShreddedCalories(){
        _shreddedCalories.value = (_maintenanceCalories.value ?: 0.0) - 500
    }

    private fun calculateBulkCalories(){
        _bulkCalories.value = (_maintenanceCalories.value ?: 0.0) + 500
    }



}