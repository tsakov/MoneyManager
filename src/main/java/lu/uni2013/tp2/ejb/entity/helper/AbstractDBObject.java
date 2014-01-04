package lu.uni2013.tp2.ejb.entity.helper;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * User: schullto
 */
@javax.persistence.MappedSuperclass
public abstract class AbstractDBObject {
    private java.lang.Long id;
    private java.util.Date jpaVersion;
    private java.util.Date deleted;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "jpaVersion")
    @Version
    public Date getJpaVersion() {
        return jpaVersion;
    }

    public void setJpaVersion(Date jpaVersion) {
        this.jpaVersion = jpaVersion;
    }

    @Column(name = "deleted")
    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    @Transient
    @XmlTransient
    public Object getMyClone() {
        try {
            Class thisClass = this.getClass();
            BeanInfo bi = Introspector.getBeanInfo(thisClass);
            Object cloneObj = thisClass.newInstance();
            PropertyDescriptor[] pds = bi.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Method readMethod = pd.getReadMethod();
                Method writeMethod = pd.getWriteMethod();
                if (readMethod != null && writeMethod != null) {
                    Object value = readMethod.invoke(this);
                    writeMethod.invoke(cloneObj, value);
                }
            }
            return cloneObj;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
