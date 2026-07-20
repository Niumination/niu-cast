package i0;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.content.UriMatcherCompat;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5520b;

    public /* synthetic */ c(Object obj, int i8) {
        this.f5519a = i8;
        this.f5520b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        int i8 = this.f5519a;
        Object obj2 = this.f5520b;
        switch (i8) {
            case 0:
                return ((ComponentName) obj2).equals((ComponentName) obj);
            case 1:
                return UriMatcherCompat.lambda$asPredicate$0((UriMatcher) obj2, (Uri) obj);
            case 2:
                return obj2.equals(obj);
            case 3:
                return ((Predicate) obj2).lambda$negate$1(obj);
            default:
                return ((java.util.function.Predicate) obj2).test((ClipData.Item) obj);
        }
    }
}
