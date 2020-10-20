package com.bigstep.videoapp.constructorInjection

import javax.inject.Inject

class Bike @Inject constructor() {

    fun getBike() = "bike service is on the process"
}