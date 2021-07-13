package pl.dmuszynski.reviewitapi.model;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected abstract static class Builder<T extends Builder<T>> {
        private long id;

        public T id(long id) {
            this.id = id;
            return this.self();
        }

        public abstract AbstractEntity build();
        protected abstract T self();
    }

    protected AbstractEntity() { }

    protected AbstractEntity(long id) {
        this.id = id;
    }

    protected AbstractEntity(Builder<?> builder) {
        this.id = builder.id;
    }

    public long getId() {
        return this.id;
    }
}