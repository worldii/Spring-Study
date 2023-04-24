package com.example.starter.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient2 {


    private String url;

    public NetworkClient2() {
        System.out.println("생성자 호출 , url=" + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void call(String msg) {
        System.out.println("call= " + url + " message= " + msg);
    }

    public void connect() {
        System.out.println("connect= " + url);
    }

    public void disconnect() {
        System.out.println("close= " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void init() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }


    public void close() throws Exception {
        disconnect();
    }
}