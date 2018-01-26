import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 26.01.2018.
 */
public class TestTask {
    private int[] chessboard = {0,0,0,0,0,0,0,0};
    private int index = 0;

    private boolean checking() {
        int i;

        if (this.index == 0) {
            return true;
        }
        if (this.chessboard[index]>7){
            this.chessboard[index] = 0;
            this.index--;
            return false;
        }

        for (i=0;i<this.index;i++){
            if ((this.chessboard[this.index] == this.chessboard[i])|((Math.abs(this.chessboard[this.index] - this.chessboard[i])) == (this.index-i))){
                return false;
            }
        }
        return true;
    }

    public List<String> show() {
        List<String> list = new ArrayList<>();
        do {
            if (checking()){
                if (this.index == 7) {
                    list.add(String.format("[0]=%s [1]=%s [2]=%s [3]=%s [4]=%s [5]=%s [6]=%s [7]=%s", this.chessboard[0], this.chessboard[1], this.chessboard[2], this.chessboard[3], this.chessboard[4], this.chessboard[5], this.chessboard[6], this.chessboard[7]));
                    this.chessboard[this.index]++;
                }
                else {
                    this.index++;
                }
            }
            else {
                this.chessboard[this.index]++;
            }
        } while (this.chessboard[0]<8);
        return list;
    }

}
