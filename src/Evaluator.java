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