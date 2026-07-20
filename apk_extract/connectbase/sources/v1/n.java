package v1;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class n extends k {
    private final x1.i<String, k> members = new x1.i<>(false);

    public void add(String str, k kVar) {
        x1.i<String, k> iVar = this.members;
        if (kVar == null) {
            kVar = m.INSTANCE;
        }
        iVar.put(str, kVar);
    }

    public void addProperty(String str, String str2) {
        add(str, str2 == null ? m.INSTANCE : new q(str2));
    }

    public Map<String, k> asMap() {
        return this.members;
    }

    public Set<Map.Entry<String, k>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).members.equals(this.members));
    }

    public k get(String str) {
        return this.members.get(str);
    }

    public h getAsJsonArray(String str) {
        return (h) this.members.get(str);
    }

    public n getAsJsonObject(String str) {
        return (n) this.members.get(str);
    }

    public q getAsJsonPrimitive(String str) {
        return (q) this.members.get(str);
    }

    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public boolean isEmpty() {
        return this.members.size() == 0;
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public k remove(String str) {
        return this.members.remove(str);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String str, Number number) {
        add(str, number == null ? m.INSTANCE : new q(number));
    }

    @Override // v1.k
    public n deepCopy() {
        n nVar = new n();
        for (Map.Entry<String, k> entry : this.members.entrySet()) {
            nVar.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return nVar;
    }

    public void addProperty(String str, Boolean bool) {
        add(str, bool == null ? m.INSTANCE : new q(bool));
    }

    public void addProperty(String str, Character ch2) {
        add(str, ch2 == null ? m.INSTANCE : new q(ch2));
    }
}
