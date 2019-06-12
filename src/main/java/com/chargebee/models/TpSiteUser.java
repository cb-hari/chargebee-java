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

public class TpSiteUser extends Resource<TpSiteUser> {

    //Constructors
    //============

    public TpSiteUser(String jsonStr) {
        super(jsonStr);
    }

    public TpSiteUser(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String hostedPageToken() {
        return optString("hosted_page_token");
    }

    public String email() {
        return reqString("email");
    }

    public String domain() {
        return reqString("domain");
    }

    // Operations
    //===========

    public static ListRequest usersForTpSiteUser(String id) throws IOException {
        String uri = uri("tp_site_users", nullCheck(id), "users");
        return new ListRequest(uri);
    }

    public static ListRequest guestsForTpSiteUser(String id) throws IOException {
        String uri = uri("tp_site_users", nullCheck(id), "guests");
        return new ListRequest(uri);
    }

    public static PayNowEnableLiveRequest payNowEnableLive() throws IOException {
        String uri = uri("tp_site_users", "pay_now_enable_live");
        return new PayNowEnableLiveRequest(Method.POST, uri);
    }


    // Operation Request Classes
    //==========================

    public static class PayNowEnableLiveRequest extends Request<PayNowEnableLiveRequest> {

        private PayNowEnableLiveRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public PayNowEnableLiveRequest domain(String domain) {
            params.add("domain", domain);
            return this;
        }


        public PayNowEnableLiveRequest hostedPageToken(String hostedPageToken) {
            params.add("hosted_page_token", hostedPageToken);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

}
