package ru.skillbox;

public class Elevator {
    public int currentFloor = 1;
    public int minFloor;
    public int maxFloor;

    Elevator (int minFloor, int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown(){
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }
    public void moveUp(){
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }


    public void move(int floor) {

        if (floor >= minFloor && floor <= maxFloor) {
            if (currentFloor < floor) {
                while (currentFloor < floor) {
                    moveUp();
                    System.out.println("Этаж " + currentFloor);
                }
            } else if (currentFloor > floor) {
                while (currentFloor > floor) {
                    moveDown();
                    System.out.println("Этаж " + currentFloor);
                }
            }

        } else {
            System.out.println("Вы ввели неверный этаж.");
            return;
        }
    }

}
