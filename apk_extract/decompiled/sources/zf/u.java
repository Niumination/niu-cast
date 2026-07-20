package zf;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(Double.valueOf(((n) obj2).f11523c), Double.valueOf(((n) obj).f11523c));
    }
}
