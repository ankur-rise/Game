package com.demo.rock.di.component;

import com.demo.rock.ui.view.MainActivity;
import dagger.Component;

@Component
public interface ActivityFragmentComponent {
    void inject(MainActivity activity);
}
