package DataStructure;

class AdjMatrix {

	private int matrix[][] = new int[10][10];
	private int totalV=0;
	
	public void insertVertex(int v) {
		totalV++;
	}
	
	public void insertEdge(int v1, int v2) {
		if (v1>=totalV || v2>=totalV)
			System.out.println("그래프에 없는 정점입니다!!");
		else
			matrix[v1][v2] = 1;
	}
	
	public void printMatrix() {
		for (int i=0; i<totalV; i++) {
			System.out.println("\t\t");
			for (int j=0; j<totalV; j++) {
				System.out.print(" " +matrix[i][j]);
			}
		}
	}
	
	
}
