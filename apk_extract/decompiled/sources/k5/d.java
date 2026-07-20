package k5;

import e5.p;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Externalizable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f6772a = Logger.getLogger(d.class.getName());
    private e phonePrefixMapStorage;
    private final e5.f phoneUtil = e5.f.c();

    public e getPhonePrefixMapStorage() {
        return this.phonePrefixMapStorage;
    }

    public e getSmallerMapStorage(SortedMap<Integer, String> sortedMap) {
        try {
            b bVar = new b();
            bVar.e(sortedMap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            bVar.d(objectOutputStream);
            objectOutputStream.flush();
            int size = byteArrayOutputStream.size();
            objectOutputStream.close();
            a aVar = new a();
            aVar.e(sortedMap);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream2);
            aVar.d(objectOutputStream2);
            objectOutputStream2.flush();
            int size2 = byteArrayOutputStream2.size();
            objectOutputStream2.close();
            return size < size2 ? bVar : aVar;
        } catch (IOException e) {
            f6772a.severe(e.getMessage());
            return new b();
        }
    }

    public String lookup(long j8) {
        e eVar = this.phonePrefixMapStorage;
        int i8 = eVar.f6773a;
        if (i8 == 0) {
            return null;
        }
        int i9 = i8 - 1;
        SortedSet sortedSetHeadSet = eVar.f6774b;
        while (sortedSetHeadSet.size() > 0) {
            Integer num = (Integer) sortedSetHeadSet.last();
            String strValueOf = String.valueOf(j8);
            int i10 = 0;
            if (strValueOf.length() > num.intValue()) {
                j8 = Long.parseLong(strValueOf.substring(0, num.intValue()));
            }
            int i11 = 0;
            while (i10 <= i9) {
                i11 = (i10 + i9) >>> 1;
                long jB = this.phonePrefixMapStorage.b(i11);
                if (jB == j8) {
                    break;
                }
                if (jB > j8) {
                    i11--;
                    i9 = i11;
                } else {
                    i10 = i11 + 1;
                }
            }
            i9 = i11;
            if (i9 < 0) {
                return null;
            }
            if (j8 == this.phonePrefixMapStorage.b(i9)) {
                return this.phonePrefixMapStorage.a(i9);
            }
            sortedSetHeadSet = sortedSetHeadSet.headSet(num);
        }
        return null;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            this.phonePrefixMapStorage = new b();
        } else {
            this.phonePrefixMapStorage = new a();
        }
        this.phonePrefixMapStorage.c(objectInput);
    }

    public void readPhonePrefixMap(SortedMap<Integer, String> sortedMap) {
        this.phonePrefixMapStorage = getSmallerMapStorage(sortedMap);
    }

    public String toString() {
        return this.phonePrefixMapStorage.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.phonePrefixMapStorage instanceof b);
        this.phonePrefixMapStorage.d(objectOutput);
    }

    public String lookup(p pVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(pVar.getCountryCode());
        this.phoneUtil.getClass();
        sb2.append(e5.f.f(pVar));
        return lookup(Long.parseLong(sb2.toString()));
    }
}
