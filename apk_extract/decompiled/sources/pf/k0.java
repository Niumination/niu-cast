package pf;

import java.nio.charset.Charset;
import java.util.Comparator;
import k3.ab;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8857a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f8857a) {
            case 0:
                return ComparisonsKt.compareValues(ab.b((Charset) obj), ab.b((Charset) obj2));
            default:
                return ComparisonsKt.compareValues((Float) ((Pair) obj2).getSecond(), (Float) ((Pair) obj).getSecond());
        }
    }
}
