import java.util.Arrays;

public class PersonArrayList {

    private int size = 0;
    private Person[] list;

//          Constructor
//        • Allocates memory for the list array
//        • Assigns a copy of the Person objects in personArrayList to the list array. [ Use
//        the copy method from the Person class.]
//        • Assigns the size of personArrayList to the size of the current PersonArrayList
//        object.

    public PersonArrayList(PersonArrayList personArrayList) {
        int personArrayListLength = personArrayList.size; // why personArrayList.length not work?

        this.list

        return list[personArrayList.length];



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



}
