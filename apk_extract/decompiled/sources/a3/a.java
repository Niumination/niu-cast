package a3;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.CursorWindow;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.converter.zac;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zan;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import com.transsion.capability.bean.FileInfo;
import com.transsion.hubsdk.api.app.TranNotificationRanking;
import com.transsion.hubsdk.api.telephony.TranAlphaTag;
import com.transsion.hubsdk.api.telephony.TranUsimGroup;
import com.transsion.hubsdk.api.view.TranBrightnessInfo;
import com.transsion.hubsdk.api.window.TranScreenshotHardwareBuffer;
import com.transsion.hubsdk.api.window.TranTaskSnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import k3.pd;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f29a;

    public /* synthetic */ a(int i8) {
        this.f29a = i8;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel in) {
        switch (this.f29a) {
            case 0:
                int iS = pd.s(in);
                int iN = 0;
                StringToIntConverter stringToIntConverter = null;
                while (in.dataPosition() < iS) {
                    int i8 = in.readInt();
                    char c9 = (char) i8;
                    if (c9 == 1) {
                        iN = pd.n(in, i8);
                    } else if (c9 != 2) {
                        pd.r(in, i8);
                    } else {
                        stringToIntConverter = (StringToIntConverter) pd.e(in, i8, StringToIntConverter.CREATOR);
                    }
                }
                pd.j(in, iS);
                return new zaa(iN, stringToIntConverter);
            case 1:
                int iS2 = pd.s(in);
                int iN2 = 0;
                ArrayList arrayListI = null;
                while (in.dataPosition() < iS2) {
                    int i9 = in.readInt();
                    char c10 = (char) i9;
                    if (c10 == 1) {
                        iN2 = pd.n(in, i9);
                    } else if (c10 != 2) {
                        pd.r(in, i9);
                    } else {
                        arrayListI = pd.i(in, i9, zac.CREATOR);
                    }
                }
                pd.j(in, iS2);
                return new StringToIntConverter(iN2, arrayListI);
            case 2:
                int iS3 = pd.s(in);
                int iN3 = 0;
                String strF = null;
                int iN4 = 0;
                while (in.dataPosition() < iS3) {
                    int i10 = in.readInt();
                    char c11 = (char) i10;
                    if (c11 == 1) {
                        iN3 = pd.n(in, i10);
                    } else if (c11 == 2) {
                        strF = pd.f(in, i10);
                    } else if (c11 != 3) {
                        pd.r(in, i10);
                    } else {
                        iN4 = pd.n(in, i10);
                    }
                }
                pd.j(in, iS3);
                return new zac(iN3, strF, iN4);
            case 3:
                int iS4 = pd.s(in);
                int iN5 = 0;
                String strF2 = null;
                FastJsonResponse$Field fastJsonResponse$Field = null;
                while (in.dataPosition() < iS4) {
                    int i11 = in.readInt();
                    char c12 = (char) i11;
                    if (c12 == 1) {
                        iN5 = pd.n(in, i11);
                    } else if (c12 == 2) {
                        strF2 = pd.f(in, i11);
                    } else if (c12 != 3) {
                        pd.r(in, i11);
                    } else {
                        fastJsonResponse$Field = (FastJsonResponse$Field) pd.e(in, i11, FastJsonResponse$Field.CREATOR);
                    }
                }
                pd.j(in, iS4);
                return new zam(iN5, strF2, fastJsonResponse$Field);
            case 4:
                int iS5 = pd.s(in);
                int iN6 = 0;
                ArrayList arrayListI2 = null;
                String strF3 = null;
                while (in.dataPosition() < iS5) {
                    int i12 = in.readInt();
                    char c13 = (char) i12;
                    if (c13 == 1) {
                        iN6 = pd.n(in, i12);
                    } else if (c13 == 2) {
                        arrayListI2 = pd.i(in, i12, zal.CREATOR);
                    } else if (c13 != 3) {
                        pd.r(in, i12);
                    } else {
                        strF3 = pd.f(in, i12);
                    }
                }
                pd.j(in, iS5);
                return new zan(iN6, arrayListI2, strF3);
            case 5:
                int iS6 = pd.s(in);
                int iN7 = 0;
                String strF4 = null;
                ArrayList arrayListI3 = null;
                while (in.dataPosition() < iS6) {
                    int i13 = in.readInt();
                    char c14 = (char) i13;
                    if (c14 == 1) {
                        iN7 = pd.n(in, i13);
                    } else if (c14 == 2) {
                        strF4 = pd.f(in, i13);
                    } else if (c14 != 3) {
                        pd.r(in, i13);
                    } else {
                        arrayListI3 = pd.i(in, i13, zam.CREATOR);
                    }
                }
                pd.j(in, iS6);
                return new zal(iN7, arrayListI3, strF4);
            case 6:
                int iS7 = pd.s(in);
                int iN8 = 0;
                Parcel parcel = null;
                zan zanVar = null;
                while (in.dataPosition() < iS7) {
                    int i14 = in.readInt();
                    char c15 = (char) i14;
                    if (c15 == 1) {
                        iN8 = pd.n(in, i14);
                    } else if (c15 == 2) {
                        int iQ = pd.q(in, i14);
                        int iDataPosition = in.dataPosition();
                        if (iQ == 0) {
                            parcel = null;
                        } else {
                            Parcel parcelObtain = Parcel.obtain();
                            parcelObtain.appendFrom(in, iDataPosition, iQ);
                            in.setDataPosition(iDataPosition + iQ);
                            parcel = parcelObtain;
                        }
                    } else if (c15 != 3) {
                        pd.r(in, i14);
                    } else {
                        zanVar = (zan) pd.e(in, i14, zan.CREATOR);
                    }
                }
                pd.j(in, iS7);
                return new SafeParcelResponse(iN8, parcel, zanVar);
            case 7:
                TranAlphaTag tranAlphaTag = new TranAlphaTag();
                tranAlphaTag.f2368b = null;
                tranAlphaTag.f2367a = in.readInt();
                tranAlphaTag.f2368b = in.readString();
                tranAlphaTag.f2369c = in.readInt();
                return tranAlphaTag;
            case 8:
                TranUsimGroup tranUsimGroup = new TranUsimGroup();
                tranUsimGroup.f2370a = null;
                tranUsimGroup.f2370a = in.readString();
                tranUsimGroup.f2371b = in.readInt();
                return tranUsimGroup;
            case 9:
                TranBrightnessInfo tranBrightnessInfo = new TranBrightnessInfo();
                tranBrightnessInfo.f2372a = in.readFloat();
                tranBrightnessInfo.f2373b = in.readFloat();
                tranBrightnessInfo.f2374c = in.readFloat();
                tranBrightnessInfo.f2375d = in.readFloat();
                tranBrightnessInfo.f2376h = in.readInt();
                tranBrightnessInfo.e = in.readFloat();
                tranBrightnessInfo.f2377i = in.readInt();
                return tranBrightnessInfo;
            case 10:
                TranScreenshotHardwareBuffer tranScreenshotHardwareBuffer = new TranScreenshotHardwareBuffer();
                tranScreenshotHardwareBuffer.f2378a = (HardwareBuffer) in.readParcelable(HardwareBuffer.class.getClassLoader());
                int i15 = in.readInt();
                tranScreenshotHardwareBuffer.f2379b = (i15 < 0 || i15 >= ColorSpace.Named.values().length) ? ColorSpace.get(ColorSpace.Named.SRGB) : ColorSpace.get(ColorSpace.Named.values()[i15]);
                tranScreenshotHardwareBuffer.f2380c = in.readByte() != 0;
                tranScreenshotHardwareBuffer.f2381d = in.readByte() != 0;
                return tranScreenshotHardwareBuffer;
            case 11:
                TranTaskSnapshot tranTaskSnapshot = new TranTaskSnapshot();
                tranTaskSnapshot.f2382a = (HardwareBuffer) in.readTypedObject(HardwareBuffer.CREATOR);
                int i16 = in.readInt();
                tranTaskSnapshot.f2383b = (i16 < 0 || i16 >= ColorSpace.Named.values().length) ? ColorSpace.get(ColorSpace.Named.SRGB) : ColorSpace.get(ColorSpace.Named.values()[i16]);
                return tranTaskSnapshot;
            case 12:
                int iS8 = pd.s(in);
                int iN9 = 0;
                String strF5 = null;
                String strF6 = null;
                String strF7 = null;
                String strF8 = null;
                Uri uri = null;
                String strF9 = null;
                String strF10 = null;
                ArrayList arrayListI4 = null;
                String strF11 = null;
                String strF12 = null;
                long jO = 0;
                while (in.dataPosition() < iS8) {
                    int i17 = in.readInt();
                    switch ((char) i17) {
                        case 1:
                            iN9 = pd.n(in, i17);
                            break;
                        case 2:
                            strF5 = pd.f(in, i17);
                            break;
                        case 3:
                            strF6 = pd.f(in, i17);
                            break;
                        case 4:
                            strF7 = pd.f(in, i17);
                            break;
                        case 5:
                            strF8 = pd.f(in, i17);
                            break;
                        case 6:
                            uri = (Uri) pd.e(in, i17, Uri.CREATOR);
                            break;
                        case 7:
                            strF9 = pd.f(in, i17);
                            break;
                        case '\b':
                            jO = pd.o(in, i17);
                            break;
                        case '\t':
                            strF10 = pd.f(in, i17);
                            break;
                        case '\n':
                            arrayListI4 = pd.i(in, i17, Scope.CREATOR);
                            break;
                        case 11:
                            strF11 = pd.f(in, i17);
                            break;
                        case '\f':
                            strF12 = pd.f(in, i17);
                            break;
                        default:
                            pd.r(in, i17);
                            break;
                    }
                }
                pd.j(in, iS8);
                return new GoogleSignInAccount(iN9, strF5, strF6, strF7, strF8, uri, strF9, jO, strF10, arrayListI4, strF11, strF12);
            case 13:
                int iS9 = pd.s(in);
                ArrayList<GoogleSignInOptionsExtensionParcelable> arrayListI5 = null;
                int iN10 = 0;
                boolean zK = false;
                boolean zK2 = false;
                boolean zK3 = false;
                ArrayList arrayListI6 = null;
                Account account = null;
                String strF13 = null;
                String strF14 = null;
                String strF15 = null;
                while (in.dataPosition() < iS9) {
                    int i18 = in.readInt();
                    switch ((char) i18) {
                        case 1:
                            iN10 = pd.n(in, i18);
                            break;
                        case 2:
                            arrayListI6 = pd.i(in, i18, Scope.CREATOR);
                            break;
                        case 3:
                            account = (Account) pd.e(in, i18, Account.CREATOR);
                            break;
                        case 4:
                            zK = pd.k(in, i18);
                            break;
                        case 5:
                            zK2 = pd.k(in, i18);
                            break;
                        case 6:
                            zK3 = pd.k(in, i18);
                            break;
                        case 7:
                            strF13 = pd.f(in, i18);
                            break;
                        case '\b':
                            strF14 = pd.f(in, i18);
                            break;
                        case '\t':
                            arrayListI5 = pd.i(in, i18, GoogleSignInOptionsExtensionParcelable.CREATOR);
                            break;
                        case '\n':
                            strF15 = pd.f(in, i18);
                            break;
                        default:
                            pd.r(in, i18);
                            break;
                    }
                }
                pd.j(in, iS9);
                HashMap map = new HashMap();
                if (arrayListI5 != null) {
                    for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : arrayListI5) {
                        map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.f1795b), googleSignInOptionsExtensionParcelable);
                    }
                }
                return new GoogleSignInOptions(iN10, arrayListI6, account, zK, zK2, zK3, strF13, strF14, map, strF15);
            case 14:
                int iS10 = pd.s(in);
                int iN11 = 0;
                Bundle bundleB = null;
                int iN12 = 0;
                while (in.dataPosition() < iS10) {
                    int i19 = in.readInt();
                    char c16 = (char) i19;
                    if (c16 == 1) {
                        iN11 = pd.n(in, i19);
                    } else if (c16 == 2) {
                        iN12 = pd.n(in, i19);
                    } else if (c16 != 3) {
                        pd.r(in, i19);
                    } else {
                        bundleB = pd.b(in, i19);
                    }
                }
                pd.j(in, iS10);
                return new GoogleSignInOptionsExtensionParcelable(iN11, iN12, bundleB);
            case 15:
                int iS11 = pd.s(in);
                int iN13 = 0;
                PendingIntent pendingIntent = null;
                String strF16 = null;
                int iN14 = 0;
                while (in.dataPosition() < iS11) {
                    int i20 = in.readInt();
                    char c17 = (char) i20;
                    if (c17 == 1) {
                        iN13 = pd.n(in, i20);
                    } else if (c17 == 2) {
                        iN14 = pd.n(in, i20);
                    } else if (c17 == 3) {
                        pendingIntent = (PendingIntent) pd.e(in, i20, PendingIntent.CREATOR);
                    } else if (c17 != 4) {
                        pd.r(in, i20);
                    } else {
                        strF16 = pd.f(in, i20);
                    }
                }
                pd.j(in, iS11);
                return new ConnectionResult(iN13, iN14, pendingIntent, strF16);
            case 16:
                int iS12 = pd.s(in);
                String strF17 = null;
                int iN15 = 0;
                long jO2 = -1;
                while (in.dataPosition() < iS12) {
                    int i21 = in.readInt();
                    char c18 = (char) i21;
                    if (c18 == 1) {
                        strF17 = pd.f(in, i21);
                    } else if (c18 == 2) {
                        iN15 = pd.n(in, i21);
                    } else if (c18 != 3) {
                        pd.r(in, i21);
                    } else {
                        jO2 = pd.o(in, i21);
                    }
                }
                pd.j(in, iS12);
                return new Feature(strF17, iN15, jO2);
            case 17:
                int iS13 = pd.s(in);
                String strF18 = null;
                IBinder iBinderM = null;
                boolean zK4 = false;
                boolean zK5 = false;
                boolean zK6 = false;
                while (in.dataPosition() < iS13) {
                    int i22 = in.readInt();
                    char c19 = (char) i22;
                    if (c19 == 1) {
                        strF18 = pd.f(in, i22);
                    } else if (c19 == 2) {
                        zK4 = pd.k(in, i22);
                    } else if (c19 == 3) {
                        zK5 = pd.k(in, i22);
                    } else if (c19 == 4) {
                        iBinderM = pd.m(in, i22);
                    } else if (c19 != 5) {
                        pd.r(in, i22);
                    } else {
                        zK6 = pd.k(in, i22);
                    }
                }
                pd.j(in, iS13);
                return new zzo(strF18, zK4, zK5, iBinderM, zK6);
            case 18:
                int iS14 = pd.s(in);
                boolean zK7 = false;
                int iN16 = 0;
                String strF19 = null;
                int iN17 = 0;
                while (in.dataPosition() < iS14) {
                    int i23 = in.readInt();
                    char c20 = (char) i23;
                    if (c20 == 1) {
                        zK7 = pd.k(in, i23);
                    } else if (c20 == 2) {
                        strF19 = pd.f(in, i23);
                    } else if (c20 == 3) {
                        iN17 = pd.n(in, i23);
                    } else if (c20 != 4) {
                        pd.r(in, i23);
                    } else {
                        iN16 = pd.n(in, i23);
                    }
                }
                pd.j(in, iS14);
                return new zzq(strF19, iN17, iN16, zK7);
            case 19:
                int iS15 = pd.s(in);
                String strF20 = null;
                boolean zK8 = false;
                boolean zK9 = false;
                IBinder iBinderM2 = null;
                while (in.dataPosition() < iS15) {
                    int i24 = in.readInt();
                    char c21 = (char) i24;
                    if (c21 == 1) {
                        strF20 = pd.f(in, i24);
                    } else if (c21 == 2) {
                        iBinderM2 = pd.m(in, i24);
                    } else if (c21 == 3) {
                        zK8 = pd.k(in, i24);
                    } else if (c21 != 4) {
                        pd.r(in, i24);
                    } else {
                        zK9 = pd.k(in, i24);
                    }
                }
                pd.j(in, iS15);
                return new zzs(strF20, iBinderM2, zK8, zK9);
            case 20:
                int iS16 = pd.s(in);
                int iN18 = 0;
                Intent intent = null;
                int iN19 = 0;
                while (in.dataPosition() < iS16) {
                    int i25 = in.readInt();
                    char c22 = (char) i25;
                    if (c22 == 1) {
                        iN18 = pd.n(in, i25);
                    } else if (c22 == 2) {
                        iN19 = pd.n(in, i25);
                    } else if (c22 != 3) {
                        pd.r(in, i25);
                    } else {
                        intent = (Intent) pd.e(in, i25, Intent.CREATOR);
                    }
                }
                pd.j(in, iS16);
                return new com.google.android.gms.signin.internal.zaa(iN18, iN19, intent);
            case 21:
                int iS17 = pd.s(in);
                ArrayList<String> arrayList = null;
                String strF21 = null;
                while (in.dataPosition() < iS17) {
                    int i26 = in.readInt();
                    char c23 = (char) i26;
                    if (c23 == 1) {
                        int iQ2 = pd.q(in, i26);
                        int iDataPosition2 = in.dataPosition();
                        if (iQ2 == 0) {
                            arrayList = null;
                        } else {
                            ArrayList<String> arrayListCreateStringArrayList = in.createStringArrayList();
                            in.setDataPosition(iDataPosition2 + iQ2);
                            arrayList = arrayListCreateStringArrayList;
                        }
                    } else if (c23 != 2) {
                        pd.r(in, i26);
                    } else {
                        strF21 = pd.f(in, i26);
                    }
                }
                pd.j(in, iS17);
                return new zag(strF21, arrayList);
            case 22:
                int iS18 = pd.s(in);
                int iN20 = 0;
                zat zatVar = null;
                while (in.dataPosition() < iS18) {
                    int i27 = in.readInt();
                    char c24 = (char) i27;
                    if (c24 == 1) {
                        iN20 = pd.n(in, i27);
                    } else if (c24 != 2) {
                        pd.r(in, i27);
                    } else {
                        zatVar = (zat) pd.e(in, i27, zat.CREATOR);
                    }
                }
                pd.j(in, iS18);
                return new zai(iN20, zatVar);
            case 23:
                int iS19 = pd.s(in);
                int iN21 = 0;
                ConnectionResult connectionResult = null;
                zav zavVar = null;
                while (in.dataPosition() < iS19) {
                    int i28 = in.readInt();
                    char c25 = (char) i28;
                    if (c25 == 1) {
                        iN21 = pd.n(in, i28);
                    } else if (c25 == 2) {
                        connectionResult = (ConnectionResult) pd.e(in, i28, ConnectionResult.CREATOR);
                    } else if (c25 != 3) {
                        pd.r(in, i28);
                    } else {
                        zavVar = (zav) pd.e(in, i28, zav.CREATOR);
                    }
                }
                pd.j(in, iS19);
                return new zak(iN21, connectionResult, zavVar);
            case 24:
                int iS20 = pd.s(in);
                int iN22 = 0;
                String strF22 = null;
                while (in.dataPosition() < iS20) {
                    int i29 = in.readInt();
                    char c26 = (char) i29;
                    if (c26 == 1) {
                        iN22 = pd.n(in, i29);
                    } else if (c26 != 2) {
                        pd.r(in, i29);
                    } else {
                        strF22 = pd.f(in, i29);
                    }
                }
                pd.j(in, iS20);
                return new Scope(iN22, strF22);
            case 25:
                int iS21 = pd.s(in);
                int iN23 = 0;
                int iN24 = 0;
                String strF23 = null;
                PendingIntent pendingIntent2 = null;
                ConnectionResult connectionResult2 = null;
                while (in.dataPosition() < iS21) {
                    int i30 = in.readInt();
                    char c27 = (char) i30;
                    if (c27 == 1) {
                        iN24 = pd.n(in, i30);
                    } else if (c27 == 2) {
                        strF23 = pd.f(in, i30);
                    } else if (c27 == 3) {
                        pendingIntent2 = (PendingIntent) pd.e(in, i30, PendingIntent.CREATOR);
                    } else if (c27 == 4) {
                        connectionResult2 = (ConnectionResult) pd.e(in, i30, ConnectionResult.CREATOR);
                    } else if (c27 != 1000) {
                        pd.r(in, i30);
                    } else {
                        iN23 = pd.n(in, i30);
                    }
                }
                pd.j(in, iS21);
                return new Status(iN23, iN24, strF23, pendingIntent2, connectionResult2);
            case 26:
                Intrinsics.checkNotNullParameter(in, "in");
                return new FileInfo(in);
            case 27:
                int iS22 = pd.s(in);
                int iN25 = 0;
                ParcelFileDescriptor parcelFileDescriptor = null;
                int iN26 = 0;
                while (in.dataPosition() < iS22) {
                    int i31 = in.readInt();
                    char c28 = (char) i31;
                    if (c28 == 1) {
                        iN25 = pd.n(in, i31);
                    } else if (c28 == 2) {
                        parcelFileDescriptor = (ParcelFileDescriptor) pd.e(in, i31, ParcelFileDescriptor.CREATOR);
                    } else if (c28 != 3) {
                        pd.r(in, i31);
                    } else {
                        iN26 = pd.n(in, i31);
                    }
                }
                pd.j(in, iS22);
                return new BitmapTeleporter(iN25, parcelFileDescriptor, iN26);
            case 28:
                int iS23 = pd.s(in);
                int iN27 = 0;
                int iN28 = 0;
                String[] strArrG = null;
                CursorWindow[] cursorWindowArr = null;
                Bundle bundleB2 = null;
                while (in.dataPosition() < iS23) {
                    int i32 = in.readInt();
                    char c29 = (char) i32;
                    if (c29 == 1) {
                        strArrG = pd.g(in, i32);
                    } else if (c29 == 2) {
                        cursorWindowArr = (CursorWindow[]) pd.h(in, i32, CursorWindow.CREATOR);
                    } else if (c29 == 3) {
                        iN28 = pd.n(in, i32);
                    } else if (c29 == 4) {
                        bundleB2 = pd.b(in, i32);
                    } else if (c29 != 1000) {
                        pd.r(in, i32);
                    } else {
                        iN27 = pd.n(in, i32);
                    }
                }
                pd.j(in, iS23);
                DataHolder dataHolder = new DataHolder(iN27, strArrG, cursorWindowArr, iN28, bundleB2);
                dataHolder.f1831c = new Bundle();
                int i33 = 0;
                while (true) {
                    String[] strArr = dataHolder.f1830b;
                    if (i33 >= strArr.length) {
                        CursorWindow[] cursorWindowArr2 = dataHolder.f1832d;
                        dataHolder.f1834i = new int[cursorWindowArr2.length];
                        int numRows = 0;
                        for (int i34 = 0; i34 < cursorWindowArr2.length; i34++) {
                            dataHolder.f1834i[i34] = numRows;
                            numRows += cursorWindowArr2[i34].getNumRows() - (numRows - cursorWindowArr2[i34].getStartPosition());
                        }
                        return dataHolder;
                    }
                    dataHolder.f1831c.putInt(strArr[i33], i33);
                    i33++;
                }
                break;
            default:
                TranNotificationRanking tranNotificationRanking = new TranNotificationRanking();
                tranNotificationRanking.f2336a = in.readString();
                tranNotificationRanking.f2337b = in.readInt();
                tranNotificationRanking.f2338c = in.readByte() != 0;
                return tranNotificationRanking;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        switch (this.f29a) {
            case 0:
                return new zaa[i8];
            case 1:
                return new StringToIntConverter[i8];
            case 2:
                return new zac[i8];
            case 3:
                return new zam[i8];
            case 4:
                return new zan[i8];
            case 5:
                return new zal[i8];
            case 6:
                return new SafeParcelResponse[i8];
            case 7:
                return new TranAlphaTag[i8];
            case 8:
                return new TranUsimGroup[i8];
            case 9:
                return new TranBrightnessInfo[i8];
            case 10:
                return new TranScreenshotHardwareBuffer[i8];
            case 11:
                return new TranTaskSnapshot[i8];
            case 12:
                return new GoogleSignInAccount[i8];
            case 13:
                return new GoogleSignInOptions[i8];
            case 14:
                return new GoogleSignInOptionsExtensionParcelable[i8];
            case 15:
                return new ConnectionResult[i8];
            case 16:
                return new Feature[i8];
            case 17:
                return new zzo[i8];
            case 18:
                return new zzq[i8];
            case 19:
                return new zzs[i8];
            case 20:
                return new com.google.android.gms.signin.internal.zaa[i8];
            case 21:
                return new zag[i8];
            case 22:
                return new zai[i8];
            case 23:
                return new zak[i8];
            case 24:
                return new Scope[i8];
            case 25:
                return new Status[i8];
            case 26:
                return new FileInfo[i8];
            case 27:
                return new BitmapTeleporter[i8];
            case 28:
                return new DataHolder[i8];
            default:
                return new TranNotificationRanking[i8];
        }
    }
}
