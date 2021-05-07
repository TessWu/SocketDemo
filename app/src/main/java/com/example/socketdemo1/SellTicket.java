package com.example.socketdemo1;

import android.util.Log;

public class SellTicket implements Runnable{  //賣火車票

    private int ticket = 20; //火車票有幾張是固定的，但允許多個thread來賣，這裡會涉及到多個thread操作的是同一個變量，調用的是同一個方法
    @Override
    public void run() {
        while (true){ //涉及到線程同步的變量，ticket
            synchronized (this){
                if(ticket>0){
                    Log.d("TAG",Thread.currentThread().getName()+"賣出了第"+(20-ticket+1)+"張票"); //因為是從第0張開始，所以要加上1
                    ticket--;
                }
                //火車票賣完
                else{
                    break;
                }
            }
            try {
                Thread.sleep(200); //賣一張休息200毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
