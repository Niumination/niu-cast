package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import gq.o;
import jn.p;
import lm.d1;
import lm.l2;
import os.l;
import os.m;
import um.d;
import xm.f;
import xm.k;

/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {414, TypedValues.CycleType.TYPE_PATH_ROTATE}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
public final class ViewKt$allViews$1 extends k implements p<o<? super View>, d<? super l2>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, d<? super ViewKt$allViews$1> dVar) {
        super(2, dVar);
        this.$this_allViews = view;
    }

    @Override // xm.a
    @l
    public final d<l2> create(@m Object obj, @l d<?> dVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, dVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // jn.p
    @m
    public final Object invoke(@l o<? super View> oVar, @m d<? super l2> dVar) {
        return ((ViewKt$allViews$1) create(oVar, dVar)).invokeSuspend(l2.f10208a);
    }

    @Override // xm.a
    @m
    public final Object invokeSuspend(@l Object obj) {
        o oVar;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                oVar = (o) this.L$0;
                d1.n(obj);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
        d1.n(obj);
        oVar = (o) this.L$0;
        View view = this.$this_allViews;
        this.L$0 = oVar;
        this.label = 1;
        if (oVar.a(view, this) == aVar) {
            return aVar;
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            gq.m<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (oVar.f(descendants, this) == aVar) {
                return aVar;
            }
        }
        return l2.f10208a;
    }
}
