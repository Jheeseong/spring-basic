package spring.springbasic.beanlifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(CycleCfgAnn.class) {};

        InitAnnotation cycle = ac.getBean(InitAnnotation.class);
        ac.close();
    }

    @Configuration
    static class CycleCfgInterface {
        @Bean
        public InitInterface initializingBean() {
            InitInterface initializingBean = new InitInterface();
            initializingBean.setNetwork("http://test-init.dev");
            return initializingBean;
        }
    }

    @Configuration
    static class CycleCfgBean {
        @Bean(initMethod = "init", destroyMethod = "close")
        public InitBean initBean() {
            InitBean initBean = new InitBean();
            initBean.setNetwork("http://test-init.dev");
            return initBean;
        }
    }

    @Configuration
    static class CycleCfgAnn {
        @Bean
        public InitAnnotation initAnnotation() {
            InitAnnotation initAnnotation = new InitAnnotation();
            initAnnotation.setNetwork("http://test-init.dev");
            return initAnnotation;
        }
    }
}
