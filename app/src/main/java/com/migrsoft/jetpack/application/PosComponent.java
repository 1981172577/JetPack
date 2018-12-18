package com.migrsoft.jetpack.application;


import com.migrsoft.jetpack.annotaion.App;
import com.migrsoft.jetpack.db.PosDataBase;
import com.migrsoft.jetpack.repository.CacheRepository;
import dagger.BindsInstance;
import dagger.Component;
import okhttp3.Interceptor;

import javax.inject.Named;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/3.
 */
@App
@Component(modules = {PosModule.class})
public interface PosComponent {
    void inject(PosApplication application);

    @Named("GET")
    Interceptor getInterceptor();

    PosDataBase getRoomDatabase();

    CacheRepository getCache();


    @Component.Builder
    interface Builder {

        @BindsInstance
        PosComponent.Builder bindApplication(PosApplication application);

        PosComponent.Builder posModule(PosModule module);

        PosComponent build();
    }
}
