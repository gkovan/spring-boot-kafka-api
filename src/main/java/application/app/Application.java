package application.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@ServletComponentScan({"com.ibm.orderskafka.*", "com.ibm.kafkastream.wordcount.*", "com.ibm.kafkastream.pipe.*", "com.ibm.kafkastream.mapping.*", "com.ibm.kafkastream.window.*", "com.ibm.kafkastream.sessionwindow.*", "com.ibm.kafkastream.json.*"})
@SpringBootApplication
@ComponentScan({"com.ibm.hello.*","com.ibm.simplekafka.*", "com.ibm.orderskafka.*", "com.ibm.config", "com.ibm.kafkastream.wordcount.*", "com.ibm.kafkastream.pipe.*", "com.ibm.kafkastream.mapping.*", "com.ibm.kafkastream.window.*", "com.ibm.kafkastream.sessionwindow.*", "com.ibm.kafkastream.json.*", "com.ibm.cloud_garage.*", "com.ibm.health"})
public class Application extends SpringBootServletInitializer {
    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String port = environment.getProperty("local.server.port");

            System.out.println();
            System.out.println("Server started - http://localhost:" + port + "/swagger-ui.html");
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
