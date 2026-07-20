package j1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f5966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap f5967d;
    public float e;
    public HashMap f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f5968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SparseArrayCompat f5969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LongSparseArray f5970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f5971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Rect f5972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f5973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f5974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f5975n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5976o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f5964a = new f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f5965b = new HashSet();
    public int p = 0;

    public final void a(String str) {
        w1.b.b(str);
        this.f5965b.add(str);
    }

    public final float b() {
        return (long) (((this.f5974m - this.f5973l) / this.f5975n) * 1000.0f);
    }

    public final Map c() {
        float fC = w1.g.c();
        if (fC != this.e) {
            for (Map.Entry entry : this.f5967d.entrySet()) {
                HashMap map = this.f5967d;
                String str = (String) entry.getKey();
                z zVar = (z) entry.getValue();
                float f = this.e / fC;
                int i8 = (int) (zVar.f6031a * f);
                int i9 = (int) (zVar.f6032b * f);
                z zVar2 = new z(i8, i9, zVar.f6033c, zVar.f6034d, zVar.e);
                Bitmap bitmap = zVar.f;
                if (bitmap != null) {
                    zVar2.f = Bitmap.createScaledBitmap(bitmap, i8, i9, true);
                }
                map.put(str, zVar2);
            }
        }
        this.e = fC;
        return this.f5967d;
    }

    public final p1.i d(String str) {
        int size = this.f5968g.size();
        for (int i8 = 0; i8 < size; i8++) {
            p1.i iVar = (p1.i) this.f5968g.get(i8);
            String str2 = iVar.f8642a;
            if (str2.equalsIgnoreCase(str) || (str2.endsWith("\r") && str2.substring(0, str2.length() - 1).equalsIgnoreCase(str))) {
                return iVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator it = this.f5971j.iterator();
        while (it.hasNext()) {
            sb2.append(((s1.i) it.next()).a("\t"));
        }
        return sb2.toString();
    }
}
