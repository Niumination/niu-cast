package b3;

import jn.p;
import kn.w;
import lm.l2;
import nq.k;
import nq.s0;
import nq.t0;
import os.l;
import os.m;
import s2.d;
import um.g;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T, R> implements y2.b<T, R>, s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final C0027a f721c = new C0027a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final String f722d = "BaseDataProcessor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f723a = d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f724b;

    /* JADX INFO: renamed from: b3.a$a, reason: collision with other inner class name */
    public static final class C0027a {
        public C0027a() {
        }

        public C0027a(w wVar) {
        }
    }

    @f(c = "com.transsion.airtransfer.filetransfer.process.base.BaseDataProcessor$receiveLoop$1", f = "BaseDataProcessor.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends o implements p<s0, um.d<? super l2>, Object> {
        int label;
        final /* synthetic */ a<T, R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a<T, R> aVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.this$0 = aVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new b(this.this$0, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0020  */
        /* JADX WARN: Code duplicated, block: B:13:0x002a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x002d  */
        /* JADX WARN: Code duplicated, block: B:16:0x002f  */
        /* JADX WARN: Code duplicated, block: B:18:0x0032  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0028 -> B:14:0x002b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x0020
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r4) {
            /*
                r3 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                lm.d1.n(r4)
                goto L2b
            Ld:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L15:
                lm.d1.n(r4)
            L18:
                b3.a<T, R> r4 = r3.this$0
                boolean r4 = b3.a.e(r4)
                if (r4 != 0) goto L38
                b3.a<T, R> r4 = r3.this$0
                r3.label = r2
                java.lang.Object r4 = r4.f(r3)
                if (r4 != r0) goto L2b
                return r0
            L2b:
                if (r4 != 0) goto L2f
                r1 = 0
                goto L30
            L2f:
                r1 = r4
            L30:
                if (r1 == 0) goto L18
                b3.a<T, R> r1 = r3.this$0
                r1.c(r4)
                goto L18
            L38:
                lm.l2 r3 = lm.l2.f10208a
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: b3.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @f(c = "com.transsion.airtransfer.filetransfer.process.base.BaseDataProcessor$sendLoop$1", f = "BaseDataProcessor.kt", i = {}, l = {25, 26}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends o implements p<s0, um.d<? super l2>, Object> {
        int label;
        final /* synthetic */ a<T, R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a<T, R> aVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.this$0 = aVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new c(this.this$0, dVar);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0037 -> B:11:0x001c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type um.d to b3.a$c for r4v3 'this'  um.d
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
                if (r1 == 0) goto L19
                if (r1 == r3) goto L15
                if (r1 != r2) goto Ld
                goto L19
            Ld:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L15:
                lm.d1.n(r5)
                goto L2f
            L19:
                lm.d1.n(r5)
            L1c:
                b3.a<T, R> r5 = r4.this$0
                boolean r5 = b3.a.e(r5)
                if (r5 != 0) goto L3a
                b3.a<T, R> r5 = r4.this$0
                r4.label = r3
                java.lang.Object r5 = r5.g(r4)
                if (r5 != r0) goto L2f
                return r0
            L2f:
                b3.a<T, R> r1 = r4.this$0
                r4.label = r2
                java.lang.Object r5 = r1.b(r5, r4)
                if (r5 != r0) goto L1c
                return r0
            L3a:
                lm.l2 r4 = lm.l2.f10208a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: b3.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @m
    public abstract Object f(@l um.d<? super R> dVar);

    @m
    public abstract Object g(@l um.d<? super T> dVar);

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f723a.getCoroutineContext();
    }

    public final nq.l2 i() {
        return k.f(this, null, null, new b(this, null), 3, null);
    }

    public final nq.l2 j() {
        return k.f(this, null, null, new c(this, null), 3, null);
    }

    @Override // y2.b
    public void start() {
        this.f724b = false;
        j();
        i();
    }

    @Override // y2.b
    public void stop() {
        this.f724b = true;
        t0.f(this, null, 1, null);
    }
}
