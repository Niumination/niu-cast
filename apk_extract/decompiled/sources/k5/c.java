package k5;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Externalizable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f6771a;
    private List<Set<String>> availableLanguages;
    private int[] countryCallingCodes;
    private int numOfEntries = 0;

    static {
        HashMap map = new HashMap();
        map.put("zh_TW", "zh_Hant");
        map.put("zh_HK", "zh_Hant");
        map.put("zh_MO", "zh_Hant");
        f6771a = Collections.unmodifiableMap(map);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x009e A[PHI: r8
      0x009e: PHI (r8v4 java.lang.String) = (r8v1 java.lang.String), (r8v3 java.lang.String) binds: [B:40:0x009c, B:43:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bd  */
    public String getFileName(int i8, String str, String str2, String str3) {
        int iBinarySearch;
        if (str.length() == 0 || (iBinarySearch = Arrays.binarySearch(this.countryCallingCodes, i8)) < 0) {
            return "";
        }
        Set<String> set = this.availableLanguages.get(iBinarySearch);
        if (set.size() > 0) {
            StringBuilder sb2 = new StringBuilder(str);
            if (str2.length() > 0) {
                sb2.append('_');
                sb2.append(str2);
            }
            if (str3.length() > 0) {
                sb2.append('_');
                sb2.append(str3);
            }
            String string = sb2.toString();
            String str4 = (String) f6771a.get(string);
            if (str4 != null && set.contains(str4)) {
                str = str4;
            } else if (set.contains(string)) {
                str = string;
            } else if ((str2.length() != 0 || str3.length() <= 0) && (str3.length() != 0 || str2.length() <= 0)) {
                if (str2.length() <= 0 || str3.length() <= 0) {
                    str = "";
                } else {
                    String str5 = str + '_' + str2;
                    if (set.contains(str5)) {
                        str = str5;
                    } else {
                        str5 = str + '_' + str3;
                        if (set.contains(str5)) {
                            str = str5;
                        } else if (!set.contains(str)) {
                            str = "";
                        }
                    }
                }
            } else if (!set.contains(str)) {
                str = "";
            }
            if (str.length() > 0) {
                return i8 + '_' + str;
            }
        }
        return "";
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        int i8 = objectInput.readInt();
        this.numOfEntries = i8;
        int[] iArr = this.countryCallingCodes;
        if (iArr == null || iArr.length < i8) {
            this.countryCallingCodes = new int[i8];
        }
        if (this.availableLanguages == null) {
            this.availableLanguages = new ArrayList();
        }
        for (int i9 = 0; i9 < this.numOfEntries; i9++) {
            this.countryCallingCodes[i9] = objectInput.readInt();
            int i10 = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < i10; i11++) {
                hashSet.add(objectInput.readUTF());
            }
            this.availableLanguages.add(hashSet);
        }
    }

    public void readFileConfigs(SortedMap<Integer, Set<String>> sortedMap) {
        int size = sortedMap.size();
        this.numOfEntries = size;
        this.countryCallingCodes = new int[size];
        this.availableLanguages = new ArrayList(this.numOfEntries);
        int i8 = 0;
        for (Integer num : sortedMap.keySet()) {
            this.countryCallingCodes[i8] = num.intValue();
            this.availableLanguages.add(new HashSet(sortedMap.get(num)));
            i8++;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i8 = 0; i8 < this.numOfEntries; i8++) {
            sb2.append(this.countryCallingCodes[i8]);
            sb2.append('|');
            Iterator it = new TreeSet(this.availableLanguages.get(i8)).iterator();
            while (it.hasNext()) {
                sb2.append((String) it.next());
                sb2.append(',');
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.numOfEntries);
        for (int i8 = 0; i8 < this.numOfEntries; i8++) {
            objectOutput.writeInt(this.countryCallingCodes[i8]);
            Set<String> set = this.availableLanguages.get(i8);
            objectOutput.writeInt(set.size());
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                objectOutput.writeUTF(it.next());
            }
        }
    }
}
