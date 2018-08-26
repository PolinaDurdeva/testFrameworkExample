package com.qandoo.steps;

import com.qandoo.pages.HoversPage;
import com.qandoo.pages.LoginPage;
import com.qandoo.pages.TablesPage;

/**
 * Base class for each step definition providing access to the pages to tests following the steps
 */
abstract class AbstractStepDefinitions {

    protected LoginPage loginPage;

    protected HoversPage hoversPage;

    protected TablesPage tablesPage;


}
