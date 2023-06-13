package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Featurefiles\\Fblogin.feature",glue="org.stepdefinition",
dryRun=false,monochrome=true,strict=false,snippets=SnippetType.CAMELCASE 
		
		)

public class RunnerClass {

}
