package gd;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f5149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f5150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f5151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OSPageView f5152d;

    public n(TextView textView, Ref.ObjectRef objectRef, Ref.IntRef intRef, OSPageView oSPageView) {
        this.f5149a = textView;
        this.f5150b = objectRef;
        this.f5151c = intRef;
        this.f5152d = oSPageView;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0051  */
    /* JADX WARN: Code duplicated, block: B:15:0x0061  */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006e, code lost:
    
        if (r1.getVisibility() == 4) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.text.Layout] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onGlobalLayout() {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gd.n.onGlobalLayout():void");
    }
}
