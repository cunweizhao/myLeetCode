package com.zcw.leetcode;

import java.util.Arrays;

/**
 * @program: my-leetcode
 * @description: 两数之和
 * @author: Zhaocunwei
 * @create: 2021-01-12 11:25
 **/

public class Test1 {
    /**
     * 看到此题，我们大家肯定会想到，最简单的解题技巧
     * 遍历数组，然后从索引为0的数据开始，加法计算
     * 如果计算的结果等于我们传入的target ，直接返回
     * 两个数的索引
     */
    public static int[] twoSum(int[] nums, int target){
        int[] temp = new int[2];
        int t=0,y=0;
        for(int i=0;i<nums.length;i++){

            //int num = nums[i];
            /**
             * 下面这个方法不适合：
             *  int[] nums ={3,2,3};
             *  int target=6;
             */
//            if((i+1)<nums.length){
//                int num1 = nums[i + 1];
//                if((num +num1) == target){
//                    temp[0]=i;
//                    temp[1]=i+1;
//                    return temp;
//                }
//            }
            /////////////////////////////////
            /**
             * 下面方法不适合
             * int[] nums ={3,3};
             * int target=6;
             */
            //然后获取的这个数据，与数组进行匹配，同时返回索引
//            int t = target-num;
//            int y = Arrays.binarySearch(nums, t);
//            if(y>0){
//                temp[0]=i;
//                temp[1]=y;
//                return temp;
//            }
            ///////////////////////////////////
//            [2,5,5,11]
//            10
//            int t = target-num;
//            int y = Arrays.binarySearch(nums, t);
//            if(y==0){
//                temp[0]=i;
//                temp[1]=i+1;
//                return temp;
//            }
//
//            if(y>0){
//                temp[0]=i;
//                temp[1]=y;
//                return temp;
//            }
            ////////////
//             t = target-num;
//            if(i+1<nums.length){
//                y=nums[i+1];
//                if(t==y){
//                    temp[0]=i;
//                    temp[1]=i+1;
//                    return temp;
//                }
//
//            }
//            for(int z=1;z<nums.length;z++){
//                int a = nums[z];
//                if(a==t){
//                    temp[0]=i;
//                    temp[1]=z;
//                    return temp;
//                }
//            }



            //////////////

            int num = nums[i];
            t=target-num;
            for(int z=i+1;z<nums.length;z++){
                y= nums[z];
                if(t==y){
                    temp[0]=i;
                    temp[1]=z;
                    return temp;
                }
            }

            ///////////////
        }
        return null;
    }


    public static void main(String[] args) {
//        int[] nums ={2,7,11,15};
//        int target = 9;

//        int[] nums={3,2,4};
//        int target =6;
        /**
         * 解析下面的试题时，报错，
         * 然后开始换位计算：
         * 遍历数组，获取第一个数据后
         * 使用传递的数据减去第一个数据，
         * 获取到的数据，去匹配数组里面是否包含
         * 当前数据，然后得到索引数据，直接返回
         */
//        int[] nums ={3,2,3};
//        int target=6;

        //int[] nums ={3,3};
        //int target=6;

        int[] nums={1,3,4,2};
        int target=6;

        int[] ints = Test1.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
