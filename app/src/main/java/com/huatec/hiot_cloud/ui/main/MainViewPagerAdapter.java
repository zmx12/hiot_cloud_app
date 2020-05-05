package com.huatec.hiot_cloud.ui.main;

import android.transition.Scene;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.huatec.hiot_cloud.utils.Constans;

/**
 * viewPager 适配器
 */
class MainViewPagerAdapter extends FragmentPagerAdapter {
    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = EquipmentFragment.newInstance();
        switch (position) {
            case Constans.MAIN_VIEWPAGER_INDEX_MESSAGE:
                //创建消息Fragemnt todo
                fragment = MessageFragment.newInstance();
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_EQUIPMENT:
                //创建设备Fragemnt
                fragment = EquipmentFragment.newInstance();
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_SCENE:
                //创建场景Fragemnt
                fragment = SceneFragment.newInstance();
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_MINE:
                //创建我的Fragemnt
                fragment = MineFragment.newInstance();
                break;
            default:
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Constans.MAIN_FRAGMENT_COUNT;
    }
}
