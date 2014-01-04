package lu.uni2013.tp4.jsf.converter;

import lu.uni2013.tp4.ejb.entity.UserBookmark;
import lu.uni2013.tp4.jsf.converter.helper.AbstractDbObjectConverter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 * User: schullto
 * Date: 11/22/13
 * Time: 12:58 PM
 */
@Named
@RequestScoped
public class UserBookmarkConverter extends AbstractDbObjectConverter {
    @Override
    public Class getEntityClass() {
        return UserBookmark.class;
    }
}