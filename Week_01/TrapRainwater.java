//雨水
public class TrapRainwater {
    public int trap(int[] height) {
        int capacity = 0;
        int i = 0;
        int max = 0;
        //从左往右扫
        while (i < height.length) {
            if (height[max] <= height[i]) {
                capacity += calculateCapacity(height, max, i);
                max = i;
            }
            i++;
        }
        int rightMax = --i;
        //从右往左扫
        while (i >= max) {
            if (height[rightMax] <= height[i]) {
                capacity += calculateCapacity(height, i, rightMax);
                rightMax = i;
            }
            i--;
        }

        return capacity;
    }

    //计算两坐标之间容量
    private int calculateCapacity(int[] height, int left, int end) {
        if (left == end)
            return 0;
        int decr = 0;
        int k = left + 1;
        while (k < end) {
            decr += height[k];
            k++;
        }
        return (end - left - 1) * Math.min(height[left],height[end]) - decr;
    }
}
