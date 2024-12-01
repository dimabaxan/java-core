public class TicTacToe {
    public static void main(String[] args) {
        int[] board = {0, 1, 2, 0, 1, 2, 0, 1, 0}; // Пример состояния
        printBoard(board);
    }

    public static void printBoard(int[] board) {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                System.out.println(); // Новая строка после каждых трех ячеек
            }
            switch (board[i]) {
                case 0 -> System.out.print("[ ] ");
                case 1 -> System.out.print("[X] ");
                case 2 -> System.out.print("[O] ");
                default -> System.out.print("[?] "); // Обработка ошибок
            }
        }
    }
}
