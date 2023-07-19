package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.GitHubSearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static guru.qa.tests.TestData.*;

public class ListenerTest extends TestBase {
    @Test
    public void testIssueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();

        gitHubSearchPage.openUrl()
                .clickSearchField()
                .inputQuery(queryBlueSky)
                .pressEnter()
                .clickSearchResult()
                .clickIssuesTab()
                .checkIssueNumber(issueNumber);

    }
}
