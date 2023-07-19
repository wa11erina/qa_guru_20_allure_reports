package guru.qa.tests;

import guru.qa.pages.GitHubSearchPage;
import io.qameta.allure.Step;

import static guru.qa.tests.TestData.*;

public class WebSteps extends TestBase {

    GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();

    @Step("Open Main page")
    public void openMainPage() {
        gitHubSearchPage.openUrl();
    }

    @Step("Search for repository")
    public void searchForRepository() {
        gitHubSearchPage.clickSearchField()
                .inputQuery(queryBlueSky)
                .pressEnter();
    }

    @Step("Click search result link")
    public void clickSearchResultLink() {
        gitHubSearchPage.clickSearchResult();
    }

    @Step("Open tab Issues")
    public void openIssuesTab() {
        gitHubSearchPage.clickIssuesTab();
    }

    @Step("Check that issue with certain number exists")
    public void checkIssueNumber() {
        gitHubSearchPage.checkIssueNumber(issueNumber);
    }

}
