package com.huatec.hiot_cloud.test.dagger2test;

import com.huatec.hiot_cloud.test.mvptest.TestMVPActivity;

import dagger.Component;

/**
 * 测试注入接口
 */
@Component(modules = TestModule.class)
public interface PresenterComponent {

    void inject(TestMVPActivity testMVPActivity);
}
