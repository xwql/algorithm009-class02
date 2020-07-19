学习笔记
#### 不同路径2的状态转移方程
使用二维数组存储中间状态的状态转移方程<br/>
``` dp[i][j] = (obstacleGrid[i - 1][j] == 0 ? dp[i - 1][j] : 0) + (obstacleGrid[i][j - 1] == 0 ? dp[i][j - 1] : 0);```

简单一点写就是用

``` java
if (obstacleGrid[i][j] == 1)
         continue;
dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
```

全部代码：

```java
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
```

