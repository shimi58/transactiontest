package transaction.domain.model.employee;

import lombok.Data;

/**
 * 従業員
 */
@Data
public class Employee {

    private String name;

    private String phone;

    private String mail;


    public Employee() {

    }

    public Employee(String name, String phone, String mail) {

        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }
}
