package edu.umb.cs680.hw06;

public class DvdPlayer {

    private static DvdPlayer dvd;
    private static State state;

    private DvdPlayer() {

    }

    public static DvdPlayer getInstance() {
        if (dvd == null) {
            dvd = new DvdPlayer();
            state = DrawerClosedNotPlaying.getInstance();
        }
        return dvd;
    }

    public void changeState(State state) {
        DvdPlayer.state = state;
    }

    public void openCloseButtonPushed() {
        state.openCloseButtonPushed();
    }

    public void playButtonPushed() {
        state.playButtonPushed();

    }

    public void stopButtonPushed() {
        state.stopButtonPushed();

    }
    public void open() {
        System.out.println("Open");

    }

    public void close() {
        System.out.println("Close");

    }

    public void play() {
        System.out.println("Play");

    }

    public void stop() {
        System.out.println("Stop");

    }

    public State getState() {
        return this.state;
    }

    public static void main (String[] args) {
        DvdPlayer dvd = DvdPlayer.getInstance();
        dvd.openCloseButtonPushed();
        dvd.playButtonPushed();
        dvd.stopButtonPushed();
    }
}