package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State {

    private static DrawerClosedNotPlaying drawerClosedNotPlaying;
    private DvdPlayer dvd;

    private DrawerClosedNotPlaying() {
        dvd = DvdPlayer.getInstance();
    }

    public static DrawerClosedNotPlaying getInstance() {
        if (drawerClosedNotPlaying == null)
            drawerClosedNotPlaying = new DrawerClosedNotPlaying();

        return drawerClosedNotPlaying;
    }
    @Override
    public void openCloseButtonPushed() {
        dvd.open();
        dvd.changeState(DrawerOpen.getInstance());
        System.out.print("Open");

    }

    @Override
    public void playButtonPushed() {
        System.out.print("Close");
        dvd.play();
        dvd.changeState(DrawerClosedPlaying.getInstance());

    }

    @Override
    public void stopButtonPushed() {
        System.out.print("Already stopped");

    }
}