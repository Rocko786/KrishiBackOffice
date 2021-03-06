package com.utsav.krishibackoffice.fragments;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.utsav.krishibackoffice.Model.ClimateListModel;
import com.utsav.krishibackoffice.Model.DataEntryReportListModel;
import com.utsav.krishibackoffice.Model.VegCategoryListModel;
import com.utsav.krishibackoffice.Model.VegListModel;
import com.utsav.krishibackoffice.Model.VegPhaseListModel;
import com.utsav.krishibackoffice.Model.VegSubCategoryListModel;
import com.utsav.krishibackoffice.Model.VegTypeListModel;
import com.utsav.krishibackoffice.R;
import com.utsav.krishibackoffice.StoreInfo.LocalStorage;
import com.utsav.krishibackoffice.ViewModel.ClimateViewModel;
import com.utsav.krishibackoffice.ViewModel.DataEntryReportViewModel;
import com.utsav.krishibackoffice.ViewModel.UserViewModel;
import com.utsav.krishibackoffice.ViewModel.VegCategoryViewModel;
import com.utsav.krishibackoffice.ViewModel.VegPhaseViewModel;
import com.utsav.krishibackoffice.ViewModel.VegSubCategoryViewModel;
import com.utsav.krishibackoffice.ViewModel.VegTypeViewModel;
import com.utsav.krishibackoffice.ViewModel.VegViewModel;
import com.utsav.krishibackoffice.activities.MainActivity;
import com.utsav.krishibackoffice.adapters.DataEntryReportAdapter;
import com.utsav.krishibackoffice.models.DataEntryModel;
import com.utsav.krishibackoffice.models.UserModel;

