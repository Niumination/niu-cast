package ni;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f8306a = new v(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8307b = qi.g.j("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8308c = qi.g.j("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", ModuleDescriptor.MODULE_VERSION, 0, 0, 12);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a8.a f8309d = new a8.a("BUFFERED", 15);
    public static final a8.a e = new a8.a("SHOULD_BUFFER", 15);
    public static final a8.a f = new a8.a("S_RESUMING_BY_RCV", 15);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a8.a f8310g = new a8.a("RESUMING_BY_EB", 15);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a8.a f8311h = new a8.a("POISONED", 15);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a8.a f8312i = new a8.a("DONE_RCV", 15);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a8.a f8313j = new a8.a("INTERRUPTED_SEND", 15);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a8.a f8314k = new a8.a("INTERRUPTED_RCV", 15);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a8.a f8315l = new a8.a("CHANNEL_CLOSED", 15);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a8.a f8316m = new a8.a("SUSPEND", 15);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a8.a f8317n = new a8.a("SUSPEND_NO_WAITER", 15);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a8.a f8318o = new a8.a("FAILED", 15);
    public static final a8.a p = new a8.a("NO_RECEIVE_RESULT", 15);
    public static final a8.a q = new a8.a("CLOSE_HANDLER_CLOSED", 15);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a8.a f8319r = new a8.a("CLOSE_HANDLER_INVOKED", 15);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a8.a f8320s = new a8.a("NO_CLOSE_CAUSE", 15);

    public static final boolean a(li.j jVar, Object obj, Function3 function3) {
        a8.a aVarD = jVar.d(obj, function3);
        if (aVarD == null) {
            return false;
        }
        jVar.u(aVarD);
        return true;
    }
}
