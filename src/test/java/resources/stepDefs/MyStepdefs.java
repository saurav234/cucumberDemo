package resources.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyStepdefs {
    String result;

    public MyStepdefs() {

    }
    @Given("Create a fizzbuzz gameplay")
    public void createAFizzbuzzGameplay() {

    }

    @When("I play with number {int}")
    public void iPlayWithNumber(int arg0) {
        result = invokeService(arg0);
    }

    @Then("The result was Buzz")
    public void theResultWasBuzz() {
        Assertions.assertEquals(result, "buzz");
    }

    @Then("The result was Fizz")
    public void theResultWasFizz() {
        Assertions.assertEquals(result, "fizz");
    }

    private String invokeService(int input) {
        String output = "";
        try {

            URL url = new URL("http://localhost:8080/fizzBuzzResult/" + String.valueOf(input));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            output = br.readLine();

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return output;
    }
}
