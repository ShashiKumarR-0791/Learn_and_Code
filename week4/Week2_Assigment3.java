class Customer {
    int customerID;
    String companyName;
    String contactName;
    String country;

    Customer(int customerID, String companyName, String contactName, String country) {
        this.customerID = customerID;
        this.companyName = companyName;
        this.contactName = contactName;
        this.country = country;
    }
}

class CustomerSearchService {

    Customer[] customers;

    CustomerSearchService(Customer[] customers) {
        this.customers = customers;
    }

    Customer[] searchByCountry(String country) {
        Customer[] result = new Customer[customers.length];
        int index = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].country.toLowerCase().contains(country.toLowerCase())) {
                result[index++] = customers[i];
            }
        }
        return result;
    }

    String exportToCSV(Customer[] data) {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("CustomerID,CompanyName,ContactName,Country\n");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                csvBuilder.append(data[i].customerID).append(",")
                          .append(data[i].companyName).append(",")
                          .append(data[i].contactName).append(",")
                          .append(data[i].country).append("\n");
            }
        }
        return csvBuilder.toString();
    }

    public static void main(String[] args) {
        Customer[] customers = new Customer[] {
            new Customer(1, "Acme Corp", "John Doe", "USA"),
            new Customer(2, "Beta Ltd", "Jane Smith", "Canada"),
            new Customer(3, "Gamma Inc", "Alice Johnson", "USA")
        };

        CustomerSearchService service = new CustomerSearchService(customers);

        Customer[] result = service.searchByCountry("USA");
        System.out.println(service.exportToCSV(result));
    }
}
