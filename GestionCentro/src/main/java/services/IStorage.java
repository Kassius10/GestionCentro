package services;

public interface IStorage<T> {
        boolean save(T value);

        T load();

        String getBackupPath();
}
