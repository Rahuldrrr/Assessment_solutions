public class Set3 {
    public static void main(String[] args) {
        String str = "$180,240/y";
        int result = convertStringToInteger(str);
        System.out.println("Converted integer: " + result);
    }

    public static int convertStringToInteger(String str) {
      
        String numericString = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericString);
    }
}

