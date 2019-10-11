package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testDropdownSelection() {

        var dropdownPage = homePage.clickDropDown();
        String option = "Option 1";
        dropdownPage.selectOption(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Value not Selected");
        assertTrue(selectedOptions.contains(option), "Incorrect Selection");

    }

    @Test
    public void testDropdownMultiSelection() {
        var dropdownPage = homePage.clickDropDown();
        dropdownPage.makeMultiSelectionDropDown();
        //String option1 ="Option 1";
        //String option2 ="Option 2";
        //dropdownPage.selectOption(option1);
        //dropdownPage.selectOption(option2);
        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectOption);


        var selectedOptions = dropdownPage.getSelectedOptions();
        assertTrue(dropdownPage.isMultiple(), "Attribute not set");
        assertEquals(selectedOptions.size(), 2, "Multi values are not selected");
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options are not selected");

    }


}
