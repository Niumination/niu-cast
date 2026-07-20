package nm;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class r1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    public static final class a<T> extends xm.k implements jn.p<gq.o<? super List<? extends T>>, um.d<? super l2>, Object> {
        final /* synthetic */ Iterator<T> $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(int i10, int i11, Iterator<? extends T> it, boolean z10, boolean z11, um.d<? super a> dVar) {
            super(2, dVar);
            this.$size = i10;
            this.$step = i11;
            this.$iterator = it;
            this.$reuseBuffer = z10;
            this.$partialWindows = z11;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super List<? extends T>> oVar, @os.m um.d<? super l2> dVar) {
            return ((a) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Code duplicated, block: B:51:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:58:0x0102  */
        /* JADX WARN: Code duplicated, block: B:59:0x0104  */
        /* JADX WARN: Code duplicated, block: B:62:0x0117 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:85:0x00f1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:86:0x00fe A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x009d -> B:16:0x0053). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0115 -> B:63:0x0118). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0143 -> B:76:0x0146). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 356
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: nm.r1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SlidingWindow.kt\nkotlin/collections/SlidingWindowKt\n*L\n1#1,680:1\n19#2:681\n*E\n"})
    public static final class b<T> implements gq.m<List<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gq.m f11686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f11688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f11689d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f11690e;

        public b(gq.m mVar, int i10, int i11, boolean z10, boolean z11) {
            this.f11686a = mVar;
            this.f11687b = i10;
            this.f11688c = i11;
            this.f11689d = z10;
            this.f11690e = z11;
        }

        @Override // gq.m
        @os.l
        public Iterator<List<? extends T>> iterator() {
            return r1.b(this.f11686a.iterator(), this.f11687b, this.f11688c, this.f11689d, this.f11690e);
        }
    }

    public static final void a(int i10, int i11) {
        String strA;
        if (i10 <= 0 || i11 <= 0) {
            if (i10 != i11) {
                strA = "Both size " + i10 + " and step " + i11 + " must be greater than zero.";
            } else {
                strA = k.b.a("size ", i10, " must be greater than zero.");
            }
            throw new IllegalArgumentException(strA.toString());
        }
    }

    @os.l
    public static final <T> Iterator<List<T>> b(@os.l Iterator<? extends T> it, int i10, int i11, boolean z10, boolean z11) {
        kn.l0.p(it, "iterator");
        return !it.hasNext() ? j0.f11638a : gq.q.a(new a(i10, i11, it, z11, z10, null));
    }

    @os.l
    public static final <T> gq.m<List<T>> c(@os.l gq.m<? extends T> mVar, int i10, int i11, boolean z10, boolean z11) {
        kn.l0.p(mVar, "<this>");
        a(i10, i11);
        return new b(mVar, i10, i11, z10, z11);
    }
}
