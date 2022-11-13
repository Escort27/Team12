package logindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.team12.logindemo.repository")
@SpringBootApplication
public class SpringBootLoginDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.team12.Team12Application.class, args);
    }

}
