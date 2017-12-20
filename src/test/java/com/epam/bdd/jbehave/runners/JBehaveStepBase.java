package com.epam.bdd.jbehave.runners;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;


public class JBehaveStepBase extends JUnitStories {

    @Override
    public InjectableStepsFactory stepsFactory() {
        Configuration configuration = new MostUsefulConfiguration();
        ApplicationContext applicationContext = new SpringApplicationContextFactory("spring-beans.xml").createApplicationContext();
        return new SpringStepsFactory(configuration, applicationContext);

    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(CodeLocations.codeLocationFromClass(
                        this.getClass()),
                        Arrays.asList("ebay.story"),
                        Arrays.asList(""));
    }
}
