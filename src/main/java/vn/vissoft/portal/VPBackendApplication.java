package vn.vissoft.portal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class VPBackendApplication extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(VPBackendApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VPBackendApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
//		uploadProfileService.deleteAll();
//		uploadProfileService.init();
    }
}
