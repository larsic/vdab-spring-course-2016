package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Zoo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
@Aspect
// TODO: Marketing must become a Spring AOP Aspect
public class Marketing {
    private boolean campaignLaunched = false;

    // TODO: Add an advice that advices the zoo before new animals are added.
    // TODO: Make sure our advice launches the marketing campaign "launchCampaign(Zoo, Animal)". Figure out how to pass the relevant Zoo and Animal parameters.
    @Before(value = "execution(* *.addAnimal(com.realdolmen.spring.domain.Animal)) && args(name)")
    public void launchIt (JoinPoint jp, Animal name){
        launchCampaign((Zoo)jp.getTarget(), name);
    }

    /**
     * Launches a new marketing campaign.
     * @param zoo The zoo to launch a campaign for.
     * @param animal The newly arrived animal.
     */
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
        campaignLaunched = true;
    }

    public boolean isCampaignLaunched() {
        return campaignLaunched;
    }
}
