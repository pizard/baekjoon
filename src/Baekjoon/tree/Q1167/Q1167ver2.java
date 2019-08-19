package tree.Q1167;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q1167ver2 {

	
	/* 
	 * 트리의 지름
	 * 트레에서 임의의 두 점사이의 거리중 가장 긴 것
	 * 1: 정점의 개수
	 * 2: start Node / end Node / Distance / -1
	 */
	public static void main(String[] args) throws IOException{
		Q1167ver2 m = new Q1167ver2();
		m.call();
	}
	List<Edge>[] g;
	int n,m;
	boolean[] check;
	int[] dist;
	
	void call() throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		g = (List<Edge>[]) new List[n+1];
		check = new boolean[n+1];
		dist = new int[n+1];
		
		for(int i= 1; i<=n; i++){
			int v1 = sc.nextInt();
			int v2;
			
			g[v1] = new ArrayList<Edge>();
			
			while( (v2=sc.nextInt()) != -1){
				int w = sc.nextInt();
				// v1이란 Edge에 v2를 연결하고 cost를 w로 설정
				g[v1].add(new Edge(v2, w)); 
			}
		}

		
		// 1(start)로 부터의 거리 정리
		bfs(1);
		
		int max = dist[1];
		int idx = 1;
		
		
		// 거리 중 최대값 도출
		for( int i = 2; i<n; i++){
			if( max <dist[i]){
				idx=i;
				max = dist[i];
			}
		}
		
		Arrays.fill(check, false);
		Arrays.fill(dist,0);
		bfs(idx);
		max = dist[1];
		for(int i = 2; i<= n; i++){
			if( max < dist[i] ){
				max = dist[i];
			}
		}
		System.out.println(max);
		
	}
	
	
	void bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		check[start] = true;
		dist[start] = 0;
		
		while(!q.isEmpty()){
			int x = q.remove();
			for( Edge y : g[x]){
				if( check[y.to] == false){
					check[y.to] = true;
					q.add(y.to);
					
					dist[y.to] = dist[x] + y.cost;
				}
			}
		}
	}
	
}

