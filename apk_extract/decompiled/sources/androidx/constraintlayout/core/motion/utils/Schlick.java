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
        int i8 = iIndexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i8, str.indexOf(44, i8)).trim());
    }

    private double dfunc(double d7) {
        double d10 = this.mT;
        if (d7 < d10) {
            double d11 = this.mS;
            return ((d11 * d10) * d10) / ((((d10 - d7) * d11) + d7) * (((d10 - d7) * d11) + d7));
        }
        double d12 = this.mS;
        return ((d10 - 1.0d) * ((d10 - 1.0d) * d12)) / (((((d10 - d7) * (-d12)) - d7) + 1.0d) * ((((d10 - d7) * (-d12)) - d7) + 1.0d));
    }

    private double func(double d7) {
        double d10 = this.mT;
        if (d7 < d10) {
            return (d10 * d7) / (((d10 - d7) * this.mS) + d7);
        }
        return ((d7 - 1.0d) * (1.0d - d10)) / ((1.0d - d7) - ((d10 - d7) * this.mS));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d7) {
        return func(d7);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d7) {
        return dfunc(d7);
    }
}
