package m1;

import c1.h0;
import c1.z;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e
@b1.d
public final class n implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public n(long count, double mean, double sumOfSquaresOfDeltas, double min, double max) {
        this.count = count;
        this.mean = mean;
        this.sumOfSquaresOfDeltas = sumOfSquaresOfDeltas;
        this.min = min;
        this.max = max;
    }

    public static n fromByteArray(byte[] byteArray) {
        byteArray.getClass();
        h0.m(byteArray.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, byteArray.length);
        return readFrom(ByteBuffer.wrap(byteArray).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> values) {
        return meanOf(values.iterator());
    }

    public static n of(Iterable<? extends Number> values) {
        o oVar = new o();
        oVar.b(values);
        return oVar.s();
    }

    public static n readFrom(ByteBuffer buffer) {
        buffer.getClass();
        h0.m(buffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, buffer.remaining());
        return new n(buffer.getLong(), buffer.getDouble(), buffer.getDouble(), buffer.getDouble(), buffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(@gm.a Object obj) {
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.count == nVar.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(nVar.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(nVar.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(nVar.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(nVar.max);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)});
    }

    public double max() {
        h0.g0(this.count != 0);
        return this.max;
    }

    public double mean() {
        h0.g0(this.count != 0);
        return this.mean;
    }

    public double min() {
        h0.g0(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        h0.g0(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return d.b(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        h0.g0(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return d.b(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(byteBufferOrder);
        return byteBufferOrder.array();
    }

    public String toString() {
        return count() > 0 ? z.c(this).e("count", this.count).b("mean", this.mean).b("populationStandardDeviation", populationStandardDeviation()).b("min", this.min).b("max", this.max).toString() : z.c(this).e("count", this.count).toString();
    }

    public void writeTo(ByteBuffer buffer) {
        buffer.getClass();
        h0.m(buffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, buffer.remaining());
        buffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> values) {
        h0.d(values.hasNext());
        double dDoubleValue = values.next().doubleValue();
        long j10 = 1;
        while (values.hasNext()) {
            double dDoubleValue2 = values.next().doubleValue();
            j10++;
            dDoubleValue = (o1.d.n(dDoubleValue2) && o1.d.n(dDoubleValue)) ? ((dDoubleValue2 - dDoubleValue) / j10) + dDoubleValue : o.i(dDoubleValue, dDoubleValue2);
        }
        return dDoubleValue;
    }

    public static n of(Iterator<? extends Number> values) {
        o oVar = new o();
        oVar.c(values);
        return oVar.s();
    }

    public static n of(double... values) {
        o oVar = new o();
        oVar.f(values);
        return oVar.s();
    }

    public static double meanOf(double... values) {
        h0.d(values.length > 0);
        double dI = values[0];
        for (int i10 = 1; i10 < values.length; i10++) {
            double d10 = values[i10];
            dI = (o1.d.n(d10) && o1.d.n(dI)) ? ((d10 - dI) / ((double) (i10 + 1))) + dI : o.i(dI, d10);
        }
        return dI;
    }

    public static n of(int... values) {
        o oVar = new o();
        oVar.g(values);
        return oVar.s();
    }

    public static n of(long... values) {
        o oVar = new o();
        oVar.h(values);
        return oVar.s();
    }

    public static double meanOf(int... values) {
        h0.d(values.length > 0);
        double dI = values[0];
        for (int i10 = 1; i10 < values.length; i10++) {
            double d10 = values[i10];
            dI = (o1.d.n(d10) && o1.d.n(dI)) ? ((d10 - dI) / ((double) (i10 + 1))) + dI : o.i(dI, d10);
        }
        return dI;
    }

    public static double meanOf(long... values) {
        h0.d(values.length > 0);
        double dI = values[0];
        for (int i10 = 1; i10 < values.length; i10++) {
            double d10 = values[i10];
            dI = (o1.d.n(d10) && o1.d.n(dI)) ? ((d10 - dI) / ((double) (i10 + 1))) + dI : o.i(dI, d10);
        }
        return dI;
    }
}
