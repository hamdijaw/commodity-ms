# commodity-ms
#api
Get: /msapi/CommodityManagementMs/v1/commodityList?customerId=123456789
Save: /msapi/CommodityManagementMs/v1/Commodity?
Delete: /msapi/CommodityManagementMs/v1/Commodity?

Get:
curl -X GET \
  'http://localhost:8080/msapi/CommodityManagementMs/v1/commodityList?customerId=22' \
  -H 'cache-control: no-cache'

Save:
curl -X POST \
  http://localhost:8080/msapi/CommodityManagementMs/v1/Commodity \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '[{"name":"commodity-3","customerId":2,"description":"third commodity","documentId":1,"createdBy":"user-1","createDate":"2018-04-09T17:06:57.986"}]'

Delete:
curl -X DELETE \
  http://localhost:8080/msapi/CommodityManagementMs/v1/Commodity \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '[{"id":3, "name":"commodity-9","customerId":2,"description":"third commodity","documentDetails":{"id":3},"createdBy":"user-2","createDate":"2018-04-09T17:06:57.986"}, {"id":4, "name":"commodity-9","customerId":2,"description":"third commodity","documentDetails":{"id":3},"createdBy":"user-2","createDate":"2018-04-09T17:06:57.986"}, {"id":5, "name":"commodity-9","customerId":2,"description":"third commodity","documentDetails":{"id":3},"createdBy":"user-2","createDate":"2018-04-09T17:06:57.986"}]'
