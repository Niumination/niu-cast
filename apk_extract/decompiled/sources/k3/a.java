package k3;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode.zzi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzux;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuy;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzva;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzve;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvh;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwc;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6346a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f6346a) {
            case 0:
                int iS = pd.s(parcel);
                String strF = null;
                String strF2 = null;
                int iN = 0;
                String strF3 = null;
                while (parcel.dataPosition() < iS) {
                    int i8 = parcel.readInt();
                    char c9 = (char) i8;
                    if (c9 == 2) {
                        iN = pd.n(parcel, i8);
                    } else if (c9 == 3) {
                        strF = pd.f(parcel, i8);
                    } else if (c9 == 4) {
                        strF3 = pd.f(parcel, i8);
                    } else if (c9 != 5) {
                        pd.r(parcel, i8);
                    } else {
                        strF2 = pd.f(parcel, i8);
                    }
                }
                pd.j(parcel, iS);
                zzn zznVar = new zzn();
                zznVar.f2025a = iN;
                zznVar.f2026b = strF;
                zznVar.f2027c = strF3;
                zznVar.f2028d = strF2;
                return zznVar;
            case 1:
                int iS2 = pd.s(parcel);
                double dL = 0.0d;
                double dL2 = 0.0d;
                while (parcel.dataPosition() < iS2) {
                    int i9 = parcel.readInt();
                    char c10 = (char) i9;
                    if (c10 == 2) {
                        dL = pd.l(parcel, i9);
                    } else if (c10 != 3) {
                        pd.r(parcel, i9);
                    } else {
                        dL2 = pd.l(parcel, i9);
                    }
                }
                pd.j(parcel, iS2);
                zzo zzoVar = new zzo();
                zzoVar.f2029a = dL;
                zzoVar.f2030b = dL2;
                return zzoVar;
            case 2:
                int iS3 = pd.s(parcel);
                String strF4 = null;
                String strF5 = null;
                String strF6 = null;
                String strF7 = null;
                String strF8 = null;
                String strF9 = null;
                String strF10 = null;
                while (parcel.dataPosition() < iS3) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 2:
                            strF4 = pd.f(parcel, i10);
                            break;
                        case 3:
                            strF5 = pd.f(parcel, i10);
                            break;
                        case 4:
                            strF6 = pd.f(parcel, i10);
                            break;
                        case 5:
                            strF7 = pd.f(parcel, i10);
                            break;
                        case 6:
                            strF8 = pd.f(parcel, i10);
                            break;
                        case 7:
                            strF9 = pd.f(parcel, i10);
                            break;
                        case '\b':
                            strF10 = pd.f(parcel, i10);
                            break;
                        default:
                            pd.r(parcel, i10);
                            break;
                    }
                }
                pd.j(parcel, iS3);
                zzp zzpVar = new zzp();
                zzpVar.f2031a = strF4;
                zzpVar.f2032b = strF5;
                zzpVar.f2033c = strF6;
                zzpVar.f2034d = strF7;
                zzpVar.e = strF8;
                zzpVar.f2035h = strF9;
                zzpVar.f2036i = strF10;
                return zzpVar;
            case 3:
                int iS4 = pd.s(parcel);
                String strF11 = null;
                int iN2 = 0;
                while (parcel.dataPosition() < iS4) {
                    int i11 = parcel.readInt();
                    char c11 = (char) i11;
                    if (c11 == 2) {
                        iN2 = pd.n(parcel, i11);
                    } else if (c11 != 3) {
                        pd.r(parcel, i11);
                    } else {
                        strF11 = pd.f(parcel, i11);
                    }
                }
                pd.j(parcel, iS4);
                zzq zzqVar = new zzq();
                zzqVar.f2037a = iN2;
                zzqVar.f2038b = strF11;
                return zzqVar;
            case 4:
                int iS5 = pd.s(parcel);
                String strF12 = null;
                String strF13 = null;
                while (parcel.dataPosition() < iS5) {
                    int i12 = parcel.readInt();
                    char c12 = (char) i12;
                    if (c12 == 2) {
                        strF12 = pd.f(parcel, i12);
                    } else if (c12 != 3) {
                        pd.r(parcel, i12);
                    } else {
                        strF13 = pd.f(parcel, i12);
                    }
                }
                pd.j(parcel, iS5);
                zzr zzrVar = new zzr();
                zzrVar.f2039a = strF12;
                zzrVar.f2040b = strF13;
                return zzrVar;
            case 5:
                int iS6 = pd.s(parcel);
                String strF14 = null;
                String strF15 = null;
                while (parcel.dataPosition() < iS6) {
                    int i13 = parcel.readInt();
                    char c13 = (char) i13;
                    if (c13 == 2) {
                        strF14 = pd.f(parcel, i13);
                    } else if (c13 != 3) {
                        pd.r(parcel, i13);
                    } else {
                        strF15 = pd.f(parcel, i13);
                    }
                }
                pd.j(parcel, iS6);
                zzs zzsVar = new zzs();
                zzsVar.f2041a = strF14;
                zzsVar.f2042b = strF15;
                return zzsVar;
            case 6:
                int iS7 = pd.s(parcel);
                int iN3 = 0;
                String strF16 = null;
                String strF17 = null;
                while (parcel.dataPosition() < iS7) {
                    int i14 = parcel.readInt();
                    char c14 = (char) i14;
                    if (c14 == 2) {
                        strF16 = pd.f(parcel, i14);
                    } else if (c14 == 3) {
                        strF17 = pd.f(parcel, i14);
                    } else if (c14 != 4) {
                        pd.r(parcel, i14);
                    } else {
                        iN3 = pd.n(parcel, i14);
                    }
                }
                pd.j(parcel, iS7);
                zzt zztVar = new zzt();
                zztVar.f2043a = strF16;
                zztVar.f2044b = strF17;
                zztVar.f2045c = iN3;
                return zztVar;
            case 7:
                int iS8 = pd.s(parcel);
                int iN4 = 0;
                boolean zK = false;
                while (parcel.dataPosition() < iS8) {
                    int i15 = parcel.readInt();
                    char c15 = (char) i15;
                    if (c15 == 2) {
                        iN4 = pd.n(parcel, i15);
                    } else if (c15 != 3) {
                        pd.r(parcel, i15);
                    } else {
                        zK = pd.k(parcel, i15);
                    }
                }
                pd.j(parcel, iS8);
                zzah zzahVar = new zzah();
                zzahVar.f1986a = iN4;
                zzahVar.f1987b = zK;
                return zzahVar;
            case 8:
                int iS9 = pd.s(parcel);
                int iN5 = 0;
                int iN6 = 0;
                int iN7 = 0;
                int iN8 = 0;
                long jO = 0;
                while (parcel.dataPosition() < iS9) {
                    int i16 = parcel.readInt();
                    char c16 = (char) i16;
                    if (c16 == 2) {
                        iN5 = pd.n(parcel, i16);
                    } else if (c16 == 3) {
                        iN6 = pd.n(parcel, i16);
                    } else if (c16 == 4) {
                        iN7 = pd.n(parcel, i16);
                    } else if (c16 == 5) {
                        jO = pd.o(parcel, i16);
                    } else if (c16 != 6) {
                        pd.r(parcel, i16);
                    } else {
                        iN8 = pd.n(parcel, i16);
                    }
                }
                pd.j(parcel, iS9);
                return new zzan(iN5, iN6, iN7, iN8, jO);
            case 9:
                int iS10 = pd.s(parcel);
                String[] strArrG = null;
                int iN9 = 0;
                while (parcel.dataPosition() < iS10) {
                    int i17 = parcel.readInt();
                    char c17 = (char) i17;
                    if (c17 == 2) {
                        iN9 = pd.n(parcel, i17);
                    } else if (c17 != 3) {
                        pd.r(parcel, i17);
                    } else {
                        strArrG = pd.g(parcel, i17);
                    }
                }
                pd.j(parcel, iS10);
                zzi zziVar = new zzi();
                zziVar.f1992a = iN9;
                zziVar.f1993b = strArrG;
                return zziVar;
            case 10:
                int iS11 = pd.s(parcel);
                String[] strArrG2 = null;
                int iN10 = 0;
                while (parcel.dataPosition() < iS11) {
                    int i18 = parcel.readInt();
                    char c18 = (char) i18;
                    if (c18 == 1) {
                        iN10 = pd.n(parcel, i18);
                    } else if (c18 != 2) {
                        pd.r(parcel, i18);
                    } else {
                        strArrG2 = pd.g(parcel, i18);
                    }
                }
                pd.j(parcel, iS11);
                return new zzux(iN10, strArrG2);
            case 11:
                int iS12 = pd.s(parcel);
                double dL3 = 0.0d;
                int iN11 = 0;
                boolean zK2 = false;
                String strF18 = null;
                String strF19 = null;
                Point[] pointArr = null;
                zzn zznVar2 = null;
                zzq zzqVar2 = null;
                zzr zzrVar2 = null;
                zzt zztVar2 = null;
                byte[] bArrC = null;
                zzo zzoVar2 = null;
                zzs zzsVar2 = null;
                zzk zzkVar = null;
                zzl zzlVar = null;
                zzm zzmVar = null;
                int iN12 = 0;
                while (parcel.dataPosition() < iS12) {
                    int i19 = parcel.readInt();
                    zzt zztVar3 = zztVar2;
                    switch ((char) i19) {
                        case 2:
                            iN11 = pd.n(parcel, i19);
                            break;
                        case 3:
                            strF18 = pd.f(parcel, i19);
                            break;
                        case 4:
                            strF19 = pd.f(parcel, i19);
                            break;
                        case 5:
                            iN12 = pd.n(parcel, i19);
                            break;
                        case 6:
                            pointArr = (Point[]) pd.h(parcel, i19, Point.CREATOR);
                            break;
                        case 7:
                            zznVar2 = (zzn) pd.e(parcel, i19, zzn.CREATOR);
                            break;
                        case '\b':
                            zzqVar2 = (zzq) pd.e(parcel, i19, zzq.CREATOR);
                            break;
                        case '\t':
                            zzrVar2 = (zzr) pd.e(parcel, i19, zzr.CREATOR);
                            break;
                        case '\n':
                            zztVar2 = (zzt) pd.e(parcel, i19, zzt.CREATOR);
                            continue;
                        case 11:
                            zzsVar2 = (zzs) pd.e(parcel, i19, zzs.CREATOR);
                            break;
                        case '\f':
                            zzoVar2 = (zzo) pd.e(parcel, i19, zzo.CREATOR);
                            break;
                        case '\r':
                            zzkVar = (zzk) pd.e(parcel, i19, zzk.CREATOR);
                            break;
                        case 14:
                            zzlVar = (zzl) pd.e(parcel, i19, zzl.CREATOR);
                            break;
                        case 15:
                            zzmVar = (zzm) pd.e(parcel, i19, zzm.CREATOR);
                            break;
                        case 16:
                            bArrC = pd.c(parcel, i19);
                            break;
                        case 17:
                            zK2 = pd.k(parcel, i19);
                            break;
                        case 18:
                            dL3 = pd.l(parcel, i19);
                            break;
                        default:
                            pd.r(parcel, i19);
                            break;
                    }
                    zztVar2 = zztVar3;
                }
                pd.j(parcel, iS12);
                zzu zzuVar = new zzu();
                zzuVar.f2046a = iN11;
                zzuVar.f2047b = strF18;
                zzuVar.q = bArrC;
                zzuVar.f2048c = strF19;
                zzuVar.f2049d = iN12;
                zzuVar.e = pointArr;
                zzuVar.f2058r = zK2;
                zzuVar.f2059s = dL3;
                zzuVar.f2050h = zznVar2;
                zzuVar.f2051i = zzqVar2;
                zzuVar.f2052j = zzrVar2;
                zzuVar.f2053k = zztVar2;
                zzuVar.f2054l = zzsVar2;
                zzuVar.f2055m = zzoVar2;
                zzuVar.f2056n = zzkVar;
                zzuVar.f2057o = zzlVar;
                zzuVar.p = zzmVar;
                return zzuVar;
            case 12:
                int iS13 = pd.s(parcel);
                String strF20 = null;
                String strF21 = null;
                byte[] bArrC2 = null;
                Point[] pointArr2 = null;
                zzvc zzvcVar = null;
                zzvf zzvfVar = null;
                zzvg zzvgVar = null;
                zzvi zzviVar = null;
                zzvh zzvhVar = null;
                zzvd zzvdVar = null;
                zzuz zzuzVar = null;
                zzva zzvaVar = null;
                zzvb zzvbVar = null;
                int iN13 = 0;
                int iN14 = 0;
                while (parcel.dataPosition() < iS13) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            iN13 = pd.n(parcel, i20);
                            break;
                        case 2:
                            strF20 = pd.f(parcel, i20);
                            break;
                        case 3:
                            strF21 = pd.f(parcel, i20);
                            break;
                        case 4:
                            bArrC2 = pd.c(parcel, i20);
                            break;
                        case 5:
                            pointArr2 = (Point[]) pd.h(parcel, i20, Point.CREATOR);
                            break;
                        case 6:
                            iN14 = pd.n(parcel, i20);
                            break;
                        case 7:
                            zzvcVar = (zzvc) pd.e(parcel, i20, zzvc.CREATOR);
                            break;
                        case '\b':
                            zzvfVar = (zzvf) pd.e(parcel, i20, zzvf.CREATOR);
                            break;
                        case '\t':
                            zzvgVar = (zzvg) pd.e(parcel, i20, zzvg.CREATOR);
                            break;
                        case '\n':
                            zzviVar = (zzvi) pd.e(parcel, i20, zzvi.CREATOR);
                            break;
                        case 11:
                            zzvhVar = (zzvh) pd.e(parcel, i20, zzvh.CREATOR);
                            break;
                        case '\f':
                            zzvdVar = (zzvd) pd.e(parcel, i20, zzvd.CREATOR);
                            break;
                        case '\r':
                            zzuzVar = (zzuz) pd.e(parcel, i20, zzuz.CREATOR);
                            break;
                        case 14:
                            zzvaVar = (zzva) pd.e(parcel, i20, zzva.CREATOR);
                            break;
                        case 15:
                            zzvbVar = (zzvb) pd.e(parcel, i20, zzvb.CREATOR);
                            break;
                        default:
                            pd.r(parcel, i20);
                            break;
                    }
                }
                pd.j(parcel, iS13);
                return new zzvj(iN13, strF20, strF21, bArrC2, pointArr2, iN14, zzvcVar, zzvfVar, zzvgVar, zzviVar, zzvhVar, zzvdVar, zzuzVar, zzvaVar, zzvbVar);
            case 13:
                int iS14 = pd.s(parcel);
                int iN15 = 0;
                boolean zK3 = false;
                while (parcel.dataPosition() < iS14) {
                    int i21 = parcel.readInt();
                    char c19 = (char) i21;
                    if (c19 == 1) {
                        iN15 = pd.n(parcel, i21);
                    } else if (c19 != 2) {
                        pd.r(parcel, i21);
                    } else {
                        zK3 = pd.k(parcel, i21);
                    }
                }
                pd.j(parcel, iS14);
                return new zzvl(iN15, zK3);
            case 14:
                int iS15 = pd.s(parcel);
                String strF22 = null;
                int iN16 = 0;
                int iN17 = 0;
                int iN18 = 0;
                int iN19 = 0;
                int iN20 = 0;
                int iN21 = 0;
                boolean zK4 = false;
                while (parcel.dataPosition() < iS15) {
                    int i22 = parcel.readInt();
                    switch ((char) i22) {
                        case 1:
                            iN16 = pd.n(parcel, i22);
                            break;
                        case 2:
                            iN17 = pd.n(parcel, i22);
                            break;
                        case 3:
                            iN18 = pd.n(parcel, i22);
                            break;
                        case 4:
                            iN19 = pd.n(parcel, i22);
                            break;
                        case 5:
                            iN20 = pd.n(parcel, i22);
                            break;
                        case 6:
                            iN21 = pd.n(parcel, i22);
                            break;
                        case 7:
                            zK4 = pd.k(parcel, i22);
                            break;
                        case '\b':
                            strF22 = pd.f(parcel, i22);
                            break;
                        default:
                            pd.r(parcel, i22);
                            break;
                    }
                }
                pd.j(parcel, iS15);
                return new zzuy(iN16, iN17, iN18, iN19, iN20, iN21, zK4, strF22);
            case 15:
                int iS16 = pd.s(parcel);
                String strF23 = null;
                String strF24 = null;
                String strF25 = null;
                String strF26 = null;
                String strF27 = null;
                zzuy zzuyVar = null;
                zzuy zzuyVar2 = null;
                while (parcel.dataPosition() < iS16) {
                    int i23 = parcel.readInt();
                    switch ((char) i23) {
                        case 1:
                            strF23 = pd.f(parcel, i23);
                            break;
                        case 2:
                            strF24 = pd.f(parcel, i23);
                            break;
                        case 3:
                            strF25 = pd.f(parcel, i23);
                            break;
                        case 4:
                            strF26 = pd.f(parcel, i23);
                            break;
                        case 5:
                            strF27 = pd.f(parcel, i23);
                            break;
                        case 6:
                            zzuyVar = (zzuy) pd.e(parcel, i23, zzuy.CREATOR);
                            break;
                        case 7:
                            zzuyVar2 = (zzuy) pd.e(parcel, i23, zzuy.CREATOR);
                            break;
                        default:
                            pd.r(parcel, i23);
                            break;
                    }
                }
                pd.j(parcel, iS16);
                return new zzuz(strF23, strF24, strF25, strF26, strF27, zzuyVar, zzuyVar2);
            case 16:
                int iS17 = pd.s(parcel);
                zzve zzveVar = null;
                String strF28 = null;
                String strF29 = null;
                zzvf[] zzvfVarArr = null;
                zzvc[] zzvcVarArr = null;
                String[] strArrG3 = null;
                zzux[] zzuxVarArr = null;
                while (parcel.dataPosition() < iS17) {
                    int i24 = parcel.readInt();
                    switch ((char) i24) {
                        case 1:
                            zzveVar = (zzve) pd.e(parcel, i24, zzve.CREATOR);
                            break;
                        case 2:
                            strF28 = pd.f(parcel, i24);
                            break;
                        case 3:
                            strF29 = pd.f(parcel, i24);
                            break;
                        case 4:
                            zzvfVarArr = (zzvf[]) pd.h(parcel, i24, zzvf.CREATOR);
                            break;
                        case 5:
                            zzvcVarArr = (zzvc[]) pd.h(parcel, i24, zzvc.CREATOR);
                            break;
                        case 6:
                            strArrG3 = pd.g(parcel, i24);
                            break;
                        case 7:
                            zzuxVarArr = (zzux[]) pd.h(parcel, i24, zzux.CREATOR);
                            break;
                        default:
                            pd.r(parcel, i24);
                            break;
                    }
                }
                pd.j(parcel, iS17);
                return new zzva(zzveVar, strF28, strF29, zzvfVarArr, zzvcVarArr, strArrG3, zzuxVarArr);
            case 17:
                int iS18 = pd.s(parcel);
                String strF30 = null;
                String strF31 = null;
                String strF32 = null;
                String strF33 = null;
                String strF34 = null;
                String strF35 = null;
                String strF36 = null;
                String strF37 = null;
                String strF38 = null;
                String strF39 = null;
                String strF40 = null;
                String strF41 = null;
                String strF42 = null;
                String strF43 = null;
                while (parcel.dataPosition() < iS18) {
                    int i25 = parcel.readInt();
                    switch ((char) i25) {
                        case 1:
                            strF30 = pd.f(parcel, i25);
                            break;
                        case 2:
                            strF31 = pd.f(parcel, i25);
                            break;
                        case 3:
                            strF32 = pd.f(parcel, i25);
                            break;
                        case 4:
                            strF33 = pd.f(parcel, i25);
                            break;
                        case 5:
                            strF34 = pd.f(parcel, i25);
                            break;
                        case 6:
                            strF35 = pd.f(parcel, i25);
                            break;
                        case 7:
                            strF36 = pd.f(parcel, i25);
                            break;
                        case '\b':
                            strF37 = pd.f(parcel, i25);
                            break;
                        case '\t':
                            strF38 = pd.f(parcel, i25);
                            break;
                        case '\n':
                            strF39 = pd.f(parcel, i25);
                            break;
                        case 11:
                            strF40 = pd.f(parcel, i25);
                            break;
                        case '\f':
                            strF41 = pd.f(parcel, i25);
                            break;
                        case '\r':
                            strF42 = pd.f(parcel, i25);
                            break;
                        case 14:
                            strF43 = pd.f(parcel, i25);
                            break;
                        default:
                            pd.r(parcel, i25);
                            break;
                    }
                }
                pd.j(parcel, iS18);
                return new zzvb(strF30, strF31, strF32, strF33, strF34, strF35, strF36, strF37, strF38, strF39, strF40, strF41, strF42, strF43);
            case 18:
                int iS19 = pd.s(parcel);
                String strF44 = null;
                String strF45 = null;
                int iN22 = 0;
                String strF46 = null;
                while (parcel.dataPosition() < iS19) {
                    int i26 = parcel.readInt();
                    char c20 = (char) i26;
                    if (c20 == 1) {
                        iN22 = pd.n(parcel, i26);
                    } else if (c20 == 2) {
                        strF44 = pd.f(parcel, i26);
                    } else if (c20 == 3) {
                        strF46 = pd.f(parcel, i26);
                    } else if (c20 != 4) {
                        pd.r(parcel, i26);
                    } else {
                        strF45 = pd.f(parcel, i26);
                    }
                }
                pd.j(parcel, iS19);
                return new zzvc(iN22, strF44, strF46, strF45);
            case 19:
                int iS20 = pd.s(parcel);
                double dL4 = 0.0d;
                double dL5 = 0.0d;
                while (parcel.dataPosition() < iS20) {
                    int i27 = parcel.readInt();
                    char c21 = (char) i27;
                    if (c21 == 1) {
                        dL4 = pd.l(parcel, i27);
                    } else if (c21 != 2) {
                        pd.r(parcel, i27);
                    } else {
                        dL5 = pd.l(parcel, i27);
                    }
                }
                pd.j(parcel, iS20);
                return new zzvd(dL4, dL5);
            case 20:
                int iS21 = pd.s(parcel);
                String strF47 = null;
                String strF48 = null;
                String strF49 = null;
                String strF50 = null;
                String strF51 = null;
                String strF52 = null;
                String strF53 = null;
                while (parcel.dataPosition() < iS21) {
                    int i28 = parcel.readInt();
                    switch ((char) i28) {
                        case 1:
                            strF47 = pd.f(parcel, i28);
                            break;
                        case 2:
                            strF48 = pd.f(parcel, i28);
                            break;
                        case 3:
                            strF49 = pd.f(parcel, i28);
                            break;
                        case 4:
                            strF50 = pd.f(parcel, i28);
                            break;
                        case 5:
                            strF51 = pd.f(parcel, i28);
                            break;
                        case 6:
                            strF52 = pd.f(parcel, i28);
                            break;
                        case 7:
                            strF53 = pd.f(parcel, i28);
                            break;
                        default:
                            pd.r(parcel, i28);
                            break;
                    }
                }
                pd.j(parcel, iS21);
                return new zzve(strF47, strF48, strF49, strF50, strF51, strF52, strF53);
            case 21:
                int iS22 = pd.s(parcel);
                String strF54 = null;
                int iN23 = 0;
                while (parcel.dataPosition() < iS22) {
                    int i29 = parcel.readInt();
                    char c22 = (char) i29;
                    if (c22 == 1) {
                        iN23 = pd.n(parcel, i29);
                    } else if (c22 != 2) {
                        pd.r(parcel, i29);
                    } else {
                        strF54 = pd.f(parcel, i29);
                    }
                }
                pd.j(parcel, iS22);
                return new zzvf(iN23, strF54);
            case 22:
                int iS23 = pd.s(parcel);
                String strF55 = null;
                String strF56 = null;
                while (parcel.dataPosition() < iS23) {
                    int i30 = parcel.readInt();
                    char c23 = (char) i30;
                    if (c23 == 1) {
                        strF55 = pd.f(parcel, i30);
                    } else if (c23 != 2) {
                        pd.r(parcel, i30);
                    } else {
                        strF56 = pd.f(parcel, i30);
                    }
                }
                pd.j(parcel, iS23);
                return new zzvg(strF55, strF56);
            case 23:
                int iS24 = pd.s(parcel);
                String strF57 = null;
                int iN24 = 0;
                int iN25 = 0;
                int iN26 = 0;
                int iN27 = 0;
                int iN28 = 0;
                int iN29 = 0;
                boolean zK5 = false;
                while (parcel.dataPosition() < iS24) {
                    int i31 = parcel.readInt();
                    switch ((char) i31) {
                        case 2:
                            iN24 = pd.n(parcel, i31);
                            break;
                        case 3:
                            iN25 = pd.n(parcel, i31);
                            break;
                        case 4:
                            iN26 = pd.n(parcel, i31);
                            break;
                        case 5:
                            iN27 = pd.n(parcel, i31);
                            break;
                        case 6:
                            iN28 = pd.n(parcel, i31);
                            break;
                        case 7:
                            iN29 = pd.n(parcel, i31);
                            break;
                        case '\b':
                            zK5 = pd.k(parcel, i31);
                            break;
                        case '\t':
                            strF57 = pd.f(parcel, i31);
                            break;
                        default:
                            pd.r(parcel, i31);
                            break;
                    }
                }
                pd.j(parcel, iS24);
                zzj zzjVar = new zzj();
                zzjVar.f1994a = iN24;
                zzjVar.f1995b = iN25;
                zzjVar.f1996c = iN26;
                zzjVar.f1997d = iN27;
                zzjVar.e = iN28;
                zzjVar.f1998h = iN29;
                zzjVar.f1999i = zK5;
                zzjVar.f2000j = strF57;
                return zzjVar;
            case 24:
                int iS25 = pd.s(parcel);
                String strF58 = null;
                String strF59 = null;
                while (parcel.dataPosition() < iS25) {
                    int i32 = parcel.readInt();
                    char c24 = (char) i32;
                    if (c24 == 1) {
                        strF58 = pd.f(parcel, i32);
                    } else if (c24 != 2) {
                        pd.r(parcel, i32);
                    } else {
                        strF59 = pd.f(parcel, i32);
                    }
                }
                pd.j(parcel, iS25);
                return new zzvh(strF58, strF59);
            case 25:
                int iS26 = pd.s(parcel);
                int iN30 = 0;
                String strF60 = null;
                String strF61 = null;
                while (parcel.dataPosition() < iS26) {
                    int i33 = parcel.readInt();
                    char c25 = (char) i33;
                    if (c25 == 1) {
                        strF60 = pd.f(parcel, i33);
                    } else if (c25 == 2) {
                        strF61 = pd.f(parcel, i33);
                    } else if (c25 != 3) {
                        pd.r(parcel, i33);
                    } else {
                        iN30 = pd.n(parcel, i33);
                    }
                }
                pd.j(parcel, iS26);
                return new zzvi(strF60, strF61, iN30);
            case 26:
                int iS27 = pd.s(parcel);
                long jO2 = 0;
                int iN31 = 0;
                int iN32 = 0;
                int iN33 = 0;
                int iN34 = 0;
                while (parcel.dataPosition() < iS27) {
                    int i34 = parcel.readInt();
                    char c26 = (char) i34;
                    if (c26 == 1) {
                        iN31 = pd.n(parcel, i34);
                    } else if (c26 == 2) {
                        iN32 = pd.n(parcel, i34);
                    } else if (c26 == 3) {
                        iN33 = pd.n(parcel, i34);
                    } else if (c26 == 4) {
                        iN34 = pd.n(parcel, i34);
                    } else if (c26 != 5) {
                        pd.r(parcel, i34);
                    } else {
                        jO2 = pd.o(parcel, i34);
                    }
                }
                pd.j(parcel, iS27);
                return new zzwc(iN31, iN32, iN33, iN34, jO2);
            case 27:
                int iS28 = pd.s(parcel);
                String strF62 = null;
                String strF63 = null;
                String strF64 = null;
                String strF65 = null;
                String strF66 = null;
                zzj zzjVar2 = null;
                zzj zzjVar3 = null;
                while (parcel.dataPosition() < iS28) {
                    int i35 = parcel.readInt();
                    switch ((char) i35) {
                        case 2:
                            strF62 = pd.f(parcel, i35);
                            break;
                        case 3:
                            strF63 = pd.f(parcel, i35);
                            break;
                        case 4:
                            strF64 = pd.f(parcel, i35);
                            break;
                        case 5:
                            strF65 = pd.f(parcel, i35);
                            break;
                        case 6:
                            strF66 = pd.f(parcel, i35);
                            break;
                        case 7:
                            zzjVar2 = (zzj) pd.e(parcel, i35, zzj.CREATOR);
                            break;
                        case '\b':
                            zzjVar3 = (zzj) pd.e(parcel, i35, zzj.CREATOR);
                            break;
                        default:
                            pd.r(parcel, i35);
                            break;
                    }
                }
                pd.j(parcel, iS28);
                zzk zzkVar2 = new zzk();
                zzkVar2.f2001a = strF62;
                zzkVar2.f2002b = strF63;
                zzkVar2.f2003c = strF64;
                zzkVar2.f2004d = strF65;
                zzkVar2.e = strF66;
                zzkVar2.f2005h = zzjVar2;
                zzkVar2.f2006i = zzjVar3;
                return zzkVar2;
            case 28:
                int iS29 = pd.s(parcel);
                zzp zzpVar2 = null;
                String strF67 = null;
                String strF68 = null;
                zzq[] zzqVarArr = null;
                zzn[] zznVarArr = null;
                String[] strArrG4 = null;
                zzi[] zziVarArr = null;
                while (parcel.dataPosition() < iS29) {
                    int i36 = parcel.readInt();
                    switch ((char) i36) {
                        case 2:
                            zzpVar2 = (zzp) pd.e(parcel, i36, zzp.CREATOR);
                            break;
                        case 3:
                            strF67 = pd.f(parcel, i36);
                            break;
                        case 4:
                            strF68 = pd.f(parcel, i36);
                            break;
                        case 5:
                            zzqVarArr = (zzq[]) pd.h(parcel, i36, zzq.CREATOR);
                            break;
                        case 6:
                            zznVarArr = (zzn[]) pd.h(parcel, i36, zzn.CREATOR);
                            break;
                        case 7:
                            strArrG4 = pd.g(parcel, i36);
                            break;
                        case '\b':
                            zziVarArr = (zzi[]) pd.h(parcel, i36, zzi.CREATOR);
                            break;
                        default:
                            pd.r(parcel, i36);
                            break;
                    }
                }
                pd.j(parcel, iS29);
                zzl zzlVar2 = new zzl();
                zzlVar2.f2007a = zzpVar2;
                zzlVar2.f2008b = strF67;
                zzlVar2.f2009c = strF68;
                zzlVar2.f2010d = zzqVarArr;
                zzlVar2.e = zznVarArr;
                zzlVar2.f2011h = strArrG4;
                zzlVar2.f2012i = zziVarArr;
                return zzlVar2;
            default:
                int iS30 = pd.s(parcel);
                String strF69 = null;
                String strF70 = null;
                String strF71 = null;
                String strF72 = null;
                String strF73 = null;
                String strF74 = null;
                String strF75 = null;
                String strF76 = null;
                String strF77 = null;
                String strF78 = null;
                String strF79 = null;
                String strF80 = null;
                String strF81 = null;
                String strF82 = null;
                while (parcel.dataPosition() < iS30) {
                    int i37 = parcel.readInt();
                    String str = strF82;
                    switch ((char) i37) {
                        case 2:
                            strF69 = pd.f(parcel, i37);
                            break;
                        case 3:
                            strF71 = pd.f(parcel, i37);
                            break;
                        case 4:
                            strF72 = pd.f(parcel, i37);
                            break;
                        case 5:
                            strF73 = pd.f(parcel, i37);
                            break;
                        case 6:
                            strF74 = pd.f(parcel, i37);
                            break;
                        case 7:
                            strF75 = pd.f(parcel, i37);
                            break;
                        case '\b':
                            strF76 = pd.f(parcel, i37);
                            break;
                        case '\t':
                            strF77 = pd.f(parcel, i37);
                            break;
                        case '\n':
                            strF78 = pd.f(parcel, i37);
                            break;
                        case 11:
                            strF79 = pd.f(parcel, i37);
                            break;
                        case '\f':
                            strF80 = pd.f(parcel, i37);
                            break;
                        case '\r':
                            strF81 = pd.f(parcel, i37);
                            break;
                        case 14:
                            strF82 = pd.f(parcel, i37);
                            continue;
                        case 15:
                            strF70 = pd.f(parcel, i37);
                            break;
                        default:
                            pd.r(parcel, i37);
                            break;
                    }
                    strF82 = str;
                }
                pd.j(parcel, iS30);
                zzm zzmVar2 = new zzm();
                zzmVar2.f2013a = strF69;
                zzmVar2.f2014b = strF71;
                zzmVar2.f2015c = strF72;
                zzmVar2.f2016d = strF73;
                zzmVar2.e = strF74;
                zzmVar2.f2017h = strF75;
                zzmVar2.f2018i = strF76;
                zzmVar2.f2019j = strF77;
                zzmVar2.f2020k = strF78;
                zzmVar2.f2021l = strF79;
                zzmVar2.f2022m = strF80;
                zzmVar2.f2023n = strF81;
                zzmVar2.f2024o = strF82;
                zzmVar2.p = strF70;
                return zzmVar2;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        switch (this.f6346a) {
            case 0:
                return new zzn[i8];
            case 1:
                return new zzo[i8];
            case 2:
                return new zzp[i8];
            case 3:
                return new zzq[i8];
            case 4:
                return new zzr[i8];
            case 5:
                return new zzs[i8];
            case 6:
                return new zzt[i8];
            case 7:
                return new zzah[i8];
            case 8:
                return new zzan[i8];
            case 9:
                return new zzi[i8];
            case 10:
                return new zzux[i8];
            case 11:
                return new zzu[i8];
            case 12:
                return new zzvj[i8];
            case 13:
                return new zzvl[i8];
            case 14:
                return new zzuy[i8];
            case 15:
                return new zzuz[i8];
            case 16:
                return new zzva[i8];
            case 17:
                return new zzvb[i8];
            case 18:
                return new zzvc[i8];
            case 19:
                return new zzvd[i8];
            case 20:
                return new zzve[i8];
            case 21:
                return new zzvf[i8];
            case 22:
                return new zzvg[i8];
            case 23:
                return new zzj[i8];
            case 24:
                return new zzvh[i8];
            case 25:
                return new zzvi[i8];
            case 26:
                return new zzwc[i8];
            case 27:
                return new zzk[i8];
            case 28:
                return new zzl[i8];
            default:
                return new zzm[i8];
        }
    }
}
