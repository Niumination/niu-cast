package s7;

import android.util.Log;
import com.transsion.connectx.sdk.FileInfo;
import com.transsion.connectx.sdk.FileInfoSyncRequest;
import com.transsion.connectx.sdk.TCCPSourceApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import q7.h;
import x7.e;
import x7.f;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements o7.c {
    @Override // o7.c
    public final void a() {
    }

    @Override // o7.c
    public final void b(q7.a capabilityBean, Map map) {
        Intrinsics.checkNotNullParameter(capabilityBean, "capabilityBean");
    }

    public final Unit c(String str) {
        h hVar = (h) na.b.a(str, h.class);
        String log = "CastSourceFileTransfer:sendFileInfo:fileInfoBean" + hVar;
        Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CastSourceFileTransfer"), log);
        }
        if (hVar != null) {
            String strB = na.b.b(hVar.getFileInfoList());
            ArrayList arrayList = new ArrayList();
            Iterator it = na.b.c(FileInfo[].class, strB).iterator();
            while (it.hasNext()) {
                arrayList.add((FileInfo) it.next());
            }
            String log2 = "CastSourceFileTransfer:sendFileInfo:newFileInfoList" + arrayList;
            Intrinsics.checkNotNullParameter("CastSourceFileTransfer", "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("CastSourceFileTransfer"), log2);
            }
            TCCPSourceApi tCCPSourceApi = f.f10882a;
            FileInfoSyncRequest fileInfoSyncRequest = new FileInfoSyncRequest(arrayList, hVar.getPackageName(), hVar.getType());
            Intrinsics.checkNotNullParameter(fileInfoSyncRequest, "fileInfoSyncRequest");
            Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
            Intrinsics.checkNotNullParameter("syncFileInfoRequest", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectSdkProxy"), "syncFileInfoRequest");
            }
            l0.p(f.f10884c, null, null, new e(fileInfoSyncRequest, null), 3);
        }
        return Unit.INSTANCE;
    }

    public final void d() {
        TCCPSourceApi tCCPSourceApi = f.f10882a;
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("cancelFileTransfer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "cancelFileTransfer");
        }
        f.f10882a.cancelFileTransfer();
    }

    @Override // o7.c
    public final void start() {
    }
}
