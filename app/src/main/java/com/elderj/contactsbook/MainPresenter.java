package com.elderj.contactsbook;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {

    private MainActivityView view;
    private DatabaseConnecting dbConnector;

    public MainPresenter(MainActivityView view, DatabaseConnecting dbConnector) {
        this.view = view;
        this.dbConnector = dbConnector;
    }

    public void saveOrgButtonTapped(String name, String email, String phone) {
        dbConnector.createOrg(name, email, phone, new DatabaseCallback() {
            @Override
            public void actionComplete() {
                List<String> orgNames = dbConnector.readAllOrgs();
                view.showOrgList(orgNames);
            }

        });
    }

    public void onResume() {
        ArrayList<String> orgs = dbConnector.readAllOrgs();

        view.showOrgList(orgs);
    }

}
