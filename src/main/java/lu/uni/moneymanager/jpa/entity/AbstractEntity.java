package lu.uni.moneymanager.jpa.entity;

import javax.persistence.*;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@javax.persistence.MappedSuperclass
public abstract class AbstractEntity {

    private Long id;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
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
