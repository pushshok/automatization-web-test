package ru.geekbrains.lesson4;

public class Box {
    private Integer ballsCount;

    public Box() {
        this.ballsCount = 0;
    }

    public Integer getBallsCount() {
        return ballsCount;
    }

    public void addBall() {
        ballsCount++;
    }

    public void deleteBall() throws BoxAlreadyEmptyException {
        if (ballsCount == 0) {
            throw new BoxAlreadyEmptyException("Box is empty!");
        }
        ballsCount--;
    }

    public void shuffleBalls() {
        if (ballsCount == 0) {
            throw new NullPointerException("Game with null pointer summ.");
        }
        System.out.println("Shuffle balls.");
    }
}
