package ru.skillbox;

public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int moveDown() {
        currentFloor = getCurrentFloor() > minFloor ? currentFloor - 1 : currentFloor;
        return currentFloor;

    }

    public int moveUp() {
        currentFloor = getCurrentFloor() < maxFloor ? currentFloor + 1 : currentFloor;
        return currentFloor;

    }

    public void move(int floor) {
        if (floor < minFloor || floor > maxFloor){
            System.out.println("Этаж введен неверно. Введите этаж от -3 до 26");
            return;
        }
        while (currentFloor != floor) {
            currentFloor = currentFloor < floor ? moveUp() : moveDown();
            System.out.println("Этаж " + currentFloor);
        }


        }
    }




