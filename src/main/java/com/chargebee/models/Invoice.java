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

public class Invoice extends Resource<Invoice> {

    public enum Status {
        PAID,
        POSTED,
        PAYMENT_DUE,
        NOT_PAID,
        VOIDED,
        PENDING,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public enum DunningStatus {
        IN_PROGRESS,
        EXHAUSTED,
        STOPPED,
        SUCCESS,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    public static class LineItem extends Resource<LineItem> {
        public enum EntityType {
             PLAN_SETUP,PLAN,ADDON,ADHOC,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public LineItem(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String id() {
            return optString("id");
        }

        public String subscriptionId() {
            return optString("subscription_id");
        }

        public Timestamp dateFrom() {
            return reqTimestamp("date_from");
        }

        public Timestamp dateTo() {
            return reqTimestamp("date_to");
        }

        public Integer unitAmount() {
            return reqInteger("unit_amount");
        }

        public Integer quantity() {
            return optInteger("quantity");
        }

        public Integer amount() {
            return optInteger("amount");
        }

        public PricingModel pricingModel() {
            return optEnum("pricing_model", PricingModel.class);
        }

        public Boolean isTaxed() {
            return reqBoolean("is_taxed");
        }

        public Integer taxAmount() {
            return optInteger("tax_amount");
        }

        public Double taxRate() {
            return optDouble("tax_rate");
        }

        public Integer discountAmount() {
            return optInteger("discount_amount");
        }

        public Integer itemLevelDiscountAmount() {
            return optInteger("item_level_discount_amount");
        }

        public String description() {
            return reqString("description");
        }

        public EntityType entityType() {
            return reqEnum("entity_type", EntityType.class);
        }

        public TaxExemptReason taxExemptReason() {
            return optEnum("tax_exempt_reason", TaxExemptReason.class);
        }

        public String entityId() {
            return optString("entity_id");
        }

    }

    public static class Discount extends Resource<Discount> {
        public enum EntityType {
             ITEM_LEVEL_COUPON,DOCUMENT_LEVEL_COUPON,PROMOTIONAL_CREDITS,PRORATED_CREDITS,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public Discount(JSONObject jsonObj) {
            super(jsonObj);
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public String description() {
            return optString("description");
        }

        public EntityType entityType() {
            return reqEnum("entity_type", EntityType.class);
        }

        public String entityId() {
            return optString("entity_id");
        }

    }

    public static class LineItemDiscount extends Resource<LineItemDiscount> {
        public enum DiscountType {
             ITEM_LEVEL_COUPON,DOCUMENT_LEVEL_COUPON,PROMOTIONAL_CREDITS,PRORATED_CREDITS,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public LineItemDiscount(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String lineItemId() {
            return reqString("line_item_id");
        }

        public DiscountType discountType() {
            return reqEnum("discount_type", DiscountType.class);
        }

        public String couponId() {
            return optString("coupon_id");
        }

        public Integer discountAmount() {
            return reqInteger("discount_amount");
        }

    }

    public static class Tax extends Resource<Tax> {
        public Tax(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String name() {
            return reqString("name");
        }

        public Integer amount() {
            return reqInteger("amount");
        }

        public String description() {
            return optString("description");
        }

    }

    public static class LineItemTax extends Resource<LineItemTax> {
        public LineItemTax(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String lineItemId() {
            return optString("line_item_id");
        }

        public String taxName() {
            return reqString("tax_name");
        }

        public Double taxRate() {
            return reqDouble("tax_rate");
        }

        public Boolean isPartialTaxApplied() {
            return optBoolean("is_partial_tax_applied");
        }

        public Boolean isNonComplianceTax() {
            return optBoolean("is_non_compliance_tax");
        }

        public Integer taxableAmount() {
            return reqInteger("taxable_amount");
        }

        public Integer taxAmount() {
            return reqInteger("tax_amount");
        }

        public TaxJurisType taxJurisType() {
            return optEnum("tax_juris_type", TaxJurisType.class);
        }

        public String taxJurisName() {
            return optString("tax_juris_name");
        }

        public String taxJurisCode() {
            return optString("tax_juris_code");
        }

    }

    public static class LineItemTier extends Resource<LineItemTier> {
        public LineItemTier(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String lineItemId() {
            return optString("line_item_id");
        }

        public Integer startingUnit() {
            return reqInteger("starting_unit");
        }

        public Integer endingUnit() {
            return optInteger("ending_unit");
        }

        public Integer quantityUsed() {
            return reqInteger("quantity_used");
        }

        public Integer unitAmount() {
            return reqInteger("unit_amount");
        }

    }

    public static class LinkedPayment extends Resource<LinkedPayment> {
        public LinkedPayment(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String txnId() {
            return reqString("txn_id");
        }

        public Integer appliedAmount() {
            return reqInteger("applied_amount");
        }

        public Timestamp appliedAt() {
            return reqTimestamp("applied_at");
        }

        public Transaction.Status txnStatus() {
            return optEnum("txn_status", Transaction.Status.class);
        }

        public Timestamp txnDate() {
            return optTimestamp("txn_date");
        }

        public Integer txnAmount() {
            return optInteger("txn_amount");
        }

    }

    public static class AppliedCredit extends Resource<AppliedCredit> {
        public AppliedCredit(JSONObject jsonObj) {
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

        public CreditNote.Status cnStatus() {
            return reqEnum("cn_status", CreditNote.Status.class);
        }

    }

    public static class AdjustmentCreditNote extends Resource<AdjustmentCreditNote> {
        public AdjustmentCreditNote(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String cnId() {
            return reqString("cn_id");
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

    }

    public static class IssuedCreditNote extends Resource<IssuedCreditNote> {
        public IssuedCreditNote(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String cnId() {
            return reqString("cn_id");
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

    }

    public static class LinkedOrder extends Resource<LinkedOrder> {
        public enum Status {
             NEW,PROCESSING,COMPLETE,CANCELLED,VOIDED,QUEUED,AWAITING_SHIPMENT,ON_HOLD,DELIVERED,SHIPPED,PARTIALLY_DELIVERED,RETURNED,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public enum OrderType {
             MANUAL,SYSTEM_GENERATED,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public LinkedOrder(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String id() {
            return reqString("id");
        }

        public String documentNumber() {
            return optString("document_number");
        }

        public Status status() {
            return optEnum("status", Status.class);
        }

        public OrderType orderType() {
            return optEnum("order_type", OrderType.class);
        }

        public String referenceId() {
            return optString("reference_id");
        }

        public String fulfillmentStatus() {
            return optString("fulfillment_status");
        }

        public String batchId() {
            return optString("batch_id");
        }

        public Timestamp createdAt() {
            return reqTimestamp("created_at");
        }

    }

    public static class Note extends Resource<Note> {
        public enum EntityType {
             PLAN,ADDON,COUPON,SUBSCRIPTION,CUSTOMER,
            _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a
            java-client version incompatibility. We suggest you to upgrade to the latest version */ 
        }

        public Note(JSONObject jsonObj) {
            super(jsonObj);
        }

        public EntityType entityType() {
            return reqEnum("entity_type", EntityType.class);
        }

        public String note() {
            return reqString("note");
        }

        public String entityId() {
            return optString("entity_id");
        }

    }

    public static class ShippingAddress extends Resource<ShippingAddress> {
        public ShippingAddress(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String firstName() {
            return optString("first_name");
        }

        public String lastName() {
            return optString("last_name");
        }

        public String email() {
            return optString("email");
        }

        public String company() {
            return optString("company");
        }

        public String phone() {
            return optString("phone");
        }

        public String line1() {
            return optString("line1");
        }

        public String line2() {
            return optString("line2");
        }

        public String line3() {
            return optString("line3");
        }

        public String city() {
            return optString("city");
        }

        public String stateCode() {
            return optString("state_code");
        }

        public String state() {
            return optString("state");
        }

        public String country() {
            return optString("country");
        }

        public String zip() {
            return optString("zip");
        }

        public ValidationStatus validationStatus() {
            return optEnum("validation_status", ValidationStatus.class);
        }

    }

    public static class BillingAddress extends Resource<BillingAddress> {
        public BillingAddress(JSONObject jsonObj) {
            super(jsonObj);
        }

        public String firstName() {
            return optString("first_name");
        }

        public String lastName() {
            return optString("last_name");
        }

        public String email() {
            return optString("email");
        }

        public String company() {
            return optString("company");
        }

        public String phone() {
            return optString("phone");
        }

        public String line1() {
            return optString("line1");
        }

        public String line2() {
            return optString("line2");
        }

        public String line3() {
            return optString("line3");
        }

        public String city() {
            return optString("city");
        }

        public String stateCode() {
            return optString("state_code");
        }

        public String state() {
            return optString("state");
        }

        public String country() {
            return optString("country");
        }

        public String zip() {
            return optString("zip");
        }

        public ValidationStatus validationStatus() {
            return optEnum("validation_status", ValidationStatus.class);
        }

    }

    //Constructors
    //============

    public Invoice(String jsonStr) {
        super(jsonStr);
    }

    public Invoice(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String id() {
        return reqString("id");
    }

    public String poNumber() {
        return optString("po_number");
    }

    public String customerId() {
        return reqString("customer_id");
    }

    public String subscriptionId() {
        return optString("subscription_id");
    }

    public Boolean recurring() {
        return reqBoolean("recurring");
    }

    public Status status() {
        return reqEnum("status", Status.class);
    }

    public String vatNumber() {
        return optString("vat_number");
    }

    public PriceType priceType() {
        return reqEnum("price_type", PriceType.class);
    }

    public Timestamp date() {
        return optTimestamp("date");
    }

    public Timestamp dueDate() {
        return optTimestamp("due_date");
    }

    public Integer netTermDays() {
        return optInteger("net_term_days");
    }

    public String currencyCode() {
        return reqString("currency_code");
    }

    public Integer total() {
        return optInteger("total");
    }

    public Integer amountPaid() {
        return optInteger("amount_paid");
    }

    public Integer amountAdjusted() {
        return optInteger("amount_adjusted");
    }

    public Integer writeOffAmount() {
        return optInteger("write_off_amount");
    }

    public Integer creditsApplied() {
        return optInteger("credits_applied");
    }

    public Integer amountDue() {
        return optInteger("amount_due");
    }

    public Timestamp paidAt() {
        return optTimestamp("paid_at");
    }

    public DunningStatus dunningStatus() {
        return optEnum("dunning_status", DunningStatus.class);
    }

    public Timestamp nextRetryAt() {
        return optTimestamp("next_retry_at");
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

    public Integer subTotal() {
        return reqInteger("sub_total");
    }

    public Integer tax() {
        return reqInteger("tax");
    }

    public Boolean firstInvoice() {
        return optBoolean("first_invoice");
    }

    public Boolean hasAdvanceCharges() {
        return optBoolean("has_advance_charges");
    }

    public Boolean termFinalized() {
        return reqBoolean("term_finalized");
    }

    public Boolean isGifted() {
        return reqBoolean("is_gifted");
    }

    public Timestamp expectedPaymentDate() {
        return optTimestamp("expected_payment_date");
    }

    public Integer amountToCollect() {
        return optInteger("amount_to_collect");
    }

    public Integer roundOffAmount() {
        return optInteger("round_off_amount");
    }

    public List<Invoice.LineItem> lineItems() {
        return optList("line_items", Invoice.LineItem.class);
    }

    public List<Invoice.Discount> discounts() {
        return optList("discounts", Invoice.Discount.class);
    }

    public List<Invoice.LineItemDiscount> lineItemDiscounts() {
        return optList("line_item_discounts", Invoice.LineItemDiscount.class);
    }

    public List<Invoice.Tax> taxes() {
        return optList("taxes", Invoice.Tax.class);
    }

    public List<Invoice.LineItemTax> lineItemTaxes() {
        return optList("line_item_taxes", Invoice.LineItemTax.class);
    }

    public List<Invoice.LineItemTier> lineItemTiers() {
        return optList("line_item_tiers", Invoice.LineItemTier.class);
    }

    public List<Invoice.LinkedPayment> linkedPayments() {
        return optList("linked_payments", Invoice.LinkedPayment.class);
    }

    public List<Invoice.AppliedCredit> appliedCredits() {
        return optList("applied_credits", Invoice.AppliedCredit.class);
    }

    public List<Invoice.AdjustmentCreditNote> adjustmentCreditNotes() {
        return optList("adjustment_credit_notes", Invoice.AdjustmentCreditNote.class);
    }

    public List<Invoice.IssuedCreditNote> issuedCreditNotes() {
        return optList("issued_credit_notes", Invoice.IssuedCreditNote.class);
    }

    public List<Invoice.LinkedOrder> linkedOrders() {
        return optList("linked_orders", Invoice.LinkedOrder.class);
    }

    public List<Invoice.Note> notes() {
        return optList("notes", Invoice.Note.class);
    }

    public Invoice.ShippingAddress shippingAddress() {
        return optSubResource("shipping_address", Invoice.ShippingAddress.class);
    }

    public Invoice.BillingAddress billingAddress() {
        return optSubResource("billing_address", Invoice.BillingAddress.class);
    }

    public Boolean deleted() {
        return reqBoolean("deleted");
    }

    // Operations
    //===========

    public static CreateRequest create() throws IOException {
        String uri = uri("invoices");
        return new CreateRequest(Method.POST, uri);
    }

    public static ChargeRequest charge() throws IOException {
        String uri = uri("invoices", "charge");
        return new ChargeRequest(Method.POST, uri);
    }

    public static ChargeAddonRequest chargeAddon() throws IOException {
        String uri = uri("invoices", "charge_addon");
        return new ChargeAddonRequest(Method.POST, uri);
    }

    public static Request stopDunning(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "stop_dunning");
        return new Request(Method.POST, uri);
    }

    public static ImportInvoiceRequest importInvoice() throws IOException {
        String uri = uri("invoices", "import_invoice");
        return new ImportInvoiceRequest(Method.POST, uri);
    }

    public static ApplyPaymentsRequest applyPayments(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "apply_payments");
        return new ApplyPaymentsRequest(Method.POST, uri);
    }

    public static ApplyCreditsRequest applyCredits(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "apply_credits");
        return new ApplyCreditsRequest(Method.POST, uri);
    }

    public static InvoiceListRequest list() throws IOException {
        String uri = uri("invoices");
        return new InvoiceListRequest(uri);
    }

    @Deprecated
    public static ListRequest invoicesForCustomer(String id) throws IOException {
        String uri = uri("customers", nullCheck(id), "invoices");
        return new ListRequest(uri);
    }

    @Deprecated
    public static ListRequest invoicesForSubscription(String id) throws IOException {
        String uri = uri("subscriptions", nullCheck(id), "invoices");
        return new ListRequest(uri);
    }

    public static Request retrieve(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id));
        return new Request(Method.GET, uri);
    }

    public static PdfRequest pdf(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "pdf");
        return new PdfRequest(Method.POST, uri);
    }

    public static AddChargeRequest addCharge(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "add_charge");
        return new AddChargeRequest(Method.POST, uri);
    }

    public static AddAddonChargeRequest addAddonCharge(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "add_addon_charge");
        return new AddAddonChargeRequest(Method.POST, uri);
    }

    public static Request close(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "close");
        return new Request(Method.POST, uri);
    }

    public static CollectPaymentRequest collectPayment(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "collect_payment");
        return new CollectPaymentRequest(Method.POST, uri);
    }

    public static RecordPaymentRequest recordPayment(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "record_payment");
        return new RecordPaymentRequest(Method.POST, uri);
    }

    public static RefundRequest refund(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "refund");
        return new RefundRequest(Method.POST, uri);
    }

    public static RecordRefundRequest recordRefund(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "record_refund");
        return new RecordRefundRequest(Method.POST, uri);
    }

    public static RemovePaymentRequest removePayment(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "remove_payment");
        return new RemovePaymentRequest(Method.POST, uri);
    }

    public static RemoveCreditNoteRequest removeCreditNote(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "remove_credit_note");
        return new RemoveCreditNoteRequest(Method.POST, uri);
    }

    public static VoidInvoiceRequest voidInvoice(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "void");
        return new VoidInvoiceRequest(Method.POST, uri);
    }

    public static WriteOffRequest writeOff(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "write_off");
        return new WriteOffRequest(Method.POST, uri);
    }

    public static DeleteRequest delete(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "delete");
        return new DeleteRequest(Method.POST, uri);
    }

    public static UpdateDetailsRequest updateDetails(String id) throws IOException {
        String uri = uri("invoices", nullCheck(id), "update_details");
        return new UpdateDetailsRequest(Method.POST, uri);
    }


    // Operation Request Classes
    //==========================

    public static class CreateRequest extends Request<CreateRequest> {

        private CreateRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public CreateRequest customerId(String customerId) {
            params.add("customer_id", customerId);
            return this;
        }


        public CreateRequest currencyCode(String currencyCode) {
            params.addOpt("currency_code", currencyCode);
            return this;
        }


        public CreateRequest coupon(String coupon) {
            params.addOpt("coupon", coupon);
            return this;
        }


        public CreateRequest poNumber(String poNumber) {
            params.addOpt("po_number", poNumber);
            return this;
        }


        public CreateRequest authorizationTransactionId(String authorizationTransactionId) {
            params.addOpt("authorization_transaction_id", authorizationTransactionId);
            return this;
        }


        public CreateRequest paymentSourceId(String paymentSourceId) {
            params.addOpt("payment_source_id", paymentSourceId);
            return this;
        }


        public CreateRequest autoCollection(com.chargebee.models.enums.AutoCollection autoCollection) {
            params.addOpt("auto_collection", autoCollection);
            return this;
        }


        public CreateRequest shippingAddressFirstName(String shippingAddressFirstName) {
            params.addOpt("shipping_address[first_name]", shippingAddressFirstName);
            return this;
        }

        public CreateRequest shippingAddressLastName(String shippingAddressLastName) {
            params.addOpt("shipping_address[last_name]", shippingAddressLastName);
            return this;
        }

        public CreateRequest shippingAddressEmail(String shippingAddressEmail) {
            params.addOpt("shipping_address[email]", shippingAddressEmail);
            return this;
        }

        public CreateRequest shippingAddressCompany(String shippingAddressCompany) {
            params.addOpt("shipping_address[company]", shippingAddressCompany);
            return this;
        }

        public CreateRequest shippingAddressPhone(String shippingAddressPhone) {
            params.addOpt("shipping_address[phone]", shippingAddressPhone);
            return this;
        }

        public CreateRequest shippingAddressLine1(String shippingAddressLine1) {
            params.addOpt("shipping_address[line1]", shippingAddressLine1);
            return this;
        }

        public CreateRequest shippingAddressLine2(String shippingAddressLine2) {
            params.addOpt("shipping_address[line2]", shippingAddressLine2);
            return this;
        }

        public CreateRequest shippingAddressLine3(String shippingAddressLine3) {
            params.addOpt("shipping_address[line3]", shippingAddressLine3);
            return this;
        }

        public CreateRequest shippingAddressCity(String shippingAddressCity) {
            params.addOpt("shipping_address[city]", shippingAddressCity);
            return this;
        }

        public CreateRequest shippingAddressStateCode(String shippingAddressStateCode) {
            params.addOpt("shipping_address[state_code]", shippingAddressStateCode);
            return this;
        }

        public CreateRequest shippingAddressState(String shippingAddressState) {
            params.addOpt("shipping_address[state]", shippingAddressState);
            return this;
        }

        public CreateRequest shippingAddressZip(String shippingAddressZip) {
            params.addOpt("shipping_address[zip]", shippingAddressZip);
            return this;
        }

        public CreateRequest shippingAddressCountry(String shippingAddressCountry) {
            params.addOpt("shipping_address[country]", shippingAddressCountry);
            return this;
        }

        public CreateRequest shippingAddressValidationStatus(com.chargebee.models.enums.ValidationStatus shippingAddressValidationStatus) {
            params.addOpt("shipping_address[validation_status]", shippingAddressValidationStatus);
            return this;
        }

        public CreateRequest addonId(int index, String addonId) {
            params.addOpt("addons[id][" + index + "]", addonId);
            return this;
        }
        public CreateRequest addonQuantity(int index, Integer addonQuantity) {
            params.addOpt("addons[quantity][" + index + "]", addonQuantity);
            return this;
        }
        public CreateRequest addonUnitPrice(int index, Integer addonUnitPrice) {
            params.addOpt("addons[unit_price][" + index + "]", addonUnitPrice);
            return this;
        }
        public CreateRequest chargeAmount(int index, Integer chargeAmount) {
            params.addOpt("charges[amount][" + index + "]", chargeAmount);
            return this;
        }
        public CreateRequest chargeDescription(int index, String chargeDescription) {
            params.addOpt("charges[description][" + index + "]", chargeDescription);
            return this;
        }
        public CreateRequest chargeAvalaraSaleType(int index, com.chargebee.models.enums.AvalaraSaleType chargeAvalaraSaleType) {
            params.addOpt("charges[avalara_sale_type][" + index + "]", chargeAvalaraSaleType);
            return this;
        }
        public CreateRequest chargeAvalaraTransactionType(int index, Integer chargeAvalaraTransactionType) {
            params.addOpt("charges[avalara_transaction_type][" + index + "]", chargeAvalaraTransactionType);
            return this;
        }
        public CreateRequest chargeAvalaraServiceType(int index, Integer chargeAvalaraServiceType) {
            params.addOpt("charges[avalara_service_type][" + index + "]", chargeAvalaraServiceType);
            return this;
        }
        @Override
        public Params params() {
            return params;
        }
    }

    public static class ChargeRequest extends Request<ChargeRequest> {

        private ChargeRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public ChargeRequest customerId(String customerId) {
            params.addOpt("customer_id", customerId);
            return this;
        }


        public ChargeRequest subscriptionId(String subscriptionId) {
            params.addOpt("subscription_id", subscriptionId);
            return this;
        }


        public ChargeRequest currencyCode(String currencyCode) {
            params.addOpt("currency_code", currencyCode);
            return this;
        }


        public ChargeRequest amount(Integer amount) {
            params.add("amount", amount);
            return this;
        }


        public ChargeRequest description(String description) {
            params.add("description", description);
            return this;
        }


        public ChargeRequest coupon(String coupon) {
            params.addOpt("coupon", coupon);
            return this;
        }


        public ChargeRequest avalaraSaleType(com.chargebee.models.enums.AvalaraSaleType avalaraSaleType) {
            params.addOpt("avalara_sale_type", avalaraSaleType);
            return this;
        }


        public ChargeRequest avalaraTransactionType(Integer avalaraTransactionType) {
            params.addOpt("avalara_transaction_type", avalaraTransactionType);
            return this;
        }


        public ChargeRequest avalaraServiceType(Integer avalaraServiceType) {
            params.addOpt("avalara_service_type", avalaraServiceType);
            return this;
        }


        public ChargeRequest poNumber(String poNumber) {
            params.addOpt("po_number", poNumber);
            return this;
        }


        public ChargeRequest paymentSourceId(String paymentSourceId) {
            params.addOpt("payment_source_id", paymentSourceId);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class ChargeAddonRequest extends Request<ChargeAddonRequest> {

        private ChargeAddonRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public ChargeAddonRequest customerId(String customerId) {
            params.addOpt("customer_id", customerId);
            return this;
        }


        public ChargeAddonRequest subscriptionId(String subscriptionId) {
            params.addOpt("subscription_id", subscriptionId);
            return this;
        }


        public ChargeAddonRequest addonId(String addonId) {
            params.add("addon_id", addonId);
            return this;
        }


        public ChargeAddonRequest addonQuantity(Integer addonQuantity) {
            params.addOpt("addon_quantity", addonQuantity);
            return this;
        }


        public ChargeAddonRequest addonUnitPrice(Integer addonUnitPrice) {
            params.addOpt("addon_unit_price", addonUnitPrice);
            return this;
        }


        public ChargeAddonRequest coupon(String coupon) {
            params.addOpt("coupon", coupon);
            return this;
        }


        public ChargeAddonRequest poNumber(String poNumber) {
            params.addOpt("po_number", poNumber);
            return this;
        }


        public ChargeAddonRequest paymentSourceId(String paymentSourceId) {
            params.addOpt("payment_source_id", paymentSourceId);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class ImportInvoiceRequest extends Request<ImportInvoiceRequest> {

        private ImportInvoiceRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public ImportInvoiceRequest id(String id) {
            params.add("id", id);
            return this;
        }


        public ImportInvoiceRequest currencyCode(String currencyCode) {
            params.addOpt("currency_code", currencyCode);
            return this;
        }


        public ImportInvoiceRequest customerId(String customerId) {
            params.addOpt("customer_id", customerId);
            return this;
        }


        public ImportInvoiceRequest subscriptionId(String subscriptionId) {
            params.addOpt("subscription_id", subscriptionId);
            return this;
        }


        public ImportInvoiceRequest poNumber(String poNumber) {
            params.addOpt("po_number", poNumber);
            return this;
        }


        public ImportInvoiceRequest priceType(com.chargebee.models.enums.PriceType priceType) {
            params.addOpt("price_type", priceType);
            return this;
        }


        public ImportInvoiceRequest taxOverrideReason(com.chargebee.models.enums.TaxOverrideReason taxOverrideReason) {
            params.addOpt("tax_override_reason", taxOverrideReason);
            return this;
        }


        public ImportInvoiceRequest vatNumber(String vatNumber) {
            params.addOpt("vat_number", vatNumber);
            return this;
        }


        public ImportInvoiceRequest date(Timestamp date) {
            params.add("date", date);
            return this;
        }


        public ImportInvoiceRequest total(Integer total) {
            params.add("total", total);
            return this;
        }


        public ImportInvoiceRequest roundOff(Integer roundOff) {
            params.addOpt("round_off", roundOff);
            return this;
        }


        public ImportInvoiceRequest status(Invoice.Status status) {
            params.addOpt("status", status);
            return this;
        }


        public ImportInvoiceRequest dueDate(Timestamp dueDate) {
            params.addOpt("due_date", dueDate);
            return this;
        }


        public ImportInvoiceRequest netTermDays(Integer netTermDays) {
            params.addOpt("net_term_days", netTermDays);
            return this;
        }


        public ImportInvoiceRequest useForProration(Boolean useForProration) {
            params.addOpt("use_for_proration", useForProration);
            return this;
        }


        public ImportInvoiceRequest billingAddressFirstName(String billingAddressFirstName) {
            params.addOpt("billing_address[first_name]", billingAddressFirstName);
            return this;
        }

        public ImportInvoiceRequest billingAddressLastName(String billingAddressLastName) {
            params.addOpt("billing_address[last_name]", billingAddressLastName);
            return this;
        }

        public ImportInvoiceRequest billingAddressEmail(String billingAddressEmail) {
            params.addOpt("billing_address[email]", billingAddressEmail);
            return this;
        }

        public ImportInvoiceRequest billingAddressCompany(String billingAddressCompany) {
            params.addOpt("billing_address[company]", billingAddressCompany);
            return this;
        }

        public ImportInvoiceRequest billingAddressPhone(String billingAddressPhone) {
            params.addOpt("billing_address[phone]", billingAddressPhone);
            return this;
        }

        public ImportInvoiceRequest billingAddressLine1(String billingAddressLine1) {
            params.addOpt("billing_address[line1]", billingAddressLine1);
            return this;
        }

        public ImportInvoiceRequest billingAddressLine2(String billingAddressLine2) {
            params.addOpt("billing_address[line2]", billingAddressLine2);
            return this;
        }

        public ImportInvoiceRequest billingAddressLine3(String billingAddressLine3) {
            params.addOpt("billing_address[line3]", billingAddressLine3);
            return this;
        }

        public ImportInvoiceRequest billingAddressCity(String billingAddressCity) {
            params.addOpt("billing_address[city]", billingAddressCity);
            return this;
        }

        public ImportInvoiceRequest billingAddressStateCode(String billingAddressStateCode) {
            params.addOpt("billing_address[state_code]", billingAddressStateCode);
            return this;
        }

        public ImportInvoiceRequest billingAddressState(String billingAddressState) {
            params.addOpt("billing_address[state]", billingAddressState);
            return this;
        }

        public ImportInvoiceRequest billingAddressZip(String billingAddressZip) {
            params.addOpt("billing_address[zip]", billingAddressZip);
            return this;
        }

        public ImportInvoiceRequest billingAddressCountry(String billingAddressCountry) {
            params.addOpt("billing_address[country]", billingAddressCountry);
            return this;
        }

        public ImportInvoiceRequest billingAddressValidationStatus(com.chargebee.models.enums.ValidationStatus billingAddressValidationStatus) {
            params.addOpt("billing_address[validation_status]", billingAddressValidationStatus);
            return this;
        }

        public ImportInvoiceRequest shippingAddressFirstName(String shippingAddressFirstName) {
            params.addOpt("shipping_address[first_name]", shippingAddressFirstName);
            return this;
        }

        public ImportInvoiceRequest shippingAddressLastName(String shippingAddressLastName) {
            params.addOpt("shipping_address[last_name]", shippingAddressLastName);
            return this;
        }

        public ImportInvoiceRequest shippingAddressEmail(String shippingAddressEmail) {
            params.addOpt("shipping_address[email]", shippingAddressEmail);
            return this;
        }

        public ImportInvoiceRequest shippingAddressCompany(String shippingAddressCompany) {
            params.addOpt("shipping_address[company]", shippingAddressCompany);
            return this;
        }

        public ImportInvoiceRequest shippingAddressPhone(String shippingAddressPhone) {
            params.addOpt("shipping_address[phone]", shippingAddressPhone);
            return this;
        }

        public ImportInvoiceRequest shippingAddressLine1(String shippingAddressLine1) {
            params.addOpt("shipping_address[line1]", shippingAddressLine1);
            return this;
        }

        public ImportInvoiceRequest shippingAddressLine2(String shippingAddressLine2) {
            params.addOpt("shipping_address[line2]", shippingAddressLine2);
            return this;
        }

        public ImportInvoiceRequest shippingAddressLine3(String shippingAddressLine3) {
            params.addOpt("shipping_address[line3]", shippingAddressLine3);
            return this;
        }

        public ImportInvoiceRequest shippingAddressCity(String shippingAddressCity) {
            params.addOpt("shipping_address[city]", shippingAddressCity);
            return this;
        }

        public ImportInvoiceRequest shippingAddressStateCode(String shippingAddressStateCode) {
            params.addOpt("shipping_address[state_code]", shippingAddressStateCode);
            return this;
        }

        public ImportInvoiceRequest shippingAddressState(String shippingAddressState) {
            params.addOpt("shipping_address[state]", shippingAddressState);
            return this;
        }

        public ImportInvoiceRequest shippingAddressZip(String shippingAddressZip) {
            params.addOpt("shipping_address[zip]", shippingAddressZip);
            return this;
        }

        public ImportInvoiceRequest shippingAddressCountry(String shippingAddressCountry) {
            params.addOpt("shipping_address[country]", shippingAddressCountry);
            return this;
        }

        public ImportInvoiceRequest shippingAddressValidationStatus(com.chargebee.models.enums.ValidationStatus shippingAddressValidationStatus) {
            params.addOpt("shipping_address[validation_status]", shippingAddressValidationStatus);
            return this;
        }

        public ImportInvoiceRequest lineItemId(int index, String lineItemId) {
            params.addOpt("line_items[id][" + index + "]", lineItemId);
            return this;
        }
        public ImportInvoiceRequest lineItemDateFrom(int index, Timestamp lineItemDateFrom) {
            params.addOpt("line_items[date_from][" + index + "]", lineItemDateFrom);
            return this;
        }
        public ImportInvoiceRequest lineItemDateTo(int index, Timestamp lineItemDateTo) {
            params.addOpt("line_items[date_to][" + index + "]", lineItemDateTo);
            return this;
        }
        public ImportInvoiceRequest lineItemDescription(int index, String lineItemDescription) {
            params.add("line_items[description][" + index + "]", lineItemDescription);
            return this;
        }
        public ImportInvoiceRequest lineItemUnitAmount(int index, Integer lineItemUnitAmount) {
            params.addOpt("line_items[unit_amount][" + index + "]", lineItemUnitAmount);
            return this;
        }
        public ImportInvoiceRequest lineItemQuantity(int index, Integer lineItemQuantity) {
            params.addOpt("line_items[quantity][" + index + "]", lineItemQuantity);
            return this;
        }
        public ImportInvoiceRequest lineItemAmount(int index, Integer lineItemAmount) {
            params.addOpt("line_items[amount][" + index + "]", lineItemAmount);
            return this;
        }
        public ImportInvoiceRequest lineItemEntityType(int index, LineItem.EntityType lineItemEntityType) {
            params.addOpt("line_items[entity_type][" + index + "]", lineItemEntityType);
            return this;
        }
        public ImportInvoiceRequest lineItemEntityId(int index, String lineItemEntityId) {
            params.addOpt("line_items[entity_id][" + index + "]", lineItemEntityId);
            return this;
        }
        public ImportInvoiceRequest lineItemItemLevelDiscount1EntityId(int index, String lineItemItemLevelDiscount1EntityId) {
            params.addOpt("line_items[item_level_discount1_entity_id][" + index + "]", lineItemItemLevelDiscount1EntityId);
            return this;
        }
        public ImportInvoiceRequest lineItemItemLevelDiscount1Amount(int index, Integer lineItemItemLevelDiscount1Amount) {
            params.addOpt("line_items[item_level_discount1_amount][" + index + "]", lineItemItemLevelDiscount1Amount);
            return this;
        }
        public ImportInvoiceRequest lineItemItemLevelDiscount2EntityId(int index, String lineItemItemLevelDiscount2EntityId) {
            params.addOpt("line_items[item_level_discount2_entity_id][" + index + "]", lineItemItemLevelDiscount2EntityId);
            return this;
        }
        public ImportInvoiceRequest lineItemItemLevelDiscount2Amount(int index, Integer lineItemItemLevelDiscount2Amount) {
            params.addOpt("line_items[item_level_discount2_amount][" + index + "]", lineItemItemLevelDiscount2Amount);
            return this;
        }
        public ImportInvoiceRequest lineItemTax1Name(int index, String lineItemTax1Name) {
            params.addOpt("line_items[tax1_name][" + index + "]", lineItemTax1Name);
            return this;
        }
        public ImportInvoiceRequest lineItemTax1Amount(int index, Integer lineItemTax1Amount) {
            params.addOpt("line_items[tax1_amount][" + index + "]", lineItemTax1Amount);
            return this;
        }
        public ImportInvoiceRequest lineItemTax2Name(int index, String lineItemTax2Name) {
            params.addOpt("line_items[tax2_name][" + index + "]", lineItemTax2Name);
            return this;
        }
        public ImportInvoiceRequest lineItemTax2Amount(int index, Integer lineItemTax2Amount) {
            params.addOpt("line_items[tax2_amount][" + index + "]", lineItemTax2Amount);
            return this;
        }
        public ImportInvoiceRequest lineItemTax3Name(int index, String lineItemTax3Name) {
            params.addOpt("line_items[tax3_name][" + index + "]", lineItemTax3Name);
            return this;
        }
        public ImportInvoiceRequest lineItemTax3Amount(int index, Integer lineItemTax3Amount) {
            params.addOpt("line_items[tax3_amount][" + index + "]", lineItemTax3Amount);
            return this;
        }
        public ImportInvoiceRequest lineItemTax4Name(int index, String lineItemTax4Name) {
            params.addOpt("line_items[tax4_name][" + index + "]", lineItemTax4Name);
            return this;
        }
        public ImportInvoiceRequest lineItemTax4Amount(int index, Integer lineItemTax4Amount) {
            params.addOpt("line_items[tax4_amount][" + index + "]", lineItemTax4Amount);
            return this;
        }
        public ImportInvoiceRequest lineItemTierLineItemId(int index, String lineItemTierLineItemId) {
            params.add("line_item_tiers[line_item_id][" + index + "]", lineItemTierLineItemId);
            return this;
        }
        public ImportInvoiceRequest lineItemTierStartingUnit(int index, Integer lineItemTierStartingUnit) {
            params.add("line_item_tiers[starting_unit][" + index + "]", lineItemTierStartingUnit);
            return this;
        }
        public ImportInvoiceRequest lineItemTierEndingUnit(int index, Integer lineItemTierEndingUnit) {
            params.add("line_item_tiers[ending_unit][" + index + "]", lineItemTierEndingUnit);
            return this;
        }
        public ImportInvoiceRequest lineItemTierQuantityUsed(int index, Integer lineItemTierQuantityUsed) {
            params.add("line_item_tiers[quantity_used][" + index + "]", lineItemTierQuantityUsed);
            return this;
        }
        public ImportInvoiceRequest lineItemTierUnitAmount(int index, Integer lineItemTierUnitAmount) {
            params.add("line_item_tiers[unit_amount][" + index + "]", lineItemTierUnitAmount);
            return this;
        }
        public ImportInvoiceRequest discountEntityType(int index, Discount.EntityType discountEntityType) {
            params.add("discounts[entity_type][" + index + "]", discountEntityType);
            return this;
        }
        public ImportInvoiceRequest discountEntityId(int index, String discountEntityId) {
            params.addOpt("discounts[entity_id][" + index + "]", discountEntityId);
            return this;
        }
        public ImportInvoiceRequest discountDescription(int index, String discountDescription) {
            params.addOpt("discounts[description][" + index + "]", discountDescription);
            return this;
        }
        public ImportInvoiceRequest discountAmount(int index, Integer discountAmount) {
            params.add("discounts[amount][" + index + "]", discountAmount);
            return this;
        }
        public ImportInvoiceRequest taxName(int index, String taxName) {
            params.add("taxes[name][" + index + "]", taxName);
            return this;
        }
        public ImportInvoiceRequest taxRate(int index, Double taxRate) {
            params.add("taxes[rate][" + index + "]", taxRate);
            return this;
        }
        public ImportInvoiceRequest taxAmount(int index, Integer taxAmount) {
            params.addOpt("taxes[amount][" + index + "]", taxAmount);
            return this;
        }
        public ImportInvoiceRequest taxDescription(int index, String taxDescription) {
            params.addOpt("taxes[description][" + index + "]", taxDescription);
            return this;
        }

        public ImportInvoiceRequest taxJurisType(int index, com.chargebee.models.enums.TaxJurisType taxJurisType) {
            params.addOpt("taxes[juris_type][" + index + "]", taxJurisType);
            return this;
        }
        public ImportInvoiceRequest taxJurisName(int index, String taxJurisName) {
            params.addOpt("taxes[juris_name][" + index + "]", taxJurisName);
            return this;
        }
        public ImportInvoiceRequest taxJurisCode(int index, String taxJurisCode) {
            params.addOpt("taxes[juris_code][" + index + "]", taxJurisCode);
            return this;
        }
        public ImportInvoiceRequest paymentAmount(int index, Integer paymentAmount) {
            params.add("payments[amount][" + index + "]", paymentAmount);
            return this;
        }
        public ImportInvoiceRequest paymentPaymentMethod(int index, com.chargebee.models.enums.PaymentMethod paymentPaymentMethod) {
            params.add("payments[payment_method][" + index + "]", paymentPaymentMethod);
            return this;
        }
        public ImportInvoiceRequest paymentDate(int index, Timestamp paymentDate) {
            params.addOpt("payments[date][" + index + "]", paymentDate);
            return this;
        }
        public ImportInvoiceRequest paymentReferenceNumber(int index, String paymentReferenceNumber) {
            params.addOpt("payments[reference_number][" + index + "]", paymentReferenceNumber);
            return this;
        }
        public ImportInvoiceRequest noteEntityType(int index, Note.EntityType noteEntityType) {
            params.addOpt("notes[entity_type][" + index + "]", noteEntityType);
            return this;
        }
        public ImportInvoiceRequest noteEntityId(int index, String noteEntityId) {
            params.addOpt("notes[entity_id][" + index + "]", noteEntityId);
            return this;
        }
        public ImportInvoiceRequest noteNote(int index, String noteNote) {
            params.addOpt("notes[note][" + index + "]", noteNote);
            return this;
        }
        @Override
        public Params params() {
            return params;
        }
    }

    public static class ApplyPaymentsRequest extends Request<ApplyPaymentsRequest> {

        private ApplyPaymentsRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public ApplyPaymentsRequest transactionId(int index, String transactionId) {
            params.addOpt("transactions[id][" + index + "]", transactionId);
            return this;
        }
        @Override
        public Params params() {
            return params;
        }
    }

    public static class ApplyCreditsRequest extends Request<ApplyCreditsRequest> {

        private ApplyCreditsRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public ApplyCreditsRequest creditNoteId(int index, String creditNoteId) {
            params.addOpt("credit_notes[id][" + index + "]", creditNoteId);
            return this;
        }
        @Override
        public Params params() {
            return params;
        }
    }

    public static class InvoiceListRequest extends ListRequest<InvoiceListRequest> {

        private InvoiceListRequest(String uri) {
            super(uri);
        }
    
        @Deprecated
        public InvoiceListRequest paidOnAfter(Timestamp paidOnAfter) {
            params.addOpt("paid_on_after", paidOnAfter);
            return this;
        }


        public InvoiceListRequest includeDeleted(Boolean includeDeleted) {
            params.addOpt("include_deleted", includeDeleted);
            return this;
        }




        public StringFilter<InvoiceListRequest> id() {
            return new StringFilter<InvoiceListRequest>("id",this).supportsMultiOperators(true);        
        }


        public StringFilter<InvoiceListRequest> subscriptionId() {
            return new StringFilter<InvoiceListRequest>("subscription_id",this).supportsMultiOperators(true).supportsPresenceOperator(true);        
        }


        public StringFilter<InvoiceListRequest> customerId() {
            return new StringFilter<InvoiceListRequest>("customer_id",this).supportsMultiOperators(true);        
        }


        public BooleanFilter<InvoiceListRequest> recurring() {
            return new BooleanFilter<InvoiceListRequest>("recurring",this);        
        }


        public EnumFilter<Invoice.Status, InvoiceListRequest> status() {
            return new EnumFilter<Invoice.Status, InvoiceListRequest>("status",this);        
        }


        public EnumFilter<com.chargebee.models.enums.PriceType, InvoiceListRequest> priceType() {
            return new EnumFilter<com.chargebee.models.enums.PriceType, InvoiceListRequest>("price_type",this);        
        }


        public TimestampFilter<InvoiceListRequest> date() {
            return new TimestampFilter<InvoiceListRequest>("date",this);        
        }


        public TimestampFilter<InvoiceListRequest> paidAt() {
            return new TimestampFilter<InvoiceListRequest>("paid_at",this);        
        }


        public NumberFilter<Integer, InvoiceListRequest> total() {
            return new NumberFilter<Integer, InvoiceListRequest>("total",this);        
        }


        public NumberFilter<Integer, InvoiceListRequest> amountPaid() {
            return new NumberFilter<Integer, InvoiceListRequest>("amount_paid",this);        
        }


        public NumberFilter<Integer, InvoiceListRequest> amountAdjusted() {
            return new NumberFilter<Integer, InvoiceListRequest>("amount_adjusted",this);        
        }


        public NumberFilter<Integer, InvoiceListRequest> creditsApplied() {
            return new NumberFilter<Integer, InvoiceListRequest>("credits_applied",this);        
        }


        public NumberFilter<Integer, InvoiceListRequest> amountDue() {
            return new NumberFilter<Integer, InvoiceListRequest>("amount_due",this);        
        }


        public EnumFilter<Invoice.DunningStatus, InvoiceListRequest> dunningStatus() {
            return new EnumFilter<Invoice.DunningStatus, InvoiceListRequest>("dunning_status",this).supportsPresenceOperator(true);        
        }


        public TimestampFilter<InvoiceListRequest> updatedAt() {
            return new TimestampFilter<InvoiceListRequest>("updated_at",this);        
        }


        public TimestampFilter<InvoiceListRequest> voidedAt() {
            return new TimestampFilter<InvoiceListRequest>("voided_at",this);        
        }


        public InvoiceListRequest sortByDate(SortOrder order) {
            params.addOpt("sort_by["+order.name().toLowerCase()+"]","date");
            return this;
        }
        public InvoiceListRequest sortByUpdatedAt(SortOrder order) {
            params.addOpt("sort_by["+order.name().toLowerCase()+"]","updated_at");
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class PdfRequest extends Request<PdfRequest> {

        private PdfRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public PdfRequest dispositionType(com.chargebee.models.enums.DispositionType dispositionType) {
            params.addOpt("disposition_type", dispositionType);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class AddChargeRequest extends Request<AddChargeRequest> {

        private AddChargeRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public AddChargeRequest amount(Integer amount) {
            params.add("amount", amount);
            return this;
        }


        public AddChargeRequest description(String description) {
            params.add("description", description);
            return this;
        }


        public AddChargeRequest avalaraSaleType(com.chargebee.models.enums.AvalaraSaleType avalaraSaleType) {
            params.addOpt("avalara_sale_type", avalaraSaleType);
            return this;
        }


        public AddChargeRequest avalaraTransactionType(Integer avalaraTransactionType) {
            params.addOpt("avalara_transaction_type", avalaraTransactionType);
            return this;
        }


        public AddChargeRequest avalaraServiceType(Integer avalaraServiceType) {
            params.addOpt("avalara_service_type", avalaraServiceType);
            return this;
        }


        public AddChargeRequest lineItemDateFrom(Timestamp lineItemDateFrom) {
            params.addOpt("line_item[date_from]", lineItemDateFrom);
            return this;
        }

        public AddChargeRequest lineItemDateTo(Timestamp lineItemDateTo) {
            params.addOpt("line_item[date_to]", lineItemDateTo);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class AddAddonChargeRequest extends Request<AddAddonChargeRequest> {

        private AddAddonChargeRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public AddAddonChargeRequest addonId(String addonId) {
            params.add("addon_id", addonId);
            return this;
        }


        public AddAddonChargeRequest addonQuantity(Integer addonQuantity) {
            params.addOpt("addon_quantity", addonQuantity);
            return this;
        }


        public AddAddonChargeRequest addonUnitPrice(Integer addonUnitPrice) {
            params.addOpt("addon_unit_price", addonUnitPrice);
            return this;
        }


        public AddAddonChargeRequest lineItemDateFrom(Timestamp lineItemDateFrom) {
            params.addOpt("line_item[date_from]", lineItemDateFrom);
            return this;
        }

        public AddAddonChargeRequest lineItemDateTo(Timestamp lineItemDateTo) {
            params.addOpt("line_item[date_to]", lineItemDateTo);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class CollectPaymentRequest extends Request<CollectPaymentRequest> {

        private CollectPaymentRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public CollectPaymentRequest amount(Integer amount) {
            params.addOpt("amount", amount);
            return this;
        }


        public CollectPaymentRequest authorizationTransactionId(String authorizationTransactionId) {
            params.addOpt("authorization_transaction_id", authorizationTransactionId);
            return this;
        }


        public CollectPaymentRequest paymentSourceId(String paymentSourceId) {
            params.addOpt("payment_source_id", paymentSourceId);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class RecordPaymentRequest extends Request<RecordPaymentRequest> {

        private RecordPaymentRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RecordPaymentRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        public RecordPaymentRequest transactionAmount(Integer transactionAmount) {
            params.addOpt("transaction[amount]", transactionAmount);
            return this;
        }

        public RecordPaymentRequest transactionPaymentMethod(com.chargebee.models.enums.PaymentMethod transactionPaymentMethod) {
            params.add("transaction[payment_method]", transactionPaymentMethod);
            return this;
        }

        public RecordPaymentRequest transactionReferenceNumber(String transactionReferenceNumber) {
            params.addOpt("transaction[reference_number]", transactionReferenceNumber);
            return this;
        }

        public RecordPaymentRequest transactionIdAtGateway(String transactionIdAtGateway) {
            params.addOpt("transaction[id_at_gateway]", transactionIdAtGateway);
            return this;
        }

        public RecordPaymentRequest transactionStatus(Transaction.Status transactionStatus) {
            params.addOpt("transaction[status]", transactionStatus);
            return this;
        }

        public RecordPaymentRequest transactionDate(Timestamp transactionDate) {
            params.addOpt("transaction[date]", transactionDate);
            return this;
        }

        public RecordPaymentRequest transactionErrorCode(String transactionErrorCode) {
            params.addOpt("transaction[error_code]", transactionErrorCode);
            return this;
        }

        public RecordPaymentRequest transactionErrorText(String transactionErrorText) {
            params.addOpt("transaction[error_text]", transactionErrorText);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class RefundRequest extends Request<RefundRequest> {

        private RefundRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RefundRequest refundAmount(Integer refundAmount) {
            params.addOpt("refund_amount", refundAmount);
            return this;
        }


        public RefundRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        public RefundRequest customerNotes(String customerNotes) {
            params.addOpt("customer_notes", customerNotes);
            return this;
        }


        public RefundRequest creditNoteReasonCode(CreditNote.ReasonCode creditNoteReasonCode) {
            params.addOpt("credit_note[reason_code]", creditNoteReasonCode);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class RecordRefundRequest extends Request<RecordRefundRequest> {

        private RecordRefundRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RecordRefundRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        public RecordRefundRequest customerNotes(String customerNotes) {
            params.addOpt("customer_notes", customerNotes);
            return this;
        }


        public RecordRefundRequest transactionAmount(Integer transactionAmount) {
            params.addOpt("transaction[amount]", transactionAmount);
            return this;
        }

        public RecordRefundRequest transactionPaymentMethod(com.chargebee.models.enums.PaymentMethod transactionPaymentMethod) {
            params.add("transaction[payment_method]", transactionPaymentMethod);
            return this;
        }

        public RecordRefundRequest transactionReferenceNumber(String transactionReferenceNumber) {
            params.addOpt("transaction[reference_number]", transactionReferenceNumber);
            return this;
        }

        public RecordRefundRequest transactionDate(Timestamp transactionDate) {
            params.add("transaction[date]", transactionDate);
            return this;
        }

        public RecordRefundRequest creditNoteReasonCode(CreditNote.ReasonCode creditNoteReasonCode) {
            params.addOpt("credit_note[reason_code]", creditNoteReasonCode);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class RemovePaymentRequest extends Request<RemovePaymentRequest> {

        private RemovePaymentRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RemovePaymentRequest transactionId(String transactionId) {
            params.add("transaction[id]", transactionId);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class RemoveCreditNoteRequest extends Request<RemoveCreditNoteRequest> {

        private RemoveCreditNoteRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public RemoveCreditNoteRequest creditNoteId(String creditNoteId) {
            params.add("credit_note[id]", creditNoteId);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

    public static class VoidInvoiceRequest extends Request<VoidInvoiceRequest> {

        private VoidInvoiceRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public VoidInvoiceRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class WriteOffRequest extends Request<WriteOffRequest> {

        private WriteOffRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public WriteOffRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class DeleteRequest extends Request<DeleteRequest> {

        private DeleteRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public DeleteRequest comment(String comment) {
            params.addOpt("comment", comment);
            return this;
        }


        @Override
        public Params params() {
            return params;
        }
    }

    public static class UpdateDetailsRequest extends Request<UpdateDetailsRequest> {

        private UpdateDetailsRequest(Method httpMeth, String uri) {
            super(httpMeth, uri);
        }
    
        public UpdateDetailsRequest vatNumber(String vatNumber) {
            params.addOpt("vat_number", vatNumber);
            return this;
        }


        public UpdateDetailsRequest poNumber(String poNumber) {
            params.addOpt("po_number", poNumber);
            return this;
        }


        public UpdateDetailsRequest billingAddressFirstName(String billingAddressFirstName) {
            params.addOpt("billing_address[first_name]", billingAddressFirstName);
            return this;
        }

        public UpdateDetailsRequest billingAddressLastName(String billingAddressLastName) {
            params.addOpt("billing_address[last_name]", billingAddressLastName);
            return this;
        }

        public UpdateDetailsRequest billingAddressEmail(String billingAddressEmail) {
            params.addOpt("billing_address[email]", billingAddressEmail);
            return this;
        }

        public UpdateDetailsRequest billingAddressCompany(String billingAddressCompany) {
            params.addOpt("billing_address[company]", billingAddressCompany);
            return this;
        }

        public UpdateDetailsRequest billingAddressPhone(String billingAddressPhone) {
            params.addOpt("billing_address[phone]", billingAddressPhone);
            return this;
        }

        public UpdateDetailsRequest billingAddressLine1(String billingAddressLine1) {
            params.addOpt("billing_address[line1]", billingAddressLine1);
            return this;
        }

        public UpdateDetailsRequest billingAddressLine2(String billingAddressLine2) {
            params.addOpt("billing_address[line2]", billingAddressLine2);
            return this;
        }

        public UpdateDetailsRequest billingAddressLine3(String billingAddressLine3) {
            params.addOpt("billing_address[line3]", billingAddressLine3);
            return this;
        }

        public UpdateDetailsRequest billingAddressCity(String billingAddressCity) {
            params.addOpt("billing_address[city]", billingAddressCity);
            return this;
        }

        public UpdateDetailsRequest billingAddressStateCode(String billingAddressStateCode) {
            params.addOpt("billing_address[state_code]", billingAddressStateCode);
            return this;
        }

        public UpdateDetailsRequest billingAddressState(String billingAddressState) {
            params.addOpt("billing_address[state]", billingAddressState);
            return this;
        }

        public UpdateDetailsRequest billingAddressZip(String billingAddressZip) {
            params.addOpt("billing_address[zip]", billingAddressZip);
            return this;
        }

        public UpdateDetailsRequest billingAddressCountry(String billingAddressCountry) {
            params.addOpt("billing_address[country]", billingAddressCountry);
            return this;
        }

        public UpdateDetailsRequest billingAddressValidationStatus(com.chargebee.models.enums.ValidationStatus billingAddressValidationStatus) {
            params.addOpt("billing_address[validation_status]", billingAddressValidationStatus);
            return this;
        }

        public UpdateDetailsRequest shippingAddressFirstName(String shippingAddressFirstName) {
            params.addOpt("shipping_address[first_name]", shippingAddressFirstName);
            return this;
        }

        public UpdateDetailsRequest shippingAddressLastName(String shippingAddressLastName) {
            params.addOpt("shipping_address[last_name]", shippingAddressLastName);
            return this;
        }

        public UpdateDetailsRequest shippingAddressEmail(String shippingAddressEmail) {
            params.addOpt("shipping_address[email]", shippingAddressEmail);
            return this;
        }

        public UpdateDetailsRequest shippingAddressCompany(String shippingAddressCompany) {
            params.addOpt("shipping_address[company]", shippingAddressCompany);
            return this;
        }

        public UpdateDetailsRequest shippingAddressPhone(String shippingAddressPhone) {
            params.addOpt("shipping_address[phone]", shippingAddressPhone);
            return this;
        }

        public UpdateDetailsRequest shippingAddressLine1(String shippingAddressLine1) {
            params.addOpt("shipping_address[line1]", shippingAddressLine1);
            return this;
        }

        public UpdateDetailsRequest shippingAddressLine2(String shippingAddressLine2) {
            params.addOpt("shipping_address[line2]", shippingAddressLine2);
            return this;
        }

        public UpdateDetailsRequest shippingAddressLine3(String shippingAddressLine3) {
            params.addOpt("shipping_address[line3]", shippingAddressLine3);
            return this;
        }

        public UpdateDetailsRequest shippingAddressCity(String shippingAddressCity) {
            params.addOpt("shipping_address[city]", shippingAddressCity);
            return this;
        }

        public UpdateDetailsRequest shippingAddressStateCode(String shippingAddressStateCode) {
            params.addOpt("shipping_address[state_code]", shippingAddressStateCode);
            return this;
        }

        public UpdateDetailsRequest shippingAddressState(String shippingAddressState) {
            params.addOpt("shipping_address[state]", shippingAddressState);
            return this;
        }

        public UpdateDetailsRequest shippingAddressZip(String shippingAddressZip) {
            params.addOpt("shipping_address[zip]", shippingAddressZip);
            return this;
        }

        public UpdateDetailsRequest shippingAddressCountry(String shippingAddressCountry) {
            params.addOpt("shipping_address[country]", shippingAddressCountry);
            return this;
        }

        public UpdateDetailsRequest shippingAddressValidationStatus(com.chargebee.models.enums.ValidationStatus shippingAddressValidationStatus) {
            params.addOpt("shipping_address[validation_status]", shippingAddressValidationStatus);
            return this;
        }

        @Override
        public Params params() {
            return params;
        }
    }

}
