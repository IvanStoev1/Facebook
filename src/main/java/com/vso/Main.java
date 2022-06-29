package com.vso;

import com.vso.controller.Controller;
import com.vso.model.entity.User;
import com.vso.model.service.AuthenticationImpl;
import com.vso.model.service.CommunicationImpl;
import com.vso.model.service.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class Main {

    public static void main(String[] args) {

        new Controller(new AuthenticationImpl(),
                new UserDao(),
                new CommunicationImpl())
                .initializeProgram();

    }

}
