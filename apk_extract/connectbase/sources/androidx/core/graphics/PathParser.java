package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import java.util.ArrayList;
import kl.f;
import m.a;

/* JADX INFO: loaded from: classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c10, float[] fArr) {
        arrayList.add(new PathDataNode(c10, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            PathDataNode pathDataNode = pathDataNodeArr[i10];
            char c10 = pathDataNode.mType;
            PathDataNode pathDataNode2 = pathDataNodeArr2[i10];
            if (c10 != pathDataNode2.mType || pathDataNode.mParams.length != pathDataNode2.mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i10, int i11) {
        if (i10 > i11) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i10 < 0 || i10 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = i11 - i10;
        int iMin = Math.min(i12, length - i10);
        float[] fArr2 = new float[i12];
        System.arraycopy(fArr, i10, fArr2, 0, iMin);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        while (i10 < str.length()) {
            int iNextStart = nextStart(str, i10);
            String strTrim = str.substring(i11, iNextStart).trim();
            if (strTrim.length() > 0) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i11 = iNextStart;
            i10 = iNextStart + 1;
        }
        if (i10 - i11 == 1 && i11 < str.length()) {
            addNode(arrayList, str.charAt(i11), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] pathDataNodeArrCreateNodesFromPathData = createNodesFromPathData(str);
        if (pathDataNodeArrCreateNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(pathDataNodeArrCreateNodesFromPathData, path);
            return path;
        } catch (RuntimeException e10) {
            throw new RuntimeException(a.a("Error in parsing ", str), e10);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            pathDataNodeArr2[i10] = new PathDataNode(pathDataNodeArr[i10]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    private static void extract(String str, int i10, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i11 = i10; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == ' ') {
                z10 = false;
                z12 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z10 = false;
                        z12 = true;
                        break;
                    case '-':
                        if (i11 == i10 || z10) {
                            z10 = false;
                        } else {
                            extractFloatResult.mEndWithNegOrDot = true;
                            z10 = false;
                            z12 = true;
                        }
                        break;
                    case '.':
                        if (z11) {
                            extractFloatResult.mEndWithNegOrDot = true;
                            z10 = false;
                            z12 = true;
                        } else {
                            z10 = false;
                            z11 = true;
                        }
                        break;
                    default:
                        z10 = false;
                        break;
                }
            } else {
                z10 = true;
            }
            if (z12) {
                extractFloatResult.mEndPosition = i11;
            }
        }
        extractFloatResult.mEndPosition = i11;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i10 = 1;
            int i11 = 0;
            while (i10 < length) {
                extract(str, i10, extractFloatResult);
                int i12 = extractFloatResult.mEndPosition;
                if (i10 < i12) {
                    fArr[i11] = Float.parseFloat(str.substring(i10, i12));
                    i11++;
                }
                i10 = extractFloatResult.mEndWithNegOrDot ? i12 : i12 + 1;
            }
            return copyOfRange(fArr, 0, i11);
        } catch (NumberFormatException e10) {
            throw new RuntimeException(n.a.a("error in parsing \"", str, "\""), e10);
        }
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f10) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            pathDataNodeArr[i10].interpolatePathDataNode(pathDataNodeArr2[i10], pathDataNodeArr3[i10], f10);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    private static int nextStart(String str, int i10) {
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                } else if (cCharAt != 'e' && cCharAt != 'E') {
                    return i10;
                }
            } else if (cCharAt != 'e') {
                continue;
            }
            i10++;
        }
        return i10;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i10 = 0; i10 < pathDataNodeArr2.length; i10++) {
            pathDataNodeArr[i10].mType = pathDataNodeArr2[i10].mType;
            int i11 = 0;
            while (true) {
                float[] fArr = pathDataNodeArr2[i10].mParams;
                if (i11 < fArr.length) {
                    pathDataNodeArr[i10].mParams[i11] = fArr[i11];
                    i11++;
                }
            }
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        public PathDataNode(char c10, float[] fArr) {
            this.mType = c10;
            this.mParams = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void addCommand(Path path, float[] fArr, char c10, char c11, float[] fArr2) {
            int i10;
            int i11;
            int i12;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            char c12 = c11;
            boolean z10 = false;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr[2];
            float f21 = fArr[3];
            float f22 = fArr[4];
            float f23 = fArr[5];
            switch (c12) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case 'a':
                    i10 = 7;
                    i11 = i10;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                case 'c':
                    i10 = 6;
                    i11 = i10;
                    break;
                case TabLayout.f3131k0 /* 72 */:
                case 'V':
                case 'h':
                case y5.a.f20728k0 /* 118 */:
                    i11 = 1;
                    break;
                case en.a.f4563i /* 76 */:
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case y5.a.f20724i0 /* 116 */:
                default:
                    i11 = 2;
                    break;
                case 'Q':
                case 'S':
                case y5.a.f20718f0 /* 113 */:
                case y5.a.f20722h0 /* 115 */:
                    i11 = 4;
                    break;
                case 'Z':
                case y5.a.f20736o0 /* 122 */:
                    path.close();
                    path.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                    i11 = 2;
                    break;
            }
            float f24 = f18;
            float f25 = f19;
            float f26 = f22;
            float f27 = f23;
            int i13 = 0;
            char c13 = c10;
            while (i13 < fArr2.length) {
                if (c12 != 'A') {
                    if (c12 == 'C') {
                        i12 = i13;
                        int i14 = i12 + 2;
                        int i15 = i12 + 3;
                        int i16 = i12 + 4;
                        int i17 = i12 + 5;
                        path.cubicTo(fArr2[i12], fArr2[i12 + 1], fArr2[i14], fArr2[i15], fArr2[i16], fArr2[i17]);
                        f24 = fArr2[i16];
                        float f28 = fArr2[i17];
                        float f29 = fArr2[i14];
                        float f30 = fArr2[i15];
                        f25 = f28;
                        f21 = f30;
                        f20 = f29;
                    } else if (c12 == 'H') {
                        i12 = i13;
                        path.lineTo(fArr2[i12], f25);
                        f24 = fArr2[i12];
                    } else if (c12 == 'Q') {
                        i12 = i13;
                        int i18 = i12 + 1;
                        int i19 = i12 + 2;
                        int i20 = i12 + 3;
                        path.quadTo(fArr2[i12], fArr2[i18], fArr2[i19], fArr2[i20]);
                        float f31 = fArr2[i12];
                        float f32 = fArr2[i18];
                        f24 = fArr2[i19];
                        f25 = fArr2[i20];
                        f20 = f31;
                        f21 = f32;
                    } else if (c12 == 'V') {
                        i12 = i13;
                        path.lineTo(f24, fArr2[i12]);
                        f25 = fArr2[i12];
                    } else if (c12 != 'a') {
                        if (c12 != 'c') {
                            if (c12 == 'h') {
                                path.rLineTo(fArr2[i13], 0.0f);
                                f24 += fArr2[i13];
                            } else if (c12 != 'q') {
                                if (c12 == 'v') {
                                    path.rLineTo(0.0f, fArr2[i13]);
                                    f13 = fArr2[i13];
                                } else if (c12 == 'L') {
                                    int i21 = i13 + 1;
                                    path.lineTo(fArr2[i13], fArr2[i21]);
                                    f24 = fArr2[i13];
                                    f25 = fArr2[i21];
                                } else if (c12 == 'M') {
                                    f24 = fArr2[i13];
                                    f25 = fArr2[i13 + 1];
                                    if (i13 > 0) {
                                        path.lineTo(f24, f25);
                                    } else {
                                        path.moveTo(f24, f25);
                                        i12 = i13;
                                        f27 = f25;
                                        f26 = f24;
                                    }
                                } else if (c12 == 'S') {
                                    if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                        f24 = (f24 * 2.0f) - f20;
                                        f25 = (f25 * 2.0f) - f21;
                                    }
                                    float f33 = f25;
                                    float f34 = f24;
                                    int i22 = i13 + 1;
                                    int i23 = i13 + 2;
                                    int i24 = i13 + 3;
                                    path.cubicTo(f34, f33, fArr2[i13], fArr2[i22], fArr2[i23], fArr2[i24]);
                                    f10 = fArr2[i13];
                                    f11 = fArr2[i22];
                                    f24 = fArr2[i23];
                                    f25 = fArr2[i24];
                                    f20 = f10;
                                    f21 = f11;
                                } else if (c12 == 'T') {
                                    if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                        f24 = (f24 * 2.0f) - f20;
                                        f25 = (f25 * 2.0f) - f21;
                                    }
                                    int i25 = i13 + 1;
                                    path.quadTo(f24, f25, fArr2[i13], fArr2[i25]);
                                    i12 = i13;
                                    f21 = f25;
                                    f20 = f24;
                                    f24 = fArr2[i13];
                                    f25 = fArr2[i25];
                                } else if (c12 == 'l') {
                                    int i26 = i13 + 1;
                                    path.rLineTo(fArr2[i13], fArr2[i26]);
                                    f24 += fArr2[i13];
                                    f13 = fArr2[i26];
                                } else if (c12 == 'm') {
                                    float f35 = fArr2[i13];
                                    f24 += f35;
                                    float f36 = fArr2[i13 + 1];
                                    f25 += f36;
                                    if (i13 > 0) {
                                        path.rLineTo(f35, f36);
                                    } else {
                                        path.rMoveTo(f35, f36);
                                        i12 = i13;
                                        f27 = f25;
                                        f26 = f24;
                                    }
                                } else if (c12 == 's') {
                                    if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                        float f37 = f24 - f20;
                                        f14 = f25 - f21;
                                        f15 = f37;
                                    } else {
                                        f15 = 0.0f;
                                        f14 = 0.0f;
                                    }
                                    int i27 = i13 + 1;
                                    int i28 = i13 + 2;
                                    int i29 = i13 + 3;
                                    path.rCubicTo(f15, f14, fArr2[i13], fArr2[i27], fArr2[i28], fArr2[i29]);
                                    f10 = fArr2[i13] + f24;
                                    f11 = fArr2[i27] + f25;
                                    f24 += fArr2[i28];
                                    f12 = fArr2[i29];
                                } else if (c12 == 't') {
                                    if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                        f16 = f24 - f20;
                                        f17 = f25 - f21;
                                    } else {
                                        f17 = 0.0f;
                                        f16 = 0.0f;
                                    }
                                    int i30 = i13 + 1;
                                    path.rQuadTo(f16, f17, fArr2[i13], fArr2[i30]);
                                    float f38 = f16 + f24;
                                    float f39 = f17 + f25;
                                    f24 += fArr2[i13];
                                    f25 += fArr2[i30];
                                    f21 = f39;
                                    f20 = f38;
                                }
                                f25 += f13;
                            } else {
                                int i31 = i13 + 1;
                                int i32 = i13 + 2;
                                int i33 = i13 + 3;
                                path.rQuadTo(fArr2[i13], fArr2[i31], fArr2[i32], fArr2[i33]);
                                f10 = fArr2[i13] + f24;
                                f11 = fArr2[i31] + f25;
                                f24 += fArr2[i32];
                                f12 = fArr2[i33];
                            }
                            i12 = i13;
                        } else {
                            int i34 = i13 + 2;
                            int i35 = i13 + 3;
                            int i36 = i13 + 4;
                            int i37 = i13 + 5;
                            path.rCubicTo(fArr2[i13], fArr2[i13 + 1], fArr2[i34], fArr2[i35], fArr2[i36], fArr2[i37]);
                            f10 = fArr2[i34] + f24;
                            f11 = fArr2[i35] + f25;
                            f24 += fArr2[i36];
                            f12 = fArr2[i37];
                        }
                        f25 += f12;
                        f20 = f10;
                        f21 = f11;
                        i12 = i13;
                    } else {
                        int i38 = i13 + 5;
                        int i39 = i13 + 6;
                        i12 = i13;
                        drawArc(path, f24, f25, fArr2[i38] + f24, fArr2[i39] + f25, fArr2[i13], fArr2[i13 + 1], fArr2[i13 + 2], fArr2[i13 + 3] != 0.0f, fArr2[i13 + 4] != 0.0f);
                        f24 += fArr2[i38];
                        f25 += fArr2[i39];
                    }
                    i13 = i12 + i11;
                    c13 = c11;
                    c12 = c13;
                    z10 = false;
                } else {
                    i12 = i13;
                    int i40 = i12 + 5;
                    int i41 = i12 + 6;
                    drawArc(path, f24, f25, fArr2[i40], fArr2[i41], fArr2[i12], fArr2[i12 + 1], fArr2[i12 + 2], fArr2[i12 + 3] != 0.0f, fArr2[i12 + 4] != 0.0f);
                    f24 = fArr2[i40];
                    f25 = fArr2[i41];
                }
                f21 = f25;
                f20 = f24;
                i13 = i12 + i11;
                c13 = c11;
                c12 = c13;
                z10 = false;
            }
            fArr[z10 ? 1 : 0] = f24;
            fArr[1] = f25;
            fArr[2] = f20;
            fArr[3] = f21;
            fArr[4] = f26;
            fArr[5] = f27;
        }

        private static void arcToBezier(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
            double d19 = d12;
            int iCeil = (int) Math.ceil(Math.abs((d18 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d16);
            double dSin = Math.sin(d16);
            double dCos2 = Math.cos(d17);
            double dSin2 = Math.sin(d17);
            double d20 = -d19;
            double d21 = d20 * dCos;
            double d22 = d13 * dSin;
            double d23 = (d21 * dSin2) - (d22 * dCos2);
            double d24 = d20 * dSin;
            double d25 = d13 * dCos;
            double d26 = (dCos2 * d25) + (dSin2 * d24);
            double d27 = d18 / ((double) iCeil);
            double d28 = d26;
            double d29 = d23;
            int i10 = 0;
            double d30 = d14;
            double d31 = d15;
            double d32 = d17;
            while (i10 < iCeil) {
                double d33 = d32 + d27;
                double dSin3 = Math.sin(d33);
                double dCos3 = Math.cos(d33);
                double d34 = (((d19 * dCos) * dCos3) + d10) - (d22 * dSin3);
                double d35 = (d25 * dSin3) + (d19 * dSin * dCos3) + d11;
                double d36 = (d21 * dSin3) - (d22 * dCos3);
                double d37 = (dCos3 * d25) + (dSin3 * d24);
                double d38 = d33 - d32;
                double dTan = Math.tan(d38 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d38)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d29 * dSqrt) + d30), (float) ((d28 * dSqrt) + d31), (float) (d34 - (dSqrt * d36)), (float) (d35 - (dSqrt * d37)), (float) d34, (float) d35);
                i10++;
                d27 = d27;
                dSin = dSin;
                d30 = d34;
                d24 = d24;
                dCos = dCos;
                d32 = d33;
                d28 = d37;
                d29 = d36;
                iCeil = iCeil;
                d31 = d35;
                d19 = d12;
            }
        }

        private static void drawArc(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
            double d10;
            double d11;
            double radians = Math.toRadians(f16);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d12 = f10;
            double d13 = d12 * dCos;
            double d14 = f11;
            double d15 = f14;
            double d16 = ((d14 * dSin) + d13) / d15;
            double d17 = f15;
            double d18 = ((d14 * dCos) + (((double) (-f10)) * dSin)) / d17;
            double d19 = f13;
            double d20 = ((d19 * dSin) + (((double) f12) * dCos)) / d15;
            double d21 = ((d19 * dCos) + (((double) (-f12)) * dSin)) / d17;
            double d22 = d16 - d20;
            double d23 = d18 - d21;
            double d24 = (d16 + d20) / 2.0d;
            double d25 = (d18 + d21) / 2.0d;
            double d26 = (d23 * d23) + (d22 * d22);
            if (d26 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d27 = (1.0d / d26) - 0.25d;
            if (d27 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d26);
                float fSqrt = (float) (Math.sqrt(d26) / 1.99999d);
                drawArc(path, f10, f11, f12, f13, f14 * fSqrt, f15 * fSqrt, f16, z10, z11);
                return;
            }
            double dSqrt = Math.sqrt(d27);
            double d28 = d22 * dSqrt;
            double d29 = dSqrt * d23;
            if (z10 == z11) {
                d10 = d24 - d29;
                d11 = d25 + d28;
            } else {
                d10 = d24 + d29;
                d11 = d25 - d28;
            }
            double dAtan2 = Math.atan2(d18 - d11, d16 - d10);
            double dAtan3 = Math.atan2(d21 - d11, d20 - d10) - dAtan2;
            if (z11 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d30 = d10 * d15;
            double d31 = d11 * d17;
            arcToBezier(path, (d30 * dCos) - (d31 * dSin), (d31 * dCos) + (d30 * dSin), d15, d17, d12, d14, radians, dAtan2, dAtan3);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c10 = f.f9271d;
            for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
                PathDataNode pathDataNode = pathDataNodeArr[i10];
                addCommand(path, fArr, c10, pathDataNode.mType, pathDataNode.mParams);
                c10 = pathDataNodeArr[i10].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f10) {
            this.mType = pathDataNode.mType;
            int i10 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i10 >= fArr.length) {
                    return;
                }
                this.mParams[i10] = (pathDataNode2.mParams[i10] * f10) + ((1.0f - f10) * fArr[i10]);
                i10++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }
}
