package com.bigstep.videoapp.constructorInjection

import javax.inject.Inject

class Car @Inject constructor() {
    fun getCar() = "car service is on the process"
}