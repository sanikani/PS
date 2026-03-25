import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int k;
	static String s;
	static Node root;
	final static char OFFSET = 'a';
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			k = Integer.parseInt(br.readLine());
			s = br.readLine();
			root = new Node();
			for(int start = 0; start < s.length(); start++){
				insert(start);
			}
			sb.append('#').append(tc).append(' ').append(findKth()).append('\n');
		}
		System.out.println(sb);
	}
	
	static class Node{
		int cnt;
		Node[] child;
		boolean isWord;
		
		public Node(){
			child = new Node[26];
		}
	}
	
	private static void insert(int start) {
		Node cur = root;
		
		for(int end = start; end < s.length(); end++) {
			int idx = s.charAt(end) - OFFSET;
			if(cur.child[idx] == null) {
				cur.child[idx] = new Node();
			}
			
			cur = cur.child[idx];
			
		}
		
		if(!cur.isWord) {
			cur.isWord = true;
			count(start, s.length() - 1);
		}
	}

	private static void count(int start, int end) {
		Node cur = root;
		cur.cnt++;
		for(int k = start; k <= end; k++) {
			int idx = s.charAt(k) - OFFSET;
			cur = cur.child[idx];
			cur.cnt++;
		}
	}
	
	static String findKth() {
		StringBuilder sb = new StringBuilder();
		if(k > s.length()) return "none";
		
		Node cur = root;
		
		while(true) {
			for(int i = 0; i < 26; i++) {
				if(cur.child[i] == null) continue;
				if(cur.child[i].cnt < k) {
					k -= cur.child[i].cnt;
				}else {
					cur = cur.child[i];
					if(cur.isWord) k--;
					sb.append((char)(i + OFFSET));
					if(k == 0) return sb.toString();
					break;
				}
			}
		}
	}
}
