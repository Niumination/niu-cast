package ej;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.transsion.widgetslib.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h.b f4475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f4476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f4477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4478e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4479f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wi.a f4480g;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            j.this.f4480g.d(i10);
            Button buttonC = j.this.f4476c.c(-1);
            if (j.this.f4478e && buttonC.getVisibility() == 0) {
                buttonC.setText(((Object) j.this.f4477d) + "(" + j.this.f4480g.a() + ")");
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f4482a;

        public b(d dVar) {
            this.f4482a = dVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            d dVar = this.f4482a;
            if (dVar != null) {
                dVar.a(j.this.f4480g.b());
            }
        }
    }

    public class c implements DialogInterface.OnShowListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            j.this.f4476c.c(-1).setText(((Object) j.this.f4477d) + "(" + j.this.f4480g.getCount() + ")");
        }
    }

    public interface d {
        void a(List<Boolean> list);
    }

    public j(Context context) {
        this.f4474a = context;
        this.f4475b = new h.b(context, 0);
    }

    public h e(boolean z10) {
        h hVarA = this.f4475b.a();
        this.f4476c = hVarA;
        if (z10) {
            hVarA.getWindow().setType(2003);
        }
        if (this.f4478e && this.f4479f) {
            this.f4476c.setOnShowListener(new c());
        }
        return this.f4476c;
    }

    public j f(boolean z10) {
        this.f4475b.g(z10);
        return this;
    }

    public j g(boolean z10) {
        this.f4475b.h(z10);
        return this;
    }

    public final View h(List<fj.a> list, boolean z10) {
        View viewInflate = LayoutInflater.from(this.f4474a).inflate(R.layout.os_select_dialog_layout, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.select_dialog_list);
        wi.a aVar = new wi.a(this.f4474a, list, z10);
        this.f4480g = aVar;
        listView.setAdapter((ListAdapter) aVar);
        listView.setOnItemClickListener(new a());
        return viewInflate;
    }

    public j i(int i10) {
        this.f4475b.r(i10);
        return this;
    }

    public j j(CharSequence charSequence) {
        this.f4475b.s(charSequence);
        return this;
    }

    public j k(int i10, DialogInterface.OnClickListener onClickListener) {
        this.f4475b.w(i10, onClickListener);
        return this;
    }

    public j l(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f4475b.x(charSequence, onClickListener);
        return this;
    }

    public j m(int i10, d dVar) {
        this.f4477d = this.f4474a.getText(i10);
        o(dVar);
        return this;
    }

    public j n(CharSequence charSequence, d dVar) {
        this.f4477d = charSequence;
        o(dVar);
        return this;
    }

    public final void o(d dVar) {
        this.f4475b.H(this.f4477d, new b(dVar));
    }

    public j p(List<fj.a> list, boolean z10, boolean z11) {
        this.f4478e = z11;
        this.f4479f = z10;
        this.f4475b.U(h(list, z10));
        return this;
    }

    public j q(int i10) {
        this.f4475b.P(i10);
        return this;
    }

    public j r(CharSequence charSequence) {
        this.f4475b.Q(charSequence);
        return this;
    }

    public h s() {
        return t(false);
    }

    public h t(boolean z10) {
        e(z10);
        this.f4476c.show();
        return this.f4476c;
    }
}
