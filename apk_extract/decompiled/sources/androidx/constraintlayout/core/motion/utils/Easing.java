package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String str = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "anticipate":
                return new CubicEasing(ANTICIPATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "overshoot":
                return new CubicEasing(OVERSHOOT);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d7) {
        return d7;
    }

    public double getDiff(double d7) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        double f1080x1;
        double x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        double f1081y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        double f1082y2;

        public CubicEasing(String str) {
            this.str = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f1080x1 = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i8 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i8);
            this.f1081y1 = Double.parseDouble(str.substring(i8, iIndexOf3).trim());
            int i9 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i9);
            this.x2 = Double.parseDouble(str.substring(i9, iIndexOf4).trim());
            int i10 = iIndexOf4 + 1;
            this.f1082y2 = Double.parseDouble(str.substring(i10, str.indexOf(41, i10)).trim());
        }

        private double getDiffX(double d7) {
            double d10 = 1.0d - d7;
            double d11 = this.f1080x1;
            double d12 = d10 * 3.0d * d10 * d11;
            double d13 = this.x2;
            return ((1.0d - d13) * 3.0d * d7 * d7) + ((d13 - d11) * d10 * 6.0d * d7) + d12;
        }

        private double getDiffY(double d7) {
            double d10 = 1.0d - d7;
            double d11 = this.f1081y1;
            double d12 = d10 * 3.0d * d10 * d11;
            double d13 = this.f1082y2;
            return ((1.0d - d13) * 3.0d * d7 * d7) + ((d13 - d11) * d10 * 6.0d * d7) + d12;
        }

        private double getX(double d7) {
            double d10 = 1.0d - d7;
            double d11 = 3.0d * d10;
            double d12 = d10 * d11 * d7;
            double d13 = d11 * d7 * d7;
            return (this.x2 * d13) + (this.f1080x1 * d12) + (d7 * d7 * d7);
        }

        private double getY(double d7) {
            double d10 = 1.0d - d7;
            double d11 = 3.0d * d10;
            double d12 = d10 * d11 * d7;
            double d13 = d11 * d7 * d7;
            return (this.f1082y2 * d13) + (this.f1081y1 * d12) + (d7 * d7 * d7);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d7) {
            if (d7 <= 0.0d) {
                return 0.0d;
            }
            if (d7 >= 1.0d) {
                return 1.0d;
            }
            double d10 = 0.5d;
            double d11 = 0.5d;
            while (d10 > error) {
                d10 *= 0.5d;
                d11 = getX(d11) < d7 ? d11 + d10 : d11 - d10;
            }
            double d12 = d11 - d10;
            double x2 = getX(d12);
            double d13 = d11 + d10;
            double x8 = getX(d13);
            double y3 = getY(d12);
            return (((d7 - x2) * (getY(d13) - y3)) / (x8 - x2)) + y3;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d7) {
            double d10 = 0.5d;
            double d11 = 0.5d;
            while (d10 > d_error) {
                d10 *= 0.5d;
                d11 = getX(d11) < d7 ? d11 + d10 : d11 - d10;
            }
            double d12 = d11 - d10;
            double d13 = d11 + d10;
            return (getY(d13) - getY(d12)) / (getX(d13) - getX(d12));
        }

        public void setup(double d7, double d10, double d11, double d12) {
            this.f1080x1 = d7;
            this.f1081y1 = d10;
            this.x2 = d11;
            this.f1082y2 = d12;
        }

        public CubicEasing(double d7, double d10, double d11, double d12) {
            setup(d7, d10, d11, d12);
        }
    }
}
