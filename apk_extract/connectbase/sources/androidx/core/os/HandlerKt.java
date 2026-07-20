package androidx.core.os;

import android.os.Handler;
import jn.a;
import k4.f;
import kn.l0;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerKt {
    @l
    public static final Runnable postAtTime(@l Handler handler, long j10, @m Object obj, @l a<l2> aVar) {
        l0.p(handler, "<this>");
        l0.p(aVar, f.f8937e);
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(aVar);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j10);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j10, Object obj, a aVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        l0.p(handler, "<this>");
        l0.p(aVar, f.f8937e);
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(aVar);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j10);
        return handlerKt$postAtTime$runnable$1;
    }

    @l
    public static final Runnable postDelayed(@l Handler handler, long j10, @m Object obj, @l a<l2> aVar) {
        l0.p(handler, "<this>");
        l0.p(aVar, f.f8937e);
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(aVar);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j10);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j10);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j10, Object obj, a aVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        l0.p(handler, "<this>");
        l0.p(aVar, f.f8937e);
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(aVar);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j10);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j10);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
