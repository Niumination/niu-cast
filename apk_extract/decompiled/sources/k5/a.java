package k5;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f6766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f6767d;

    @Override // k5.e
    public final String a(int i8) {
        return this.f6767d[i8];
    }

    @Override // k5.e
    public final int b(int i8) {
        return this.f6766c[i8];
    }

    @Override // k5.e
    public final void c(ObjectInput objectInput) throws IOException {
        int i8 = objectInput.readInt();
        this.f6773a = i8;
        int[] iArr = this.f6766c;
        if (iArr == null || iArr.length < i8) {
            this.f6766c = new int[i8];
        }
        String[] strArr = this.f6767d;
        if (strArr == null || strArr.length < i8) {
            this.f6767d = new String[i8];
        }
        for (int i9 = 0; i9 < this.f6773a; i9++) {
            this.f6766c[i9] = objectInput.readInt();
            this.f6767d[i9] = objectInput.readUTF();
        }
        int i10 = objectInput.readInt();
        TreeSet treeSet = this.f6774b;
        treeSet.clear();
        for (int i11 = 0; i11 < i10; i11++) {
            treeSet.add(Integer.valueOf(objectInput.readInt()));
        }
    }

    @Override // k5.e
    public final void d(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.f6773a);
        for (int i8 = 0; i8 < this.f6773a; i8++) {
            objectOutput.writeInt(this.f6766c[i8]);
            objectOutput.writeUTF(this.f6767d[i8]);
        }
        TreeSet treeSet = this.f6774b;
        objectOutput.writeInt(treeSet.size());
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            objectOutput.writeInt(((Integer) it.next()).intValue());
        }
    }

    public final void e(SortedMap sortedMap) {
        int size = sortedMap.size();
        this.f6773a = size;
        this.f6766c = new int[size];
        this.f6767d = new String[size];
        Iterator it = sortedMap.keySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            this.f6766c[i8] = iIntValue;
            this.f6774b.add(Integer.valueOf(((int) Math.log10(iIntValue)) + 1));
            i8++;
        }
        sortedMap.values().toArray(this.f6767d);
    }
}
