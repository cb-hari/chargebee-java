package com.chargebee.models;

import com.chargebee.*;
import com.chargebee.internal.*;
import com.chargebee.filters.*;
import com.chargebee.filters.enums.SortOrder;
import com.chargebee.internal.HttpUtil.Method;
import com.chargebee.models.enums.*;
import org.json.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class ThirdPartyConfiguration extends Resource<ThirdPartyConfiguration> {

    //Constructors
    //============

    public ThirdPartyConfiguration(String jsonStr) {
        super(jsonStr);
    }

    public ThirdPartyConfiguration(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String integrationName() {
        return reqString("integration_name");
    }

    public Timestamp lastSyncAt() {
        return optTimestamp("last_sync_at");
    }

    public JSONObject configJson() {
        return optJSONObject("config_json");
    }

    public JSONObject authJson() {
        return optJSONObject("auth_json");
    }

    // Operations
    //===========

    public static RetrieveRequest retrieve() throws IOException {
        String uri = uri("third_party_configurations");
        return new RetrieveRequest(Method.GET, uri);
    }

    public static UpdateRequest update() throws IOException {
        String uri = uri("third_party_configurations");
        return new UpdateRequest(Method.POST, uri);
    }


    // Operation Request Classes
    //==========================

    public static class RetrieveRequest extends Request<RetrieveRequest> {

        private RetrieveRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RetrieveRequest integrationName(String integrationName) {
            params.add("integration_name", integrationName);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class UpdateRequest extends Request<UpdateRequest> {

        private UpdateRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public UpdateRequest integrationName(String integrationName) {
            params.add("integration_name", integrationName);
            return this;
        }


        public UpdateRequest configJson(JSONObject configJson) {
            params.addOpt("config_json", configJson);
            return this;
        }


        public UpdateRequest authJson(JSONObject authJson) {
            params.addOpt("auth_json", authJson);
            return this;
        }


        public UpdateRequest lastSyncAt(Timestamp lastSyncAt) {
            params.addOpt("last_sync_at", lastSyncAt);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

}
