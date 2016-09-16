package com.herprogramacion.crmleads;

import android.content.Context;
import android.database.Cursor;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Repositorio ficticio de leads
 */
public class LeadsRepository {
    //private static LeadsRepository repository = new LeadsRepository();
    private HashMap<String, Lead> leads = new HashMap<>();
    TextView txtContent;
    DBController dbController;

    /*public static LeadsRepository getInstance() {
        return repository;
    }*/

    public void showData() {
        //txtContent.setText("");

    }

    public LeadsRepository(Context mContext) {
        dbController = new DBController(mContext);
        dbController.open();
        Cursor cursor = dbController.getData();
        if (cursor.moveToFirst()) {
            do {
//                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String descripcion = cursor.getString(2);
                String fechaIni = cursor.getString(3);

                saveLead(new Lead(name,fechaIni, descripcion));

            } while (cursor.moveToNext());
        }
        dbController.close();

        /*
        saveLead(new Lead("Carlos Lopez", "Asistente", "Hospital Blue", R.drawable.lead_photo_2));
        saveLead(new Lead("Sara Bonz", "Directora de Marketing", "Electrical Parts ltd", R.drawable.lead_photo_3));
        saveLead(new Lead("Liliana Clarence", "Diseñadora de Producto", "Creativa App", R.drawable.lead_photo_4));
        saveLead(new Lead("Benito Peralta", "Supervisor de Ventas", "Neumáticos Press", R.drawable.lead_photo_5));
        saveLead(new Lead("Juan Jaramillo", "CEO", "Banco Nacional", R.drawable.lead_photo_6));
        saveLead(new Lead("Christian Steps", "CTO", "Cooperativa Verde", R.drawable.lead_photo_7));
        saveLead(new Lead("Alexa Giraldo", "Lead Programmer", "Frutisofy", R.drawable.lead_photo_8));
        saveLead(new Lead("Linda Murillo", "Directora de Marketing", "Seguros Boliver", R.drawable.lead_photo_9));
        saveLead(new Lead("Lizeth Astrada", "CEO", "Concesionario Motolox", R.drawable.lead_photo_10));*/
    }

    private void saveLead(Lead lead) {
        leads.put(lead.getId(), lead);
    }

    public List<Lead> getLeads() {
        return new ArrayList<>(leads.values());
    }
}
