package lv.javaguru.finalwork;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "lv.javaguru.finalwork")
@PropertySource("classpath:application.properties")
public class SpringConfig {
}
