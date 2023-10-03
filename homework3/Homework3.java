package homework3;

public class Homework3 {

    /**
     * Является ли число четным
     * @param n целое число
     * @return true/false
     */
    public boolean evenOddNumber (int n){
        if (n % 2 == 0){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Попадает ли число в интервал (25; 100)
     * @param n целое число
     * @return true/false
     */
   public boolean numberInInterval(int n){
        if (n >= 25 && n <= 100) return true;
        return false;
   }
}
