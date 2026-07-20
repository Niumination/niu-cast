package ne;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.util.Log;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceInfo;
import df.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.lb;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import se.h5;
import se.r6;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends ScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f8194a;

    public e(f fVar) {
        this.f8194a = fVar;
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List list) {
        super.onBatchScanResults(list);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
            }
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int i8) {
        super.onScanFailed(i8);
        String strM = o.d.m("onScanFailed errorCode:", "BleScanTool", "tag", "mes", i8);
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", strM, "BleScanTool", null);
        }
        h5 h5Var = this.f8194a.f8200h;
        if (h5Var != null) {
            TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, i8, 0, null, 11, null, new TranConnectionController$EventInfo(11, (String) null, i8, 0, 0, 56), null);
            r6 r6Var = h5Var.e;
            if (r6Var != null) {
                r6Var.invoke(tranConnectionController$MessageInfo);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.welink.protocol.utils.DeviceInfo] */
    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int i8, ScanResult scanResult) {
        List list;
        super.onScanResult(i8, scanResult);
        f fVar = this.f8194a;
        if (scanResult == null) {
            fVar.getClass();
            return;
        }
        synchronized (fVar.f8202j) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? A = f.a(scanResult);
            objectRef.element = A;
            if (A == 0) {
                Intrinsics.checkNotNullParameter("BleScanTool", "tag");
                Intrinsics.checkNotNullParameter("deviceInfo is null, continue scan......", "mes");
                if (lb.f6529c >= 6) {
                    Log.wtf("BleScanTool", "TransConnect:deviceInfo is null, continue scan......", null);
                }
                return;
            }
            m mVar = fVar.e;
            if (mVar != null) {
                ArrayList arrayList = (ArrayList) mVar.f4460d;
                if (arrayList != null && !arrayList.contains(Byte.valueOf(A.f4220a))) {
                    return;
                }
                m mVar2 = fVar.e;
                if (mVar2 == null || mVar2.f4459c != -100) {
                    if (scanResult.getRssi() < (mVar2 != null ? mVar2.f4459c : -20)) {
                        return;
                    }
                }
                m mVar3 = fVar.e;
                if ((mVar3 != null ? (List) mVar3.f4458b : null) != null && ((mVar3 == null || (list = (List) mVar3.f4458b) == null || !list.contains(Byte.valueOf((byte) ((DeviceInfo) objectRef.element).f4226j))) && !fVar.e((DeviceInfo) objectRef.element))) {
                    return;
                }
                T t3 = objectRef.element;
                if (((DeviceInfo) t3).f4220a == 7 || ((DeviceInfo) t3).f4220a == 13) {
                    if (scanResult.getDevice() != null) {
                        String address = scanResult.getDevice().getAddress();
                        Context mContext = fVar.f8195a;
                        Intrinsics.checkNotNullParameter(mContext, "mContext");
                        fVar.f8201i = new oe.e(address, mContext);
                    }
                } else if ((((DeviceInfo) t3).f4220a == 0 || ((DeviceInfo) t3).f4220a == 1) && scanResult.getDevice() != null) {
                    String address2 = scanResult.getDevice().getAddress();
                    Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
                    Context mContext2 = fVar.f8195a;
                    Intrinsics.checkNotNullParameter(address2, "address");
                    Intrinsics.checkNotNullParameter(mContext2, "mContext");
                    new oe.d(address2, mContext2);
                }
                if (fVar.f8199g == null) {
                    h.j("BleScanTool", "mBleScanCallback is null");
                }
                lc.a aVar = fVar.f8199g;
                if (aVar != null) {
                    aVar.invoke(scanResult, objectRef.element);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
