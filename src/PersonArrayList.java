/*
Author: Miguel Aquino
Date: 4/15/2019
Purpose: A PersonArrayList class.
*/

import java.util.Arrays;

public class PersonArrayList {

    private int size = 0;
    private Person[] list;

    /*
    Purpose: Constructor that allocates memory for the list array and assigns a copy of the Person objects in personArrayList to the list array. Also assigns the size of personArrayList to the size of the current PersonArrayList object.
    Parameters: PersonArrayList object
    Return: None
    */
    public PersonArrayList(PersonArrayList personArrayList) {

        int personArrayListSize = personArrayList.size;

        this.list = new Person[personArrayListSize];

        for (int i = 0; i < list.length; i++) {
            this.list[i] = personArrayList.list[i].copy();
        }

        this.size = personArrayListSize;

    }

    public PersonArrayList(int capacity) {
        list = new Person[capacity];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int capacity) {

        if (capacity > list.length) {
            Person[] tmp = new Person[capacity];
            System.arraycopy(list, 0, tmp, 0, list.length);
            list = tmp;
        }
    }

    public void add(Person p) {

        if (size >= list.length) {
            ensureCapacity(2 * list.length);
        }
        list[size] = p;
        size++;
    }

    public Person remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Person tmp = list[index];
        System.arraycopy(list, index + 1, list, index, size - index - 1);
        size--;
        return tmp;
    }

    public Person[] sort() {

        Person[] perArr = new Person[size];
        System.arraycopy(list, 0, perArr, 0, size);
        Arrays.sort(perArr);
        return perArr;
    }

    public PersonArrayList greaterThan(Person p) {

        PersonArrayList pal = new PersonArrayList(10);
        for (int i = 0; i < size; i++) {
            if (list[i].compareTo(p) > 0) {
                pal.add(list[i]);
            }
        }
        return pal;
    }

    public Person get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public boolean remove(Person p) {

        boolean flag = false;
        int index = 0;
        while (index < size && !flag) {
            flag = list[index].equals(p);
            if (!flag) {
                index++;
            }
        }
        if (flag) {
            System.arraycopy(list, index + 1, list, index, size - index - 1);
            size--;
        }
        return flag;
    }

    public void add(int index, Person p) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size >= list.length) {
            ensureCapacity(2 * list.length);
        }
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = p;
        size++;
    }
    /*
    Purpose: Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    Parameters: Person object
    Return: Index of the first occurrence of specified element.
     */
    public int indexOf(Person p) {

        int index = -1;

        for (int i = 0; i < size && index == -1; i++) {
            if (p.equals(list[i])) {
                index = i;
            }
        }
        return index;
    }

    /*
     Purpose: Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     Parameters: Person object
     Return: Index of the last occurrence of specified element.
     */
    public int lastIndexOf(Person p) {

        int index = -1;

        for (int i = size - 1; i >= 0 && index == -1; i--) {
            if (p.equals(list[i])) {
                index = i;
            }
        }
        return index;
    }

    /*
     Purpose: Removes from the current PersonArrayList object all of its elements that are equal to a Person object in the input parameter. Returns true if at least one Person object is removed. Otherwise, return false.
     Parameters: PersonArrayList object
     Return: boolean value if condition is met.
     */
    public boolean removeAll(PersonArrayList personArrayList) {

        boolean flag = false;

        for (int i = size - 1; i >= 0; i--) {
            if (personArrayList.contains(list[i])) {
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    /*
     Purpose: Retains only the elements in the current PersonArrayList that are equal to a Person object in the input parameter. Returns true if at least one Person object is removed. Otherwise, return false.
     Parameters: PersonArrayList object
     Return: boolean value if condition is met.
     */
    public boolean retainAll(PersonArrayList personArrayList) {

        boolean flag = false;

        for (int i = 0; i < size; i++) {
            if (!personArrayList.contains(list[i])) {
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    /*
     Purpose: Removes from the current PersonArrayList object all Person objects that causes the test method to return true. The method returns true if at least one Person object is removed. Otherwise, return false.
     Parameters: PersonEvaluator object.
     Return: boolean value if condition is met.
     */
    public boolean removeIf(PersonEvaluator eval) {

        boolean flag = false;

        for (int i = size - 1; i >= 0; i--) {
            if (eval.test(list[i])) {
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    /*
     Purpose: Checks to see if Person object is stored in PersonArrayList object.
     Parameters: Person object
     Return: boolean value if condition is met.
     */
    private boolean contains(Person p) {
        boolean flag = false;

        for (int i = 0; i < size && !flag; i++) {
            if (list[i].equals(p)) {
                flag = true;
            }
        }

        return flag;
    }
}
