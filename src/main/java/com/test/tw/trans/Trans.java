package com.test.tw.trans;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Trans {

    private String[] vexs;
    private Integer[][] matrix;
    private Map<String, Integer> map1;
    public Map<Integer, String> map2;
    private int start;
    private int end;

    private static final int INF = Integer.MAX_VALUE;

    class Dijkstra {

        public String[] mVexs;
        private int[][] mMatrix;
        private static final int INF = Integer.MAX_VALUE;

        public Dijkstra(String[] vexs, Integer[][] matrix) {
            int vlen = vexs.length;
            mVexs = new String[vlen];
            for (int i = 0; i < mVexs.length; i++)
                mVexs[i] = vexs[i];
            mMatrix = new int[vlen][vlen];
            for (int i = 0; i < vlen; i++) {
                for (int j = 0; j < vlen; j++) {
                    mMatrix[i][j] = matrix[i][j];
                }
            }
        }

        public String dijkstra(int vs, int[] prev, int[] dist, int end) {
            boolean[] flag = new boolean[mVexs.length];
            int n = mVexs.length;
            String[] path1 = new String[n];
            for(int i=0;i<n;i++)
                path1[i]=new String(vs+"-->"+i);
            for (int i = 0; i < mVexs.length; i++) {
                flag[i] = false;
                prev[i] = 0;
                dist[i] = mMatrix[vs][i];
            }
            flag[vs] = true;
            dist[vs] = 0;
            int k=0;
            for (int i = 1; i < mVexs.length; i++) {
                int min = INF;
                for (int j = 0; j < mVexs.length; j++) {
                    if (flag[j]==false && dist[j]<min) {
                        min = dist[j];
                        k = j;
                    }
                }
                flag[k] = true;
                for (int j = 0; j < mVexs.length; j++) {
                    int tmp = (mMatrix[k][j]==INF ? INF : (min + mMatrix[k][j]));
                    if (flag[j]==false && (tmp<dist[j]) ) {
                        dist[j] = tmp;
                        prev[j] = k;
                        path1[j] = path1[k] + "-->" + j;
                    }
                }
            }
            for(int s = 0; s < n; s++) {
                if(s == end) {
                    if(dist[s]==INF) {
                        return null;
                    }else {
                        return path1[s];
                    }
                }
            }
            return null;
        }
    }

    public String getPath(String sourceId, String dstId) {
        Dijkstra pG = new Dijkstra(vexs, matrix);
        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        start = map1.get(sourceId);
        end = map1.get(dstId);
        return pG.dijkstra(start, prev, dist, end);
    }

    public static void main(String[] args) {

        String[] paths = new String[] {"AB5","BC4","CD8","DE6","AD5","CE2","EB3","AE7"};
        if (paths.length<3) {
            System.out.println("");
        }
        Set<String> nodes = new HashSet<String>();
        for(String path:paths) {
            String node0 = path.substring(0, 1);
            String node = path.substring(1, 2);
            nodes.add(node);
            nodes.add(node0);
        }
        Trans tran = new Trans();
        tran.init(nodes, paths);
    }

    public void init(Set<String> nodes, String[] paths) {
        map1 = new HashMap<String, Integer>();
        int len = nodes.size();
        String[] vex = new String[len];
        Integer[][] matri = new Integer[len][len];
        Iterator<String> iter = nodes.iterator();
        while (iter.hasNext()) {
            int i = 0;
            map1.put(iter.next(), i);
            i++;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    matri[i][j] = 0;
                } else {
                    matri[i][j] = INF;
                }
            }

        }
        for (String path:paths) {

        }

    }

}