import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataReportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataReportFragment extends Fragment {
    AppCompatTextView txt_fromdate,txt_todate;
    LinearLayoutCompat lin_pro;
    MainActivity mainActivity;
    String todateindicator="",fromdateindicator="";
    String txtFromdate="",txtTodate="";
    DatePickerDialog datePickerDialog;
    ClimateViewModel climateViewModel;
    VegTypeViewModel vegTypeViewModel;
    VegCategoryViewModel vegCategoryViewModel;
    VegPhaseViewModel vegPhaseViewModel;
    VegSubCategoryViewModel vegSubCategoryViewModel;
    DataEntryReportViewModel  dataEntryReportViewModel;
    VegViewModel vegViewModel;
    Spinner spn_mosum;
    Spinner spn_FasolProkar;
    Spinner spn_FasolName;
    Spinner spn_FasolAbstha;
    Spinner spn_FasolJat;
    Spinner spn_Fasol;
    AppCompatButton btn_search,btn_back;
    RelativeLayout rel_search,rel_report;
    RecyclerView rec_entry_report;
    ProgressBar pro_cir;
    LocalStorage localStorage;
    UserModel user;
    int UserId;

    DataEntryReportAdapter dataEntryReportAdapter;

    ArrayList<ClimateListModel> climateListModelArrayList = new ArrayList<>();
    ArrayList<VegCategoryListModel> vegCategoryListModelArrayList = new ArrayList<>();
    ArrayAdapter<ClimateListModel> climateListModelArrayAdapter;
    ArrayList<VegTypeListModel> vegTypeListModelArrayList = new ArrayList<>();
    ArrayAdapter<VegTypeListModel> vegTypeListModelArrayAdapter;
    ArrayAdapter<VegCategoryListModel> vegCategoryListModelArrayAdapter;
    ArrayList<VegPhaseListModel> vegPhaseListModelArrayList = new ArrayList<>();

    ArrayList<DataEntryReportListModel> dataEntryReportListModelArrayList = new ArrayList<>();
    ArrayAdapter<VegPhaseListModel> vegPhaseListModelArrayAdapter;

    ArrayList<VegSubCategoryListModel> vegSubCategoryListModelArrayList = new ArrayList<>();
    ArrayAdapter<VegSubCategoryListModel> vegSubCategoryListModelArrayAdapter;

    ArrayList<VegListModel> vegListModelArrayList = new ArrayList<>();
    ArrayAdapter<VegListModel> vegListModelArrayAdapter;
    int ClimateId=0;
    int VegTypeId=0,VegCategoryId=0,VegPhaseId=0,VegSubCategoryId=0,VegId=0;


    public DataReportFragment() {
        // Required empty public constructor
    }


    public static DataReportFragment newInstance(String param1, String param2) {
        DataReportFragment fragment = new DataReportFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_data_report, container, false);
        instance(view);
        clickevent();
        return view;
    }


    private void clickevent() {
        txt_fromdate.setOnClickListener(v -> {
            setupFromDate();
        });

        txt_todate.setOnClickListener(v -> {
            setupToDate();
        });

        btn_search.setOnClickListener(view -> {
            validfields();
        });
        btn_back.setOnClickListener(view -> {
            backAllOptions();
        });

    }

    private void backAllOptions() {
        rel_search.setVisibility(View.VISIBLE);
        rel_report.setVisibility(View.GONE);
    }

    private void validfields() {
            if(ClimateId==0){
                showAlertMessage("Please Select Climate");
            }
            else  if(VegPhaseId==0){
                showAlertMessage("Please Select VegPhase");
            }
            else  if(VegCategoryId==0){
                showAlertMessage("Please Select VegCategory");
            }
            else  if(VegTypeId==0){
                showAlertMessage("Please Select VegType");
            }
            else  if(VegSubCategoryId==0){
                showAlertMessage("Please Select VegSubCategory");
            }
            /*else  if(VegId==0){
                showAlertMessage("Please Select Veg");
            }*/
            else {
                getAllReports();
            }

    }
    private void getAllReports() {
        if(txtFromdate.equals("")){
            txtFromdate="NULL";
        }

        if(txtTodate.equals("")){
            txtTodate="NULL";
        }
        try{
            setProgressbar(1);
            dataEntryReportListModelArrayList.clear();
            DataEntryModel entrymodel;
            entrymodel=new DataEntryModel(txtFromdate,txtTodate,ClimateId,VegPhaseId,VegCategoryId,VegTypeId,VegSubCategoryId,VegId,UserId);

                 dataEntryReportViewModel=ViewModelProviders.of(this).get(DataEntryReportViewModel.class);
                dataEntryReportViewModel.getDataEntryReportGetAll(entrymodel).observe(mainActivity, datareports -> {
                    setProgressbar(0);
                List<DataEntryReportListModel> dataEntryReportListModels = datareports.getDataEntryReportListModels();
                if(dataEntryReportListModels!=null)
                dataEntryReportListModelArrayList.addAll(dataEntryReportListModels);
                   // dataEntryReportAdapter.notifyDataSetChanged();
                    if(dataEntryReportListModelArrayList.size() > 0){
                        rel_search.setVisibility(View.GONE);
                        rel_report.setVisibility(View.VISIBLE);
                        setupRecyclerView();

                    }
                    else {
                        setProgressbar(0);
                        showAlertMessage("???????????? ?????????????????? ?????????????????? |");
                        rel_search.setVisibility(View.VISIBLE);
                        rel_report.setVisibility(View.GONE);
                    }
            });



        }
        catch (Exception ex){
            setProgressbar(0);
            showAlertMessage(ex.getMessage());
        }
        finally {
            setProgressbar(0);
        }
    }

    private void setupRecyclerView() {
        if (dataEntryReportAdapter == null) {
            dataEntryReportAdapter = new DataEntryReportAdapter(mainActivity, dataEntryReportListModelArrayList);
            rec_entry_report.setLayoutManager(new LinearLayoutManager(mainActivity));
            rec_entry_report.setAdapter(dataEntryReportAdapter);
            rec_entry_report.setItemAnimator(new DefaultItemAnimator());
            rec_entry_report.setNestedScrollingEnabled(true);
        } else {
            dataEntryReportAdapter.notifyDataSetChanged();
        }
    }

    private void showAlertMessage(String msg){
        new SweetAlertDialog(mainActivity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText(msg)
                .show();
    }
    private void setupFromDate() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        datePickerDialog=new DatePickerDialog(mainActivity, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                // set day of month , month and year value in the edit text
                String setFromDate=(dayOfMonth + "/"
                        + (monthOfYear + 1) + "/" + year);
                txt_fromdate.setText(setFromDate);
                txtFromdate=setFromDate;
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    private void setupToDate() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        datePickerDialog=new DatePickerDialog(mainActivity, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                // set day of month , month and year value in the edit text
                String setToDate=(dayOfMonth + "/"
                        + (monthOfYear + 1) + "/" + year);
                txt_todate.setText(setToDate);
                txtTodate=setToDate;
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    private void instance(View view) {
        mainActivity=(MainActivity)getActivity();
        localStorage = new LocalStorage(mainActivity);
        String userString = localStorage.getUserLogin();
        Gson gson = new Gson();
        user = gson.fromJson(userString, UserModel.class);
        if (user != null) {
            UserId=user.getUserId();
        }

        txt_fromdate=view.findViewById(R.id.txt_fromdate);
        txt_todate=view.findViewById(R.id.txt_todate);
        spn_mosum=view.findViewById(R.id.spn_mosum);
        spn_FasolProkar=view.findViewById(R.id.spn_FasolProkar);
        spn_FasolName=view.findViewById(R.id.spn_FasolName);
        spn_FasolAbstha=view.findViewById(R.id.spn_FasolAbstha);
        spn_FasolJat=view.findViewById(R.id.spn_FasolJat);
        spn_Fasol=view.findViewById(R.id.spn_Fasol);
        btn_search=view.findViewById(R.id.btn_search);
        btn_back=view.findViewById(R.id.btn_back);
        rel_report=view.findViewById(R.id.rel_report);
        rel_search=view.findViewById(R.id.rel_search);
        rec_entry_report=view.findViewById(R.id.rec_entry_report);
        pro_cir=view.findViewById(R.id.pro_cir);
        lin_pro=view.findViewById(R.id.lin_pro);
        bindClimates();
        bindVegType();
     //   bindVegCategory(ClimateId,VegTypeId);

    }

    private void setProgressbar(int check){
        if(check==1){
            pro_cir.getProgress();
            lin_pro.setVisibility(View.VISIBLE);

        }
        else {
            lin_pro.setVisibility(View.GONE);
        }
    }
    private void bindClimates() {
        setProgressbar(1);
        climateListModelArrayList.clear();
        try {
            climateViewModel = ViewModelProviders.of(this).get(ClimateViewModel.class);
            climateViewModel.getClimates();
            climateViewModel.getClimateRepository().observe(mainActivity,climateReponse -> {

                List<ClimateListModel> climates = climateReponse.getClimates();
                climateListModelArrayList.addAll(climates);
                setupClimate(climateListModelArrayList);
            });
        }
        catch (Exception ex){
            setProgressbar(0);
            showAlertMessage(ex.getMessage());
        }
        finally {
            setProgressbar(0);
        }
    }
    private void setupClimate(ArrayList<ClimateListModel> climateListModelArrayList) {
        setProgressbar(0);
        climateListModelArrayAdapter = new ArrayAdapter<>(mainActivity, android.R.layout.simple_spinner_item, climateListModelArrayList);
        climateListModelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_mosum.setAdapter(climateListModelArrayAdapter);
        spn_mosum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(climateListModelArrayList!=null)
                getSelectedClimate(climateListModelArrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void getSelectedClimate(ClimateListModel climateListModel) {
        ClimateId=climateListModel.getClimateId();
        //bindVegCategory(ClimateId,VegTypeId);
    }
    private void bindVegType() {
        setProgressbar(1);
        vegTypeListModelArrayList.clear();
        try {
            vegTypeViewModel = ViewModelProviders.of(this).get(VegTypeViewModel.class);
            vegTypeViewModel.getVegType();
            vegTypeViewModel.getVegTypeRepository().observe(mainActivity,vegTypeReponse -> {
                setProgressbar(0);
                List<VegTypeListModel> vegType = vegTypeReponse.getVegType();
                vegTypeListModelArrayList.addAll(vegType);
                setupVegType(vegTypeListModelArrayList);
            });
        }
        catch (Exception ex){
            setProgressbar(0);
            showAlertMessage(ex.getMessage());
        }
        finally {
            setProgressbar(0);
        }
    }
    private void setupVegType(ArrayList<VegTypeListModel> vegTypeListModelArrayList) {
        vegTypeListModelArrayAdapter = new ArrayAdapter<>(mainActivity, android.R.layout.simple_spinner_item, vegTypeListModelArrayList);
        vegTypeListModelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_FasolProkar.setAdapter(vegTypeListModelArrayAdapter);
        spn_FasolProkar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(vegTypeListModelArrayList!=null)
                getSelectedVegType(vegTypeListModelArrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void getSelectedVegType(VegTypeListModel vegTypeListModel) {
        VegTypeId=vegTypeListModel.getVegTypeId();
        bindVegCategory(ClimateId,VegTypeId);
    }

    private void bindVegCategory(int ClimateId, int VegTypeId) {
        setProgressbar(1);
        vegCategoryListModelArrayList.clear();
        try {
            vegCategoryViewModel = ViewModelProviders.of(this).get(VegCategoryViewModel.class);
            vegCategoryViewModel.getVegCategoryRepository(ClimateId,VegTypeId).observe(mainActivity,vegCategoryResponse -> {
                setProgressbar(0);
                List<VegCategoryListModel> vegCategories = vegCategoryResponse.getVegCategoryList();
                vegCategoryListModelArrayList.addAll(vegCategories);
                setupVegCategory(vegCategoryListModelArrayList);
            });
        }
        catch (Exception ex){
            setProgressbar(0);
            showAlertMessage(ex.getMessage());
        }
        finally {
            setProgressbar(0);
        }
    }
    private void setupVegCategory(ArrayList<VegCategoryListModel> vegCategoryListModelArrayList) {
        vegCategoryListModelArrayAdapter = new ArrayAdapter<>(mainActivity, android.R.layout.simple_spinner_item, vegCategoryListModelArrayList);
        vegCategoryListModelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_FasolName.setAdapter(vegCategoryListModelArrayAdapter);
        spn_FasolName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(vegCategoryListModelArrayList!=null)
                getSelectedVegCategory(vegCategoryListModelArrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void getSelectedVegCategory(VegCategoryListModel vegCategoryListModel) {
        VegCategoryId=vegCategoryListModel.getVegCategoryId();
        //if(VegCategoryId>0){
            bindVegPhase(VegCategoryId);
            bindVegSubCategory(VegCategoryId);
       // }

    }

    private void bindVegPhase(int VegCategoryId) {
        setProgressbar(1);
        vegPhaseListModelArrayList.clear();
        try {
            vegPhaseViewModel = ViewModelProviders.of(this).get(VegPhaseViewModel.class);
            vegPhaseViewModel.getVegPhaseRepository(VegCategoryId).observe(mainActivity,vegPhaseResponse -> {
                setProgressbar(0);
                List<VegPhaseListModel> vegPhase = vegPhaseResponse.getVegPhaseList();
                vegPhaseListModelArrayList.addAll(vegPhase);
                setupVegPhase(vegPhaseListModelArrayList);
            });
        }
        catch (Exception ex){
            setProgressbar(0);
            showAlertMessage(ex.getMessage());
        }
        finally {
            setProgressbar(0);
        }
    }
    private void setupVegPhase(ArrayList<VegPhaseListModel> vegPhaseListModelArrayList) {
        vegPhaseListModelArrayAdapter = new ArrayAdapter<>(mainActivity, android.R.layout.simple_spinner_item, vegPhaseListModelArrayList);
        vegPhaseListModelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_FasolAbstha.setAdapter(vegPhaseListModelArrayAdapter);
        spn_FasolAbstha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(vegPhaseListModelArrayList!=null)
                getSelectedVegPhase(vegPhaseListModelArrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void getSelectedVegPhase(VegPhaseListModel vegPhaseListModel) {
        VegPhaseId=vegPhaseListModel.getVegPhaseId();
    }

    private void bindVegSubCategory(int VegCategoryId) {
        setProgressbar(1);
        vegSubCategoryListModelArrayList.clear();
        try {
            vegSubCategoryViewModel = ViewModelProviders.of(this).get(VegSubCategoryViewModel.class);
            vegSubCategoryViewModel.getVegSubCategoryRepository(VegCategoryId).observe(mainActivity,vegSubCategoryResponse -> {
                setProgressbar(0);
                List<VegSubCategoryListModel> vegSubCategory = vegSubCategoryResponse.getVegSubCategoryList();
                vegSubCategoryListModelArrayList.addAll(vegSubCategory);
                setupVegSubCategory(vegSubCategoryListModelArrayList);
            });
        }
        catch (Exception ex){
            setProgressbar(0);
            showAlertMessage(ex.getMessage());
        }
        finally {
            setProgressbar(0);
        }
    }
    private void setupVegSubCategory(ArrayList<VegSubCategoryListModel> vegSubCategoryListModelArrayList) {
        vegSubCategoryListModelArrayAdapter = new ArrayAdapter<>(mainActivity, android.R.layout.simple_spinner_item, vegSubCategoryListModelArrayList);
        vegSubCategoryListModelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_FasolJat.setAdapter(vegSubCategoryListModelArrayAdapter);
        spn_FasolJat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(vegSubCategoryListModelArrayList!=null)
                getSelectedVegSubCategory(vegSubCategoryListModelArrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void getSelectedVegSubCategory(VegSubCategoryListModel vegSubCategoryListModel) {
        VegSubCategoryId=vegSubCategoryListModel.getVegSubCategoryId();
        bindVeg(VegCategoryId,VegSubCategoryId);
    }

    private void bindVeg(int VegCategoryId, int VegSubCategoryId) {
        setProgressbar(1);
        vegListModelArrayList.clear();
        try {
            vegViewModel = ViewModelProviders.of(this).get(VegViewModel.class);
            vegViewModel.getVegRepository(VegCategoryId,VegSubCategoryId).observe(mainActivity,vegResponse -> {
                setProgressbar(0);
                List<VegListModel> veg = vegResponse.getVegList();
                vegListModelArrayList.addAll(veg);
                setupVeg(vegListModelArrayList);
            });
        }
        catch (Exception ex){
            setProgressbar(0);
            showAlertMessage(ex.getMessage());
        }
        finally {
            setProgressbar(0);
        }
    }
    private void setupVeg(ArrayList<VegListModel> vegListModelArrayList) {
        vegListModelArrayAdapter = new ArrayAdapter<>(mainActivity, android.R.layout.simple_spinner_item, vegListModelArrayList);
        vegListModelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_Fasol.setAdapter(vegListModelArrayAdapter);
        spn_Fasol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(vegListModelArrayList!=null)
                getSelectedVeg(vegListModelArrayList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void getSelectedVeg(VegListModel vegListModel) {
        VegId=vegListModel.getVegId();


    }
}