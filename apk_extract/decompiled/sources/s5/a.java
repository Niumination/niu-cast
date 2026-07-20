package s5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.Image;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzap;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzas;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzat;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzau;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzav;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzax;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzay;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaz;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbu;
import com.google.android.libraries.barhopper.BarhopperV3;
import com.google.android.libraries.barhopper.RecognitionOptions;
import g4.b;
import g4.c;
import g4.d;
import g4.e;
import g4.f;
import g4.g;
import g4.j;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l3.b0;
import l3.h;
import l3.i;
import l3.m;
import l3.m0;
import l3.p;
import l3.q0;
import l3.y0;
import u2.l;
import y5.k;
import y5.n;
import y5.o;
import y5.q;
import y5.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends h implements i {
    public static final int[] e = {5, 7, 7, 7, 5, 5};
    public static final double[][] f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecognitionOptions f9511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BarhopperV3 f9512d;

    static {
        double[] dArr = new double[2];
        // fill-array-data instruction
        dArr[0] = 0.5d;
        dArr[1] = 1.0d;
        f = new double[][]{new double[]{0.075d, 1.0d}, new double[]{0.1d, 1.0d}, new double[]{0.125d, 1.0d}, new double[]{0.2d, 2.0d}, new double[]{0.2d, 0.5d}, new double[]{0.15d, 1.0d}, new double[]{0.2d, 1.0d}, new double[]{0.25d, 1.0d}, new double[]{0.35d, 2.0d}, new double[]{0.35d, 0.5d}, new double[]{0.35d, 3.0d}, new double[]{0.35d, 0.3333d}, new double[]{0.3d, 1.0d}, new double[]{0.4d, 1.0d}, dArr, new double[]{0.5d, 2.0d}, new double[]{0.5d, 0.5d}, new double[]{0.5d, 3.0d}, new double[]{0.5d, 0.3333d}, new double[]{0.6d, 1.0d}, new double[]{0.8d, 1.0d}, new double[]{1.0d, 1.0d}, new double[]{0.65d, 2.0d}, new double[]{0.65d, 0.5d}, new double[]{0.65d, 3.0d}, new double[]{0.65d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.8d, 2.0d}, new double[]{0.8d, 0.5d}, new double[]{0.8d, 3.0d}, new double[]{0.8d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.95d, 2.0d}, new double[]{0.95d, 0.5d}, new double[]{0.95d, 3.0d}, new double[]{0.95d, 0.3333d}};
    }

    public a(Context context, zzbc zzbcVar) {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
        RecognitionOptions recognitionOptions = new RecognitionOptions();
        this.f9511c = recognitionOptions;
        this.f9510b = context;
        recognitionOptions.a(zzbcVar.f2198a);
        recognitionOptions.b(zzbcVar.f2199b);
    }

    public static zzap g(n nVar, String str, String str2) {
        if (nVar == null || str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return new zzap(nVar.t(), nVar.r(), nVar.o(), nVar.p(), nVar.q(), nVar.s(), nVar.v(), matcher.find() ? matcher.group(1) : null);
    }

    /* JADX WARN: Code duplicated, block: B:237:0x0654 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:? A[Catch: IOException -> 0x0631, SYNTHETIC, TRY_LEAVE, TryCatch #4 {IOException -> 0x0631, blocks: (B:189:0x059b, B:204:0x062d, B:232:0x065d, B:231:0x065a, B:227:0x0654, B:190:0x05a5, B:199:0x0624, B:225:0x0651, B:224:0x064e, B:220:0x0648, B:191:0x05af, B:194:0x061b, B:218:0x0645, B:217:0x0642), top: B:242:0x059b, inners: #1, #3 }] */
    @Override // l3.h
    public final boolean e(int i8, Parcel parcel, Parcel parcel2) throws IllegalAccessException, InvocationTargetException {
        y5.a aVarH;
        Matrix matrix;
        zzat zzatVar;
        zzaw zzawVar;
        zzax zzaxVar;
        zzaz zzazVar;
        zzay zzayVar;
        zzau zzauVar;
        zzaq zzaqVar;
        zzar zzarVar;
        zzas zzasVar;
        int i9;
        int i10;
        Point[] pointArr;
        int i11;
        int i12;
        zzaw[] zzawVarArr;
        zzat[] zzatVarArr;
        zzao[] zzaoVarArr;
        int i13 = 1;
        int i14 = 0;
        if (i8 == 1) {
            Context context = this.f9510b;
            if (this.f9512d == null) {
                BarhopperV3 barhopperV3 = new BarhopperV3();
                System.loadLibrary("barhopper_v3");
                this.f9512d = barhopperV3;
                f fVarO = g.o();
                d dVarO = e.o();
                int i15 = 16;
                int i16 = 0;
                int i17 = 0;
                while (i16 < 6) {
                    b bVarO = c.o();
                    bVarO.f();
                    c.s((c) bVarO.f7270b, i15);
                    bVarO.f();
                    c.p((c) bVarO.f7270b, i15);
                    int i18 = i17;
                    int i19 = 0;
                    while (i19 < e[i16]) {
                        double[] dArr = f[i18];
                        double d7 = dArr[0] * 320.0d;
                        f fVar = fVarO;
                        float fSqrt = (float) Math.sqrt(dArr[i13]);
                        float f4 = (float) d7;
                        bVarO.f();
                        c.q((c) bVarO.f7270b, f4 / fSqrt);
                        bVarO.f();
                        c.r((c) bVarO.f7270b, f4 * fSqrt);
                        i13 = 1;
                        i18++;
                        i19++;
                        fVarO = fVar;
                    }
                    i15 += i15;
                    dVarO.f();
                    e.p((e) dVarO.f7270b, (c) bVarO.c());
                    i16 += i13;
                    fVarO = fVarO;
                    i17 = i18;
                }
                f fVar2 = fVarO;
                fVar2.f();
                g.p((g) fVar2.f7270b, (e) dVarO.c());
                try {
                    InputStream inputStreamOpen = context.getAssets().open("mlkit_barcode_models/barcode_ssd_mobilenet_v1_dmp25_quant.tflite");
                    try {
                        InputStream inputStreamOpen2 = context.getAssets().open("mlkit_barcode_models/oned_auto_regressor_mobile.tflite");
                        try {
                            InputStream inputStreamOpen3 = context.getAssets().open("mlkit_barcode_models/oned_feature_extractor_mobile.tflite");
                            try {
                                BarhopperV3 barhopperV4 = this.f9512d;
                                l.e(barhopperV4);
                                g4.h hVarO = g4.a.o();
                                b0 b0VarZzs = b0.zzs(inputStreamOpen);
                                fVar2.f();
                                g.q((g) fVar2.f7270b, b0VarZzs);
                                hVarO.f();
                                g4.a.p((g4.a) hVarO.f7270b, (g) fVar2.c());
                                g4.i iVarO = j.o();
                                b0 b0VarZzs2 = b0.zzs(inputStreamOpen2);
                                iVarO.f();
                                j.q((j) iVarO.f7270b, b0VarZzs2);
                                b0 b0VarZzs3 = b0.zzs(inputStreamOpen3);
                                iVarO.f();
                                j.p((j) iVarO.f7270b, b0VarZzs3);
                                hVarO.f();
                                g4.a.q((g4.a) hVarO.f7270b, (j) iVarO.c());
                                barhopperV4.a((g4.a) hVarO.c());
                                if (inputStreamOpen3 != null) {
                                    inputStreamOpen3.close();
                                }
                                if (inputStreamOpen2 != null) {
                                    inputStreamOpen2.close();
                                }
                                if (inputStreamOpen != null) {
                                    inputStreamOpen.close();
                                }
                            } catch (Throwable th2) {
                                if (inputStreamOpen3 == null) {
                                    throw th2;
                                }
                                try {
                                    inputStreamOpen3.close();
                                    throw th2;
                                } catch (Throwable th3) {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                                    throw th2;
                                }
                                if (inputStreamOpen != null) {
                                    throw th;
                                }
                                try {
                                    inputStreamOpen.close();
                                    throw th;
                                } catch (Throwable th4) {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th4);
                                    throw th;
                                }
                            }
                        } catch (Throwable th5) {
                            if (inputStreamOpen2 == null) {
                                throw th5;
                            }
                            try {
                                inputStreamOpen2.close();
                                throw th5;
                            } catch (Throwable th6) {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th5, th6);
                                throw th5;
                            }
                            throw new IllegalStateException("Failed to open Barcode models", e);
                        }
                    } catch (Throwable th7) {
                        if (inputStreamOpen != null) {
                            throw th7;
                        }
                        inputStreamOpen.close();
                        throw th7;
                    }
                } catch (IOException e4) {
                    throw new IllegalStateException("Failed to open Barcode models", e4);
                }
            }
            parcel2.writeNoException();
            return true;
        }
        q0 q0Var = null;
        if (i8 == 2) {
            BarhopperV3 barhopperV5 = this.f9512d;
            if (barhopperV5 != null) {
                barhopperV5.close();
                this.f9512d = null;
            }
            parcel2.writeNoException();
        } else {
            if (i8 != 3) {
                return false;
            }
            f3.a aVarK = f3.b.k(parcel.readStrongBinder());
            Parcelable.Creator<zzbu> creator = zzbu.CREATOR;
            int i20 = m.f7268a;
            zzbu zzbuVarCreateFromParcel = parcel.readInt() == 0 ? null : creator.createFromParcel(parcel);
            int iDataAvail = parcel.dataAvail();
            if (iDataAvail > 0) {
                throw new BadParcelableException(a1.a.o(iDataAvail, "Parcel data not fully consumed, unread size: "));
            }
            int i21 = zzbuVarCreateFromParcel.f2200a;
            int i22 = -1;
            if (i21 == -1) {
                BarhopperV3 barhopperV6 = this.f9512d;
                l.e(barhopperV6);
                aVarH = barhopperV6.h((Bitmap) f3.b.l(aVarK), this.f9511c);
            } else if (i21 == 17) {
                aVarH = i((ByteBuffer) f3.b.l(aVarK), zzbuVarCreateFromParcel);
            } else if (i21 != 35) {
                if (i21 != 842094169) {
                    throw new IllegalArgumentException("Unsupported image format: " + zzbuVarCreateFromParcel.f2200a);
                }
                aVarH = i((ByteBuffer) f3.b.l(aVarK), zzbuVarCreateFromParcel);
            } else {
                Image image = (Image) f3.b.l(aVarK);
                l.e(image);
                aVarH = i(image.getPlanes()[0].getBuffer(), zzbuVarCreateFromParcel);
            }
            ArrayList arrayList = new ArrayList();
            int i23 = zzbuVarCreateFromParcel.f2203d;
            if (i23 == 0) {
                matrix = null;
            } else {
                matrix = new Matrix();
                int i24 = zzbuVarCreateFromParcel.f2201b;
                int i25 = zzbuVarCreateFromParcel.f2202c;
                matrix.postTranslate((-i24) / 2.0f, (-i25) / 2.0f);
                matrix.postRotate(i23 * 90);
                int i26 = i23 % 2;
                int i27 = i26 != 0 ? i25 : i24;
                if (i26 == 0) {
                    i24 = i25;
                }
                matrix.postTranslate(i27 / 2.0f, i24 / 2.0f);
            }
            for (y5.l lVar : aVarH.p()) {
                int i28 = 5;
                if (lVar.p() > 0 && matrix != null) {
                    float[] fArr = new float[8];
                    y0 y0VarB = lVar.B();
                    int iP = lVar.p();
                    for (int i29 = i14; i29 < iP; i29++) {
                        int i30 = i29 + i29;
                        fArr[i30] = ((y5.f) y0VarB.get(i29)).o();
                        fArr[i30 + 1] = ((y5.f) y0VarB.get(i29)).p();
                    }
                    matrix.mapPoints(fArr);
                    int i31 = i14;
                    while (i31 < iP) {
                        m0 m0Var = (m0) lVar.n(i28, q0Var);
                        m0Var.b(lVar);
                        k kVar = (k) m0Var;
                        int i32 = i31 + i31;
                        y5.e eVarQ = y5.f.q();
                        int i33 = (int) fArr[i32];
                        eVarQ.f();
                        y5.f.r((y5.f) eVarQ.f7270b, i33);
                        int i34 = (int) fArr[i32 + 1];
                        eVarQ.f();
                        y5.f.s((y5.f) eVarQ.f7270b, i34);
                        y5.f fVar3 = (y5.f) eVarQ.c();
                        kVar.f();
                        y5.l.C((y5.l) kVar.f7270b, (i31 + i23) % iP, fVar3);
                        lVar = (y5.l) kVar.c();
                        i31++;
                        q0Var = null;
                        i28 = 5;
                    }
                }
                if (lVar.G()) {
                    r rVarU = lVar.u();
                    zzatVar = new zzat(rVarU.s() + i22, rVarU.p(), rVarU.r(), rVarU.q());
                } else {
                    zzatVar = null;
                }
                if (lVar.I()) {
                    p pVarQ = lVar.q();
                    zzawVar = new zzaw(pVarQ.q() + i22, pVarQ.p());
                } else {
                    zzawVar = null;
                }
                if (lVar.J()) {
                    y5.g gVarW = lVar.w();
                    zzaxVar = new zzax(gVarW.p(), gVarW.q());
                } else {
                    zzaxVar = null;
                }
                if (lVar.L()) {
                    y5.j jVarY = lVar.y();
                    zzazVar = new zzaz(jVarY.q(), jVarY.p(), jVarY.r() + i22);
                } else {
                    zzazVar = null;
                }
                if (lVar.K()) {
                    y5.i iVarX = lVar.x();
                    zzayVar = new zzay(iVarX.p(), iVarX.q());
                } else {
                    zzayVar = null;
                }
                if (lVar.H()) {
                    y5.d dVarV = lVar.v();
                    zzauVar = new zzau(dVarV.o(), dVarV.p());
                } else {
                    zzauVar = null;
                }
                if (lVar.D()) {
                    o oVarR = lVar.r();
                    zzaqVar = new zzaq(oVarR.v(), oVarR.r(), oVarR.s(), oVarR.t(), oVarR.u(), g(oVarR.p(), lVar.z().zzn() ? lVar.z().zzu() : null, "DTSTART:([0-9TZ]*)"), g(oVarR.o(), lVar.z().zzn() ? lVar.z().zzu() : null, "DTEND:([0-9TZ]*)"));
                } else {
                    zzaqVar = null;
                }
                if (lVar.E()) {
                    y5.p pVarS = lVar.s();
                    l3.o oVarO = pVarS.o();
                    zzav zzavVar = oVarO != null ? new zzav(oVarO.q(), oVarO.u(), oVarO.t(), oVarO.p(), oVarO.s(), oVarO.r(), oVarO.v()) : null;
                    String strQ = pVarS.q();
                    String strR = pVarS.r();
                    y0 y0VarU = pVarS.u();
                    if (y0VarU.isEmpty()) {
                        zzawVarArr = null;
                    } else {
                        zzaw[] zzawVarArr2 = new zzaw[y0VarU.size()];
                        for (int i35 = i14; i35 < y0VarU.size(); i35++) {
                            zzawVarArr2[i35] = new zzaw(((p) y0VarU.get(i35)).q() + i22, ((p) y0VarU.get(i35)).p());
                        }
                        zzawVarArr = zzawVarArr2;
                    }
                    y0 y0VarT = pVarS.t();
                    if (y0VarT.isEmpty()) {
                        zzatVarArr = null;
                    } else {
                        zzat[] zzatVarArr2 = new zzat[y0VarT.size()];
                        int i36 = i14;
                        while (i36 < y0VarT.size()) {
                            zzatVarArr2[i36] = new zzat(((r) y0VarT.get(i36)).s() + i22, ((r) y0VarT.get(i36)).p(), ((r) y0VarT.get(i36)).r(), ((r) y0VarT.get(i36)).q());
                            i36++;
                            i22 = -1;
                        }
                        zzatVarArr = zzatVarArr2;
                    }
                    String[] strArr = (String[]) pVarS.v().toArray(new String[0]);
                    y0 y0VarS = pVarS.s();
                    if (y0VarS.isEmpty()) {
                        zzaoVarArr = null;
                    } else {
                        zzao[] zzaoVarArr2 = new zzao[y0VarS.size()];
                        for (int i37 = 0; i37 < y0VarS.size(); i37++) {
                            zzaoVarArr2[i37] = new zzao(((l3.n) y0VarS.get(i37)).p() - 1, (String[]) ((l3.n) y0VarS.get(i37)).o().toArray(new String[0]));
                        }
                        zzaoVarArr = zzaoVarArr2;
                    }
                    zzarVar = new zzar(zzavVar, strQ, strR, zzawVarArr, zzatVarArr, strArr, zzaoVarArr);
                } else {
                    zzarVar = null;
                }
                if (lVar.F()) {
                    q qVarT = lVar.t();
                    zzasVar = new zzas(qVarT.u(), qVarT.w(), qVarT.C(), qVarT.A(), qVarT.x(), qVarT.r(), qVarT.p(), qVarT.q(), qVarT.s(), qVarT.B(), qVarT.y(), qVarT.v(), qVarT.t(), qVarT.z());
                } else {
                    zzasVar = null;
                }
                switch (lVar.M() - 1) {
                    case 0:
                        i9 = 0;
                        break;
                    case 1:
                        i9 = 1;
                        break;
                    case 2:
                        i9 = 2;
                        break;
                    case 3:
                        i9 = 4;
                        break;
                    case 4:
                        i9 = 8;
                        break;
                    case 5:
                        i9 = 16;
                        break;
                    case 6:
                        i10 = 32;
                        i9 = i10;
                        break;
                    case 7:
                        i10 = 64;
                        i9 = i10;
                        break;
                    case 8:
                        i10 = 128;
                        i9 = i10;
                        break;
                    case 9:
                        i10 = 256;
                        i9 = i10;
                        break;
                    case 10:
                        i10 = 512;
                        i9 = i10;
                        break;
                    case 11:
                        i10 = 1024;
                        i9 = i10;
                        break;
                    case 12:
                        i10 = 2048;
                        i9 = i10;
                        break;
                    case 13:
                        i10 = 4096;
                        i9 = i10;
                        break;
                    default:
                        i9 = -1;
                        break;
                }
                String strA = lVar.A();
                String strZzu = lVar.z().zzn() ? lVar.z().zzu() : null;
                byte[] bArrZzx = lVar.z().zzx();
                y0 y0VarB2 = lVar.B();
                if (y0VarB2.isEmpty()) {
                    pointArr = null;
                } else {
                    Point[] pointArr2 = new Point[y0VarB2.size()];
                    for (int i38 = 0; i38 < y0VarB2.size(); i38++) {
                        pointArr2[i38] = new Point(((y5.f) y0VarB2.get(i38)).o(), ((y5.f) y0VarB2.get(i38)).p());
                    }
                    pointArr = pointArr2;
                }
                switch (lVar.o() - 1) {
                    case 1:
                        i11 = 1;
                        continue;
                        arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                        i22 = -1;
                        i14 = 0;
                        q0Var = null;
                        break;
                    case 2:
                        i11 = 2;
                        continue;
                        arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                        i22 = -1;
                        i14 = 0;
                        q0Var = null;
                        break;
                    case 3:
                        i11 = 3;
                        continue;
                        arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                        i22 = -1;
                        i14 = 0;
                        q0Var = null;
                        break;
                    case 4:
                        i11 = 4;
                        continue;
                        arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                        i22 = -1;
                        i14 = 0;
                        q0Var = null;
                        break;
                    case 5:
                        i11 = 5;
                        continue;
                        arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                        i22 = -1;
                        i14 = 0;
                        q0Var = null;
                        break;
                    case 6:
                        i11 = 6;
                        continue;
                        arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                        i22 = -1;
                        i14 = 0;
                        q0Var = null;
                        break;
                    case 7:
                        i12 = 7;
                        break;
                    case 8:
                        i11 = 8;
                        continue;
                        arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                        i22 = -1;
                        i14 = 0;
                        q0Var = null;
                        break;
                    case 9:
                        i12 = 9;
                        break;
                    case 10:
                        i12 = 10;
                        break;
                    case 11:
                        i12 = 11;
                        break;
                    case 12:
                        i12 = 12;
                        break;
                    default:
                        i11 = 0;
                        continue;
                        arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                        i22 = -1;
                        i14 = 0;
                        q0Var = null;
                        break;
                }
                i11 = i12;
                arrayList.add(new zzba(i9, strA, strZzu, bArrZzx, pointArr, i11, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                i22 = -1;
                i14 = 0;
                q0Var = null;
            }
            parcel2.writeNoException();
            parcel2.writeTypedList(arrayList);
        }
        return true;
    }

    public final y5.a i(ByteBuffer byteBuffer, zzbu zzbuVar) {
        BarhopperV3 barhopperV3 = this.f9512d;
        l.e(barhopperV3);
        l.e(byteBuffer);
        boolean zIsDirect = byteBuffer.isDirect();
        int i8 = zzbuVar.f2202c;
        int i9 = zzbuVar.f2201b;
        RecognitionOptions recognitionOptions = this.f9511c;
        if (zIsDirect) {
            return barhopperV3.c(i9, i8, byteBuffer, recognitionOptions);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return barhopperV3.g(i9, i8, byteBuffer.array(), recognitionOptions);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return barhopperV3.g(i9, i8, bArr, recognitionOptions);
    }
}
