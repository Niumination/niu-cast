package n0;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f8118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8119c;

    public /* synthetic */ a(Predicate predicate, Predicate predicate2, int i8) {
        this.f8117a = i8;
        this.f8118b = predicate;
        this.f8119c = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f8117a) {
            case 0:
                return this.f8118b.lambda$or$2((Predicate) this.f8119c, obj);
            case 1:
                return this.f8118b.lambda$and$0((Predicate) this.f8119c, obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtra$13((Class) this.f8119c, this.f8118b, obj);
        }
    }

    public /* synthetic */ a(Class cls, Predicate predicate) {
        this.f8117a = 2;
        this.f8119c = cls;
        this.f8118b = predicate;
    }
}
