package lv.javaguru.finalwork;

//import lv.javaguru.finalwork.ui.ProductLoginUI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import lv.javaguru.finalwork.ui.ProductMainUI;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

/*    @Bean
    @Profile("!test")
    public CommandLineRunner demo(ProductLoginUI ui) {
        return (args) -> {
            ui.execute();
        };
    }*/
}