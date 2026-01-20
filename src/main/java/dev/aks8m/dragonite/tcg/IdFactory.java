package dev.aks8m.dragonite.tcg;

public class IdFactory {

    // --- BIT LAYOUT ---
    // [ Game(8) | Name(24) | Set(16) | Local(16) ]

    private static final int GAME_SHIFT  = 56;
    private static final int NAME_SHIFT  = 32;
    private static final int SET_SHIFT   = 16;
    // Local ID is at 0

    public static long create(byte gameId, int nameId, int setId, int localId) {
        // We mask the nameId with 0xFFFFFF to ensure it fits in 24 bits
        // in case the input int was too big.
        return ((long) (gameId & 0xFF)   << GAME_SHIFT) |
                ((long) (nameId & 0xFFFFFF) << NAME_SHIFT) |
                ((long) (setId  & 0xFFFF)   << SET_SHIFT)  |
                ((long) (localId & 0xFFFF));
    }

    // --- READERS ---

    public static byte getGameId(long id) {
        // Unsigned shift >>> brings top bits down
        return (byte) (id >>> GAME_SHIFT);
    }

    public static int getNameId(long id) {
        // Shift down 32, then keep only the bottom 24 bits
        return (int) ((id >>> NAME_SHIFT) & 0xFFFFFF);
    }

    public static int getSetId(long id) {
        return (int) ((id >>> SET_SHIFT) & 0xFFFF);
    }

    public static int getLocalId(long id) {
        return (int) (id & 0xFFFF);
    }
}
