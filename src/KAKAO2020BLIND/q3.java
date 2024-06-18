package KAKAO2020BLIND;

public class q3 {
    static int[][] copyLock;
    static int lockLen;
    static int keyLen;
    public static boolean solution(int[][] key, int[][] lock) {
        keyLen = key.length;
        lockLen = lock.length;
        copyLock = new int[lockLen*3][lockLen*3];

        for (int i = 0; i < lockLen*2-1; i++) {
            for (int j = 0; j < lockLen*2-1; j++) {
                for (int k = 0; k < 4; k++) {
                    key = turnKey(key);
                    lockInit(lock);
                    if(!isInsertKey(i+lockLen-keyLen+1,j+lockLen-keyLen+1,key)) { continue;}
                    if(isOpen()){ return true;}
                }
            }
        }
        return false;
    }
    static void lockInit(int[][] lock){
        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) { copyLock[i+lockLen][j+lockLen] = lock[i][j];}
        }
    }

    static boolean isOpen(){
        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                if (copyLock[i+lockLen][j+lockLen] == 0){ return false;}
            }
        }
        return true;
    }

    static boolean isInsertKey(int r, int c, int[][] key){
        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                if(isRange(r+i,c+j)){
                    copyLock[r+i][c+j] += key[i][j];
                    if(copyLock[r+i][c+j]==2){return false;}
                }
            }
        }
        return true;
    }
    static boolean isRange(int r, int c){ return lockLen <= r && r< 2*lockLen && lockLen <= c && c< 2*lockLen; }

    static int[][] turnKey(int[][] key){
        int[][] turnKey = new int[keyLen][keyLen];

        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                turnKey[j][keyLen-i-1]=key[i][j];
            }
        }
        return turnKey;
    }

    public static void main(String[] args) {
        solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
//        solution(new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }
}
