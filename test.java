import java.util.*;

public class test{

	public static void main(String[] args){
		
		Node[] graph = new Node[5];
		for (int i = 0 ; i < graph.length; i++){
			graph[i] = new Node(i);
		}
		for (int i = 1; i <= 3; i++){
			addEdge(graph, 0, i);
		}
		addEdge(graph, 4, 1);
		addEdge(graph, 4, 2);
		addEdge(graph, 4, 3);
		addEdge(graph, 4, 0);

		bfs(graph, graph[0], graph[4]);
	}

	static void bfs(Node[] graph, Node u, Node target){
		for (Node v : graph){
			v.dist = 1000;
		}
		u.dist = 0;
		Queue<Node> h = new LinkedList<Node>();
		h.add(u);
		while (h.size() > 0){
			Node s = h.poll();
			for (Node v : s.adj){
				if (v.dist == 1000){
					v.n ++;
					v.dist = s.dist + 1;
					h.add(v);
				}
				else {
					if (v.dist == s.dist + 1){
						// found another shortest path from u to v
						v.n ++;
					}
				}

			}
		}
		System.out.println(target.n);
	}

	static void addEdge(Node[] graph, int a, int b){
		graph[a].adj.add(graph[b]);
		graph[b].adj.add(graph[a]);
	}

	static class Node{
		int value;
		int n;
		int dist;
		LinkedList<Node> adj;

		Node(int value){
			this.value = value;
			adj = new LinkedList<Node>();
			n = 0;
		}
	}
}