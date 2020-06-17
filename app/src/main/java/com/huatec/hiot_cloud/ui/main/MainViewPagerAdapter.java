package com.huatec.hiot_cloud.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.huatec.hiot_cloud.ui.devicelist.DeviceListFragment;
import com.huatec.hiot_cloud.ui.mine.MineFragment;
import com.huatec.hiot_cloud.utils.Constants;

/**
 * viewPager适配器
 */
class MainViewPagerAdapter extends FragmentPagerAdapter {
    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case Constants.MAIN_VIEWPAGER_INDEX_MESSAGE:
                //创建消息fragment todo
                fragment = MessageFragment.newInstance();
                break;
            case Constants.MAIN_VIEWPAGER_INDEX_EQUIPMENT:
                //创建设备的fragment
                fragment =  DeviceListFragment.newInstance();
                break;
            case Constants.MAIN_VIEWPAGER_INDEX_SCENE:
                //创建设场景的fragment
                fragment = SceneFragment.newInstance();
                break;
            case Constants.MAIN_VIEWPAGER_INDEX_MINE:
                //创建我的fragment
                fragment = MineFragment.newInstance();
                break;
            default:
        }
        return  fragment;
    }

    @Override
    public int getCount() {
        return Constants.MAIN_FRAGMENT_COUNT;
    }
}
