package lm;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class x<T> implements d0<T>, Serializable {
    private final T value;

    public x(T t10) {
        this.value = t10;
    }

    @Override // lm.d0
    public T getValue() {
        return this.value;
    }

    @Override // lm.d0
    public boolean isInitialized() {
        return true;
    }

    @os.l
    public String toString() {
        return String.valueOf(getValue());
    }
}
