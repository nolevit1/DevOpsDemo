package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeControllerTest {
    
    @Test
    void testCreate() {
        EmployeeController controller = new EmployeeController();
        var employee = new Employee(6, "John", "Developer");
        controller.createEmployee(employee);
        assertEquals(1, controller.countemployee());
        assertEquals(1, controller.employee().size());
    }
    @Test
    void testCreate2() {
        EmployeeController controller = new EmployeeController();
        var employee = new Employee(7, "Johny", "Developer");
        controller.createEmployee(employee);
        assertEquals(1, controller.countemployee());
        assertEquals(1, controller.employee().size());
    }
}