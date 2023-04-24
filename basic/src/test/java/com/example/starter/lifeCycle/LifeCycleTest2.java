package com.example.starter.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class LifeCycleTest2 {
    /*설정 정보 클래스에서 Bean으로 등록되는 부분에 속성으로 initMethod속성에 init 소멸 메서드명으로 close를 설정해줬다.
     *
     * */

    /*## 종료 메서드 추론

`@Bean` 애노테이션의 소멸메서드를 지정하는 속성인 `destroyMethod` 에는 추론기능이 있다.

관례적으로 대부분 라이브러리에서는 close, shutdown 이라는 이름으로 소멸 메서드를 사용하기때문에, @Bean 의 destroyMethod는 default 값으로 (inferred)(추론)으로 등록되어 있는데, 이 기능은 close, shutdown이라는 이름의 메서드를 자동으로 호출해준다.

즉, 내가 스프링 빈을 등록할때 종료 메서드를 해당 관례를 따르는 close나 shutdown으로 지정한다면 따로 속성에 destroyMethod에 지정해주지 않아도, 자동으로 찾아서 동작한다.

만약, 추론 기능을 사용하기 싫을경우 공백(`""`)을 지정하면 된다.
    *
    * */
    @Test
    public void lifeCycleTest2() {

        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig2.class);
        NetworkClient2 client = ac.getBean(NetworkClient2.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig2 {
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient2 networkClient2() {
            NetworkClient2 networkClient2 = new NetworkClient2();
            networkClient2.setUrl("http://hello-spring.dev");
            return networkClient2;
        }
    }
}
