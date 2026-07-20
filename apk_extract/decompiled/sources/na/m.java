package na;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import bb.s;
import com.transsion.tranradionet.TranRadioNetManager;
import k3.gc;
import k3.pb;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8145b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f8144a = LazyKt.lazy(new s(28));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TranRadioNetManager f8146c = new TranRadioNetManager(pb.a());

    public static Integer a(String cmd) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        if (b() == null) {
            TranRadioNetManager tranRadioNetManager = f8146c;
            if (tranRadioNetManager.isServiceConnected()) {
                Intrinsics.checkNotNullParameter("TranNetApiProxy", "tag");
                Intrinsics.checkNotNullParameter("dispatchNetCmd with New TranNet", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("TranNetApiProxy"), "dispatchNetCmd with New TranNet");
                }
                return Integer.valueOf(tranRadioNetManager.dispatchNetCmd(cmd));
            }
            Intrinsics.checkNotNullParameter("TranNetApiProxy", "tag");
            Intrinsics.checkNotNullParameter("dispatchNetCmd Err", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("TranNetApiProxy"), "dispatchNetCmd Err");
            }
            return null;
        }
        Intrinsics.checkNotNullParameter("TranNetApiProxy", "tag");
        Intrinsics.checkNotNullParameter("dispatchNetCmd with TranNet", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranNetApiProxy"), "dispatchNetCmd with TranNet");
        }
        rk.c cVarB = b();
        if (cVarB == null) {
            return null;
        }
        rk.a aVar = (rk.a) cVarB;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(rk.c.f9444a);
            parcelObtain.writeString(cmd);
            if (!aVar.f9442b.transact(1, parcelObtain, parcelObtain2, 0)) {
                throw new RemoteException("Method dispatchNetCmd is unimplemented.");
            }
            parcelObtain2.readException();
            int i8 = parcelObtain2.readInt();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return Integer.valueOf(i8);
        } catch (Throwable th2) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th2;
        }
    }

    public static rk.c b() {
        return (rk.c) f8144a.getValue();
    }

    public static void c() {
        boolean zConnectService = f8146c.connectService(new Handler(Looper.getMainLooper()), PointerIconCompat.TYPE_TEXT);
        f8145b = zConnectService;
        String strO = o.d.o("init supportNewTranNet:", zConnectService, "TranNetApiProxy", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranNetApiProxy"), strO);
        }
    }

    public static void d(String type, String enable) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(enable, "enable");
        if (b() == null) {
            TranRadioNetManager tranRadioNetManager = f8146c;
            if (tranRadioNetManager.isServiceConnected()) {
                tranRadioNetManager.setProcSysNet(4, 1, type, "proxy_arp", enable);
                return;
            }
            return;
        }
        rk.c cVarB = b();
        if (cVarB != null) {
            rk.a aVar = (rk.a) cVarB;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(rk.c.f9444a);
                parcelObtain.writeInt(4);
                parcelObtain.writeInt(1);
                parcelObtain.writeString(type);
                parcelObtain.writeString("proxy_arp");
                parcelObtain.writeString(enable);
                if (!aVar.f9442b.transact(3, parcelObtain, parcelObtain2, 0)) {
                    throw new RemoteException("Method setProcSysNet is unimplemented.");
                }
                parcelObtain2.readException();
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th2) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th2;
            }
        }
    }
}
