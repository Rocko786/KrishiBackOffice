package com.utsav.krishibackoffice.networking;

import com.utsav.krishibackoffice.Model.VegCategoryListModel;
import com.utsav.krishibackoffice.Response.ClimateReponse;
import com.utsav.krishibackoffice.Response.DataEntryReportResponse;
import com.utsav.krishibackoffice.Response.UserResponse;
import com.utsav.krishibackoffice.Response.VegCategoryResponse;
import com.utsav.krishibackoffice.Response.VegPhaseResponse;
import com.utsav.krishibackoffice.Response.VegResponse;
import com.utsav.krishibackoffice.Response.VegSubCategoryResponse;
import com.utsav.krishibackoffice.Response.VegTypeResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface KrishiApi {
    @POST("KrishiMain/UserLogin")
    Call<UserResponse> userlogin(@Query("UserCode") String UserCode,
                                 @Query("UserPassword") String UserPassword);

    @GET("KrishiDataSave/BindClimate")
    Call<ClimateReponse> getClimates();
    @GET("KrishiDataSave/BindVegType")
    Call<VegTypeResponse> getVegType();

    @GET("KrishiDataSave/BindVegCategory")
    Call<VegCategoryResponse> getVegCategory(@Query("ClimateId") int ClimateId,
                                             @Query("VegTypeId") int VegTypeId);

    @GET("KrishiDataSave/BindVegPhase")
    Call<VegPhaseResponse> getVegPhase(@Query("VegCategoryId") int VegCategoryId);

    @GET("KrishiDataSave/BindVegSubCategory")
    Call<VegSubCategoryResponse> getVegSubCategory(@Query("VegCategoryId") int VegCategoryId);

    @GET("KrishiDataSave/BindVeg")
    Call<VegResponse> getVeg(@Query("VegCategoryId") int VegCategoryId,
                             @Query("VegSubCategoryId") int VegSubCategoryId);


    @GET("KrishiDataSave/GetAllReport")
    Call<DataEntryReportResponse> getDataEntryReportGetAll(@Query("FromDate") String FromDate,
                                                           @Query("ToDate") String  ToDate,
                                                           @Query("ClimateId") int ClimateId,
                                                           @Query("VegPhaseId") int VegPhaseId,
                                                           @Query("VegCategoryId") int VegCategoryId,
                                                           @Query("VegTypeId") int VegTypeId,
                                                           @Query("VegSubCategoryId") int VegSubCategoryId,
                                                           @Query("VegId") int VegId,
                                                           @Query("UserId") int UserId);
}
