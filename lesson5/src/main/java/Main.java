public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Alexandr","Funkner", "Alexandrovich", 23, "just.funkner@gmail.com", "877783885950","Middle Developer", 1450,"USD");
        employees[1] = new Employee("Ivan","Coi", "Evgenevich", 42, "coi_I@gmail.com", "87055411123","Senior Developer", 2000,"USD");
        employees[2] = new Employee("Ekaterina","Kruglik", "Nikolaevna", 18, "kriglik_00@gmail.com", "87014125618","Junior QA", 300,"USD");
        employees[3] = new Employee("Anastasiya","Funkner", "Alexandrovane", 20, "funkner_a@gmail.com", "87012181312","Middle Administrator", 600,"USD");
        employees[4] = new Employee("Aliev","Ilyas", "Komirbaevich", 45, "aliev_k@gmail.com", "87772937895","Team Lead", 3500,"USD");

        for (Employee cur: employees) {
            if(cur.getAge() > 40)
                System.out.println(cur.toString());
        }
    }
}
