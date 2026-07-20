package mi;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f10710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f10711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f10712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<String> f10713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, String> f10714e = new HashMap<>();

    public interface a {
        String getString();
    }

    public class b implements Comparator<String> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return f.this.b(str, str2);
        }

        public /* synthetic */ b(f fVar, b bVar) {
            this();
        }
    }

    public class c implements Comparator<a> {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            return f.this.b(aVar.getString(), aVar2.getString());
        }

        public /* synthetic */ c(f fVar, c cVar) {
            this();
        }
    }

    public f(Context context) {
        d dVarA = mi.a.a(context);
        this.f10710a = dVarA;
        this.f10713d = dVarA.b();
        this.f10711b = new b();
        this.f10712c = new c();
    }

    public void a() {
        this.f10714e.clear();
    }

    public int b(String str, String str2) {
        int iIndexOf = this.f10713d.indexOf(e(str));
        int iIndexOf2 = this.f10713d.indexOf(e(str2));
        return iIndexOf != iIndexOf2 ? iIndexOf - iIndexOf2 : str.compareToIgnoreCase(str2);
    }

    public <E extends a> int c(E e10, E e11) {
        return b(e10.getString(), e11.getString());
    }

    public String d() {
        return f(this.f10713d);
    }

    public String e(String str) {
        String strG = this.f10714e.get(str);
        if (strG == null) {
            strG = this.f10710a.g(str);
            this.f10714e.put(str, strG);
        }
        return strG.equals("") ? "#" : strG;
    }

    public final String f(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            str = String.valueOf(str) + it.next();
        }
        return str;
    }

    public void g(List<? extends a> list) {
        Collections.sort(list, this.f10712c);
    }

    public void h(List<String> list) {
        Collections.sort(list, this.f10711b);
    }
}
