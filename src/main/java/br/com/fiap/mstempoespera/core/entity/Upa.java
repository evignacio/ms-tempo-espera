package br.com.fiap.mstempoespera.core.entity;

public class Upa {
    private String id;
    private String name;

    public Upa(String id, String name) {
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("UPA ID cannot be null or empty");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("UPA name cannot be null or empty");
        }
        this.name = name;
    }
}
