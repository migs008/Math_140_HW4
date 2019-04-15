
public class TestHWFour {

    // create a Person object
    public static Person createObject(String firstName, String lastName, int age) {
        return new Person(new String(firstName), new String(lastName), age);
    }

    // display contents of the instance variables
    public static String getString(Person p) {
        return "Name = " + p.getFirstName() + " " + p.getLastName()
                + " age: " + p.getAge();
    }

    // display contents of a PersonArrayList
    public static void display(PersonArrayList pal) {
        for (int i = 0; i < pal.size(); i++) {
            System.out.println(i + ": " + getString(pal.get(i)));
        }
    }

    // display contents of a Person array
    public static void display(Person[] perArr) {
        for (int i = 0; i < perArr.length; i++) {
            System.out.println(i + ": " + getString(perArr[i]));
        }
    }

    public static void main(String[] args) {

        Person[] perArr = {createObject("Pilar", "Smith", 45), createObject("Max", "Jay", 11),
                createObject("Abigail", "Zee", 15), createObject("Abigail", "Zee", 14),
                createObject("Jim", "Zee", 15), createObject("Jackson", "Mason", 44),
                createObject("Juan", "Jay", 5), createObject("Carlos", "Mason", 54),
                createObject("Kyle", "Mason", 62), createObject("Xaviar", "Austin", 23),
                createObject("Xaviar", "Austin", 51), createObject("Juan", "Jay", 5),
                createObject("Juan", "Jay", 5),createObject("Juan", "Jay", 5),
                createObject("Juan", "Jay", 17), createObject("Ava", "Kim", 33)};

        PersonArrayList pal = new PersonArrayList(6);
        for (Person p : perArr) { // add Person objects to the PersonArrayList
            pal.add(p);
        }

        System.out.println("Testing indexOf and lastIndexOf");
        Person p = new Person("Raul", "Monday", 11);
        int index = pal.indexOf(p);
        if (index == -1) {
            System.out.println("Raul Monday Age 11 not in the PersonArrayList." );
        } else {
            System.out.println("Raul Monday Age 11 in the PersonArrayList\n"
                    + "1st index: " + index);
        }
        index = pal.lastIndexOf(p);
        if (index == -1) {
            System.out.println("Raul Monday Age 11 not in the PersonArrayList.\n" );
        } else {
            System.out.println("Raul Monday Age 11 in the PersonArrayList\n"
                    + "last index: " + index);
        }

        p = new Person("Juan", "Jay", 5);
        index = pal.indexOf(p);
        if (index == -1) {
            System.out.println("Juan Jay Age 5 not in the PersonArrayList.\n" );
        } else {
            System.out.println("Juan Jay Age 5 in the PersonArrayList\n"
                    + "1st index: " + index);
        }
        index = pal.lastIndexOf(p);
        if (index == -1) {
            System.out.println("Juan Jay Age 5 not in the PersonArrayList.\n" );
        } else {
            System.out.println("Juan Jay Age 5 in the PersonArrayList\n"
                    + "last index: " + index);
        }

        System.out.println("\nTesting 2nd Constructor");
        PersonArrayList palTwo = new PersonArrayList(pal);
        System.out.println("Number of elements in pal: " + pal.size());
        System.out.println("Number of elements in palTwo: " + palTwo.size());

        System.out.println("\nChanging values in 1st element of pal: ");
        pal.get(0).setFirstName("Emma");
        pal.get(0).setLastName("Ess");
        pal.get(0).setAge(29);

        System.out.println("Verifying that 1st of pal didn't change " +
                "1st element of palTwo");
        System.out.println("Displaying pal.get(0): ");
        System.out.println(pal.get(0));
        System.out.println("Displaying palTwo.get(0): ");
        System.out.println(palTwo.get(0));
        System.out.println("\nDisplaying contents of pal: ");
        display(pal);
        System.out.println("\nTesting removeIf: ");
        if (pal.removeIf(new Evaluator())){
            System.out.println("Contents of pal after removing " +
                    "last names with length > 3 and age < 50");
            display(pal);
        }
        else{
            System.out.println("No elements removed after calling removeIf");
        }
        if (pal.removeIf(new Evaluator())){
            System.out.println("Contents of pal after removing " +
                    "last names with length > 3 and age < 50");
            display(pal);
        }
        else{
            System.out.println("\nNo elements removed after calling removeIf for 2nd time");
        }

        System.out.println("\nTesting retainAll: ");
        if (palTwo.retainAll(pal)){
            System.out.println("Contents of palTwo after removing values not in pal ");
            display(palTwo);
        }
        else{
            System.out.println("No elements removed from palTwo after calling retainAll");
        }


        if (palTwo.retainAll(palTwo)){
            System.out.println("Contents of palTwo after removing values not in palTwo ");
            display(palTwo);
        }
        else{
            System.out.println("\nNo elements removed from palTwo after calling retainAll for "
                    + " second time");
        }


        PersonArrayList palThree = new PersonArrayList(4);
        palThree.add(createObject("Juan", "Jay", 5));
        palThree.add(createObject("Juan", "Jay", 17));
        palThree.add(createObject("Kyle", "Mason", 62));

        System.out.println("\nTesting removeAll: ");
        System.out.println("\nContents of pal3: ");
        display(palThree);
        if (palTwo.removeAll(palThree)){
            System.out.println("\nContents of palTwo after removing values  in palThree ");
            display(palTwo);
        }
        else{
            System.out.println("\nNo elements removed from palTwo after calling removeAll");
        }

        if (palTwo.removeAll(palThree)){
            System.out.println("\nContents of palTwo after removing values  in palThree ");
            display(palTwo);
        }
        else{
            System.out.println("\nNo elements removed from palTwo after calling removeAll " +
                    " for the second time");
        }


    }
}
