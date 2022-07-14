package softarex.gorbachev.springbootrestclassroom.service;

import java.util.List;

/**
 * @author Gorabachev I. D.
 * @version 14.07.2022
 */
public interface ServiceTemplate<T, ID> {

    List<T> getAll();

    T getById(ID id);

    T create(T entity);

    T update(T rscEntity);

    void deleteById(ID id);

    void deleteAll();
}
