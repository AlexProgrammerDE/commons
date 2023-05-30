package net.lenni0451.commons;

import javax.annotation.concurrent.ThreadSafe;
import java.util.function.Supplier;

/**
 * An object to store a value that is only initialized when required.<br>
 * Useful for objects that are expensive to create and are not always needed.
 *
 * @param <T> The type of the object
 */
@ThreadSafe
public class Lazy<T> {

    private final Object lock = new Object();
    private final Supplier<T> supplier;
    private T value;
    private boolean initialized = false;

    public Lazy(final Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * @return The value of the object
     */
    public T get() {
        synchronized (this.lock) {
            if (!this.initialized) {
                this.value = this.supplier.get();
                this.initialized = true;
            }
            return this.value;
        }
    }

}
