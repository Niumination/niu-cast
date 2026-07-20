package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public Arc(int i8, double d7, double d10, double d11, double d12, double d13, double d14) {
            this.linear = false;
            this.mVertical = i8 == 1;
            this.mTime1 = d7;
            this.mTime2 = d10;
            this.mOneOverDeltaTime = 1.0d / (d10 - d7);
            if (3 == i8) {
                this.linear = true;
            }
            double d15 = d13 - d11;
            double d16 = d14 - d12;
            if (!this.linear && Math.abs(d15) >= EPSILON && Math.abs(d16) >= EPSILON) {
                this.mLut = new double[101];
                boolean z2 = this.mVertical;
                this.mEllipseA = d15 * ((double) (z2 ? -1 : 1));
                this.mEllipseB = d16 * ((double) (z2 ? 1 : -1));
                this.mEllipseCenterX = z2 ? d13 : d11;
                this.mEllipseCenterY = z2 ? d12 : d14;
                buildTable(d11, d12, d13, d14);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d11;
            this.mX2 = d13;
            this.mY1 = d12;
            this.mY2 = d14;
            double dHypot = Math.hypot(d16, d15);
            this.mArcDistance = dHypot;
            this.mArcVelocity = dHypot * this.mOneOverDeltaTime;
            double d17 = this.mTime2;
            double d18 = this.mTime1;
            this.mEllipseCenterX = d15 / (d17 - d18);
            this.mEllipseCenterY = d16 / (d17 - d18);
        }

        private void buildTable(double d7, double d10, double d11, double d12) {
            double dHypot;
            double d13 = d11 - d7;
            double d14 = d10 - d12;
            int i8 = 0;
            double d15 = 0.0d;
            double d16 = 0.0d;
            double d17 = 0.0d;
            while (true) {
                double[] dArr = ourPercent;
                if (i8 >= dArr.length) {
                    break;
                }
                double d18 = d15;
                double radians = Math.toRadians((((double) i8) * 90.0d) / ((double) (dArr.length - 1)));
                double dSin = Math.sin(radians) * d13;
                double dCos = Math.cos(radians) * d14;
                if (i8 > 0) {
                    dHypot = Math.hypot(dSin - d16, dCos - d17) + d18;
                    ourPercent[i8] = dHypot;
                } else {
                    dHypot = d18;
                }
                i8++;
                d17 = dCos;
                d15 = dHypot;
                d16 = dSin;
            }
            double d19 = d15;
            this.mArcDistance = d19;
            int i9 = 0;
            while (true) {
                double[] dArr2 = ourPercent;
                if (i9 >= dArr2.length) {
                    break;
                }
                dArr2[i9] = dArr2[i9] / d19;
                i9++;
            }
            int i10 = 0;
            while (true) {
                double[] dArr3 = this.mLut;
                if (i10 >= dArr3.length) {
                    return;
                }
                double length = ((double) i10) / ((double) (dArr3.length - 1));
                int iBinarySearch = Arrays.binarySearch(ourPercent, length);
                if (iBinarySearch >= 0) {
                    this.mLut[i10] = ((double) iBinarySearch) / ((double) (ourPercent.length - 1));
                } else if (iBinarySearch == -1) {
                    this.mLut[i10] = 0.0d;
                } else {
                    int i11 = -iBinarySearch;
                    int i12 = i11 - 2;
                    double[] dArr4 = ourPercent;
                    double d20 = dArr4[i12];
                    this.mLut[i10] = (((length - d20) / (dArr4[i11 - 1] - d20)) + ((double) i12)) / ((double) (dArr4.length - 1));
                }
                i10++;
            }
        }

        public double getDX() {
            double d7 = this.mEllipseA * this.mTmpCosAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d7, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d7 = -d7;
            }
            return d7 * dHypot;
        }

        public double getDY() {
            double d7 = this.mEllipseA * this.mTmpCosAngle;
            double d10 = (-this.mEllipseB) * this.mTmpSinAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d7, d10);
            return this.mVertical ? (-d10) * dHypot : d10 * dHypot;
        }

        public double getLinearDX(double d7) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d7) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d7) {
            double d10 = (d7 - this.mTime1) * this.mOneOverDeltaTime;
            double d11 = this.mX1;
            return ((this.mX2 - d11) * d10) + d11;
        }

        public double getLinearY(double d7) {
            double d10 = (d7 - this.mTime1) * this.mOneOverDeltaTime;
            double d11 = this.mY1;
            return ((this.mY2 - d11) * d10) + d11;
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public double lookup(double d7) {
            if (d7 <= 0.0d) {
                return 0.0d;
            }
            if (d7 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d7 * ((double) (dArr.length - 1));
            int i8 = (int) length;
            double d10 = length - ((double) i8);
            double d11 = dArr[i8];
            return ((dArr[i8 + 1] - d11) * d10) + d11;
        }

        public void setPoint(double d7) {
            double dLookup = lookup((this.mVertical ? this.mTime2 - d7 : d7 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(dLookup);
            this.mTmpCosAngle = Math.cos(dLookup);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002f  */
    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i8 = 1;
        int i9 = 1;
        int i10 = 0;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i10 >= arcArr.length) {
                return;
            }
            int i11 = iArr[i10];
            if (i11 == 0) {
                i9 = 3;
            } else if (i11 == 1) {
                i8 = 1;
                i9 = i8;
            } else {
                if (i11 != 2) {
                    if (i11 == 3) {
                        if (i8 != 1) {
                            i8 = 1;
                        }
                        i9 = i8;
                    }
                }
                i8 = 2;
                i9 = i8;
            }
            double d7 = dArr[i10];
            int i12 = i10 + 1;
            double d10 = dArr[i12];
            double[] dArr3 = dArr2[i10];
            double d11 = dArr3[0];
            double d12 = dArr3[1];
            double[] dArr4 = dArr2[i12];
            arcArr[i10] = new Arc(i9, d7, d10, d11, d12, dArr4[0], dArr4[1]);
            i10 = i12;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d7, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d10 = arc.mTime1;
            if (d7 < d10) {
                double d11 = d7 - d10;
                if (arc.linear) {
                    dArr[0] = (this.mArcs[0].getLinearDX(d10) * d11) + arc.getLinearX(d10);
                    dArr[1] = (d11 * this.mArcs[0].getLinearDY(d10)) + this.mArcs[0].getLinearY(d10);
                    return;
                }
                arc.setPoint(d10);
                dArr[0] = (this.mArcs[0].getDX() * d11) + this.mArcs[0].getX();
                dArr[1] = (d11 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
                return;
            }
            if (d7 > arcArr[arcArr.length - 1].mTime2) {
                double d12 = arcArr[arcArr.length - 1].mTime2;
                double d13 = d7 - d12;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.linear) {
                    dArr[0] = (this.mArcs[length].getLinearDX(d12) * d13) + arc2.getLinearX(d12);
                    dArr[1] = (d13 * this.mArcs[length].getLinearDY(d12)) + this.mArcs[length].getLinearY(d12);
                    return;
                }
                arc2.setPoint(d7);
                dArr[0] = (this.mArcs[length].getDX() * d13) + this.mArcs[length].getX();
                dArr[1] = (d13 * this.mArcs[length].getDY()) + this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d14 = arcArr2[0].mTime1;
            if (d7 < d14) {
                d7 = d14;
            }
            if (d7 > arcArr2[arcArr2.length - 1].mTime2) {
                d7 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i8 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i8 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i8];
            if (d7 <= arc3.mTime2) {
                if (arc3.linear) {
                    dArr[0] = arc3.getLinearX(d7);
                    dArr[1] = this.mArcs[i8].getLinearY(d7);
                    return;
                } else {
                    arc3.setPoint(d7);
                    dArr[0] = this.mArcs[i8].getX();
                    dArr[1] = this.mArcs[i8].getY();
                    return;
                }
            }
            i8++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d7, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d10 = arcArr[0].mTime1;
        if (d7 < d10) {
            d7 = d10;
        } else if (d7 > arcArr[arcArr.length - 1].mTime2) {
            d7 = arcArr[arcArr.length - 1].mTime2;
        }
        int i8 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i8 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i8];
            if (d7 <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearDX(d7);
                    dArr[1] = this.mArcs[i8].getLinearDY(d7);
                    return;
                } else {
                    arc.setPoint(d7);
                    dArr[0] = this.mArcs[i8].getDX();
                    dArr[1] = this.mArcs[i8].getDY();
                    return;
                }
            }
            i8++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d7, int i8) {
        Arc[] arcArr = this.mArcs;
        int i9 = 0;
        double d10 = arcArr[0].mTime1;
        if (d7 < d10) {
            d7 = d10;
        }
        if (d7 > arcArr[arcArr.length - 1].mTime2) {
            d7 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i9 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i9];
            if (d7 <= arc.mTime2) {
                if (arc.linear) {
                    if (i8 == 0) {
                        return arc.getLinearDX(d7);
                    }
                    return arc.getLinearDY(d7);
                }
                arc.setPoint(d7);
                if (i8 == 0) {
                    return this.mArcs[i9].getDX();
                }
                return this.mArcs[i9].getDY();
            }
            i9++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d7, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d10 = arc.mTime1;
            if (d7 < d10) {
                double d11 = d7 - d10;
                if (arc.linear) {
                    fArr[0] = (float) ((this.mArcs[0].getLinearDX(d10) * d11) + arc.getLinearX(d10));
                    fArr[1] = (float) ((d11 * this.mArcs[0].getLinearDY(d10)) + this.mArcs[0].getLinearY(d10));
                    return;
                }
                arc.setPoint(d10);
                fArr[0] = (float) ((this.mArcs[0].getDX() * d11) + this.mArcs[0].getX());
                fArr[1] = (float) ((d11 * this.mArcs[0].getDY()) + this.mArcs[0].getY());
                return;
            }
            if (d7 > arcArr[arcArr.length - 1].mTime2) {
                double d12 = arcArr[arcArr.length - 1].mTime2;
                double d13 = d7 - d12;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.linear) {
                    fArr[0] = (float) ((this.mArcs[length].getLinearDX(d12) * d13) + arc2.getLinearX(d12));
                    fArr[1] = (float) ((d13 * this.mArcs[length].getLinearDY(d12)) + this.mArcs[length].getLinearY(d12));
                    return;
                }
                arc2.setPoint(d7);
                fArr[0] = (float) this.mArcs[length].getX();
                fArr[1] = (float) this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d14 = arcArr2[0].mTime1;
            if (d7 < d14) {
                d7 = d14;
            } else if (d7 > arcArr2[arcArr2.length - 1].mTime2) {
                d7 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i8 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i8 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i8];
            if (d7 <= arc3.mTime2) {
                if (arc3.linear) {
                    fArr[0] = (float) arc3.getLinearX(d7);
                    fArr[1] = (float) this.mArcs[i8].getLinearY(d7);
                    return;
                } else {
                    arc3.setPoint(d7);
                    fArr[0] = (float) this.mArcs[i8].getX();
                    fArr[1] = (float) this.mArcs[i8].getY();
                    return;
                }
            }
            i8++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d7, int i8) {
        int i9 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d10 = arc.mTime1;
            if (d7 < d10) {
                double d11 = d7 - d10;
                if (arc.linear) {
                    if (i8 == 0) {
                        return (d11 * this.mArcs[0].getLinearDX(d10)) + arc.getLinearX(d10);
                    }
                    return (d11 * this.mArcs[0].getLinearDY(d10)) + arc.getLinearY(d10);
                }
                arc.setPoint(d10);
                if (i8 == 0) {
                    return (d11 * this.mArcs[0].getDX()) + this.mArcs[0].getX();
                }
                return (d11 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
            }
            if (d7 > arcArr[arcArr.length - 1].mTime2) {
                double d12 = arcArr[arcArr.length - 1].mTime2;
                double d13 = d7 - d12;
                int length = arcArr.length - 1;
                if (i8 == 0) {
                    return (d13 * this.mArcs[length].getLinearDX(d12)) + arcArr[length].getLinearX(d12);
                }
                return (d13 * this.mArcs[length].getLinearDY(d12)) + arcArr[length].getLinearY(d12);
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d14 = arcArr2[0].mTime1;
            if (d7 < d14) {
                d7 = d14;
            } else if (d7 > arcArr2[arcArr2.length - 1].mTime2) {
                d7 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i9 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i9];
            if (d7 <= arc2.mTime2) {
                if (arc2.linear) {
                    if (i8 == 0) {
                        return arc2.getLinearX(d7);
                    }
                    return arc2.getLinearY(d7);
                }
                arc2.setPoint(d7);
                if (i8 == 0) {
                    return this.mArcs[i9].getX();
                }
                return this.mArcs[i9].getY();
            }
            i9++;
        }
    }
}
