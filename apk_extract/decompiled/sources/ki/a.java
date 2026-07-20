package ki;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import java.util.Comparator;
import kotlin.uuid.Uuid;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6874a;

    public /* synthetic */ a(int i8) {
        this.f6874a = i8;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f6874a) {
            case 0:
                return Uuid.LEXICAL_ORDER$lambda$0((Uuid) obj, (Uuid) obj2);
            case 1:
                return OptionsBundle.lambda$static$0((Config.Option) obj, (Config.Option) obj2);
            default:
                return ((Double) obj).compareTo((Double) obj2);
        }
    }
}
