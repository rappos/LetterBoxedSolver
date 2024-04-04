import java.util.Arrays;

public class LetterBox {
    private final String[] top;
    private final String[] right;
    private final String[] left;
    private final String[] bottom;

    public LetterBox(String[] letters) {
        this.top = new String[]{letters[0], letters[1], letters[2]};
        this.right = new String[]{letters[3], letters[4], letters[5]};
        this.bottom = new String[]{letters[6], letters[7], letters[8]};
        this.left = new String[]{letters[9], letters[10], letters[11]};
    }

    public String[] getTop() {
        return top;
    }

    public String[] getRight() {
        return right;
    }

    public String[] getLeft() {
        return left;
    }

    public String[] getBottom() {
        return bottom;
    }

    public String toString() {
        String[][] printBox = new String[][]{
                new String[]{"  ", this.top[0], this.top[1], this.top[2], " "},
                new String[]{this.left[2], " ", " ", " ", this.right[0]},
                new String[]{this.left[1], " ", " ", " ", this.right[1]},
                new String[]{this.left[0], " ", " ", " ", this.right[2]},
                new String[]{"  ", this.bottom[2], this.bottom[1], this.bottom[0], " "},
        };
        StringBuilder returnString = new StringBuilder();
        for (String[] strings : printBox) {
            for (String string : strings) {
                returnString.append(string);
                returnString.append("\t");
            }
            returnString.append(System.lineSeparator());
        }
        return returnString.toString();
    }
}
