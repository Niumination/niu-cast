package f1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class q0 implements Serializable {
    private int value;

    public q0(int value) {
        this.value = value;
    }

    public void add(int delta) {
        this.value += delta;
    }

    public int addAndGet(int delta) {
        int i10 = this.value + delta;
        this.value = i10;
        return i10;
    }

    public boolean equals(@gm.a Object obj) {
        return (obj instanceof q0) && ((q0) obj).value == this.value;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int newValue) {
        int i10 = this.value;
        this.value = newValue;
        return i10;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int newValue) {
        this.value = newValue;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
