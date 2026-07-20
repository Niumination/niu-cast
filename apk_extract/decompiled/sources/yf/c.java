package yf;

import bh.d;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import qg.y0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f11199a = new d();

    public final void a(a definition, Object obj) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        fh.a aVar = (fh.a) this.f11199a.b(definition);
        Throwable th2 = null;
        if (aVar != null) {
            Object objC = aVar.c();
            Intrinsics.checkNotNull(objC, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            for (fh.c cVarD = (fh.c) objC; !Intrinsics.areEqual(cVarD, aVar); cVarD = cVarD.d()) {
                if (cVarD instanceof b) {
                    try {
                        Function1 function1 = ((b) cVarD).f11198d;
                        Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<T of io.ktor.events.Events.raise, kotlin.Unit>");
                        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(obj);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt.addSuppressed(th2, th3);
                        } else {
                            th2 = th3;
                        }
                    }
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }

    public final void b(a definition, Function1 handler) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ((fh.a) this.f11199a.a(definition, new y0(24))).a(new b(handler));
    }
}
