package we;

import android.content.Context;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1 f10730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f10731b;

    public k(boolean z2, Function1 creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.f10730a = creator;
    }

    public Object a(Context context, Object obj) {
        return b(new Pair(context, obj));
    }

    public final Object b(Object obj) {
        Object objInvoke;
        Object obj2 = this.f10731b;
        if (obj2 != null) {
            return obj2;
        }
        synchronized (this) {
            objInvoke = this.f10731b;
            if (objInvoke == null) {
                Function1 function1 = this.f10730a;
                Intrinsics.checkNotNull(function1);
                objInvoke = function1.invoke(obj);
                this.f10731b = objInvoke;
                this.f10730a = null;
            }
        }
        return objInvoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Function1 creator) {
        this(false, creator);
        Intrinsics.checkNotNullParameter(creator, "creator");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Function2 creator) {
        this(false, new j(creator));
        Intrinsics.checkNotNullParameter(creator, "creator");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Function3 creator) {
        this(false, new j(creator));
        Intrinsics.checkNotNullParameter(creator, "creator");
    }
}
