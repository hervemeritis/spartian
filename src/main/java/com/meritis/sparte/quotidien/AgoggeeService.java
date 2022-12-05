package com.meritis.sparte.quotidien;

import com.meritis.sparte.people.Citoyen;
import com.meritis.sparte.people.JeuneCitoyen;

public class AgoggeeService {
    private final JeuneCitoyenDeleter jeuneCitoyenDeleter;
    private final JeuneCitoyenRetriever jeuneCitoyenRetriever;
    private final CitoyenCreator citoyenCreator;

    private final SpartiateArmyManager spartiateArmyManager;

    public AgoggeeService(JeuneCitoyenDeleter jeuneCitoyenDeleter, JeuneCitoyenRetriever jeuneCitoyenRetriever, CitoyenCreator citoyenCreator, SpartiateArmyManager spartiateArmyManager) {
        this.jeuneCitoyenDeleter = jeuneCitoyenDeleter;
        this.jeuneCitoyenRetriever = jeuneCitoyenRetriever;
        this.citoyenCreator = citoyenCreator;
        this.spartiateArmyManager = spartiateArmyManager;
    }

    public Citoyen agogee(String citoyenName) {
        JeuneCitoyen jeuneCitoyen = jeuneCitoyenRetriever.retrieveByName(citoyenName);
        if (!jeuneCitoyen.isAgogee()) {
            return jeuneCitoyen;
        }
        Citoyen citoyen = jeuneCitoyen.agogee();
        jeuneCitoyenDeleter.delete(jeuneCitoyen);
        citoyenCreator.create(citoyen);
        if (citoyen.aFaitSonAgogee()) {
            spartiateArmyManager.enrole(citoyen)
                                .equipe(citoyen);

        }
        return citoyen;
    }
}
