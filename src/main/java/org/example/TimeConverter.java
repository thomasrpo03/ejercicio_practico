package org.example;
import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese las horas:");
        int hours = scanner.nextInt();

        System.out.println("Ingrese los minutos:");
        int minutes = scanner.nextInt();

        if (hours >= 1 && hours < 12 && minutes >= 0 && minutes < 60) {
            String timeInWords = convertTimeToWords(hours, minutes);
            System.out.println(timeInWords);
        } else {
            System.out.println("Entrada inválida. Asegúrese de ingresar horas en el rango [1, 12) y minutos en el rango [0, 60).");
        }
    }

    public static String convertTimeToWords(int hours, int minutes) {
        String[] hoursInWords = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once"};

        String timeInWords = hoursInWords[hours];

        if (minutes == 0) {
            timeInWords += " en punto";
        } else if (minutes == 15) {
            timeInWords += " y cuarto";
        } else if (minutes == 30) {
            timeInWords += " y media";
        } else if (minutes == 45) {
            timeInWords += " y cuarenta y cinco minutos";
        } else {
            timeInWords += " y " + convertMinutesToWords(minutes) + " minutos";
        }

        return timeInWords;
    }

    public static String convertMinutesToWords(int minutes) {
        if (minutes < 10) {
            return convertUnitToWords(minutes);
        } else if (minutes < 20) {
            return convertTeensToWords(minutes);
        } else {
            int unit = minutes % 10;
            int ten = minutes / 10 * 10;

            return convertTenToWords(ten) + (unit != 0 ? " " + convertUnitToWords(unit) : "");
        }
    }

    public static String convertUnitToWords(int unit) {
        String[] unitsInWords = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};

        return unitsInWords[unit];
    }

    public static String convertTeensToWords(int teens) {
        String[] teensInWords = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};

        return teensInWords[teens - 10];
    }

    public static String convertTenToWords(int ten) {
        String[] tensInWords = {"", "", "veinte", "treinta", "cuarenta", "cincuenta"};

        return tensInWords[ten / 10];
    }
}
