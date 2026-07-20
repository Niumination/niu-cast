package t7;

import android.graphics.Rect;
import com.android.internal.util.CallbackRegistry;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CallbackRegistry<b, c, Rect> f15520a;

    public class a extends CallbackRegistry.NotifierCallback<b, c, Rect> {
        public a() {
        }

        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b bVar, c cVar, int i10, Rect rect) {
            bVar.onContentChanged();
        }
    }

    public interface b {
        void onContentChanged();
    }

    public void a(b bVar) {
        if (this.f15520a == null) {
            this.f15520a = new CallbackRegistry<>(new a());
        }
        this.f15520a.add(bVar);
    }

    public void b(int i10) {
        CallbackRegistry<b, c, Rect> callbackRegistry = this.f15520a;
        if (callbackRegistry != null) {
            callbackRegistry.notifyCallbacks(this, i10, (Object) null);
        }
    }
}
