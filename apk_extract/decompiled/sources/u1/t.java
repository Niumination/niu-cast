package u1;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.transsion.message.bank.MessageBank;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f5.a f10316a = f5.a.g("w", "h", "ip", MessageBank.KEY_OP, "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f5.a f10317b = f5.a.g("id", "layers", "w", "h", "p", "u");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f5.a f10318c = f5.a.g("list");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f5.a f10319d = f5.a.g("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0045. Please report as an issue. */
    public static j1.j a(v1.e eVar) {
        float f;
        ArrayList arrayList;
        float f4;
        int i8;
        float f10;
        int i9;
        float f11;
        int i10;
        float f12;
        float fC = w1.g.c();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        j1.j jVar = new j1.j();
        eVar.c();
        float fL = 0.0f;
        int iM = 0;
        int iM2 = 0;
        float fL2 = 0.0f;
        float fL3 = 0.0f;
        while (eVar.i()) {
            switch (eVar.w(f10316a)) {
                case 0:
                    arrayList3 = arrayList3;
                    iM = eVar.m();
                    arrayList3 = arrayList3;
                    break;
                case 1:
                    arrayList3 = arrayList3;
                    iM2 = eVar.m();
                    arrayList3 = arrayList3;
                    break;
                case 2:
                    fL2 = (float) eVar.l();
                    fC = fC;
                    arrayList3 = arrayList3;
                    break;
                case 3:
                    fL = ((float) eVar.l()) - 0.01f;
                    fC = fC;
                    arrayList3 = arrayList3;
                    break;
                case 4:
                    fL3 = (float) eVar.l();
                    fC = fC;
                    arrayList3 = arrayList3;
                    break;
                case 5:
                    f = fC;
                    arrayList = arrayList3;
                    f4 = fL;
                    i8 = iM2;
                    f10 = fL2;
                    String[] strArrSplit = eVar.o().split("\\.");
                    int i11 = Integer.parseInt(strArrSplit[0]);
                    int i12 = Integer.parseInt(strArrSplit[1]);
                    int i13 = Integer.parseInt(strArrSplit[2]);
                    if (i11 < 4 || (i11 <= 4 && (i12 < 4 || (i12 <= 4 && i13 < 0)))) {
                        jVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fC = f;
                    fL2 = f10;
                    arrayList3 = arrayList;
                    fL = f4;
                    iM2 = i8;
                    break;
                case 6:
                    f = fC;
                    arrayList = arrayList3;
                    f4 = fL;
                    i8 = iM2;
                    f10 = fL2;
                    eVar.a();
                    int i14 = 0;
                    while (eVar.i()) {
                        s1.i iVarA = s.a(eVar, jVar);
                        if (iVarA.e == s1.g.IMAGE) {
                            i14++;
                        }
                        arrayList2.add(iVarA);
                        longSparseArray.put(iVarA.f9475d, iVarA);
                        if (i14 > 4) {
                            w1.b.b("You have " + i14 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    eVar.g();
                    fC = f;
                    fL2 = f10;
                    arrayList3 = arrayList;
                    fL = f4;
                    iM2 = i8;
                    break;
                case 7:
                    arrayList = arrayList3;
                    f4 = fL;
                    int i15 = iM2;
                    f10 = fL2;
                    eVar.a();
                    while (eVar.i()) {
                        ArrayList arrayList4 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        eVar.c();
                        String strO = null;
                        String strO2 = null;
                        String strO3 = null;
                        int iM3 = 0;
                        int iM4 = 0;
                        while (eVar.i()) {
                            int iW = eVar.w(f10317b);
                            if (iW != 0) {
                                if (iW == 1) {
                                    eVar.a();
                                    while (eVar.i()) {
                                        s1.i iVarA2 = s.a(eVar, jVar);
                                        longSparseArray2.put(iVarA2.f9475d, iVarA2);
                                        arrayList4.add(iVarA2);
                                        fC = fC;
                                        i15 = i15;
                                    }
                                    i9 = i15;
                                    f11 = fC;
                                    eVar.g();
                                } else if (iW == 2) {
                                    iM3 = eVar.m();
                                } else if (iW == 3) {
                                    iM4 = eVar.m();
                                } else if (iW == 4) {
                                    strO2 = eVar.o();
                                } else if (iW != 5) {
                                    eVar.A();
                                    eVar.B();
                                    i9 = i15;
                                    f11 = fC;
                                } else {
                                    strO3 = eVar.o();
                                }
                                fC = f11;
                                i15 = i9;
                            } else {
                                strO = eVar.o();
                            }
                        }
                        int i16 = i15;
                        float f13 = fC;
                        eVar.h();
                        if (strO2 != null) {
                            map2.put(strO, new j1.z(iM3, iM4, strO, strO2, strO3));
                        } else {
                            map.put(strO, arrayList4);
                        }
                        fC = f13;
                        i15 = i16;
                    }
                    i8 = i15;
                    f = fC;
                    eVar.g();
                    fC = f;
                    fL2 = f10;
                    arrayList3 = arrayList;
                    fL = f4;
                    iM2 = i8;
                    break;
                case 8:
                    f4 = fL;
                    int i17 = iM2;
                    f10 = fL2;
                    eVar.c();
                    while (eVar.i()) {
                        if (eVar.w(f10318c) != 0) {
                            eVar.A();
                            eVar.B();
                        } else {
                            eVar.a();
                            while (eVar.i()) {
                                f5.a aVar = k.f10300a;
                                eVar.c();
                                String strO4 = null;
                                String strO5 = null;
                                String strO6 = null;
                                while (eVar.i()) {
                                    int iW2 = eVar.w(k.f10300a);
                                    if (iW2 != 0) {
                                        ArrayList arrayList5 = arrayList3;
                                        if (iW2 == 1) {
                                            strO5 = eVar.o();
                                        } else if (iW2 == 2) {
                                            strO6 = eVar.o();
                                        } else if (iW2 != 3) {
                                            eVar.A();
                                            eVar.B();
                                        } else {
                                            eVar.l();
                                        }
                                        arrayList3 = arrayList5;
                                    } else {
                                        strO4 = eVar.o();
                                    }
                                }
                                eVar.h();
                                map3.put(strO5, new p1.d(strO4, strO5, strO6));
                                arrayList3 = arrayList3;
                            }
                            eVar.g();
                        }
                    }
                    arrayList = arrayList3;
                    eVar.h();
                    i8 = i17;
                    f = fC;
                    fC = f;
                    fL2 = f10;
                    arrayList3 = arrayList;
                    fL = f4;
                    iM2 = i8;
                    break;
                case 9:
                    f4 = fL;
                    i10 = iM2;
                    f10 = fL2;
                    eVar.a();
                    while (eVar.i()) {
                        f5.a aVar2 = j.f10298a;
                        ArrayList arrayList6 = new ArrayList();
                        eVar.c();
                        double dL = 0.0d;
                        String strO7 = null;
                        String strO8 = null;
                        char cCharAt = 0;
                        while (eVar.i()) {
                            int iW3 = eVar.w(j.f10298a);
                            if (iW3 == 0) {
                                cCharAt = eVar.o().charAt(0);
                            } else if (iW3 == 1) {
                                eVar.l();
                            } else if (iW3 == 2) {
                                dL = eVar.l();
                            } else if (iW3 == 3) {
                                strO7 = eVar.o();
                            } else if (iW3 == 4) {
                                strO8 = eVar.o();
                            } else if (iW3 != 5) {
                                eVar.A();
                                eVar.B();
                            } else {
                                eVar.c();
                                while (eVar.i()) {
                                    if (eVar.w(j.f10299b) != 0) {
                                        eVar.A();
                                        eVar.B();
                                    } else {
                                        eVar.a();
                                        while (eVar.i()) {
                                            arrayList6.add((r1.s) g.a(eVar, jVar));
                                        }
                                        eVar.g();
                                    }
                                }
                                eVar.h();
                            }
                        }
                        eVar.h();
                        p1.e eVar2 = new p1.e(arrayList6, cCharAt, dL, strO7, strO8);
                        sparseArrayCompat.put(eVar2.hashCode(), eVar2);
                    }
                    eVar.g();
                    i8 = i10;
                    f = fC;
                    arrayList = arrayList3;
                    fC = f;
                    fL2 = f10;
                    arrayList3 = arrayList;
                    fL = f4;
                    iM2 = i8;
                    break;
                case 10:
                    eVar.a();
                    while (eVar.i()) {
                        eVar.c();
                        String strO9 = null;
                        float fL4 = 0.0f;
                        float fL5 = 0.0f;
                        while (eVar.i()) {
                            int iW4 = eVar.w(f10319d);
                            if (iW4 != 0) {
                                f12 = fL;
                                if (iW4 == 1) {
                                    fL2 = fL2;
                                    fL4 = (float) eVar.l();
                                } else if (iW4 != 2) {
                                    eVar.A();
                                    eVar.B();
                                } else {
                                    fL2 = fL2;
                                    fL5 = (float) eVar.l();
                                }
                                fL = f12;
                                iM2 = iM2;
                            } else {
                                f12 = fL;
                                strO9 = eVar.o();
                            }
                            fL = f12;
                        }
                        eVar.h();
                        arrayList3.add(new p1.i(strO9, fL4, fL5));
                        iM2 = iM2;
                        fL2 = fL2;
                        fL = fL;
                    }
                    f4 = fL;
                    i10 = iM2;
                    f10 = fL2;
                    eVar.g();
                    i8 = i10;
                    f = fC;
                    arrayList = arrayList3;
                    fC = f;
                    fL2 = f10;
                    arrayList3 = arrayList;
                    fL = f4;
                    iM2 = i8;
                    break;
                default:
                    eVar.A();
                    eVar.B();
                    f = fC;
                    arrayList = arrayList3;
                    f4 = fL;
                    i8 = iM2;
                    f10 = fL2;
                    fC = f;
                    fL2 = f10;
                    arrayList3 = arrayList;
                    fL = f4;
                    iM2 = i8;
                    break;
            }
        }
        float f14 = fC;
        Rect rect = new Rect(0, 0, (int) (iM * f14), (int) (iM2 * f14));
        float fC2 = w1.g.c();
        jVar.f5972k = rect;
        jVar.f5973l = fL2;
        jVar.f5974m = fL;
        jVar.f5975n = fL3;
        jVar.f5971j = arrayList2;
        jVar.f5970i = longSparseArray;
        jVar.f5966c = map;
        jVar.f5967d = map2;
        jVar.e = fC2;
        jVar.f5969h = sparseArrayCompat;
        jVar.f = map3;
        jVar.f5968g = arrayList3;
        return jVar;
    }
}
