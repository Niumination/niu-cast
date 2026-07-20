package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double eps;
    double mS;
    double mT;

    public Schlick(String str) {
        this.str = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.mS = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i10 = iIndexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i10, str.indexOf(44, i10)).trim());
    }

    private double dfunc(double d10) {
        double d11 = this.mT;
        if (d10 < d11) {
            double d12 = this.mS;
            return ((d12 * d11) * d11) / ((((d11 - d10) * d12) + d10) * (((d11 - d10) * d12) + d10));
        }
        double d13 = this.mS;
        return ((d11 - 1.0d) * ((d11 - 1.0d) * d13)) / (((((d11 - d10) * (-d13)) - d10) + 1.0d) * ((((d11 - d10) * (-d13)) - d10) + 1.0d));
    }

    private double func(double d10) {
        double d11 = this.mT;
        if (d10 < d11) {
            return (d11 * d10) / (((d11 - d10) * this.mS) + d10);
        }
        return ((d10 - 1.0d) * (1.0d - d11)) / ((1.0d - d10) - ((d11 - d10) * this.mS));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d10) {
        return func(d10);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d10) {
        return dfunc(d10);
    }
}
