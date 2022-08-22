package entities;

public class JuridicPerson extends Person {

    private Integer employeeNumber;

    public JuridicPerson(){
        super();
    }
    

    public JuridicPerson(String name, Double annualIncome, Integer employeeNumber) {
        super(name, annualIncome);
        this.employeeNumber = employeeNumber;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }


    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    

    @Override
    public Double tax() {
        if (employeeNumber > 10) {
            return getAnnualIncome() * 0.14;
        } else {
            return getAnnualIncome() * 0.16;
        }
    }


    
    
}
