package customer.hwCkcho.handlers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.ServiceName;

import cds.gen.hrinfoservice.*;

@Component
@ServiceName(HrInfoService_.CDS_NAME)
public class HrInfoServiceHandler implements EventHandler {

	@After(event = CdsService.EVENT_READ, entity = Employees_.CDS_NAME)
	public void checkHighSalaryEmp(Stream<Employees> Employee) {

        Employee.filter(e -> e.getSalary() > 100)
        .forEach(e -> e.setName(e.getName() + " (High Salary)"));

    }
    
	@After(event = CdsService.EVENT_READ, entity = Depts_.CDS_NAME)
	public void checkHighSalaryDept(List<Depts> Dept) {

        for(Depts d : Dept){
            if(d.getEmployees() != null){
                for(Employees e  : d.getEmployees()){
                    if(e.getSalary() > 100){
                        e.setName(e.getName() + " (High Salary)");
                    }
                }
            }
        }

	}

}