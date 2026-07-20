package ej;

import android.content.Context;
import android.content.DialogInterface;
import android.text.format.DateUtils;
import android.view.View;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.widget.timepicker.OSDateTimePicker;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h.b f4355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Calendar f4356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OSDateTimePicker f4357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC0102c f4358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f4359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f4360g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4362i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4363j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4361h = OSDateTimePicker.T;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OSDateTimePicker.i f4364k = new a();

    public class a implements OSDateTimePicker.i {
        public a() {
        }

        @Override // com.transsion.widgetslib.widget.timepicker.OSDateTimePicker.i
        public void a(OSDateTimePicker oSDateTimePicker, Calendar calendar) {
            c cVar = c.this;
            cVar.f4356c = calendar;
            cVar.k();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            c cVar = c.this;
            d dVar = cVar.f4359f;
            if (dVar != null) {
                OSDateTimePicker oSDateTimePicker = cVar.f4357d;
                Calendar calendar = cVar.f4356c;
                dVar.a(oSDateTimePicker, calendar, calendar.get(1), c.this.f4356c.get(2), c.this.f4356c.get(5), c.this.f4356c.get(11), c.this.f4356c.get(12), c.this.f4356c.get(9));
            }
        }
    }

    /* JADX INFO: renamed from: ej.c$c, reason: collision with other inner class name */
    public interface InterfaceC0102c {
        void a(OSDateTimePicker oSDateTimePicker, Calendar calendar, int i10, int i11, int i12, int i13, int i14, int i15);
    }

    public interface d {
        void a(OSDateTimePicker oSDateTimePicker, Calendar calendar, int i10, int i11, int i12, int i13, int i14, int i15);
    }

    public c(Context context) {
        this.f4354a = context;
        this.f4355b = new h.b(context, 0);
    }

    public void A(int i10, int i11, int i12) {
        OSDateTimePicker oSDateTimePicker = this.f4357d;
        if (oSDateTimePicker != null) {
            oSDateTimePicker.O(i10, i11, i12);
        }
    }

    public void B(int i10, int i11, int i12, int i13, int i14) {
        OSDateTimePicker oSDateTimePicker = this.f4357d;
        if (oSDateTimePicker != null) {
            oSDateTimePicker.P(i10, i11, i12, i13, i14);
        }
    }

    public void C(int i10, int i11) {
        OSDateTimePicker oSDateTimePicker = this.f4357d;
        if (oSDateTimePicker != null) {
            oSDateTimePicker.T(i10, i11);
        }
    }

    public final void D() {
        h hVar = this.f4360g;
        if (hVar != null) {
            hVar.setTitle(i());
        }
    }

    public h f() {
        u();
        h hVarA = this.f4355b.a();
        this.f4360g = hVarA;
        hVarA.i();
        D();
        return this.f4360g;
    }

    public void g() {
        h hVar = this.f4360g;
        if (hVar == null || !hVar.isShowing()) {
            return;
        }
        this.f4360g.dismiss();
    }

    public OSDateTimePicker h() {
        return this.f4357d;
    }

    public final String i() {
        int i10;
        if (OSDateTimePicker.U.equals(this.f4361h)) {
            i10 = 22;
        } else {
            i10 = OSDateTimePicker.f3224a0.equals(this.f4361h) ? 1 : 23;
        }
        return DateUtils.formatDateTime(this.f4354a, this.f4356c.getTimeInMillis(), i10);
    }

    public boolean j() {
        h hVar = this.f4360g;
        return hVar != null && hVar.isShowing();
    }

    public final void k() {
        if (this.f4358e == null || !j()) {
            return;
        }
        InterfaceC0102c interfaceC0102c = this.f4358e;
        OSDateTimePicker oSDateTimePicker = this.f4357d;
        Calendar calendar = this.f4356c;
        interfaceC0102c.a(oSDateTimePicker, calendar, calendar.get(1), this.f4356c.get(2), this.f4356c.get(5), this.f4356c.get(11), this.f4356c.get(12), this.f4356c.get(9));
        D();
    }

    public c l(boolean z10) {
        this.f4355b.g(z10);
        return this;
    }

    public c m(boolean z10) {
        this.f4355b.h(z10);
        return this;
    }

    public void n(String str) {
        this.f4361h = str;
    }

    public c o(int i10, DialogInterface.OnClickListener onClickListener) {
        return p(this.f4354a.getText(i10), onClickListener);
    }

    public c p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f4355b.x(charSequence, onClickListener);
        return this;
    }

    public c q(DialogInterface.OnCancelListener onCancelListener) {
        this.f4355b.B(onCancelListener);
        return this;
    }

    public c r(InterfaceC0102c interfaceC0102c) {
        this.f4358e = interfaceC0102c;
        return this;
    }

    public c s(d dVar) {
        this.f4359f = dVar;
        this.f4355b.F(R.string.os_preference_dialog_positive_string, new b());
        return this;
    }

    public c t(DialogInterface.OnDismissListener onDismissListener) {
        this.f4355b.C(onDismissListener);
        return this;
    }

    public final void u() {
        if (this.f4356c == null) {
            this.f4356c = Calendar.getInstance();
        }
        View viewInflate = View.inflate(this.f4354a, R.layout.os_picker_date_time_layout, null);
        OSDateTimePicker oSDateTimePicker = (OSDateTimePicker) viewInflate.findViewById(R.id.datePicker);
        this.f4357d = oSDateTimePicker;
        int i10 = this.f4362i;
        if (i10 != 0 || this.f4363j != 0) {
            oSDateTimePicker.N(i10, this.f4363j);
        }
        this.f4357d.n(this.f4356c, this.f4361h);
        this.f4357d.setOnDateChangeListener(this.f4364k);
        this.f4355b.U(viewInflate);
    }

    public c v(int i10, DialogInterface.OnClickListener onClickListener) {
        return w(this.f4354a.getText(i10), onClickListener);
    }

    public c w(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f4355b.H(charSequence, onClickListener);
        return this;
    }

    public c x(int i10) {
        this.f4355b.R(i10);
        return this;
    }

    public c y(CharSequence charSequence) {
        this.f4355b.S(charSequence);
        return this;
    }

    public void z(int i10, int i11) {
        this.f4362i = i10;
        this.f4363j = i11;
    }

    public c(Context context, int i10, int i11, int i12, int i13, int i14) {
        this.f4354a = context;
        this.f4355b = new h.b(context, 0);
        Calendar calendar = Calendar.getInstance();
        this.f4356c = calendar;
        calendar.set(1, i10);
        this.f4356c.set(2, i11);
        this.f4356c.set(5, i12);
        this.f4356c.set(11, i13);
        this.f4356c.set(12, i14);
    }

    public c(Context context, int i10, int i11, int i12) {
        this.f4354a = context;
        this.f4355b = new h.b(context, 0);
        Calendar calendar = Calendar.getInstance();
        this.f4356c = calendar;
        calendar.set(1, i10);
        this.f4356c.set(2, i11);
        this.f4356c.set(5, i12);
    }

    public c(Context context, int i10, int i11) {
        this.f4354a = context;
        this.f4355b = new h.b(context, 0);
        Calendar calendar = Calendar.getInstance();
        this.f4356c = calendar;
        calendar.set(11, i10);
        this.f4356c.set(12, i11);
    }
}
