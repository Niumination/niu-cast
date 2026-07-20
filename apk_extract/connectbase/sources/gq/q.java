package gq;

import java.util.Iterator;
import kn.l0;
import kn.r1;
import lm.f1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6868a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6869b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6870c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6871d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6872e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6873f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SequenceBuilder.kt\nkotlin/sequences/SequencesKt__SequenceBuilderKt\n*L\n1#1,680:1\n26#2:681\n*E\n"})
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.p f6874a;

        public a(jn.p pVar) {
            this.f6874a = pVar;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            return q.a(this.f6874a);
        }
    }

    @f1(version = "1.3")
    @os.l
    public static <T> Iterator<T> a(@lm.b @os.l jn.p<? super o<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        l0.p(pVar, "block");
        n nVar = new n();
        nVar.f6867d = wm.c.c(pVar, nVar, nVar);
        return nVar;
    }

    @f1(version = "1.3")
    @os.l
    public static <T> m<T> b(@lm.b @os.l jn.p<? super o<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        l0.p(pVar, "block");
        return new a(pVar);
    }
}
