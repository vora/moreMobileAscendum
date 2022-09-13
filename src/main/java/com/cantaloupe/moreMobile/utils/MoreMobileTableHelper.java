package com.cantaloupe.moreMobile.utils;

import com.cantaloupe.moreMobile.MoreMobileWebDriverController;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an html table with convenience methods for accessing rows, columns etc...
 *
 * @author jroe
 * @author umurodov
 *
 */

public class MoreMobileTableHelper {

    protected static Logger LOG = Logger.getLogger(MoreMobileTableHelper.class);

    protected final static String CELL_LOC = "tbody>tr:nth-of-type(%d)>td:nth-child(%d)";
    protected final static String COLUMN_LOC = "tbody>tr>td:nth-child(%d)";
    protected final static String ROW_LOC = "tbody>tr:nth-child(%d)";
    protected final static String ROWS_COUNT_LOC = "tbody>tr";

    protected final static String DEFAULT_HEADER_LOC = "thead>tr>th";
    protected final static String DEFAULT_SORT_COLUMN_HEADER_LOC = "thead>tr>th:nth-child(%d)>a";
    protected final static String DEFAULT_HEADER_CHECK_ALL_LOC = "thead>tr>th:nth-child(1)>input";

    protected final static String TABLE_CONTAINS_LOC = "tbody/tr/td[contains(., '%s')]";
    protected final static String INVALID_HEADER_LOC_MSG = "Unable to retrieve header data using locator %s in the context of %s";


    private WebDriver driver = MoreMobileWebDriverController.getWebDriver();
    private WebElement tableContainer;
    private By headerLoc;

    /**
     * Use this constructor if you have a standard header locator of: "thead>tr>th"
     * @param tableContainer
     */
    public MoreMobileTableHelper(WebElement tableContainer) {
        this.tableContainer = tableContainer;
        this.headerLoc = By.cssSelector(DEFAULT_HEADER_LOC);
    }

    /***
     * Use this constructor if you have a different header locator than the default one of "thead>tr>th"
     * @param tableContainer
     * @param headerLoc
     */
    public MoreMobileTableHelper(WebElement tableContainer, By headerLoc) {
        this.tableContainer = tableContainer;
        this.headerLoc = headerLoc;
    }

    public WebElement getTableContainer(){
        return tableContainer;
    }

    /**
     * return the number of visible rows in the table
     *
     * @param offset - Optional number of rows to ignore in the table count.
     * @return the number of visible rows in the table
     */
    public Integer getRowCount(int... offset) {
        Integer size = tableContainer.findElements(By.cssSelector(ROWS_COUNT_LOC)).size();
        if (offset.length > 0) {
            size += offset[0];
        }

        return size;
    }

    /**
     * Returns the table's column header as a {@link List} of {@link WebElement} This assumes that the header is part of the table object.
     *
     * @return {@link List} of {@link WebElement} table header
     */
    public List<WebElement> getTableHeader() {

        List<WebElement> header = tableContainer.findElements(headerLoc);

        if(header.isEmpty()) {
            LOG.error("No header found using locator: " + headerLoc.toString());
        }

        return header;
    }

    /**
     * Returns the table's column header labels. This assumes that the header is part of the table object. If the header is independent of
     *
     * @return {@link List} of {@link String} labels
     */
    public List<String> getColumnLabels()  {

        List<String> stringHeaders = new ArrayList<>();
        List<WebElement> headers = getTableHeader();

        if (headers.isEmpty()) {
            LOG.error("No header found using locator: " + headerLoc.toString());
        }

        for (WebElement header : headers) {
            stringHeaders.add(header.getText().trim());
        }

        return stringHeaders;
    }

    /**
     * Returns the index of the column with the header label or -1 if not found. <br>This assumes that the header is part of the table
     * object is underneath a {@code table -> thead -> tr -> th } <br>If the header is independent of the table data, use*
     * @param columnHeader - the visible text of the column header
     * @param offset - optional offset to use if the header elements have any "hidden" cells to account for.
     *
     * @return index of the column or -1 if not found
     */
    public int getIndexOfColumn(String columnHeader, int... offset) {
        int index = -1;
        List<String> columns = getColumnLabels();

        if (columns.contains(columnHeader)) {
            //tables are not zero-based
            index = columns.indexOf(columnHeader) + 1;
            if (offset.length > 0) {
                index += offset[0];
            }
        }
        else {
            LOG.warn("Unable to find a header named: " + columnHeader);
        }
        return index;
    }


    /**
     * Get the column data as a {@link List} of {@link WebElement}
     *
     * @param column - the target column
     * @return - the contents of the cell as a {@link List} of {@link WebElement} or empty list if no data
     */
    public List<WebElement> getColumnDataAsElement(int column) {
        return tableContainer.findElements(By.cssSelector(String.format(COLUMN_LOC, column)));
    }


    /**
     * Get the column data as a {@link List} of {@link String}
     *
     * @param column - the target column
     * @return - the contents of the cell as a {@link List} of {@link String} or empty list if no data
     */
    public List<String> getColumnDataAsString(int column) {
        List<String> values = new ArrayList<>();
        List<WebElement> elements = getColumnDataAsElement(column);
        for (WebElement element : elements) {
            values.add(element.getText().trim());
        }

        return values;
    }

    /**
     * Returns the row number that has the value for a particular column
     * @param column - column to search for the value
     * @param targetValue - value to search for in the column
     * @return - row number of -1 if not found
     */
    public Integer getRowNumberThatHasValue(String column, String targetValue) {
        Integer rowNumber = -1;

        int i = 0;
        Integer index = getIndexOfColumn(column);
        if(index != -1) {
            var columns = getColumnDataAsElement(index);
            for(i = 0; i < columns.size(); i++) {
                var columnContents = columns.get(i).getText();
                if(columnContents.contains(targetValue)) {
                    rowNumber = i + 1;
                    LOG.debug("Found row " + rowNumber + " contains value " + targetValue + " in column " + column);
                    break;
                }
            }

        }
        return rowNumber;
    }

    /**
     * Click the link in the cell
     * @param rowNumber
     * @param columnHeader - column header
     */
    public void clickLinkInCell(int rowNumber, String columnHeader)  {

        var colIndex = getIndexOfColumn(columnHeader);
        if(colIndex > 0) {
            LOG.debug("Clicking link in row: " + rowNumber + " column: " + columnHeader);
            var cellElement = getCell(rowNumber, colIndex);
            var linkElement = cellElement.findElement(By.cssSelector("a"));
            linkElement.click();
        } else {
            LOG.warn("Unable to locate column " + columnHeader);
        }
    }

    /**
     * Click the link in the cell
     * @param rowNumber
     * @param columnNumber
     */
    public void clickLinkInCell(int rowNumber, int columnNumber)  {
        LOG.debug("Clicking link in row: " + rowNumber + " column: " + columnNumber);
        var cellElement = getCell(rowNumber, columnNumber);
        var linkElement = cellElement.findElement(By.cssSelector("a"));
        linkElement.click();
    }

    private WebElement getCell(int row, int col) {
        return tableContainer.findElement(By.cssSelector(String.format(CELL_LOC, row, col)));
    }

}
