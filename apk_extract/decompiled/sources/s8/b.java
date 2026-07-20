package s8;

import android.accounts.Account;
import android.content.ComponentName;
import android.graphics.Rect;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.common.internal.zzaj;
import com.google.android.gms.common.internal.zzj;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import com.transsion.hubsdk.api.app.TranRootTaskInfo;
import com.transsion.kolun.data.KolunTrackingEvent;
import com.transsion.kolun.kolunscanner.parcelablebean.CustomWifiConfiguration;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanBLEAudioSupport;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanBatteryInfo;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanBoxAndEarbudsStatus;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanBroadcastAndPairState;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanColorInfo;
import com.transsion.kolun.kolunscanner.parcelablebean.TwsBleScanFirmwareVersion;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import java.util.ArrayList;
import k3.pd;
import k3.qd;
import kotlin.jvm.internal.Intrinsics;
import org.appspot.transsion.aiot.aidl.IBluetoothBean;
import org.appspot.transsion.aiot.aidl.IProxiInterDevice;
import org.appspot.transsion.aiot.aidl.IQRParameter;
import org.appspot.transsion.aiot.aidl.Message;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9575a;

    public /* synthetic */ b(int i8) {
        this.f9575a = i8;
    }

    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        int i10 = getServiceRequest.f1849a;
        qd.k(parcel, 1, 4);
        parcel.writeInt(i10);
        qd.k(parcel, 2, 4);
        parcel.writeInt(getServiceRequest.f1850b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(getServiceRequest.f1851c);
        qd.e(parcel, 4, getServiceRequest.f1852d);
        qd.c(parcel, 5, getServiceRequest.e);
        qd.g(parcel, 6, getServiceRequest.f1853h, i8);
        qd.a(parcel, 7, getServiceRequest.f1854i);
        qd.d(parcel, 8, getServiceRequest.f1855j, i8);
        qd.g(parcel, 10, getServiceRequest.f1856k, i8);
        qd.g(parcel, 11, getServiceRequest.f1857l, i8);
        qd.k(parcel, 12, 4);
        parcel.writeInt(getServiceRequest.f1858m ? 1 : 0);
        qd.k(parcel, 13, 4);
        parcel.writeInt(getServiceRequest.f1859n);
        boolean z2 = getServiceRequest.f1860o;
        qd.k(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        qd.e(parcel, 15, getServiceRequest.p);
        qd.j(parcel, i9);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f9575a) {
            case 0:
                TranRootTaskInfo tranRootTaskInfo = new TranRootTaskInfo();
                tranRootTaskInfo.f2341c = new Rect();
                tranRootTaskInfo.f2339a = parcel.readString();
                tranRootTaskInfo.f2340b = ComponentName.readFromParcel(parcel);
                Parcelable.Creator creator = Rect.CREATOR;
                tranRootTaskInfo.f2341c = (Rect) parcel.readTypedObject(creator);
                tranRootTaskInfo.f2342d = parcel.createIntArray();
                tranRootTaskInfo.e = parcel.createStringArray();
                tranRootTaskInfo.f2343h = (Rect[]) parcel.createTypedArray(creator);
                tranRootTaskInfo.f2344i = parcel.createIntArray();
                tranRootTaskInfo.f2345j = parcel.readInt() > 0;
                tranRootTaskInfo.f2346k = parcel.readInt();
                tranRootTaskInfo.f2347l = parcel.readInt();
                tranRootTaskInfo.f2348m = parcel.readInt();
                return tranRootTaskInfo;
            case 1:
                return new KolunTrackingEvent(parcel);
            case 2:
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Intrinsics.checkNotNullParameter(Parcelable.class, "clazz");
                Intrinsics.checkNotNullParameter(Parcelable.class, "deviceClass");
                Object parcelable = parcel.readParcelable(Parcelable.class.getClassLoader(), Parcelable.class);
                Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type T of com.welink.protocol.nfbd.NearDeviceDataParcel");
                return new NearDeviceDataParcel(parcelable, (Parcelable) parcel.readParcelable(Parcelable.class.getClassLoader(), Parcelable.class));
            case 3:
                int iS = pd.s(parcel);
                int iN = 0;
                int iN2 = 0;
                Uri uri = null;
                int iN3 = 0;
                while (parcel.dataPosition() < iS) {
                    int i8 = parcel.readInt();
                    char c9 = (char) i8;
                    if (c9 == 1) {
                        iN = pd.n(parcel, i8);
                    } else if (c9 == 2) {
                        uri = (Uri) pd.e(parcel, i8, Uri.CREATOR);
                    } else if (c9 == 3) {
                        iN3 = pd.n(parcel, i8);
                    } else if (c9 != 4) {
                        pd.r(parcel, i8);
                    } else {
                        iN2 = pd.n(parcel, i8);
                    }
                }
                pd.j(parcel, iS);
                return new WebImage(iN, uri, iN3, iN2);
            case 4:
                AppIdData appIdData = new AppIdData();
                appIdData.e = new ArrayList();
                appIdData.f2313a = parcel.readInt();
                appIdData.f2314b = parcel.readString();
                return appIdData;
            case 5:
                TrackData trackData = new TrackData();
                trackData.f2319b = 0;
                trackData.f2320c = 1.0f;
                try {
                    trackData.f2319b = parcel.readInt();
                    trackData.f2318a = new JSONObject(parcel.readString());
                    trackData.f2320c = parcel.readFloat();
                    break;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return trackData;
            case 6:
                TrackDataWrapper trackDataWrapper = new TrackDataWrapper();
                trackDataWrapper.f2321a = parcel.readString();
                trackDataWrapper.f2322b = (TrackData) parcel.readParcelable(TrackData.class.getClassLoader());
                trackDataWrapper.f2323c = parcel.readLong();
                return trackDataWrapper;
            case 7:
                IBluetoothBean iBluetoothBean = new IBluetoothBean();
                iBluetoothBean.f8578h = false;
                iBluetoothBean.f8574a = parcel.readString();
                iBluetoothBean.f8575b = parcel.readString();
                iBluetoothBean.f8576c = parcel.readString();
                iBluetoothBean.f8577d = parcel.readBoolean();
                iBluetoothBean.e = parcel.readInt();
                iBluetoothBean.f8578h = parcel.readBoolean();
                return iBluetoothBean;
            case 8:
                return new IProxiInterDevice(parcel);
            case 9:
                IQRParameter iQRParameter = new IQRParameter();
                iQRParameter.f8599a = parcel.readString();
                iQRParameter.f8600b = parcel.readString();
                iQRParameter.f8601c = parcel.readString();
                iQRParameter.f8602d = parcel.readString();
                iQRParameter.e = parcel.readInt();
                iQRParameter.f8603h = parcel.readInt();
                iQRParameter.f8604i = parcel.readInt();
                iQRParameter.f8605j = parcel.readInt();
                iQRParameter.f8606k = parcel.readInt();
                iQRParameter.f8607l = parcel.readString();
                iQRParameter.f8608m = parcel.readInt();
                iQRParameter.f8609n = parcel.readInt();
                iQRParameter.f8610o = parcel.readString();
                iQRParameter.p = parcel.readInt();
                iQRParameter.q = parcel.readLong();
                return iQRParameter;
            case 10:
                Message message = new Message();
                int iDataPosition = parcel.dataPosition();
                int i9 = parcel.readInt();
                try {
                    if (i9 < 4) {
                        throw new BadParcelableException("Parcelable too small");
                    }
                    if (parcel.dataPosition() - iDataPosition < i9) {
                        message.f8611a = parcel.readString();
                        if (parcel.dataPosition() - iDataPosition < i9) {
                            message.f8612b = parcel.readString();
                            if (parcel.dataPosition() - iDataPosition < i9) {
                                message.f8613c = parcel.readInt();
                                if (parcel.dataPosition() - iDataPosition < i9) {
                                    message.f8614d = parcel.readLong();
                                    if (iDataPosition > Integer.MAX_VALUE - i9) {
                                        throw new BadParcelableException("Overflow in the size of parcelable");
                                    }
                                } else if (iDataPosition > Integer.MAX_VALUE - i9) {
                                    throw new BadParcelableException("Overflow in the size of parcelable");
                                }
                            } else if (iDataPosition > Integer.MAX_VALUE - i9) {
                                throw new BadParcelableException("Overflow in the size of parcelable");
                            }
                        } else if (iDataPosition > Integer.MAX_VALUE - i9) {
                            throw new BadParcelableException("Overflow in the size of parcelable");
                        }
                    } else if (iDataPosition > Integer.MAX_VALUE - i9) {
                        throw new BadParcelableException("Overflow in the size of parcelable");
                    }
                    parcel.setDataPosition(iDataPosition + i9);
                    return message;
                } catch (Throwable th2) {
                    if (iDataPosition > Integer.MAX_VALUE - i9) {
                        throw new BadParcelableException("Overflow in the size of parcelable");
                    }
                    parcel.setDataPosition(iDataPosition + i9);
                    throw th2;
                }
            case 11:
                int iS2 = pd.s(parcel);
                int iN4 = 0;
                String strF = null;
                while (parcel.dataPosition() < iS2) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        iN4 = pd.n(parcel, i10);
                    } else if (c10 != 2) {
                        pd.r(parcel, i10);
                    } else {
                        strF = pd.f(parcel, i10);
                    }
                }
                pd.j(parcel, iS2);
                return new ClientIdentity(iN4, strF);
            case 12:
                int iS3 = pd.s(parcel);
                int iN5 = 0;
                ArrayList arrayListI = null;
                while (parcel.dataPosition() < iS3) {
                    int i11 = parcel.readInt();
                    char c11 = (char) i11;
                    if (c11 == 1) {
                        iN5 = pd.n(parcel, i11);
                    } else if (c11 != 2) {
                        pd.r(parcel, i11);
                    } else {
                        arrayListI = pd.i(parcel, i11, MethodInvocation.CREATOR);
                    }
                }
                pd.j(parcel, iS3);
                return new TelemetryData(iN5, arrayListI);
            case 13:
                int iS4 = pd.s(parcel);
                int iN6 = 0;
                int iN7 = 0;
                int iN8 = 0;
                int iN9 = 0;
                long jO = 0;
                long jO2 = 0;
                String strF2 = null;
                String strF3 = null;
                int iN10 = -1;
                while (parcel.dataPosition() < iS4) {
                    int i12 = parcel.readInt();
                    switch ((char) i12) {
                        case 1:
                            iN6 = pd.n(parcel, i12);
                            break;
                        case 2:
                            iN7 = pd.n(parcel, i12);
                            break;
                        case 3:
                            iN8 = pd.n(parcel, i12);
                            break;
                        case 4:
                            jO = pd.o(parcel, i12);
                            break;
                        case 5:
                            jO2 = pd.o(parcel, i12);
                            break;
                        case 6:
                            strF2 = pd.f(parcel, i12);
                            break;
                        case 7:
                            strF3 = pd.f(parcel, i12);
                            break;
                        case '\b':
                            iN9 = pd.n(parcel, i12);
                            break;
                        case '\t':
                            iN10 = pd.n(parcel, i12);
                            break;
                        default:
                            pd.r(parcel, i12);
                            break;
                    }
                }
                pd.j(parcel, iS4);
                return new MethodInvocation(iN6, iN7, iN8, jO, jO2, strF2, strF3, iN9, iN10);
            case 14:
                int iS5 = pd.s(parcel);
                int iN11 = 0;
                Account account = null;
                GoogleSignInAccount googleSignInAccount = null;
                int iN12 = 0;
                while (parcel.dataPosition() < iS5) {
                    int i13 = parcel.readInt();
                    char c12 = (char) i13;
                    if (c12 == 1) {
                        iN11 = pd.n(parcel, i13);
                    } else if (c12 == 2) {
                        account = (Account) pd.e(parcel, i13, Account.CREATOR);
                    } else if (c12 == 3) {
                        iN12 = pd.n(parcel, i13);
                    } else if (c12 != 4) {
                        pd.r(parcel, i13);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) pd.e(parcel, i13, GoogleSignInAccount.CREATOR);
                    }
                }
                pd.j(parcel, iS5);
                return new zat(iN11, account, iN12, googleSignInAccount);
            case 15:
                int iS6 = pd.s(parcel);
                int iN13 = 0;
                boolean zK = false;
                boolean zK2 = false;
                IBinder iBinderM = null;
                ConnectionResult connectionResult = null;
                while (parcel.dataPosition() < iS6) {
                    int i14 = parcel.readInt();
                    char c13 = (char) i14;
                    if (c13 == 1) {
                        iN13 = pd.n(parcel, i14);
                    } else if (c13 == 2) {
                        iBinderM = pd.m(parcel, i14);
                    } else if (c13 == 3) {
                        connectionResult = (ConnectionResult) pd.e(parcel, i14, ConnectionResult.CREATOR);
                    } else if (c13 == 4) {
                        zK = pd.k(parcel, i14);
                    } else if (c13 != 5) {
                        pd.r(parcel, i14);
                    } else {
                        zK2 = pd.k(parcel, i14);
                    }
                }
                pd.j(parcel, iS6);
                return new zav(iN13, iBinderM, connectionResult, zK, zK2);
            case 16:
                int iS7 = pd.s(parcel);
                int iN14 = 0;
                int iN15 = 0;
                Scope[] scopeArr = null;
                int iN16 = 0;
                while (parcel.dataPosition() < iS7) {
                    int i15 = parcel.readInt();
                    char c14 = (char) i15;
                    if (c14 == 1) {
                        iN14 = pd.n(parcel, i15);
                    } else if (c14 == 2) {
                        iN16 = pd.n(parcel, i15);
                    } else if (c14 == 3) {
                        iN15 = pd.n(parcel, i15);
                    } else if (c14 != 4) {
                        pd.r(parcel, i15);
                    } else {
                        scopeArr = (Scope[]) pd.h(parcel, i15, Scope.CREATOR);
                    }
                }
                pd.j(parcel, iS7);
                return new zax(iN14, iN16, iN15, scopeArr);
            case 17:
                int iS8 = pd.s(parcel);
                int iN17 = 0;
                int iN18 = 0;
                int iN19 = 0;
                boolean zK3 = false;
                boolean zK4 = false;
                while (parcel.dataPosition() < iS8) {
                    int i16 = parcel.readInt();
                    char c15 = (char) i16;
                    if (c15 == 1) {
                        iN17 = pd.n(parcel, i16);
                    } else if (c15 == 2) {
                        zK3 = pd.k(parcel, i16);
                    } else if (c15 == 3) {
                        zK4 = pd.k(parcel, i16);
                    } else if (c15 == 4) {
                        iN18 = pd.n(parcel, i16);
                    } else if (c15 != 5) {
                        pd.r(parcel, i16);
                    } else {
                        iN19 = pd.n(parcel, i16);
                    }
                }
                pd.j(parcel, iS8);
                return new RootTelemetryConfiguration(iN17, iN18, iN19, zK3, zK4);
            case 18:
                int iS9 = pd.s(parcel);
                int iN20 = 0;
                while (parcel.dataPosition() < iS9) {
                    int i17 = parcel.readInt();
                    if (((char) i17) != 1) {
                        pd.r(parcel, i17);
                    } else {
                        iN20 = pd.n(parcel, i17);
                    }
                }
                pd.j(parcel, iS9);
                return new zzaj(iN20);
            case 19:
                BinderWrapper binderWrapper = new BinderWrapper();
                binderWrapper.f1840a = parcel.readStrongBinder();
                return binderWrapper;
            case 20:
                int iS10 = pd.s(parcel);
                Bundle bundleB = null;
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                int iN21 = 0;
                Feature[] featureArr = null;
                while (parcel.dataPosition() < iS10) {
                    int i18 = parcel.readInt();
                    char c16 = (char) i18;
                    if (c16 == 1) {
                        bundleB = pd.b(parcel, i18);
                    } else if (c16 == 2) {
                        featureArr = (Feature[]) pd.h(parcel, i18, Feature.CREATOR);
                    } else if (c16 == 3) {
                        iN21 = pd.n(parcel, i18);
                    } else if (c16 != 4) {
                        pd.r(parcel, i18);
                    } else {
                        connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) pd.e(parcel, i18, ConnectionTelemetryConfiguration.CREATOR);
                    }
                }
                pd.j(parcel, iS10);
                zzj zzjVar = new zzj();
                zzjVar.f1908a = bundleB;
                zzjVar.f1909b = featureArr;
                zzjVar.f1910c = iN21;
                zzjVar.f1911d = connectionTelemetryConfiguration;
                return zzjVar;
            case 21:
                int iS11 = pd.s(parcel);
                RootTelemetryConfiguration rootTelemetryConfiguration = null;
                int[] iArrD = null;
                int[] iArrD2 = null;
                boolean zK5 = false;
                boolean zK6 = false;
                int iN22 = 0;
                while (parcel.dataPosition() < iS11) {
                    int i19 = parcel.readInt();
                    switch ((char) i19) {
                        case 1:
                            rootTelemetryConfiguration = (RootTelemetryConfiguration) pd.e(parcel, i19, RootTelemetryConfiguration.CREATOR);
                            break;
                        case 2:
                            zK5 = pd.k(parcel, i19);
                            break;
                        case 3:
                            zK6 = pd.k(parcel, i19);
                            break;
                        case 4:
                            iArrD = pd.d(parcel, i19);
                            break;
                        case 5:
                            iN22 = pd.n(parcel, i19);
                            break;
                        case 6:
                            iArrD2 = pd.d(parcel, i19);
                            break;
                        default:
                            pd.r(parcel, i19);
                            break;
                    }
                }
                pd.j(parcel, iS11);
                return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zK5, zK6, iArrD, iN22, iArrD2);
            case 22:
                int iS12 = pd.s(parcel);
                Scope[] scopeArr2 = GetServiceRequest.q;
                Bundle bundle = new Bundle();
                Feature[] featureArr2 = GetServiceRequest.f1848r;
                Feature[] featureArr3 = featureArr2;
                int iN23 = 0;
                int iN24 = 0;
                int iN25 = 0;
                boolean zK7 = false;
                int iN26 = 0;
                boolean zK8 = false;
                String strF4 = null;
                IBinder iBinderM2 = null;
                Account account2 = null;
                String strF5 = null;
                while (parcel.dataPosition() < iS12) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            iN23 = pd.n(parcel, i20);
                            break;
                        case 2:
                            iN24 = pd.n(parcel, i20);
                            break;
                        case 3:
                            iN25 = pd.n(parcel, i20);
                            break;
                        case 4:
                            strF4 = pd.f(parcel, i20);
                            break;
                        case 5:
                            iBinderM2 = pd.m(parcel, i20);
                            break;
                        case 6:
                            scopeArr2 = (Scope[]) pd.h(parcel, i20, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = pd.b(parcel, i20);
                            break;
                        case '\b':
                            account2 = (Account) pd.e(parcel, i20, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            pd.r(parcel, i20);
                            break;
                        case '\n':
                            featureArr2 = (Feature[]) pd.h(parcel, i20, Feature.CREATOR);
                            break;
                        case 11:
                            featureArr3 = (Feature[]) pd.h(parcel, i20, Feature.CREATOR);
                            break;
                        case '\f':
                            zK7 = pd.k(parcel, i20);
                            break;
                        case '\r':
                            iN26 = pd.n(parcel, i20);
                            break;
                        case 14:
                            zK8 = pd.k(parcel, i20);
                            break;
                        case 15:
                            strF5 = pd.f(parcel, i20);
                            break;
                    }
                }
                pd.j(parcel, iS12);
                return new GetServiceRequest(iN23, iN24, iN25, strF4, iBinderM2, scopeArr2, bundle, account2, featureArr2, featureArr3, zK7, iN26, zK8, strF5);
            case 23:
                CustomWifiConfiguration customWifiConfiguration = new CustomWifiConfiguration();
                customWifiConfiguration.f2914a = parcel.readString();
                customWifiConfiguration.f2915b = parcel.readString();
                customWifiConfiguration.f2916c = parcel.readInt();
                customWifiConfiguration.f2917d = parcel.readString();
                customWifiConfiguration.e = parcel.readString();
                return customWifiConfiguration;
            case 24:
                TwsBleScanBLEAudioSupport twsBleScanBLEAudioSupport = new TwsBleScanBLEAudioSupport();
                twsBleScanBLEAudioSupport.f2918a = parcel.readByte() != 0;
                return twsBleScanBLEAudioSupport;
            case 25:
                TwsBleScanBatteryInfo twsBleScanBatteryInfo = new TwsBleScanBatteryInfo();
                twsBleScanBatteryInfo.f2919a = parcel.readInt();
                twsBleScanBatteryInfo.f2920b = parcel.readInt();
                twsBleScanBatteryInfo.f2921c = parcel.readInt();
                return twsBleScanBatteryInfo;
            case 26:
                TwsBleScanBoxAndEarbudsStatus twsBleScanBoxAndEarbudsStatus = new TwsBleScanBoxAndEarbudsStatus();
                twsBleScanBoxAndEarbudsStatus.f2922a = parcel.readByte() != 0;
                twsBleScanBoxAndEarbudsStatus.f2923b = parcel.readByte() != 0;
                twsBleScanBoxAndEarbudsStatus.f2924c = parcel.readByte() != 0;
                twsBleScanBoxAndEarbudsStatus.f2925d = parcel.readByte() != 0;
                twsBleScanBoxAndEarbudsStatus.e = parcel.readByte() != 0;
                return twsBleScanBoxAndEarbudsStatus;
            case 27:
                TwsBleScanBroadcastAndPairState twsBleScanBroadcastAndPairState = new TwsBleScanBroadcastAndPairState();
                twsBleScanBroadcastAndPairState.f2926a = parcel.readByte() != 0;
                twsBleScanBroadcastAndPairState.f2927b = parcel.readByte() != 0;
                twsBleScanBroadcastAndPairState.f2928c = parcel.readByte() != 0;
                return twsBleScanBroadcastAndPairState;
            case 28:
                TwsBleScanColorInfo twsBleScanColorInfo = new TwsBleScanColorInfo();
                twsBleScanColorInfo.f2929a = parcel.readInt();
                return twsBleScanColorInfo;
            default:
                TwsBleScanFirmwareVersion twsBleScanFirmwareVersion = new TwsBleScanFirmwareVersion();
                twsBleScanFirmwareVersion.f2930a = parcel.readString();
                return twsBleScanFirmwareVersion;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        switch (this.f9575a) {
            case 0:
                return new TranRootTaskInfo[i8];
            case 1:
                return new KolunTrackingEvent[i8];
            case 2:
                return new NearDeviceDataParcel[i8];
            case 3:
                return new WebImage[i8];
            case 4:
                return new AppIdData[i8];
            case 5:
                return new TrackData[i8];
            case 6:
                return new TrackDataWrapper[i8];
            case 7:
                return new IBluetoothBean[i8];
            case 8:
                return new IProxiInterDevice[i8];
            case 9:
                return new IQRParameter[i8];
            case 10:
                return new Message[i8];
            case 11:
                return new ClientIdentity[i8];
            case 12:
                return new TelemetryData[i8];
            case 13:
                return new MethodInvocation[i8];
            case 14:
                return new zat[i8];
            case 15:
                return new zav[i8];
            case 16:
                return new zax[i8];
            case 17:
                return new RootTelemetryConfiguration[i8];
            case 18:
                return new zzaj[i8];
            case 19:
                return new BinderWrapper[i8];
            case 20:
                return new zzj[i8];
            case 21:
                return new ConnectionTelemetryConfiguration[i8];
            case 22:
                return new GetServiceRequest[i8];
            case 23:
                return new CustomWifiConfiguration[i8];
            case 24:
                return new TwsBleScanBLEAudioSupport[i8];
            case 25:
                return new TwsBleScanBatteryInfo[i8];
            case 26:
                return new TwsBleScanBoxAndEarbudsStatus[i8];
            case 27:
                return new TwsBleScanBroadcastAndPairState[i8];
            case 28:
                return new TwsBleScanColorInfo[i8];
            default:
                return new TwsBleScanFirmwareVersion[i8];
        }
    }
}
