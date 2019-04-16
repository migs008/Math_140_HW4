/*
Author: Miguel Aquino
Date: 4/15/2019
Purpose: An Evaluator class that implements PersonEvaluator. Test method returns true when a Person object’s lastName has a length greater than 3 and an age
less than 50. Otherwise, the method returns false.
*/

public class Evaluator implements PersonEvaluator {
    @Override
    public boolean test(Person a) {
        boolean flag = false;
        if (a.getLastName().length() > 3 && a.getAge() < 50) {
            flag = true;
        }
        return flag;
    }

}