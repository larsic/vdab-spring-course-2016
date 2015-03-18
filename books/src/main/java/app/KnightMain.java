package app;

import config.KnightConfig;
import knights.BraveKnight;
import knights.Knight;
import knights.Quest;
import knights.SlayDragonQuest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by cda5732 on 18/03/2015.
 */
@SpringBootApplication
public class KnightMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KnightConfig.class, args);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}

