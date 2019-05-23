package com.demo.rock.di.injector

import com.demo.rock.di.component.ActivityComponent
import com.demo.rock.di.component.DaggerActivityComponent

class Injector {

    fun getActivityComponent() : ActivityComponent {
        var component = DaggerActivityComponent.builder().build()
        return component
    }

}