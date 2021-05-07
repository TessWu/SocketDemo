package com.example.socketdemo1;

import android.util.Log;

public class MyThread extends Thread{  //繼承extends方法然後去複寫run方法

    @Override
    public void run() {
        Log.d("TAG",Thread.currentThread().getName()+".run()");  //得到當前Thread的Name，可以直觀的看到當前Thread的執行情況
    }
}
