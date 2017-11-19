import java.util.NoSuchElementException;
import java.util.Scanner;

public class BrainFuck {
    public static String run(String program, Scanner scanner) {

        StringBuilder output = new StringBuilder();

        int iterator = 0;
        char[] arr = new char[30000];

        int pos = 0;
        while (true) {
            if (program.length() == pos) break;
            {
                switch (program.charAt(pos)) {
                    case '>':
                        iterator++;
                        pos++;
                        continue;
                    case '<':
                        iterator--;
                        pos++;
                        continue;
                    case '+':
                        arr[iterator]++;
                        pos++;
                        continue;
                    case '-':
                        arr[iterator]--;
                        pos++;
                        continue;
                    case '.':
                        System.out.print(arr[iterator]);
                        output.append(arr[iterator]);
                        pos++;
                        continue;
                    case ',':
                        try {
                            arr[iterator] = scanner.useDelimiter("").next().charAt(0);
                        } catch (NoSuchElementException e) {
                            arr[iterator] = 0;
                        }
                        pos++;
                        continue;
                    case '['://если значение текущей ячейки ноль, перейти вперёд по тексту программы на ячейку, следующую за соответствующей ] (с учётом вложенности)
                        if (arr[iterator] == 0) {
                            int brackets = 1;
                            for (int i = pos + 1; ; i++) {
                                if (program.charAt(i) == ']') brackets--;
                                else if (program.charAt(i) == '[') brackets++;
                                if (brackets == 0) {
                                    pos = i + 1;
                                    break;
                                }
                            }
                        } else
                            pos++;
                        continue;
                    case ']'://если значение текущей ячейки не нуль, перейти назад по тексту программы на символ [ (с учётом вложенности)
                        if (arr[iterator] != 0) {
                            int bracket = 1;
                            for (int i = pos - 1; ; i--) {
                                if (program.charAt(i) == ']') {
                                    bracket++;
                                    continue;
                                }
                                if (program.charAt(i) == '[') bracket--;
                                if (bracket == 0) {
                                    pos = i;
                                    break;
                                }
                            }
                        } else
                            pos++;
                        continue;
                    default:
                        pos++;
                }
            }
        }
        return output.toString();
    }


}
