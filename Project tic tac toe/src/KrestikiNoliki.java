

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KrestikiNoliki {
    /*
   -создать двумерный массив
-создание метода вывести на экран
-cоздание метода крестики
-cоздание метода нолики
-создание метода проверки
-вывод таблицы x/o


*/
    //главный метод
    //создание двумерного массива
    public static void main(String[] args) throws IOException {
        char[][] field = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};


        while (true) {
            field = input(field,'x');
            showMatrix(field);
            if (checkControl(field) == false) {
                break;
            }
            field = input(field,'o');
            showMatrix(field);
            if (checkControl(field) == false){
                break;
            }

        }
    }
//вывод  всего массива  на экран  (р-р 3х3)
    public static void showMatrix(char field[][]) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
//ввод данных Х или О
    public static char[][] input(char field[][],char cheStavim ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String Vvod = br.readLine();
            int a = Integer.parseInt(Vvod);
            int row = 0;
            int column = 0;
            switch (a) {
                case 1:
                    row = 0;
                    column = 0;
                    break;
                case 2:
                    row = 0;
                    column = 1;
                    break;
                case 3:
                    row = 0;
                    column = 2;
                    break;
                case 4:
                    row = 1;
                    column = 0;
                    break;
                case 5:
                    row = 1;
                    column = 1;
                    break;
                case 6:
                    row = 1;
                    column = 2;
                    break;
                case 7:
                    row = 2;
                    column = 0;
                    break;
                case 8:
                    row = 2;
                    column = 1;
                    break;
                case 9:
                    row = 2;
                    column = 2;
                    break;
                default:
                    System.out.println("Vne diapazona");
                    continue;

            }

//Проверка чтобы не попадало на одну и  ту же ячейку
            if (field[row][column] == 'x' || field[row][column] == 'o') {
                System.out.println("ошибка");
            } else {
                field[row][column] = cheStavim;
                return field;
            }

        }
    }

    //выводим false если надо остановить игру
    public static boolean checkControl(char fieldControl[][]) {

//проверка строк
        for (int i = 0; i < fieldControl.length; i++) {
            int countX = 0;
            int countO = 0;

            for (int j = 0; j < fieldControl.length; j++) {
                if (fieldControl[i][j] == 'x') {
                    countX++;
                }
                if (fieldControl[i][j] == 'o') {
                    countO++;
                }

            }
                // если кол-во  х  = 
            if (countX == fieldControl.length) {
                System.out.println("X winner");
                return false;
            }
            if (countO == fieldControl.length) {
                System.out.println("O winner");
                return false;
            }

        }
//проверка столбцев
        for (int j = 0; j < fieldControl.length; j++) {
            int countX = 0;
            int countO = 0;

            for (int i = 0; i < fieldControl.length; i++) {
                if (fieldControl[i][j] == 'x') {
                    countX++;
                }
                if (fieldControl[i][j] == 'o') {
                    countO++;
                }

            }
            if (countX == fieldControl.length) {
                System.out.println("X winner");
                return false;
            }
            if (countO == fieldControl.length) {
                System.out.println("O winner");
                return false;
            }

        }
        //Проверка по диагонали (с право налево)
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < fieldControl.length; i++) {

            if (fieldControl[i][i] == 'x') {
                countX++;
            }
            if (fieldControl[i][i] == 'O') {
                countO++;
            }
        }
        if (countX == fieldControl.length) {
            System.out.println("X winner");
            return false;
        }
        if (countO == fieldControl.length) {
            System.out.println("O winner");
            return false;

        }
        countX = 0;
        countO = 0;
        //Проверка по диагонали слева направо
        for (int i = 0; i < fieldControl.length; i++) {

            if( fieldControl[i][fieldControl.length - i - 1] == 'x'){
                countX ++;
            }if( fieldControl[i][fieldControl.length - i - 1] == 'o'){
                countO ++;
            }
        }
        if (countX == fieldControl.length) {
            System.out.println("X winner");
            return false;
        }
        if (countO == fieldControl.length) {
            System.out.println("O winner");
            return false;
        }
        //проверка на наличие "-"
        int countTire = 0;
        for (int i = 0; i < fieldControl.length; i++) {

            for (int j = 0; j < fieldControl.length; j++) {
                if(fieldControl[i][j] == '-'){
                    countTire ++;
                }
            }
        }
        if (countTire == 0) {
            System.out.println("Winner isn't found ");
            return


            false;
        }
        return true;
    }
}

/*
игра продолжается
проверка наличия тире
условия по вертикали
условия по диагонали
условия по горизонтали
*/