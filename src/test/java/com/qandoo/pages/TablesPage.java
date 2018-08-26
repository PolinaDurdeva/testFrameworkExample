package com.qandoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

/**
 * Represents the page containing tables with user details
 */
public class TablesPage extends BasePage {

    private final static String TABLE_PAGE_URL = "/tables";

    private final static String CSS_TEMPLATE_COLUMN_HEADER = ".//th/span[text()=\"%s\"]";

    private final static String CSS_TEMPLATE_COLUMN = "td[class=\"%s\"]";

    private Map<String, String> tableNameIdMap = new HashMap<>();

    public TablesPage() {
        /*
            Here I manually fill the map of (tableName -> tableId) because
            finding the table by its name is not consistent (e.g. language may change)
        */
        tableNameIdMap.put("Example 2", "table2");
    }

    @Override
    String getSelfUrl() {
        return TABLE_PAGE_URL;
    }

    /**
     * Checks if the table is sortable by clicking on the specified column
     * @param columnName column name by which sorting is checked
     * @param tableName name of the table to experiment with
     */
    public void assertTableIsSortableBy(String columnName, String tableName){
        WebElement table = getTableByName(tableName);
        WebElement headerSpan = getTableHeaderByName(table, columnName);
        String columnClass = headerSpan.getAttribute("class");
        // here we assume that we know that ascending order is the first to apply.
        headerSpan.click();
        boolean firstSortCauseAsc = checkElementsAreSorted(getColumnElements(table, columnClass), true);
        assertTrue("First sorting is not causing data to be sorted in ascending order", firstSortCauseAsc);
        headerSpan.click();
        boolean secondSortCauseDesc = checkElementsAreSorted(getColumnElements(table, columnClass), false);
        assertTrue("Second click does not cause data to be sorted in descending order", secondSortCauseDesc);
        headerSpan.click();
        // Perhaps the database returns the data already sorted in an ascending order before the first sore
        boolean thirdSortCauseAsc = checkElementsAreSorted(getColumnElements(table, columnClass), true);
        assertTrue("Third click does not cause data to be sorted in ascending order", thirdSortCauseAsc);
    }

    /**
     * Checks whether text elements are sorted in alphabetic order (ascending or descending based on the parameters).
     * Note that the equality requirements between adjacent elements is not strict.
     * @param textElements elements to examine
     * @param asc flag to check whether elements are sorted in 'ascending' order. If false the order is 'descending'
     * @return true if desired the sort order is preserved
     */
    private boolean checkElementsAreSorted(List<String> textElements, boolean asc) {
        boolean areSorted = true;
        int expectedDiff = asc ? 1 : -1;
        if (textElements != null && textElements.size() > 1){
            for (int i = 1; i < textElements.size() && areSorted; i++){
                int neighborsDiff = textElements.get(i).compareTo(textElements.get(i - 1));
                areSorted = (neighborsDiff * expectedDiff >= 0);
            }
        }
        return areSorted;
    }


    /**
     * Gets the table as the web element by its name
     * @param tableName name of the table
     * @return the target element of throws {@link org.openqa.selenium.NoSuchElementException} exception if no table is found
     */
    private WebElement getTableByName(String tableName){
        String tableId = tableNameIdMap.get(tableName);
        return this.driver.findElement(By.id(tableId));
    }

    /**
     * Gets all values from table's column as text. Uses class attribute of the column to identify its elements
     * @param table table to get column values from
     * @param columnClass class of the column to explore
     * @return text values present in the table's column as text
     */
    private List<String> getColumnElements(WebElement table, String columnClass){
        List<WebElement> targetColumnElements = table.findElements(By.cssSelector(String.format(CSS_TEMPLATE_COLUMN, columnClass)));
        return targetColumnElements.stream()
                .map(WebElement::getText)
                .collect(toList());
    }

    /**
     * Gets table's header by its name. Uses text content as search key
     * @param table table to get header from
     * @param columnName name of the table's column of which the header is needed
     * @return the header element
     */
    private WebElement getTableHeaderByName(WebElement table, String columnName) {
        String css_selector = String.format(CSS_TEMPLATE_COLUMN_HEADER, columnName);
        return table.findElement(By.xpath(css_selector));
    }


}
