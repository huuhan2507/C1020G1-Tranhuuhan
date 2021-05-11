package another_folder;

import models.Customer;

import java.util.Comparator;

public class SortCustomer implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getName1().compareTo( o2.getName1() ) != 0) {
            return o1.getName1().compareTo( o2.getName1() );
        } else if (Integer.parseInt( o1.getYear() ) - Integer.parseInt( o2.getYear() ) != 0) {
            return Integer.parseInt( o1.getYear() ) - Integer.parseInt( o2.getYear() );
        } else if (Integer.parseInt( o1.getMonth() ) - Integer.parseInt( o2.getMonth() ) != 0) {
            return Integer.parseInt( o1.getMonth() ) - Integer.parseInt( o2.getMonth() );
        }
        return Integer.parseInt( o1.getDay() ) - Integer.parseInt( o2.getDay() );
    }
}
