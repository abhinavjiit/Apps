package com.bigstep.videoapp.constructorInjection

import javax.inject.Inject

class Service @Inject constructor(private val car: Car, private val bike: Bike) {

    fun getService() = "Service is started"

    fun getCar() = car.getCar()

    fun getBike() = bike.getBike()

}