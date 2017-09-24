package com.gnoemes.bullhorn.di.modules.activity;


import com.gnoemes.bullhorn.models.DataManagerHelper;
import com.gnoemes.bullhorn.di.ActivityScope;
import com.gnoemes.bullhorn.ui.main.IMainPresenter;
import com.gnoemes.bullhorn.ui.main.IMainView;
import com.gnoemes.bullhorn.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private IMainView mainView;

    public MainModule(IMainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    @ActivityScope
    IMainView provideMainView() {
        return mainView;
    }

    @Provides
    @ActivityScope
    IMainPresenter provideMainPresenter(DataManagerHelper DataManagerHelper) {
        return new MainPresenter(mainView, DataManagerHelper);
    }
}