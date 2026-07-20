package ej;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.view.LoadingView;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h.b f4368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoadingView f4370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f4371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4372f;

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            LoadingView loadingView = d.this.f4370d;
            if (loadingView != null) {
                loadingView.f();
            }
        }
    }

    public d(Context context) {
        this.f4367a = context;
        h.b bVar = new h.b(context, 0);
        this.f4368b = bVar;
        bVar.h(false);
        this.f4368b.g(false);
    }

    public h b() {
        View viewInflate = LayoutInflater.from(this.f4367a).inflate(R.layout.os_dialog_loading_bottom, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.messageTv)).setText(this.f4369c);
        this.f4370d = (LoadingView) viewInflate.findViewById(R.id.osLoading);
        this.f4368b.U(viewInflate);
        h hVarA = this.f4368b.a();
        Window window = hVarA.getWindow();
        window.setWindowAnimations(R.style.OsInputDialogAnimStyle);
        if (!this.f4372f) {
            hVarA.setOnDismissListener(new a());
        }
        window.setSoftInputMode(0);
        return hVarA;
    }

    public void c() {
        LoadingView loadingView = this.f4370d;
        if (loadingView != null) {
            loadingView.f();
        }
    }

    public d d(boolean z10) {
        this.f4372f = z10;
        return this;
    }

    public d e(int i10) {
        f(this.f4367a.getResources().getString(i10));
        return this;
    }

    public d f(String str) {
        this.f4369c = str;
        return this;
    }

    public h g() {
        h hVarB = b();
        this.f4371e = hVarB;
        hVarB.show();
        return this.f4371e;
    }
}
