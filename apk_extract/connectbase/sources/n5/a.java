package n5;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0290a f11411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11412b;

    /* JADX INFO: renamed from: n5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0290a {
        void a(int i10, View view);
    }

    public a(InterfaceC0290a interfaceC0290a, int i10) {
        this.f11411a = interfaceC0290a;
        this.f11412b = i10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11411a.a(this.f11412b, view);
    }
}
