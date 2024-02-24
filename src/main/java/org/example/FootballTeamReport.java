package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FootballTeam {
    private String teamName;
    private String stadium;
    private int titles;
    private List<Player> startingPlayers;
    private List<Player> substitutePlayers;

    public FootballTeam(String teamName, String stadium, int titles) {
        this.teamName = teamName;
        this.stadium = stadium;
        this.titles = titles;
        this.startingPlayers = new ArrayList<>();
        this.substitutePlayers = new ArrayList<>();
    }

    public void addStartingPlayer(String name, String position) {
        startingPlayers.add(new Player(name, position));
    }

    public void addSubstitutePlayer(String name, String position) {
        substitutePlayers.add(new Player(name, position));
    }

    public void printBasicReport() {
        System.out.println("Reporte Básico:");
        System.out.println("Equipo: " + teamName);
        System.out.println("Títulos Ganados: " + titles);
        System.out.println("Cantidad total de jugadores: " + (startingPlayers.size() + substitutePlayers.size()));
    }

    public void printDetailedReport() {
        System.out.println("Reporte Detallado:");
        System.out.println("Equipo: " + teamName);
        System.out.println("Títulos ganados: " + titles);

        System.out.println("Jugadores Titulares:");
        for (Player player : startingPlayers) {
            System.out.println(player.getName() + " - " + player.getPosition());
        }

        System.out.println("Jugadores Suplentes:");
        for (Player player : substitutePlayers) {
            System.out.println(player.getName() + " - " + player.getPosition());
        }
    }
}

class Player {
    private String name;
    private String position;

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}


public class FootballTeamReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del equipo:");
        String teamName = scanner.nextLine();

        System.out.println("Ingrese el nombre del estadio:");
        String stadium = scanner.nextLine();

        System.out.println("Ingrese el número de títulos ganados:");
        int titles = scanner.nextInt();

        FootballTeam footballTeam = new FootballTeam(teamName, stadium, titles);

        System.out.println("Ingrese los jugadores titulares(Nombre y posición):");
        for (int i = 0; i < 5; i++) {
            String name = scanner.next();
            String position = scanner.next();
            footballTeam.addStartingPlayer(name, position);
        }

        System.out.println("Ingrese los jugadores suplentes(Nombre y posición):");
        for (int i = 0; i < 3; i++) {
            String name = scanner.next();
            String position = scanner.next();
            footballTeam.addSubstitutePlayer(name, position);
        }

        System.out.println("Escoga el Reporte de su preferencia:");
        System.out.println("1. Reporte Básico");
        System.out.println("2. Reporte Detallado");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                footballTeam.printBasicReport();
                break;
            case 2:
                footballTeam.printDetailedReport();
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
}