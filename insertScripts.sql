;             
CREATE USER IF NOT EXISTS "SA" SALT 'cfbd75709a46543b' HASH 'd6a34c6e06e78f8da337be2f8d039d9677aab25b65f3f645f872bfbf9d5c784e' ADMIN;         
CREATE SEQUENCE "PUBLIC"."PID" START WITH 1 INCREMENT BY 9999;
CREATE CACHED TABLE "PUBLIC"."REFFERED_TEMPLATE"(
    "REFFERED_TEMPLATE_ID" VARCHAR(255) NOT NULL,
    "TEMPLATE_ID" VARCHAR(255) NOT NULL
);             
ALTER TABLE "PUBLIC"."REFFERED_TEMPLATE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_A" PRIMARY KEY("REFFERED_TEMPLATE_ID", "TEMPLATE_ID");           
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.REFFERED_TEMPLATE;       
INSERT INTO "PUBLIC"."REFFERED_TEMPLATE" VALUES
('dce1f643-4f43-4131-bb79-5ff4b43e3614', '34237cf3-a967-41d0-a5ee-e28d21404055'),
('57df117e-7423-4c05-a6f6-452c08158cc2', '2c437167-9ddb-4ce6-a17e-420b2511d7f4');         
CREATE CACHED TABLE "PUBLIC"."TYPE_ELEMENT"(
    "NAMESPACE_ID" VARCHAR(255) NOT NULL SELECTIVITY 4,
    "SL_NO" INTEGER NOT NULL SELECTIVITY 100,
    "TYPE_ID" VARCHAR(255) NOT NULL SELECTIVITY 4,
    "ELEMENT_DESC" VARCHAR(255) SELECTIVITY 4,
    "ELEMENT_NAME" VARCHAR(255) SELECTIVITY 100,
    "ELEMENT_TYPE_ID" VARCHAR(255) SELECTIVITY 18,
    "MAX_OCCURS" VARCHAR(255) SELECTIVITY 4,
    "MIN_OCCURS" VARCHAR(255) SELECTIVITY 4
); 
ALTER TABLE "PUBLIC"."TYPE_ELEMENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_EB" PRIMARY KEY("NAMESPACE_ID", "SL_NO", "TYPE_ID");  
-- 67 +/- SELECT COUNT(*) FROM PUBLIC.TYPE_ELEMENT;           
INSERT INTO "PUBLIC"."TYPE_ELEMENT" VALUES
('N_0001', 1, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'transactionId', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 2, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'transactionTimestamp', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 3, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'typeCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 4, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'subTypeCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 5, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'txnGroupCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 6, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'businessStatusCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 7, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'processedStatusCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 8, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'paymentStatusCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 9, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'deliveryStatusCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 10, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'inventoryStatusCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 11, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'accountingStatusCode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 12, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'businessDayDate', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 13, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'cancelledFlag', 'ca327c8b-b683-406b-b8b5-919dd28952198', '1', '0'),
('N_0001', 14, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'transferedFlag', 'ca327c8b-b683-406b-b8b5-919dd28952198', '1', '0'),
('N_0001', 15, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'interstoreTxnFlag', 'ca327c8b-b683-406b-b8b5-919dd28952198', '1', '0'),
('N_0001', 16, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'lastLineitemSeqNum', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 17, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'cancelledIndex', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 18, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'lastActivitySeqNum', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 19, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalUnitCount', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 20, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalItemCount', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 21, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalGrsAmt', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '1', '0'),
('N_0001', 22, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalDscAmt', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '1', '0'),
('N_0001', 23, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalMrpDscAmt', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 24, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalNetsaleAmt', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '1', '0'),
('N_0001', 25, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTaxAmt', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '1', '0'),
('N_0001', 26, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'roundOffAmt', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 27, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalBillAmt', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '1', '0'),
('N_0001', 28, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalInvoiceAmt', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '1', '0'),
('N_0001', 29, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndAmt', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 30, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalDueAmt', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '1', '0'),
('N_0001', 31, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndCash', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0');              
INSERT INTO "PUBLIC"."TYPE_ELEMENT" VALUES
('N_0001', 32, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndCard', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 33, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndGiftcert', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 34, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndCoupon', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 35, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndNetbank', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 36, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndPg', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 37, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndCheque', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 38, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndDd', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 39, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndLylpts', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 40, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTndCusAcc', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 41, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalAdjNeg', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 42, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalAdjAdd', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 43, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalServiceCharge', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 44, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalED', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 45, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalVAT', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 46, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalCST', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 47, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalCgst', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 48, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalSgst', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 50, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalIgst', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '1', '0'),
('N_0001', 51, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'tcsPercent', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 52, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'totalTcsAmount', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 53, '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', NULL, 'tdsPercent', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 1, '89b9bb74-8b1f-47a7-af47-a20f85a0d4d1', NULL, 'fullName', 'bf81bca4-27ea-49d2-a354-8b7838c09dcc', '1', '0'),
('N_0001', 2, '89b9bb74-8b1f-47a7-af47-a20f85a0d4d1', NULL, 'emailId', '87ba812d-2314-45b1-b557-76f055c02d59', '1', '0'),
('N_0001', 3, '89b9bb74-8b1f-47a7-af47-a20f85a0d4d1', NULL, 'phoneNo', 'd81ff705-0cb1-4897-a5cb-481e35324d67', '1', '0'),
('N_0001', 1, 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', NULL, 'address1', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 2, 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', NULL, 'address2', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 3, 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', NULL, 'city', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 4, 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', NULL, 'state', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 5, 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', NULL, 'country', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 6, 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', NULL, 'pincode', 'ca327c8b-b683-406b-b8b5-919dd28952123', '1', '0'),
('N_0001', 1, 'debc16fd-2135-442c-92a9-5c57a7fb2482', NULL, 'accountNumber', '69e3a4d8-952b-4aee-a5ef-1a9cdf7265bf', '1', '0'),
('N_0001', 2, 'debc16fd-2135-442c-92a9-5c57a7fb2482', NULL, 'nomineeDetails', 'b548cf3c-07d4-473f-bf3e-366cdbe36786', '1', '0');   
INSERT INTO "PUBLIC"."TYPE_ELEMENT" VALUES
('N_0001', 3, 'debc16fd-2135-442c-92a9-5c57a7fb2482', NULL, 'address', 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', '1', '0'),
('N_0001', 1, 'b548cf3c-07d4-473f-bf3e-366cdbe36786', NULL, 'accountNumber', '69e3a4d8-952b-4aee-a5ef-1a9cdf7265bf', '1', '0'),
('N_0001', 2, 'b548cf3c-07d4-473f-bf3e-366cdbe36786', NULL, 'details', '89b9bb74-8b1f-47a7-af47-a20f85a0d4d1', '1', '0'),
('N_0001', 3, 'b548cf3c-07d4-473f-bf3e-366cdbe36786', NULL, 'address', 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', '1', '0');  
CREATE CACHED TABLE "PUBLIC"."TYPESREPO"(
    "NAMESPACE_ID" VARCHAR(255) NOT NULL,
    "TYPE_ID" VARCHAR(255) NOT NULL,
    "DESC" VARCHAR(255),
    "TEMPLATE_ID" VARCHAR(255),
    "TYPE" VARCHAR(255),
    "TYPE_NAME" VARCHAR(255),
    "ENUMS" VARCHAR(255),
    "MAX_OCCURS" VARCHAR(255),
    "MIN_OCCURS" VARCHAR(255),
    "PATTERN" VARCHAR(255)
);     
ALTER TABLE "PUBLIC"."TYPESREPO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C6" PRIMARY KEY("NAMESPACE_ID", "TYPE_ID");              
-- 39 +/- SELECT COUNT(*) FROM PUBLIC.TYPESREPO;              
INSERT INTO "PUBLIC"."TYPESREPO" VALUES
('N_0001', 'b548cf3c-07d4-473f-bf3e-366cdbe36786', '', '34237cf3-a967-41d0-a5ee-e28d21404055', 'CT', 'NomineeDetails', NULL, NULL, NULL, NULL),
('N_0001', '69e3a4d8-952b-4aee-a5ef-1a9cdf7265bf', 'account number for all the account types like saving account, current account', '34237cf3-a967-41d0-a5ee-e28d21404055', 'ST', 'AccountNumber', NULL, '10', '0', NULL),
('N_0001', 'e07fa30f-7c43-4472-a507-cc8e1340b82b', '', '34237cf3-a967-41d0-a5ee-e28d21404055', 'ST', 'AccountType', NULL, NULL, NULL, NULL),
('N_0001', '47c063a2-e52b-475b-8be0-3cb320f0af53', '', '34237cf3-a967-41d0-a5ee-e28d21404055', 'ST', 'IfscCode', NULL, NULL, NULL, NULL),
('N_0001', '910cce5a-70e0-4958-8912-f983f22c59ea', '', '34237cf3-a967-41d0-a5ee-e28d21404055', 'ST', 'FirstName', NULL, NULL, NULL, NULL),
('N_0001', '54bad129-46e3-49d7-a465-905bf7dc25e3', '', '34237cf3-a967-41d0-a5ee-e28d21404055', 'ST', 'MiddleName', NULL, NULL, NULL, NULL),
('N_0001', '8d2557ba-2435-4257-a10d-607194e2ab2d', '', '34237cf3-a967-41d0-a5ee-e28d21404055', 'ST', 'LastName', NULL, NULL, NULL, NULL),
('N_0001', 'debc16fd-2135-442c-92a9-5c57a7fb2482', '', '34237cf3-a967-41d0-a5ee-e28d21404055', 'CT', 'Account', NULL, NULL, NULL, NULL),
('N_0001', 'c9b5b125-6de9-4e80-9991-5f33f7f115b8', 'Address type which contains complete address requirements', '34237cf3-a967-41d0-a5ee-e28d21404055', 'CT', 'Address', NULL, NULL, NULL, NULL),
('N_0001', 'bf81bca4-27ea-49d2-a354-8b7838c09dcc', '', 'dce1f643-4f43-4131-bb79-5ff4b43e3614', 'ST', 'fullName', NULL, NULL, NULL, NULL),
('N_0001', '89b9bb74-8b1f-47a7-af47-a20f85a0d4d1', '', 'dce1f643-4f43-4131-bb79-5ff4b43e3614', 'CT', 'details', NULL, NULL, NULL, NULL),
('N_0001', '87ba812d-2314-45b1-b557-76f055c02d59', '', 'dce1f643-4f43-4131-bb79-5ff4b43e3614', 'ST', 'emailId', NULL, NULL, NULL, NULL),
('N_0001', 'd81ff705-0cb1-4897-a5cb-481e35324d67', '', 'dce1f643-4f43-4131-bb79-5ff4b43e3614', 'ST', 'phoneNo', NULL, NULL, NULL, NULL),
('N_0001', 'b97b6dfc-fb36-4510-91b6-d100224a3c82', '', '339d079b-57b8-4155-8bbf-99f78bfc72fb', 'ST', 'refId', NULL, NULL, NULL, NULL),
('N_0001', '3f3eee58-9203-4d12-bef8-532fe5246d73', '', '339d079b-57b8-4155-8bbf-99f78bfc72fb', 'ST', 'amount', NULL, NULL, NULL, NULL),
('N_0001', 'ca327c8b-b683-406b-b8b5-919dd289521c', '', '339d079b-57b8-4155-8bbf-99f78bfc72fb', 'CT', 'summaryDetails', NULL, NULL, NULL, NULL),
('N_0001', 'ca327c8b-b683-406b-b8b5-919dd28952123', '', '', 'PT', 'String', NULL, NULL, NULL, NULL),
('N_0001', 'ca327c8b-b683-406b-b8b5-919dd289521245', '', '', 'PT', 'Float', NULL, NULL, NULL, NULL),
('N_0001', 'b6c3452a-f6e4-45cf-a4c3-97d819f3acf8', '', '2c437167-9ddb-4ce6-a17e-420b2511d7f4', 'ST', 'ReturnCode', NULL, NULL, NULL, NULL),
('N_0001', '3136d65e-7169-4bf1-908e-a14469f4addb', '', '2c437167-9ddb-4ce6-a17e-420b2511d7f4', 'ST', 'ReturnText', NULL, NULL, NULL, NULL),
('N_0001', '6a3ac6d3-ec52-452f-9e34-8729f96fe242', '', '2c437167-9ddb-4ce6-a17e-420b2511d7f4', 'ST', 'RequestUrl', NULL, NULL, NULL, NULL),
('N_0001', '327ecc3d-1ff1-4f6b-a051-16eda0c259de', '', '2c437167-9ddb-4ce6-a17e-420b2511d7f4', 'ST', 'ReturnDataCount', NULL, NULL, NULL, NULL),
('N_0001', 'a22fdba9-d417-4839-807d-f2bed4a2ebaa', '', '2c437167-9ddb-4ce6-a17e-420b2511d7f4', 'CT', 'Response', NULL, NULL, NULL, NULL),
('N_0001', '5fd700e3-09f4-4cd5-b7a4-aa93f084cdd8', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'CT', 'Event', NULL, NULL, NULL, NULL),
('N_0001', '4c721971-dd2d-4fb7-955b-4a3c97b15a5a', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'type', NULL, NULL, NULL, NULL),
('N_0001', '163a0d28-359f-45ac-825f-4feb44ab9664', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'subType', NULL, NULL, NULL, NULL),
('N_0001', '2c12e898-9ab4-4b2e-94d3-7f45923cc00d', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'eventTime', NULL, NULL, NULL, NULL),
('N_0001', '0edaa5b5-159e-44a6-9323-8d2b1d1bd0aa', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'operator', NULL, NULL, NULL, NULL),
('N_0001', '48e4a7f7-3437-414b-87a2-52d72bf4d69b', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'bsc', NULL, NULL, NULL, NULL);               
INSERT INTO "PUBLIC"."TYPESREPO" VALUES
('N_0001', 'afc4f662-7716-40d3-ace7-bb376ea2d339', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'isc', NULL, NULL, NULL, NULL),
('N_0001', '73bbcc35-7099-49b2-90a2-ccfcd1cf7768', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'dsc', NULL, NULL, NULL, NULL),
('N_0001', 'a52025d2-67d5-4be1-aa64-4c616ecfefec', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'activityNum', NULL, NULL, NULL, NULL),
('N_0001', 'be87d9af-c6c4-4f09-bc0f-313ed4d922ae', '', '57df117e-7423-4c05-a6f6-452c08158cc2', 'ST', 'transactionId', NULL, NULL, NULL, NULL),
('N_0001', '5e298308-8b4f-4bc7-8366-b46641077e53', '', '2c437167-9ddb-4ce6-a17e-420b2511d7f4', 'CT', 'Events', NULL, NULL, NULL, NULL),
('N_0001', 'ca327c8b-b683-406b-b8b5-919dd2895298245', '', '', 'PT', 'Decimal', NULL, NULL, NULL, NULL),
('N_0001', 'ca327c8b-b683-406b-b8b5-919dd28952198', '', '', 'PT', 'Boolean', NULL, NULL, NULL, NULL),
('N_0001', '948dbacd-feb8-4ed9-8621-ccc7917f1c3d', '', 'fa453472-3bae-4cac-ba97-1a21c1ea4003', 'CT', 'CustomerSaleTxn', NULL, NULL, NULL, NULL),
('N_0001', 'ca3456c8b-b683-406b-b8b5-919dd28952123', '', '', 'PT', 'Integer', NULL, NULL, NULL, NULL),
('N_0001', 'ase34edf-b683-406b-b8b5-919dd28952123', '', '', 'PT', 'Date', NULL, NULL, NULL, NULL);      
CREATE CACHED TABLE "PUBLIC"."USER"(
    "UID" VARCHAR(255) NOT NULL,
    "DISPLAY_NAME" VARCHAR(255),
    "EMAIL" VARCHAR(255),
    "EMAIL_VERIFIED" BOOLEAN NOT NULL,
    "PHOTOURL" VARCHAR(255)
);  
ALTER TABLE "PUBLIC"."USER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("UID");        
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.USER;    
INSERT INTO "PUBLIC"."USER" VALUES
('pxbKCj3lkbcaeWkBpIU4nfKMrA12', 'Venkata Seshu', 'venkata.seshu@netmeds.com', TRUE, 'https://lh3.googleusercontent.com/a/AATXAJxgxKZX6frv49LTRecvqHMckYEUDS6AkV4Yxefg=s96-c');           
CREATE CACHED TABLE "PUBLIC"."SWAGGER_SPEC"(
    "ID" VARCHAR(255) NOT NULL,
    "PID" VARCHAR(255) NOT NULL,
    "SPEC" CLOB
);          
ALTER TABLE "PUBLIC"."SWAGGER_SPEC" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E" PRIMARY KEY("ID", "PID");          
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.SWAGGER_SPEC;            
CREATE TABLE IF NOT EXISTS SYSTEM_LOB_STREAM(ID INT NOT NULL, PART INT NOT NULL, CDATA VARCHAR, BDATA BINARY);
CREATE PRIMARY KEY SYSTEM_LOB_STREAM_PRIMARY_KEY ON SYSTEM_LOB_STREAM(ID, PART);              
CREATE ALIAS IF NOT EXISTS SYSTEM_COMBINE_CLOB FOR "org.h2.command.dml.ScriptCommand.combineClob";            
CREATE ALIAS IF NOT EXISTS SYSTEM_COMBINE_BLOB FOR "org.h2.command.dml.ScriptCommand.combineBlob";            
INSERT INTO SYSTEM_LOB_STREAM VALUES(0, 0, STRINGDECODE('swagger: ''2.0''\ninfo:\n  description: ''This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.''\n  version: 1.0.5\n  title: Swagger Pet\n  termsOfService: http://swagger.io/terms/\n  contact:\n    email: apiteam@swagger.io\n  license:\n    name: Apache 2.0\n    url: http://www.apache.org/licenses/LICENSE-2.0.html\nhost: petstore.swagger.io\nbasePath: /v2\ntags:\n  - name: pet\n    description: Everything about your Pets\n    externalDocs:\n      description: Find out more\n      url: http://swagger.io\n  - name: store\n    description: Access to Petstore orders\n  - name: user\n    description: Operations about user\n    externalDocs:\n      description: Find out more about our store\n      url: http://swagger.io\nschemes:\n  - https\n  - http\npaths:\n  /pet/{petId}/uploadImage:\n    post:\n      tags:\n        - pet\n      summary: uploads an image\n      description: ''''\n      operationId: uploadFile\n      consumes:\n        - multipart/form-data\n      produces:\n        - application/json\n      parameters:\n        - name: petId\n          in: path\n          description: ID of pet to update\n          required: true\n          type: integer\n          format: int64\n        - name: additionalMetadata\n          in: formData\n          description: Additional data to pass to server\n          required: false\n          type: string\n        - name: file\n          in: formData\n          description: file to upload\n          required: false\n          type: file\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/ApiResponse''\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n  /pet:\n    post:\n      tags:\n        - pet\n      summary: Add a new pet to the store\n      description: ''''\n      operationId: addPet\n      consumes:\n        - application/json\n        - application/xml\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: Pet object that needs to be added to the store\n          required: true\n          schema:\n            $ref: ''#/definitions/Pet''\n      responses:\n        ''405'':\n          description: Invalid input\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n    put:\n      tags:\n        - pet\n      summary: Update an existing pet\n      description: ''''\n      operationId: updatePet\n      consumes:\n        - application/json\n        - application/xml\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: Pet object that needs to be added to the store\n          required: true\n          schema:\n            $ref: ''#/definitions/Pet''\n      responses:\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Pet not found\n        ''405'':\n          description: Validation exception\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n  /pet/findByStatus:\n    get:\n      tags:\n        - pet\n      summary: Finds Pets by status\n      description: Multiple status values can be provided with comma separated strings\n      operationId: findPetsByStatus\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: status\n          in: query\n          description: Status values that need to be considered for filter\n          required: true\n          type: array\n          items:\n            type: string\n            enum:\n              - available\n              - pending\n              - sold\n            default: available\n          collectionFormat: multi\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            type: array\n            items:\n              $ref: ''#/def'), NULL);    
INSERT INTO SYSTEM_LOB_STREAM VALUES(0, 1, STRINGDECODE('initions/Pet''\n        ''400'':\n          description: Invalid status value\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n  /pet/findByTags:\n    get:\n      tags:\n        - pet\n      summary: Finds Pets by tags\n      description: Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.\n      operationId: findPetsByTags\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: tags\n          in: query\n          description: Tags to filter by\n          required: true\n          type: array\n          items:\n            type: string\n          collectionFormat: multi\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            type: array\n            items:\n              $ref: ''#/definitions/Pet''\n        ''400'':\n          description: Invalid tag value\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n      deprecated: true\n  /pet/{petId}:\n    get:\n      tags:\n        - pet\n      summary: Find pet by ID\n      description: Returns a single pet\n      operationId: getPetById\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: petId\n          in: path\n          description: ID of pet to return\n          required: true\n          type: integer\n          format: int64\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/Pet''\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Pet not found\n      security:\n        - api_key: []\n    post:\n      tags:\n        - pet\n      summary: Updates a pet in the store with form data\n      description: ''''\n      operationId: updatePetWithForm\n      consumes:\n        - application/x-www-form-urlencoded\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: petId\n          in: path\n          description: ID of pet that needs to be updated\n          required: true\n          type: integer\n          format: int64\n        - name: name\n          in: formData\n          description: Updated name of the pet\n          required: false\n          type: string\n        - name: status\n          in: formData\n          description: Updated status of the pet\n          required: false\n          type: string\n      responses:\n        ''405'':\n          description: Invalid input\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n    delete:\n      tags:\n        - pet\n      summary: Deletes a pet\n      description: ''''\n      operationId: deletePet\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: api_key\n          in: header\n          required: false\n          type: string\n        - name: petId\n          in: path\n          description: Pet id to delete\n          required: true\n          type: integer\n          format: int64\n      responses:\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Pet not found\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n  /store/inventory:\n    get:\n      tags:\n        - store\n      summary: Returns pet inventories by status\n      description: Returns a map of status codes to quantities\n      operationId: getInventory\n      produces:\n        - application/json\n      parameters: []\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            type: object\n            additionalProperties:\n              type: integer\n              format: int32\n      security:\n        - api_key: []\n  /store/order:\n    post:\n      tags:\n        - store\n      summary: Place an order for a pet\n      description: ''''\n      operationId: placeOrder\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in:'), NULL);       
INSERT INTO SYSTEM_LOB_STREAM VALUES(0, 2, STRINGDECODE(' body\n          name: body\n          description: order placed for purchasing the pet\n          required: true\n          schema:\n            $ref: ''#/definitions/Order''\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/Order''\n        ''400'':\n          description: Invalid Order\n  /store/order/{orderId}:\n    get:\n      tags:\n        - store\n      summary: Find purchase order by ID\n      description: For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions\n      operationId: getOrderById\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: orderId\n          in: path\n          description: ID of pet that needs to be fetched\n          required: true\n          type: integer\n          maximum: 10\n          minimum: 1\n          format: int64\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/Order''\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Order not found\n    delete:\n      tags:\n        - store\n      summary: Delete purchase order by ID\n      description: For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors\n      operationId: deleteOrder\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: orderId\n          in: path\n          description: ID of the order that needs to be deleted\n          required: true\n          type: integer\n          minimum: 1\n          format: int64\n      responses:\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Order not found\n  /user/createWithList:\n    post:\n      tags:\n        - user\n      summary: Creates list of users with given input array\n      description: ''''\n      operationId: createUsersWithListInput\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: List of user object\n          required: true\n          schema:\n            type: array\n            items:\n              $ref: ''#/definitions/User''\n      responses:\n        default:\n          description: successful operation\n  /user/{username}:\n    get:\n      tags:\n        - user\n      summary: Get user by user name\n      description: ''''\n      operationId: getUserByName\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: username\n          in: path\n          description: ''The name that needs to be fetched. Use user1 for testing. ''\n          required: true\n          type: string\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/User''\n        ''400'':\n          description: Invalid username supplied\n        ''404'':\n          description: User not found\n    put:\n      tags:\n        - user\n      summary: Updated user\n      description: This can only be done by the logged in user.\n      operationId: updateUser\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: username\n          in: path\n          description: name that need to be updated\n          required: true\n          type: string\n        - in: body\n          name: body\n          description: Updated user object\n          required: true\n          schema:\n            $ref: ''#/definitions/User''\n      responses:\n        ''400'':\n          description: Invalid user supplied\n        ''404'':\n          description: User not found\n    delete:\n      tags:\n        - user\n      summary: Delete user\n      description: This can only be done by the logged in user.\n      operationId: deleteUser\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: username\n'), NULL);          
INSERT INTO SYSTEM_LOB_STREAM VALUES(0, 3, STRINGDECODE('          in: path\n          description: The name that needs to be deleted\n          required: true\n          type: string\n      responses:\n        ''400'':\n          description: Invalid username supplied\n        ''404'':\n          description: User not found\n  /user/login:\n    get:\n      tags:\n        - user\n      summary: Logs user into the system\n      description: ''''\n      operationId: loginUser\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: username\n          in: query\n          description: The user name for login\n          required: true\n          type: string\n        - name: password\n          in: query\n          description: The password for login in clear text\n          required: true\n          type: string\n      responses:\n        ''200'':\n          description: successful operation\n          headers:\n            X-Expires-After:\n              type: string\n              format: date-time\n              description: date in UTC when token expires\n            X-Rate-Limit:\n              type: integer\n              format: int32\n              description: calls per hour allowed by the user\n          schema:\n            type: string\n        ''400'':\n          description: Invalid username/password supplied\n  /user/logout:\n    get:\n      tags:\n        - user\n      summary: Logs out current logged in user session\n      description: ''''\n      operationId: logoutUser\n      produces:\n        - application/json\n        - application/xml\n      parameters: []\n      responses:\n        default:\n          description: successful operation\n  /user/createWithArray:\n    post:\n      tags:\n        - user\n      summary: Creates list of users with given input array\n      description: ''''\n      operationId: createUsersWithArrayInput\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: List of user object\n          required: true\n          schema:\n            type: array\n            items:\n              $ref: ''#/definitions/User''\n      responses:\n        default:\n          description: successful operation\n  /user:\n    post:\n      tags:\n        - user\n      summary: Create user\n      description: This can only be done by the logged in user.\n      operationId: createUser\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: Created user object\n          required: true\n          schema:\n            $ref: ''#/definitions/User''\n      responses:\n        default:\n          description: successful operation\nsecurityDefinitions:\n  api_key:\n    type: apiKey\n    name: api_key\n    in: header\n  petstore_auth:\n    type: oauth2\n    authorizationUrl: https://petstore.swagger.io/oauth/authorize\n    flow: implicit\n    scopes:\n      read:pets: read your pets\n      write:pets: modify pets in your account\ndefinitions:\n  ApiResponse:\n    type: object\n    properties:\n      code:\n        type: integer\n        format: int32\n      type:\n        type: string\n      message:\n        type: string\n  Category:\n    type: object\n    properties:\n      id:\n        type: integer\n        format: int64\n      name:\n        type: string\n    xml:\n      name: Category\n  Pet:\n    type: object\n    required:\n      - name\n      - photoUrls\n    properties:\n      id:\n        type: integer\n        format: int64\n      category:\n        $ref: ''#/definitions/Category''\n      name:\n        type: string\n        example: doggie\n      photoUrls:\n        type: array\n        xml:\n          wrapped: true\n        items:\n          type: string\n          xml:\n            name: photoUrl\n      tags:\n        type: array\n        xml:\n          wrapped: true\n        items:\n          xml:\n            name: tag\n          $ref: ''#/definitions/Tag''\n      status:\n        type: string\n        description: pet status in the store\n        enum:\n          - available\n          - pending\n   '), NULL);      
INSERT INTO SYSTEM_LOB_STREAM VALUES(0, 4, STRINGDECODE('       - sold\n    xml:\n      name: Pet\n  Tag:\n    type: object\n    properties:\n      id:\n        type: integer\n        format: int64\n      name:\n        type: string\n    xml:\n      name: Tag\n  Order:\n    type: object\n    properties:\n      id:\n        type: integer\n        format: int64\n      petId:\n        type: integer\n        format: int64\n      quantity:\n        type: integer\n        format: int32\n      shipDate:\n        type: string\n        format: date-time\n      status:\n        type: string\n        description: Order Status\n        enum:\n          - placed\n          - approved\n          - delivered\n      complete:\n        type: boolean\n    xml:\n      name: Order\n  User:\n    type: object\n    properties:\n      id:\n        type: integer\n        format: int64\n      username:\n        type: string\n      firstName:\n        type: string\n      lastName:\n        type: string\n      email:\n        type: string\n      password:\n        type: string\n      phone:\n        type: string\n      userStatus:\n        type: integer\n        format: int32\n        description: User Status\n    xml:\n      name: User\nexternalDocs:\n  description: Find out more about Swagger\n  url: http://swagger.io\n'), NULL); 
INSERT INTO SYSTEM_LOB_STREAM VALUES(1, 0, STRINGDECODE('swagger: ''2.0''\ninfo:\n  description: ''This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.''\n  version: 1.0.5\n  title: Petstore API\n  termsOfService: http://swagger.io/terms/\n  contact:\n    email: apiteam@swagger.io\n  license:\n    name: Apache 2.0\n    url: http://www.apache.org/licenses/LICENSE-2.0.html\nhost: petstore.swagger.io\nbasePath: /v2\ntags:\n  - name: pet\n    description: Everything about your Pets\n    externalDocs:\n      description: Find out more\n      url: http://swagger.io\n  - name: store\n    description: Access to Petstore orders\n  - name: user\n    description: Operations about user\n    externalDocs:\n      description: Find out more about our store\n      url: http://swagger.io\nschemes:\n  - https\n  - http\npaths:\n  /pet/{petId}/uploadImage:\n    post:\n      tags:\n        - pet\n      summary: uploads an image\n      description: ''''\n      operationId: uploadFile\n      consumes:\n        - multipart/form-data\n      produces:\n        - application/json\n      parameters:\n        - name: petId\n          in: path\n          description: ID of pet to update\n          required: true\n          type: integer\n          format: int64\n        - name: additionalMetadata\n          in: formData\n          description: Additional data to pass to server\n          required: false\n          type: string\n        - name: file\n          in: formData\n          description: file to upload\n          required: false\n          type: file\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/ApiResponse''\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n  /pet:\n    post:\n      tags:\n        - pet\n      summary: Add a new pet to the store\n      description: ''''\n      operationId: addPet\n      consumes:\n        - application/json\n        - application/xml\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: Pet object that needs to be added to the store\n          required: true\n          schema:\n            $ref: ''#/definitions/Pet''\n      responses:\n        ''405'':\n          description: Invalid input\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n    put:\n      tags:\n        - pet\n      summary: Update an existing pet\n      description: ''''\n      operationId: updatePet\n      consumes:\n        - application/json\n        - application/xml\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: Pet object that needs to be added to the store\n          required: true\n          schema:\n            $ref: ''#/definitions/Pet''\n      responses:\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Pet not found\n        ''405'':\n          description: Validation exception\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n  /pet/findByStatus:\n    get:\n      tags:\n        - pet\n      summary: Finds Pets by status\n      description: Multiple status values can be provided with comma separated strings\n      operationId: findPetsByStatus\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: status\n          in: query\n          description: Status values that need to be considered for filter\n          required: true\n          type: array\n          items:\n            type: string\n            enum:\n              - available\n              - pending\n              - sold\n            default: available\n          collectionFormat: multi\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            type: array\n            items:\n              $ref: ''#/de'), NULL);    
INSERT INTO SYSTEM_LOB_STREAM VALUES(1, 1, STRINGDECODE('finitions/Pet''\n        ''400'':\n          description: Invalid status value\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n  /pet/findByTags:\n    get:\n      tags:\n        - pet\n      summary: Finds Pets by tags\n      description: Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.\n      operationId: findPetsByTags\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: tags\n          in: query\n          description: Tags to filter by\n          required: true\n          type: array\n          items:\n            type: string\n          collectionFormat: multi\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            type: array\n            items:\n              $ref: ''#/definitions/Pet''\n        ''400'':\n          description: Invalid tag value\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n      deprecated: true\n  /pet/{petId}:\n    get:\n      tags:\n        - pet\n      summary: Find pet by ID\n      description: Returns a single pet\n      operationId: getPetById\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: petId\n          in: path\n          description: ID of pet to return\n          required: true\n          type: integer\n          format: int64\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/Pet''\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Pet not found\n      security:\n        - api_key: []\n    post:\n      tags:\n        - pet\n      summary: Updates a pet in the store with form data\n      description: ''''\n      operationId: updatePetWithForm\n      consumes:\n        - application/x-www-form-urlencoded\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: petId\n          in: path\n          description: ID of pet that needs to be updated\n          required: true\n          type: integer\n          format: int64\n        - name: name\n          in: formData\n          description: Updated name of the pet\n          required: false\n          type: string\n        - name: status\n          in: formData\n          description: Updated status of the pet\n          required: false\n          type: string\n      responses:\n        ''405'':\n          description: Invalid input\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n    delete:\n      tags:\n        - pet\n      summary: Deletes a pet\n      description: ''''\n      operationId: deletePet\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: api_key\n          in: header\n          required: false\n          type: string\n        - name: petId\n          in: path\n          description: Pet id to delete\n          required: true\n          type: integer\n          format: int64\n      responses:\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Pet not found\n      security:\n        - petstore_auth:\n            - write:pets\n            - read:pets\n  /store/inventory:\n    get:\n      tags:\n        - store\n      summary: Returns pet inventories by status\n      description: Returns a map of status codes to quantities\n      operationId: getInventory\n      produces:\n        - application/json\n      parameters: []\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            type: object\n            additionalProperties:\n              type: integer\n              format: int32\n      security:\n        - api_key: []\n  /store/order:\n    post:\n      tags:\n        - store\n      summary: Place an order for a pet\n      description: ''''\n      operationId: placeOrder\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in'), NULL);       
INSERT INTO SYSTEM_LOB_STREAM VALUES(1, 2, STRINGDECODE(': body\n          name: body\n          description: order placed for purchasing the pet\n          required: true\n          schema:\n            $ref: ''#/definitions/Order''\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/Order''\n        ''400'':\n          description: Invalid Order\n  /store/order/{orderId}:\n    get:\n      tags:\n        - store\n      summary: Find purchase order by ID\n      description: For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions\n      operationId: getOrderById\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: orderId\n          in: path\n          description: ID of pet that needs to be fetched\n          required: true\n          type: integer\n          maximum: 10\n          minimum: 1\n          format: int64\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/Order''\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Order not found\n    delete:\n      tags:\n        - store\n      summary: Delete purchase order by ID\n      description: For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors\n      operationId: deleteOrder\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: orderId\n          in: path\n          description: ID of the order that needs to be deleted\n          required: true\n          type: integer\n          minimum: 1\n          format: int64\n      responses:\n        ''400'':\n          description: Invalid ID supplied\n        ''404'':\n          description: Order not found\n  /user/createWithList:\n    post:\n      tags:\n        - user\n      summary: Creates list of users with given input array\n      description: ''''\n      operationId: createUsersWithListInput\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: List of user object\n          required: true\n          schema:\n            type: array\n            items:\n              $ref: ''#/definitions/User''\n      responses:\n        default:\n          description: successful operation\n  /user/{username}:\n    get:\n      tags:\n        - user\n      summary: Get user by user name\n      description: ''''\n      operationId: getUserByName\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: username\n          in: path\n          description: ''The name that needs to be fetched. Use user1 for testing. ''\n          required: true\n          type: string\n      responses:\n        ''200'':\n          description: successful operation\n          schema:\n            $ref: ''#/definitions/User''\n        ''400'':\n          description: Invalid username supplied\n        ''404'':\n          description: User not found\n    put:\n      tags:\n        - user\n      summary: Updated user\n      description: This can only be done by the logged in user.\n      operationId: updateUser\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: username\n          in: path\n          description: name that need to be updated\n          required: true\n          type: string\n        - in: body\n          name: body\n          description: Updated user object\n          required: true\n          schema:\n            $ref: ''#/definitions/User''\n      responses:\n        ''400'':\n          description: Invalid user supplied\n        ''404'':\n          description: User not found\n    delete:\n      tags:\n        - user\n      summary: Delete user\n      description: This can only be done by the logged in user.\n      operationId: deleteUser\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: username'), NULL);           
INSERT INTO SYSTEM_LOB_STREAM VALUES(1, 3, STRINGDECODE('\n          in: path\n          description: The name that needs to be deleted\n          required: true\n          type: string\n      responses:\n        ''400'':\n          description: Invalid username supplied\n        ''404'':\n          description: User not found\n  /user/login:\n    get:\n      tags:\n        - user\n      summary: Logs user into the system\n      description: ''''\n      operationId: loginUser\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - name: username\n          in: query\n          description: The user name for login\n          required: true\n          type: string\n        - name: password\n          in: query\n          description: The password for login in clear text\n          required: true\n          type: string\n      responses:\n        ''200'':\n          description: successful operation\n          headers:\n            X-Expires-After:\n              type: string\n              format: date-time\n              description: date in UTC when token expires\n            X-Rate-Limit:\n              type: integer\n              format: int32\n              description: calls per hour allowed by the user\n          schema:\n            type: string\n        ''400'':\n          description: Invalid username/password supplied\n  /user/logout:\n    get:\n      tags:\n        - user\n      summary: Logs out current logged in user session\n      description: ''''\n      operationId: logoutUser\n      produces:\n        - application/json\n        - application/xml\n      parameters: []\n      responses:\n        default:\n          description: successful operation\n  /user/createWithArray:\n    post:\n      tags:\n        - user\n      summary: Creates list of users with given input array\n      description: ''''\n      operationId: createUsersWithArrayInput\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: List of user object\n          required: true\n          schema:\n            type: array\n            items:\n              $ref: ''#/definitions/User''\n      responses:\n        default:\n          description: successful operation\n  /user:\n    post:\n      tags:\n        - user\n      summary: Create user\n      description: This can only be done by the logged in user.\n      operationId: createUser\n      consumes:\n        - application/json\n      produces:\n        - application/json\n        - application/xml\n      parameters:\n        - in: body\n          name: body\n          description: Created user object\n          required: true\n          schema:\n            $ref: ''#/definitions/User''\n      responses:\n        default:\n          description: successful operation\nsecurityDefinitions:\n  api_key:\n    type: apiKey\n    name: api_key\n    in: header\n  petstore_auth:\n    type: oauth2\n    authorizationUrl: https://petstore.swagger.io/oauth/authorize\n    flow: implicit\n    scopes:\n      read:pets: read your pets\n      write:pets: modify pets in your account\ndefinitions:\n  ApiResponse:\n    type: object\n    properties:\n      code:\n        type: integer\n        format: int32\n      type:\n        type: string\n      message:\n        type: string\n  Category:\n    type: object\n    properties:\n      id:\n        type: integer\n        format: int64\n      name:\n        type: string\n    xml:\n      name: Category\n  Pet:\n    type: object\n    required:\n      - name\n      - photoUrls\n    properties:\n      id:\n        type: integer\n        format: int64\n      category:\n        $ref: ''#/definitions/Category''\n      name:\n        type: string\n        example: doggie\n      photoUrls:\n        type: array\n        xml:\n          wrapped: true\n        items:\n          type: string\n          xml:\n            name: photoUrl\n      tags:\n        type: array\n        xml:\n          wrapped: true\n        items:\n          xml:\n            name: tag\n          $ref: ''#/definitions/Tag''\n      status:\n        type: string\n        description: pet status in the store\n        enum:\n          - available\n          - pending\n  '), NULL);     
INSERT INTO SYSTEM_LOB_STREAM VALUES(1, 4, STRINGDECODE('        - sold\n    xml:\n      name: Pet\n  Tag:\n    type: object\n    properties:\n      id:\n        type: integer\n        format: int64\n      name:\n        type: string\n    xml:\n      name: Tag\n  Order:\n    type: object\n    properties:\n      id:\n        type: integer\n        format: int64\n      petId:\n        type: integer\n        format: int64\n      quantity:\n        type: integer\n        format: int32\n      shipDate:\n        type: string\n        format: date-time\n      status:\n        type: string\n        description: Order Status\n        enum:\n          - placed\n          - approved\n          - delivered\n      complete:\n        type: boolean\n    xml:\n      name: Order\n  User:\n    type: object\n    properties:\n      id:\n        type: integer\n        format: int64\n      username:\n        type: string\n      firstName:\n        type: string\n      lastName:\n        type: string\n      email:\n        type: string\n      password:\n        type: string\n      phone:\n        type: string\n      userStatus:\n        type: integer\n        format: int32\n        description: User Status\n    xml:\n      name: User\nexternalDocs:\n  description: Find out more about Swagger\n  url: http://swagger.io\n'), NULL);
INSERT INTO "PUBLIC"."SWAGGER_SPEC" VALUES
('5536f7d9-797d-42d4-a9ae-1696357142fc', 'P_0000001', SYSTEM_COMBINE_CLOB(0)),
('d1c08f93-b649-421f-9825-1ee9db5a7ad1', 'P_0000001', SYSTEM_COMBINE_CLOB(1));    
CREATE CACHED TABLE "PUBLIC"."COMPLEX_TYPE"(
    "NAMESPACE_ID" VARCHAR(255) NOT NULL,
    "TYPE_ID" VARCHAR(255) NOT NULL
);              
ALTER TABLE "PUBLIC"."COMPLEX_TYPE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7" PRIMARY KEY("NAMESPACE_ID", "TYPE_ID");            
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.COMPLEX_TYPE;            
CREATE CACHED TABLE "PUBLIC"."FAVOURITE"(
    "ITEMID" VARCHAR(255) NOT NULL,
    "PID" VARCHAR(255) NOT NULL,
    "USERID" VARCHAR(255) NOT NULL,
    "FILE_DETAILS_ID" VARCHAR(255),
    "FILE_DETAILS_PID" VARCHAR(255)
);           
ALTER TABLE "PUBLIC"."FAVOURITE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3B" PRIMARY KEY("ITEMID", "PID", "USERID");              
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.FAVOURITE;               
INSERT INTO "PUBLIC"."FAVOURITE" VALUES
('e9b3b097-7b9d-4ac7-83f5-d989540d4958', 'P_0000001', 'pxbKCj3lkbcaeWkBpIU4nfKMrA12', NULL, NULL),
('fa453472-3bae-4cac-ba97-1a21c1ea4003', 'P_0000001', 'TIYJv4FhgROfOCHm4mxdKR6iqW33', NULL, NULL),
('34237cf3-a967-41d0-a5ee-e28d21404055', 'P_0000001', 'TIYJv4FhgROfOCHm4mxdKR6iqW33', NULL, NULL);           
CREATE CACHED TABLE "PUBLIC"."SIMPLE_TYPE"(
    "NAMESPACE_ID" VARCHAR(255) NOT NULL,
    "TYPE_ID" VARCHAR(255) NOT NULL,
    "MAX_LENGTH" INTEGER NOT NULL,
    "MIN_LENGTH" INTEGER NOT NULL,
    "REGEX" VARCHAR(255)
);            
ALTER TABLE "PUBLIC"."SIMPLE_TYPE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2D" PRIMARY KEY("NAMESPACE_ID", "TYPE_ID");            
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.SIMPLE_TYPE;             
CREATE CACHED TABLE "PUBLIC"."TEMPLATE"(
    "TEMPLATE_ID" VARCHAR(255) NOT NULL,
    "FORMAT" INTEGER NOT NULL,
    "MAX_OCCURS" INTEGER NOT NULL,
    "MIN_OCCURS" INTEGER NOT NULL,
    "NAMESPACE_ID" VARCHAR(255),
    "PUBLISHED" BOOLEAN NOT NULL,
    "ROOTTYPE_ID" VARCHAR(255),
    "TEMPLATE_DESC" VARCHAR(255)
);        
ALTER TABLE "PUBLIC"."TEMPLATE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D" PRIMARY KEY("TEMPLATE_ID");            
-- 20 +/- SELECT COUNT(*) FROM PUBLIC.TEMPLATE;               
INSERT INTO "PUBLIC"."TEMPLATE" VALUES
('b867f17e-b81b-41b5-9525-974469f53cc1', 0, 0, 0, NULL, FALSE, NULL, NULL),
('2e8e0751-25e0-4d34-9297-a0e6afd0ec5d', 0, 0, 0, NULL, FALSE, NULL, NULL),
('4232cb47-04bf-400b-a53b-1cee23ec2dba', 0, 0, 0, NULL, FALSE, NULL, NULL),
('1524c3b6-8c54-44a8-a67c-39feeacf098f', 0, 0, 0, NULL, FALSE, NULL, NULL),
('5170a9d9-4fbe-47d8-9e30-992739c27228', 0, 0, 0, NULL, FALSE, NULL, NULL),
('27c99e43-2dd1-46ba-81db-13baa19653e1', 0, 0, 0, NULL, FALSE, NULL, NULL),
('0197e1e9-5f94-4b81-a39a-80680f0a6ef8', 0, 0, 0, NULL, FALSE, NULL, NULL),
('537fb44f-3d57-4c54-9a5e-e0b312689d21', 0, 0, 0, NULL, FALSE, NULL, NULL),
('8c71d285-a9ab-4b31-9713-db3335fdfeb2', 0, 0, 0, NULL, FALSE, NULL, NULL),
('bd53a2ac-86fd-461a-a026-9f4d395cee57', 0, 0, 0, NULL, FALSE, NULL, NULL),
('83850ac0-4a0b-4140-8b4b-d4fc52af9b60', 0, 0, 0, NULL, FALSE, NULL, NULL),
('4754d3db-8f9d-4965-9233-06cc36e99733', 0, 0, 0, NULL, FALSE, NULL, NULL),
('34237cf3-a967-41d0-a5ee-e28d21404055', 0, 0, 0, '', FALSE, 'debc16fd-2135-442c-92a9-5c57a7fb2482', ''),
('4467b7b2-3295-4949-aa8c-31b71b5edaed', 0, 0, 0, NULL, FALSE, NULL, NULL),
('bc83bfd2-46ed-4d4c-a600-3cd87904e699', 0, 0, 0, NULL, FALSE, NULL, NULL),
('a90809b9-7b97-40d0-adc7-9fb2171ee8f8', 0, 0, 0, NULL, FALSE, 'a22fdba9-d417-4839-807d-f2bed4a2ebaa', NULL),
('8cefef22-8167-4862-a0a2-39443e57bee8', 0, 0, 0, NULL, FALSE, 'a22fdba9-d417-4839-807d-f2bed4a2ebaa', NULL),
('b1953b18-a2f6-4984-8909-8ddd31c0fa3a', 0, 0, 0, NULL, FALSE, 'a22fdba9-d417-4839-807d-f2bed4a2ebaa', NULL),
('2c437167-9ddb-4ce6-a17e-420b2511d7f4', 0, 0, 0, '', FALSE, 'a22fdba9-d417-4839-807d-f2bed4a2ebaa', ''),
('78becdae-276b-4e6c-92e1-77ebe0dfd596', 0, 0, 0, NULL, FALSE, NULL, NULL);  
CREATE CACHED TABLE "PUBLIC"."API_REPO"(
    "APIDOC_ID" VARCHAR(255) NOT NULL,
    "APIID" VARCHAR(255) NOT NULL,
    "ENDPOINT_ID" VARCHAR(255) NOT NULL,
    "METHOD" VARCHAR(255) NOT NULL,
    "PID" VARCHAR(255) NOT NULL,
    "URL" VARCHAR(255) NOT NULL,
    "API_NAME" VARCHAR(255),
    "DESC" VARCHAR(255)
);            
ALTER TABLE "PUBLIC"."API_REPO" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("APIDOC_ID", "APIID", "ENDPOINT_ID", "METHOD", "PID", "URL");              
-- 7 +/- SELECT COUNT(*) FROM PUBLIC.API_REPO;
INSERT INTO "PUBLIC"."API_REPO" VALUES
('9b4616cc-6e4f-4543-9679-573fe9d8763f', '59c66fe9-c33e-4aff-8383-9facb5c3f4aa', 'E0001', 'POST', 'P_0000001', '/account/saving', 'create Saving Account', ''),
('9b4616cc-6e4f-4543-9679-573fe9d8763f', '91c9fc6f-68b9-421a-b25a-70dc92580c63', 'E0001', 'POST', 'P_0000001', '/account/current', 'create Current Account', ''),
('9b4616cc-6e4f-4543-9679-573fe9d8763f', 'c5594286-2909-4c5d-8491-1af73202d866', 'E0001', 'GET', 'P_0000001', '/account/{accountNo}', 'get Account details', ''),
('9b4616cc-6e4f-4543-9679-573fe9d8763f', '29521180-a3ec-45e3-9843-fd26d228e6f6', 'E0001', 'POST', 'P_0000001', '/account/{accountNo}/address', 'add address detail', 'add account address details based on the account number'),
('9b4616cc-6e4f-4543-9679-573fe9d8763f', 'e4229d7c-6365-4e27-a024-0534788ba932', 'E0001', 'PUT', 'P_0000001', '/account/{accountNo}/saving', 'update Saving Account', ''),
('9b4616cc-6e4f-4543-9679-573fe9d8763f', 'd637a807-14d6-4db3-b0f3-c0dce876f0f8', 'E0001', 'PUT', 'P_0000001', '/account/{accountNo}/current', 'update Current Account', ''),
('9b4616cc-6e4f-4543-9679-573fe9d8763f', 'fa91d3a3-4b6f-45c1-88bf-aa9d2025fbcf', 'E0001', 'DELETE', 'P_0000001', '/api/{accountNo}', 'delete account', '');        
CREATE CACHED TABLE "PUBLIC"."API_PATH_PARAM"(
    "APIID" VARCHAR(255) NOT NULL,
    "PARAM_ID" VARCHAR(255) NOT NULL,
    "ACTIVE" BOOLEAN NOT NULL,
    "DESCRIPTION" VARCHAR(255),
    "PARAM_NAME" VARCHAR(255),
    "PARAM_TYPE" VARCHAR(255),
    "TEMPLATE" VARCHAR(255)
);   
ALTER TABLE "PUBLIC"."API_PATH_PARAM" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_EE" PRIMARY KEY("APIID", "PARAM_ID");               
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.API_PATH_PARAM;          
INSERT INTO "PUBLIC"."API_PATH_PARAM" VALUES
('29521180-a3ec-45e3-9843-fd26d228e6f6', '2f9aca69-d1e3-4188-85f9-ad57c4b6d625', TRUE, 'account no of the account holder', 'accountNo', '69e3a4d8-952b-4aee-a5ef-1a9cdf7265bf', NULL);          
CREATE CACHED TABLE "PUBLIC"."NAMESPACEREP"(
    "NAMESPACE_ID" VARCHAR(255) NOT NULL,
    "DESCRIPTION" VARCHAR(255),
    "NAMESPACE_URL" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."NAMESPACEREP" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3F" PRIMARY KEY("NAMESPACE_ID");      
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.NAMESPACEREP;            
CREATE CACHED TABLE "PUBLIC"."API_HEADER_PARAM"(
    "APIID" VARCHAR(255) NOT NULL,
    "PARAM_ID" VARCHAR(255) NOT NULL,
    "DEFAULTVALUE" VARCHAR(255),
    "DESCRIPTION" VARCHAR(255),
    "MANDATORY" BOOLEAN NOT NULL,
    "PARAM_NAME" VARCHAR(255),
    "PARAM_TYPE" VARCHAR(255),
    "TEMPLATE" VARCHAR(255)
);            
ALTER TABLE "PUBLIC"."API_HEADER_PARAM" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("APIID", "PARAM_ID");              
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.API_HEADER_PARAM;        
INSERT INTO "PUBLIC"."API_HEADER_PARAM" VALUES
('29521180-a3ec-45e3-9843-fd26d228e6f6', 'dbf4a701-2676-454d-a142-706944e2ac42', '*/*', 'request accepts', TRUE, 'Accept', '69e3a4d8-952b-4aee-a5ef-1a9cdf7265bf', NULL);     
CREATE CACHED TABLE "PUBLIC"."FILE_EXPLORER"(
    "ID" VARCHAR(255) NOT NULL,
    "PID" VARCHAR(255) NOT NULL,
    "NAME" VARCHAR(255),
    "PARENT_ID" VARCHAR(255),
    "TYPE" VARCHAR(255),
    "PATH" VARCHAR(255)
);              
ALTER TABLE "PUBLIC"."FILE_EXPLORER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("ID", "PID");         
-- 22 +/- SELECT COUNT(*) FROM PUBLIC.FILE_EXPLORER;          
INSERT INTO "PUBLIC"."FILE_EXPLORER" VALUES
('FE_0000001', 'P_0000001', 'Home', NULL, '1', NULL),
('0ead2593-0ad0-4fd9-b9a4-d498433bb16c', 'P_0000001', 'Templates', 'FE_0000001', '1', '/Home/Templates'),
('e9b3b097-7b9d-4ac7-83f5-d989540d4958', 'P_0000001', 'Accounts', '0ead2593-0ad0-4fd9-b9a4-d498433bb16c', '1', '/Home/Templates/Accounts'),
('34237cf3-a967-41d0-a5ee-e28d21404055', 'P_0000001', 'Account Details', 'e9b3b097-7b9d-4ac7-83f5-d989540d4958', '2', '/Home/Templates/Accounts/Account Details.dt'),
('8d975c59-e2ea-43d2-819b-2ff303b3301d', 'P_0000001', 'APIs', 'FE_0000001', '1', '/Home/APIs'),
('d07f126c-d0da-4801-838b-def3628ae84b', 'P_0000001', 'PetStore', '8d975c59-e2ea-43d2-819b-2ff303b3301d', '4', '/Home/APIs/PetStore.spec'),
('e2993db4-6a54-478f-8d6c-0228f48c1cb0', 'P_0000001', 'Designs', 'FE_0000001', '1', '/Home/Designs'),
('dce1f643-4f43-4131-bb79-5ff4b43e3614', 'P_0000001', 'Details', 'e9b3b097-7b9d-4ac7-83f5-d989540d4958', '2', '/Home/Templates/Accounts/Details.dt'),
('339d079b-57b8-4155-8bbf-99f78bfc72fb', 'P_0000001', 'Summary', 'e9b3b097-7b9d-4ac7-83f5-d989540d4958', '2', '/Home/Templates/Accounts/Summary.dt'),
('9b4616cc-6e4f-4543-9679-573fe9d8763f', 'P_0000001', 'Account', '8d975c59-e2ea-43d2-819b-2ff303b3301d', '5', '/Home/APIs/Account.api'),
('fe64f5a8-a342-46ac-b1d7-62d4a193fbfe', 'P_0000001', 'Payments', 'e9b3b097-7b9d-4ac7-83f5-d989540d4958', '2', '/Home/Templates/Accounts/Payments.dt'),
('18f39bb7-1844-43bd-81a9-a7c55a1a575a', 'P_0000001', 'Orders', 'e9b3b097-7b9d-4ac7-83f5-d989540d4958', '2', '/Home/Templates/Accounts/Orders.dt'),
('f100c385-54b3-42bd-b2c4-4e2868416398', 'P_0000001', 'Invoices', 'e9b3b097-7b9d-4ac7-83f5-d989540d4958', '2', '/Home/Templates/Accounts/Invoices.dt'),
('8e0807ff-d11d-4e37-9657-4a227403603e', 'P_0000001', 'GRN', 'e9b3b097-7b9d-4ac7-83f5-d989540d4958', '2', '/Home/Templates/Accounts/GRN.dt'),
('840a40c1-c069-4e06-b9c2-e7a7c048bc45', 'P_0000001', 'GDN', 'e9b3b097-7b9d-4ac7-83f5-d989540d4958', '2', '/Home/Templates/Accounts/GDN.dt'),
('435e5aa8-a1ca-43e1-814d-f4ea0a8effb2', 'P_0000001', 'RWOS', 'FE_0000001', '1', '/Home/RWOS'),
('29e2bc14-6083-4408-9733-c79d4bee947b', 'P_0000001', 'Events', '435e5aa8-a1ca-43e1-814d-f4ea0a8effb2', '1', '/Home/RWOS/Events'),
('2c437167-9ddb-4ce6-a17e-420b2511d7f4', 'P_0000001', 'Response', '29e2bc14-6083-4408-9733-c79d4bee947b', '2', '/Home/RWOS/Events/Response.dt'),
('57df117e-7423-4c05-a6f6-452c08158cc2', 'P_0000001', 'Event', '29e2bc14-6083-4408-9733-c79d4bee947b', '2', '/Home/RWOS/Events/Event.dt'),
('e8a092f5-4e3e-44ad-9c66-a0aaef16c714', 'P_0000001', 'Customer Sale', '435e5aa8-a1ca-43e1-814d-f4ea0a8effb2', '1', '/Home/RWOS/Customer Sale'),
('fa453472-3bae-4cac-ba97-1a21c1ea4003', 'P_0000001', 'CustomerSale', 'e8a092f5-4e3e-44ad-9c66-a0aaef16c714', '2', '/Home/RWOS/Customer Sale/CustomerSale.dt'),
('FE_0000002', 'P_0000001', 'Admin', NULL, '6', '/Admin');         
CREATE CACHED TABLE "PUBLIC"."API_QUERY_PARAM"(
    "APIID" VARCHAR(255) NOT NULL,
    "PARAM_ID" VARCHAR(255) NOT NULL,
    "DESCRIPTION" VARCHAR(255),
    "MANDATORY" BOOLEAN NOT NULL,
    "PARAM_NAME" VARCHAR(255),
    "PARAM_TYPE" VARCHAR(255),
    "TEMPLATE" VARCHAR(255),
    "DEFAULTVALUE" VARCHAR(255)
);             
ALTER TABLE "PUBLIC"."API_QUERY_PARAM" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C4" PRIMARY KEY("APIID", "PARAM_ID");              
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.API_QUERY_PARAM;         
INSERT INTO "PUBLIC"."API_QUERY_PARAM" VALUES
('29521180-a3ec-45e3-9843-fd26d228e6f6', 'ed8f941c-4cdc-43b3-937f-fba9013a7b3f', 'projectId for verification', TRUE, 'projectId', '69e3a4d8-952b-4aee-a5ef-1a9cdf7265bf', NULL, 'F0001');      
CREATE CACHED TABLE "PUBLIC"."API_REQUEST_TEMPLATE"(
    "APIID" VARCHAR(255) NOT NULL,
    "REQUEST_ID" VARCHAR(255) NOT NULL,
    "ACTIVE" BOOLEAN NOT NULL,
    "DESCRIPTION" VARCHAR(255),
    "TEMPLATE_ID" VARCHAR(255),
    "TYPE" VARCHAR(255)
);              
ALTER TABLE "PUBLIC"."API_REQUEST_TEMPLATE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_99" PRIMARY KEY("APIID", "REQUEST_ID");       
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.API_REQUEST_TEMPLATE;    
INSERT INTO "PUBLIC"."API_REQUEST_TEMPLATE" VALUES
('29521180-a3ec-45e3-9843-fd26d228e6f6', 'efe0df05-c254-48b5-a048-ba14365ff6dc', TRUE, 'request template for JSON', '34237cf3-a967-41d0-a5ee-e28d21404055', 'JSON');      
CREATE CACHED TABLE "PUBLIC"."API_RESPONSE_TEMPLATE"(
    "APIID" VARCHAR(255) NOT NULL,
    "RESPONSE_ID" VARCHAR(255) NOT NULL,
    "ACTIVE" BOOLEAN NOT NULL,
    "DESCRIPTION" VARCHAR(255),
    "TEMPLATE_ID" VARCHAR(255),
    "TYPE" VARCHAR(255)
);            
ALTER TABLE "PUBLIC"."API_RESPONSE_TEMPLATE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7D" PRIMARY KEY("APIID", "RESPONSE_ID");     
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.API_RESPONSE_TEMPLATE;   
INSERT INTO "PUBLIC"."API_RESPONSE_TEMPLATE" VALUES
('29521180-a3ec-45e3-9843-fd26d228e6f6', 'add4fa41-2f5b-4e81-87ca-e46e6608a1f8', TRUE, 'response template for JSON', 'dce1f643-4f43-4131-bb79-5ff4b43e3614', 'JSON'),
('29521180-a3ec-45e3-9843-fd26d228e6f6', '66d534c9-8d17-4f8a-8874-631c38e9b492', TRUE, 'xml response template', '339d079b-57b8-4155-8bbf-99f78bfc72fb', 'XML');   
DROP TABLE IF EXISTS SYSTEM_LOB_STREAM;       
CALL SYSTEM_COMBINE_BLOB(-1); 
DROP ALIAS IF EXISTS SYSTEM_COMBINE_CLOB;     
DROP ALIAS IF EXISTS SYSTEM_COMBINE_BLOB;     
ALTER TABLE "PUBLIC"."TYPE_ELEMENT" ADD CONSTRAINT "PUBLIC"."UKM7YF2UKF53GSCBM1H54AAKLR9" UNIQUE("TYPE_ID", "NAMESPACE_ID", "SL_NO", "ELEMENT_NAME");         
ALTER TABLE "PUBLIC"."NAMESPACEREP" ADD CONSTRAINT "PUBLIC"."UKST7JQ43VJCHP292VM6O2PW0IJ" UNIQUE("NAMESPACE_URL");            
ALTER TABLE "PUBLIC"."TYPESREPO" ADD CONSTRAINT "PUBLIC"."UKETV23WNB4WFUGMY1IH3TUA02K" UNIQUE("NAMESPACE_ID", "TYPE_NAME");   
ALTER TABLE "PUBLIC"."FAVOURITE" ADD CONSTRAINT "PUBLIC"."FKI0F6YLK0EWQ8INUQOWQE39KRW" FOREIGN KEY("ITEMID", "PID") REFERENCES "PUBLIC"."FILE_EXPLORER"("ID", "PID") NOCHECK; 
ALTER TABLE "PUBLIC"."FILE_EXPLORER" ADD CONSTRAINT "PUBLIC"."FKQ4A9S0YYY74M8WAN2MY0ESSFN" FOREIGN KEY("PARENT_ID", "PID") REFERENCES "PUBLIC"."FILE_EXPLORER"("ID", "PID") NOCHECK;          
ALTER TABLE "PUBLIC"."FAVOURITE" ADD CONSTRAINT "PUBLIC"."FK4NNYDXDRA1X6Y9AAXYGL0AKHU" FOREIGN KEY("FILE_DETAILS_ID", "FILE_DETAILS_PID") REFERENCES "PUBLIC"."FILE_EXPLORER"("ID", "PID") NOCHECK;           
