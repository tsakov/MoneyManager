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
public class UserComment extends AbstractDBObject {
    private String comment;
    private User user;

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
