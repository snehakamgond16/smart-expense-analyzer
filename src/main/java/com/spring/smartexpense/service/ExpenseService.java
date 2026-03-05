import java.util.List;

import com.spring.smartexpense.dto.ExpenseDTO;

public interface ExpenseService {

    ExpenseDTO addExpense(ExpenseDTO expenseDTO);

    List<ExpenseDTO> getAllExpenses();

    void deleteExpense(Long id);

}