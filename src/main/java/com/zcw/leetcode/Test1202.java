package com.zcw.leetcode;


import java.util.*;

/**
 * @ClassName : Test1202
 * @Description : 1202.交换字符串中的元素
 * @Author : zhaocunwei
 * @Date: 2021-01-11 21:16
 */
public class Test1202 {

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        //初始化连通图，把字符串的长度传到对象的构造方法总
        DisjointSetUnion dsu = new DisjointSetUnion(s.length());

        //遍历传递的参数
        for (List<Integer> pair : pairs) {
            //合并： 传递：参数0，1是因为我们传递的数组只包含两个数据，索引-0 ，索引-1
            dsu.unionSet(pair.get(0), pair.get(1));
        }
        //使用map存储祖先节点到子节点列表的映射，存储并查集结果
        //例如s = "dcab", pairs = [[0,3],[1,2]]
        //0:[d,b]  1:[c,a]
        Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();

        for (int i = 0; i < s.length(); i++) {
            //找到该节点的父节点
            int parent = dsu.find(i);
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<Character>());
            }
            map.get(parent).add(s.charAt(i));
        }
        //对map中的值进行排序
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<Character>() {
                public int compare(Character c1, Character c2) {
                    return c2 - c1;
                }
            });
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int x = dsu.find(i);
            List<Character> list = map.get(x);
            sb.append(list.remove(list.size() - 1));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();


        List<Integer> pair = new ArrayList<Integer>();
        pair.add(0);
        pair.add(3);
        pairs.add(pair);

        List<Integer> pair1 = new ArrayList<Integer>();
        pair1.add(1);
        pair1.add(2);
        pairs.add(pair1);

        String s1 = Test1202.smallestStringWithSwaps(s, pairs);
        System.out.println(s1);
    }
}

/**
 * 定义并差集类
 */

class DisjointSetUnion {
    /**
     * 并差集长度
     */
    int n;
    /**
     * 节点等级
     */
    int[] rank;

    /**
     * 存储对应的祖先节点
     */
    int[] f;

    /**
     * 构造函数,初始化属性
     */
    public DisjointSetUnion(int n) {
        //字符串长度赋值给，对象属性
        this.n = n;
        //初始化当前对象数组，长度为字符串长度
        rank = new int[n];

        //rank是对象中数组变量，1是一个rank中元素数据类型的值，作用：填充rank数组中的每个元素都是1
        Arrays.fill(rank, 1);
        //初始化数组，用来存放对应的祖先结点
        f = new int[n];
        //遍历字符串长度，然后填充数组f，为后续的递归进行操作数据
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }

    /**
     * 方法find,寻找已经传递节点的祖先
     */
    public int find(int x) {
        //三元表达式，递归调用当前方法，相等后返回数据
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    /**
     *  合并到一个图中，共同有一个祖先
     */
    public void unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return;
        }
        if (rank[fx] < rank[fy]) {
            //swap(fx,fy);
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        //fx级别高，要作为祖先
        rank[fx] += rank[fy];
        f[fy] = fx;
    }
}