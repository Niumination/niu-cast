package f3;

import jn.p;
import lm.l2;
import nq.k;
import nq.s0;
import os.l;
import os.m;
import s2.d;
import um.g;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> implements z2.a<T>, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f5839a = d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5840b;

    /* JADX INFO: renamed from: f3.a$a, reason: collision with other inner class name */
    @f(c = "com.transsion.airtransfer.filetransfer.transmission.base.BaseDataReceiver$startReceiveLoop$1", f = "BaseDataReceiver.kt", i = {}, l = {21, 22}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0138a extends o implements p<s0, um.d<? super l2>, Object> {
        int label;
        final /* synthetic */ a<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0138a(a<T> aVar, um.d<? super C0138a> dVar) {
            super(2, dVar);
            this.this$0 = aVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new C0138a(this.this$0, dVar);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003b -> B:11:0x0024). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to f3.a$a for r4v3 'this'  um.d
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r5) {
            /*
                r4 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                lm.d1.n(r5)
                goto L24
            L10:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L18:
                lm.d1.n(r5)
                goto L33
            L1c:
                lm.d1.n(r5)
                f3.a<T> r5 = r4.this$0
                r1 = 0
                r5.f5840b = r1
            L24:
                f3.a<T> r5 = r4.this$0
                boolean r1 = r5.f5840b
                if (r1 != 0) goto L3e
                r4.label = r3
                java.lang.Object r5 = r5.b(r4)
                if (r5 != r0) goto L33
                return r0
            L33:
                f3.a<T> r1 = r4.this$0
                r4.label = r2
                java.lang.Object r5 = r1.f(r5, r4)
                if (r5 != r0) goto L24
                return r0
            L3e:
                lm.l2 r4 = lm.l2.f10208a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: f3.a.C0138a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((C0138a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @m
    public abstract Object f(T t10, @l um.d<? super l2> dVar);

    public final nq.l2 g() {
        return k.f(this, null, null, new C0138a(this, null), 3, null);
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f5839a.getCoroutineContext();
    }

    @m
    public Integer i() {
        return null;
    }

    @Override // z2.a
    public void start() {
        if (this.f5840b) {
            return;
        }
        g();
    }

    @Override // z2.a
    public void stop() {
        this.f5840b = true;
    }
}
