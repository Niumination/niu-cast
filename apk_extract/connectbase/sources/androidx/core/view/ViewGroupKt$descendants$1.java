package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import gq.o;
import jn.p;
import kn.r1;
import lm.l2;
import os.l;
import os.m;
import um.d;
import xm.f;
import xm.k;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nViewGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewGroup.kt\nandroidx/core/view/ViewGroupKt$descendants$1\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,175:1\n55#2,4:176\n*S KotlinDebug\n*F\n+ 1 ViewGroup.kt\nandroidx/core/view/ViewGroupKt$descendants$1\n*L\n118#1:176,4\n*E\n"})
@f(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {y5.a.f20730l0, 121}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "index$iv", "$this$sequence", "$this$forEach$iv", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
public final class ViewGroupKt$descendants$1 extends k implements p<o<? super View>, d<? super l2>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroupKt$descendants$1(ViewGroup viewGroup, d<? super ViewGroupKt$descendants$1> dVar) {
        super(2, dVar);
        this.$this_descendants = viewGroup;
    }

    @Override // xm.a
    @l
    public final d<l2> create(@m Object obj, @l d<?> dVar) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, dVar);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    @Override // jn.p
    @m
    public final Object invoke(@l o<? super View> oVar, @m d<? super l2> dVar) {
        return ((ViewGroupKt$descendants$1) create(oVar, dVar)).invokeSuspend(l2.f10208a);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004a  */
    /* JADX WARN: Code duplicated, block: B:14:0x0065 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0066  */
    /* JADX WARN: Code duplicated, block: B:18:0x006f  */
    /* JADX WARN: Code duplicated, block: B:20:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0089  */
    /* JADX WARN: Code duplicated, block: B:23:0x0090  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0089 -> B:22:0x008b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0090 -> B:24:0x0092). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // xm.a
    @os.m
    public final java.lang.Object invokeSuspend(@os.l java.lang.Object r10) {
        /*
            r9 = this;
            wm.a r0 = wm.a.COROUTINE_SUSPENDED
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            int r1 = r9.I$1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$1
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            java.lang.Object r6 = r9.L$0
            gq.o r6 = (gq.o) r6
            lm.d1.n(r10)
            goto L8b
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L25:
            int r1 = r9.I$1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$2
            android.view.View r5 = (android.view.View) r5
            java.lang.Object r6 = r9.L$1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.lang.Object r7 = r9.L$0
            gq.o r7 = (gq.o) r7
            lm.d1.n(r10)
            r10 = r7
            goto L6b
        L3a:
            lm.d1.n(r10)
            java.lang.Object r10 = r9.L$0
            gq.o r10 = (gq.o) r10
            android.view.ViewGroup r1 = r9.$this_descendants
            int r4 = r1.getChildCount()
            r5 = 0
        L48:
            if (r5 >= r4) goto L97
            android.view.View r6 = r1.getChildAt(r5)
            java.lang.String r7 = "getChildAt(index)"
            kn.l0.o(r6, r7)
            r9.L$0 = r10
            r9.L$1 = r1
            r9.L$2 = r6
            r9.I$0 = r5
            r9.I$1 = r4
            r9.label = r3
            java.lang.Object r7 = r10.a(r6, r9)
            if (r7 != r0) goto L66
            return r0
        L66:
            r8 = r6
            r6 = r1
            r1 = r4
            r4 = r5
            r5 = r8
        L6b:
            boolean r7 = r5 instanceof android.view.ViewGroup
            if (r7 == 0) goto L90
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            gq.m r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r9.L$0 = r10
            r9.L$1 = r6
            r7 = 0
            r9.L$2 = r7
            r9.I$0 = r4
            r9.I$1 = r1
            r9.label = r2
            java.lang.Object r5 = r10.f(r5, r9)
            if (r5 != r0) goto L89
            return r0
        L89:
            r5 = r6
            r6 = r10
        L8b:
            r10 = r6
            r8 = r5
            r5 = r1
            r1 = r8
            goto L92
        L90:
            r5 = r1
            r1 = r6
        L92:
            int r4 = r4 + r3
            r8 = r5
            r5 = r4
            r4 = r8
            goto L48
        L97:
            lm.l2 r9 = lm.l2.f10208a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewGroupKt$descendants$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
