package y2;

import com.google.android.gms.common.Feature;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a f11026a = new a();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Feature feature = (Feature) obj;
        Feature feature2 = (Feature) obj2;
        return !feature.f1804a.equals(feature2.f1804a) ? feature.f1804a.compareTo(feature2.f1804a) : (feature.g() > feature2.g() ? 1 : (feature.g() == feature2.g() ? 0 : -1));
    }
}
