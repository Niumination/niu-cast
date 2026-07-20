package ej;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.view.LoadingView;
import rb.s;

/* JADX INFO: loaded from: classes2.dex */
public class e extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LoadingView f4374a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f4375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f4376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f4377c;

        public b(Context context) {
            this(context, 0);
        }

        public b a(int i10) {
            b(i10, false);
            return this;
        }

        public b b(int i10, boolean z10) {
            d(this.f4376b.getResources().getString(i10), z10);
            return this;
        }

        public b c(String str) {
            d(str, false);
            return this;
        }

        public b d(String str, boolean z10) {
            View viewInflate = LayoutInflater.from(this.f4376b).inflate(z10 ? R.layout.os_dialog_loading_mask : R.layout.os_dialog_loading, (ViewGroup) null, true);
            this.f4377c = viewInflate;
            ((TextView) viewInflate.findViewById(R.id.messageTv)).setText(str);
            LoadingView unused = e.f4374a = (LoadingView) this.f4377c.findViewById(R.id.osLoading);
            this.f4375a.setContentView(this.f4377c, new ViewGroup.LayoutParams(-2, -2));
            this.f4375a.getWindow().setBackgroundDrawableResource(z10 ? R.drawable.os_loading_dialog_ims_bg : R.drawable.os_loading_dialog_bg);
            this.f4375a.getWindow().setWindowAnimations(R.style.OsInputDialogAnimStyle);
            return this;
        }

        public e e() {
            e eVar = this.f4375a;
            if (eVar != null) {
                eVar.show();
            }
            return this.f4375a;
        }

        public b(Context context, int i10) {
            this.f4376b = context;
            e eVar = new e(context, i10 < 16777216 ? R.style.OS_Dialog_Loading : i10);
            this.f4375a = eVar;
            eVar.setCancelable(false);
            this.f4375a.setCanceledOnTouchOutside(false);
            this.f4375a.getWindow().setGravity(17);
            if (hj.h.D(this.f4376b) && hj.h.G()) {
                this.f4375a.getWindow().setType(s.f14432g);
                this.f4375a.setTitle(context.getString(R.string.os_string_fold_dialog_title_verify));
            }
        }
    }

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        LoadingView loadingView = f4374a;
        if (loadingView != null) {
            loadingView.f();
            f4374a = null;
        }
    }

    public e(@NonNull Context context, int i10) {
        super(context, i10);
    }

    public e(Context context, int i10, a aVar) {
        super(context, i10);
    }
}
