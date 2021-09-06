package dataproviders;

public class NamePass {
    private final String name;
    private final String pass;

    public NamePass(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}
