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

public class ThirdPartySyncDetail extends Resource<ThirdPartySyncDetail> {

    public enum Status {
        SUCCEEDED,
        FAILED,
        STARTED,
        RUNNING,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    //Constructors
    //============

    public ThirdPartySyncDetail(String jsonStr) {
        super(jsonStr);
    }

    public ThirdPartySyncDetail(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String id() {
        return reqString("id");
    }

    public String integrationName() {
        return optString("integration_name");
    }

    public Status status() {
        return reqEnum("status", Status.class);
    }

    public JSONObject context() {
        return optJSONObject("context");
    }

    // Operations
    //===========

    public static CreateRequest create() throws IOException {
        String uri = uri("third_party_sync_details");
        return new CreateRequest(Method.POST, uri);
    }

    public static Request retrieve(String id) throws IOException {
        String uri = uri("third_party_sync_details", nullCheck(id));
        return new Request(Method.GET, uri);
    }

    public static RetrieveLatestSyncRequest retrieveLatestSync() throws IOException {
        String uri = uri("third_party_sync_details", "retrieve_latest_sync");
        return new RetrieveLatestSyncRequest(Method.GET, uri);
    }

    public static UpdateRequest update(String id) throws IOException {
        String uri = uri("third_party_sync_details", nullCheck(id));
        return new UpdateRequest(Method.POST, uri);
    }


    // Operation Request Classes
    //==========================

    public static class CreateRequest extends Request<CreateRequest> {

        private CreateRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public CreateRequest context(JSONObject context) {
            params.addOpt("context", context);
            return this;
        }


        public CreateRequest thirdPartyConfigurationIntegrationName(String thirdPartyConfigurationIntegrationName) {
            params.add("third_party_configuration[integration_name]", thirdPartyConfigurationIntegrationName);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class RetrieveLatestSyncRequest extends Request<RetrieveLatestSyncRequest> {

        private RetrieveLatestSyncRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RetrieveLatestSyncRequest thirdPartyConfigurationIntegrationName(String thirdPartyConfigurationIntegrationName) {
            params.add("third_party_configuration[integration_name]", thirdPartyConfigurationIntegrationName);
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
    
        public UpdateRequest status(ThirdPartySyncDetail.Status status) {
            params.add("status", status);
            return this;
        }


        public UpdateRequest context(JSONObject context) {
            params.addOpt("context", context);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

}
