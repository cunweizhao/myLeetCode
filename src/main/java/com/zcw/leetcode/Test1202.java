package com.zcw.leetcode;


import java.util.*;

/**
 * @ClassName : Test1202
 * @Description : 1202.交换字符串中的元素
 * @Author : zhaocunwei
 * @Date: 2021-01-11 21:16
 */
public class Test1202 {

        public  static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            //初始化连通图
            DisjointSetUnion dsu = new DisjointSetUnion(s.length());
            for(List<Integer> pair:pairs){
                //合并
                dsu.unionSet(pair.get(0),pair.get(1));
            }
            //使用map存储祖先节点到子节点列表的映射，存储并查集结果
            //例如s = "dcab", pairs = [[0,3],[1,2]]
            //0:[d,b]  1:[c,a]
            Map<Integer,List<Character>> map =new HashMap<Integer,List<Character>>();
            for(int i =0;i<s.length();i++){
                int parent = dsu.find(i);//找到该节点的父节点
                if(!map.containsKey(parent)){
                    map.put(parent,new ArrayList<Character>());
                }
                map.get(parent).add(s.charAt(i));
            }
            //对map中的值进行排序
            for(Map.Entry<Integer,List<Character>> entry:map.entrySet()){
                Collections.sort(entry.getValue(),new Comparator<Character>(){
                    public int compare(Character c1,Character c2){
                        return c2-c1;
                    }
                });
            }
            StringBuffer sb = new StringBuffer();
            for(int i =0;i<s.length();i++){
                int x = dsu.find(i);
                List<Character> list =map.get(x);
                sb.append(list.remove(list.size()-1));
            }
            return sb.toString();

        }
    }
    //定义并差集类
    class DisjointSetUnion{
        int n;  //并查集长度
        int[] rank;  //节点等级
        int[] f;   //存储对应的祖先节点

        //构造函数,初始化属性
        public DisjointSetUnion(int n){
            this.n = n;
            rank = new int[n];
            Arrays.fill(rank,1);
            f = new int[n];
            for(int i=0;i<n;i++){
                f[i] = i;
            }
        }

        //方法find,寻找给节点的祖先
        public int find(int x){
            return f[x] == x?x:(f[x]=find(f[x]));
        }

        //合并到一个图中，共同有一个祖先
        public void unionSet(int x, int y) {
            int fx=find(x),fy = find(y);
            if(fx==fy){
                return;
            }
            if(rank[fx]<rank[fy]){
                //swap(fx,fy);
                int temp = fx;
                fx=fy;
                fy=temp;
            }
            //fx级别高，要作为祖先
            rank[fx] +=rank[fy];
            f[fy] = fx;
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