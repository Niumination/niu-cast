package m1;

import c1.h0;
import c1.z;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e
@b1.d
public final class j implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10345a = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final n xStats;
    private final n yStats;

    public j(n xStats, n yStats, double sumOfProductsOfDeltas) {
        this.xStats = xStats;
        this.yStats = yStats;
        this.sumOfProductsOfDeltas = sumOfProductsOfDeltas;
    }

    public static double a(double value) {
        if (value >= 1.0d) {
            return 1.0d;
        }
        if (value <= -1.0d) {
            return -1.0d;
        }
        return value;
    }

    public static double b(double value) {
        if (value > 0.0d) {
            return value;
        }
        return Double.MIN_VALUE;
    }

    public static j fromByteArray(byte[] byteArray) {
        byteArray.getClass();
        h0.m(byteArray.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, byteArray.length);
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(byteArray).order(ByteOrder.LITTLE_ENDIAN);
        return new j(n.readFrom(byteBufferOrder), n.readFrom(byteBufferOrder), byteBufferOrder.getDouble());
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(@gm.a Object obj) {
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.xStats.equals(jVar.xStats) && this.yStats.equals(jVar.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(jVar.sumOfProductsOfDeltas);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas)});
    }

    public g leastSquaresFit() {
        h0.g0(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return g.c.f10326a;
        }
        double dSumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (dSumOfSquaresOfDeltas > 0.0d) {
            return this.yStats.sumOfSquaresOfDeltas() > 0.0d ? g.f(this.xStats.mean(), this.yStats.mean()).b(this.sumOfProductsOfDeltas / dSumOfSquaresOfDeltas) : g.b(this.yStats.mean());
        }
        h0.g0(this.yStats.sumOfSquaresOfDeltas() > 0.0d);
        return g.i(this.xStats.mean());
    }

    public double pearsonsCorrelationCoefficient() {
        h0.g0(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double dSumOfSquaresOfDeltas = xStats().sumOfSquaresOfDeltas();
        double dSumOfSquaresOfDeltas2 = yStats().sumOfSquaresOfDeltas();
        h0.g0(dSumOfSquaresOfDeltas > 0.0d);
        h0.g0(dSumOfSquaresOfDeltas2 > 0.0d);
        return a(this.sumOfProductsOfDeltas / Math.sqrt(b(dSumOfSquaresOfDeltas * dSumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        h0.g0(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        h0.g0(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(byteBufferOrder);
        this.yStats.writeTo(byteBufferOrder);
        byteBufferOrder.putDouble(this.sumOfProductsOfDeltas);
        return byteBufferOrder.array();
    }

    public String toString() {
        return count() > 0 ? z.c(this).j("xStats", this.xStats).j("yStats", this.yStats).b("populationCovariance", populationCovariance()).toString() : z.c(this).j("xStats", this.xStats).j("yStats", this.yStats).toString();
    }

    public n xStats() {
        return this.xStats;
    }

    public n yStats() {
        return this.yStats;
    }
}
