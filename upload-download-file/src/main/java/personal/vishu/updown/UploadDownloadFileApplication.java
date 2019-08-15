package personal.vishu.updown;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import personal.vishu.updown.properties.StorageProperties;
import personal.vishu.updown.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadDownloadFileApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(UploadDownloadFileApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService)
    {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
