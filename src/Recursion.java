import java.util.Scanner;

public class Recursion {

    public static void main(String[] args) {
        System.out.println("Enter expression: ");
        Scanner inp = new Scanner(System.in);
        try {
            System.out.println(calculus((inp.next())));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private static int countSymbol(char symbol, String pattern){
        int countS = 0;
        for (int i = 0; i < pattern.length(); ++i) {
            if (pattern.charAt(i) == symbol) countS++;
        }
        return countS;
    }
    private static boolean ifBracketsEqual(String pattern) {
        return (countSymbol('(', pattern) == countSymbol(')', pattern));
    }
    private static int indexOfCharacter (char symbol, String patternString, boolean fromBegin){
        int index = -1;
        int flag = 0;
        char [] pattern = patternString.toCharArray();
        for (int i = 0; i < pattern.length; ++i) {
            if (pattern [i] == symbol && flag == 0)
                if (fromBegin) return i;
                else index = i;
            if (pattern [i] == '(') ++flag;
            if (pattern [i] == ')') --flag;
        }
        return index;
    }
    private static int indexOfOperator(String pattern) {
        int indOp;
        if ((indOp = indexOfCharacter('+', pattern, false)) !=-1) return indOp;
        if ((indOp = indexOfCharacter('-', pattern, false)) !=-1) return indOp == 0 ? -1 : indOp;
        if ((indOp = indexOfCharacter('*', pattern, false)) !=-1) return indOp;
        if ((indOp = indexOfCharacter('/', pattern, false)) !=-1) return indOp;
        if ((indOp = indexOfCharacter('^', pattern, false)) !=-1) return indOp;
        if ((indOp = indexOfCharacter('%', pattern, false)) !=-1) return indOp;
        return -1;
    }
    private static String removeBrackets (String patternString){
        int indOp = indexOfOperator(patternString);
        if (patternString.length() > 1 && indOp == -1)
            if (patternString.charAt(0) == '(' && patternString.charAt(patternString.length()-1) == ')')
                patternString = removeBrackets(patternString.substring(1,patternString.length()-1));
        return patternString;
    }
    private static String cutPattern (String pattern, int length){
        return pattern.substring(length, pattern.length() - 1);
    }
    private static double mathOperator (String pattern) throws Exception {
        double sum = 0;
        String [] parts;
        String operat;

        try {
            parts = pattern.split("\\(");
            operat = parts [0];
            switch (switchOperator(operat)){
                case 1:
                    if (pattern.length() > 1)
                        pattern = pattern.substring(1, pattern.length() - 1);
                    sum += Math.E;
                    break;
                case 2:
                    pattern = cutPattern(pattern, 4);
                    sum += Math.sin(Math.PI * calculus(pattern) / 180);
                    break;
                case 3:
                    pattern = cutPattern(pattern, 4);
                    sum += Math.cos(Math.PI * calculus(pattern) / 180);
                    break;
                case 4:
                    pattern = cutPattern(pattern, 4);
                    String[] tempString = new String[2];
                    int ind = indexOfCharacter(';', pattern, true);
                    tempString[0] = pattern.substring(0, ind);
                    tempString[1] = pattern.substring(ind + 1);
                    sum += Math.pow(calculus(tempString[0]), calculus(tempString[1]));
                    break;
                case 5:
                    pattern = cutPattern(pattern, 5);
                    sum += Math.sqrt(calculus(pattern));
                    break;
                case 6:
                    pattern = cutPattern(pattern, 3);
                    sum += Math.log(calculus(pattern));
                    break;
                case 7:
                    pattern = cutPattern(pattern, 3);
                    sum += Math.log10(calculus(pattern));
                    break;
                case 8:
                    pattern = cutPattern(pattern, 4);
                    sum += Math.abs(calculus(pattern));
                    break;
                case 9:
                    pattern = cutPattern(pattern, 4);
                    tempString = new String[2];
                    ind = indexOfCharacter(';', pattern, true);
                    tempString[0] = pattern.substring(0, ind);
                    tempString[1] = pattern.substring(ind + 1);
                    sum += Math.max(calculus(tempString[0]), calculus(tempString[1]));
                    break;
                default:
                    sum += Double.parseDouble(pattern);
                    break;

            }
            return sum;
        } catch (Exception e) {
            throw new Exception("Check pattern: " + pattern);
        }
    }

    private static int switchOperator (String pattern) {
        if (pattern.equalsIgnoreCase("e")) return 1;
        if (pattern.equalsIgnoreCase("sin")) return 2;
        if (pattern.equalsIgnoreCase("cos")) return 3;
        if (pattern.equalsIgnoreCase("pow")) return 4;
        if (pattern.equalsIgnoreCase("sqrt")) return 5;
        if (pattern.equalsIgnoreCase("ln")) return 6;
        if (pattern.equalsIgnoreCase("lg")) return 7;
        if (pattern.equalsIgnoreCase("abs")) return 8;
        if (pattern.equalsIgnoreCase("max")) return 9;

        return 0;
    }

    static double calculus (String pattern) throws Exception {
        pattern = pattern.replace(" ", "");

        if (pattern.charAt(0) == '-') return (calculus("0" + pattern));
        pattern = removeBrackets(pattern);
        if (!ifBracketsEqual(pattern)) throw new Exception("Braces unequal");
        int indOp = indexOfOperator(pattern);
        if (indOp == -1) {
            return (mathOperator(pattern));
        }
        switch (pattern.toCharArray()[indOp]){
            case '*':
                return calculus(pattern.substring(0,indOp)) * calculus(pattern.substring(indOp + 1));
            case '+':
                return calculus(pattern.substring(0,indOp)) + calculus(pattern.substring(indOp + 1));
            case '/':
                return calculus(pattern.substring(0,indOp)) / calculus(pattern.substring(indOp + 1));
            case '^':
                return Math.pow(calculus(pattern.substring(0,indOp)), calculus(pattern.substring(indOp + 1)));
            case '-':
                return calculus(pattern.substring(0,indOp)) - calculus(pattern.substring(indOp + 1));
            case '%':
                return calculus(pattern.substring(0,indOp)) % calculus(pattern.substring(indOp + 1));
            default:
                return 0;
        }
    }

}
