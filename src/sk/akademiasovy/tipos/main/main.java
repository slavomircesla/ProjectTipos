package sk.akademiasovy.tipos.main;

import sk.akademiasovy.tipos.Tipos;
import sk.akademiasovy.tipos.database.MYSQLDatabase;

public class main {
    public static void main(String[] args) {

        Tipos tipos= new Tipos();


        tipos.sort();
        tipos.print();
        tipos.generate();

        MYSQLDatabase mysqlDatabase=new MYSQLDatabase();

        mysqlDatabase.testConnection();

        mysqlDatabase.insertValuesIntoDrawHistory(tipos.getArr());
    }
    }
