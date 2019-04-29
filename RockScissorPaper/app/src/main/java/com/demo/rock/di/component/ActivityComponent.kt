package com.demo.rock.di.component

import com.demo.rock.di.scopes.ActivityScope
import com.demo.rock.ui.view.MainActivity
import dagger.Component

@ActivityScope @Component interface ActivityComponent {
    fun inject(activity:MainActivity)
}
