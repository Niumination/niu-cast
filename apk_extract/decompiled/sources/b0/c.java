package b0;

import android.view.View;
import androidx.camera.view.PreviewView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1176b;

    public /* synthetic */ c(Object obj, int i8) {
        this.f1175a = i8;
        this.f1176b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = this.f1175a;
        Object obj = this.f1176b;
        switch (i16) {
            case 0:
                ((PreviewView) obj).lambda$new$0(view, i8, i9, i10, i11, i12, i13, i14, i15);
                break;
            default:
                ((CarouselLayoutManager) obj).lambda$new$0(view, i8, i9, i10, i11, i12, i13, i14, i15);
                break;
        }
    }
}
