package li;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f7488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f7489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f7490d;
    public final Throwable e;

    public t(Object obj, i iVar, Function3 function3, Object obj2, Throwable th2) {
        this.f7487a = obj;
        this.f7488b = iVar;
        this.f7489c = function3;
        this.f7490d = obj2;
        this.e = th2;
    }

    public static t a(t tVar, i iVar, CancellationException cancellationException, int i8) {
        Object obj = tVar.f7487a;
        if ((i8 & 2) != 0) {
            iVar = tVar.f7488b;
        }
        i iVar2 = iVar;
        Function3 function3 = tVar.f7489c;
        Object obj2 = tVar.f7490d;
        Throwable th2 = cancellationException;
        if ((i8 & 16) != 0) {
            th2 = tVar.e;
        }
        tVar.getClass();
        return new t(obj, iVar2, function3, obj2, th2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Intrinsics.areEqual(this.f7487a, tVar.f7487a) && Intrinsics.areEqual(this.f7488b, tVar.f7488b) && Intrinsics.areEqual(this.f7489c, tVar.f7489c) && Intrinsics.areEqual(this.f7490d, tVar.f7490d) && Intrinsics.areEqual(this.e, tVar.e);
    }

    public final int hashCode() {
        Object obj = this.f7487a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f7488b;
        int iHashCode2 = (iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        Function3 function3 = this.f7489c;
        int iHashCode3 = (iHashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Object obj2 = this.f7490d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.e;
        return iHashCode4 + (th2 != null ? th2.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f7487a + ", cancelHandler=" + this.f7488b + ", onCancellation=" + this.f7489c + ", idempotentResume=" + this.f7490d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ t(Object obj, i iVar, Function3 function3, CancellationException cancellationException, int i8) {
        this(obj, (i8 & 2) != 0 ? null : iVar, (i8 & 4) != 0 ? null : function3, (Object) null, (i8 & 16) != 0 ? null : cancellationException);
    }
}
