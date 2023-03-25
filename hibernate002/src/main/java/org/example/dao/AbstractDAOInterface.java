package org.example.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDAOInterface<T extends Serializable>  {

    public void persist(T entity); //zapis nowego rekordu do bazy danych
    public void update(T entity); //aktualizacja rekordu w bazie danych
    public T findById(Integer id);
    public void delete(T entity);
    public void deleteAll();
    public List<T> findAll();
}
