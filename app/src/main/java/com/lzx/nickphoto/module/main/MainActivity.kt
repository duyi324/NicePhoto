package com.lzx.nickphoto.module.main

import android.support.v7.widget.LinearLayoutManager
import com.lzx.nickphoto.R
import com.lzx.nickphoto.bean.PhotoInfo
import com.lzx.nickphoto.common.RxBaseActivity
import com.lzx.nickphoto.module.main.contract.PhotoContract
import com.lzx.nickphoto.module.main.presenter.PhotoPresenter
import com.lzx.nickphoto.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RxBaseActivity(), PhotoContract.IPhotoView {

    //api文档：https://unsplash.com/documentation#user-authentication
    //Application ID： 6c18f0d4f3c1fcd37b2388ec2c543f272777584f8ed62a4bcd0fba0fe904c6f8
    //Secret： a36ad9805b0f97f3e3d553763e957c0fcc4abf0026d8602314fbea844992a6f8
    //Callback URLs： https://lzx-images.com/callback (Authorize)

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }

    lateinit var mPresenter: PhotoContract.IPhotoPresenter

    override fun init() {
        mPresenter = PhotoPresenter(this)

        recycle_view.layoutManager = LinearLayoutManager(this)

        mPresenter.getAllPhotoList(bindToLifecycle())
    }

    override fun showPro(isShow: Boolean) {

    }

    override fun OnGetPhotoSuccess(result: ArrayList<PhotoInfo>) {
        LogUtils.i("result = " + result.size)
    }

    override fun OnError(msg: String) {

    }
}

