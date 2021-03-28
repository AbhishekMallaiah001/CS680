package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {

    private static DrawerClosedPlaying drawerClosedPlaying;
    private DvdPlayer dvd;

    private DrawerClosedPlaying() {
        dvd = DvdPlayer.getInstance();
    }

    public static DrawerClosedPlaying getInstance() {
        if (drawerClosedPlaying == null)
            drawerClosedPlaying = new DrawerClosedPlaying();

        return drawerClosedPlaying;
    }

    @Override
    public void openCloseButtonPushed() {
        System.out.print("Play");
        dvd.stop();
        dvd.open();
        dvd.changeState(DrawerOpen.getInstance());

    }

    @Override
    public void playButtonPushed() {
        System.out.println("System is playing");

    }

    @Override
    public void stopButtonPushed() {
        dvd.stop();
        dvd.changeState(DrawerClosedNotPlaying.getInstance());
        System.out.print("Stopped");

    }
}
