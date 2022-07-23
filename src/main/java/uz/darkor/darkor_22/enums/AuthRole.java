package uz.darkor.darkor_22.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthRole {
    USER,
    MANAGER,
    ADMIN;
}
