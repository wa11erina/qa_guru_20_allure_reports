package guru.qa.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSearchPage {
    String url = "https://github.com/";
    SelenideElement
            searchField = $("[placeholder='Search or jump to...']"),
            queryInput = $("#query-builder-test"),
            searchResult = $("[data-testid='results-list']").$(".Box-sc-g0xbh4-0").$(byText("bluesky-social/")),
            issuesTab = $("#issues-tab"),
            issueLocator = $("#issue_1034");


        public GitHubSearchPage openUrl() {
            open(url);
            return this;
        }


        public GitHubSearchPage clickSearchField() {
            searchField.click();
            return this;
        }

        public GitHubSearchPage inputQuery(String value) {
            queryInput.setValue(value);
            return this;
        }

        public GitHubSearchPage pressEnter() {
            queryInput.pressEnter();
            return this;
        }

        public GitHubSearchPage clickSearchResult() {
            searchResult.click();
            return this;
        }

        public GitHubSearchPage clickIssuesTab() {
            issuesTab.click();
            return this;
        }

        public GitHubSearchPage checkIssueNumber(String value) {
            issueLocator.shouldHave(text (value));
            return this;

        }


}
