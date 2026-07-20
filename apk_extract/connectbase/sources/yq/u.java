package yq;

import kn.r1;
import lm.l2;
import nq.a2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nWhileSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,33:1\n55#2,8:34\n*S KotlinDebug\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n*L\n31#1:34,8\n*E\n"})
public final class u {

    @r1({"SMAP\nWhileSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt$whileSelect$1\n*L\n1#1,33:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0}, l = {41}, m = "whileSelect", n = {"builder"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return u.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0055  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004a -> B:18:0x004d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    @nq.a2
    public static final java.lang.Object a(@os.l jn.l<? super yq.c<? super java.lang.Boolean>, lm.l2> r4, @os.l um.d<? super lm.l2> r5) {
        /*
            boolean r0 = r5 instanceof yq.u.a
            if (r0 == 0) goto L13
            r0 = r5
            yq.u$a r0 = (yq.u.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            yq.u$a r0 = new yq.u$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            jn.l r4 = (jn.l) r4
            lm.d1.n(r5)
            goto L4d
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            lm.d1.n(r5)
        L36:
            yq.l r5 = new yq.l
            um.g r2 = r0.getContext()
            r5.<init>(r2)
            r4.invoke(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = yq.l.z(r5, r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L36
            lm.l2 r4 = lm.l2.f10208a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: yq.u.a(jn.l, um.d):java.lang.Object");
    }

    @a2
    public static final Object b(jn.l<? super c<? super Boolean>, l2> lVar, um.d<? super l2> dVar) {
        throw null;
    }
}
