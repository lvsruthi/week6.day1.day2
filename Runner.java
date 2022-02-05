package Runner;

import org.testng.annotations.DataProvider;

import StepDefinitions.CucumberBaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features="src/test/java/features",
glue="StepDefinitions",
publish = true,
monochrome=true,
dryRun=false, 
snippets =SnippetType.CAMELCASE,
tags="@Functional"

)
public class Runner extends CucumberBaseClass{
	/*
	 * @DataProvider(indices=1) public Object[][] scenarios() {
	 * 
	 * return super.scenarios(); }
	 */
}
