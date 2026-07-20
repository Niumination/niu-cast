package j2;

import android.database.Cursor;
import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements f, f2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f6043b = new e(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f6044c = new e(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6045a;

    public /* synthetic */ e(int i8) {
        this.f6045a = i8;
    }

    @Override // j2.f
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        switch (this.f6045a) {
            case 0:
                a2.b bVar = h.e;
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (cursor.moveToNext()) {
                    byte[] blob = cursor.getBlob(0);
                    arrayList.add(blob);
                    length += blob.length;
                }
                byte[] bArr = new byte[length];
                int length2 = 0;
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    byte[] bArr2 = (byte[]) arrayList.get(i8);
                    System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                    length2 += bArr2.length;
                }
                return bArr;
            default:
                a2.b bVar2 = h.e;
                ArrayList arrayList2 = new ArrayList();
                while (cursor.moveToNext()) {
                    d2.c cVarA = d2.j.a();
                    String string = cursor.getString(1);
                    if (string == null) {
                        throw new NullPointerException("Null backendName");
                    }
                    cVarA.f4266a = string;
                    cVarA.f4268c = m2.a.b(cursor.getInt(2));
                    String string2 = cursor.getString(3);
                    cVarA.f4267b = string2 == null ? null : Base64.decode(string2, 0);
                    arrayList2.add(cVarA.a());
                }
                return arrayList2;
        }
    }

    @Override // yh.a
    public Object get() {
        List list = k.f6056c;
        return 4;
    }
}
