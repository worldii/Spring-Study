package com.example.starter.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
* postConstuct, predestory  쓰는 방식
* 컴포넌트 스캔과 잘 어울린다.
* 하지만, 외부 라이브러리에는 적용하지 못하기에(변경 불가로 인해) 이런 경우에는 @Bean의 기능(속성을 부여)을 이용하면 된다.
 *  */
public class LifeCycleTest3 {

    @Test
    public void lifeCycleTest2() {

        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig2.class);
        NetworkClient3 client = ac.getBean(NetworkClient3.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig2 {
        @Bean
        public NetworkClient3 networkClient3() {
            NetworkClient3 networkClient2 = new NetworkClient3();
            networkClient2.setUrl("http://hello-spring.dev");
            return networkClient2;
        }
    }
}
