package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "users")
@NamedQueries({
    @NamedQuery(
            name = "getAllUsers",
            query = "SELECT e FROM User AS e ORDER BY e.id DESC"
            ),
    @NamedQuery(
            name = "getUsersCount",
            query = "SELECT COUNT(e) FROM User AS e"
            ),
    @NamedQuery(
            name = "checkRegisteredMailaddress",
            query = "SELECT COUNT(e) FROM User AS e WHERE e.mailaddress = :mailaddress"
            ),
    @NamedQuery(
            name = "checkLoginMailaddressAndPassword",
            query = "SELECT e FROM User AS e WHERE e.mailaddress = :mailaddress AND e.password = :pass"
            )
})
@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mailaddress", nullable = false, unique = true)
    private String mailaddress;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
