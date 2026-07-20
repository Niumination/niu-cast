package s;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import androidx.camera.video.VideoCapture;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9446b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f9445a = i8;
        this.f9446b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9445a) {
            case 0:
                return ((SurfaceSorter) this.f9446b).lambda$sort$0((SessionConfig.OutputConfig) obj, (SessionConfig.OutputConfig) obj2);
            default:
                return VideoCapture.lambda$adjustCropRectToValidSize$4((Rect) this.f9446b, (Size) obj, (Size) obj2);
        }
    }
}
