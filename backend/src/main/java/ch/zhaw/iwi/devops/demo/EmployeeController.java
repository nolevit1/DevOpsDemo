package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmployeeController {

    /* Alte Codezeile */
    /*private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();*/
    /* Neue Codezeile */
    private Map<Integer, Employee> employees = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.employees.put(1,new Employee(1, "Ale", "Software Engineer"));
        this.employees.put(2,new Employee(2, "Moreno", "Devops"));
        this.employees.put(3,new Employee(3, "Billy", "Chef"));
        this.employees.put(4,new Employee(4, "Jimmy", "Koch"));
        this.employees.put(5,new Employee(5, "Frank", "Tester"));
        System.out.println("Init Data Employee");
    }

    @GetMapping("/testemployee")
    public String testemployee() {
        return "Employee app is up and running!";
    }

    @GetMapping("/countemployee")
    public int countemployee() {
        return this.employees.size();
    }

    @GetMapping("/services/employee")
    public List<PathListEntry<Integer>> employee() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var employee : this.employees.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(employee.getId(), "employeeKey");
            entry.setName(employee.getName());
            entry.getDetails().add(employee.getJob());
            entry.setTooltip(employee.getJob());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/employee/{key}")
    public Employee getEmployee(@PathVariable Integer key) {
        return this.employees.get(key);
    }

    @PostMapping("/services/employee")
    public void createEmployee(@RequestBody Employee employee) {
        var newId = this.employees.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        employee.setId(newId);
        this.employees.put(newId, employee);
    }

    @PutMapping("/services/employee/{id}")
    public void createEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        this.employees.put(id, employee);
    }

    @DeleteMapping("/services/employee/{key}")
    public Employee deletEmployee(@PathVariable Integer key) {
        return this.employees.remove(key);
    }


}
