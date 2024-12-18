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

class SecondImplementation implements FirstInterface {
    public void execute() { System.out.println("Y"); }
}

class SecondExecutor implements SecondInterface {
    public void perform() { System.out.println("Z"); }
}
