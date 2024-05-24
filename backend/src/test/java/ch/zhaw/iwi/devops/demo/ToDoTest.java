package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoTest {

    private ToDoController controller;

    @Test
    void testToDo() {
        var toDo1 = new ToDo(1, "title", "description");
        assertEquals("title", toDo1.getTitle());
        assertEquals("description", toDo1.getDescription());
        assertEquals(1, toDo1.getId());
    }

    @Test
    void testCreate() {
        EmployeeController controller = new EmployeeController();
        var employee = new Employee(6, "John", "Developer");
        controller.createEmployee(employee);
        assertEquals(1, controller.countemployee());
        assertEquals(1, controller.employee().size());
    }

        @BeforeEach
    void setUp() {
        controller = new ToDoController();
        // Assuming ToDoController has an init method to initialize todos if necessary
        // controller.init();
    }

    @Test
    void testTestEndpoint() {
        assertEquals("ToDo app is up and running!", controller.test());
    }

    @Test
    void testPingEndpoint() {
        String expectedResponse = "{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"de\",\"version\": \"0.0.1\"}";
        assertEquals(expectedResponse, controller.ping());
    }

    @Test
    void testCountEndpoint() {
        // Assuming the ToDoController is initialized and todos are empty
        assertEquals(0, controller.count());
    }
}
