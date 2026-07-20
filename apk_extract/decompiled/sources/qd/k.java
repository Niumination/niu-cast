package qd;

import android.view.View;
import com.transsion.widgetslib.view.ViewPagerTabs;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8984c;

    public /* synthetic */ k(int i8, int i9, Object obj) {
        this.f8982a = i9;
        this.f8984c = obj;
        this.f8983b = i8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f8982a) {
            case 0:
                ViewPagerTabs viewPagerTabs = (ViewPagerTabs) this.f8984c;
                viewPagerTabs.p.setCurrentItem(viewPagerTabs.b(this.f8983b), false);
                break;
            case 1:
                ViewPagerTabs viewPagerTabs2 = (ViewPagerTabs) this.f8984c;
                viewPagerTabs2.p.setCurrentItem(viewPagerTabs2.b(this.f8983b), false);
                break;
            default:
                ((ya.a) this.f8984c).b(this.f8983b);
                break;
        }
    }
}
