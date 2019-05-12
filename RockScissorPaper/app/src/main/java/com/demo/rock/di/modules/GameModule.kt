package com.demo.rock.di.modules

import com.demo.rock.di.scopes.ActivityScope
import com.demo.rock.game.GameEngine
import com.demo.rock.ui.presenters.GamePresenter
import com.demo.rock.ui.presenters.ResultPresenter
import dagger.Module
import dagger.Provides

@Module
class GameModule {
    var c:Int = 0
    @Provides @ActivityScope
    fun gameEngine():GameEngine {
        c++
        return GameEngine(c.toString())

    }
    @Provides @ActivityScope
    fun gamePresenter(gameEngine: GameEngine):GamePresenter{
        return GamePresenter(gameEngine)
    }

    @Provides
    fun resultPresenter():ResultPresenter{
        return ResultPresenter()
    }


}