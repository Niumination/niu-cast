package n0;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11079a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<b> f11080b = new ArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, z0.f> f11081c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Comparator<Pair<String, Float>> f11082d = new a();

    public class a implements Comparator<Pair<String, Float>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = pair.second.floatValue();
            float fFloatValue2 = pair2.second.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    public interface b {
        void a(float f10);
    }

    public void a(b bVar) {
        this.f11080b.add(bVar);
    }

    public void b() {
        this.f11081c.clear();
    }

    public List<Pair<String, Float>> c() {
        if (!this.f11079a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f11081c.size());
        for (Map.Entry<String, z0.f> entry : this.f11081c.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().b())));
        }
        Collections.sort(arrayList, this.f11082d);
        return arrayList;
    }

    public void d() {
        if (this.f11079a) {
            List<Pair<String, Float>> listC = c();
            Log.d(e.f10922b, "Render times:");
            for (int i10 = 0; i10 < listC.size(); i10++) {
                Pair<String, Float> pair = listC.get(i10);
                Log.d(e.f10922b, String.format("\t\t%30s:%.2f", pair.first, pair.second));
            }
        }
    }

    public void e(String str, float f10) {
        if (this.f11079a) {
            z0.f fVar = this.f11081c.get(str);
            if (fVar == null) {
                fVar = new z0.f();
                this.f11081c.put(str, fVar);
            }
            fVar.a(f10);
            if (str.equals("__container")) {
                Iterator<b> it = this.f11080b.iterator();
                while (it.hasNext()) {
                    it.next().a(f10);
                }
            }
        }
    }

    public void f(b bVar) {
        this.f11080b.remove(bVar);
    }

    public void g(boolean z10) {
        this.f11079a = z10;
    }
}
