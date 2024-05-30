import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListManager {
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            executeCommand(command);
        }
        scanner.close();
    }

    private static void executeCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action) {
            case "push":
                int position = Integer.parseInt(parts[1]);
                int number = Integer.parseInt(parts[2]);
                if (position >= list.size()) {
                    list.add(number);
                } else {
                    list.add(position, number);
                }
                printList();
                break;
            case "pop":
                position = Integer.parseInt(parts[1]);
                if (position < list.size()) {
                    list.remove(position);
                }
                printList();
                break;
            case "left":
                int rotation = Integer.parseInt(parts[1]);
                leftRotate(rotation);
                printList();
                break;
            case "right":
                rotation = Integer.parseInt(parts[1]);
                rightRotate(rotation);
                printList();
                break;
            case "search":
                number = Integer.parseInt(parts[1]);
                System.out.println(list.contains(number) ? "yes" : "no");
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    private static void leftRotate(int rotation) {
        int size = list.size();
        rotation = rotation % size;
        for (int i = 0; i < rotation; i++) {
            int first = list.remove(0);
            list.add(first);
        }
    }

    private static void rightRotate(int rotation) {
        int size = list.size();
        rotation = rotation % size;
        for (int i = 0; i < rotation; i++) {
            int last = list.remove(size - 1);
            list.add(0, last);
        }
    }

    private static void printList() {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
