package v4;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class x extends u {
    private final x4.q members = new x4.q(false);

    public void add(String str, u uVar) {
        x4.q qVar = this.members;
        if (uVar == null) {
            uVar = w.INSTANCE;
        }
        qVar.put(str, uVar);
    }

    public void addProperty(String str, String str2) {
        add(str, str2 == null ? w.INSTANCE : new z(str2));
    }

    public Map<String, u> asMap() {
        return this.members;
    }

    public Set<Map.Entry<String, u>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof x) && ((x) obj).members.equals(this.members));
    }

    public u get(String str) {
        return (u) this.members.get(str);
    }

    public t getAsJsonArray(String str) {
        return (t) this.members.get(str);
    }

    public x getAsJsonObject(String str) {
        return (x) this.members.get(str);
    }

    public z getAsJsonPrimitive(String str) {
        return (z) this.members.get(str);
    }

    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public boolean isEmpty() {
        return this.members.isEmpty();
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public u remove(String str) {
        return (u) this.members.remove(str);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String str, Number number) {
        add(str, number == null ? w.INSTANCE : new z(number));
    }

    @Override // v4.u
    public x deepCopy() {
        x xVar = new x();
        for (Map.Entry<Object, Object> entry : this.members.entrySet()) {
            xVar.add((String) entry.getKey(), ((u) entry.getValue()).deepCopy());
        }
        return xVar;
    }

    public void addProperty(String str, Boolean bool) {
        add(str, bool == null ? w.INSTANCE : new z(bool));
    }

    public void addProperty(String str, Character ch2) {
        add(str, ch2 == null ? w.INSTANCE : new z(ch2));
    }
}
