
package Spring_02.HelloObject;


public class Wizard {
private String object;
private String adjective;

    public Wizard() {
    }

    public Wizard(String object, String adjective) {
        this.object = object;
        this.adjective = adjective;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

}
