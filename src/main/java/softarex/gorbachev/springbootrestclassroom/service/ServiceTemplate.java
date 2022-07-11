package softarex.gorbachev.springbootrestclassroom.service;

import java.util.List;

public interface ServiceTemplate<T, ID> {

    List<T> getAll();

    T getById(ID id);

    T create(T entity);

    void update(T rscEntity);

    void deleteById(ID id);

    void deleteAll();
}
