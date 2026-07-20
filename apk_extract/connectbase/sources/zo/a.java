package zo;

import in.f;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kn.l0;
import kn.w;
import nm.h0;
import nm.v0;
import nm.z;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ap.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final C0610a f21949g = new C0610a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @f
    @l
    public static final a f21950h = new a(1, 0, 7);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @f
    @l
    public static final a f21951i = new a(new int[0]);

    /* JADX INFO: renamed from: zo.a$a, reason: collision with other inner class name */
    public static final class C0610a {
        public C0610a() {
        }

        @l
        public final a a(@l InputStream inputStream) {
            l0.p(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            tn.l lVar = new tn.l(1, dataInputStream.readInt(), 1);
            ArrayList arrayList = new ArrayList(z.b0(lVar, 10));
            Iterator<Integer> it = lVar.iterator();
            while (it.hasNext()) {
                ((v0) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] iArrU5 = h0.U5(arrayList);
            return new a(Arrays.copyOf(iArrU5, iArrU5.length));
        }

        public C0610a(w wVar) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@l int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
        l0.p(iArr, "numbers");
    }

    public boolean h() {
        return f(f21950h);
    }
}
