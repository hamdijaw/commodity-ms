Technology Stack:
1. Spring Boot 2.0.1
2. Spring MVC
3. Spring Data (uses Hibernate 5.2.16.Final)
4. Embedded Tomcat 8.5.29
5. H2 In-Memory Database - for dev env (web page - http://localhost:8080/h2-console, Driver: org.h2.Driver, jdbc url: jdbc:h2:mem:testdb, username=sa, password is not required)
6. MySQL Database 6.0.6 - for qa env
7. Maven 3.5.0

A) Prerequisites:
    I. To run
        1. Java 8
        2. Any Restful API testing Client(Postman/RestEasy)
        3. cURL is required for testing multipart/mixed type requests where a Binary File and JSON both can be sent
           If source code repository is Git then Git Bash would already be installed,
           so it can be used to issue cURL requests

    II. To develop/build
        1. JDK 8
        2. Maven (latest version should be fine)
        3. For development purpose Embedded H2 DB is used, so external database is not required.
            But for other environments MySQL needs to be installed and its connection details should be provided
            in application-qa.properties file in src/main/resources folder
        4. Any IDE (Eclipse/Intellij Idea/STS) - Not required for non-developers

B) How To?
    I. Build
        1. Navigate to the root directory of the source code
        2. Environment specific
            i. For Dev(Default) : mvn clean package
            ii. For QA : mvn clean package -Pqa

    II. Run
        1. Navigate to the root directory of the source code
        2.  Environment specific
            i. For Dev(Default) : java -jar target\commodity-ms-0.0.1-SNAPSHOT.jar --server.port=8081
            ii. For QA : java -jar target\commodity-ms-0.0.1-SNAPSHOT.jar --server.port=8081 --spring.profiles.active=qa

# commodity-ms
#api
1. Get: /msapi/CommodityManagementMs/v1/commodityList?customerId=123456789
2. Save: /msapi/CommodityManagementMs/v1/Commodity?
3. Delete: /msapi/CommodityManagementMs/v1/Commodity?

Get:
curl -X GET \
  'http://localhost:8080/msapi/CommodityManagementMs/v1/commodityList?customerId=1' \
  -H 'cache-control: no-cache'

Save without Document:
 curl -i -v -X POST http://localhost:8080/msapi/CommodityManagementMs/v1/Commodity -H "Content-Type: multipart/mixed" \
 -F "commodityList=[        {           \"customerId\": 1,            \"name\": \"commodity-7890\",            \"description\": \"third commodity\",            \"length\": 7,            \"width\": 5,            \"height\": 2,            \"weight\": 3,            \"stackable\": 0,            \"freightClassType\": {                \"id\": 1,                \"name\": \"density-1\",                \"density\": \"freight-class-1\"            },            \"freightPackagingType\": {                \"id\": 1,                \"name\": \"name\",                \"pluralName\": \"plural_name\"            },            \"nmfc\": \"nmfc\",            \"freightGoodsType\": {                \"id\": 1,                \"name\": \"freight_goods_type-name\",                \"sortOrder\": 1,                \"terms\": \"freight_goods_type-terms\"            },            \"value\": 2,            \"condition\": \"insurance_condition\",            \"oversized\": 1,            \"statedQuantity\": 12,            \"statedQuantityPackagingType\": {                \"id\": 1,                \"name\": \"name\",                \"pluralName\": \"plural_name\"            },            \"haz\": 0,            \"hazIdentificationNumber\": \"haz_identification_number\",            \"hazProperShippingName\": \"haz_proper_shipping_name\",            \"freightHazClassType\": {                \"id\": 1,                \"name\": \"name\"            },            \"freightHazPackagingGroupType\": {                \"id\": 1,                \"name\": \"name\",                \"code\": \"code\"            },            \"hazEmergencyContact\": \"haz_emergency_contact_name\",            \"hazEmergencyPhone\": \"haz_emergency_contact_phone\",            \"hazPlacardRequired\": 0,            \"hazPlacardDetails\": \"haz_placard_details\",            \"hazFlashpointTemperature\": \"haz_flashpoint_temperature\",            \"hazAdditionalDetails\": \"haz_additional_details\",            \"hazErr\": \"haz_err\",            \"createdBy\": \"user-2\",            \"createDate\": \"2018-04-09T17:06:58\",            \"addInsuranceReminder\": 0,            \"type\": \"type\"        }    ];type=application/json"


