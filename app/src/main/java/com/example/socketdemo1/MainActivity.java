package com.example.socketdemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class MainActivity extends AppCompatActivity {  //這一個是要掃描可以用的server


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




}

    public void butonclick(View view) {
        testSale();
    }

    public void testThread(){ //現在想要執行Therad方法可以直接調用run方法嗎?答案是不行
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();

        mt1.start();
        mt2.start();
    }

    public void testRunnable(){

        MyRunnable mr1= new MyRunnable();
        MyRunnable mr2= new MyRunnable();
          //多個Thread對象可以共用一個mr
        //線程同步
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr1);
        //Thread t2 = new Thread(mr2);
        t1.start();
        t2.start();
    }
    public void testSale(){
        //多個thread操作同一個目標對象，先把目標對象用出來
        SellTicket sellTicket = new SellTicket();
        Thread t1 = new Thread(sellTicket,"A代理");
        Thread t2 = new Thread(sellTicket,"B代理");
        Thread t3 = new Thread(sellTicket,"C代理");
        Thread t4 = new Thread(sellTicket,"D代理");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}