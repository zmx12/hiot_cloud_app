package com.huatec.hiot_cloud.test.dagger2test;

import dagger.Module;
import dagger.Provides;

/**
 * dagger2 测试module 类
 */
@Module
public class TestModule {
    @Provides
    public ThirdObj getThirdObj(){
        return new ThirdObj();
    }
}
