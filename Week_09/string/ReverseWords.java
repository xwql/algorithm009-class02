package string;

public class ReverseWords {
    public String reverseWords(String s) {
        String newS = s.trim();
        String[] str = newS.split("\\s+");
        int left = 0, right = str.length - 1;
        while (left < right) {
            String temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (String st : str) {
            sb.append(st).append(" ");
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(" ".trim());
    }
}
