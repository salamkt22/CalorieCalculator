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
    }
    fun setHeight(heightNu : Double){
        _height.value = heightNu
    }
    fun setWeight(weightNu : Double){
        _weight.value = weightNu
    }
    fun setActiveDays(activeDays : String){
        _activeDays.value = activeDays
    }

}