Save with Document + Document Image/File: What should be the max file size allowed?
curl -i -v -X POST http://localhost:8080/msapi/CommodityManagementMs/v1/Commodity -H "Content-Type: multipart/mixed" \
 -F "document=@E:\document.txt"  \
 -F "commodityList=[        {         \"customerId\": 1,            \"name\": \"commodity-2311\",            \"description\": \"third commodity\",            \"length\": 7,            \"width\": 5,            \"height\": 2,            \"weight\": 3,            \"stackable\": 0,            \"freightClassType\": {                \"id\": 1,                \"name\": \"density-1\",                \"density\": \"freight-class-1\"            },            \"freightPackagingType\": {                \"id\": 1,                \"name\": \"name\",                \"pluralName\": \"plural_name\"            },            \"nmfc\": \"nmfc\",            \"freightGoodsType\": {                \"id\": 1,                \"name\": \"freight_goods_type-name\",                \"sortOrder\": 1,                \"terms\": \"freight_goods_type-terms\"            },            \"value\": 2,            \"condition\": \"insurance_condition\",            \"oversized\": 1,            \"statedQuantity\": 12,            \"statedQuantityPackagingType\": {                \"id\": 1,                \"name\": \"name\",                \"pluralName\": \"plural_name\"            },            \"haz\": 0,            \"hazIdentificationNumber\": \"haz_identification_number\",            \"hazProperShippingName\": \"haz_proper_shipping_name\",            \"freightHazClassType\": {                \"id\": 1,                \"name\": \"name\"            },            \"freightHazPackagingGroupType\": {                \"id\": 1,                \"name\": \"name\",                \"code\": \"code\"            },            \"hazEmergencyContact\": \"haz_emergency_contact_name\",            \"hazEmergencyPhone\": \"haz_emergency_contact_phone\",            \"hazPlacardRequired\": 0,            \"hazPlacardDetails\": \"haz_placard_details\",            \"hazFlashpointTemperature\": \"haz_flashpoint_temperature\",            \"hazAdditionalDetails\": \"haz_additional_details\",            \"hazErr\": \"haz_err\",            \"documentDetails\": {                \"documentSource\": \"doc-source-1\",                \"documentType\": \"text-file\",                \"toBePrinted\": 1            },            \"createdBy\": \"user-2\",            \"createDate\": \"2018-04-09T17:06:58\",            \"addInsuranceReminder\": 0,            \"type\": \"type\"        }    ];type=application/json"


Delete:
curl -X DELETE \
  http://localhost:8080/msapi/CommodityManagementMs/v1/Commodity \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 487a9e05-f7d1-bc30-7238-bdef382a8c7d' \
  -d '[
        {
            "id": 2,
            "customerId": 1,
            "name": "commodity-7890",
            "description": "third commodity",
            "length": 7,
            "width": 5,
            "height": 2,
            "weight": 3,
            "stackable": 0,
            "freightClassType": {
                "id": 1,
                "name": "density-1",
                "density": "freight-class-1"
            },
            "freightPackagingType": {
                "id": 1,
                "name": "name",
                "pluralName": "plural_name"
            },
            "nmfc": "nmfc",
            "freightGoodsType": {
                "id": 1,
                "name": "freight_goods_type-name",
                "sortOrder": 1,
                "terms": "freight_goods_type-terms"
            },
            "value": 2,
            "condition": "insurance_condition",
            "oversized": 1,
            "statedQuantity": 12,
            "statedQuantityPackagingType": {
                "id": 1,
                "name": "name",
                "pluralName": "plural_name"
            },
            "haz": 0,
            "hazIdentificationNumber": "haz_identification_number",
            "hazProperShippingName": "haz_proper_shipping_name",
            "freightHazClassType": {
                "id": 1,
                "name": "name"
            },
            "freightHazPackagingGroupType": {
                "id": 1,
                "name": "name",
                "code": "code"
            },
            "hazEmergencyContact": "haz_emergency_contact_name",
            "hazEmergencyPhone": "haz_emergency_contact_phone",
            "hazPlacardRequired": 0,
            "hazPlacardDetails": "haz_placard_details",
            "hazFlashpointTemperature": "haz_flashpoint_temperature",
            "hazAdditionalDetails": "haz_additional_details",
            "hazErr": "haz_err",
            "createdBy": "user-2",
            "createDate": "2018-04-09T17:06:58",
            "addInsuranceReminder": 0,
            "type": "type"
        }
    ]'
