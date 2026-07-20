package q1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@o0
public class y extends Number implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient AtomicLong f13766a;

    public y(double initialValue) {
        this.f13766a = new AtomicLong(Double.doubleToRawLongBits(initialValue));
    }

    private void readObject(ObjectInputStream s10) throws ClassNotFoundException, IOException {
        s10.defaultReadObject();
        this.f13766a = new AtomicLong();
        set(s10.readDouble());
    }

    private void writeObject(ObjectOutputStream s10) throws IOException {
        s10.defaultWriteObject();
        s10.writeDouble(get());
    }

    @t1.a
    public final double addAndGet(double delta) {
        long j10;
        double dLongBitsToDouble;
        do {
            j10 = this.f13766a.get();
            dLongBitsToDouble = Double.longBitsToDouble(j10) + delta;
        } while (!this.f13766a.compareAndSet(j10, Double.doubleToRawLongBits(dLongBitsToDouble)));
        return dLongBitsToDouble;
    }

    public final boolean compareAndSet(double expect, double update) {
        return this.f13766a.compareAndSet(Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.f13766a.get());
    }

    @t1.a
    public final double getAndAdd(double delta) {
        long j10;
        double dLongBitsToDouble;
        do {
            j10 = this.f13766a.get();
            dLongBitsToDouble = Double.longBitsToDouble(j10);
        } while (!this.f13766a.compareAndSet(j10, Double.doubleToRawLongBits(dLongBitsToDouble + delta)));
        return dLongBitsToDouble;
    }

    public final double getAndSet(double newValue) {
        return Double.longBitsToDouble(this.f13766a.getAndSet(Double.doubleToRawLongBits(newValue)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double newValue) {
        this.f13766a.lazySet(Double.doubleToRawLongBits(newValue));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double newValue) {
        this.f13766a.set(Double.doubleToRawLongBits(newValue));
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double expect, double update) {
        return this.f13766a.weakCompareAndSet(Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    public y() {
        this(0.0d);
    }
}
