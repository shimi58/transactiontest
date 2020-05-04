/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package transaction.controller.employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import transaction.application.repository.EmployeeRepository;
import transaction.domain.model.employee.Employee;
import transaction.domain.model.employee.EmployeeNumber;
import transaction.domain.model.employee.Employees;
import transaction.presentation.controller.employee.EmployeesController;

@SpringBootTest
public class EmployeesControllerTransactionTest {

    MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private EmployeesController employeesController;

    // Mock対象
    @SpyBean
    private EmployeeRepository employeeRepository;


    /**
     * Transactionテスト
     *
     * Emploeeテーブルに従業員情報を登録後、従業員件数更新時にエラーが発生した際、 <br>
     * 従業員情報登録をロールバックしていることを確認する
     *
     * @throws Exception
     */
    @ParameterizedTest
    @CsvSource({"日比 隆夫,123-4345-2352,hibi@test.com,3"})
    public void testTransaction(String name, String phone, String mail, int expected)
            throws Exception {

        Employee employee = new Employee(name, phone, mail);


        // リクエストをJson形式に変換
        String json = mapper.writeValueAsString(employee);

        // エラー発生設定
        doThrow(new RuntimeException()).when(employeeRepository)
                .registerNumber(Mockito.any(EmployeeNumber.class));

        this.mockMvc = MockMvcBuilders.standaloneSetup(employeesController).build();

        // リクエスト発行
        MvcResult result = mockMvc.perform(
                post("/employees/register").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        Employees employees = employeeRepository.findEmployees();

        System.out.println(response);
        System.out.println(employees.toString());

        EmployeeNumber actual = employees.number();

        // ロールバックされるため、登録前の3件の状態になっていることを確認
        assertEquals(expected, actual.getValue().intValue());
    }
}