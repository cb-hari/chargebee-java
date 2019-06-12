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

public class ThirdPartyEntityMapping extends Resource<ThirdPartyEntityMapping> {

    public enum EntityType {
        CUSTOMER,
        INVOICE,
        CREDIT_NOTE,
        TRANSACTION,
        PLAN,
        ADDON,
        COUPON,
        SUBSCRIPTION,
        ORDER,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public enum Status {
        SYNCED,
        PARTIALLY_SYNCED,
        CREATE_FAILED,
        UPDATE_FAILED,
        STOPPED,
        IGNORED,
        TO_BE_PICKED,
        FORCE_SYNC,
        MISMATCH,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public enum FailedDependentEntityType {
        CUSTOMER,
        INVOICE,
        CREDIT_NOTE,
        TRANSACTION,
        PLAN,
        ADDON,
        COUPON,
        SUBSCRIPTION,
        ORDER,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    //Constructors
    //============

    public ThirdPartyEntityMapping(String jsonStr) {
        super(jsonStr);
    }

    public ThirdPartyEntityMapping(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public EntityType entityType() {
        return reqEnum("entity_type", EntityType.class);
    }

    public String integrationName() {
        return reqString("integration_name");
    }

    public String thirdPartyEntityId() {
        return optString("third_party_entity_id");
    }

    public Timestamp lastSyncAt() {
        return optTimestamp("last_sync_at");
    }

    public Status status() {
        return optEnum("status", Status.class);
    }

    public FailedDependentEntityType failedDependentEntityType() {
        return optEnum("failed_dependent_entity_type", FailedDependentEntityType.class);
    }

    public String errorMessage() {
        return optString("error_message");
    }

    public String url() {
        return optString("url");
    }

    public Timestamp createdAt() {
        return reqTimestamp("created_at");
    }

    public Timestamp modifiedAt() {
        return reqTimestamp("modified_at");
    }

    public String entityId() {
        return reqString("entity_id");
    }

    public JSONObject newResource() {
        return optJSONObject("new_resource");
    }

    public JSONObject oldResource() {
        return optJSONObject("old_resource");
    }

    public JSONObject mappingMeta() {
        return optJSONObject("mapping_meta");
    }

    public String failedDependentEntityId() {
        return optString("failed_dependent_entity_id");
    }

    // Operations
    //===========

    public static ListAllRequest listAll() throws IOException {
        String uri = uri("third_party_entity_mappings", "list_all");
        return new ListAllRequest(Method.GET, uri);
    }

    public static ThirdPartyEntityMappingListRequest list() throws IOException {
        String uri = uri("third_party_entity_mappings");
        return new ThirdPartyEntityMappingListRequest(uri);
    }

    public static RetrieveEntityRequest retrieveEntity() throws IOException {
        String uri = uri("third_party_entity_mappings", "retrieve");
        return new RetrieveEntityRequest(Method.GET, uri);
    }

    public static UpdateEntityRequest updateEntity() throws IOException {
        String uri = uri("third_party_entity_mappings", "update_entity");
        return new UpdateEntityRequest(Method.POST, uri);
    }


    // Operation Request Classes
    //==========================

    public static class ListAllRequest extends Request<ListAllRequest> {

        private ListAllRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public ListAllRequest integrationName(String integrationName) {
            params.add("integration_name", integrationName);
            return this;
        }


        public EnumFilter<ThirdPartyEntityMapping.EntityType, ListAllRequest> entityType() {
            return new EnumFilter<ThirdPartyEntityMapping.EntityType, ListAllRequest>("entity_type",this);        
        }


        public EnumFilter<ThirdPartyEntityMapping.Status, ListAllRequest> status() {
            return new EnumFilter<ThirdPartyEntityMapping.Status, ListAllRequest>("status",this);        
        }


        public TimestampFilter<ListAllRequest> modifiedAt() {
            return new TimestampFilter<ListAllRequest>("modified_at",this);        
        }


        public StringFilter<ListAllRequest> thirdPartyEntityId() {
            return new StringFilter<ListAllRequest>("third_party_entity_id",this);        
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class ThirdPartyEntityMappingListRequest extends ListRequest<ThirdPartyEntityMappingListRequest> {

        private ThirdPartyEntityMappingListRequest(String uri) {
            super(uri);
        }
    
        public ThirdPartyEntityMappingListRequest integrationName(String integrationName) {
            params.add("integration_name", integrationName);
            return this;
        }


        public EnumFilter<ThirdPartyEntityMapping.EntityType, ThirdPartyEntityMappingListRequest> entityType() {
            return new EnumFilter<ThirdPartyEntityMapping.EntityType, ThirdPartyEntityMappingListRequest>("entity_type",this);        
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class RetrieveEntityRequest extends Request<RetrieveEntityRequest> {

        private RetrieveEntityRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RetrieveEntityRequest entityType(ThirdPartyEntityMapping.EntityType entityType) {
            params.add("entity_type", entityType);
            return this;
        }


        public RetrieveEntityRequest entityId(String entityId) {
            params.add("entity_id", entityId);
            return this;
        }


        public RetrieveEntityRequest integrationName(String integrationName) {
            params.add("integration_name", integrationName);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class UpdateEntityRequest extends Request<UpdateEntityRequest> {

        private UpdateEntityRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public UpdateEntityRequest entityType(ThirdPartyEntityMapping.EntityType entityType) {
            params.add("entity_type", entityType);
            return this;
        }


        public UpdateEntityRequest entityId(String entityId) {
            params.add("entity_id", entityId);
            return this;
        }


        public UpdateEntityRequest thirdPartyEntityId(String thirdPartyEntityId) {
            params.addOpt("third_party_entity_id", thirdPartyEntityId);
            return this;
        }


        public UpdateEntityRequest integrationName(String integrationName) {
            params.add("integration_name", integrationName);
            return this;
        }


        public UpdateEntityRequest status(ThirdPartyEntityMapping.Status status) {
            params.add("status", status);
            return this;
        }


        public UpdateEntityRequest oldResource(JSONObject oldResource) {
            params.addOpt("old_resource", oldResource);
            return this;
        }


        public UpdateEntityRequest mappingMeta(JSONObject mappingMeta) {
            params.addOpt("mapping_meta", mappingMeta);
            return this;
        }


        public UpdateEntityRequest failedDependentEntityId(String failedDependentEntityId) {
            params.addOpt("failed_dependent_entity_id", failedDependentEntityId);
            return this;
        }


        public UpdateEntityRequest failedDependentEntityType(ThirdPartyEntityMapping.FailedDependentEntityType failedDependentEntityType) {
            params.addOpt("failed_dependent_entity_type", failedDependentEntityType);
            return this;
        }


        public UpdateEntityRequest errorMessage(String errorMessage) {
            params.addOpt("error_message", errorMessage);
            return this;
        }


        public UpdateEntityRequest url(String url) {
            params.addOpt("url", url);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

}
