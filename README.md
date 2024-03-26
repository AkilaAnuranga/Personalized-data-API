Endpoints Docs
POST - /api/internal/products
request body - {
"productId": "MD-654613215",
"category": "Babies",
"brand": "Babyom"
}
Description - Insert Product metadata

POST - /api/internal/shopper/products
request body - {
"shopperId": "S-2000",
"shelf": [
{
"productId": "MB-2093193398",
"relevancyScore": 31.089209569320897
},
{
"productId": "BB-4653218",
"relevancyScore": 55.16626010671777
},
{
"productId": "MD-654613215",
"relevancyScore": 73.01492966268303
}
]
}
Description - Insert Shopper with Products

GET - /api/external/products
request params - shopperId (String, required)
Category - String, optional
Brand - String, optional
Limit - Integer, optional, default = 10, max = 100
