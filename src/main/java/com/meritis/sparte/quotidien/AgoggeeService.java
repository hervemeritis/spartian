package com.meritis.sparte.quotidien;

import com.meritis.sparte.people.Citoyen;
import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.JeuneCitoyen;

public class AgoggeeService {
    private final JeuneCitoyenDeleter jeuneCitoyenDeleter;
    private final JeuneCitoyenRetriever jeuneCitoyenRetriever;
    private final CitoyenCreator citoyenCreator;

    public AgoggeeService(JeuneCitoyenDeleter jeuneCitoyenDeleter, JeuneCitoyenRetriever jeuneCitoyenRetriever, CitoyenCreator citoyenCreator) {
        this.jeuneCitoyenDeleter = jeuneCitoyenDeleter;
        this.jeuneCitoyenRetriever = jeuneCitoyenRetriever;
        this.citoyenCreator = citoyenCreator;
    }

    public Citoyen agogee(String citoyenName) {
        JeuneCitoyen jeuneCitoyen = jeuneCitoyenRetriever.retrieveByName(citoyenName);
        //TODO le modifier
        if (jeuneCitoyen.age < 20) {
            return jeuneCitoyen;
        }
        Homoioi spartiate = jeuneCitoyen.agogee();
        jeuneCitoyenDeleter.delete(jeuneCitoyen);
        citoyenCreator.create(spartiate);
        return spartiate;
    }
}
