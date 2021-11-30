package simulation;

/**
 * Vyctove typy pro ruzne stavy, ve kterych se letadlo muze nachazet resp. chovat jinak
 * Stavy ovlivnuji soucasny stav letadla, coz je jeho tridni atribut {@code Plane.currentStatus}
 * Atribut je ovlivnen stavem simulace a jakokoukoliv zmenou stavu dale {@code Mapa.statusChange()}
 */
public enum Status {
    PARIS,
    HORSE_LOAD,
    SET_OFF,
    NEXT_STOP,
    FINISHED;
}
