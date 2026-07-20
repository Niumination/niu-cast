package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotcardsdk.bean.DeviceType;
import h0.a;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c9, float[] fArr) {
        arrayList.add(new PathDataNode(c9, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i8 = 0; i8 < pathDataNodeArr.length; i8++) {
            if (pathDataNodeArr[i8].mType != pathDataNodeArr2[i8].mType || pathDataNodeArr[i8].mParams.length != pathDataNodeArr2[i8].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i8, int i9) {
        if (i8 > i9) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i8 < 0 || i8 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i10 = i9 - i8;
        int iMin = Math.min(i10, length - i8);
        float[] fArr2 = new float[i10];
        System.arraycopy(fArr, i8, fArr2, 0, iMin);
        return fArr2;
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        int i9 = 1;
        while (i9 < str.length()) {
            int iNextStart = nextStart(str, i9);
            String strTrim = str.substring(i8, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i8 = iNextStart;
            i9 = iNextStart + 1;
        }
        if (i9 - i8 == 1 && i8 < str.length()) {
            addNode(arrayList, str.charAt(i8), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(a.i("Error in parsing ", str), e);
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i8 = 0; i8 < pathDataNodeArr.length; i8++) {
            pathDataNodeArr2[i8] = new PathDataNode(pathDataNodeArr[i8]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    private static void extract(String str, int i8, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z5 = false;
        for (int i9 = i8; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == ' ') {
                z2 = false;
                z5 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z2 = false;
                        z5 = true;
                        break;
                    case '-':
                        if (i9 == i8 || z2) {
                            z2 = false;
                        } else {
                            extractFloatResult.mEndWithNegOrDot = true;
                            z2 = false;
                            z5 = true;
                        }
                        break;
                    case '.':
                        if (z3) {
                            extractFloatResult.mEndWithNegOrDot = true;
                            z2 = false;
                            z5 = true;
                        } else {
                            z2 = false;
                            z3 = true;
                        }
                        break;
                    default:
                        z2 = false;
                        break;
                }
            } else {
                z2 = true;
            }
            if (z5) {
                extractFloatResult.mEndPosition = i9;
            }
        }
        extractFloatResult.mEndPosition = i9;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i8 = 1;
            int i9 = 0;
            while (i8 < length) {
                extract(str, i8, extractFloatResult);
                int i10 = extractFloatResult.mEndPosition;
                if (i8 < i10) {
                    fArr[i9] = Float.parseFloat(str.substring(i8, i10));
                    i9++;
                }
                i8 = extractFloatResult.mEndWithNegOrDot ? i10 : i10 + 1;
            }
            return copyOfRange(fArr, 0, i9);
        } catch (NumberFormatException e) {
            throw new RuntimeException(a.j("error in parsing \"", str, "\""), e);
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    private static int nextStart(String str, int i8) {
        while (i8 < str.length()) {
            char cCharAt = str.charAt(i8);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                } else if (cCharAt != 'e' && cCharAt != 'E') {
                    return i8;
                }
            } else if (cCharAt != 'e') {
                continue;
            }
            i8++;
        }
        return i8;
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c9 = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c9, pathDataNode.mType, pathDataNode.mParams);
            c9 = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i8 = 0; i8 < pathDataNodeArr2.length; i8++) {
            pathDataNodeArr[i8].mType = pathDataNodeArr2[i8].mType;
            for (int i9 = 0; i9 < pathDataNodeArr2[i8].mParams.length; i9++) {
                pathDataNodeArr[i8].mParams[i9] = pathDataNodeArr2[i8].mParams[i9];
            }
        }
    }

    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(char c9, float[] fArr) {
            this.mType = c9;
            this.mParams = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c9, char c10, float[] fArr2) {
            int i8;
            int i9;
            int i10;
            float f;
            float f4;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            char c11 = c10;
            boolean z2 = false;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[3];
            float f20 = fArr[4];
            float f21 = fArr[5];
            switch (c11) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case 'a':
                    i8 = 7;
                    i9 = i8;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                case 'c':
                    i8 = 6;
                    i9 = i8;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i9 = 1;
                    break;
                case Base64.mimeLineLength /* 76 */:
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i9 = 2;
                    break;
                case 'Q':
                case 'S':
                case DeviceType.INFRARED_ELECTRIC_HEATER /* 113 */:
                case DeviceType.INFRARED_CURTAIN /* 115 */:
                    i9 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f20, f21);
                    f16 = f20;
                    f18 = f16;
                    f17 = f21;
                    f19 = f17;
                    i9 = 2;
                    break;
            }
            float f22 = f16;
            float f23 = f17;
            float f24 = f20;
            float f25 = f21;
            int i11 = 0;
            char c12 = c9;
            while (i11 < fArr2.length) {
                if (c11 != 'A') {
                    if (c11 == 'C') {
                        i10 = i11;
                        int i12 = i10 + 2;
                        int i13 = i10 + 3;
                        int i14 = i10 + 4;
                        int i15 = i10 + 5;
                        path.cubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i12], fArr2[i13], fArr2[i14], fArr2[i15]);
                        f22 = fArr2[i14];
                        float f26 = fArr2[i15];
                        float f27 = fArr2[i12];
                        float f28 = fArr2[i13];
                        f23 = f26;
                        f19 = f28;
                        f18 = f27;
                    } else if (c11 == 'H') {
                        i10 = i11;
                        path.lineTo(fArr2[i10], f23);
                        f22 = fArr2[i10];
                    } else if (c11 == 'Q') {
                        i10 = i11;
                        int i16 = i10 + 1;
                        int i17 = i10 + 2;
                        int i18 = i10 + 3;
                        path.quadTo(fArr2[i10], fArr2[i16], fArr2[i17], fArr2[i18]);
                        float f29 = fArr2[i10];
                        float f30 = fArr2[i16];
                        f22 = fArr2[i17];
                        f23 = fArr2[i18];
                        f18 = f29;
                        f19 = f30;
                    } else if (c11 == 'V') {
                        i10 = i11;
                        path.lineTo(f22, fArr2[i10]);
                        f23 = fArr2[i10];
                    } else if (c11 != 'a') {
                        if (c11 != 'c') {
                            if (c11 == 'h') {
                                path.rLineTo(fArr2[i11], 0.0f);
                                f22 += fArr2[i11];
                            } else if (c11 != 'q') {
                                if (c11 == 'v') {
                                    path.rLineTo(0.0f, fArr2[i11]);
                                    f11 = fArr2[i11];
                                } else if (c11 == 'L') {
                                    int i19 = i11 + 1;
                                    path.lineTo(fArr2[i11], fArr2[i19]);
                                    f22 = fArr2[i11];
                                    f23 = fArr2[i19];
                                } else if (c11 == 'M') {
                                    f22 = fArr2[i11];
                                    f23 = fArr2[i11 + 1];
                                    if (i11 > 0) {
                                        path.lineTo(f22, f23);
                                    } else {
                                        path.moveTo(f22, f23);
                                        i10 = i11;
                                        f25 = f23;
                                        f24 = f22;
                                    }
                                } else if (c11 == 'S') {
                                    if (c12 == 'c' || c12 == 's' || c12 == 'C' || c12 == 'S') {
                                        f22 = (f22 * 2.0f) - f18;
                                        f23 = (f23 * 2.0f) - f19;
                                    }
                                    float f31 = f23;
                                    float f32 = f22;
                                    int i20 = i11 + 1;
                                    int i21 = i11 + 2;
                                    int i22 = i11 + 3;
                                    path.cubicTo(f32, f31, fArr2[i11], fArr2[i20], fArr2[i21], fArr2[i22]);
                                    f = fArr2[i11];
                                    f4 = fArr2[i20];
                                    f22 = fArr2[i21];
                                    f23 = fArr2[i22];
                                    f18 = f;
                                    f19 = f4;
                                } else if (c11 == 'T') {
                                    if (c12 == 'q' || c12 == 't' || c12 == 'Q' || c12 == 'T') {
                                        f22 = (f22 * 2.0f) - f18;
                                        f23 = (f23 * 2.0f) - f19;
                                    }
                                    int i23 = i11 + 1;
                                    path.quadTo(f22, f23, fArr2[i11], fArr2[i23]);
                                    i10 = i11;
                                    f19 = f23;
                                    f18 = f22;
                                    f22 = fArr2[i11];
                                    f23 = fArr2[i23];
                                } else if (c11 == 'l') {
                                    int i24 = i11 + 1;
                                    path.rLineTo(fArr2[i11], fArr2[i24]);
                                    f22 += fArr2[i11];
                                    f11 = fArr2[i24];
                                } else if (c11 == 'm') {
                                    float f33 = fArr2[i11];
                                    f22 += f33;
                                    float f34 = fArr2[i11 + 1];
                                    f23 += f34;
                                    if (i11 > 0) {
                                        path.rLineTo(f33, f34);
                                    } else {
                                        path.rMoveTo(f33, f34);
                                        i10 = i11;
                                        f25 = f23;
                                        f24 = f22;
                                    }
                                } else if (c11 == 's') {
                                    if (c12 == 'c' || c12 == 's' || c12 == 'C' || c12 == 'S') {
                                        float f35 = f22 - f18;
                                        f12 = f23 - f19;
                                        f13 = f35;
                                    } else {
                                        f13 = 0.0f;
                                        f12 = 0.0f;
                                    }
                                    int i25 = i11 + 1;
                                    int i26 = i11 + 2;
                                    int i27 = i11 + 3;
                                    path.rCubicTo(f13, f12, fArr2[i11], fArr2[i25], fArr2[i26], fArr2[i27]);
                                    f = fArr2[i11] + f22;
                                    f4 = fArr2[i25] + f23;
                                    f22 += fArr2[i26];
                                    f10 = fArr2[i27];
                                } else if (c11 == 't') {
                                    if (c12 == 'q' || c12 == 't' || c12 == 'Q' || c12 == 'T') {
                                        f14 = f22 - f18;
                                        f15 = f23 - f19;
                                    } else {
                                        f15 = 0.0f;
                                        f14 = 0.0f;
                                    }
                                    int i28 = i11 + 1;
                                    path.rQuadTo(f14, f15, fArr2[i11], fArr2[i28]);
                                    float f36 = f14 + f22;
                                    float f37 = f15 + f23;
                                    f22 += fArr2[i11];
                                    f23 += fArr2[i28];
                                    f19 = f37;
                                    f18 = f36;
                                }
                                f23 += f11;
                            } else {
                                int i29 = i11 + 1;
                                int i30 = i11 + 2;
                                int i31 = i11 + 3;
                                path.rQuadTo(fArr2[i11], fArr2[i29], fArr2[i30], fArr2[i31]);
                                f = fArr2[i11] + f22;
                                f4 = fArr2[i29] + f23;
                                f22 += fArr2[i30];
                                f10 = fArr2[i31];
                            }
                            i10 = i11;
                        } else {
                            int i32 = i11 + 2;
                            int i33 = i11 + 3;
                            int i34 = i11 + 4;
                            int i35 = i11 + 5;
                            path.rCubicTo(fArr2[i11], fArr2[i11 + 1], fArr2[i32], fArr2[i33], fArr2[i34], fArr2[i35]);
                            f = fArr2[i32] + f22;
                            f4 = fArr2[i33] + f23;
                            f22 += fArr2[i34];
                            f10 = fArr2[i35];
                        }
                        f23 += f10;
                        f18 = f;
                        f19 = f4;
                        i10 = i11;
                    } else {
                        int i36 = i11 + 5;
                        int i37 = i11 + 6;
                        i10 = i11;
                        drawArc(path, f22, f23, fArr2[i36] + f22, fArr2[i37] + f23, fArr2[i11], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3] != 0.0f, fArr2[i11 + 4] != 0.0f);
                        f22 += fArr2[i36];
                        f23 += fArr2[i37];
                    }
                    i11 = i10 + i9;
                    c12 = c10;
                    c11 = c12;
                    z2 = false;
                } else {
                    i10 = i11;
                    int i38 = i10 + 5;
                    int i39 = i10 + 6;
                    drawArc(path, f22, f23, fArr2[i38], fArr2[i39], fArr2[i10], fArr2[i10 + 1], fArr2[i10 + 2], fArr2[i10 + 3] != 0.0f, fArr2[i10 + 4] != 0.0f);
                    f22 = fArr2[i38];
                    f23 = fArr2[i39];
                }
                f19 = f23;
                f18 = f22;
                i11 = i10 + i9;
                c12 = c10;
                c11 = c12;
                z2 = false;
            }
            fArr[z2 ? 1 : 0] = f22;
            fArr[1] = f23;
            fArr[2] = f18;
            fArr[3] = f19;
            fArr[4] = f24;
            fArr[5] = f25;
        }

        private static void arcToBezier(Path path, double d7, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
            double d18 = d11;
            int iCeil = (int) Math.ceil(Math.abs((d17 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d15);
            double dSin = Math.sin(d15);
            double dCos2 = Math.cos(d16);
            double dSin2 = Math.sin(d16);
            double d19 = -d18;
            double d20 = d19 * dCos;
            double d21 = d12 * dSin;
            double d22 = (d20 * dSin2) - (d21 * dCos2);
            double d23 = d19 * dSin;
            double d24 = d12 * dCos;
            double d25 = (dCos2 * d24) + (dSin2 * d23);
            double d26 = d17 / ((double) iCeil);
            double d27 = d25;
            double d28 = d22;
            int i8 = 0;
            double d29 = d13;
            double d30 = d14;
            double d31 = d16;
            while (i8 < iCeil) {
                double d32 = d31 + d26;
                double dSin3 = Math.sin(d32);
                double dCos3 = Math.cos(d32);
                double d33 = (((d18 * dCos) * dCos3) + d7) - (d21 * dSin3);
                double d34 = (d24 * dSin3) + (d18 * dSin * dCos3) + d10;
                double d35 = (d20 * dSin3) - (d21 * dCos3);
                double d36 = (dCos3 * d24) + (dSin3 * d23);
                double d37 = d32 - d31;
                double dTan = Math.tan(d37 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d37)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d28 * dSqrt) + d29), (float) ((d27 * dSqrt) + d30), (float) (d33 - (dSqrt * d35)), (float) (d34 - (dSqrt * d36)), (float) d33, (float) d34);
                i8++;
                d26 = d26;
                dSin = dSin;
                d29 = d33;
                d23 = d23;
                dCos = dCos;
                d31 = d32;
                d27 = d36;
                d28 = d35;
                iCeil = iCeil;
                d30 = d34;
                d18 = d11;
            }
        }

        private static void drawArc(Path path, float f, float f4, float f10, float f11, float f12, float f13, float f14, boolean z2, boolean z3) {
            double d7;
            double d10;
            double radians = Math.toRadians(f14);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d11 = f;
            double d12 = d11 * dCos;
            double d13 = f4;
            double d14 = f12;
            double d15 = ((d13 * dSin) + d12) / d14;
            double d16 = f13;
            double d17 = ((d13 * dCos) + (((double) (-f)) * dSin)) / d16;
            double d18 = f11;
            double d19 = ((d18 * dSin) + (((double) f10) * dCos)) / d14;
            double d20 = ((d18 * dCos) + (((double) (-f10)) * dSin)) / d16;
            double d21 = d15 - d19;
            double d22 = d17 - d20;
            double d23 = (d15 + d19) / 2.0d;
            double d24 = (d17 + d20) / 2.0d;
            double d25 = (d22 * d22) + (d21 * d21);
            if (d25 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d26 = (1.0d / d25) - 0.25d;
            if (d26 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d25);
                float fSqrt = (float) (Math.sqrt(d25) / 1.99999d);
                drawArc(path, f, f4, f10, f11, f12 * fSqrt, f13 * fSqrt, f14, z2, z3);
                return;
            }
            double dSqrt = Math.sqrt(d26);
            double d27 = d21 * dSqrt;
            double d28 = dSqrt * d22;
            if (z2 == z3) {
                d7 = d23 - d28;
                d10 = d24 + d27;
            } else {
                d7 = d23 + d28;
                d10 = d24 - d27;
            }
            double dAtan2 = Math.atan2(d17 - d10, d15 - d7);
            double dAtan3 = Math.atan2(d20 - d10, d19 - d7) - dAtan2;
            if (z3 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d29 = d7 * d14;
            double d30 = d10 * d16;
            arcToBezier(path, (d29 * dCos) - (d30 * dSin), (d30 * dCos) + (d29 * dSin), d14, d16, d11, d13, radians, dAtan2, dAtan3);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i8 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i8 >= fArr.length) {
                    return;
                }
                this.mParams[i8] = (pathDataNode2.mParams[i8] * f) + ((1.0f - f) * fArr[i8]);
                i8++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i8 = 0; i8 < pathDataNodeArr.length; i8++) {
                pathDataNodeArr[i8].interpolatePathDataNode(pathDataNodeArr2[i8], pathDataNodeArr3[i8], f);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
