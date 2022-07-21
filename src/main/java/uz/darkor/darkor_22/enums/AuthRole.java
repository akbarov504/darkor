package uz.darkor.darkor_22.enums;

public enum AuthRole {

    ADMIN("ROLE_ADMIN"),
    OPERATOR("ROLE_OPERATOR"),
    SUPER_ADMIN("ROLE_SUPER_ADMIN"),
    MANAGER("ROLE_MANAGER");

    private final String value;

    AuthRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
