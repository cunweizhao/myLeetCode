package com.zcw.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: my-leetcode
 * @description: 无重复字符的最长子串
 * @author: Zhaocunwei
 * @create: 2021-01-13 14:59
 **/

public class Test3 {
    public static int lengthOfLongestSubstring(String s) {

        if(s==null|| s.length()==0){
            return 0;
        }
        //........................失败思路一.................................
//        Set<Character> characterSet = new HashSet<Character>();
//
//        for(int i=0;i<s.length();i++){
//            char c = s.charAt(i);
//            /**
//             * 通过循环，先把字符串中的所有字节遍历出来，
//             * 然后再进行相关操作，意思先拿到，再说，其他的骚操作
//             *
//             * Set容器具有去重的功能，可以添加到这里面,
//             * 但是如果单纯使用set集合还是不能满足案例3
//             */
//            characterSet.add(c);
//        }
//        return characterSet.size();
        // ....................思路二.....................
        /**
         * 通上面我们分析，知道单纯的set集合，
         * 是不能满足，大概的思路就是我们需要遍历字符串
         * 同时还有不确定数量个数的list容器集合，
         * 创建一个list容器集合，然后遍历获取
         * 到的字符串是否包含在集合里面，如果包含就创建
         * 新的list集合，同时把之前的list 集合的size 存放到
         * 刚初始化的countLsit集合里面，最后倒序countList,
         * 获取最大值，然后返回好了。
         */

        //用来存放list长度，然后最后再倒序，获取最大值

        List<Integer> countList = new ArrayList<>();

        List<Character> characterList = new ArrayList<>();

        if(s.length()==1){
            return 1;
        }
        char c1 = s.charAt(0);
        characterList.add(c1);
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(characterList.contains(c)){
                countList.add(characterList.size());
                characterList.clear();
            }else{
                characterList.add(c);
            }
        }
        if(countList.size()>0){
            return countList.get(0);
        }

        return 0;
    }

    public static void main(String[] args) {
        //案例1：
        String s1="abcabcbb";
        int i = Test3.lengthOfLongestSubstring(s1);
        System.out.println(i);
        //案例2：
        String s2="bbbbb";
        int i1 = Test3.lengthOfLongestSubstring(s2);
        System.out.println(i1);
        //案例3：
        String s3="pwwkew";
        int i2 = Test3.lengthOfLongestSubstring(s3);
        System.out.println(i2);

    }
}
