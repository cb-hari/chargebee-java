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

public class Transaction extends Resource<Transaction> {

    public enum Type {
        AUTHORIZATION,
        PAYMENT,
        REFUND,
        PAYMENT_REVERSAL,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public enum Status {
        IN_PROGRESS,
        SUCCESS,
        VOIDED,
        FAILURE,
        TIMEOUT,
        NEEDS_ATTENTION,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public enum FraudFlag {
        SAFE,
        SUSPICIOUS,
        FRAUDULENT,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public enum AuthorizationReason {
        BLOCKING_FUNDS,
        VERIFICATION,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public static class LinkedInvoice extends Resource<LinkedInvoice> {
        public LinkedInvoice(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String invoiceId() {
            return reqString("invoice_id");
        }

        public Integer appliedAmount() {
            return reqInteger("applied_amount");
        }

        public Timestamp appliedAt() {
            return reqTimestamp("applied_at");
        }

        public Timestamp invoiceDate() {
            return optTimestamp("invoice_date");
        }

        public Integer invoiceTotal() {
            return optInteger("invoice_total");
        }

        public Invoice.Status invoiceStatus() {
            return reqEnum("invoice_status", Invoice.Status.class);
        }

    }

    public static class LinkedCreditNote extends Resource<LinkedCreditNote> {
        public LinkedCreditNote(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String cnId() {
            return reqString("cn_id");
        }

        public Integer appliedAmount() {
            return reqInteger("applied_amount");
        }

        public Timestamp appliedAt() {
            return reqTimestamp("applied_at");
        }

        public CreditNote.ReasonCode cnReasonCode() {
            return reqEnum("cn_reason_code", CreditNote.ReasonCode.class);
        }

        public Timestamp cnDate() {
            return optTimestamp("cn_date");
        }

        public Integer cnTotal() {
            return optInteger("cn_total");
        }

        public CreditNote.Status cnStatus() {
            return reqEnum("cn_status", CreditNote.Status.class);
        }

        public String cnReferenceInvoiceId() {
            return reqString("cn_reference_invoice_id");
        }

    }

    public static class LinkedRefund extends Resource<LinkedRefund> {
        public LinkedRefund(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String txnId() {
            return reqString("txn_id");
        }

        public Transaction.Status txnStatus() {
            return reqEnum("txn_status", Transaction.Status.class);
        }

        public Timestamp txnDate() {
            return reqTimestamp("txn_date");
        }

        public Integer txnAmount() {
            return reqInteger("txn_amount");
        }

    }

    public static class LinkedPayment extends Resource<LinkedPayment> {
        public enum Status {
             IN_PROGRESS,SUCCESS,VOIDED,FAILURE,TIMEOUT,NEEDS_ATTENTION,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public LinkedPayment(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String id() {
            return reqString("id");
        }

        public Status status() {
            return reqEnum("status", Status.class);
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public Timestamp date() {
            return reqTimestamp("date");
        }

    }

    //Constructors
    //============

    public Transaction(String jsonStr) {
        super(jsonStr);
    }

    public Transaction(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String id() {
        return reqString("id");
    }

    public String customerId() {
        return optString("customer_id");
    }

    public String subscriptionId() {
        return optString("subscription_id");
    }

    public String gatewayAccountId() {
        return optString("gateway_account_id");
    }

    public String paymentSourceId() {
        return optString("payment_source_id");
    }

    public PaymentMethod paymentMethod() {
        return reqEnum("payment_method", PaymentMethod.class);
    }

    public String referenceNumber() {
        return optString("reference_number");
    }

    public Gateway gateway() {
        return reqEnum("gateway", Gateway.class);
    }

    public Type type() {
        return reqEnum("type", Type.class);
    }

    public Timestamp date() {
        return optTimestamp("date");
    }

    public Timestamp settledAt() {
        return optTimestamp("settled_at");
    }

    public String currencyCode() {
        return reqString("currency_code");
    }

    public Integer amount() {
        return optInteger("amount");
    }

    public String idAtGateway() {
        return optString("id_at_gateway");
    }

    public Status status() {
        return optEnum("status", Status.class);
    }

    public FraudFlag fraudFlag() {
        return optEnum("fraud_flag", FraudFlag.class);
    }

    public AuthorizationReason authorizationReason() {
        return optEnum("authorization_reason", AuthorizationReason.class);
    }

    public String errorCode() {
        return optString("error_code");
    }

    public String errorText() {
        return optString("error_text");
    }

    public Timestamp voidedAt() {
        return optTimestamp("voided_at");
    }

    public Long resourceVersion() {
        return optLong("resource_version");
    }

    public Timestamp updatedAt() {
        return optTimestamp("updated_at");
    }

    public String fraudReason() {
        return optString("fraud_reason");
    }

    public Integer amountUnused() {
        return optInteger("amount_unused");
    }

    public String maskedCardNumber() {
        return optString("masked_card_number");
    }

    public String referenceTransactionId() {
        return optString("reference_transaction_id");
    }

    public String refundedTxnId() {
        return optString("refunded_txn_id");
    }

    public String referenceAuthorizationId() {
        return optString("reference_authorization_id");
    }

    public Integer amountCapturable() {
        return optInteger("amount_capturable");
    }

    public String reversalTransactionId() {
        return optString("reversal_transaction_id");
    }

    public List<Transaction.LinkedInvoice> linkedInvoices() {
        return optList("linked_invoices", Transaction.LinkedInvoice.class);
    }

    public List<Transaction.LinkedCreditNote> linkedCreditNotes() {
        return optList("linked_credit_notes", Transaction.LinkedCreditNote.class);
    }

    public List<Transaction.LinkedRefund> linkedRefunds() {
        return optList("linked_refunds", Transaction.LinkedRefund.class);
    }

    public List<Transaction.LinkedPayment> linkedPayments() {
        return optList("linked_payments", Transaction.LinkedPayment.class);
    }

    public Boolean deleted() {
        return reqBoolean("deleted");
    }

    // Operations
    //===========

    public static CreateAuthorizationRequest createAuthorization() throws IOException {
        String uri = uri("transactions", "create_authorization");
        return new CreateAuthorizationRequest(Method.POST, uri);
    }

    public static Request voidTransaction(String id) throws IOException {
        String uri = uri("transactions", nullCheck(id), "void");
        return new Request(Method.POST, uri);
    }

    public static TransactionListRequest list() throws IOException {
        String uri = uri("transactions");
        return new TransactionListRequest(uri);
    }

    @Deprecated
    public static ListRequest transactionsForCustomer(String id) throws IOException {
        String uri = uri("customers", nullCheck(id), "transactions");
        return new ListRequest(uri);
    }

    @Deprecated
    public static ListRequest transactionsForSubscription(String id) throws IOException {
        String uri = uri("subscriptions", nullCheck(id), "transactions");
        return new ListRequest(uri);
    }

    public static ListRequest paymentsForInvoice(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "payments");
        return new ListRequest(uri);
    }

    public static Request retrieve(String id) throws IOException {
        String uri = uri("transactions", nullCheck(id));
        return new Request(Method.GET, uri);
    }

    public static DeleteOfflineTransactionRequest deleteOfflineTransaction(String id) throws IOException {
        String uri = uri("transactions", nullCheck(id), "delete_offline_transaction");
        return new DeleteOfflineTransactionRequest(Method.POST, uri);
    }


    // Operation Request Classes
    //==========================

    public static class CreateAuthorizationRequest extends Request<CreateAuthorizationRequest> {

        private CreateAuthorizationRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public CreateAuthorizationRequest customerId(String customerId) {
            params.add("customer_id", customerId);
            return this;
        }


        public CreateAuthorizationRequest paymentSourceId(String paymentSourceId) {
            params.addOpt("payment_source_id", paymentSourceId);
            return this;
        }


        public CreateAuthorizationRequest currencyCode(String currencyCode) {
            params.addOpt("currency_code", currencyCode);
            return this;
        }


        public CreateAuthorizationRequest amount(Integer amount) {
            params.add("amount", amount);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class TransactionListRequest extends ListRequest<TransactionListRequest> {

        private TransactionListRequest(String uri) {
            super(uri);
        }
    
        public TransactionListRequest includeDeleted(Boolean includeDeleted) {
            params.addOpt("include_deleted", includeDeleted);
            return this;
        }


        public StringFilter<TransactionListRequest> id() {
            return new StringFilter<TransactionListRequest>("id",this).supportsMultiOperators(true);        
        }


        public StringFilter<TransactionListRequest> customerId() {
            return new StringFilter<TransactionListRequest>("customer_id",this).supportsMultiOperators(true).supportsPresenceOperator(true);        
        }


        public StringFilter<TransactionListRequest> subscriptionId() {
            return new StringFilter<TransactionListRequest>("subscription_id",this).supportsMultiOperators(true).supportsPresenceOperator(true);        
        }


        public StringFilter<TransactionListRequest> paymentSourceId() {
            return new StringFilter<TransactionListRequest>("payment_source_id",this).supportsMultiOperators(true).supportsPresenceOperator(true);        
        }


        public EnumFilter<com.chargebee.models.enums.PaymentMethod, TransactionListRequest> paymentMethod() {
            return new EnumFilter<com.chargebee.models.enums.PaymentMethod, TransactionListRequest>("payment_method",this);        
        }


        public EnumFilter<com.chargebee.models.enums.Gateway, TransactionListRequest> gateway() {
            return new EnumFilter<com.chargebee.models.enums.Gateway, TransactionListRequest>("gateway",this);        
        }


        public StringFilter<TransactionListRequest> gatewayAccountId() {
            return new StringFilter<TransactionListRequest>("gateway_account_id",this).supportsMultiOperators(true);        
        }


        public StringFilter<TransactionListRequest> idAtGateway() {
            return new StringFilter<TransactionListRequest>("id_at_gateway",this);        
        }


        public StringFilter<TransactionListRequest> referenceNumber() {
            return new StringFilter<TransactionListRequest>("reference_number",this).supportsPresenceOperator(true);        
        }


        public EnumFilter<Transaction.Type, TransactionListRequest> type() {
            return new EnumFilter<Transaction.Type, TransactionListRequest>("type",this);        
        }


        public TimestampFilter<TransactionListRequest> date() {
            return new TimestampFilter<TransactionListRequest>("date",this);        
        }


        public NumberFilter<Integer, TransactionListRequest> amount() {
            return new NumberFilter<Integer, TransactionListRequest>("amount",this);        
        }


        public NumberFilter<Integer, TransactionListRequest> amountCapturable() {
            return new NumberFilter<Integer, TransactionListRequest>("amount_capturable",this);        
        }


        public EnumFilter<Transaction.Status, TransactionListRequest> status() {
            return new EnumFilter<Transaction.Status, TransactionListRequest>("status",this);        
        }


        public TimestampFilter<TransactionListRequest> updatedAt() {
            return new TimestampFilter<TransactionListRequest>("updated_at",this);        
        }


        public TransactionListRequest sortByDate(SortOrder order) {
            params.addOpt("sort_by["+order.name().toLowerCase()+"]","date");
            return this;
        }
        public TransactionListRequest sortByUpdatedAt(SortOrder order) {
            params.addOpt("sort_by["+order.name().toLowerCase()+"]","updated_at");
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class DeleteOfflineTransactionRequest extends Request<DeleteOfflineTransactionRequest> {

        private DeleteOfflineTransactionRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public DeleteOfflineTransactionRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

}
