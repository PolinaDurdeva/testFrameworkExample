package com.qandoo.steps;

import com.qandoo.pages.TablesPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TablesPageStepDefinitions extends AbstractStepDefinitions{


    @Given("^I open tables page$")
    public void iOpenTablesPage() throws Throwable {
        tablesPage = new TablesPage();
        tablesPage.openPage();
    }

    @Then("^I see \"([^\"]*)\" of \"([^\"]*)\" is sortable$")
    public void iSeeOfIsSortable(String column, String table) throws Throwable {
        tablesPage.assertTableIsSortableBy(column, table);
    }

}
