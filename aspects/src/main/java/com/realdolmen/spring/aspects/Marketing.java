package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Zoo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class Marketing {
    private boolean campaignLaunched = false;

    @Before("execution(* addAnimal(..)) && args(animal)")
    public void marketingCampaignLauncher(JoinPoint joinPoint, Animal animal) {
        Zoo zoo = (Zoo) joinPoint.getTarget();
        launchCampaign(zoo, animal);
        campaignLaunched = true;
    }

    void launchCampaign(Zoo zoo, Animal animal) {
        Objects.requireNonNull(zoo, () -> "Don't know which zoo to launch an advertisement campaign for.");
        Objects.requireNonNull(animal, () -> "Don't know which animal to launch an advertisement campaign for.");

        System.out.println();
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("* NEWS - NEWS - NEWS - NEWS - NEWS - NEWS - NEWS - NEWS - NEWS *");
        System.out.println("****************************************************************");
        System.out.format("A new %s named '%s' has moved to '%s' zoo!%n", animal.type(), animal.getName(), zoo.getName());
        System.out.println("****************************************************************");

        System.out.println(
            "       .''.             *''*    :_\\/_:     . \n" +
            "      :_\\/_:   .    .:.*_\\/_*   : /\\ :  .'.:.'.\n" +
            "  .''.: /\\ : _\\(/_  ':'* /\\ *  : '..'.  -=:o:=-\n" +
            " :_\\/_:'.:::. /)\\*''*  .|.* '.\\'/.'_\\(/_'.':'.'\n" +
            " : /\\ : :::::  '*_\\/_* | |  -= o =- /)\\    '  *\n" +
            "  '..'  ':::'   * /\\ * |'|  .'/.\\'.  '._____\n" +
            "      *        __*..* |  |     :      |.   |' .---\"|\n" +
            "       _*   .-'   '-. |  |     .--'|  ||   | _|    |\n" +
            "    .-'|  _.|  |    ||   '-__  |   |  |    ||      |\n" +
            "    |' | |.    |    ||       | |   |  |    ||      |\n" +
            " ___|  '-'     '    \"\"       '-'   '-.'    '`      |____\n" +
            "   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        );
        System.out.println("****************************************************************");
        System.out.println("* NEWS - NEWS - NEWS - NEWS - NEWS - NEWS - NEWS - NEWS - NEWS *");
        System.out.println("****************************************************************");
        System.out.println("                          (dramatization; may not have happened)");
        System.out.println();
    }

    public boolean isCampaignLaunched() {
        return campaignLaunched;
    }
}
