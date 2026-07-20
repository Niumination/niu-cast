package l3;

import android.graphics.Point;
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
import k3.pd;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7237a;

    public /* synthetic */ g(int i8) {
        this.f7237a = i8;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f7237a) {
            case 0:
                int iS = pd.s(parcel);
                String[] strArrG = null;
                int iN = 0;
                while (parcel.dataPosition() < iS) {
                    int i8 = parcel.readInt();
                    char c9 = (char) i8;
                    if (c9 == 1) {
                        iN = pd.n(parcel, i8);
                    } else if (c9 != 2) {
                        pd.r(parcel, i8);
                    } else {
                        strArrG = pd.g(parcel, i8);
                    }
                }
                pd.j(parcel, iS);
                return new zzao(iN, strArrG);
            case 1:
                int iS2 = pd.s(parcel);
                String strF = null;
                String strF2 = null;
                byte[] bArrC = null;
                Point[] pointArr = null;
                zzat zzatVar = null;
                zzaw zzawVar = null;
                zzax zzaxVar = null;
                zzaz zzazVar = null;
                zzay zzayVar = null;
                zzau zzauVar = null;
                zzaq zzaqVar = null;
                zzar zzarVar = null;
                zzas zzasVar = null;
                int iN2 = 0;
                int iN3 = 0;
                while (parcel.dataPosition() < iS2) {
                    int i9 = parcel.readInt();
                    switch ((char) i9) {
                        case 1:
                            iN2 = pd.n(parcel, i9);
                            break;
                        case 2:
                            strF = pd.f(parcel, i9);
                            break;
                        case 3:
                            strF2 = pd.f(parcel, i9);
                            break;
                        case 4:
                            bArrC = pd.c(parcel, i9);
                            break;
                        case 5:
                            pointArr = (Point[]) pd.h(parcel, i9, Point.CREATOR);
                            break;
                        case 6:
                            iN3 = pd.n(parcel, i9);
                            break;
                        case 7:
                            zzatVar = (zzat) pd.e(parcel, i9, zzat.CREATOR);
                            break;
                        case '\b':
                            zzawVar = (zzaw) pd.e(parcel, i9, zzaw.CREATOR);
                            break;
                        case '\t':
                            zzaxVar = (zzax) pd.e(parcel, i9, zzax.CREATOR);
                            break;
                        case '\n':
                            zzazVar = (zzaz) pd.e(parcel, i9, zzaz.CREATOR);
                            break;
                        case 11:
                            zzayVar = (zzay) pd.e(parcel, i9, zzay.CREATOR);
                            break;
                        case '\f':
                            zzauVar = (zzau) pd.e(parcel, i9, zzau.CREATOR);
                            break;
                        case '\r':
                            zzaqVar = (zzaq) pd.e(parcel, i9, zzaq.CREATOR);
                            break;
                        case 14:
                            zzarVar = (zzar) pd.e(parcel, i9, zzar.CREATOR);
                            break;
                        case 15:
                            zzasVar = (zzas) pd.e(parcel, i9, zzas.CREATOR);
                            break;
                        default:
                            pd.r(parcel, i9);
                            break;
                    }
                }
                pd.j(parcel, iS2);
                return new zzba(iN2, strF, strF2, bArrC, pointArr, iN3, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar);
            case 2:
                int iS3 = pd.s(parcel);
                int iN4 = 0;
                boolean zK = false;
                while (parcel.dataPosition() < iS3) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        iN4 = pd.n(parcel, i10);
                    } else if (c10 != 2) {
                        pd.r(parcel, i10);
                    } else {
                        zK = pd.k(parcel, i10);
                    }
                }
                pd.j(parcel, iS3);
                return new zzbc(iN4, zK);
            case 3:
                int iS4 = pd.s(parcel);
                String strF3 = null;
                int iN5 = 0;
                int iN6 = 0;
                int iN7 = 0;
                int iN8 = 0;
                int iN9 = 0;
                int iN10 = 0;
                boolean zK2 = false;
                while (parcel.dataPosition() < iS4) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 1:
                            iN5 = pd.n(parcel, i11);
                            break;
                        case 2:
                            iN6 = pd.n(parcel, i11);
                            break;
                        case 3:
                            iN7 = pd.n(parcel, i11);
                            break;
                        case 4:
                            iN8 = pd.n(parcel, i11);
                            break;
                        case 5:
                            iN9 = pd.n(parcel, i11);
                            break;
                        case 6:
                            iN10 = pd.n(parcel, i11);
                            break;
                        case 7:
                            zK2 = pd.k(parcel, i11);
                            break;
                        case '\b':
                            strF3 = pd.f(parcel, i11);
                            break;
                        default:
                            pd.r(parcel, i11);
                            break;
                    }
                }
                pd.j(parcel, iS4);
                return new zzap(iN5, iN6, iN7, iN8, iN9, iN10, zK2, strF3);
            case 4:
                int iS5 = pd.s(parcel);
                String strF4 = null;
                String strF5 = null;
                String strF6 = null;
                String strF7 = null;
                String strF8 = null;
                zzap zzapVar = null;
                zzap zzapVar2 = null;
                while (parcel.dataPosition() < iS5) {
                    int i12 = parcel.readInt();
                    switch ((char) i12) {
                        case 1:
                            strF4 = pd.f(parcel, i12);
                            break;
                        case 2:
                            strF5 = pd.f(parcel, i12);
                            break;
                        case 3:
                            strF6 = pd.f(parcel, i12);
                            break;
                        case 4:
                            strF7 = pd.f(parcel, i12);
                            break;
                        case 5:
                            strF8 = pd.f(parcel, i12);
                            break;
                        case 6:
                            zzapVar = (zzap) pd.e(parcel, i12, zzap.CREATOR);
                            break;
                        case 7:
                            zzapVar2 = (zzap) pd.e(parcel, i12, zzap.CREATOR);
                            break;
                        default:
                            pd.r(parcel, i12);
                            break;
                    }
                }
                pd.j(parcel, iS5);
                return new zzaq(strF4, strF5, strF6, strF7, strF8, zzapVar, zzapVar2);
            case 5:
                int iS6 = pd.s(parcel);
                zzav zzavVar = null;
                String strF9 = null;
                String strF10 = null;
                zzaw[] zzawVarArr = null;
                zzat[] zzatVarArr = null;
                String[] strArrG2 = null;
                zzao[] zzaoVarArr = null;
                while (parcel.dataPosition() < iS6) {
                    int i13 = parcel.readInt();
                    switch ((char) i13) {
                        case 1:
                            zzavVar = (zzav) pd.e(parcel, i13, zzav.CREATOR);
                            break;
                        case 2:
                            strF9 = pd.f(parcel, i13);
                            break;
                        case 3:
                            strF10 = pd.f(parcel, i13);
                            break;
                        case 4:
                            zzawVarArr = (zzaw[]) pd.h(parcel, i13, zzaw.CREATOR);
                            break;
                        case 5:
                            zzatVarArr = (zzat[]) pd.h(parcel, i13, zzat.CREATOR);
                            break;
                        case 6:
                            strArrG2 = pd.g(parcel, i13);
                            break;
                        case 7:
                            zzaoVarArr = (zzao[]) pd.h(parcel, i13, zzao.CREATOR);
                            break;
                        default:
                            pd.r(parcel, i13);
                            break;
                    }
                }
                pd.j(parcel, iS6);
                return new zzar(zzavVar, strF9, strF10, zzawVarArr, zzatVarArr, strArrG2, zzaoVarArr);
            case 6:
                int iS7 = pd.s(parcel);
                String strF11 = null;
                String strF12 = null;
                String strF13 = null;
                String strF14 = null;
                String strF15 = null;
                String strF16 = null;
                String strF17 = null;
                String strF18 = null;
                String strF19 = null;
                String strF20 = null;
                String strF21 = null;
                String strF22 = null;
                String strF23 = null;
                String strF24 = null;
                while (parcel.dataPosition() < iS7) {
                    int i14 = parcel.readInt();
                    switch ((char) i14) {
                        case 1:
                            strF11 = pd.f(parcel, i14);
                            break;
                        case 2:
                            strF12 = pd.f(parcel, i14);
                            break;
                        case 3:
                            strF13 = pd.f(parcel, i14);
                            break;
                        case 4:
                            strF14 = pd.f(parcel, i14);
                            break;
                        case 5:
                            strF15 = pd.f(parcel, i14);
                            break;
                        case 6:
                            strF16 = pd.f(parcel, i14);
                            break;
                        case 7:
                            strF17 = pd.f(parcel, i14);
                            break;
                        case '\b':
                            strF18 = pd.f(parcel, i14);
                            break;
                        case '\t':
                            strF19 = pd.f(parcel, i14);
                            break;
                        case '\n':
                            strF20 = pd.f(parcel, i14);
                            break;
                        case 11:
                            strF21 = pd.f(parcel, i14);
                            break;
                        case '\f':
                            strF22 = pd.f(parcel, i14);
                            break;
                        case '\r':
                            strF23 = pd.f(parcel, i14);
                            break;
                        case 14:
                            strF24 = pd.f(parcel, i14);
                            break;
                        default:
                            pd.r(parcel, i14);
                            break;
                    }
                }
                pd.j(parcel, iS7);
                return new zzas(strF11, strF12, strF13, strF14, strF15, strF16, strF17, strF18, strF19, strF20, strF21, strF22, strF23, strF24);
            case 7:
                int iS8 = pd.s(parcel);
                String strF25 = null;
                String strF26 = null;
                int iN11 = 0;
                String strF27 = null;
                while (parcel.dataPosition() < iS8) {
                    int i15 = parcel.readInt();
                    char c11 = (char) i15;
                    if (c11 == 1) {
                        iN11 = pd.n(parcel, i15);
                    } else if (c11 == 2) {
                        strF25 = pd.f(parcel, i15);
                    } else if (c11 == 3) {
                        strF27 = pd.f(parcel, i15);
                    } else if (c11 != 4) {
                        pd.r(parcel, i15);
                    } else {
                        strF26 = pd.f(parcel, i15);
                    }
                }
                pd.j(parcel, iS8);
                return new zzat(iN11, strF25, strF27, strF26);
            case 8:
                int iS9 = pd.s(parcel);
                double dL = 0.0d;
                double dL2 = 0.0d;
                while (parcel.dataPosition() < iS9) {
                    int i16 = parcel.readInt();
                    char c12 = (char) i16;
                    if (c12 == 1) {
                        dL = pd.l(parcel, i16);
                    } else if (c12 != 2) {
                        pd.r(parcel, i16);
                    } else {
                        dL2 = pd.l(parcel, i16);
                    }
                }
                pd.j(parcel, iS9);
                return new zzau(dL, dL2);
            case 9:
                int iS10 = pd.s(parcel);
                String strF28 = null;
                String strF29 = null;
                String strF30 = null;
                String strF31 = null;
                String strF32 = null;
                String strF33 = null;
                String strF34 = null;
                while (parcel.dataPosition() < iS10) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 1:
                            strF28 = pd.f(parcel, i17);
                            break;
                        case 2:
                            strF29 = pd.f(parcel, i17);
                            break;
                        case 3:
                            strF30 = pd.f(parcel, i17);
                            break;
                        case 4:
                            strF31 = pd.f(parcel, i17);
                            break;
                        case 5:
                            strF32 = pd.f(parcel, i17);
                            break;
                        case 6:
                            strF33 = pd.f(parcel, i17);
                            break;
                        case 7:
                            strF34 = pd.f(parcel, i17);
                            break;
                        default:
                            pd.r(parcel, i17);
                            break;
                    }
                }
                pd.j(parcel, iS10);
                return new zzav(strF28, strF29, strF30, strF31, strF32, strF33, strF34);
            case 10:
                int iS11 = pd.s(parcel);
                String strF35 = null;
                int iN12 = 0;
                while (parcel.dataPosition() < iS11) {
                    int i18 = parcel.readInt();
                    char c13 = (char) i18;
                    if (c13 == 1) {
                        iN12 = pd.n(parcel, i18);
                    } else if (c13 != 2) {
                        pd.r(parcel, i18);
                    } else {
                        strF35 = pd.f(parcel, i18);
                    }
                }
                pd.j(parcel, iS11);
                return new zzaw(iN12, strF35);
            case 11:
                int iS12 = pd.s(parcel);
                String strF36 = null;
                String strF37 = null;
                while (parcel.dataPosition() < iS12) {
                    int i19 = parcel.readInt();
                    char c14 = (char) i19;
                    if (c14 == 1) {
                        strF36 = pd.f(parcel, i19);
                    } else if (c14 != 2) {
                        pd.r(parcel, i19);
                    } else {
                        strF37 = pd.f(parcel, i19);
                    }
                }
                pd.j(parcel, iS12);
                return new zzax(strF36, strF37);
            case 12:
                int iS13 = pd.s(parcel);
                String strF38 = null;
                String strF39 = null;
                while (parcel.dataPosition() < iS13) {
                    int i20 = parcel.readInt();
                    char c15 = (char) i20;
                    if (c15 == 1) {
                        strF38 = pd.f(parcel, i20);
                    } else if (c15 != 2) {
                        pd.r(parcel, i20);
                    } else {
                        strF39 = pd.f(parcel, i20);
                    }
                }
                pd.j(parcel, iS13);
                return new zzay(strF38, strF39);
            case 13:
                int iS14 = pd.s(parcel);
                int iN13 = 0;
                String strF40 = null;
                String strF41 = null;
                while (parcel.dataPosition() < iS14) {
                    int i21 = parcel.readInt();
                    char c16 = (char) i21;
                    if (c16 == 1) {
                        strF40 = pd.f(parcel, i21);
                    } else if (c16 == 2) {
                        strF41 = pd.f(parcel, i21);
                    } else if (c16 != 3) {
                        pd.r(parcel, i21);
                    } else {
                        iN13 = pd.n(parcel, i21);
                    }
                }
                pd.j(parcel, iS14);
                return new zzaz(strF40, strF41, iN13);
            default:
                int iS15 = pd.s(parcel);
                long jO = 0;
                int iN14 = 0;
                int iN15 = 0;
                int iN16 = 0;
                int iN17 = 0;
                while (parcel.dataPosition() < iS15) {
                    int i22 = parcel.readInt();
                    char c17 = (char) i22;
                    if (c17 == 1) {
                        iN14 = pd.n(parcel, i22);
                    } else if (c17 == 2) {
                        iN15 = pd.n(parcel, i22);
                    } else if (c17 == 3) {
                        iN16 = pd.n(parcel, i22);
                    } else if (c17 == 4) {
                        iN17 = pd.n(parcel, i22);
                    } else if (c17 != 5) {
                        pd.r(parcel, i22);
                    } else {
                        jO = pd.o(parcel, i22);
                    }
                }
                pd.j(parcel, iS15);
                return new zzbu(iN14, iN15, iN16, iN17, jO);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        switch (this.f7237a) {
            case 0:
                return new zzao[i8];
            case 1:
                return new zzba[i8];
            case 2:
                return new zzbc[i8];
            case 3:
                return new zzap[i8];
            case 4:
                return new zzaq[i8];
            case 5:
                return new zzar[i8];
            case 6:
                return new zzas[i8];
            case 7:
                return new zzat[i8];
            case 8:
                return new zzau[i8];
            case 9:
                return new zzav[i8];
            case 10:
                return new zzaw[i8];
            case 11:
                return new zzax[i8];
            case 12:
                return new zzay[i8];
            case 13:
                return new zzaz[i8];
            default:
                return new zzbu[i8];
        }
    }
}
