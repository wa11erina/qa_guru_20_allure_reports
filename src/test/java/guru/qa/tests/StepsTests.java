package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.GitHubSearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static guru.qa.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class StepsTests extends TestBase {
    @Test
    public void testIssueSearchLambdaStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();


        step("Open Main Page", () -> {
            gitHubSearchPage.openUrl();
        });

        step("Search for" + " " + queryBlueSky, () -> {
            gitHubSearchPage.clickSearchField()
                    .inputQuery(queryBlueSky)
                    .pressEnter();
        });

        step("Click search result link", () -> {
            gitHubSearchPage.clickSearchResult();
        });

        step("Open Issues tab", () -> {
            gitHubSearchPage.clickIssuesTab();
        });

        step("Check that issue" + " " + issueNumber + " " + "exists", () -> {
            gitHubSearchPage.checkIssueNumber(issueNumber);
        });

    }

    @Test
    public void testAnnotatedStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository();
        steps.clickSearchResultLink();
        steps.openIssuesTab();
        steps.checkIssueNumber();
    }

}
