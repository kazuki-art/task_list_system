package models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "routines")
@NamedQueries({
    @NamedQuery(
            name = "getAllRoutines",
            query = "SELECT r FROM Routine AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getRoutinesCount",
            query = "SELECT COUNT(r) FROM Routine AS r"
            ),
})

@Entity
public class Routine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "routine_date", length = 255, nullable = false)
    private String routine_date;

    @Column(name = "time_kubun", length = 255, nullable = false)
    private String time_kubun;


    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoutine_date() {
        return routine_date;
    }

    public void setRoutine_date(String routine_date) {
        this.routine_date = routine_date;
    }

    public String getTime_kubun() {
        return time_kubun;
    }

    public void setTime_kubun(String time_kubun) {
        this.time_kubun = time_kubun;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
