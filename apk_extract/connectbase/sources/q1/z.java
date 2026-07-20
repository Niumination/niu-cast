package q1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public class z implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient AtomicLongArray f13774a;

    public z(int length) {
        this.f13774a = new AtomicLongArray(length);
    }

    private void readObject(ObjectInputStream s10) throws ClassNotFoundException, IOException {
        s10.defaultReadObject();
        int i10 = s10.readInt();
        o1.k.c cVarBuilder = o1.k.builder();
        for (int i11 = 0; i11 < i10; i11++) {
            cVarBuilder.a(Double.doubleToRawLongBits(s10.readDouble()));
        }
        this.f13774a = new AtomicLongArray(cVarBuilder.f().toArray());
    }

    private void writeObject(ObjectOutputStream s10) throws IOException {
        s10.defaultWriteObject();
        int length = length();
        s10.writeInt(length);
        for (int i10 = 0; i10 < length; i10++) {
            s10.writeDouble(get(i10));
        }
    }

    @t1.a
    public double addAndGet(int i10, double delta) {
        long j10;
        double dLongBitsToDouble;
        do {
            j10 = this.f13774a.get(i10);
            dLongBitsToDouble = Double.longBitsToDouble(j10) + delta;
        } while (!this.f13774a.compareAndSet(i10, j10, Double.doubleToRawLongBits(dLongBitsToDouble)));
        return dLongBitsToDouble;
    }

    public final boolean compareAndSet(int i10, double expect, double update) {
        return this.f13774a.compareAndSet(i10, Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    public final double get(int i10) {
        return Double.longBitsToDouble(this.f13774a.get(i10));
    }

    @t1.a
    public final double getAndAdd(int i10, double delta) {
        long j10;
        double dLongBitsToDouble;
        do {
            j10 = this.f13774a.get(i10);
            dLongBitsToDouble = Double.longBitsToDouble(j10);
        } while (!this.f13774a.compareAndSet(i10, j10, Double.doubleToRawLongBits(dLongBitsToDouble + delta)));
        return dLongBitsToDouble;
    }

    public final double getAndSet(int i10, double newValue) {
        return Double.longBitsToDouble(this.f13774a.getAndSet(i10, Double.doubleToRawLongBits(newValue)));
    }

    public final void lazySet(int i10, double newValue) {
        this.f13774a.lazySet(i10, Double.doubleToRawLongBits(newValue));
    }

    public final int length() {
        return this.f13774a.length();
    }

    public final void set(int i10, double newValue) {
        this.f13774a.set(i10, Double.doubleToRawLongBits(newValue));
    }

    public String toString() {
        int length = length();
        int i10 = length - 1;
        if (i10 == -1) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder(length * 19);
        sb2.append(ks.a.f9445d);
        int i11 = 0;
        while (true) {
            sb2.append(Double.longBitsToDouble(this.f13774a.get(i11)));
            if (i11 == i10) {
                sb2.append(']');
                return sb2.toString();
            }
            sb2.append(", ");
            i11++;
        }
    }

    public final boolean weakCompareAndSet(int i10, double expect, double update) {
        return this.f13774a.weakCompareAndSet(i10, Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    public z(double[] array) {
        int length = array.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = Double.doubleToRawLongBits(array[i10]);
        }
        this.f13774a = new AtomicLongArray(jArr);
    }
}
