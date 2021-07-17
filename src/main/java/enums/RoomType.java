package enums;

import lombok.Getter;

public enum RoomType {
    C_Cave("C-Cave", 3),D_Tower("D-Tower", 7),G_Mansion("G-Mansion", 20);

    @Getter
    private String roomName;
    @Getter
    private Integer personCapactity;

    RoomType(String roomName, Integer personCapactity) {
        this.roomName = roomName;
        this.personCapactity = personCapactity;
    }
}
