package everyday;

public class AddDigits {
    public int addDigits(int num) {
        int x = num % 10;
        while (num / 10 != 0) {
            num = num / 10;
            x += num % 10;
        }
        if (x < 10) return x;
        return addDigits(x);
    }
}
