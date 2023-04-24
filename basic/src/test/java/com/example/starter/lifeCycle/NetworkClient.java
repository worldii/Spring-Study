package com.example.starter.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    /*
    * 해당 인터페이스 두개를 구현하면서 두 메서드만 오버라이딩해서 구현하면 되니 편하지만, 이 인터페이스는 스프링 전용 인터페이스이기 때문에 해당 인터페이스에 의존하게 된다.
    그리고 두 인터페이스에서 제공하는 메서드 오버라이딩이기 때문에 이름을 변경할 수 없고 외부 라이브러리에는 적용할수도 없다.
    *
    * */
    private String url;

    public NetworkClient() {
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

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}