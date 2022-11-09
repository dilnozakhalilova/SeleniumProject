package BrowserTest;

public class FireFoxBrowser implements ParentBrowser {
    public FireFoxBrowser() {
        System.out.println("Launching ...");
    }

    @Override
    public void goTo(String URL) {
        System.out.println("Navigaring "+URL);
    }

    @Override
    public void getCurrentURL() {
        System.out.println("Launching URL... ");
    }

    @Override
    public void getTitle() {
        System.out.println("Getting the Title");
    }

    @Override
    public void close() {
        System.out.println("Closing the Browser");
    }
}
