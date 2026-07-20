package k5;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6769d;
    public ByteBuffer e;
    public ByteBuffer f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String[] f6770g;

    @Override // k5.e
    public final String a(int i8) {
        ByteBuffer byteBuffer = this.f;
        int i9 = this.f6769d;
        int i10 = i8 * i9;
        return this.f6770g[i9 == 2 ? byteBuffer.getShort(i10) : byteBuffer.getInt(i10)];
    }

    @Override // k5.e
    public final int b(int i8) {
        ByteBuffer byteBuffer = this.e;
        int i9 = this.f6768c;
        int i10 = i8 * i9;
        return i9 == 2 ? byteBuffer.getShort(i10) : byteBuffer.getInt(i10);
    }

    @Override // k5.e
    public final void c(ObjectInput objectInput) throws IOException {
        this.f6768c = objectInput.readInt();
        this.f6769d = objectInput.readInt();
        int i8 = objectInput.readInt();
        TreeSet treeSet = this.f6774b;
        treeSet.clear();
        for (int i9 = 0; i9 < i8; i9++) {
            treeSet.add(Integer.valueOf(objectInput.readInt()));
        }
        int i10 = objectInput.readInt();
        String[] strArr = this.f6770g;
        if (strArr == null || strArr.length < i10) {
            this.f6770g = new String[i10];
        }
        for (int i11 = 0; i11 < i10; i11++) {
            this.f6770g[i11] = objectInput.readUTF();
        }
        this.f6773a = objectInput.readInt();
        ByteBuffer byteBuffer = this.e;
        if (byteBuffer == null || byteBuffer.capacity() < this.f6773a) {
            this.e = ByteBuffer.allocate(this.f6773a * this.f6768c);
        }
        ByteBuffer byteBuffer2 = this.f;
        if (byteBuffer2 == null || byteBuffer2.capacity() < this.f6773a) {
            this.f = ByteBuffer.allocate(this.f6773a * this.f6769d);
        }
        for (int i12 = 0; i12 < this.f6773a; i12++) {
            int i13 = this.f6768c;
            ByteBuffer byteBuffer3 = this.e;
            int i14 = i12 * i13;
            if (i13 == 2) {
                byteBuffer3.putShort(i14, objectInput.readShort());
            } else {
                byteBuffer3.putInt(i14, objectInput.readInt());
            }
            int i15 = this.f6769d;
            ByteBuffer byteBuffer4 = this.f;
            int i16 = i12 * i15;
            if (i15 == 2) {
                byteBuffer4.putShort(i16, objectInput.readShort());
            } else {
                byteBuffer4.putInt(i16, objectInput.readInt());
            }
        }
    }

    @Override // k5.e
    public final void d(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.f6768c);
        objectOutput.writeInt(this.f6769d);
        TreeSet treeSet = this.f6774b;
        objectOutput.writeInt(treeSet.size());
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            objectOutput.writeInt(((Integer) it.next()).intValue());
        }
        objectOutput.writeInt(this.f6770g.length);
        for (String str : this.f6770g) {
            objectOutput.writeUTF(str);
        }
        objectOutput.writeInt(this.f6773a);
        for (int i8 = 0; i8 < this.f6773a; i8++) {
            int i9 = this.f6768c;
            ByteBuffer byteBuffer = this.e;
            int i10 = i8 * i9;
            if (i9 == 2) {
                objectOutput.writeShort(byteBuffer.getShort(i10));
            } else {
                objectOutput.writeInt(byteBuffer.getInt(i10));
            }
            int i11 = this.f6769d;
            ByteBuffer byteBuffer2 = this.f;
            int i12 = i8 * i11;
            if (i11 == 2) {
                objectOutput.writeShort(byteBuffer2.getShort(i12));
            } else {
                objectOutput.writeInt(byteBuffer2.getInt(i12));
            }
        }
    }

    public final void e(SortedMap sortedMap) {
        TreeSet treeSet = new TreeSet();
        this.f6773a = sortedMap.size();
        int i8 = ((Integer) sortedMap.lastKey()).intValue() <= 32767 ? 2 : 4;
        this.f6768c = i8;
        this.e = ByteBuffer.allocate(this.f6773a * i8);
        int i9 = 0;
        for (Map.Entry entry : sortedMap.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            ByteBuffer byteBuffer = this.e;
            int i10 = this.f6768c;
            int i11 = i9 * i10;
            if (i10 == 2) {
                byteBuffer.putShort(i11, (short) iIntValue);
            } else {
                byteBuffer.putInt(i11, iIntValue);
            }
            this.f6774b.add(Integer.valueOf(((int) Math.log10(iIntValue)) + 1));
            treeSet.add((String) entry.getValue());
            i9++;
        }
        int i12 = treeSet.size() + (-1) <= 32767 ? 2 : 4;
        this.f6769d = i12;
        this.f = ByteBuffer.allocate(this.f6773a * i12);
        String[] strArr = new String[treeSet.size()];
        this.f6770g = strArr;
        treeSet.toArray(strArr);
        int i13 = 0;
        for (int i14 = 0; i14 < this.f6773a; i14++) {
            ByteBuffer byteBuffer2 = this.e;
            int i15 = this.f6768c;
            int i16 = i14 * i15;
            int iBinarySearch = Arrays.binarySearch(this.f6770g, (String) sortedMap.get(Integer.valueOf(i15 == 2 ? byteBuffer2.getShort(i16) : byteBuffer2.getInt(i16))));
            ByteBuffer byteBuffer3 = this.f;
            int i17 = this.f6769d;
            int i18 = i13 * i17;
            if (i17 == 2) {
                byteBuffer3.putShort(i18, (short) iBinarySearch);
            } else {
                byteBuffer3.putInt(i18, iBinarySearch);
            }
            i13++;
        }
    }
}
