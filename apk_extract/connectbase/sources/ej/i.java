package ej;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public DialogInterface.OnMultiChoiceClickListener A;
    public Cursor C;
    public String D;
    public String E;
    public AdapterView.OnItemSelectedListener F;
    public a G;
    public boolean H;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public CharSequence O;
    public boolean P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f4449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f4450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f4451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f4452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f4453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DialogInterface.OnClickListener f4454g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f4456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DialogInterface.OnClickListener f4457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f4458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DialogInterface.OnClickListener f4459l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DialogInterface.OnCancelListener f4462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DialogInterface.OnDismissListener f4463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DialogInterface.OnKeyListener f4464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f4466s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence[] f4467t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RecyclerView.Adapter<?> f4468u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ListAdapter f4469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DialogInterface.OnClickListener f4470w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4471x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4472y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean[] f4473z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4455h = true;
    public int B = -1;
    public boolean I = true;
    public boolean N = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4460m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4461n = true;

    public interface a {
        void onPrepareListView(ListView listView);
    }

    public i(Context context) {
        this.f4448a = context;
    }

    public void a(g gVar) {
        gVar.l0(this.f4450c);
        gVar.k0(this.f4449b);
        gVar.M(this.f4451d);
        gVar.X(this.f4452e);
        gVar.m0(this.f4465r, this.f4466s);
        gVar.f4406r = this.H;
        gVar.I(-1, this.f4453f, this.f4454g, null);
        gVar.f4408t = this.f4455h;
        gVar.I(-2, this.f4456i, this.f4457j, null);
        gVar.I(-3, this.f4458k, this.f4459l, null);
        gVar.f4405q = this.J;
        gVar.J = this.M;
        if (this.f4471x) {
            CharSequence[] charSequenceArr = this.f4467t;
            if (charSequenceArr != null) {
                gVar.a0(charSequenceArr, this.f4473z, this.A);
            } else {
                Cursor cursor = this.C;
                if (cursor != null) {
                    gVar.Y(cursor, this.D, this.E, this.A);
                }
            }
        } else if (this.f4472y) {
            CharSequence[] charSequenceArr2 = this.f4467t;
            if (charSequenceArr2 != null) {
                gVar.h0(charSequenceArr2, this.f4470w);
            } else {
                RecyclerView.Adapter<?> adapter = this.f4468u;
                if (adapter == null && this.f4469v == null) {
                    Cursor cursor2 = this.C;
                    if (cursor2 != null) {
                        gVar.e0(cursor2, this.D, this.f4470w);
                    }
                } else if (adapter != null) {
                    gVar.g0(adapter, this.f4470w);
                } else {
                    gVar.f0(this.f4469v, this.f4470w);
                }
            }
        } else {
            CharSequence[] charSequenceArr3 = this.f4467t;
            if (charSequenceArr3 != null) {
                gVar.U(charSequenceArr3, this.f4470w);
            } else {
                RecyclerView.Adapter<?> adapter2 = this.f4468u;
                if (adapter2 == null && this.f4469v == null) {
                    Cursor cursor3 = this.C;
                    if (cursor3 != null) {
                        gVar.R(cursor3, this.D, this.f4470w);
                    }
                } else if (adapter2 != null) {
                    gVar.T(adapter2, this.f4470w);
                } else {
                    gVar.S(this.f4469v, this.f4470w);
                }
            }
        }
        CharSequence charSequence = this.O;
        if (charSequence != null) {
            gVar.d0(charSequence, this.P, this.f4470w);
        }
        a aVar = this.G;
        if (aVar != null) {
            gVar.G(aVar);
        }
        if (this.f4472y) {
            gVar.K(this.B);
        }
        gVar.G = this.I;
        gVar.H = this.K;
        gVar.I = this.L;
    }
}
