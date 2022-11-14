package spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private int basketId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "basket_status")
    private String basketStatus;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "basket", cascade = CascadeType.ALL)
    private List<Content> contentList;

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBasketStatus() {
        return basketStatus;
    }

    public void setBasketStatus(String basketStatus) {
        this.basketStatus = basketStatus;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}
