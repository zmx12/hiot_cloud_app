package com.huatec.hiot_cloud.ui.base;

import android.util.Log;

import com.huatec.hiot_cloud.test.networktest.ResultBase;
import com.huatec.hiot_cloud.utils.Constants;
import com.huatec.hiot_cloud.utils.LoadingUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * MVP架构Presenter层基类
 */

public class BasePresenter<V extends BaseView> {
    private V view;

    public BasePresenter() {

    }
    public void setView(V view){
        this.view = view;
    }
    public  V getView(){
        return view;
    }
    public void destroy(){
        if (viewAttached()){
            view = null;
        }
    }
    public boolean viewAttached(){
        return view != null;
    }

    public <T> void subscrib(Observable<T> observable, final RequestCallback<T> callback) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        callback.onSubscribe(d);
                    }

                    @Override
                    public void onNext(T t) {
                        callback.onNext(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        callback.onComplete();
                    }
                });
    }

    /**
     * 回调类
     */
    public abstract class RequestCallback<T> {
        private static final String TAG = "RequestCallback";

        public void onSubscribe(Disposable d) {

        }

        public void onNext(T t) {
            ResultBase resultBase = (ResultBase) t;
            if (resultBase == null) {
                getView().showMessage("服务器开小差了，请稍后再试");
                return;
            }
            //如果token失效
            if (resultBase.getStatus() == Constants.MSG_STATUS_TOKENOUT) {
                getView().tokenOut();
                return;
            }
            if (resultBase.getStatus() != Constants.MSG_STATYS_SUCCESS) {
                getView().showMessage(resultBase.getMsg());
                return;
            }
        }

        public void onError(Throwable e) {
            //对话框隐藏
            LoadingUtil.hideLoading();
            Log.e(TAG, "onError: ", e);
            getView().showMessage("服务器开小差，请稍后再试");
        }

        public void onComplete() {
            //对话框隐藏
            LoadingUtil.hideLoading();
        }
    }
}
