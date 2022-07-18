package softarex.gorbachev.springbootrestclassroom.service;

import java.util.List;

/**
 * @author Gorabachev I. D.
 * @version 14.07.2022
 */
public interface ServiceTemplate<T, ID> {

    /**
     * @return a list of a specific type
     */
    List<T> getAll();

    /**
     * @param id entity-ID
     * @return entity specific type
     */
    T getById(ID id);

    /**
     * @param entity the entity being created
     * @return created entity
     */
    T create(T entity);

    /**
     * @param rscEntity is main resource data
     * @return updated entity
     */
    T update(T rscEntity);

    /**
     * Delete entity by his ID
     *
     * @param id entity ID
     */
    void deleteById(ID id);

    /**
     * Delete all entity
     */
    void deleteAll();
}
