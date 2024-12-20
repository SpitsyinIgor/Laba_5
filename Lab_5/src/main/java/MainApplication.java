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

class Bean {
    @AutoInjectable private FirstInterface firstField;
    @AutoInjectable private SecondInterface secondField;

    public void run() {
        firstField.execute();
        secondField.perform();
    }
}

public class MainApplication {
    public static void main(String[] args) {
        Bean beanInstance = (new DependencyInjector()).injectDependencies(new Bean());
        beanInstance.run();
    }
}
