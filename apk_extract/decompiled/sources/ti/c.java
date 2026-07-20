package ti;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import li.x0;
import qi.w;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3 f10221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f10222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a8.a f10223d;
    public final SuspendLambda e;
    public final Function3 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f10224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10225h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f10226i;

    public c(e eVar, Object obj, Function3 function3, Function3 function4, a8.a aVar, SuspendLambda suspendLambda, Function3 function5) {
        this.f10226i = eVar;
        this.f10220a = obj;
        this.f10221b = function3;
        this.f10222c = function4;
        this.f10223d = aVar;
        this.e = suspendLambda;
        this.f = function5;
    }

    public final void a() {
        Object obj = this.f10224g;
        if (obj instanceof w) {
            ((w) obj).h(this.f10225h, this.f10226i.f10228a);
            return;
        }
        x0 x0Var = obj instanceof x0 ? (x0) obj : null;
        if (x0Var != null) {
            x0Var.dispose();
        }
    }
}
