/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-03-22
 * Time: 09:26
 */
public class User {
    private int id;
    private String name;
    private String passord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passord='" + passord + '\'' +
                '}';
    }



}
