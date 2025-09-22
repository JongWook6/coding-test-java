import java.util.Arrays;
import java.util.HashMap;

public class Simulation_characterPosition {

    private static int[] mySolution(String[] keyInput, int[] board) {
        int[] position = {0, 0};

        for (String cmd : keyInput) {
            int[] cmdArr = getCmdArr(cmd);
            if (isValidCmd(board, position, cmdArr)) {
                position[0] += cmdArr[0];
                position[1] += cmdArr[1];
            }
        }

        return position;
    }

    private static boolean isValidCmd(int[] board, int[] position, int[] cmdArr){
        int halfWidth = board[0] / 2;
        int halfHeight = board[1] / 2;

        if (Math.abs(position[0] + cmdArr[0]) > halfWidth) {
            return false;
        }

        if (Math.abs(position[1] + cmdArr[1]) > halfHeight) {
            return false;
        }

        return true;
    }

    private static int[] getCmdArr(String cmd) {
        int[] arr = switch (cmd) {
            case "left" -> new int[]{-1, 0};
            case "right" -> new int[]{1, 0};
            case "up" -> new int[]{0, 1};
            case "down" -> new int[]{0, -1};
            default -> new int[]{};
        };
        return arr;
    }

    private static int width, height;

    private static boolean isInBounds(int x, int y, int dx, int dy) {
        return Math.abs(x + dx) <= width && Math.abs(y + dy) <= height;
    }

    private static int[] answer(String[] keyInput, int[] board) {
        int x = 0, y = 0;
        width = board[0] / 2;
        height = board[1] / 2;

        HashMap<String, int[]> moves = new HashMap<>();
        moves.put("left", new int[]{-1, 0});
        moves.put("right", new int[]{1, 0});
        moves.put("up", new int[]{0, 1});
        moves.put("down", new int[]{0, -1});

        for (String s : keyInput) {
            int[] move = moves.get(s);
            int dx = move[0];
            int dy = move[1];

            if (isInBounds(x, y, dx, dy)) {
                x += dx;
                y += dy;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
//        String[] keyInput = {"left", "right", "up", "right", "right"};
        String[] keyInput = {"down", "down", "down", "down", "down"};
//        int[] board = {11, 11};
        int[] board = {7, 9};
        int[] result = answer(keyInput, board);
        System.out.println(Arrays.toString(result));
    }
}
