package bf;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import ze.q2;
import ze.r2;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements oi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f1290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ oi.i f1291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1293d;

    public q(Ref.BooleanRef booleanRef, oi.i iVar, String str, Object obj) {
        this.f1290a = booleanRef;
        this.f1291b = iVar;
        this.f1292c = str;
        this.f1293d = obj;
    }

    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) throws r2 {
        Ref.BooleanRef booleanRef = this.f1290a;
        if (!booleanRef.element) {
            booleanRef.element = true;
            Object objEmit = this.f1291b.emit(obj, continuation);
            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
        }
        throw new r2(q2.f11410m.h("Expected one " + this.f1292c + " for " + this.f1293d + " but received two"));
    }
}
