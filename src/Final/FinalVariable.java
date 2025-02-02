package Final;

public class FinalVariable {

    private final float G = 9.8F;

    public float getG() {
        return G;
    }

    //message to display
    public final void showMessage() {
        System.out.println("This is a final method inside a finalvariable class.");
    }
}

