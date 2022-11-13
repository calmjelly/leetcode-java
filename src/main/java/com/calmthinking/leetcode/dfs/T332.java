package com.calmthinking.leetcode.dfs;

import java.util.*;

/**
 * @Description: 332. 重新安排行程
 * @Author: Ybl
 * @Date: 2022/10/7 23:56
 */
public class T332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) {
            return ans;
        }
        Map<String,List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(to);
        }
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }
        dfs(graph, ans, "JFK");
        return ans;
    }

    private void dfs(Map<String, List<String>> graph, List<String> ans, String src) {
        List<String> list = graph.get(src);
        while (list != null && list.size() > 0) {
            String to = list.remove(0);
            dfs(graph, ans, to);
        }
        ans.add(0, src);
    }


}
