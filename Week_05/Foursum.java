import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foursum {
    //超时
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return null;
        Arrays.sort(nums); //[-2, -1, 0, 0, 1, 2]
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0) {
                while (i < nums.length - 3 && nums[i] == nums[i - 1]) i++;
            }
            if (nums[i] + nums[i + 1] + nums[nums.length - 2] + nums[nums.length - 1] > target) break;
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j > i + 1) {
                    while (j < nums.length - 2 && nums[j] == nums[j - 1]) j++;
                }
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[m], nums[n]);
                        resList.add(temp);
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m - 1]) m++;
                        while (m < n && nums[n] == nums[n + 1]) n--;
                    } else if (sum < target) {
                        m++;
                        while (m < n && nums[m] == nums[m - 1]) m++;
                    } else {
                        n--;
                        while (m < n && nums[n] == nums[n + 1]) n--;
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        Foursum foursum = new Foursum();
        List<List<Integer>> lists = foursum.fourSum(nums, 0);
        System.out.println(lists);
    }
}
