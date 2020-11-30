package com.example.java8.extra.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class AlgorithmEasy {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, nums.length)
                .mapToObj(v -> {
                    if (map.containsKey(target - nums[v])) {
                        return new int[]{map.get(target - nums[v]), v};
                    }
                    map.put(nums[v], v);
                    return null;
                });
        return null;
    }

    //回文数
    public boolean isPalindrome(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    //最长公共前缀,以第一个开始，每个都和第一个进行比较，如果从第一个就不一样，
    // 说明没有前缀，即ans为空格，直接返回，先取出最小的公共前缀，用subString截取依次比较
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }

    /**
     * 括号放进去
     */
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) stack.addLast(c);
            else if (map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }

    /**
     * 删除重复项
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 移除元素
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 求a在b中第一次出现的位置
     */
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 返回目标值在数组的索引
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //后半部分有序
            if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else {
                if (nums[mid] > target && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 求目标值target的数组下标起点和终点位置
     */
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                //left为false就是跳过第一个再次往下判断最后一个
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    /**
     * 数独，在索引下插入
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 和最大的
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {

            sum = Math.max(sum + nums[i], nums[i]);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     * 蛇形数组都要加进去
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    /**
     * 跳跃数组是否能打到终点
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 最后一个空格的字符串长度
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }

    /**
     * 加一
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    //平方根
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //爬楼梯 一次爬一个或者两个 有几种方法能爬上去
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    //去除重复元素
    public AlgorithmMedium.ListNode deleteDuplicates(AlgorithmMedium.ListNode head) {
        AlgorithmMedium.ListNode current = head;
        while(current != null && current.next != null) {
            if(current.next.val == current.val) current.next = current.next.next;
            else current = current.next;
        }
        return head;
    }

    //不同的二叉搜索树
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    //判断两棵树是否相同
    public boolean isSameTree(AlgorithmMedium.TreeNode p, AlgorithmMedium.TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    //树的最大深度
    public int maxDepth(TreeNode root) {
        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size ; i++) {
                TreeNode curr = queue.remove();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            ans++;
        }
        return ans;
    }

    //自底向上的二叉树的层次遍历  就是层次遍历+list.add(0,list)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }

    //有序数组转换为平衡二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    //二叉树最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

    //二叉树是否有根到叶子总和为sum的
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //打印出所有节点总和等于sum的数组
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        pathSum(root, sum, new ArrayList<Integer>());
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(path);
            return ;
        }
        if (root.left != null) pathSum(root.left, sum-root.val, new ArrayList<Integer>(path));
        if (root.right != null) pathSum(root.right, sum-root.val, new ArrayList<Integer>(path));
    }

    //一次购买 买股票的最佳时机
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    //多次购买 买股票的最佳时机
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    //二叉树的前序遍历，根节点压栈 然后取数栈的时候最后取根节点
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pollLast();
            output.add(curr.val);
            if(curr.right != null) stack.add(curr.right);
            if(curr.left != null) stack.add(curr.left);
        }
        return output;
    }

    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    //数组旋转后求旋转的最小值
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {                         // 循环的条件选为左闭右闭区间left <= right
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[right]) {             // 注意是当中值大于等于右值时，
                left = mid + 1;                         // 将左边界移动到中值的右边
            } else {                                    // 当中值小于右值时
                right = mid;                            // 将右边界移动到中值处
            }
        }
        return nums[right];                             // 最小值返回nums[right]
    }

    //有重复元素的
    public int findMin1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }

    public AlgorithmMedium.ListNode getIntersectionNode(AlgorithmMedium.ListNode headA, AlgorithmMedium.ListNode headB) {
        if (headA == null || headB == null) return null;
        AlgorithmMedium.ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    //二分法查找峰值
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    //数组在排序后相邻元素间最大差值
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > max) {
                max = nums[i + 1] - nums[i];
            }
        }
        return max;
    }

    //升序数组
    public int[] twoSum1(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

    //
    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n--; // 依次获取 26 进制逻辑上的个位、十位、百位…（虽然在 26 进制中不这么叫）
            stringBuilder.append((char) ('A' + n % 26));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
//        int count = 0;
//        Integer candidate = null;
//
//        for (int num : nums) {
//            if (count == 0) {
//                candidate = num;
//            }
//            count += (num == candidate) ? 1 : -1;
//        }
//
//        return candidate;
    }

    //返回excel的数组对应的下标
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    //阶乘后的0
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }

    //几个数组合最大数
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (arr[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for (String i : arr) {
            res.append(i);
        }
        return res.toString();
    }

    //查出数组中最小的k个数字
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if(input.length>=k&&k>0){
            Arrays.sort(input);
            for(int i=0;i<k;i++){
                result.add(new Integer(input[i]));
            }

        }
        return result;
    }

    //1-n中1出现的次数
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for(int i=1;i<=n;i*=10){  //i代表位数
            int high=n/(i*10); //更高位数字
            int low=(n%i);  //更低位数字
            int cur=(n/i)%10;  //当前位数字
            if(cur==0){
                count+=high*i;
            }else if(cur==1){
                count+=high*i+(low+1);
            }else{
                count+=(high+1)*i;
            }
        }
        return count;
    }

    //质数只包含2，3，5的是丑数  写出从小到大的低N个丑数
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        int p2 = 0, p3 = 0, p5 = 0;
        int[] result = new int[index];
        result[0] = 1;
        for(int i = 1; i < index; i++) {
            result[i] = Math.min(result[p2]*2,Math.min(result[p3]*3,result[p5]*5));
            if(result[i] == result[p2]*2) p2++;
            if(result[i] == result[p3]*3) p3++;
            if(result[i] == result[p5]*5) p5++;
        }
        return result[index - 1];
    }

    //求连续几个数和为s的序列
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start = 1 , end = 2;
        int curSum = 3;
        while(end < curSum) {
            if(curSum > sum) {
                curSum -= start;
                start++;
            } else if(curSum < sum){
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> cur = new ArrayList<>();
                for(int i = start; i<=end; i++) cur.add(i);
                res.add(cur);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return res;
    }

    //循环左移
    public String LeftRotateString(String str,int n) {
        if(n > str.length()) return str;
        String s = str.substring(n,str.length()) + str.substring(0,n);
        return s;
    }

    //小朋友转圈丢手绢问题
    public int LastRemaining_Solution(int n, int m) {
        int s = 0;
        if(m == 0) return -1;
        for(int i = 2; i <= n; i++) s = (s + m) % i;
        return s;
    }

    // 1+2+3+。。。+n
    public int Sum_Solution(int n) {
        int sum = n;
        boolean stop = (sum != 0) && ((sum += Sum_Solution(n-1))!=0);
        return sum;
    }

    //链表的环形头节点 ，这里可以ABD = X
    public AlgorithmMedium.ListNode EntryNodeOfLoop(AlgorithmMedium.ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return null;
        AlgorithmMedium.ListNode left = pHead;
        AlgorithmMedium.ListNode right = pHead;
        while(right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            if(left == right) break;
        }
        right = pHead;
        while(right != left) {
            right = right.next;
            left = left.next;
        }
        return right;
    }
}


