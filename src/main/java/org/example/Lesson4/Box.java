package org.example.Lesson4;

public class Box {
    private Integer ballsCount;

    public void setBallsCount(Integer ballsCount) {
        this.ballsCount = ballsCount;
    }

    public Integer getBallsCount() {
        return ballsCount;
    }

    public Box() {
        ballsCount = 0;
    }
    public void addBall() {
        ballsCount++;
    }
    public void deleteBall() throws BoxIsEmptyException {
        if (ballsCount == 0){
            throw new BoxIsEmptyException();
        }
        ballsCount--;
    }
}
