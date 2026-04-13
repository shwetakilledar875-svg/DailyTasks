package streamproblems;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

 class Order {
        String customerName;
        double amount;

        Order(String customerName, double amount) {
            this.customerName = customerName;
            this.amount = amount;
        }

        public String getCustomerName() { return customerName; }
        public double getAmount() { return amount; }

     @Override
     public String toString() {
         return "Order{" +
                 "customerName='" + customerName + '\'' +
                 ", amount=" + amount +
                 '}';
     }
 }

    public class Day5 {
        public static void main(String[] args) {
            List<Order> orders = Arrays.asList(
                    new Order("Alice", 1200.50),
                    new Order("Bob", 500.00),
                    new Order("Alice", 1500.00), // Duplicate name
                    new Order("Charlie", 2000.00),
                    new Order("David", 800.00)
            );
            // 1. Filter by amount// 2. Extract names // 3. Remove duplicates// 4. Sort alphabetically
                            // 5. Convert to list

            List<String> result=orders.stream().filter(o->o.getAmount()>1000)
                    .map(Order::getCustomerName)
                    .sorted().distinct().collect(Collectors.toList());
            System.out.println(result);


            Set<String> unique=orders.stream().filter(o->o.getAmount()>1000).map(Order::getCustomerName)
                    .collect(Collectors.toCollection(TreeSet::new));
            System.out.println("Unique character "+unique);


            //filter orders where the customer name is "Alice"?
            List<Order> name=orders.stream()
                    .filter(o -> o.getCustomerName().equals("Alice")).collect(Collectors.toList());
            System.out.println(name);

            //Get list of customer names
            List<String> names = orders.stream().map(Order::getCustomerName)
                    .collect(Collectors.toList());
            System.out.println(names);

            //Sort orders by amount
            List<Order> sortedOrders = orders.stream().sorted(Comparator.comparing(Order::getAmount))
                    .collect(Collectors.toList());
            System.out.println(sortedOrders);

            //Get total order amount
            double total = orders.stream().mapToDouble(Order::getAmount)
                    .sum();
            System.out.println(total);

            //Find maximum order amount
            Optional<Order> maxOrder = orders.stream().max(Comparator.comparing(Order::getAmount));
            maxOrder.ifPresent(System.out::println);

            //Count orders above 1000
            long count = orders.stream().filter(o -> o.getAmount() > 1000)
                    .count();
            System.out.println(count);

            //Group orders by customer name
            Map<String, List<Order>> grouped = orders.stream()
                    .collect(Collectors.groupingBy(Order::getCustomerName));
            System.out.println(grouped);

            //Sum order amount per customer
            Map<String, Double> totalPerCustomer = orders.stream().collect(Collectors.groupingBy(
                            Order::getCustomerName,
                            Collectors.summingDouble(Order::getAmount)));
            System.out.println(totalPerCustomer);

            //Get top 3 highest orders
            List<Order> top3 = orders.stream().sorted(Comparator.comparing(Order::getAmount).reversed())
                    .limit(3).collect(Collectors.toList());
            System.out.println(top3);

            //Partition orders above and below 1000
            Map<Boolean, List<Order>> partitioned = orders.stream()
                    .collect(Collectors.partitioningBy(o -> o.getAmount() > 1000));
            System.out.println(partitioned);


        }
    }

