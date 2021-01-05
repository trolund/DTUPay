package repositories.Interfaces;

public interface BasicRepository<T, key> {

    T get(key id);
    void add(T obj);
    void delete(key id);
    void update(T a);
}
