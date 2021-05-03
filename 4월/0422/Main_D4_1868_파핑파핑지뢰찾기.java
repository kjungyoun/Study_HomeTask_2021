package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_D4_1868_파핑파핑지뢰찾기 {

	static int N, ans;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new char[N][N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			
			for (int i = 0; i < N; i++) {
				top: for (int j = 0; j < N; j++) {
					// 빈 곳만 탐색
					if (map[i][j] == '.') {
						
						
						//8방 탐색
						for (int k = 0; k < 8; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							
							
							// 주변에 폭탄이 있는지 확인
							if (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] == '*')
								continue top;
						}
						
						
						// 주변에 폭탄이 없는 곳일 경우
						map[i][j] = '0';
						click(i, j);
						ans++;	// 클릭 횟수 세주기
					}
				}
			}
			
			ans += check();
			
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void click(int row, int col) {
		
		// 8방향의 지점도 클릭 처리
			int nr,nc;
			for (int k = 0; k < 8; k++) {
				nr = row + dr[k];
				nc = col + dc[k];
				
				// 주변에서 빈 곳인 경우만
				if(nr>-1 && nr<N && nc>-1 && nc<N && map[nr][nc] == '.') {
					
					// 주변 폭탄 개수를 저장
					int cnt = count(nr,nc);
					map[nr][nc] = (char) (cnt+'0');
					
					// 주변 폭탄 개수가 0이면 연쇄 폭발
					if(cnt == 0)
						click(nr,nc);
				}
					
		}
	}

	private static int count(int r, int c) {
		int nr, nc;
		int cnt = 0;
		for (int k = 0; k < 8; k++) {
			nr = r + dr[k];
			nc = c + dc[k];

			// 폭탄의 개수 세기
			if (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] == '*')
				cnt++;
		}
		return cnt;
	}
	
	// 남은 '.' 인 곳 개수 count
	private static int check() {
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '.')
					cnt++;
			}
		}
		return cnt;
	}
}
