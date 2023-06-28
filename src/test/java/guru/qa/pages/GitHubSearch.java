package guru.qa.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSearch {
    String url = "https://github.com/";
    SelenideElement
            searchField = $("[placeholder='Search GitHub']"),
            searchResult = $$("ul.repo-list li").first().$("a[href='/bluesky-social/social-app']"),
            issuesTab = $("#issues-tab"),
            issueLocator = $("#issue_908");


        public GitHubSearch openUrl() {
            open(url);
            return this;
        }


        public GitHubSearch clickSearchField() {
            searchField.click();
            return this;
        }

        public GitHubSearch inputQuery(String value) {
            searchField.setValue(value);
            return this;
        }

        public GitHubSearch pressEnter() {
            searchField.pressEnter();
            return this;
        }

        public GitHubSearch clickSearchResult() {
            searchResult.click();
            return this;
        }

        public GitHubSearch clickIssuesTab() {
            issuesTab.click();
            return this;
        }

        public GitHubSearch checkIssueNumber(String value) {
            issueLocator.shouldHave(text (value));
            return this;

        }


}
