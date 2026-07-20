package kotlin.sequences;

import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7054b;

    public /* synthetic */ b(Object obj, int i8) {
        this.f7053a = i8;
        this.f7054b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i8 = this.f7053a;
        Object obj2 = this.f7054b;
        switch (i8) {
            case 0:
                return SequencesKt__SequencesKt.generateSequence$lambda$4$SequencesKt__SequencesKt((Function0) obj2, obj);
            case 1:
                return Boolean.valueOf(((Class) obj2).isInstance(obj));
            case 2:
                return SequencesKt___SequencesKt.requireNoNulls$lambda$16$SequencesKt___SequencesKt((Sequence) obj2, obj);
            case 3:
                return Boolean.valueOf(SequencesKt___SequencesKt.filterIndexed$lambda$2$SequencesKt___SequencesKt((Function2) obj2, (IndexedValue) obj));
            default:
                return SequencesKt___SequencesKt.onEach$lambda$14$SequencesKt___SequencesKt((Function1) obj2, obj);
        }
    }
}
