package guru.qa.tests;

import guru.qa.pages.GitHubSearch;
import io.qameta.allure.Step;

import static guru.qa.tests.TestData.*;

public class WebSteps extends TestBase {

    GitHubSearch gitHubSearch = new GitHubSearch();

    @Step("Open Main page")
    public void openMainPage() {
        gitHubSearch.openUrl();
    }

    @Step("Search for repository")
    public void searchForRepository() {
        gitHubSearch.clickSearchField()
                .inputQuery(queryBlueSky)
                .pressEnter();
    }

    @Step("Click search result link")
    public void clickSearchResultLink() {
        gitHubSearch.clickSearchResult();
    }

    @Step("Open tab Issues")
    public void openIssuesTab() {
        gitHubSearch.clickIssuesTab();
    }

    @Step("Check that issue with certain number exists")
    public void checkIssueNumber() {
        gitHubSearch.checkIssueNumber(issueNumber);
    }

}
