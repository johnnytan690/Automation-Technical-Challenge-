package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateTodoTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://todo-app-url.com");
    }

    @Test
    public void testCreateTodo() {
        // Enter todo details
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys("New Todo");

        WebElement descriptionField = driver.findElement(By.id("description"));
        descriptionField.sendKeys("This is a new todo.");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify success message
        WebElement successMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(successMessage.getText(), "Todo created successfully!");

        // Verify todo is displayed in the list
        WebElement todoList = driver.findElement(By.id("todo-list"));
        Assert.assertTrue(todoList.getText().contains("New Todo"));
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}