package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.GitHubSearch;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static guru.qa.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class StepsTests extends TestBase {
    @Test
    public void testIssueSearchLambdaStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        GitHubSearch gitHubSearch = new GitHubSearch();


        step("Open Main Page", () -> {
            gitHubSearch.openUrl();
        });

        step("Search for" + " " + queryBlueSky, () -> {
            gitHubSearch.clickSearchField()
                    .inputQuery(queryBlueSky)
                    .pressEnter();
        });

        step("Click search result link", () -> {
            gitHubSearch.clickSearchResult();
        });

        step("Open Issues tab", () -> {
            gitHubSearch.clickIssuesTab();
        });

        step("Check that issue" + " " + issueNumber + " " + "exists", () -> {
            gitHubSearch.checkIssueNumber(issueNumber);
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
