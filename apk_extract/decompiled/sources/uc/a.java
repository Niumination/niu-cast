package uc;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.transsion.hubsdk.api.hardware.fingerprint.TranFingerprintInfo;
import com.transsion.hubsdk.api.os.TranUserInfo;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanBLEAudioSupport;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanBatteryInfo;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanBoxAndEarbudsStatus;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanBroadcastAndPairState;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanColorInfo;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanFirmwareVersion;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanOtherEarbudBTMac;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanResult;
import k3.pd;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10420a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f10420a) {
            case 0:
                TwsBleScanOtherEarbudBTMac twsBleScanOtherEarbudBTMac = new TwsBleScanOtherEarbudBTMac();
                twsBleScanOtherEarbudBTMac.f2931a = parcel.readString();
                return twsBleScanOtherEarbudBTMac;
            case 1:
                TwsBleScanResult twsBleScanResult = new TwsBleScanResult();
                twsBleScanResult.f2932a = parcel.readInt();
                twsBleScanResult.f2933b = parcel.readString();
                twsBleScanResult.f2934c = parcel.readInt();
                twsBleScanResult.f2935d = parcel.readInt();
                twsBleScanResult.e = parcel.readString();
                twsBleScanResult.f2936h = (TwsBleScanBroadcastAndPairState) parcel.readParcelable(TwsBleScanBroadcastAndPairState.class.getClassLoader());
                twsBleScanResult.f2937i = (TwsBleScanBoxAndEarbudsStatus) parcel.readParcelable(TwsBleScanBoxAndEarbudsStatus.class.getClassLoader());
                twsBleScanResult.f2938j = (TwsBleScanBatteryInfo) parcel.readParcelable(TwsBleScanBatteryInfo.class.getClassLoader());
                twsBleScanResult.f2939k = (TwsBleScanColorInfo) parcel.readParcelable(TwsBleScanColorInfo.class.getClassLoader());
                twsBleScanResult.f2940l = (TwsBleScanBLEAudioSupport) parcel.readParcelable(TwsBleScanBLEAudioSupport.class.getClassLoader());
                twsBleScanResult.f2941m = (TwsBleScanOtherEarbudBTMac) parcel.readParcelable(TwsBleScanOtherEarbudBTMac.class.getClassLoader());
                twsBleScanResult.f2942n = (TwsBleScanFirmwareVersion) parcel.readParcelable(TwsBleScanFirmwareVersion.class.getClassLoader());
                twsBleScanResult.f2943o = (ContentValues) parcel.readParcelable(ContentValues.class.getClassLoader());
                return twsBleScanResult;
            case 2:
                TranFingerprintInfo tranFingerprintInfo = new TranFingerprintInfo();
                tranFingerprintInfo.f2349a = parcel.readInt();
                tranFingerprintInfo.f2350b = parcel.readInt();
                tranFingerprintInfo.f2351c = parcel.readString();
                tranFingerprintInfo.f2352d = parcel.readInt();
                tranFingerprintInfo.e = parcel.readLong();
                return tranFingerprintInfo;
            case 3:
                int iS = pd.s(parcel);
                boolean zK = false;
                int iN = 0;
                while (parcel.dataPosition() < iS) {
                    int i8 = parcel.readInt();
                    char c9 = (char) i8;
                    if (c9 == 1) {
                        zK = pd.k(parcel, i8);
                    } else if (c9 != 2) {
                        pd.r(parcel, i8);
                    } else {
                        iN = pd.n(parcel, i8);
                    }
                }
                pd.j(parcel, iS);
                return new ModuleAvailabilityResponse(zK, iN);
            case 4:
                int iS2 = pd.s(parcel);
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < iS2) {
                    int i9 = parcel.readInt();
                    if (((char) i9) != 1) {
                        pd.r(parcel, i9);
                    } else {
                        pendingIntent = (PendingIntent) pd.e(parcel, i9, PendingIntent.CREATOR);
                    }
                }
                pd.j(parcel, iS2);
                return new ModuleInstallIntentResponse(pendingIntent);
            case 5:
                int iS3 = pd.s(parcel);
                int iN2 = 0;
                boolean zK2 = false;
                while (parcel.dataPosition() < iS3) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        iN2 = pd.n(parcel, i10);
                    } else if (c10 != 2) {
                        pd.r(parcel, i10);
                    } else {
                        zK2 = pd.k(parcel, i10);
                    }
                }
                pd.j(parcel, iS3);
                return new ModuleInstallResponse(iN2, zK2);
            case 6:
                int iS4 = pd.s(parcel);
                int iN3 = 0;
                int iN4 = 0;
                int iN5 = 0;
                Long lP = null;
                Long lP2 = null;
                while (parcel.dataPosition() < iS4) {
                    int i11 = parcel.readInt();
                    char c11 = (char) i11;
                    if (c11 == 1) {
                        iN3 = pd.n(parcel, i11);
                    } else if (c11 == 2) {
                        iN4 = pd.n(parcel, i11);
                    } else if (c11 == 3) {
                        lP = pd.p(parcel, i11);
                    } else if (c11 == 4) {
                        lP2 = pd.p(parcel, i11);
                    } else if (c11 != 5) {
                        pd.r(parcel, i11);
                    } else {
                        iN5 = pd.n(parcel, i11);
                    }
                }
                pd.j(parcel, iS4);
                return new ModuleInstallStatusUpdate(iN3, iN4, lP, lP2, iN5);
            case 7:
                int iS5 = pd.s(parcel);
                int iN6 = 0;
                String strF = null;
                int iN7 = 0;
                while (parcel.dataPosition() < iS5) {
                    int i12 = parcel.readInt();
                    char c12 = (char) i12;
                    if (c12 == 1) {
                        iN6 = pd.n(parcel, i12);
                    } else if (c12 == 2) {
                        strF = pd.f(parcel, i12);
                    } else if (c12 != 3) {
                        pd.r(parcel, i12);
                    } else {
                        iN7 = pd.n(parcel, i12);
                    }
                }
                pd.j(parcel, iS5);
                return new FavaDiagnosticsEntity(iN6, strF, iN7);
            default:
                TranUserInfo tranUserInfo = new TranUserInfo();
                tranUserInfo.f2353a = parcel.readInt();
                parcel.readInt();
                tranUserInfo.f2354b = parcel.readString();
                tranUserInfo.f2355c = parcel.readString();
                tranUserInfo.f2356d = parcel.readInt();
                tranUserInfo.e = parcel.readString();
                tranUserInfo.f2357h = parcel.readLong();
                tranUserInfo.f2358i = parcel.readByte() != 0;
                tranUserInfo.f2359j = parcel.readByte() != 0;
                tranUserInfo.f2360k = parcel.readString();
                tranUserInfo.f2361l = parcel.readInt();
                tranUserInfo.f2362m = parcel.readInt();
                tranUserInfo.f2363n = parcel.readInt();
                tranUserInfo.f2364o = parcel.readByte() != 0;
                return tranUserInfo;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        switch (this.f10420a) {
            case 0:
                return new TwsBleScanOtherEarbudBTMac[i8];
            case 1:
                return new TwsBleScanResult[i8];
            case 2:
                return new TranFingerprintInfo[i8];
            case 3:
                return new ModuleAvailabilityResponse[i8];
            case 4:
                return new ModuleInstallIntentResponse[i8];
            case 5:
                return new ModuleInstallResponse[i8];
            case 6:
                return new ModuleInstallStatusUpdate[i8];
            case 7:
                return new FavaDiagnosticsEntity[i8];
            default:
                return new TranUserInfo[i8];
        }
    }
}
