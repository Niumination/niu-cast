package h3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import xa.i;

/* JADX INFO: loaded from: classes.dex */
public class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5242a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Looper looper, int i8) {
        super(looper);
        this.f5242a = i8;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        switch (this.f5242a) {
            case 4:
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                if (msg.what == 10001) {
                    Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                    Intrinsics.checkNotNullParameter("传输文件超时了,文件已被取消", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("FileTransferProcessor"), "传输文件超时了,文件已被取消");
                    }
                    s7.d dVar = i.f10899k;
                    if (dVar != null) {
                        dVar.d();
                    }
                    i.c(null, false, 3);
                }
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Looper looper, Handler.Callback callback, int i8) {
        super(looper, callback);
        this.f5242a = i8;
    }
}
