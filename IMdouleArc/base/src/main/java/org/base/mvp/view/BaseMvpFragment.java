package org.base.mvp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;

import org.base.BaseFragment;
import org.base.mvp.presenter.BasePresenter;


public abstract class BaseMvpFragment<T extends BasePresenter>  extends BaseFragment implements BaseView {
    protected T mPresenter ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initInjector() ;
        mPresenter.attachView(this);
    }

    protected abstract T  initInjector();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null)
            mPresenter.detachView();
    }
}
