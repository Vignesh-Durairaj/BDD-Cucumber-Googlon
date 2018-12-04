package stepDefinitions;

import static org.junit.Assert.assertEquals;

import com.credijusto.googlon.pojo.GooglonText;
import com.credijusto.googlon.processor.GooglonTextProcessor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GooglonStepDefinitions {

	private GooglonTextProcessor googlonProcessor;

	private GooglonText googlonText;
	
	@Given("^a working googlon processor$")
	public void a_working_googlon_processor() throws Throwable {
	    googlonProcessor = new GooglonTextProcessor();
	}

	@When("^The input text is \"([^\"]*)\"$")
	public void the_input_text_is(String arg1) throws Throwable {
		googlonText = googlonProcessor.getProcessedText(arg1);
	}

	@Then("^There are (\\d+) prepositions in the text$")
	public void there_are_prepositions_in_the_text(int arg1) throws Throwable {
	    assertEquals(arg1, googlonText.getPrepositionCount());
	}

	@Then("^There are (\\d+) verbs in the text$")
	public void there_are_verbs_in_the_text(int arg1) throws Throwable {
	    assertEquals(arg1, googlonText.getVerbCount());
	}

	@Then("^There are (\\d+) subjunctive verbs in the text$")
	public void there_are_subjunctive_verbs_in_the_text(int arg1) throws Throwable {
	    assertEquals(arg1, googlonText.getSubjunctivesCount());	
	}

	@Then("^Vocabulary list: \"([^\"]*)\"\"$")
	public void vocabulary_list(String arg1) throws Throwable {
	    assertEquals(arg1, googlonText.getOrderedVocabularySet());
	}

	@Then("^There are (\\d+) distinct pretty numbers in the text$")
	public void there_are_distinct_pretty_numbers_in_the_text(int arg1) throws Throwable {
	    assertEquals(arg1, googlonText.getPrettyNosCount());
	}
}
