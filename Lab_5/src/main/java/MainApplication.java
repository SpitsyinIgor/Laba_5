import annotation.AutoInjectable;

interface FirstInterface {
    void execute();
}

interface SecondInterface {
    void perform();
}

class FirstImplementation implements FirstInterface {
    public void execute() { System.out.println("X"); }
}
