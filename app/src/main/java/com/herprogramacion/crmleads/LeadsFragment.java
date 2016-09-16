package com.herprogramacion.crmleads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.google.gson.Gson;

import java.util.Properties;


/**
 * Vista para los leads del CRM
 */
public class LeadsFragment extends Fragment {
    private ListView mLeadsList;
    private LeadsAdapter mLeadsAdapter;
    private static final String CADENA_JSON = "CADENA_JSON";

    public LeadsFragment() {
        // Required empty public constructor
    }

    public static LeadsFragment newInstance(/*parámetros*/) {
        LeadsFragment fragment = new LeadsFragment();
        // Setup parámetros
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Gets parámetros
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_leads, container, false);

        // Instancia del ListView.
        mLeadsList = (ListView) root.findViewById(R.id.leads_list);

        LeadsRepository mLeads = new LeadsRepository(getActivity().getApplicationContext());
        // Inicializar el adaptador con la fuente de datos.
        mLeadsAdapter = new LeadsAdapter(getActivity(),
                mLeads.getLeads());

        //Relacionando la lista con el adaptador
        mLeadsList.setAdapter(mLeadsAdapter);

        // Eventos
        mLeadsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Lead currentLead = mLeadsAdapter.getItem(position);


                final Gson gson = new Gson();
                String json = gson.toJson(currentLead);

                //Al usar fragment, se debe hacer el getActivity
               Intent mIntent = new Intent(getActivity().getApplicationContext(), Detalle.class);
                mIntent.putExtra("objeto", json);
               startActivity(mIntent);
            }
        });

        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_leads_list, menu);
    }

    //*@Override
    //*public boolean onOptionsItemSelected(MenuItem item) {
     //*   int id = item.getItemId();
     //*   if (id == R.id.action_delete_all) {
      //*      // Eliminar todos los leads
       //*     mLeadsAdapter.clear();
        //*    return true;
       //* }
       //* return super.onOptionsItemSelected(item);
   //* }
}
