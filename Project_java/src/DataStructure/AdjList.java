package DataStructure;

class AdjList {

	private GraphNode head[] = new GraphNode[10];
	private int totalV = 0;
	
	public void insertVertex(int v) {
		totalV++;
	}

	public void insertEdge(int v1, int v2) {
		if (v1>=totalV || v2>=totalV)
			System.out.println("그래프에 없는 정점입니다!!");
		else {
			GraphNode gNode = new GraphNode();
			gNode.vertex = v2;
			gNode.link = head[v1];
			head[v1] = gNode;
		}
	}

	public void printAdjList() {
		GraphNode gNode = new GraphNode();
		for (int i=0; i<totalV; i++) {
			System.out.print("\n정점" +(char)(i+65)+ "의 인접리스트");
			gNode = head[i];
			
			while (gNode != null) {
				System.out.print("-> " +(char)(gNode.vertex+65));
				gNode = gNode.link;
			}
		}
	}
	
	public void DFS(int v) {
		GraphNode w = new GraphNode();
		LinkedStack S = new LinkedStack();
		boolean visited[] = new boolean[10];
		S.push(v);
		visited[v] = true;
		System.out.print(" " +(char)(v+65));
		
		while (S.top != null) {
			w = head[v];
			while (w!=null) {
				if (visited[w.vertex]==false) {
					S.push(w.vertex);
					visited[w.vertex] = true;
					System.out.print(" " +(char)(w.vertex+65));
					v = w.vertex;
					w = head[v];
				}
				else w = w.link;
			}
			v = S.pop();
		}
	}
	
	public void BFS(int v) {
		GraphNode w = new GraphNode();
		LinkedQueue Q = new LinkedQueue();
		boolean visited[] = new boolean[10];
		visited[v] = true;
		System.out.print(" " +(char)(v+65));
		Q.enQueue(v);
		
		while (!Q.isEmpty()) {
			v = Q.deQueue();
			for (w=head[v]; w!=null; w=w.link) {
				if (visited[w.vertex]==false) {
					visited[w.vertex] = true;
					System.out.print(" " +(char)(w.vertex+65));
					Q.enQueue(w.vertex);
				}
			}
		}
	}
	
}
