package lu.uni2013.tp4.ejb.entity;

import lu.uni2013.tp2.ejb.entity.helper.AbstractDBObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * User: schullto
 * Date: 11/7/13
 * Time: 9:05 PM
 */
@Entity
@XmlRootElement
public class UserBookmark extends AbstractDBObject {
    private String bookmark;
    private String url;
    private User user;

    @Column(name = "bookmark")
    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne
    @XmlTransient
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
